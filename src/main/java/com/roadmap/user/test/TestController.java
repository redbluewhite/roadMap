package com.roadmap.user.test;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.roadmap.domain.User;


/*
 *  FileName : TestController.java
 *  - 1EA 의 controller 이용 request 처리
 */
@Controller
public class TestController {
	///Field
	///Constructor
	public TestController(){
		System.out.println("==> TestController default Constructor call.............");
	}
	
	/*
	 * :: Controller Method 파라미터는 아래의 DataType, 갯수를 다양하게 할 수 있다.
	 * 		- HttpServletRequest / HttpServletResponse
	 * 		- java.util.Locale / InputStream / Reader / OutputStream / Writer
	 * 		- Map / Model / ModelMap
	 * 
	 * :: Controller Method return 아래의 DataType, 다양하게 할 수 있다.
	 * 		- ModelAndView / View / String ... 
	 */
	
	// 00 : 단순 Navigation :: ParameterizableViewController 와 비교이해
	@RequestMapping("/testPage.do")
	public String testPage(){
		System.out.println(":: ==> testPage() start....");
		return "/test/testPage.jsp";
	}
	
	// 01 : method parameter ::Servlet API :: HttpServletRequest  
	//         return type : String
	@RequestMapping("/testController01.do")
	public String testController01(HttpServletRequest request){
		
		System.out.println(":: ==> testController01() start....");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		request.setAttribute("userId", userId);
		HttpSession session = request.getSession(true);
		session.setAttribute("password", password);
		
		//return "redirect:/test/testView.jsp";
		return "/test/testView.jsp";
	}
	
	// 02 : Servlet API :: HttpServletRequest , HttpSession 
	//			return type : ModelAndView
	@RequestMapping("/testController02.do")
	public ModelAndView testController02(	HttpServletRequest request,
																				HttpSession session){
		
		System.out.println(":: ==> testController02() start....");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		request.setAttribute("userId", userId);
		session.setAttribute("password", password);
		
		return new ModelAndView("/test/testView.jsp");
	}
	
	// 03 : Servlet API :: HttpSession 
	//			return type : ModelAndView
	//			@ModelAttribute 사용 :: Client FormData =>Command Object Binding 
	//													:: request ObjectScope 저장됨
	@RequestMapping("/testController03.do")
	public ModelAndView testController03(	@ModelAttribute("user") User user,
																				HttpSession session){
		
		System.out.println(":: ==> testController03() start....");
		
		int userNo = user.getUserNo();
		String password = user.getPassword();
		
		session.setAttribute("userNo", userNo);
		
		return new ModelAndView("/test/testView.jsp");
	}
	
	// 04 : 	return type : ModelAndView
	//			@ModelAttribute 사용 :: Client FormData =>Command Object Binding 
	//													:: request ObjectScope 저장됨
	@RequestMapping("/testController04.do")
	public ModelAndView testController04 (	@ModelAttribute("user") User user){
		
		System.out.println(":: ==> testController04() start....");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/test/testView.jsp");
		modelAndView.addObject("message", "~~~~");
		
		return modelAndView;
	}
	
		// 05 : 	return type : String
		//			@RequestParam / Map  사용 :: request ObjectScope 저장됨
		@RequestMapping("/testController05.do")
		public String testController05 (	@RequestParam("userNo") int userNo,
																	@RequestParam("password") String password,
																	Map map){
			
			System.out.println(":: ==> testController05() start....");
			
			User user = new User();
			user.setUserNo(userNo);
			user.setPassword(password);
			map.put("user",user);
			map.put("userNo", userNo);
			map.put("password",password);
			map.put("message", "~~~~");
			
			return "/test/testView.jsp";
		}
		
		// 06 : 	return type : String
		//			@RequestParam / Model  사용 :: request ObjectScope 저장됨
		@RequestMapping("/testController06.do")
		public String testController06 (	@RequestParam("userNo") int userNo,
																	@RequestParam("password") String password,
																	Model model){
			
			System.out.println(":: ==> testController06() start....");
			
			User user = new User();
			user.setUserNo(userNo);
			user.setPassword(password);
			model.addAttribute("user",user);
			model.addAttribute("userNo", userNo);
			model.addAttribute("password",password);
			model.addAttribute("message", "~~~~");
			
			return "/test/testView.jsp";
		}
}