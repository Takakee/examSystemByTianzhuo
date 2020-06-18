package dao;

import vo.Teacher;

public interface ITeacherDAO {
	
	// 根据teacherName找teacher
	public Teacher getByName(String teacherName);
	// 更改试卷题目数量
	public void update(Teacher teacher);
}
