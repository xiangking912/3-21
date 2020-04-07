package com.newer.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.dao.StudentDao;
import com.newer.domain.Student;
import com.newer.dto.PageDto;
import com.newer.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao dao;
	
	@Override
	public PageInfo<Student> findStuAll(PageDto dto) {
		PageHelper.startPage(dto.getPage(),dto.getPageSize());
		List<Student> list=dao.selectAll();
		PageInfo<Student> pageInfo = new PageInfo<Student>(list); 
		return pageInfo;
	}

	@Override
	public void Update(Student stu) {
		dao.updateByPrimaryKey(stu);
	}

	@Override
	public void DeleteById(int id) {
		// TODO Auto-generated method stub
		dao.deleteByPrimaryKey(id);
	}

	@Override
	public void Insert(Student stu) {
		dao.insert(stu);
	}

	@Override
	public Student findStuById(int id) {
		// TODO Auto-generated method stub
		return dao.selectByPrimaryKey(id);
	}

}
