package controller;

import common.Pager;
import domain.AcademyDomain;
import domain.AdminDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.AcademyService;
import service.AdminService;
import service.CourseService;
import service.MajorService;
import service.StudentService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/students")
public class AcademyController {
	@Autowired
	private AcademyService service;
	@Autowired
	private CourseService courseService;
	@Autowired 
	private MajorService majorService;
	
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public MajorService getMajorService() {
		return majorService;
	}
	public void setMajorService(MajorService majorService) {
		this.majorService = majorService;
	}
	public AcademyService getService() {
		return service;
	}
	public void setService(AcademyService service) {
		this.service = service;
	}
	
	//显示所有学院信息
	@RequestMapping("/showAllAcademy.do")
	public ModelAndView findAllAcademy( Integer page,Integer perPage,HttpServletRequest request){
		ModelAndView mv=new ModelAndView();
		HttpSession session = request.getSession();
		String error = (String) session.getAttribute("error");
		request.setAttribute("error", error);
		mv.setViewName("showAllAcademy");
		session.removeAttribute("error");
		Pager<AcademyDomain> list=service.findAllAcademy(page,perPage);
		mv.addObject("Pager",list);
		return mv;
	}
	//删除学院
	@RequestMapping("/delAcademy.do")
	public ModelAndView delAcademy(Integer id,HttpServletRequest req){
		HttpSession session = req.getSession();
		String error = "";
		if (majorService.findByAId(id)) {
			error= "该学院下有专业，不能删除该学院！！！";
			session.setAttribute("error", error);
		}else {
			if (courseService.findByAId(id)) {
				error= "该学院下有课程，不能删除该学院！！！";
				session.setAttribute("error", error);
			}else {
				service.delAcademy(id);
			}
		}
		return new ModelAndView("redirect:/students/showAllAcademy.do");
	}
	//添加预处理
	@RequestMapping("/preAddAcademy.do")
	public ModelAndView preAddAcademy(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("addAcademy");
		return mv;
	}
	
	//添加学院
	@RequestMapping("/addAcademy.do")
	public ModelAndView addAcademy(AcademyDomain domain){
		service.addAcademy(domain);
		return new ModelAndView("redirect:/students/showAllAcademy.do");
	}
	//修改学院
	@RequestMapping("/modifyAcademy.do")
	public ModelAndView modifyAcademy(Integer id,AcademyDomain domain){
		service.modifyAcademy(id, domain);
		return new ModelAndView("redirect:/students/showAllAcademy.do");
	}
	
}
