package com.example.listviewtutorial;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("ShowToast")
public class MainActivity extends Activity {
	
	private List<Car> myCars = new ArrayList<Car>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		populateCars();	
		populateCarsList();
		registerClickListener();
	}
	
	
	private void registerClickListener() { 
		ListView car_list = (ListView) findViewById(R.id.lst_car);
		car_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
			Car currentCar = myCars.get(position);
			
			Intent intent = new Intent(MainActivity.this, CarDetailsActivity.class); 
	 
			intent.putExtra("getIcon", ""+ currentCar.getIcon());
			intent.putExtra("getName", currentCar.getName());
			intent.putExtra("getYear", "" + currentCar.getYear());
			intent.putExtra("getBrand", currentCar.getBrand());
			startActivity(intent);
			
		
			}
			
		});

	}

 
	private void populateCarsList() {
		ArrayAdapter<Car> adapter = new MyListAdapter();
		ListView lst_car = (ListView) findViewById(R.id.lst_car);
		lst_car.setAdapter(adapter);
	}
	
	

	private void populateCars() {
		myCars.add(new Car(R.drawable.heart, 1111, "car1", "branch1" ));
		myCars.add(new Car(R.drawable.bug, 2222, "car2", "branch2" ));
		myCars.add(new Car(R.drawable.fish, 3333, "car3", "branch3" ));
		myCars.add(new Car(R.drawable.help, 4444, "car4", "branch4" ));
		myCars.add(new Car(R.drawable.down, 5555, "car5", "branch5" ));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class MyListAdapter extends ArrayAdapter<Car>{
	
		public MyListAdapter(){
			super(MainActivity.this, R.layout.car_list, myCars);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View itemView = convertView;
			
			if(itemView == null){
				itemView = getLayoutInflater().inflate(R.layout.car_list, parent, false);
				
			}
			Car currentCar = myCars.get(position);
			ImageView car_icon = (ImageView) itemView.findViewById(R.id.icon_car);
			car_icon.setImageResource(currentCar.getIcon());
			
			TextView car_name = (TextView) itemView.findViewById(R.id.text_name);
			car_name.setText(currentCar.getName());
			
			
			TextView car_year = (TextView) itemView.findViewById(R.id.txt_year);
			car_year.setText("" + currentCar.getYear());
			
			TextView car_brand = (TextView) itemView.findViewById(R.id.txt_brand);
			car_brand.setText(currentCar.getBrand());
			 
			
			return itemView;
			//return super.getView(position, convertView, parent);
		}
			 
		
	}

}
