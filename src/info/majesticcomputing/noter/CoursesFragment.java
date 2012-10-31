package info.majesticcomputing.noter;

import android.app.Activity;
import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;

public class CoursesFragment extends ListFragment{
	
	OnCourseSelectedListener mCallback;
	
	public interface OnCourseSelectedListener{
		public void onCourseSelected(int position);
	}
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // We need to use a different list item layout for devices older than Honeycomb
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        // Create an array adapter for the list view, using the Ipsum headlines array
        setListAdapter(new ArrayAdapter<Course>(getActivity(), layout, Data.Courses));
    }
	
	@Override
	public void onStart(){
		super.onStart();
		
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE); 
	}
	
	@Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Notify the parent activity of selected item
        //Toast.makeText(getActivity(), Data.Courses[position], Toast.LENGTH_SHORT).show();
        ((OnCourseSelectedListener)getActivity()).onCourseSelected(position);
        // Set the item as checked to be highlighted when in two-pane layout
        getListView().setItemChecked(position, true);
    }
	
	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            mCallback = (OnCourseSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
	
	public void reDraw()
	{
		int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;

        // Create an array adapter for the list view, using the Ipsum headlines array
        setListAdapter(new ArrayAdapter<Course>(getActivity(), layout, Data.Courses));
		getListView().invalidate();
	}
}