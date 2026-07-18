package com.example.demo.controller;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable; // ← 追加
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.InquireForm;
import com.example.demo.Form.DiaryForm;
import com.example.demo.service.DiaryService;

@Controller
public class DiaryController {

	@Autowired
	private DiaryService diaryService;

	@GetMapping("/")
	public String getList(Model model) {
		model.addAttribute("diaryForm", new DiaryForm());
		return "about";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("diaryForm", new DiaryForm());
		return "about";
	}

	@PostMapping("/inquire")
	public String inquire(
			@Valid @ModelAttribute("inquireForm") InquireForm inquireForm,
			BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "about";
		}

		diaryService.create(
				inquireForm.getEmail(),
				inquireForm.getName());

		return "redirect:/diary";
	}

	@GetMapping("/diary")
	public String diary(Model model) {
		model.addAttribute("diaries", diaryService.findAll());
		return "diary";
	}

	@PostMapping("/diary")
	public String createDiary(@ModelAttribute DiaryForm diaryForm) {
		diaryService.create(
				diaryForm.getTitle(),
				diaryForm.getBody());
		return "redirect:/diary";
	}
	
	// 新規投稿
	@GetMapping("/diary/new")
	public String newDiary(Model model) {
		model.addAttribute("diaryForm", new DiaryForm());
		return "new";
	}

	// 編集フォーム表示
	@GetMapping("/diary/{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("diary", diaryService.findById(id));
		return "edit";
	}

	// 更新実行
	@PostMapping("/diary/{id}/update")
	public String update(@PathVariable Long id,
			@ModelAttribute DiaryForm diaryForm) {
		diaryService.update(
				id,
				diaryForm.getTitle(),
				diaryForm.getBody());
		return "redirect:/diary";
	}

	// 削除実行
	@PostMapping("/diary/{id}/delete")
	public String delete(@PathVariable Long id) {
		diaryService.delete(id);
		return "redirect:/diary";
	}
}