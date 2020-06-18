package dao;

import java.util.List;

import vo.Question;

public interface IQuestionDAO {
	
	// 通过id查找question
	public Question getById(int id);
	
	// 增加题目
	public boolean insert(Question question);
	
	// 删除题目
	public boolean delete(int id);
	
	// 随机获取试题，返回题目集合类
	public List<Question> getRandQuestion(int numOfQuestion);
}
