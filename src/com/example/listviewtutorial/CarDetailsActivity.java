package com.example.listviewtutorial;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class CarDetailsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_car_details);
		Intent intent = getIntent();
		
		TextView name = (TextView) findViewById(R.id.cd_name);
		TextView year = (TextView) findViewById(R.id.cd_year);
		TextView brand = (TextView) findViewById(R.id.cd_brand);
		ImageView icon = (ImageView) findViewById(R.id.cd_icon);
		
		
		Log.d("s================", "=====sss========" +  intent.getStringExtra("getIcon"));
		
		name.setText(intent.getStringExtra("getName"));
		year.setText(intent.getStringExtra("getYear"));
		brand.setText(intent.getStringExtra("getBrand")); 
		//icon.setTag(intent.getStringExtra("getIcon"));
		
		int i = getIntent().getIntExtra("getIcon", 0);
		String dd=  intent.getStringExtra("getIcon"); 
		//intent.setType("image/*");
		//intent.setAction(Intent.ACTION_GET_CONTENT);
		//startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
		
		icon.setImageResource(Integer.parseInt(dd));
	}

 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.car_details, menu);
		return true;
	}

}
