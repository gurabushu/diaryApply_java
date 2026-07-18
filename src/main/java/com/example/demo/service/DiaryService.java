
package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Diary;
import com.example.demo.repositry.DiaryRepository;

@Service
public class DiaryService {

	@Autowired
	private DiaryRepository repository;

	public void create(String title, String body) {

		Diary diary = new Diary();

		diary.setTitle(title);
		diary.setBody(body);
		diary.setCreatedAt(LocalDateTime.now());

		repository.save(diary);
	}

	public List<Diary> findAll() {
		return repository.findAll();
	}

	public Diary findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("日記が見つかりません: " + id));
	}

	public void update(Long id, String title, String body) {
		Diary diary = findById(id);
		diary.setTitle(title);
		diary.setBody(body);
		repository.save(diary);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	

		}