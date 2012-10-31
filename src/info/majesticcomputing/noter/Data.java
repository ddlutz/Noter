package info.majesticcomputing.noter;
import java.util.*;

public class Data {
	static ArrayList<Course> Courses = new ArrayList<Course>();

    static ArrayList<Lecture> Lectures = new ArrayList<Lecture>();
    
    public static void populate(){
    	
    	for(int i = 0; i < 4; i++)
    		Courses.add(new Course(i, "Course " + i));
    	
    	for(int i = 0; i < 10; i++)
    		Lectures.add(new Lecture(i, "Lecture " + i, i % 3));
    }
    
    
    public static void addNewCourse(Course n){
    	Courses.add(n);
    }
}
