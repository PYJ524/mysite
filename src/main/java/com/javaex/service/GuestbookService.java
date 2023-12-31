package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getList(){
		System.out.println("GuestbookService.getList");
		
		List<GuestbookVo> guestbookList = guestbookDao.getList();
		
		return guestbookList;
		
	}
	
	public void insert(GuestbookVo vo) {
		System.out.println("GusetbookService.insert()");
		guestbookDao.insert(vo);
	}
	
	public int delete(GuestbookVo vo) {
		return guestbookDao.delete(vo);
	}
	
	
	// ajax 방명록 등록때 사용
	public GuestbookVo addGuest(GuestbookVo guestbookVo) {
		System.out.println("GusetbookService.addGuest()");
		guestbookDao.insertSelectKey(guestbookVo);
		return guestbookDao.selectGuest(guestbookVo.getNo());
	}
}
