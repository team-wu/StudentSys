package service;

import dao.MajorDao;
import domain.AcademyDomain;
import domain.MajorDomain;
import entity.MajorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MajorService {	
	@Autowired //自动注入
	private MajorDao dao;
	@Autowired
	private AcademyService academyService;
	
	public MajorDao getDao() {
		return dao;
	}
	
	public void setDao(MajorDao dao) {
		this.dao = dao;
	}
	
	
	private MajorDomain copyEntityToDomain(MajorEntity ma){
		MajorDomain majorDomain=new MajorDomain();
		majorDomain.setId(ma.getId());
		majorDomain.setName(ma.getName());
		majorDomain.setDesc(ma.getDesc());
		majorDomain.setAcademyId(ma.getAcademyId());
		return majorDomain;
	}
	private MajorEntity copyDomainToEntity(MajorDomain domain){
		MajorEntity entity=new MajorEntity();
		//entity.setId(domain.getId());
		entity.setAcademyId(domain.getAcademyId());
		entity.setName(domain.getName());
		entity.setDesc(domain.getDesc());
		return entity;
	}
	
	//查询所有专业
	public List<MajorDomain> findAll(){
		List<MajorEntity> majorEntities=dao.findAll();
		List<MajorDomain> domain=new ArrayList<MajorDomain>();
		for(MajorEntity en : majorEntities){
			MajorDomain md=this.copyEntityToDomain(en);
			AcademyDomain ac=academyService.findById(md.getAcademyId());
			md.setAcademyName(ac.getName());
			domain.add(md);
		}
		return domain;
	}

	// 根据ID查询学生
	public boolean findByAId(Integer id) {
		return dao.findByAId(id);
	}
	
	//增加专业
	public void addMajor(MajorDomain ma){
		dao.addMajor(this.copyDomainToEntity(ma));			
	}
	//删除专业		
	public void delMajor(Integer id){
		dao.delMajor(id);
	}

	public MajorDomain findById(Integer id) {
		return this.copyEntityToDomain(dao.findById(id));
	}
	
	//修改专业
	public void modifyMajor(Integer id, MajorDomain domain){
		dao.modifyMajor(id, this.copyDomainToEntity(domain));
	}
	
		
		
}
