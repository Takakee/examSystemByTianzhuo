package vo;

public class Student {
	private String stuName;
	private String score;
	
	public Student() {
		super();
	}
	public Student(String stuName, String score) {
		super();
		this.stuName = stuName;
		this.score = score;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", score=" + score + "]";
	}
	
	
}
