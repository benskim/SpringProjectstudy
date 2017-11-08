package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
/*
 *   interface => class => total
 *   
 *   interface I
 *   class A implements I
 *   class B implements I
 */
@Service
public class DataBoardService {
    @Autowired
    private DataBaordDAO dao;
    public List<BoardVO> databoardAllData(int page)
    {
    	return dao.boardAllData(page);
    }
    public void databoardInsert(BoardVO vo)
    {
    	dao.boardInsert(vo);
    }
    public int databoardTotalpage()
    {
    	return dao.boardTotal();
    }
    public BoardVO databoardContent(int no){
    	return dao.boardContent(no);
    }
}
