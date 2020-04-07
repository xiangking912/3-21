package com.newer.service;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.newer.domain.Student;
import com.newer.dto.PageDto;

public interface StudentService {
	public PageInfo<Student> findStuAll(PageDto dto);
	public void Update(Student stu);
	public void DeleteById(int id);
	public void Insert(Student stu);
	public Student findStuById(int id);
	
	public boolean updatePwd(Student stu);
}
