package com.hp.tiptap;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	
	TextView tv;
     int flag=0;
	Button b1,b2,b3,b4,b5;
	Intent obj,obj1;
	int high;
	String st;
	int count=0;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		setTitle("Tip Tap Touch");
		
		b1=(Button)findViewById(R.id.start);
		b2=(Button)findViewById(R.id.Leave);
		b3=(Button)findViewById(R.id.sound);
		b4=(Button)findViewById(R.id.AboutUs);
		b5=(Button)findViewById(R.id.info);
		
		b3.setOnClickListener(this);
		tv=(TextView)findViewById(R.id.textView1);
		obj1=new Intent(MainActivity.this,Myservice.class);
		

		
		
		
		Intent myIntent = getIntent();
		count= myIntent.getIntExtra("score", 0);
		tv.setText("Your Score :" + count);
		
		
	
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
	
				obj=new Intent(MainActivity.this,StartActivity.class);
				startActivity(obj);
				
			}
		});
		
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			     stopService(obj1);
			    //finish();
				//System.exit(0);
                   Intent intent=new Intent(Intent.ACTION_MAIN);
                   intent.addCategory(Intent.CATEGORY_HOME);
                   startActivity(intent);
			}
		});
		
		b4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent obj= new Intent(MainActivity.this,About_Us.class);
				startActivity(obj);
				
				
			}
		});
		
		b5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent obj=new Intent(MainActivity.this,Instruction.class);
				startActivity(obj);
				
			}
		});
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(b3.getId())
		{
		case R.id.sound:
			if(flag==0)
			{
				
				
				flag=1;
				startService(obj1);
			}
			else
			{
				
				
				flag=0;
				stopService(obj1);
			}
			break;
		}
		
	}

	



}
