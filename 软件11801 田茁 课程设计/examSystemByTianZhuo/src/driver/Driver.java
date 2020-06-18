package driver;

import service.QuestionService;
import service.StudentService;
import service.TeacherService;
import service.UserService;
import util.Menu;
import vo.Student;
import vo.Teacher;
import vo.User;

public class Driver {

	public static void main(String[] args) throws Exception {

		// 启动服务层
		Menu menu = new Menu();
		UserService userservice = new UserService();
		TeacherService teacherservice = new TeacherService();
		StudentService stuservice = new StudentService();
		QuestionService quesService = new QuestionService();

		// 准备参数
		int numOfquestion = quesService.getNumOfquestion();;
		Teacher teacher = new Teacher();
		Student stu = new Student();
	

		// 登录校验，并传回user对象，若对象为null则退出程序
		User user = userservice.Login();
		if (user == null) {
			return;
		}

		// 根据role的不同，提供不同的服务
		// 当role为teacher时，提供老师服务
		if (user.getRole().equals("teacher")) {
			teacher = teacherservice.findByTeacherName(user.getUserName());
			int choose = menu.teacherMenu(teacher);
			while (choose != 5) {
				switch (choose) {
				case 1:
					teacherservice.teacherQuestionManagement();
					break;
				case 2:
					teacherservice.changeNumOfquestion(teacher);
					break;
				case 3:
					teacherservice.findStuByname();
					break;
				case 4:
					teacherservice.showScoreDetail();
					break;
				case 5:
					teacherservice.changeNumOfquestion(teacher);
					return; // 退出
				default:
					System.out.println("输入无效，只能输入1-5，请重新输入");
					break;
				}
				choose = menu.teacherMenu(teacher);
			}
		} // if
		else { // 当role为student时，提供学生考试服务
			stu = stuservice.findByStuName(user.getUserName());
			System.out.println("登录成功！" + stu.getStuName() + "，考试马上开始，请答题：");
			stuservice.examTime(stu, numOfquestion);
		}
	}

}
