package com.study.a01.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Board {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id; // PK

	    private String title; // 제목

	    private String content; // 내용

	    private String writer; // 작성자

	    private int hits; // 조회 수

	    private char deleteYn; // 삭제 여부

	    private LocalDateTime createDate = LocalDateTime.now(); // 생성일

	    private LocalDateTime modifiedDate; // 수정일
	    
	    @Builder
	    public Board(String title, String content, String writer, int hits, char deleteYn) {
	        this.title = title;
	        this.content = content;
	        this.writer = writer;
	        this.hits = hits;
	        this.deleteYn = deleteYn;
	    } 
		
	    public Board toEntity() {
	    	return Board.builder()
	    			.title(title)
	    			.content(content)
	    			.writer(writer)
	    			.hits(hits)
	    			.deleteYn(deleteYn)
	    			.build();
	    }
		
	
}
