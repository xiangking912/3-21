package com.newer.dao;

import org.apache.ibatis.annotations.Select;

import com.newer.domain.Subject;

import tk.mybatis.mapper.common.Mapper;

public interface SubjectDao extends Mapper<Subject>{
	
	@Select("select * from subject where id=#{id}")
	public Subject findSubById(int id);
}
