package com.example.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity {
	final String[] items = {"音量大", "音量中", "音量小"};	
	final String[] items2 = {"大", "中", "小"};	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String[] data = {"通知音", "音量", "文字の大きさ"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, data ) {   
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView view1 = (TextView)super.getView(position, convertView, parent);
				Switch b4 =(Switch)findViewById(R.id.button);
				int bmp2 = getIntent().getIntExtra("data", 0);
				int i=20;
				if(bmp2 == 40){
					i=30;
					view1.setTextSize(i);
					b4.setTextSize(i);
				}else if(bmp2 == 30){
					i=20;
					view1.setTextSize(i);
					b4.setTextSize(i);
				}else if(bmp2 == 20){
					i=10;
					view1.setTextSize(i);
					b4.setTextSize(i);
				}
				view1.setTextSize(i);
				return view1;
			}
		};      
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter); 
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, final View view,final int position, final long id) {
				final ListView listView = (ListView) parent;
			    String item2 = (String) listView.getItemAtPosition(position);
			    if(item2 == "文字の大きさ"){
			    	new AlertDialog.Builder(MainActivity.this)
			    	.setTitle("データを選択してください")
			    	.setSingleChoiceItems(items2, 0, new DialogInterface.OnClickListener() {
			    		public void onClick(DialogInterface dialog, int item) {	
			    			int dr = 0;
			    			Intent m = new Intent(MainActivity.this, MainActivity.class);
			    			if(item == 0){
			    				dr=40;
			    			}else if(item == 1){
			    				dr=30;
			    			}else if(item == 2){
			    				dr=20;
			    			}
			    			m.putExtra("data", dr);
			    			startActivity(m);
			    		}
	        		})
	        		.show();
			    }else if(item2 == "通知音"){
			    	Intent inten = new Intent(MainActivity.this,SubActivity.class);
			    	startActivity(inten);
			    }else if(item2 == "音量"){
			    	new AlertDialog.Builder(MainActivity.this)
			    	.setTitle("データを選択してください")
			    	.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {		
			    		public void onClick(DialogInterface dialog, final int item) {	
			    			
	        			}
	        		})
	        		.setNegativeButton("閉じる", new DialogInterface.OnClickListener() {
	        			public void onClick(DialogInterface dialog, int id) {
	        				dialog.cancel();
	        			}
	        		})
	        		.show();
			    }			 	 
			}
		});
		listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
					ListView listView = (ListView) parent;
		            String item = (String) listView.getSelectedItem();
	                if(item == "通知音"){
        				Intent inten = new Intent(MainActivity.this,SubActivity.class);
        				startActivity(inten);
	                }
	            }
	            @Override
	            public void onNothingSelected(AdapterView<?> parent) {
	            }
		});
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
