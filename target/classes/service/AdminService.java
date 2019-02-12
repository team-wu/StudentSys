package service;

import dao.AdminDao;
import domain.AdminDomain;
import entity.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
	@Autowired
	private AdminDao dao;

	public AdminDao getDao() {
		return dao;
	}

	public void setDao(AdminDao dao) {
		this.dao = dao;
	}
	private AdminDomain copyEntityToDomain(AdminEntity ae){
		AdminDomain ad=new AdminDomain();
		ad.setId(ae.getId());
		ad.setName(ae.getName());
		ad.setPassword(ae.getPassword());
		return ad;
	}
	private AdminEntity copyDomainToEntity(AdminDomain ad){
		AdminEntity ae=new AdminEntity();
		ae.setId(ad.getId());
		ae.setName(ad.getName());
		ae.setPassword(ad.getPassword());
		return ae;
	}
	
	//遍历管理员
	public List<AdminDomain> findAll(){
		List<AdminEntity> entities=dao.findAll();
		List<AdminDomain> domains=new ArrayList<AdminDomain>();
		for(AdminEntity ae:entities){
			domains.add(this.copyEntityToDomain(ae));
		}
		return domains;
	}
	//通过ID查找管理员
	public AdminDomain findById(Integer id){
		return this.copyEntityToDomain(dao.findById(id));
	}

}
