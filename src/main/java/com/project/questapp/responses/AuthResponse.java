package com.project.questapp.responses;

import lombok.Data;

@Data
public class AuthResponse {
	
	String message;
	int userId;
	String accessToken;
	String refreshToken;

}
