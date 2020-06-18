package vo;

public class Teacher {
	private String teacherName;
	private int numberOfquestion;
	
	public Teacher() {
		super();
	}
	public Teacher(String teacherName, int numberOfquestion) {
		super();
		this.teacherName = teacherName;
		this.numberOfquestion = numberOfquestion;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public int getnumberOfquestion() {
		return numberOfquestion;
	}
	public void setnumberOfquestion(int numberOfquestion) {
		this.numberOfquestion = numberOfquestion;
	}
	@Override
	public String toString() {
		return "Teacher [teacherName=" + teacherName + ", numberOfquestion=" + numberOfquestion + "]";
	}
	
	
}
