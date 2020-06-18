package service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import dao.ITeacherDAO;
import util.Menu;
import util.MybatisUtils;
import vo.Question;
import vo.Student;
import vo.Teacher;

public class TeacherService {
	
	private ITeacherDAO teacherDAO = null;
	private SqlSession sqlSession = null;
	
	public TeacherService() {
		this.sqlSession = MybatisUtils.getSqlSession();
		this.teacherDAO = sqlSession.getMapper(ITeacherDAO.class);
	}
	
	// 根据teacherName查找老师
	public Teacher findByTeacherName(String teacherName) {
		Teacher t1 = this.teacherDAO.getByName(teacherName);
		
		return t1;
	}
	
	// 改试卷题目数量
	public void changeNumOfquestion(Teacher teacher) {
		int newNumOfquestion;
		Scanner scan = new Scanner(System.in);
		System.out.println("考试管理，修改试卷题目数量，请输入新的题目数量：");
		newNumOfquestion = scan.nextInt();
		
		Teacher newTeacher = new Teacher(teacher.getTeacherName(), newNumOfquestion);
		this.teacherDAO.update(newTeacher);
		this.sqlSession.commit();
		System.out.println("题目数量修改好了！下次考试生效！");
	}
	
	// 通过stuName查询学生成绩
	public void findStuByname() {
		// 输入要查询的学生姓名
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要查询成绩的学生姓名：");
		String stuName = scan.nextLine();
		// 启动stu的服务层
		StudentService stuService = new StudentService();
		Student s1 = stuService.findByStuName(stuName);
		
		if(s1==null) {
			System.out.println("无该学生成绩！");
		}else {
			System.out.println(s1.getStuName()+"成绩为："+s1.getScore());
		}
	}
	
	// 成绩统计，显示最高分、最低分、平均分、各分段成绩百分比
	public void showScoreDetail() {
		StudentService stuService = new StudentService();
		Student stuHigh = stuService.findHighest();
		Student stuLow  = stuService.findLowest();
		List<Student> stuList = stuService.findAll();
		
		System.out.println("最高分："+ stuHigh.getStuName()+"  "+stuHigh.getScore()+"分");
		System.out.println("最低分："+ stuLow.getStuName() +"  "+stuLow.getScore()+"分");
		
		double sum=0;
		double avg=0;
		for(Student stu:stuList) {
			sum = sum+Double.parseDouble(stu.getScore());
		}
		avg = sum/(stuList.size());
		System.out.println("平均分："+ avg);
		
		int count=0;
		for(Student stu:stuList) {
			if(Double.parseDouble(stu.getScore())<60) {
				count++;
			}
		}
		System.out.println("60分以下的人数占全班百分比为：" + count*100/stuList.size()+"%");
		count=0;
		for(Student stu:stuList) {
			if(Double.parseDouble(stu.getScore())>=60 && Double.parseDouble(stu.getScore())<70) {
				count++;
			}
		}
		System.out.println("60~69分的人数占全班百分比为：" + count*100/stuList.size()+"%");
		count=0;
		for(Student stu:stuList) {
			if(Double.parseDouble(stu.getScore())>=70 && Double.parseDouble(stu.getScore())<80) {
				count++;
			}
		}
		System.out.println("70~79分的人数占全班百分比为：" + count*100/stuList.size()+"%");
		count=0;
		for(Student stu:stuList) {
			if(Double.parseDouble(stu.getScore())>=80 && Double.parseDouble(stu.getScore())<90) {
				count++;
			}
		}
		System.out.println("80~89分的人数占全班百分比为：" + count*100/stuList.size()+"%");
		count=0;
		for(Student stu:stuList) {
			if(Double.parseDouble(stu.getScore())>=90 && Double.parseDouble(stu.getScore())<=100) {
				count++;
			}
		}
		System.out.println("90~100分的人数占全班百分比为：" + count*100/stuList.size()+"%");
	}
	
	// 教师对题库进行管理
	public void teacherQuestionManagement() {
		// 启动服务层
		QuestionService quesService = new QuestionService();
		Menu menu = new Menu();
		Scanner scan = new Scanner(System.in);
		
		
		int choose = menu.questionManageMenu();
		while(choose!=5) {
			switch(choose) {
			case 1://增加
				Question q1 = quesService.inputFromKeyboard();
				boolean flag1 =quesService.insertQuestion(q1);
				break;
			case 2://删除
				boolean flag2 = quesService.deleteQuestion();
				break;
			case 3://修改
				Question q2 = quesService.inputFromKeyboard();
				boolean flag3 =quesService.changeQuestion(q2);
				break;
			case 4://查询
				System.out.println("请输入你要查询的题目id：");
				int id = scan.nextInt();
				Question q3 = quesService.findById(id);
				if(q3!=null) {
					System.out.println("该题目id为："+q3.getId()+"\n该题题干为："+q3.getContent()+"\n该题答案为："+q3.getAnswer());
				}else {
					System.out.println("没有该题！");
				}
				
				break;
			case 5:return; // 退出
			default:System.out.println("输入无效，只能输入1-5，请重新输入");break;
			}
			choose = menu.questionManageMenu();
		}
	}
	
	// 记录下次考试的题目数量，修改txt文件
	public void changeNumOfQuestion(Teacher teacher) throws Exception {
		teacher = this.teacherDAO.getByName(teacher.getTeacherName());
		int newNumOfQuestion = teacher.getnumberOfquestion();
		
		File file = new File("numOfQuestion.txt");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
		
		String numStr = String.valueOf(newNumOfQuestion);
		pw.println(numStr);
		
		pw.close();
		fw.close();
	}
}
