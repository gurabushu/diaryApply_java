package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.form.DyuserForm;
import com.example.demo.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userservice;

	//TOPページ表示
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	//ログイン画面遷移
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	//ログアウト後画面遷移
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}

	//新規登録画面
	@GetMapping("/create")
	public String newUser(Model model) {
		model.addAttribute("dyuserForm", new DyuserForm());
		return "create";
	}

	//新規登録
	@PostMapping("/create")
	public String createUser(
			@Valid DyuserForm form,
			BindingResult result,
			Model model) {
		//バリデーションエラーメッセージの表示
		if (result.hasErrors()) {
			return "create";
		}
		//登録成功
		boolean createSuccess = userservice.create(
				form.getName(),
				form.getEmail(),
				form.getPassword());
		//メールアドレスが重複している。
		if (!createSuccess) {
			model.addAttribute(
					"error",
					"このメールアドレスはすでに登録されています。");
			return "index";
		}
		//登録成功
		return "redirect:/index";

	}

	//ログイン
	@PostMapping("/login")
	public String loginUser(
			@RequestParam String email,
			@RequestParam String password,
			Model model) {

		boolean loginSuccess = userservice.login(email, password);

		if (loginSuccess) {
			return "redirect:/top";
		}

		model.addAttribute(
				"error",
				"メールアドレスまたはパスワードが違います。");

		return "login";
	}

}