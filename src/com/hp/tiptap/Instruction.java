package com.hp.tiptap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Instruction extends Activity {

	
	TextView t2,t3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_instruction);
		t2=(TextView)findViewById(R.id.textView2);
		t3=(TextView)findViewById(R.id.textView3);
		
		t2.setText("The characters in the game appear randomly on the screen.\nYou need to tap over the characters to gain points!!");
        t3.setText("Ensure that you are fast enough or you'll lose a point!");
	
	
	}


}
