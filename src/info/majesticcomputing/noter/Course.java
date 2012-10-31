package info.majesticcomputing.noter;

public class Course {

	Course(int id, String name){
		courseId = id;
		courseName = name;
	}
	private int courseId;
	private String courseName;
	
	@Override
	public String toString(){
		return courseName;
	}
	
	public int getId(){
		return courseId;
	}
	
	public String getName(){
		return courseName;
	}
	
}
