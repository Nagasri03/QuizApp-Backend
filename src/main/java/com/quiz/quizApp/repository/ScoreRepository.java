package com.quiz.quizApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.quizApp.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {

}
