package com.example.spring_project.authentication;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.spring_project.entity.UserInfo;
import com.example.spring_project.repository.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

    private final UserInfoRepository userInfoRepository;

    @Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException(email));


        // return User.withUsername(userInfo.getEmail())
        //             .password(userInfo.getPassword())
        //             .roles("USER")
        //             .build();

        UserDetails userDetails = User.withUsername(userInfo.getEmail())
                                      .password(userInfo.getPassword())
                                      .roles("USER")
                                      .build();

        return new UserDetailsImpl(userInfo,userDetails);
    }
    
    
}
