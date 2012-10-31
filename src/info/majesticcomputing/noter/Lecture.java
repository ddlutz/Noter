package info.majesticcomputing.noter;

public class Lecture {
	public Lecture(int id, String title, int courseId)
	{
		this.id = id;
		this.title = title;
		this.courseId = courseId;
	}
	public int id;
	public String title;
	public int courseId;
	
	public String toString(){
		return title;
	}
}
