package info.majesticcomputing.noter;
import info.majesticcomputing.noter.CoursesFragment.OnCourseSelectedListener;
import info.majesticcomputing.noter.LecturesFragment.ILectureFragmentHandler;
import info.majesticcomputing.noter.R;
import android.content.Intent;
import android.os.*;
import android.support.v4.app.*;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;


public class MainActivity extends FragmentActivity implements OnCourseSelectedListener, ILectureFragmentHandler{
	int currentCourseId = -1;
	Menu menu;
	FragmentManager fm = getSupportFragmentManager();
	LecturesFragment lf;
	CoursesFragment cf;
	@Override
	public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			
			//This ensures that we have the actionbar if it is available.
			this.requestWindowFeature(Window.FEATURE_ACTION_BAR);
			setContentView(R.layout.courses_lectures);
			lf = (LecturesFragment)fm.findFragmentByTag("LecturesFragment");
			cf = (CoursesFragment)fm.findFragmentByTag("CoursesFragment");
	}

	public void onCourseSelected(int position) {
		Toast.makeText(getApplicationContext(), "Called inside the activity " + Data.Courses.get(position), Toast.LENGTH_SHORT).show();
		FragmentManager fm = getSupportFragmentManager();
		LecturesFragment lf = (LecturesFragment)fm.findFragmentByTag("LecturesFragment");
		lf.setCourseId(position);
		currentCourseId = position;
		menu.getItem(1).setVisible(true);
		
	}

	public boolean setCourseId(int id) {
		Toast.makeText(getApplicationContext(), "Called inside the activity " + Data.Courses.get(id), Toast.LENGTH_SHORT).show();
		return true;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main_menu, menu);
	    this.menu = menu;
	    Data.populate();
	    return true;
	}

	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add_course){
    		currentCourseId++;
        	Data.Courses.add(new Course(currentCourseId, "Course: " + currentCourseId));
        	Toast.makeText(getApplicationContext(), "Added course", Toast.LENGTH_SHORT).show();
        	if(cf != null){
        		cf.reDraw();
        		Toast.makeText(getApplicationContext(), "Redraw called", Toast.LENGTH_LONG).show();
        	}
        }
        if(item.getItemId() == R.id.add_note){
        	Intent i = new Intent(this, NoteActivity.class);
        	startActivity(i);
        }
        	
        return true;

    }

}
