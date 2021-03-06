package com.chemart.comers;




import java.text.DecimalFormat;
import java.util.GregorianCalendar;
import java.util.Random;


import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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

/** MainActivity**/
public class MainActivity extends Activity {
	
	final int MENU_QUIT_ID = 2;
	final int MENU_ABOUT_ID = 3;
	String[] data = {"���� ", "����", "�����", "�����", "���������", "���������"};
	 protected int splashTime = 1000;
	 String[] day = {"�����������","�������","�����","�������","�������","�������","�����������"};
	 String[] date = {"01-","02-","03-","04-","05-","06-","07-","08-","09-","10-","11-","12-","13-","14-","15-","16-","17-","18-","19-","20-","21-","22-","23-","24-","25-","26-","27-","28-","29-","30-", "31-"};
	 String[] month = {"Jan-","Feb-","Mar-","Apr-","May-","Jun-","Jul-","Aug-","Sep-","Oct-","Nov-","Dec-"};
	 int y_timer = 2000;   
	 TextView dt,dy,mnt,yr,score_tv,profit_tv,income_tax_tv,kredit_proc_tv,depoz_proc_tv,kredit_tv,depozit_tv;
	    int day_timer,d_timer,m_timer =0;
	    double house_rent;
	    double land_rent;
	    double income_tax = 0.98;
	    double profit= 0.00;
	    double score = 53657.00;
	    double car_cost =0;
	    double apart_cost =0;
	    int oil_cost=0, glebe_cost=0;
	    String car="",apart="";
	    int birthday,birthmonth;
	    int month_now=1;
	    int oil,glebe;
	    int g,o;
	    int kredit_proc = 10;
	    int depoz_proc = 3;
	    int sales_g=0,sales_o=0,buyes_o=0,buyes_g=0, kredit=0, depozit=0, kredit_srok=0,depoz_srok=0;
	    
	    int tempbirthd,tempbirthm,tempnyd,tempnym ;
	     	
	    double saldo_ob=0.00,saldo_gb=0.00,saldo_os=0.00,saldo_gs=0.00;
	    DecimalFormat df = new DecimalFormat("###########");
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	//Save Preferences states of items
		SavePreferences("score",df.format(score));
		SavePreferences("profit",df.format(profit));
		SavePreferences("car_cost",df.format(car_cost));
		SavePreferences("apart_cost",df.format(apart_cost));
		SavePreferences("apart", apart);
		SavePreferences("car", car);
		SavePreferences("oil", Integer.toString(oil));
		SavePreferences("glebe", Integer.toString(glebe));
		SavePreferences("month_now",Integer.toString(month_now));
		SavePreferences("sales_g",Integer.toString(sales_g));
		SavePreferences("sales_o",Integer.toString(sales_o));
		SavePreferences("buyes_g",Integer.toString(buyes_g));
		SavePreferences("buyes_o",Integer.toString(buyes_o));
		SavePreferences("saldo_gb",df.format(saldo_gb));
		SavePreferences("saldo_ob",df.format(saldo_ob));
		SavePreferences("saldo_gs",df.format(saldo_gs));
		SavePreferences("saldo_os",df.format(saldo_os));
		SavePreferences("kredit_proc",Integer.toString(kredit_proc));
		SavePreferences("depoz_proc",Integer.toString(depoz_proc));
		SavePreferences("kredit",Integer.toString(kredit));
		SavePreferences("depozit",Integer.toString(depozit));
		SavePreferences("kredit_srok",Integer.toString(kredit_srok));
		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
		SavePreferences("birthday",Integer.toString(birthday));
		SavePreferences("birthmonth",Integer.toString(birthmonth));
	//End of SavePreferences
	//Randomize coefficient of grab and oil
		final Random myRandom = new Random();
    	int koef_g = myRandom.nextInt(70);
    	int koef_o = myRandom.nextInt(5);
    	int sign = myRandom.nextInt(2);
    	if (sign == 0){
    	g = (myRandom.nextInt(500-300)+300)+koef_g;
    	o = (myRandom.nextInt(100-10)+100)+koef_o;
    	}
    	else{
    	g = (myRandom.nextInt(500-300)+300)-koef_g;
    	o = (myRandom.nextInt(100-10)+100)-koef_o;
    	}
    	SavePreferences("glebe_cost",Integer.toString(g));
    	SavePreferences("oil_cost",Integer.toString(o));
    //End of Randomize
    //Generate birthday
    	final Random mybirthRandom = new Random();
    	birthday = mybirthRandom.nextInt(30);
    	birthmonth = mybirthRandom.nextInt(11);
    	if (birthday == 0){
    		birthday = 1;
    	}
    	if (birthmonth == 0){
    		birthmonth =1;
    	}
    	SavePreferences("birthday",Integer.toString(birthday));
		SavePreferences("birthmonth",Integer.toString(birthmonth));
    //End of birthday
	//Menu items selector
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setAdapter(adapter);
        spinner.setPrompt("����");
        spinner.setSelection(-1);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                int position, long id) {
              
              //Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            switch (position){
            case 0:{
            	position = 0;
                 spinner.setSelection(0);
                 break;
            }
            case 1:{
            	Intent intent = new Intent(MainActivity.this, Bank.class);
            	startActivity(intent);
            	position = 0;
            	spinner.setSelection(0);
            	break;            	
            }
            case 2:{
            	Intent intent = new Intent(MainActivity.this, Shop.class);
                startActivity(intent);
                position =0;
                spinner.setSelection(0);
                break;
                
            }
            case 3:{
            	Intent intent = new Intent(MainActivity.this, Railto.class);
                startActivity(intent);
            	position =0;
                spinner.setSelection(0);
                
            	break;
            }
            case 4:{
            	Intent intent = new Intent(MainActivity.this, Havings.class);
                startActivity(intent);
                position = 0;
                spinner.setSelection(0);
                break;
            }
            case 5:{
            	Intent intent = new Intent(MainActivity.this, Secret.class);
                startActivity(intent);
            	position = 0;
                spinner.setSelection(0);
            	break;
            }
            }
            
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
          });
    //End of Menu items selector
    //Set lables text
        dy = (TextView) findViewById(R.id.textView3);
        dt = (TextView) findViewById(R.id.textView2);
        mnt = (TextView) findViewById(R.id.textView6);
        yr = (TextView) findViewById(R.id.textView27);
        score_tv = (TextView) findViewById(R.id.textView5);
        profit_tv = (TextView) findViewById(R.id.textView14);
        income_tax_tv = (TextView) findViewById(R.id.textView17);
        kredit_proc_tv = (TextView) findViewById(R.id.textView21);
        depoz_proc_tv = (TextView) findViewById(R.id.textView19);
        kredit_tv = (TextView) findViewById(R.id.textView8);
        depozit_tv = (TextView) findViewById(R.id.textView11);
        score_tv.setText(df.format(score));
        profit_tv.setText(df.format(profit));
        income_tax_tv.setText(df.format((1-income_tax)*100)+"%");
        kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
        depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
        kredit_tv.setText(Integer.toString(kredit));
        depozit_tv.setText(Integer.toString(depozit));
     //end lables text
        
        //tempbirthd =-1;
        //tempbirthm =-1;
        tempnyd =0;
        tempnym =0;
        tempnyd =30;
        tempnyd =11;
       	tempbirthd = birthday;
     	tempbirthm = birthmonth;
     	
     //Start thread for timer
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
                    //splashTime = 500;
            		
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
                                        	
                                        	d_timer=0;
                                        	
                                        	if (profit <0){
                                        		profit=0;
                                        	}
                                        	
                                        	score = score+(profit*income_tax);
                                        	profit=0;
                                        	SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	//
                                        	SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                     	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                     	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                        	if ((kredit >0)&(kredit_srok>0)){
                                         		kredit_srok --;
                                     	    	kredit = kredit + kredit_proc;
                                         		kredit_tv.setText(Integer.toString(kredit));
                                         		score_tv.setText(df.format(score));
                                         		SavePreferences("score",df.format(score));
                                            	SavePreferences("profit",df.format(profit));
                                            	SavePreferences("kredit",Integer.toString(kredit));
                                             	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                         	}
                                         	else{
                                         		score = score - kredit;
                                         		kredit =0;
                                         		kredit_srok = 0;
                                         		kredit_tv.setText(Integer.toString(kredit));
                                         		score_tv.setText(df.format(score));
                                         		SavePreferences("score",df.format(score));
                                            	SavePreferences("profit",df.format(profit));
                                            	SavePreferences("kredit",Integer.toString(kredit));
                                            	SavePreferences("depozit",Integer.toString(depozit));
                                            	SavePreferences("depozit",Integer.toString(depozit));
                                         		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                            		}
                                         	if ((depozit >0)&(depoz_srok>0)){
                                         		depoz_srok --;
                                         		depozit = depozit + depoz_proc;
                                         		depozit_tv.setText(Integer.toString(depozit));
                                         		score_tv.setText(df.format(score));
                                         		SavePreferences("score",df.format(score));
                                            	SavePreferences("profit",df.format(profit));
                                            	SavePreferences("depozit",Integer.toString(depozit));
                                         		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                         	}
                                         	else{
                                         		score = score + depozit;
                                         		depozit =0;
                                         		depoz_srok = 0;
                                         		depozit_tv.setText(Integer.toString(depozit));
                                         		score_tv.setText(df.format(score));
                                         		SavePreferences("score",df.format(score));
                                            	SavePreferences("profit",df.format(profit));
                                            	SavePreferences("kredit",Integer.toString(kredit));
                                            	SavePreferences("depozit",Integer.toString(depozit));
                                            	SavePreferences("depozit",Integer.toString(depozit));
                                         		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                         	}
                                         	//
                                         	//
                                         	final Random myBankRandom = new Random();
                                         	kredit_proc = myBankRandom.nextInt(19);
                                         	depoz_proc = myBankRandom.nextInt(9);
                                         	if (kredit_proc <=0){
                                         		kredit_proc =1;
                                         	}
                                         	if (depoz_proc <=0){
                                         		depoz_proc =1;
                                         	}
                                         	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                         	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                         	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                        	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                        	//
                                         	final Random myRandom = new Random();
                                        	int koef_g = myRandom.nextInt(70);
                                        	int koef_o = myRandom.nextInt(5);
                                        	int sign = myRandom.nextInt(2);
                                        	if (sign == 0){
                                        	g = (myRandom.nextInt(500-300)+300)+koef_g;
                                        	o = (myRandom.nextInt(100-10)+100)+koef_o;
                                        	}
                                        	else{
                                        	g = (myRandom.nextInt(500-300)+300)-koef_g;
                                        	o = (myRandom.nextInt(100-10)+100)-koef_o;
                                        	}
                                        	SavePreferences("glebe_cost",Integer.toString(g));
                                        	SavePreferences("oil_cost",Integer.toString(o));
                                        	
                                        	m_timer++;
                                        	//Toast.makeText(getBaseContext(), "������������ ���������� ����� � ������� "+ df.format(profit-(profit*income_tax))+" �������", Toast.LENGTH_LONG).show();
                                            //Log.w("score", Double.toString(score));
                                        	score_tv.setText(df.format(score));
                                        	profit_tv.setText(df.format(profit));
                                        	
                                    } 
                                    try{
                                    	mnt.setText(month[m_timer]);
                                    	
                                    	
                                    	
                                    	SavePreferences("glebe_cost",Integer.toString(g));
                                    	SavePreferences("oil_cost",Integer.toString(o));
                                    	SavePreferences("month_now",Integer.toString(m_timer));
                                    	switch (m_timer){
                                    	case 0:
                                    		SavePreferences("g_jan",Integer.toString(g));
                                    		SavePreferences("o_jan",Integer.toString(o));
                                    		break;
                                    	case 1:
                                    		SavePreferences("g_feb",Integer.toString(g));
                                    		SavePreferences("o_feb",Integer.toString(o));
                                    		break;
                                    	case 2:
                                    		SavePreferences("g_mar",Integer.toString(g));
                                    		SavePreferences("o_mar",Integer.toString(o));
                                    		break;
                                    	case 3:
                                    		SavePreferences("g_apr",Integer.toString(g));
                                    		SavePreferences("o_apr",Integer.toString(o));
                                    		break;
                                    	case 4:
                                    		SavePreferences("g_may",Integer.toString(g));
                                    		SavePreferences("o_may",Integer.toString(o));
                                    		break;
                                    	case 5:
                                    		SavePreferences("g_jun",Integer.toString(g));
                                    		SavePreferences("o_jun",Integer.toString(o));
                                    		break;
                                    	case 6:
                                    		SavePreferences("g_jul",Integer.toString(g));
                                    		SavePreferences("o_jul",Integer.toString(o));
                                    		break;
                                    	case 7:
                                    		SavePreferences("g_aug",Integer.toString(g));
                                    		SavePreferences("o_aug",Integer.toString(o));
                                    		break;
                                        case 8:
                                        	SavePreferences("g_sep",Integer.toString(g));
                                        	SavePreferences("o_sep",Integer.toString(o));
                                    		break;
                                        case 9:
                                        	SavePreferences("g_oct",Integer.toString(g));
                                        	SavePreferences("o_oct",Integer.toString(o));
                                    		break;
                                        case 10:
                                        	SavePreferences("g_nov",Integer.toString(g));
                                        	SavePreferences("o_nov",Integer.toString(o));
                                    		break;
                                        case 11:
                                        	SavePreferences("g_dec",Integer.toString(g));
                                        	SavePreferences("o_dec",Integer.toString(o));
                                    		break;
                                    	}
                                    	//
                                    	//tempbirthm = birthmonth;
                                    	//tempbirthd = birthday;
                                     	if ((m_timer == tempbirthm)&&(d_timer == tempbirthd)){
                                     		tempbirthd =-1;
                                     		tempbirthm =-1;
                                    		Toast.makeText(getBaseContext(), "Birthday!!! Yahoo!!", Toast.LENGTH_LONG).show();
                                    	}
                 // if ((tempnym ==11)&(tempnyd ==30)){
                //	  tempnym =0;
                //	  tempnyd =0;
                //  Toast.makeText(getBaseContext(), "Happy New Year!!!", Toast.LENGTH_LONG).show();
                
              //  }
                                    	//
                                    	Log.w("COMERS", Integer.toString(m_timer));	
                                    		  
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
                                    	//
                                    	SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                 	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                 	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                    	
                                    	if ((kredit >0)&(kredit_srok>0)){
                                     		kredit_srok --;
                                 	    	kredit = kredit + kredit_proc;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                         	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                     	}
                                     	else{
                                     		score = score - kredit;
                                     		kredit =0;
                                     		kredit_srok = 0;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                        		}
                                     	if ((depozit >0)&(depoz_srok>0)){
                                     		depoz_srok --;
                                     		depozit = depozit + depoz_proc;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	else{
                                     		score = score + depozit;
                                     		depozit =0;
                                     		depoz_srok = 0;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	
                                     	//
                                     	final Random myBankRandom = new Random();
                                     	kredit_proc = myBankRandom.nextInt(19);
                                     	depoz_proc = myBankRandom.nextInt(9);
                                     	if (kredit_proc <=0){
                                     		kredit_proc =1;
                                     	}
                                     	if (depoz_proc <=0){
                                     		depoz_proc =1;
                                     	}
                                     	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                     	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                     	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                    	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                    	//
                                    	d_timer = 0;
                                    	mnt.setText("2Mar-");
                                    	m_timer=m_timer+1;
                                    	SavePreferences("score",df.format(score));
                                    	SavePreferences("profit",df.format(profit));
                                    	SavePreferences("kredit",Integer.toString(kredit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                 		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                    	//Toast.makeText(getBaseContext(), "Lisp", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                    else{
                                    	if(m_timer == 1 && d_timer >= 28){
                                    		//
                                    		SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                     	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                     	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                        	
                                        	if ((kredit >0)&(kredit_srok>0)){
                                         		kredit_srok --;
                                     	    	kredit = kredit + kredit_proc;
                                         		kredit_tv.setText(Integer.toString(kredit));
                                         		score_tv.setText(df.format(score));
                                         		SavePreferences("score",df.format(score));
                                            	SavePreferences("profit",df.format(profit));
                                            	 	SavePreferences("kredit",Integer.toString(kredit));
                                             	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                         	}
                                         	else{
                                         		score = score - kredit;
                                         		kredit =0;
                                         		kredit_srok = 0;
                                         		kredit_tv.setText(Integer.toString(kredit));
                                         		score_tv.setText(df.format(score));
                                         		SavePreferences("score",df.format(score));
                                            	SavePreferences("profit",df.format(profit));
                                            	SavePreferences("kredit",Integer.toString(kredit));
                                            	SavePreferences("depozit",Integer.toString(depozit));
                                            	SavePreferences("depozit",Integer.toString(depozit));
                                         		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                            		}
                                         	if ((depozit >0)&(depoz_srok>0)){
                                         		depoz_srok --;
                                         		depozit = depozit + depoz_proc;
                                         		depozit_tv.setText(Integer.toString(depozit));
                                         		score_tv.setText(df.format(score));
                                         		SavePreferences("score",df.format(score));
                                            	SavePreferences("profit",df.format(profit));
                                            	SavePreferences("depozit",Integer.toString(depozit));
                                         		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                         	}
                                         	else{
                                         		score = score + depozit;
                                         		depozit =0;
                                         		depoz_srok = 0;
                                         		depozit_tv.setText(Integer.toString(depozit));
                                         		score_tv.setText(df.format(score));
                                         		SavePreferences("score",df.format(score));
                                            	SavePreferences("profit",df.format(profit));
                                            	SavePreferences("kredit",Integer.toString(kredit));
                                            	SavePreferences("depozit",Integer.toString(depozit));
                                            	SavePreferences("depozit",Integer.toString(depozit));
                                         		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                         	}
                                         	
                                         	//
                                         	
                                         	final Random myBankRandom = new Random();
                                         	kredit_proc = myBankRandom.nextInt(19);
                                         	depoz_proc = myBankRandom.nextInt(9);
                                         	if (kredit_proc <=0){
                                         		kredit_proc =1;
                                         	}
                                         	if (depoz_proc <=0){
                                         		depoz_proc =1;
                                         	}
                                         	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                         	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                         	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                        	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                        	//
                                        	d_timer = 0;
                                        	mnt.setText("2Mar-");
                                        	m_timer=m_timer+1;
                                        	SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	//Toast.makeText(getBaseContext(), "NoLisp!!!!", Toast.LENGTH_LONG).show();
                                    	}
                                    }
                                    if(m_timer == 2 && d_timer >=31){
                                    	//
                                    	SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                 	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                 	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                    	
                                    	if ((kredit >0)&(kredit_srok>0)){
                                     		kredit_srok --;
                                 	    	kredit = kredit + kredit_proc;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                         	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                     	}
                                     	else{
                                     		score = score - kredit;
                                     		kredit =0;
                                     		kredit_srok = 0;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                        		}
                                     	if ((depozit >0)&(depoz_srok>0)){
                                     		depoz_srok --;
                                     		depozit = depozit + depoz_proc;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	else{
                                     		score = score + depozit;
                                     		depozit =0;
                                     		depoz_srok = 0;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	
                                     	//
                                     	final Random myBankRandom = new Random();
                                     	kredit_proc = myBankRandom.nextInt(19);
                                     	depoz_proc = myBankRandom.nextInt(9);
                                     	if (kredit_proc <=0){
                                     		kredit_proc =1;
                                     	}
                                     	if (depoz_proc <=0){
                                     		depoz_proc =1;
                                     	}
                                     	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                     	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                     	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                    	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                    	//
                                    	d_timer = 0;
                                    	mnt.setText("2Apr-");
                                    	m_timer=m_timer+1;
                                    	SavePreferences("score",df.format(score));
                                    	SavePreferences("profit",df.format(profit));
                                    	SavePreferences("kredit",Integer.toString(kredit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                 		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                    }
                                    if(m_timer == 3 && d_timer >=30){
                                    	//
                                    	SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                 	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                 	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                    	
                                    	if ((kredit >0)&(kredit_srok>0)){
                                     		kredit_srok --;
                                 	    	kredit = kredit + kredit_proc;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                         	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                     	}
                                     	else{
                                     		score = score - kredit;
                                     		kredit =0;
                                     		kredit_srok = 0;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                        		}
                                     	if ((depozit >0)&(depoz_srok>0)){
                                     		depoz_srok --;
                                     		depozit = depozit + depoz_proc;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	else{
                                     		score = score + depozit;
                                     		depozit =0;
                                     		depoz_srok = 0;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	
                                     	//
                                     	final Random myBankRandom = new Random();
                                     	kredit_proc = myBankRandom.nextInt(19);
                                     	depoz_proc = myBankRandom.nextInt(9);
                                     	if (kredit_proc <=0){
                                     		kredit_proc =1;
                                     	}
                                     	if (depoz_proc <=0){
                                     		depoz_proc =1;
                                     	}
                                     	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                     	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                     	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                    	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                    	//
                                    	d_timer = 0;
                                    	mnt.setText("2May-");
                                    	m_timer=m_timer+1;
                                    	SavePreferences("score",df.format(score));
                                    	SavePreferences("profit",df.format(profit));
                                    	SavePreferences("kredit",Integer.toString(kredit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                 		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                    }
                                    if(m_timer == 4 && d_timer >=31){
                                    	//
                                    	SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                 	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                 	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                    	
                                    	if ((kredit >0)&(kredit_srok>0)){
                                     		kredit_srok --;
                                 	    	kredit = kredit + kredit_proc;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                         	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                     	}
                                     	else{
                                     		score = score - kredit;
                                     		kredit =0;
                                     		kredit_srok = 0;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                        		}
                                     	if ((depozit >0)&(depoz_srok>0)){
                                     		depoz_srok --;
                                     		depozit = depozit + depoz_proc;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	else{
                                     		score = score + depozit;
                                     		depozit =0;
                                     		depoz_srok = 0;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	
                                     	//
                                     	final Random myBankRandom = new Random();
                                     	kredit_proc = myBankRandom.nextInt(19);
                                     	depoz_proc = myBankRandom.nextInt(9);
                                     	if (kredit_proc <=0){
                                     		kredit_proc =1;
                                     	}
                                     	if (depoz_proc <=0){
                                     		depoz_proc =1;
                                     	}
                                     	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                     	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                     	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                    	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                    	//
                                    	d_timer = 0;
                                    	mnt.setText("2Jun-");
                                    	m_timer=m_timer+1;
                                    	SavePreferences("score",df.format(score));
                                    	SavePreferences("profit",df.format(profit));
                                    	SavePreferences("kredit",Integer.toString(kredit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                    }
                                    if(m_timer == 5 && d_timer >=30){
                                    	//
                                    	SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                 	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                 	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                    	
                                    	if ((kredit >0)&(kredit_srok>0)){
                                     		kredit_srok --;
                                 	    	kredit = kredit + kredit_proc;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                         	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                     	}
                                     	else{
                                     		score = score - kredit;
                                     		kredit =0;
                                     		kredit_srok = 0;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                        		}
                                     	if ((depozit >0)&(depoz_srok>0)){
                                     		depoz_srok --;
                                     		depozit = depozit + depoz_proc;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	else{
                                     		score = score + depozit;
                                     		depozit =0;
                                     		depoz_srok = 0;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	
                                     	//
                                     	final Random myBankRandom = new Random();
                                     	kredit_proc = myBankRandom.nextInt(19);
                                     	depoz_proc = myBankRandom.nextInt(9);
                                     	if (kredit_proc <=0){
                                     		kredit_proc =1;
                                     	}
                                     	if (depoz_proc <=0){
                                     		depoz_proc =1;
                                     	}
                                     	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                     	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                     	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                    	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                    	//
                                    	d_timer = 0;
                                    	mnt.setText("2Jul-");
                                    	m_timer=m_timer+1;
                                    	SavePreferences("score",df.format(score));
                                    	SavePreferences("profit",df.format(profit));
                                    	SavePreferences("kredit",Integer.toString(kredit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                 		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                    }
                                    if(m_timer == 6 && d_timer >=31){
                                    	//
                                    	SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                 	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                 	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                    	
                                    	if ((kredit >0)&(kredit_srok>0)){
                                     		kredit_srok --;
                                 	    	kredit = kredit + kredit_proc;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                         	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                     	}
                                     	else{
                                     		score = score - kredit;
                                     		kredit =0;
                                     		kredit_srok = 0;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                        		}
                                     	if ((depozit >0)&(depoz_srok>0)){
                                     		depoz_srok --;
                                     		depozit = depozit + depoz_proc;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	else{
                                     		score = score + depozit;
                                     		depozit =0;
                                     		depoz_srok = 0;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	
                                     	//
                                     	final Random myBankRandom = new Random();
                                     	kredit_proc = myBankRandom.nextInt(19);
                                     	depoz_proc = myBankRandom.nextInt(9);
                                     	if (kredit_proc <=0){
                                     		kredit_proc =1;
                                     	}
                                     	if (depoz_proc <=0){
                                     		depoz_proc =1;
                                     	}
                                     	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                     	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                     	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                    	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                    	//
                                    	d_timer = 0;
                                    	mnt.setText("2Aug-");
                                    	m_timer=m_timer+1;
                                    	SavePreferences("score",df.format(score));
                                    	SavePreferences("profit",df.format(profit));
                                    	SavePreferences("kredit",Integer.toString(kredit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                 		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                    }
                                    if(m_timer == 7 && d_timer >=31){
                                    	//
                                    	SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                 	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                 	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                    	
                                    	if ((kredit >0)&(kredit_srok>0)){
                                     		kredit_srok --;
                                 	    	kredit = kredit + kredit_proc;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                         	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                     	}
                                     	else{
                                     		score = score - kredit;
                                     		kredit =0;
                                     		kredit_srok = 0;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                        		}
                                     	if ((depozit >0)&(depoz_srok>0)){
                                     		depoz_srok --;
                                     		depozit = depozit + depoz_proc;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	else{
                                     		score = score + depozit;
                                     		depozit =0;
                                     		depoz_srok = 0;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	
                                     	//
                                     	final Random myBankRandom = new Random();
                                     	kredit_proc = myBankRandom.nextInt(19);
                                     	depoz_proc = myBankRandom.nextInt(9);
                                     	if (kredit_proc <=0){
                                     		kredit_proc =1;
                                     	}
                                     	if (depoz_proc <=0){
                                     		depoz_proc =1;
                                     	}
                                     	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                     	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                     	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                    	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                    	//
                                    	d_timer = 0;
                                    	mnt.setText("2Sep-");
                                    	m_timer=m_timer+1;
                                    	SavePreferences("score",df.format(score));
                                    	SavePreferences("profit",df.format(profit));
                                    	SavePreferences("kredit",Integer.toString(kredit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                 		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                    }
                                    if(m_timer == 8 && d_timer >=30){
                                    	//
                                    	SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                 	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                 	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                    	
                                    	if ((kredit >0)&(kredit_srok>0)){
                                     		kredit_srok --;
                                 	    	kredit = kredit + kredit_proc;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                         	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                     	}
                                     	else{
                                     		score = score - kredit;
                                     		kredit =0;
                                     		kredit_srok = 0;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                        		}
                                     	if ((depozit >0)&(depoz_srok>0)){
                                     		depoz_srok --;
                                     		depozit = depozit + depoz_proc;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	else{
                                     		score = score + depozit;
                                     		depozit =0;
                                     		depoz_srok = 0;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	
                                     	//
                                     	final Random myBankRandom = new Random();
                                     	kredit_proc = myBankRandom.nextInt(19);
                                     	depoz_proc = myBankRandom.nextInt(9);
                                     	if (kredit_proc <=0){
                                     		kredit_proc =1;
                                     	}
                                     	if (depoz_proc <=0){
                                     		depoz_proc =1;
                                     	}
                                     	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                     	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                     	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                    	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                    	//
                                    	d_timer = 0;
                                    	mnt.setText("2Oct-");
                                    	m_timer=m_timer+1;
                                    	SavePreferences("score",df.format(score));
                                    	SavePreferences("profit",df.format(profit));
                                    	SavePreferences("kredit",Integer.toString(kredit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                 		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                    }
                                    if(m_timer == 9 && d_timer >=31){
                                    	//
                                    	SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                 	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                 	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                    	
                                    	if ((kredit >0)&(kredit_srok>0)){
                                     		kredit_srok --;
                                 	    	kredit = kredit + kredit_proc;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                         	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                     	}
                                     	else{
                                     		score = score - kredit;
                                     		kredit =0;
                                     		kredit_srok = 0;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                        		}
                                     	if ((depozit >0)&(depoz_srok>0)){
                                     		depoz_srok --;
                                     		depozit = depozit + depoz_proc;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	else{
                                     		score = score + depozit;
                                     		depozit =0;
                                     		depoz_srok = 0;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	//
                                    	
                                     	//
                                     	final Random myBankRandom = new Random();
                                     	kredit_proc = myBankRandom.nextInt(19);
                                     	depoz_proc = myBankRandom.nextInt(9);
                                     	if (kredit_proc <=0){
                                     		kredit_proc =1;
                                     	}
                                     	if (depoz_proc <=0){
                                     		depoz_proc =1;
                                     	}
                                     	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                     	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                     	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                    	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                    	//
                                    	d_timer = 0;
                                    	mnt.setText("2Nov-");
                                    	m_timer=m_timer+1;
                                    	SavePreferences("score",df.format(score));
                                    	SavePreferences("profit",df.format(profit));
                                    	SavePreferences("kredit",Integer.toString(kredit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                 		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                    }
                                    if(m_timer == 10 && d_timer >=30){
                                    	//
                                    	SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                 	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                 	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                    	
                                    	if ((kredit >0)&(kredit_srok>0)){
                                     		kredit_srok --;
                                 	    	kredit = kredit + kredit_proc;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                         	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                     	}
                                     	else{
                                     		score = score - kredit;
                                     		kredit =0;
                                     		kredit_srok = 0;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                        		}
                                     	if ((depozit >0)&(depoz_srok>0)){
                                     		depoz_srok --;
                                     		depozit = depozit + depoz_proc;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	else{
                                     		score = score + depozit;
                                     		depozit =0;
                                     		depoz_srok = 0;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	//
                                    	
                                     	//
                                     	final Random myBankRandom = new Random();
                                     	kredit_proc = myBankRandom.nextInt(19);
                                     	depoz_proc = myBankRandom.nextInt(9);
                                     	if (kredit_proc <=0){
                                     		kredit_proc =1;
                                     	}
                                     	if (depoz_proc <=0){
                                     		depoz_proc =1;
                                     	}
                                     	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                     	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                     	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                    	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                    	//
                                    	d_timer = 0;
                                    	mnt.setText("2Dec-");
                                    	m_timer=m_timer+1;
                                    	SavePreferences("score",df.format(score));
                                    	SavePreferences("profit",df.format(profit));
                                    	SavePreferences("kredit",Integer.toString(kredit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                 		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                    }
                                    if(m_timer == 11 && d_timer >=31){
                                    	//
                                    	SharedPreferences sharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                 	    kredit =  Integer.parseInt(sharedPreferences2.getString("kredit", ""));
                                 	    depozit = Integer.parseInt(sharedPreferences2.getString("depozit", ""));
                                    	
                                    	if ((kredit >0)&(kredit_srok>0)){
                                     		kredit_srok --;
                                 	    	kredit = kredit + kredit_proc;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                         	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
                                     	}
                                     	else{
                                     		score = score - kredit;
                                     		kredit =0;
                                     		kredit_srok = 0;
                                     		kredit_tv.setText(Integer.toString(kredit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                        		}
                                     	if ((depozit >0)&(depoz_srok>0)){
                                     		depoz_srok --;
                                     		depozit = depozit + depoz_proc;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	else{
                                     		score = score + depozit;
                                     		depozit =0;
                                     		depoz_srok = 0;
                                     		depozit_tv.setText(Integer.toString(depozit));
                                     		score_tv.setText(df.format(score));
                                     		SavePreferences("score",df.format(score));
                                        	SavePreferences("profit",df.format(profit));
                                        	SavePreferences("kredit",Integer.toString(kredit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                        	SavePreferences("depozit",Integer.toString(depozit));
                                     		SavePreferences("depoz_srok",Integer.toString(depoz_srok));
                                     	}
                                     	
                                     	//
                                     	final Random myBankRandom = new Random();
                                     	kredit_proc = myBankRandom.nextInt(19);
                                     	depoz_proc = myBankRandom.nextInt(9);
                                     	if (kredit_proc <=0){
                                     		kredit_proc =1;
                                     	}
                                     	if (depoz_proc <=0){
                                     		depoz_proc =1;
                                     	}
                                     	kredit_proc_tv.setText(Integer.toString(kredit_proc)+"%");
                                     	depoz_proc_tv.setText(Integer.toString(depoz_proc)+"%");
                                     	SavePreferences("kredit_proc",Integer.toString(kredit_proc));
                                    	SavePreferences("depoz_proc",Integer.toString(depoz_proc));
                                    	//
                                    	d_timer = 0;
                                    	mnt.setText("2Jan-");
                                    	m_timer=0;
                                    	SavePreferences("score",df.format(score));
                                    	SavePreferences("profit",df.format(profit));
                                    	SavePreferences("kredit",Integer.toString(kredit));
                                    	SavePreferences("depozit",Integer.toString(depozit));
                                    	SavePreferences("kredit_srok",Integer.toString(kredit));
                                    	SavePreferences("depoz_srok",Integer.toString(depozit));
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
	
	
	
	private void SavePreferences(String key, String value){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
        }
	
	@Override
	public void onPause() {
	    super.onPause();  // Always call the superclass method first
	    Log.w("Comers", "Pause");
	  
	}


	@Override
	public void onResume() {
	    super.onResume();
	    Log.w("Comers", "Resume");
	    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	    score = Double.parseDouble(sharedPreferences.getString("score", ""));
	    profit = Double.parseDouble(sharedPreferences.getString("profit", ""));
	    oil = Integer.parseInt(sharedPreferences.getString("oil", ""));
	    glebe = Integer.parseInt(sharedPreferences.getString("glebe", ""));
	    sales_g = Integer.parseInt(sharedPreferences.getString("sales_g", ""));
	    sales_o = Integer.parseInt(sharedPreferences.getString("sales_o", ""));
	    buyes_g = Integer.parseInt(sharedPreferences.getString("buyes_g", ""));
	    buyes_o = Integer.parseInt(sharedPreferences.getString("buyes_o", ""));
	    kredit = Integer.parseInt(sharedPreferences.getString("kredit", ""));
	    depozit = Integer.parseInt(sharedPreferences.getString("depozit", ""));
	    kredit_srok = Integer.parseInt(sharedPreferences.getString("kredit_srok", ""));
	    depoz_srok = Integer.parseInt(sharedPreferences.getString("depoz_srok", ""));
	    kredit_proc = Integer.parseInt(sharedPreferences.getString("kredit_proc", ""));
	    depoz_proc = Integer.parseInt(sharedPreferences.getString("depoz_proc", ""));
	    depoz_srok = Integer.parseInt(sharedPreferences.getString("depoz_srok", ""));
	    kredit_srok = Integer.parseInt(sharedPreferences.getString("kredit_srok", ""));
	    birthday = Integer.parseInt(sharedPreferences.getString("birthday", ""));
	    birthmonth = Integer.parseInt(sharedPreferences.getString("birthmonth", ""));
	    score_tv.setText(df.format(score));
	    profit_tv.setText(df.format(profit));
	    kredit_tv.setText(Integer.toString(kredit));
	    depozit_tv.setText(Integer.toString(depozit));
	    splashTime = 500;
	    }
	
@Override
public void onStop(){
	super.onStop();
	Log.w("Comers", "Stop");
	SavePreferences("score",df.format(score));
	SavePreferences("profit",df.format(profit));
	SavePreferences("oil",Integer.toString(oil));
	SavePreferences("glebe",Integer.toString(glebe));
	SavePreferences("sales_g",Integer.toString(sales_g));
	SavePreferences("sales_o",Integer.toString(sales_o));
	SavePreferences("buyes_g",Integer.toString(buyes_g));
	SavePreferences("buyes_o",Integer.toString(buyes_o));
	SavePreferences("kredit",Integer.toString(kredit));
	SavePreferences("depozit",Integer.toString(depozit));
	SavePreferences("kredit_srok",Integer.toString(kredit_srok));
	SavePreferences("depoz_srok",Integer.toString(depoz_srok));
	SavePreferences("birthday",Integer.toString(birthday));
	SavePreferences("birthmonth",Integer.toString(birthmonth));
	//SavePreferences("saldo_gb",df.format(saldo_gb));
//	SavePreferences("saldo_ob",df.format(saldo_ob));
	//SavePreferences("saldo_gs",df.format(saldo_gs));
	//SavePreferences("saldo_os",df.format(saldo_os));
	splashTime = 500000;
}

		@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//����������� � ���� ����� �����
		menu.add(0, MENU_QUIT_ID, 0, R.string.quit);
		menu.add(0,MENU_ABOUT_ID, 0, R.string.about);
		return super.onCreateOptionsMenu(menu);
		
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		//TODO Auto-generated method stub
		switch (item.getItemId()) {
		case MENU_QUIT_ID:
		//����� �� ����������
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
