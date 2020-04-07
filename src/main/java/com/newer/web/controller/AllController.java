package com.newer.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.domain.Grade;
import com.newer.domain.Student;
import com.newer.domain.Subject;
import com.newer.dto.PageDto;
import com.newer.service.GradeService;
import com.newer.service.StudentService;
import com.newer.service.SubjectService;

@RestController
@CrossOrigin
@RequestMapping("all")
@ResponseBody
public class AllController {
	
	@Autowired
	private StudentService stuService;
	
	@Autowired
	private SubjectService subService;
	
	@Autowired
	private GradeService gradeService;
	
	
	@RequestMapping("stuFindAll")
	public PageInfo<Student> stuFindAll(PageDto dto){
		return this.stuService.findStuAll(dto);
	}
	
	@RequestMapping("subFindAll")
	public PageInfo<Subject> subFindAll(PageDto dto){
		return this.subService.findAll(dto);
	}
	
	@RequestMapping("gradeFindAll")
	public PageInfo<Grade> gradeFindAll(PageDto dto){
		PageHelper.startPage(dto.getPage(),dto.getPageSize());
		PageInfo pageInfo=new PageInfo<Grade>(gradeService.findAll());
		return pageInfo;
	}
	
	@RequestMapping("addGrade")
	public boolean addGrade(Grade grade) {
		this.gradeService.addGrade(grade);
		System.out.println(grade);
		return false;
	}
	
	@RequestMapping("upload")
	public String upload(MultipartFile file,HttpSession session) throws Exception, IOException {
		String path="/upload/";
		if(file!=null && !"".equals(file.getOriginalFilename())) {
			String oldName=file.getOriginalFilename();
			String ext=oldName.substring(oldName.lastIndexOf("."));
			String newName=UUID.randomUUID()+ext;
			String realpath= session.getServletContext().getRealPath("upload")+"/"+newName;
			file.transferTo(new File(realpath));
			return path+newName;
		}
		return null;
	}
	
	@RequestMapping("addStu")
	public boolean addStu(Student stu) {
		this.stuService.Insert(stu);
		return false;
	}

	@RequestMapping("update")
	public boolean update(Student stu) {
		this.stuService.Update(stu);
		return false;
	}
	
	@RequestMapping("delete")
	public boolean delete(int sno) {
		this.stuService.DeleteById(sno);
		return false;
	}
	
	@RequestMapping("deleteFile")
	public boolean deleteFile(String f,HttpSession session) {
		String path=session.getServletContext().getRealPath("upload");
		File file=new File(path+f.substring(7));
		if(file.isFile()==true) {
			file.delete();
		}
		return false;
	}
}
