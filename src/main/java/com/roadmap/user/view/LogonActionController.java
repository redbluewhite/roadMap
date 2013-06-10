package com.roadmap.user.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.roadmap.domain.User;
import com.roadmap.user.UserService;


@Controller
@RequestMapping("/logonAction.do")
public class LogonActionController {
	
	///Field
	@Inject
	@Named("userServiceImpl")
	private UserService userService;
	
	public void setUserService(UserService userService) {
		System.out.println("LogonActionController �� UserService DI ��.....");
		this.userService = userService;
	}	
	

	@ModelAttribute("referenceDataMap")
	protected Map<String, String> referenceData01 () throws Exception {
		System.out.println("���� 01 : [LogonActionController. referenceData01() call ]");
		Map<String, String> info =  new HashMap<String, String>();
		info.put("message01", "Map �ν��Ͻ��� ���� return �� data�� ....");
		info.put("message02", "request ObjectScope�� ����Ǿ� View���� ó����.");
		return info;
	}

	@ModelAttribute("referenceDataList")
	protected List<String> referenceData() throws Exception {
		System.out.println("���� 02 : [LogonActionController. referenceData02()  call ]");
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("List �ν��Ͻ��� ���� return �� data�� ....");
		arrayList.add("request ObjectScope�� ����Ǿ� View���� ó����.");
		return arrayList;
	}
	
	///Constructor
	public LogonActionController(){
		System.out.println(":: LogonActionController default Contructor call");
	}
	

	@RequestMapping(method = RequestMethod.GET)
	public String formView(){
		return "/logonView.do";
	}


	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView logonAction	(	@ModelAttribute("user") User user,
																			HttpSession session	) throws Exception{

		System.out.println("[ LogonActionController start........]");//<== ������
		
		String viewName = this.formView();
		
		session.setAttribute("user",user);
		System.out.println(":: command Ȯ�� "+ user);
		
		//==> CONTROLLER :: Business logic ó��
		User dbUser = userService.getUser(user.getUserNo());
		System.out.println("::=====> UserService ���� ���� dbUser:: "+ dbUser);
		if( dbUser != null){
		
			if( user.getUserEmail().equals(dbUser.getUserEmail()) 
					&& user.getPassword().equals(dbUser.getPassword()) ) {
				user.setActive(true);
			}
	  

			if( user.isActive() ){
				viewName = "/homeView.do";
			}
			System.out.println("[ action : "+viewName+ "]");		
			System.out.println("[ LogonActionController end........]\n");
		}
		

		String message = null;
		if( viewName.equals("/homeView.do"))
			message = "[LogonActionController] WELCOME";
		else
			message = "[LogonActionController] ���̵�,�н����� 3���̻� �Է��ϼ���.";
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName);
		modelAndView.addObject("message", message);
		
		return modelAndView;
		//return new ModelAndView(viewName,"message",message);
	}
}