package com.study.a01.domain.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.study.a01.domain.Board;
import com.study.a01.repository.BoardRepository;


@SpringBootTest
public class BoardTest {

	@Autowired
	BoardRepository boardRepository;
	
	@Autowired(required = true)
	private RestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	@Test
	public void printOut() {
		System.out.println("test!!");
	}
	
	public void boardInsert () {

		// 게시글 파라매터 생성
				Board params = Board.builder()
						.title("1번 게시글 제목")
						.content("1번 게시글 내용")
						.writer("JJH")
						.hits(0)
						.deleteYn('N')
						.build();
				
			String url = "http://localhost:" + port + "/restApi/insert/board" ;
		
			ResponseEntity<Long> reponseEntity = restTemplate.postForEntity(url, params, Long.class);

			assertThat(reponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(reponseEntity.getBody()).isGreaterThan(0L);
			
			List<Board> all = boardRepository.findAll();
			assertThat(all.get(0).getTitle()).isEqualTo("1번 게시글 제목");
			
	}
	
	
	void save() {
		
		// 게시글 파라매터 생성
		Board params = Board.builder()
				.title("1번 게시글 제목")
				.content("1번 게시글 내용")
				.writer("JJH")
				.hits(0)
				.deleteYn('N')
				.build();
		
		// 파라매터 저장
		boardRepository.save(params);
		
		// 1번 게시글 정보 조회
		Board entity = boardRepository.findById((long) 3).get();
		assertThat(entity.getTitle()).isEqualTo("1번 게시글 제목");
		assertThat(entity.getContent()).isEqualTo("1번 게시글 내용");
		assertThat(entity.getWriter()).isEqualTo("JJH");
	}
	
	void findAll() {
		long boardsCount = boardRepository.count();
		List<Board> boards = boardRepository.findAll();
	}
	
	void delete() {
		Board entity = boardRepository.findById((long) 2).get();
		
		boardRepository.delete(entity);
	}
	
	
	
}
