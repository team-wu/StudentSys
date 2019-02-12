package service;

import common.PageCount;
import common.Pager;
import dao.AcademyDao;
import domain.AcademyDomain;
import domain.AdminDomain;
import entity.AcademyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcademyService {
	@Autowired
	private AcademyDao dao;
	@Autowired
	private AdminService aService;
	public AdminService getaService() {
		return aService;
	}
	public void setaService(AdminService aService) {
		this.aService = aService;
	}
	public AcademyDao getDao() {
		return dao;
	}
	public void setDao(AcademyDao dao) {
		this.dao = dao;
	}
	private PageCount pageCount=new PageCount();
		//添加学院
		public void addAcademy(AcademyDomain domain){
			dao.addAcademy(this.copyDomainToEntity(domain));
		}
		private AcademyDomain copyEntityToDomain(AcademyEntity ac){
			AcademyDomain domain =new AcademyDomain();
			domain.setId(ac.getId());
			domain.setName(ac.getName());
			domain.setAdminId(ac.getAdminId());
			return domain;
		}
		private AcademyEntity copyDomainToEntity(AcademyDomain domain){
			AcademyEntity entity=new AcademyEntity();
			entity.setId(domain.getId());
			entity.setName(domain.getName());
			entity.setAdminId(domain.getAdminId());
			return entity;
			
		}
		
		//删除学院
		public void delAcademy(Integer id){
			dao.delAcademy(id);
		}
		//修改学院信息
		public void modifyAcademy(Integer id, AcademyDomain domain){
			dao.modifyAcademy(id, this.copyDomainToEntity(domain));
		}
		
		//分页显示所有记录
		public Pager<AcademyDomain> findAllAcademy(Integer page, Integer perPage){
			if(page==null){
				page=1;
			}
			if(perPage==null){
				perPage=4;
			}
			//创建分页封装对象
			Pager<AcademyDomain> pager=new Pager<AcademyDomain>();
			List<AcademyDomain> domains=new ArrayList<AcademyDomain>();
			List<AcademyEntity> entities=dao.findAllAcademy(page,perPage);
			//确定分页大小
			pager.setPage(page);
			pager.setPerPage(perPage);
			//查询总记录
			Integer rc= pageCount.findAllCount("Academy");
			Integer pc=(int)Math.ceil( (double)rc/ (double)perPage );
			//
			pager.setPageCount(pc);
			//
			for(AcademyEntity en :entities){
				AdminDomain ad=aService.findById(en.getAdminId());
				AcademyDomain acd=this.copyEntityToDomain(en);
				acd.setAdminName(ad.getName());
				domains.add(acd);
			}
			pager.setPageItems(domains);
			return pager;
		}
		//所有记录
		public List<AcademyDomain> findAllAcademy1(){
			List<AcademyDomain> domains=new ArrayList<AcademyDomain>();
			List<AcademyEntity> entities=dao.findAllAcademy1();
			for(AcademyEntity en:entities){
				domains.add(this.copyEntityToDomain(en));
			}
			return domains;
		}
		
		
		//按照ID查询学院
		public AcademyDomain findById(Integer id){
			return this.copyEntityToDomain(dao.findById(id));
		}
}
