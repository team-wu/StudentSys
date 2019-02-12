package service;

import common.Pager;
import dao.StudentDao;
import domain.MajorDomain;
import domain.StudentDomain;
import entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
	@Autowired
	private StudentDao dao;
	@Autowired
	private MajorService majorService;
	
	/**
	 * 分页查询
	 */
	public Pager<StudentDomain> findForPager(Integer page, Integer perPage){
		if(page == null){
			page = 1;
		}
		if(perPage == null){
			perPage = 5;
		}		
		Pager<StudentDomain> pager = new Pager<StudentDomain>();
		pager.setPage(page);
		pager.setPerPage(perPage);		
		List<StudentDomain> domains = new ArrayList<StudentDomain>();
		List<StudentEntity> entities = dao.findAll(page,perPage);
		for( StudentEntity en : entities )
		{		
			StudentDomain sd = this.copyEntityToDomain(en);
			MajorDomain md = majorService.findById(en.getMajorId());
			if(new Integer(1).equals(sd.getGender())){
				sd.setGenderName("男");
			}
			if(new Integer(2).equals(sd.getGender())){
				sd.setGenderName("女");
			}
			sd.setMajorName(md.getName());
			domains.add(sd);
		}	
		pager.setPageItems(domains);		
		Integer rc = dao.findAllCount();//表的所有记录数
		pager.setPageCount((int)Math.ceil(( (double)rc/ (double)perPage)));
		return pager;
	}
	
	
	private StudentDomain copyEntityToDomain(StudentEntity entity){
		StudentDomain domain = new StudentDomain();
		domain.setBirthday(entity.getBirthday());
		domain.setDescription(entity.getDescription());
		domain.setEmail(entity.getEmail());
		domain.setGender(entity.getGender());
		domain.setId(entity.getId());
		domain.setMajorId(entity.getMajorId());
		domain.setName(entity.getName());
		domain.setSchoolTerm(entity.getSchoolTerm());
		domain.setSchoolYear(entity.getSchoolYear());
		domain.setTellphone(entity.getTellphone());
		domain.setMajorName(entity.getMajorName());
		return domain;
	}
	private StudentEntity copyDomainToEntity(StudentDomain domain){
		StudentEntity entity=new StudentEntity();
		entity.setBirthday(domain.getBirthday());
		entity.setDescription(domain.getDescription());
		entity.setEmail(domain.getEmail());
		entity.setGender(domain.getGender());
		entity.setId(domain.getId());
		entity.setName(domain.getName());
		entity.setSchoolTerm(domain.getSchoolTerm());
		entity.setSchoolYear(domain.getSchoolYear());
		entity.setTellphone(domain.getTellphone());
		entity.setMajorId(domain.getMajorId());
		return entity;
	}
		
	//  根据姓名模糊查询学生
	public Pager<StudentDomain> findByName(String name){
		Pager<StudentDomain> pager=new Pager<StudentDomain>();
		List<StudentEntity> entities=dao.findByName(name);
		List<StudentDomain> domains=new ArrayList<StudentDomain>();
		for(StudentEntity en : entities){
			domains.add(this.copyEntityToDomain(en));
		}
		pager.setPageItems(domains);
		return pager;
	}	
	
	//根据ID查询学生
	public StudentDomain findById(Integer id){
		return this.copyEntityToDomain(dao.findById(id));		
	}	
	
	//根据ID查询学生
	public boolean findByMajorId(Integer id){
		return dao.findBymajorId(id);		
	}	

	
	//增加学生
	public void addStudent(StudentDomain stu){	
		StudentEntity stuEntity=new StudentEntity();
		stuEntity.setId(stu.getId());
		stuEntity.setName(stu.getName());
		stuEntity.setGender(stu.getGender());
		stuEntity.setBirthday(stu.getBirthday());
		stuEntity.setDescription(stu.getDescription());
		stuEntity.setEmail(stu.getEmail());
		stuEntity.setSchoolTerm(stu.getSchoolTerm());
		stuEntity.setTellphone(stu.getTellphone());
		stuEntity.setSchoolYear(stu.getSchoolTerm());			
		stuEntity.setMajorId(stu.getMajorId());
		
		dao.addStudent(stuEntity);
		
	}
	//删除学生
	public void DelStudent(String id){
		dao.Delstudent(id);		
	}
	//修改学生
	public void Modify(Integer id,StudentDomain domain){
		dao.Modify(id,this.copyDomainToEntity(domain));
	}

	public StudentDao getDao() {
		return dao;
	}
	public void setDao(StudentDao dao) {
		this.dao = dao;
	}
	
	
	
}
