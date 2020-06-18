package vo;

public class Question {
	private int id;
	private String content;
	private String answer;
	
	
	public Question() {
		super();
	}


	public Question(int id, String content, String answer) {
		super();
		this.id = id;
		this.content = content;
		this.answer = answer;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + ", answer=" + answer + "]";
	}
	
	
}
