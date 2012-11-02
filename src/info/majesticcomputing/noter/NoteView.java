package info.majesticcomputing.noter;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.*;
import android.graphics.*;
import android.graphics.Paint.Cap;

public class NoteView extends View {
	private Paint lPaint = new Paint();
	private Paint cPaint = new Paint();
	private Path path = new Path();
	Point p = new Point();
	ArrayList<Point> points = new ArrayList<Point>();
	int pEvent;
	public NoteView(Context context, AttributeSet attrs) {
		super(context, attrs);
		lPaint.setAntiAlias(true);
		lPaint.setColor(Color.WHITE);
		lPaint.setStyle(Paint.Style.STROKE);
		lPaint.setStrokeJoin(Paint.Join.ROUND);
		lPaint.setStrokeCap(Cap.ROUND);
		lPaint.setStrokeWidth(5f);
		
		cPaint.setAntiAlias(true);
		cPaint.setColor(Color.WHITE);
		cPaint.setStyle(Paint.Style.FILL);
		cPaint.setStrokeJoin(Paint.Join.ROUND);
		cPaint.setStrokeCap(Cap.ROUND);
		cPaint.setStrokeWidth(5f);
		
		
	}
	
	@Override
	protected void onDraw(Canvas canvas){
			canvas.drawPath(path, lPaint);
			for(Point a : points){
				canvas.drawCircle(a.x, a.y, 3f, cPaint);
			}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		float eventX = event.getX();
		float eventY = event.getY();
		
		switch(event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			path.moveTo(eventX, eventY);
			pEvent = MotionEvent.ACTION_DOWN;
			Point p = new Point();
			p.x = (int)eventX;
			p.y = (int)eventY;
			points.add(p);
			return true;
		case MotionEvent.ACTION_MOVE:
			path.lineTo(eventX, eventY);
			pEvent = MotionEvent.ACTION_MOVE;
			break;
		case MotionEvent.ACTION_UP:
			break;
		default:
			return true;
		}
		
		invalidate();
		return true;
	}
			

}
