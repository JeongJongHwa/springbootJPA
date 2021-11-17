package com.study.a01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.a01.domain.Board;
import com.study.a01.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	@PutMapping("/restApi/insert/board/{id}")
	public Long save(@RequestBody Board board ) {
		return boardService.save(board);
	}
	
	@GetMapping("/restApi/select/board/{id}")
	public Board findById( @PathVariable Long id ) throws Exception {
		return boardService.findById(id);
	}
	
	
}
