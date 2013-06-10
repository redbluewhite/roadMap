package com.roadmap.user.view;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/*
 * FileName : LogonController.java
 * - 1EA �� Control Bean ��� ���� Request ó�� :: @RequestMapping
 * - @RequestMapping  ����� Method �� �پ��� ���� 
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
		//ModelAndView ��ü�� Return 
		return new ModelAndView("/logon/logon.jsp");
	}
	
	@RequestMapping("/homeView.do")
	public String homeView(){
		//viewName �� ���� String Return 
		return "/logon/home.jsp";
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpSession session){
	//public ModelAndView logout(HttpServletRequest request){
		//:: ����Ϸ� �ϴ� ��ü�� �����Ѵٸ�..
		//:: Method �� ���ڷ� �����ϸ�, �ʿ� ��ü�� ���� �޾� ��� �� �� �ִ�.
		System.out.println("[ LogoutController start........]");//<== ������

		session.removeAttribute("user");
		//request.getSession().removeAttribute("user");

		System.out.println("[ LogoutController end........]\n");
		
		//==> Client �� ������  Message ���� 
		String message = "[LogoutController] ���̵�,�н����� 3���̻� �Է��ϼ���.";

		return new ModelAndView("/logonView.do","message",message);
	}
	
	@RequestMapping("/test01.do")
	public ModelAndView test01( @RequestParam("abc") int no,
															@RequestParam("def") String name) {
		System.out.println("[ test01.do start........]");//<== ������
		System.out.println("no : "+ no +"===  name : "+name);
		return new ModelAndView("/logon/logon.jsp");
	}
	
	@RequestMapping("/test02.do")
	public ModelAndView test02( @RequestParam(value="abc") int no,
															@RequestParam(value="def", required= false) String name) {
		System.out.println("[ test02.do start........]");//<== ������
		System.out.println("no : "+ no +"===  name : "+name);
		return new ModelAndView("/logon/logon.jsp");
	}
	
	@RequestMapping("/test03.do")
	public ModelAndView test03(	@RequestParam(value="abc",defaultValue="1") int no,
															@RequestParam(value="def", required= false) String name) {
		System.out.println("[ test03.do start........]");//<== ������
		System.out.println("no : "+ no +"===  name : "+name);
		return new ModelAndView("/logon/logon.jsp");
	}
}//end of class