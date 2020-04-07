package com.newer.service;

import com.github.pagehelper.PageInfo;
import com.newer.domain.Subject;
import com.newer.dto.PageDto;

public interface SubjectService {
	public PageInfo findAll(PageDto dto);
	public Subject findSubById(int id);
}
