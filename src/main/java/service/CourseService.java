package service;

import dao.CourseDao;
import domain.AcademyDomain;
import domain.CourseDomain;
import entity.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
	@Autowired
	private CourseDao dao;
	@Autowired
	private AcademyService academyService;
	// private AcademyService academyService=new AcademyService();

	public CourseDao getDao() {
		return dao;
	}

	public void setDao(CourseDao dao) {
		this.dao = dao;
	}

	// 查询所有课程
	public List<CourseDomain> findAllCourse() {
		List<CourseEntity> entities = dao.findAllCourse();
		List<CourseDomain> domains = new ArrayList<CourseDomain>();
		for (CourseEntity cou : entities) {
			CourseDomain cd = this.copyEntityToDomain(cou);
			AcademyDomain ac = academyService.findById(cou.getAcademyId());
			cd.setAcademyName(ac.getName());
			if (cd.getType() == 1) {
				cd.setTypeName("必修");
			}
			if (cd.getType() == 2) {
				cd.setTypeName("选修");
			}
			domains.add(cd);
		}
		return domains;
	}

	private CourseDomain copyEntityToDomain(CourseEntity cou) {
		CourseDomain domain = new CourseDomain();
		domain.setId(cou.getId());
		domain.setName(cou.getName());
		domain.setCredit(cou.getCredit());
		domain.setDesc(cou.getDesc());
		domain.setTime(cou.getTime());
		domain.setType(cou.getType());
		domain.setAcademyId(cou.getAcademyId());
		return domain;
	}

	private CourseEntity copyDomainToEntity(CourseDomain domain) {
		CourseEntity entity = new CourseEntity();
		entity.setCredit(domain.getCredit());
		entity.setDesc(domain.getDesc());
		// entity.setId(domain.getId());
		entity.setName(domain.getName());
		entity.setType(domain.getType());
		entity.setTime(domain.getTime());
		entity.setAcademyId(domain.getAcademyId());
		return entity;
	}

	// 删除课程
	public void delCourse(Integer id) {
		dao.delCourse(id);
	}

	// 根据ID查询学生
	public boolean findByAId(Integer id) {
		return dao.findByAId(id);
	}

	// 修改课程
	public void modifyCourse(Integer id, CourseDomain domain) {
		dao.modifyCourse(id, this.copyDomainToEntity(domain));
	}

	// 增加课程
	public void addCourse(CourseDomain domain) {
		dao.addcourse(this.copyDomainToEntity(domain));
	}

	// 按照ID查询课程
	public CourseDomain findById(Integer id) {
		return this.copyEntityToDomain(dao.findById(id));
	}

}
