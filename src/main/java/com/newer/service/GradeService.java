package com.newer.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.newer.domain.Grade;
import com.newer.dto.PageDto;

public interface GradeService {
	public List<Grade> findAll();
	public void addGrade(Grade grade);
}
