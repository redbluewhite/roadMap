package com.roadmap.user.view;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * FileName : LogonController.java
 * - 1EA 의 Control Bean 사용 여러 Request 처리 :: @RequestMapping
 * - @RequestMapping  선언된 Method 의 다양한 사용법 
*/
@Controller
public class LogonController {
	///Field
	///Constructor
	public LogonController(){
		System.out.println(":: LogonController default Contructor call");
	}
	
	@RequestMapping("/logonView.do")
	public ModelAndView logonView(){
		//ModelAndView 객체를 Return 
		return new ModelAndView("/logon/logon.jsp");
	}
	
	@RequestMapping("/homeView.do")
	public String homeView(){
		//viewName 를 갖는 String Return 
		return "/logon/home.jsp";
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session){
	//public ModelAndView logout(HttpServletRequest request){
		//:: 사용하려 하는 객체가 존재한다면..
		//:: Method 에 인자로 선언하면, 필요 객체를 전달 받아 사용 할 수 있다.
		System.out.println("[ LogoutController start........]");//<== 디버깅용

		session.removeAttribute("user");
		//request.getSession().removeAttribute("user");

		System.out.println("[ LogoutController end........]\n");
		
		//==> Client 에 전달할  Message 생성 
		String message = "[LogoutController] 아이디,패스워드 3자이상 입력하세요.";

		return new ModelAndView("/logonView.do","message",message);
	}
	
	@RequestMapping("/test01.do")
	public ModelAndView test01( @RequestParam("abc") int no,
															@RequestParam("def") String name) {
		System.out.println("[ test01.do start........]");//<== 디버깅용
		System.out.println("no : "+ no +"===  name : "+name);
		return new ModelAndView("/logon/logon.jsp");
	}
	
	@RequestMapping("/test02.do")
	public ModelAndView test02( @RequestParam(value="abc") int no,
															@RequestParam(value="def", required= false) String name) {
		System.out.println("[ test02.do start........]");//<== 디버깅용
		System.out.println("no : "+ no +"===  name : "+name);
		return new ModelAndView("/logon/logon.jsp");
	}
	
	@RequestMapping("/test03.do")
	public ModelAndView test03(	@RequestParam(value="abc",defaultValue="1") int no,
															@RequestParam(value="def", required= false) String name) {
		System.out.println("[ test03.do start........]");//<== 디버깅용
		System.out.println("no : "+ no +"===  name : "+name);
		return new ModelAndView("/logon/logon.jsp");
	}
}//end of class