package info.majesticcomputing.noter;

import android.app.Activity;
import android.os.*;
public class NoteActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(new NoteView(this, null));
	}
}
