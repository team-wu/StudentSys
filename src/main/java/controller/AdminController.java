package controller;

import domain.AdminDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.AdminService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/students")
public class AdminController {

	@Autowired
	private AdminService service;


	public AdminService getService() {
		return service;
	}

	public void setService(AdminService service) {
		this.service = service;
	}

	// 判断登录
	@RequestMapping("/login.do")
	public ModelAndView doLogin(AdminDomain ae, HttpServletRequest req) {
		HttpSession session = req.getSession();
		List<AdminDomain> list = service.findAll();
		ModelAndView mv = new ModelAndView();
		for (AdminDomain ad : list) {
			if (ae.getName().equals(ad.getName()) && ae.getPassword().equals(ad.getPassword())) {
				mv.addObject("ae", ae);
				session.setAttribute("user", ae);
				mv.setViewName("Main");
				return mv;
			}
		}
		mv.setViewName("loginFailure");
		return mv;

	}
}
