package dao;

import java.util.List;

import vo.Student;

public interface IStudentDAO {
	
	// 根据stuName找学生
	public Student getByName(String stuName);
	// 修改学生成绩
	public void update(Student student);
	// 查找最高分数的学生
	public Student getHighest();
	// 查找最低分数的学生
	public Student getLowest();
	// 查找所有学生，以list集合返回
	public List<Student> getAllStu();
}
