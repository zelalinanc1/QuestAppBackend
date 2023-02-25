package com.project.questapp.requests;

import lombok.Data;

@Data
public class PostCreateRequest {

	private int id;
	private String text;
	private String title;
	private int userId;
}
