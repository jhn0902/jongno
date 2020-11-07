package com.home.controller.board;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.home.service.board.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardRestController {

  @Autowired
  private BoardService service;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ResponseEntity<Map<String, Object>> selectMemberList() {
    Map<String, Object> result = new LinkedHashMap<String, Object>();
    result.put("datas", service.selectBoardList());
    return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
