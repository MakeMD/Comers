package com.chemart.comers;




import java.text.DecimalFormat;
import java.util.GregorianCalendar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
//import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	
	final int MENU_QUIT_ID = 2;
	final int MENU_ABOUT_ID = 3;
	String[] data = {"Банк", "Рынок", "Биржа", "Хозяйство", "Секретарь"};
	 protected int splashTime;
	 String[] day = {"Понедельник","Вторник","Среда","Четверг","Пятница","Суббота","Воскресенье"};
	 String[] date = {"01-","02-","03-","04-","05-","06-","07-","08-","09-","10-","11-","12-","13-","14-","15-","16-","17-","18-","19-","20-","21-","22-","23-","24-","25-","26-","27-","28-","29-","30-", "31-"};
	 String[] month = {"Jan-","Feb-","Mar-","Apr-","May-","Jun-","Jul-","Aug-","Sep-","Oct-","Nov-","Dec-"};
	 int y_timer = 2000;   
	 TextView dt,dy,mnt,yr,score_tv,profit_tv,income_tax_tv;
	    int day_timer,d_timer,m_timer =0;
	    double house_rent;
	    double land_rent;
	    double income_tax;
	    double profit;
	    double score;
	    DecimalFormat df = new DecimalFormat("###########");
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final Intent conf_intent = getIntent();
		splashTime = conf_intent.getIntExtra("splashTime", 0);
		score = conf_intent.getDoubleExtra("score_conf", 0);
		profit = conf_intent.getDoubleExtra("profit_conf", 0);
		income_tax = conf_intent.getDoubleExtra("income_tax_conf", 0);
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
              
              //Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            switch (position){
            case 0:{
            	//Intent intent = new Intent(MainActivity.this, Bank.class);
                //startActivity(intent);
            	break;            	
            }
            case 1:{
            	splashTime = 6000;
            	Intent intent = new Intent(MainActivity.this, Shop.class);
                startActivity(intent);
                break;
                
            }
            case 2:{
            	//Intent intent = new Intent(MainActivity.this, Rialto.class);
                //startActivity(intent);
                break;
            }
            case 3:{
            	//Intent intent = new Intent(MainActivity.this, Property.class);
                //startActivity(intent);
                break;
            }
            case 4:{
            	//Intent intent = new Intent(MainActivity.this, Secretary.class);
                //startActivity(intent);
                break;
            }
            }
            
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
        profit_tv = (TextView) findViewById(R.id.textView14);
        income_tax_tv = (TextView) findViewById(R.id.textView17);
        score_tv.setText(df.format(score));
        profit_tv.setText(df.format(profit));
        income_tax_tv.setText(df.format((1-income_tax)*100)+"%");
         final Thread th=new Thread(){
        	
            @Override
            public void run(){
            	
            	try
                {
            		m_timer = 0;
                	d_timer=-1;
                	day_timer=-1;
                    while (d_timer > -2 & day_timer > -2) {
                	//for (timer = 0; timer < 31; timer++)
                    d_timer++;
                    day_timer++;
                    splashTime = conf_intent.getIntExtra("splashTime", 0);
            		
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
                                        	day_timer=0;
                                        	m_timer++;
                                        	d_timer=0;
                                        	score = score+(profit*income_tax);
                                        	Intent put_intent = new Intent(MainActivity.this, Config.class);
                                        	put_intent.putExtra("score_conf", score);
                                        	//Toast.makeText(getBaseContext(), "Удерживается подоходный налог в размере "+ df.format(profit-(profit*income_tax))+" гроблей", Toast.LENGTH_LONG).show();
                                            //Log.w("score", Double.toString(score));
                                        	score_tv.setText(df.format(score));
                                        	profit=0;
                                        	put_intent.putExtra("profit_conf", profit);
                                            profit_tv.setText(df.format(profit));
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
                                    GregorianCalendar cal = new GregorianCalendar();
                                    if (cal.isLeapYear(y_timer) == true)
                                    {
                                    if(m_timer == 1 && d_timer >= 29){
                                    	d_timer = 0;
                                    	mnt.setText("Mar-");
                                    	m_timer=m_timer+1;
                                    	Toast.makeText(getBaseContext(), "Lisp", Toast.LENGTH_LONG).show();
                                        
                                    }
                                    }
                                    else{
                                    	if(m_timer == 1 && d_timer >= 28){
                                        	d_timer = 0;
                                        	mnt.setText("Mar-");
                                        	m_timer=m_timer+1;
                                        	Toast.makeText(getBaseContext(), "NoLisp!!!!", Toast.LENGTH_LONG).show();
                                    	}
                                    }
                                    if(m_timer == 2 && d_timer >=31){
                                    	d_timer = 0;
                                    	mnt.setText("Apr-");
                                    	m_timer=m_timer+1;
                                    }
                                    if(m_timer == 3 && d_timer >=30){
                                    	d_timer = 0;
                                    	mnt.setText("May-");
                                    	m_timer=m_timer+1;
                                    }
                                    if(m_timer == 4 && d_timer >=31){
                                    	d_timer = 0;
                                    	mnt.setText("Jun-");
                                    	m_timer=m_timer+1;
                                    }
                                    if(m_timer == 5 && d_timer >=30){
                                    	d_timer = 0;
                                    	mnt.setText("Jul-");
                                    	m_timer=m_timer+1;
                                    }
                                    if(m_timer == 6 && d_timer >=31){
                                    	d_timer = 0;
                                    	mnt.setText("Aug-");
                                    	m_timer=m_timer+1;
                                    }
                                    if(m_timer == 7 && d_timer >=31){
                                    	d_timer = 0;
                                    	mnt.setText("Sep-");
                                    	m_timer=m_timer+1;
                                    }
                                    if(m_timer == 8 && d_timer >=30){
                                    	d_timer = 0;
                                    	mnt.setText("Oct-");
                                    	m_timer=m_timer+1;
                                    }
                                    if(m_timer == 9 && d_timer >=31){
                                    	d_timer = 0;
                                    	mnt.setText("Nov-");
                                    	m_timer=m_timer+1;
                                    }
                                    if(m_timer == 10 && d_timer >=30){
                                    	d_timer = 0;
                                    	mnt.setText("Dec-");
                                    	m_timer=m_timer+1;
                                    }
                                    if(m_timer == 11 && d_timer >=31){
                                    	d_timer = 0;
                                    	mnt.setText("Jan-");
                                    	Toast.makeText(getBaseContext(), "Happy New year!", Toast.LENGTH_SHORT).show();
                                    	m_timer=0;
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
	public void onPause() {
	    super.onPause();  // Always call the superclass method first
	}


	@Override
	public void onResume() {
	    super.onResume();  // Always call the superclass method first
	    Intent conf_intent = getIntent();
	    score = conf_intent.getDoubleExtra("score_conf", 0);
		profit = conf_intent.getDoubleExtra("profit_conf", 0);
		income_tax = conf_intent.getDoubleExtra("income_tax_conf", 0);
		
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
