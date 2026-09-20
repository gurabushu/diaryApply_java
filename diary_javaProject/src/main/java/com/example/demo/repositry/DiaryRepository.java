package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Diary;

public interface DiaryRepository
        extends JpaRepository<Diary, Long> {

}