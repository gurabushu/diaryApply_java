package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Diary;
import com.example.demo.service.DiaryService;

@Controller
public class DiaryController {
	@Autowired
	private DiaryService diaryService;
	
	@GetMapping({"/","top","top.html"})
	public String top(Model model) {
		List<Diary>diaries = diaryService.findAll();
		model.addAttribute("title", "日記");
		model.addAttribute("diaries", diaries);
		
		return "top";
	}
	
	@GetMapping("about")
	public String about(Model model) {
		List<Diary>diaries = diaryService.findAll();
		model.addAttribute("title", "このサイトについて");
		model.addAttribute("diaries", diaries);
		
		return "about";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		List<Diary> diaries = diaryService.findAll();
		
		model.addAttribute("diaries", diaries);
		System.out.println("取得件数："+ diaries.size());
		
		return "list";
		
	}
	
	@PostMapping("/new")
	public String createDiary(
			@RequestParam("title")String title,
			@RequestParam("body")String body) {
		
		Diary diary = new Diary();
		
		diary.setTitle(title);
		diary.setBody(body);
	
	diaryService.save(diary);
	
	return "redirect:/list";
	
}
	
	
	
	
	
	
}