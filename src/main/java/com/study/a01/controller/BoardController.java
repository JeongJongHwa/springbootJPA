package com.study.a01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.study.a01.domain.Board;
import com.study.a01.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("/")
	public String startStr() {
		return "Hello!";
	}
	
	@GetMapping("/restApi/select/board/{id}")
	public Board findById( @PathVariable long id ) throws Exception {
		return boardService.findById(id);
	}
	
	
}
