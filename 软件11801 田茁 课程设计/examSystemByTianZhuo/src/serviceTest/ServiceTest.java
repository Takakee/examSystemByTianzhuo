package serviceTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.Test;

import service.TeacherService;
import service.UserService;
import vo.Teacher;
import vo.User;

class ServiceTest {

	@Test
	public void test() throws Exception {
		UserService userService=new UserService();
		User user = new User();
		user.setUserName("田茁");
		user.setPassword("12345");
		Map<String,Object> map=userService.checkLogin(user);
		
		if(map.get("code").equals("0")) {
			System.out.println("登录成功！");
			
		}
		else {
			System.out.println(map.get("msg"));
		}	

	}

}
