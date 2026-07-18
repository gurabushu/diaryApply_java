package com.example.demo.form;

import jakarta.validation.constraints.NotBlank;

public class DiaryForm {

	@NotBlank(message = "タイトルを入力してください")
	private String title;

	@NotBlank(message = "本文を入力してください")
	private String body;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}