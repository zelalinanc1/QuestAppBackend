package com.project.questapp.requests;

import lombok.Data;

@Data
public class RefreshRequest {

	int userId;
	String refreshToken;
}
