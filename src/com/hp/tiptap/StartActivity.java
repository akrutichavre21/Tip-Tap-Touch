  package com.hp.tiptap;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class StartActivity extends Activity {

    Button b,b1,b2;
    TextView t;

    ImageView iv;
    
    int check=0;
    
    int count=0,x,y,m,n;
 
    
	int[] p={R.drawable.a2,R.drawable.b2,R.drawable.c2,R.drawable.d2,R.drawable.e2,R.drawable.f2,R.drawable.g2,R.drawable.h2,R.drawable.i2,R.drawable.j2,R.drawable.k2};
    private CountDownTimer countdown;
    private boolean timeHasStarted = false;
    private final long start=30*1000;
    private final long end=1*1000;
    int a=0;
    int size=0;
    long tEnd,tStart;
   
    
    
    Display display;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		setTitle("Level - 1");
		t=(TextView)findViewById(R.id.txtStart);
		b=(Button)findViewById(R.id.btnStart);
	    b1=(Button)findViewById(R.id.btn);
	    b2=(Button)findViewById(R.id.button);
	    display = getWindowManager().getDefaultDisplay();
	   
	   
		b2.setVisibility(View.GONE);
	    m=display.getWidth();
	    n= display.getHeight();
	   
	    
		
		countdown= new MyCountdownTimer(start, end);
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
		
				 
				
				 
				 
				 if(System.currentTimeMillis()>(tEnd+2000)&&a!=1)
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
			        
			   
			        
			
				tEnd = System.currentTimeMillis();
				}
			});
			
			
			
		}

		protected void Random() {
			// TODO Auto-generated method stub
			
			java.util.Random r= new java.util.Random();
			
			
			size=r.nextInt(10)+1;
			x = r.nextInt(m-250) + 80;
			y=r.nextInt(n-550) + 85;
			
		 b1.setX(x);
		 b1.setY(y);
			
		}

		

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			
			t.setText("Time is Up!");
			
			new Handler().postDelayed(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					Intent ob= new Intent(StartActivity.this,Level2.class);
					ob.putExtra("score", count);
					startActivity(ob); 
					
				}
			}, 1500);
			
			
			check=1;
			
			
			
		}
		
	}
	
		 
	
	
}
