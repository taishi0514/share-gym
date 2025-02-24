package com.example.spring_project.controller;

import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.spring_project.constant.UrlConst;
import com.example.spring_project.entity.UserInfo;
import com.example.spring_project.form.LoginForm;
import com.example.spring_project.form.SignupForm;
import com.example.spring_project.service.SignupService;
import com.example.spring_project.util.AppUtil;
import com.example.spring_project.constant.MessageConst;
import com.example.spring_project.constant.SignupMessage;

import lombok.RequiredArgsConstructor;

/**
 * ユーザー登録画面Controllerクラス
 * 
 * @author taishi
 *
 */
@Controller
@RequiredArgsConstructor
public class SignupController {

	/** ユーザー登録画面Serviceクラス */
	private final SignupService service;

	/** メッセージソース */
	private final MessageSource messageSource;

	@GetMapping(UrlConst.SIGNUP)
	public String view(Model model, SignupForm form) {
		return "signup";
	}

	/**
	*会員登録または、エラー表示を行う
	*
	* @param model モデル
	* @param form 入力値
	* @param bdResult エラー有無
	* @return 表示画面
	*/
	@PostMapping(UrlConst.SIGNUP)
	public String signup(Model model, @Validated SignupForm form, BindingResult bdResult) {
		if (bdResult.hasErrors()) {
			editGuideMessage(model, MessageConst.FORM_ERROR, true);
		}

		Optional<UserInfo> userInfoOpt = service.resistUserInfo(form);
		SignupMessage signupMessage = judgeMessageKey(userInfoOpt);
		editGuideMessage(model, signupMessage.getMessageId(), signupMessage.isError());

		if (signupMessage.isError()) {
			return "signup"; // ユーザー登録に失敗した場合、再度サインアップページを表示
		}
			model.addAttribute("loginForm", new LoginForm());
			return "login"; // 成功した場合、ログインページにリダイレクト
	}

	/**
	 * 画面に表示するガイドメッセージを設定する
	 * 
	 * @param model モデル
	 * @param messageId メッセージID
	 * @param isError エラー有無
	 */
	private void editGuideMessage(Model model, String messageId, boolean isError) {
		String message = AppUtil.getMessage(messageSource, messageId);
		model.addAttribute("message", message);
		model.addAttribute("isError", isError);
	}
		
	/**
	 * ユーザ情報登録の結果メッセージキーを判断する
	 * 
	 * @param userInfoOpt ユーザ登録結果(登録済みだった場合はEmpty)
	 * @return メッセージキー
	 */
	private SignupMessage judgeMessageKey(Optional<UserInfo> userInfoOpt) {
		if (userInfoOpt.isEmpty()) {
			return SignupMessage.EXISTED_EMAIL;
		} else {
			return SignupMessage.SUCCEED;
		}
	}
}