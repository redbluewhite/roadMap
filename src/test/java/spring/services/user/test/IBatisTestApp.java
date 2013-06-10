package spring.services.user.test;

import com.roadmap.domain.User;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.roadmap.user.UserDao;
import com.roadmap.user.UserService;

public class IBatisTestApp {
	///Main method
	public static void main(String[] args) throws Exception{

		ApplicationContext context =
			new ClassPathXmlApplicationContext(
														new String[] {	"/config/userservice.xml"	 }
								                                                    );
	UserService userService = (UserService)context.getBean("userServiceImpl");
	
	User user = new User("user01", "류현진", "1234");
	User user2 = new User("user02", "박찬호", "1234");
	User user3 = new User("user03", "박지성", "1234");

	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	System.out.println(":: 1. add(INSERT)  ? ");
	userService.addUser(user);
	userService.addUser(user2);
	userService.addUser(user3);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	user = userService.getUser("user01");
	user2 = userService.getUser("user02");
	user3 = userService.getUser("user03");
	System.out.println(":: 2. get(SELECT)  ? "+user);
	System.out.println(":: 2. get(SELECT)  ? "+user2);
	System.out.println(":: 2. get(SELECT)  ? "+user3);
	
//	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
//	user.setUserName("류현진");
//	System.out.println(":: 3. update(UPDATE)  ? ");
//	userService.updateUser(user);
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	user = userService.getUser("user01");
	System.out.println(":: 4. get(SELECT)  ? "+user);

	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	UserDao userDAO = (UserDao)context.getBean("iBatisUserDaoImpl");
	System.out.println(":: 5. remove(DELETE)  ? "+userDAO.removeUser("user02"));
	
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	System.out.println(":: 6. all User(SELECT)  ? ");
	List<User> list = userService.getUserList(new User());
	for (int i =0 ;  i < list.size() ; i++) {
		System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
		System.out.println( list.get(i).toString() );
	}
	System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		
	}//end of main
}//end of class