package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import dao.IStudentDAO;
import util.MybatisUtils;
import vo.Question;
import vo.Student;

public class StudentService {

	private IStudentDAO studentDAO = null;
	private SqlSession sqlSession = null;

	public StudentService() {
		this.sqlSession = MybatisUtils.getSqlSession();
		this.studentDAO = sqlSession.getMapper(IStudentDAO.class);
	}

	// 根据stuName查找student
	public Student findByStuName(String stuname) {
		Student stu = this.studentDAO.getByName(stuname);
		return stu;
	}

	// 找最高成绩
	public Student findHighest() {
		Student stu = this.studentDAO.getHighest();
		return stu;
	}

	// 找最低成绩
	public Student findLowest() {
		Student stu = this.studentDAO.getLowest();
		return stu;
	}
	
	// 查找所有学生
	public List<Student> findAll(){
		List<Student> stuList = this.studentDAO.getAllStu();
		return stuList;
	}
	
	// 学生考试模式，最后会修改学生成绩score
	public void examTime(Student stu, int numOfQuestion) {
		// 准备参数
		String myAnswer="";
		String trueAnswer="";
		String newScore="";
		int count=0;
		int rightCount=0;
		
		// 启动服务层
		QuestionService quesService = new QuestionService();
		Scanner scan = new Scanner(System.in);
		
		// 获取随机生成的题目集合
		List<Question> quesList = quesService.findRandQuestion(numOfQuestion);
		for(Question ques:quesList) {
			// 生成题号
			count++;
			// 生成该题正确答案
			trueAnswer = ques.getAnswer();
			// 分割题干和题目选项
			String[] contentArray = ques.getContent().split(" ");
			// 输出题干
			System.out.println("\n"+count+". "+contentArray[0]);
			// 输出题目选项
			for(int i=1;i<contentArray.length;i++) {
				System.out.println(contentArray[i]);
			}
			System.out.println("请输入你的答案：");
			// 生成我的答案
			myAnswer = scan.nextLine();
			// 判断答案是否一致，不区分大小写
			if(myAnswer.equals(trueAnswer) || myAnswer.equalsIgnoreCase(trueAnswer)) {
				rightCount++;
			}
		}
		
		newScore = String.valueOf(rightCount*100/count);
		System.out.println("一共答对了"+rightCount+"题"+" 分数："+newScore);
		
		// 修改学生分数，记录到数据库
		Student changeStu = this.studentDAO.getByName(stu.getStuName());
		changeStu.setScore(newScore);
		this.studentDAO.update(changeStu);
		this.sqlSession.commit();
		System.out.println(changeStu.getStuName()+"同学，考试结束！你的分数已经登记成功！");
	}
}
