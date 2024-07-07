package com.example.spring_project.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring_project.entity.UserInfo;
import com.example.spring_project.form.SignupForm;
import com.example.spring_project.repository.UserInfoRepository;
import com.github.dozermapper.core.Mapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserInfoRepository userInfoRepository;

	/** Dozer Mapper */
	private final Mapper mapper;

	/** PasswordEncoder */
	private final PasswordEncoder passwordEncoder;


	public String getTime(){
		TimeZone jp = TimeZone.getTimeZone("Asia/Tokyo");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setTimeZone(jp);
		return sdf.format(new Date());
	}


    public Optional<UserInfo> resistUserInfo(SignupForm form) {
		Optional<UserInfo> userInfoExistedOpt = userInfoRepository.findByEmail(form.getEmail());
		if (userInfoExistedOpt.isPresent()) {
			return Optional.empty();
		}

		// TimeZone jp = TimeZone.getTimeZone("Asia/Tokyo");
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		// sdf.setTimeZone(jp);
		// String createdat = sdf.format(new Date());

		UserInfo userInfo = mapper.map(form, UserInfo.class);
		String encodedPassword = passwordEncoder.encode(form.getPassword());

		userInfo.setPassword(encodedPassword);
		userInfo.setCreatedAt(getTime());

		return Optional.of(userInfoRepository.save(userInfo));
	}
	
}
