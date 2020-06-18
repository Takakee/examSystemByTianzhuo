package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import dao.IQuestionDAO;
import util.MybatisUtils;
import vo.Question;

public class QuestionService {

	private IQuestionDAO questionDAO = null;
	private SqlSession sqlSession = null;

	public QuestionService() {
		this.sqlSession = MybatisUtils.getSqlSession();
		this.questionDAO = sqlSession.getMapper(IQuestionDAO.class);
	}

	// 读取题目数量的txt文件
	public int getNumOfquestion() throws Exception {
		int num;
		
		// 水源
		File file = new File("numOfQuestion.txt");
		// 水管
		FileReader fr = new FileReader(file);
		// 水龙头
		BufferedReader bf = new BufferedReader(fr);
		String numStr="";
		numStr = bf.readLine();
		num = Integer.parseInt(numStr);
		
		bf.close();
		fr.close();
		return num;
		
	}
	// 通过id查询题目
	public Question findById(int id) {
		Question question = this.questionDAO.getById(id);

		return question;
	}

	// 从键盘输入题目
	public Question inputFromKeyboard() {
		System.out.println("请输入题目id：");
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		scan.nextLine();
		
		System.out.println("请输入题目内容（题干、选项用空格隔开）：");
		String content = scan.nextLine();
		
		System.out.println("请输入题目答案：");
		String answer = scan.nextLine();
		
		Question q1 = new Question(id, content, answer);

		return q1;
	}

	// 插入题目
	public boolean insertQuestion(Question q1) {
		boolean result = this.questionDAO.insert(q1);
		this.sqlSession.commit();
		System.out.println("题目插入成功！");
		return result;
	}

	// 修改题目
	public boolean changeQuestion(Question q1) {
		boolean result = this.questionDAO.insert(q1);
		this.sqlSession.commit();
		System.out.println("题目修改成功！");
		return result;
	}
	
	// 删除题目
	public boolean deleteQuestion() {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要删除的题目id：");
		int id = scan.nextInt();
		
		boolean result = this.questionDAO.delete(id);
		this.sqlSession.commit();
		
		return result;
		
	}
	
	public List<Question> findRandQuestion(int numOfQuestion){
		List<Question> quesList = new ArrayList<Question>();
		quesList = this.questionDAO.getRandQuestion(numOfQuestion);
		
		return quesList;
	}
	
	
}
