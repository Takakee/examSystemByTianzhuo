package util;

import java.util.Scanner;

import vo.Teacher;
import vo.User;

public class Menu {
	public Menu() {
		super();
	}

	public int teacherMenu(Teacher teacher) {
		int choose;
		System.out.println("\n\n登录成功！欢迎您"+teacher.getTeacherName()+"老师");
		System.out.println("1、题库管理");
		System.out.println("2、考试管理");
		System.out.println("3、成绩查询");
		System.out.println("4、成绩统计");
		System.out.println("5、退出");
		System.out.println("请选择（1-5）：");
		Scanner scan = new Scanner(System.in);
		choose = scan.nextInt();	
		return choose;
	}
	
	public int questionManageMenu() {
		int choose;
		System.out.println("\n进入题库管理模式：");
		System.out.println("1、增加题目");
		System.out.println("2、删除题目");
		System.out.println("3、修改题目");
		System.out.println("4、查询题目");
		System.out.println("5、退出");
		System.out.println("请选择（1-5）：");
		Scanner scan = new Scanner(System.in);
		choose = scan.nextInt();	
		
		return choose;
	}
}
