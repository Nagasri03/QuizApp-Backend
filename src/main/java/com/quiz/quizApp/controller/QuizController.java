package com.quiz.quizApp.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.quiz.quizApp.service.QuestionService;
import com.quiz.quizApp.service.UserService;

@CrossOrigin(origins={"*"})
@RestController
@RequestMapping("/api")
public class QuizController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("create/user")
	public ResponseEntity<String> createUser(@RequestBody Map<String, String> user) throws NoSuchAlgorithmException{
		return userService.createUser(user);
	}
	
	@PostMapping("login/user")
	public ResponseEntity<String> loginUser(@RequestBody Map<String, String> user) throws NoSuchAlgorithmException{
		return userService.loginUser(user);
	}
	
	@PostMapping("upload")
	public ResponseEntity<String> uploadQuestions(@RequestParam("questions") MultipartFile questions ){
		return questionService.uploadQuestionFile(questions);
	}
	
	@GetMapping("get/question")
	public ResponseEntity<Map<String,Object>> getQuestions(@RequestParam("questionId") Long QuestionId){
		return questionService.getQuestion(QuestionId);
	}
}
