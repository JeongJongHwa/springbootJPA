package com.study.a01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.a01.domain.Board;
import com.study.a01.repository.BoardRepository;

@Service

public class BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	@Transactional
	public Long save(Board board) {
		
		return boardRepository.save(board.toEntity()).getId();
	}
	
	public Board findById(Long id) throws Exception {
		Board entity = boardRepository.findById(id).orElseThrow(()->new Exception("no user ! id="+id) );
		return entity;
	}
	
	
}
