package com.sist.dao;
import java.util.*;
/*
 *   MultiPart
 *   Transaction <AOP>
 *   Trigger <ORM>
 *   Security <AOP>
 *   WebSocket = NodeJS <front> react.js
 */
public interface DataBoard {
   public List<BoardVO> boardAllData(int page);
   public void boardInsert(BoardVO vo);
   public int boardTotal();
   public BoardVO boardContent(int no);
}
