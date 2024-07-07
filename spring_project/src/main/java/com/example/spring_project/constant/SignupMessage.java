package com.example.spring_project.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SignupMessage {

    SUCCEED(MessageConst.SIGNUP_RESIST_SUCCEED, false),

	EXISTED_EMAIL(MessageConst.SIGNUP_EXISTED_EMAIL, true);


	private String messageId;

	private boolean isError;
    
}
