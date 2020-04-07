package com.newer.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.dao.GradeDao;
import com.newer.dao.StudentDao;
import com.newer.dao.SubjectDao;
import com.newer.domain.Grade;
import com.newer.domain.Student;
import com.newer.domain.Subject;
import com.newer.dto.PageDto;
import com.newer.service.GradeService;
import com.newer.service.StudentService;

@Service
public class GradeServiceImpl implements GradeService{

	@Autowired
	GradeDao dao;
	
	public List<Grade> findAll() {
		List<Grade> list=dao.findAll();
		return list;
	}

	@Override
	public void addGrade(Grade grade) {
		this.dao.insert(grade);
	}

}
