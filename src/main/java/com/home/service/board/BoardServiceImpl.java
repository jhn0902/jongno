package com.home.service.board;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.home.domain.board.BoardDto;
import com.home.domain.board.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  private BoardRepository repository;

  public List<BoardDto> selectBoardList() {
    List<BoardDto> datas = repository.findAll();
    return datas;
  }

  @Override
  public BoardDto selectBoard(Long idx) {
    Optional<BoardDto> data = repository.findById(idx);
    return data.get();
  }

  @Override
  public void insertBoard(BoardDto board) {
    repository.save(board);
    
  }

  @Override
  public void updateBoard(BoardDto board) {
    BoardDto data = repository.findById(board.getIdx()).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
    data.update(board.getSubject(), board.getContent());
    repository.save(data);
  }

  @Override
  public void deleteBoard(Long idx) {
    repository.deleteById(idx);
  }
}
