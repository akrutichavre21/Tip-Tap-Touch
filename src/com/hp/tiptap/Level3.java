package com.hp.tiptap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Level3 extends Activity {

	
	
	Button b,b1,b2;
	TextView t;
	
	int check=0;
	int count=0;
	int x,y,m,n;
	
	int[] p={R.drawable.a4,R.drawable.b4,R.drawable.c4,R.drawable.d4,R.drawable.e4,R.drawable.f4,R.drawable.g4,R.drawable.h4,R.drawable.i4,R.drawable.j4,R.drawable.k4,R.drawable.l4};
	
	private CountDownTimer countdown;
	private boolean timeHasStarted = false;
	private final long start=15*1000;
	private final long end=1*1000;
	
	int a=0;
	int size=0;
	long tEnd;
	
	String s;
	
	Display display;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_level3);
		setTitle("Level - 3");
		t=(TextView)findViewById(R.id.textView3);
		b=(Button)findViewById(R.id.btnStart3);
		b1=(Button)findViewById(R.id.btn3);
		b2=(Button)findViewById(R.id.lost3);
		
		display=getWindowManager().getDefaultDisplay();
		
		m=display.getWidth();
		n=display.getHeight();
		
		Intent myIntent = getIntent();
		count= myIntent.getIntExtra("score", 0);
		
		countdown = new MyCountdownTimer(start, end);
		
		t.setText(t.getText()+String.valueOf(start/1000)+":00");
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				tEnd=System.currentTimeMillis();
				b.setVisibility(View.GONE);
				b.setEnabled(false);
				
				if(!timeHasStarted)
				{
					countdown.start();
					timeHasStarted=true;
					
					b1.setEnabled(true);
					
				}
				
				else
				{
					countdown.cancel();
					timeHasStarted=false;
				
					b1.setEnabled(false);
					b1.setVisibility(View.GONE);
				
					
				}
			}
		});
	}

	
	public class MyCountdownTimer extends CountDownTimer
	{

		public MyCountdownTimer(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onTick(long millisUntilFinished) {
			// TODO Auto-generated method stub
			t.setText(""+millisUntilFinished/1000+":00");
			
			b1.setVisibility(View.VISIBLE);
			b2.setVisibility(View.GONE);
			b2.setBackgroundResource(R.drawable.lost);
			b2.setEnabled(false);
			b1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					count++;
					
					Random();
					
					b1.setBackgroundResource(p[size]);
					b1.getX();
					b1.getY();
					
					if(check==1)
					{
						check=0;
						a=1;
						
						b1.setVisibility(View.GONE);
						
					}
					
					if((System.currentTimeMillis()>(tEnd+2000))&&a!=1)
					{
						
						runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								b2.setVisibility(View.VISIBLE);
								b1.setVisibility(View.GONE);
								
								if(System.currentTimeMillis()%3000==0)
								{
									b2.setVisibility(View.GONE);
									b1.setVisibility(View.VISIBLE);
								}
								
							}
						});
						
						
						
						count=count-1;
						
					}
					tEnd=System.currentTimeMillis();
				}
			});
		}

		protected void Random() {
			// TODO Auto-generated method stub
			
			java.util.Random r=new java.util.Random();
			size=r.nextInt(11)+1;
			x=r.nextInt(m-270)+80;
			y=r.nextInt(n-450)+85;
			
			b1.setX(x);
			b1.setY(y);
			
		}

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			
			
			t.setText("Time is Up! ");
		    
		    
		  new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent obj= new Intent(Level3.this,MainActivity.class);
				obj.putExtra("score", count);
				startActivity(obj);
				
			}
		}, 1500);
					
				
			check=1;
					   
		}
		
	}
	
}
