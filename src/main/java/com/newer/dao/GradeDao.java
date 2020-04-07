package com.newer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import com.newer.domain.Grade;

import tk.mybatis.mapper.common.Mapper;

public interface GradeDao extends Mapper<Grade>{
		
	@Results({
		@Result(column = "stuid",property = "stu",
			many =@Many(select ="com.newer.dao.StudentDao.findStuById")
		),
		@Result(column = "subid",property = "sub",
			many =@Many(select ="com.newer.dao.SubjectDao.findSubById") 
		),
	})
	@Select("select * from grade")
	public List<Grade> findAll();
}
