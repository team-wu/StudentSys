package controller;

import domain.AcademyDomain;
import domain.MajorDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.AcademyService;
import service.MajorService;
import service.StudentService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/students")
public class MajorController {
	@Autowired
	private MajorService service;
	@Autowired
	private AcademyService aService;
	@Autowired
	private StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public AcademyService getaService() {
		return aService;
	}

	public void setaService(AcademyService aService) {
		this.aService = aService;
	}

	public MajorService getService() {
		return service;
	}

	public void setService(MajorService service) {
		this.service = service;
	}
	//显示所有
	@RequestMapping("/showAllMajor.do")
	public ModelAndView findAll(HttpServletRequest request){
		HttpSession session = request.getSession();
		ModelAndView mv=new ModelAndView();
		String error = (String) session.getAttribute("error");
		request.setAttribute("error", error);
		mv.setViewName("showAllMajor");
		session.removeAttribute("error");
		List<MajorDomain> list=service.findAll();
		mv.addObject("list",list);
		return mv;
	}
	
	
	//添加预处理
	@RequestMapping("/preAddMajor.do")
	public ModelAndView preAdd(){
		ModelAndView mv=new ModelAndView();
		List<AcademyDomain> majorList=aService.findAllAcademy1();
		mv.addObject("majorList",majorList);
		mv.setViewName("addMajor");
		return mv;
	}
	
	//添加专业
	@RequestMapping("/addMajor.do")
	public ModelAndView addMajor(MajorDomain domain,HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8" );
		response.setCharacterEncoding("UTF-8");
		service.addMajor(domain);	
		return new ModelAndView("redirect:/students/showAllMajor.do");
	}
	//删除
	@RequestMapping("/delMajor.do")
	public ModelAndView delMajor(Integer id,HttpServletRequest req){
		HttpSession session = req.getSession();
		String error = "";
		if (studentService.findByMajorId(id)) {
			error= "该专业类别下有学生，不能删除该专业！！！";
			session.setAttribute("error", error);
		}else {
			service.delMajor(id);
			
		}
		return new ModelAndView("redirect:/students/showAllMajor.do");
	}
	
	//修改
		@RequestMapping("/preModifyMajor.do")
		public ModelAndView preModifyMajor(Integer id ){
			ModelAndView mv=new ModelAndView();
			List<AcademyDomain> academList=aService.findAllAcademy1();
			MajorDomain majorDomain = service.findById(id);
			mv.addObject("majorDomain",majorDomain);
			mv.addObject("majorList",academList);
			mv.setViewName("modifyMajor");
			return mv;
		}
	
	//修改
	@RequestMapping("/modifyMajor.do")
	public ModelAndView modifyMajor(Integer id ,MajorDomain domain,HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8" );
		response.setCharacterEncoding("UTF-8");
		service.modifyMajor(id, domain);
		return new ModelAndView("redirect:/students/showAllMajor.do");
	}
	
}
