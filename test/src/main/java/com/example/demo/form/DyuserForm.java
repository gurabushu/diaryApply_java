package com.example.demo.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;


@Data
public class DyuserForm {
	
	@NotBlank(message = "ユーザー名を入力してください。")
	@Size (max = 20, message = "ユーザー名は２０文字以内で入力してください。")
	private String name;
	
	@NotBlank(message = "メールアドレスを入力してください。")
    @Email(message = "正しいメールアドレスを入力してください。")
    @Size(max = 100, message = "メールアドレスは100文字以内で入力してください。")
    private String email;

    @NotBlank(message = "パスワードを入力してください。")
    @Size(min = 8, max = 20, message = "パスワードは8文字以上20文字以内で入力してください。")
    private String password;
    
    
    
}