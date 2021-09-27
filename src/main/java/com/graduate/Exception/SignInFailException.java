package com.graduate.Exception;

public class SignInFailException extends RuntimeException {
	public SignInFailException(String message) {
		super(message);
	}
}
