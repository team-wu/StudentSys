package controller;

import common.Pager;
import domain.MajorDomain;
import domain.StudentDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.MajorService;
import service.StudentService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * MVC -->　Model + View + Controller
 * ModelAndView 封装业务数据以及逻辑视图名
 * Bean对象  --> 作用域  （ singleton prototype）
 */
@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired // 自动注入 ( byName byType)
	private StudentService service;
	@Autowired
	private MajorService majorservice;

	public MajorService getMajorservice() {
		return majorservice;
	}

	public void setMajorservice(MajorService majorservice) {
		this.majorservice = majorservice;
	}

	public StudentService getService() {
		return service;
	}

	public void setService(StudentService service) {
		this.service = service;
	}

	// 添加学生预处理
	@RequestMapping("/preAdd.do")
	public ModelAndView preAddStudent() {
		List<MajorDomain> list = null;
		list = majorservice.findAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("addstudent");
		return mv;
	}

	@RequestMapping("/create.do")
	public ModelAndView createStudent(StudentDomain domain, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		service.addStudent(domain);
		return new ModelAndView("redirect:/students/findForPager.do");
	}

	// 显示所有
	@RequestMapping("/findForPager.do")
	// page, perPage 数据绑定
	// 获取参数
	public ModelAndView findForPager(@RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer perPage) {

		ModelAndView mv = new ModelAndView();
		Pager<StudentDomain> pager = service.findForPager(page, perPage);
		mv.setViewName("showAll");
		mv.addObject("pager", pager);
		return mv;
	}

	// 删除
	@RequestMapping("/delStudents.do")
	public ModelAndView delStuent(String id) {
		service.DelStudent(id);
		return new ModelAndView("redirect:/students/findForPager.do");
	}

	// 修改
	@RequestMapping("/preModifyStudents.do")
	public ModelAndView preModifyStudent(Integer id) throws Exception {
		List<MajorDomain> list = null;
		list = majorservice.findAll();
		ModelAndView mv = new ModelAndView();
		StudentDomain studentDomain = service.findById(id);
		mv.addObject("mojorList", list);
		mv.addObject("student", studentDomain);
		mv.setViewName("modifystudent");
		return mv;
	}

	// 修改
	@RequestMapping("/modifyStudents.do")
	public ModelAndView modifyStudent(Integer id, StudentDomain stu, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		service.Modify(id, stu);
		return new ModelAndView("redirect:/students/findForPager.do");
	}

	// 按姓名查找
	@RequestMapping("/findByName.do")
	public ModelAndView findByName(String name, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ModelAndView mv = new ModelAndView();
		Pager<StudentDomain> list = service.findByName(name);
		mv.setViewName("showAll");
		mv.addObject("pager", list);
		return mv;
	}

}
