package com.home.controller.board;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.home.domain.board.BoardDto;
import com.home.service.board.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardRestController {

  @Autowired
  private BoardService service;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ResponseEntity<Map<String, Object>> selectBoardrList() {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    result.put("datas", service.selectBoardList());
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @RequestMapping(value = "/get/{idx}", method = RequestMethod.GET)
  public ResponseEntity<Map<String, Object>> selectBoardr(@PathVariable("idx") Long idx) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    result.put("datas", service.selectBoard(idx));
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @RequestMapping(value = "/post", method = RequestMethod.POST)
  public ResponseEntity<Map<String, Object>> insertBoard(@RequestBody BoardDto board) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    service.insertBoard(board);
    result.put("result", 1);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @RequestMapping(value = "/put", method = RequestMethod.PUT)
  public ResponseEntity<Map<String, Object>> updateBoard(@RequestBody BoardDto board) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    service.updateBoard(board);
    result.put("result", 1);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @RequestMapping(value = "/delete/{idx}", method = RequestMethod.DELETE)
  public ResponseEntity<Map<String, Object>> deleteBoard(@PathVariable("idx") Long idx) {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    service.deleteBoard(idx);
    result.put("result", 1);
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
