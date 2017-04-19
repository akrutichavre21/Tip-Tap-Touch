package com.hp.tiptap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class About_Us extends Activity {

	
	TextView t2,t4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about__us);
		
		t2=(TextView)findViewById(R.id.textView2);
		t4=(TextView)findViewById(R.id.textView4);
		
		t2.setText("\n\nAKANKSHA DEWANGAN\nakankshadewangan@gmail.com "+"\n\n"+"AKRUTI CHAVRE\nakrutichavre21@gmail.com"+"\n\n"+"AKSHATA NERKAR\nakshatanerkar96@gmail.com"+"\n\nBranch :"+"\nCOMPUTER SCIENCE AND ENGINEERING");
		t4.setText("This is our first Android application and it has been developed as a part of our training project work for our Engineering course at Innolat Technologies, Raipur. It has been purely built to demonstrate our Android Application development skills.");
	}

	
	
}
