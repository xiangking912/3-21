package com.newer.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.dao.SubjectDao;
import com.newer.domain.Student;
import com.newer.domain.Subject;
import com.newer.dto.PageDto;
import com.newer.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectDao dao;
	
	@Override
	public PageInfo findAll(PageDto dto) {
		PageHelper.startPage(dto.getPage(),dto.getPageSize());
		List<Subject> list=dao.selectAll();
		PageInfo<Subject> pageInfo = new PageInfo<Subject>(list); 
		return pageInfo;
	}

	@Override
	public Subject findSubById(int id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

}
