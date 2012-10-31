package info.majesticcomputing.noter;
import android.app.Activity;
import android.os.*;
import android.support.v4.app.*;
import android.widget.*;
import java.util.*;

public class LecturesFragment extends ListFragment{
	
	ILectureFragmentHandler mCallback;
	
	/**
	 * 
	 * @author ddlutz
	 * This interface ensures that the parent activity has a function setCourseId which will allow
	 * enable this fragment to communicate with the activity and other fragments it holds
	 */
	public interface ILectureFragmentHandler{
		public boolean setCourseId(int id);
	}
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
        ArrayList<Lecture> empty = new ArrayList<Lecture>();
        setListAdapter(new ArrayAdapter<Lecture>(getActivity(), layout, empty));
    }
	
	
	/**
	 * This function ensures that the activity implemented the necessary activity
	 */
	public void onAttach(Activity activity){
		super.onAttach(activity);
		
		try{
			mCallback = (ILectureFragmentHandler)activity;
		}
			catch(ClassCastException e){
			}
			
	}
	
	/**
	 * 
	 * @param id : The Course Id that we will filter by. If it is set to -1, do not load any courses
	 * 
	 * @return True if there is a course with the corresponding Id, false otherwise 
	 */
	public boolean setCourseId(int courseId){
		ArrayList<Lecture> LectureList = new ArrayList<Lecture>();
		for(int i = 0; i < Data.Lectures.size(); i++){
			if(Data.Lectures.get(i).courseId == courseId){
			LectureList.add(Data.Lectures.get(i));
			}
	}
		
		//Lecture[] LectureArray = (Lecture[]) LectureList.toArray();
		
		//Toast.makeText(getActivity(), "Sent by acvitiy: " + courseId, Toast.LENGTH_SHORT).show();
		
		// We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
        setListAdapter(new ArrayAdapter<Lecture>(getActivity(), layout, LectureList));

		
		return true;
	}
}