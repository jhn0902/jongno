package com.home.service.board;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.home.domain.board.BoardDto;
import com.home.domain.board.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

  private BoardRepository repository;

  public List<BoardDto> selectBoardList() {
    List<BoardDto> datas = new ArrayList<BoardDto>();

    try {

      datas = repository.findAll();

    } catch (Exception e) {
      System.out.println("jpa error .");
    }

    return datas;
  }
}
