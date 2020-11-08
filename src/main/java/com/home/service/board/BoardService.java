package com.home.service.board;

import java.util.List;
import com.home.domain.board.BoardDto;

public interface BoardService {

  List<BoardDto> selectBoardList();
  BoardDto selectBoard(Long idx);
  void insertBoard(BoardDto board);
  void updateBoard(BoardDto board);
  void deleteBoard(Long idx);
}
