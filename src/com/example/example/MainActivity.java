package com.example.example;


import com.example.example3.R;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;



public class MainActivity extends Activity {
	
	
	
	final String[] items = {"音量大", "音量中", "音量小"};	
	final String[] items2 = {"大", "中", "小"};	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final String[] data = {"通知音", "音量", "文字の大きさ"}; 
		
		
			 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this
					   , android.R.layout.simple_list_item_1, data ) {   
				 
				 @Override
				public 	View getView(int position, View convertView, ViewGroup parent) {
					   final TextView view1 = (TextView)super.getView(position, convertView, parent);
						 
					  
					  view1.setTextSize(koko(1) );
					   return view1;
					   
					   }

				

				
			
				   };      
			   ListView listView = (ListView) findViewById(R.id.listView1);       // アダプターを設定します
			   listView.setAdapter(adapter); 
			  
			 

	        // リストビューのアイテムがクリックされた時に呼び出されるコールバックリスナーを登録します
	        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	            
	       
	        	@Override
	            
	          public void onItemClick(AdapterView<?> parent, final View view,final int position, final long id) {
	                final ListView listView = (ListView) parent;
	                // クリックされたアイテムを取得します
	                String item2 = (String) listView.getItemAtPosition(position);
	              
	              
	                final int size[] ={10, 20,30};
	               
	                if(item2 == "文字の大きさ"){
	                	new AlertDialog.Builder(MainActivity.this)
	        			.setTitle("データを選択してください")
	        			.setSingleChoiceItems(items2, 0, new DialogInterface.OnClickListener() {
	        				
							public void onClick(DialogInterface dialog, int item) {	
								
								 koko(3);
								 Intent m = new Intent(MainActivity.this, MainActivity.class);
								 m.putExtra("通知音", "ere");
								 startActivity(m);
								 
								
							}

							

														

							
							
	        		})
	
	        			.setNegativeButton("閉じる", new DialogInterface.OnClickListener() {
	        			public void onClick(DialogInterface dialog, int id) {
	        				dialog.cancel();
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
	        					((TextView) view).setTextSize( size[item] );
	        					
	        					
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
	        
	        // リストビューのアイテムが選択された時に呼び出されるコールバックリスナーを登録します
	        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
	            @Override
	            public void onItemSelected(AdapterView<?> parent, View view,
	                    int position, long id) {
	                ListView listView = (ListView) parent;
	                // 選択されたアイテムを取得します
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


protected float koko(int i) {
		// TODO 自動生成されたメソッド・スタブ
		return 20*i;
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
