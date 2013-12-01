package com.chemart.comers;




import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	final int MENU_QUIT_ID = 2;
	final int MENU_ABOUT_ID = 3;
	String[] data = {"Банк", "Рынок", "Биржа", "Хозяйство", "Секретарь"};
	 protected int splashTime = 1000;
	 String[] day = {"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота","Воскресенье"};
	 String[] date = {"01-","02-","03-","04-","05-","06-","07-","08-","09-","10-","11-","12-","13-","14-","15-","16-","17-","18-","19-","20-","21-","22-","23-","24-","25-","26-","27-","28-","29-","30-"};
	 String[] month = {"Jan-","Feb-","Mar-","Apr-","May-","Jun-","Jul-","Aug-","Sep-","Oct-","Nov-","Dec-"};
	 int y_timer = 2000;   
	 TextView dt,dy,mnt,yr,score_tv;
	    int day_timer,d_timer,m_timer =0;
	    double house_rent = 0.71;
	    double land_rent = 0.98;
	    double income_tax = 0.98;
	    double profit = 137.00;
	    double score = 43657.00;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Меню");
        spinner.setSelection(2);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                int position, long id) {
              // показываем позиция нажатого элемента
              //Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
          });
         
        dy = (TextView) findViewById(R.id.textView3);
        dt = (TextView) findViewById(R.id.textView2);
        mnt = (TextView) findViewById(R.id.textView6);
        yr = (TextView) findViewById(R.id.textView27);
        score_tv = (TextView) findViewById(R.id.textView5);
        
        Thread th=new Thread(){
        	
            @Override
            public void run(){
                try
                {
                	d_timer=-1;
                	day_timer=-1;
                    while (d_timer > -2 & day_timer > -2) {
                	//for (timer = 0; timer < 31; timer++)
                    d_timer++;
                    day_timer++;
                    	{
                        int waited = 0;
                        while(waited < splashTime)
                        {
                            Thread.sleep(100);
                            runOnUiThread(new Runnable() { 
                                @Override
                                public void run() {
                                    try{
                                    	dy.setText(day[day_timer]);
                                    }
                                    catch(Exception e)
                                    {
                                    	day_timer=0;
                                    	
                                    }
                                	try {
                                        dt.setText(date[d_timer]);
                                
                                    }
                                    catch(Exception e) 
                                    {
                                        e.printStackTrace();
                                   d_timer=0;
                                   m_timer++;
                                   score = score+(profit*income_tax);
                                   //double pr = profit*income_tax;
                                   //String formatedDouble = String.format("%.10f", pr);
                                   DecimalFormat df = new DecimalFormat("###########");
                                   Toast.makeText(getBaseContext(), "Удерживается подоходный налог в размере "+ df.format(profit-(profit*income_tax))+" гроблей", Toast.LENGTH_LONG).show();
                                   Log.w("score", Double.toString(score));
                                   score_tv.setText(df.format(score));
                                   profit=0;
                                    } 
                                    try{
                                    	mnt.setText(month[m_timer]);
                                    	
                                    }
                                    catch(Exception e)
                                    {
                                    	e.printStackTrace();
                                    	m_timer=0;
                                    	y_timer++;
                                    }
                                    try{
                                    	yr.setText(Integer.toString(y_timer));
                                    }
                                    catch(Exception e)
                                    {
                                    	e.printStackTrace();
                                    	y_timer=0;
                                    }
                                    if (m_timer == 12 & d_timer == 30 ){
                                    	Toast.makeText(getBaseContext(), "Happy New year!", Toast.LENGTH_SHORT).show();   
                                    }
                                    }
                            });
                            waited += 100;
                                	
                            }  
                        
                    }
                }
                    }
                catch (InterruptedException e) {
                
                }
            }
            };
        th.start();
        }
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//Прописываем в меню пункт Выход
		menu.add(0, MENU_QUIT_ID, 0, R.string.quit);
		menu.add(0,MENU_ABOUT_ID, 0, R.string.about);
		return super.onCreateOptionsMenu(menu);
		
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		//TODO Auto-generated method stub
		switch (item.getItemId()) {
		case MENU_QUIT_ID:
		//выход из приложения
		finish();
		break;
		case MENU_ABOUT_ID:
			
		try {
			PackageManager manager = this.getPackageManager();
			PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
			Toast.makeText(this,
			     "Version "+ info.versionName, Toast.LENGTH_LONG).show();	
		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		}
		return super.onOptionsItemSelected(item);
			}

}
