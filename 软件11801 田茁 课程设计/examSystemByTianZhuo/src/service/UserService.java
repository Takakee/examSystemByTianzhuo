package service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import dao.IUserDAO;
import util.MybatisUtils;
import vo.User;

public class UserService {

	private IUserDAO userDAO = null;
	private SqlSession sqlSession = null;

	public UserService() {
		this.sqlSession = MybatisUtils.getSqlSession();
		this.userDAO = sqlSession.getMapper(IUserDAO.class);
	}

	// 登录检查一次，Map形式返回检查结果
	public Map<String, Object> checkLogin(User user) throws Exception {
		Map<String, Object> mapResult = new HashMap<String, Object>();
		
		try {
			User foundUser = this.userDAO.getByName(user.getUserName());
			if(foundUser == null) {
				mapResult.put("code", 1);
				mapResult.put("msg","用户名不存在！");
			}else {
				String userPassword = user.getPassword();
				if(!foundUser.getPassword().equals(userPassword)) {
					mapResult.put("code", 1);
					mapResult.put("msg", "密码不正确！");
				}else {
					mapResult.put("code", 0);
					mapResult.put("msg", "登录成功！");
					mapResult.put("user", foundUser);
				}
			}
			
		} catch(Exception e) {
			mapResult.put("code", 1);
			mapResult.put("msg", e.getMessage());
			
		}finally { // 无论是否有异常，都需要关闭数据库会话
			sqlSession.close();
		}
		
		return mapResult;
	}
	
	public User inputFromKeyboard() {
		Scanner scan=new Scanner(System.in);
		System.out.println("请输入用户名");
		String userName= scan.nextLine();
		System.out.println("请输入密码");
		String password=scan.nextLine();
		User user=new User();
		user.setUserName(userName);
		user.setPassword(password);
		return user;
	}
	// 登录检查三次，若都不正确则退出
	public User Login() throws Exception {
		int i=0;
		int t=0;
		User loginUser = new User();
		
		while(i<3) {
			UserService userService = new UserService();
			User user = userService.inputFromKeyboard();
			Map<String,Object> map = userService.checkLogin(user);
			
			if(map.get("code").equals(0)) {
				t=1;
				System.out.println("登陆成功！");
//				loginUser = userService.userDAO.getByName(loginUser.getUserName());
				loginUser = (User)map.get("user");
				break;
			}else{
				System.out.println(map.get("msg")+"请重新输入");
				i++;
			}
		}
		
		if(i>=3) {
			System.out.println("最多只能尝试3次,程序退出!");
			return null;
		}
		if(t==1) {
			return loginUser;
		}
		
		return null;
	}
}
