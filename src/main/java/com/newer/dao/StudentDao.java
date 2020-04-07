package com.newer.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import com.newer.domain.Student;

import tk.mybatis.mapper.common.Mapper;

public interface StudentDao extends Mapper<Student> {
	
	@Select("select * from student where sno=#{id}")
	public Student findStuById(int id);
}
