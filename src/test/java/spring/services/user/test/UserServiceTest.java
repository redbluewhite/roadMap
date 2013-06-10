package spring.services.user.test;

import com.roadmap.domain.User;
import com.roadmap.user.UserDao;
import com.roadmap.user.UserService;

import javax.inject.Inject;
import javax.inject.Named;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:/config/userservice.xml" })
public class UserServiceTest {


	@Inject
	@Named("userServiceImpl")
	private UserService userService;
	
	@Inject
	@Named("iBatisUserDaoImpl")
	private UserDao userDAO;

	@Test
	public void testAddUser() throws Exception {

		User user = new User("user05", "주몽", "1234");
		userService.addUser(user);
		
		Assert.assertEquals(1, userDAO.removeUser(user.getUserEmail()));

	}
	
	@Test
	public void testGetUser() throws Exception {
		
		User user = userService.getUser("user05");

		Assert.assertEquals("user05",user.getUserEmail());
		Assert.assertNotNull(userService.getUser("user05"));

	}

	 //@Test
	 public void testGetUserList() throws Exception{

	 }


	 //@Test
	 public void testUpdateUser() throws Exception{

	 }
}