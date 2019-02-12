package controller;

import domain.AcademyDomain;
import domain.CourseDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.AcademyService;
import service.CourseService;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/students")
public class CourseController {
	@Autowired
	private CourseService service;
	@Autowired
	private AcademyService aService;
	
	public AcademyService getaService() {
		return aService;
	}

	public void setaService(AcademyService aService) {
		this.aService = aService;
	}

	public CourseService getService() {
		return service;
	}

	public void setService(CourseService service) {
		this.service = service;
	}
	
	@RequestMapping("/showAllCourse.do")
	public ModelAndView showAllCourse(){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("showAllCourse");
		List<CourseDomain> list=service.findAllCourse();
		mv.addObject("list",list);
		return mv;
	}
	//添加课程预处理
	@RequestMapping("/preAddCourse.do")
	public ModelAndView preAdd(){
		ModelAndView mv=new ModelAndView();
		List<AcademyDomain> list=aService.findAllAcademy1();
		mv.addObject("list",list);
		mv.setViewName("addcourse");
		return mv;
	}
	//
	@RequestMapping("/addCourse.do")
	public ModelAndView addCourse(CourseDomain domain,HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8" );
		response.setCharacterEncoding("UTF-8");
		service.addCourse(domain);
		return new ModelAndView("redirect:/students/showAllCourse.do");
	}
	@RequestMapping("/delCourse.do")
	public ModelAndView delCourse(Integer id){
		service.delCourse(id);
		return new ModelAndView("redirect:/students/showAllCourse.do");
	}
	
	@RequestMapping("/preModifyCourse.do")
	public ModelAndView preModifyCourse(Integer id) throws Exception{
		ModelAndView mv=new ModelAndView();
		List<AcademyDomain> alist=aService.findAllAcademy1();
		CourseDomain courseDomain = service.findById(id);
		mv.addObject("courseDomain", courseDomain);
		mv.addObject("alist",alist);
		mv.setViewName("modifyCourse");
		return mv;
	}
	
	@RequestMapping("/modifyCourse.do")
	public ModelAndView modifyCourse(Integer id,CourseDomain domain,HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		service.modifyCourse(id, domain);
		return new ModelAndView("redirect:/students/showAllCourse.do");
	}
}
