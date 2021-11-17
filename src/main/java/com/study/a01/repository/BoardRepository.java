package com.study.a01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.a01.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
