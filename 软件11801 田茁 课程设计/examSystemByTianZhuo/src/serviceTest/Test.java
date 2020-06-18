package serviceTest;

import java.util.List;
import java.util.Map;

import service.QuestionService;
import service.StudentService;
import service.TeacherService;
import service.UserService;
import vo.Question;
import vo.Student;
import vo.Teacher;
import vo.User;

public class Test {

	public static void main(String[] args) throws Exception {
/*		UserService userService=new UserService();
		User user = new User();
		user.setUserName("田茁");
		user.setPassword("123");
		Map<String,Object> map=userService.checkLogin(user);
		
		if(map.get("code").equals("0")) {
			System.out.println("登录成功！");
			
		}
		else {
			System.out.println(map.get("msg"));
		}	
*/		
		TeacherService teacherService = new TeacherService();
//		teacherService.teacherQuestionManagement();
/*		Teacher t1 = teacherService.findByTeacherName("田茁");
		System.out.println(t1.toString());
		teacherService.changeNumOfquestion(t1);
		t1 = teacherService.findByTeacherName("田茁");
		System.out.println(t1.toString());
*/		
/*		teacherService.teacherQuestionManagement();
		teacherService.showScoreDetail();
		StudentService stuService = new StudentService();
		List<Student> stuList = stuService.findAll();
		for(Student stu:stuList) {
			System.out.println(stu.toString());
		}
*/		
		

/*		QuestionService quesService = new QuestionService();
		Question q1 = new Question(12, "第二次测试第12条是否插入", "C");
		boolean flag = quesService.insertQuestion(q1);
		q1 = quesService.findById(12);
		System.out.println(q1.toString());

		Question q2 = quesService.findById(12);
		System.out.println(q2.toString());

		List<Question> quesList = quesService.findRandQuestion(3);
		for(Question ques:quesList) {
			System.out.println(ques.toString());
		}

		StudentService stuService = new StudentService();
		Student stu = new Student("韩信", "80");
		stuService.examTime(stu, 3);
		
		QuestionService quesService = new QuestionService();
		System.out.println(quesService.getNumOfquestion());
*/
	}

}
