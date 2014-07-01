package com.chemart.comers;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Havings extends Activity {
	
	TextView apart_tv, car_tv, oil_tv, glebe_tv;
	EditText EditOil, EditGlebe; 
	String apart,car;
	double car_cost, apart_cost, score, profit, saldo_o,saldo_g,saldo_gs,saldo_os;
	int oil,glebe,sales_o,sales_g;
	DecimalFormat df = new DecimalFormat("###########");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.havings);
	apart_tv = (TextView) findViewById(R.id.textView2);
	car_tv = (TextView) findViewById(R.id.textView4);
	oil_tv = (TextView) findViewById(R.id.textView6);
	glebe_tv = (TextView) findViewById(R.id.textView8);
SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	saldo_os = Double.parseDouble(sharedPreferences.getString("saldo_os", ""));
	saldo_gs = Double.parseDouble(sharedPreferences.getString("saldo_gs", ""));    
	score = Double.parseDouble(sharedPreferences.getString("score", ""));
    profit = Double.parseDouble(sharedPreferences.getString("profit", ""));
	car_cost = Double.parseDouble(sharedPreferences.getString("car_cost", ""));
    apart_cost = Double.parseDouble(sharedPreferences.getString("apart_cost", ""));
 	oil = Integer.parseInt(getDefaults("oil",this));
 	glebe = Integer.parseInt(getDefaults("glebe",this));
 	apart = sharedPreferences.getString("APART", "");
    car = sharedPreferences.getString("CAR", "");
    sales_g = Integer.parseInt(sharedPreferences.getString("sales_g", ""));
    sales_o = Integer.parseInt(sharedPreferences.getString("sales_o", ""));
    apart_tv.setText(apart);
    car_tv.setText(car);
	oil_tv.setText(Integer.toString(oil)+" "+"бар.");
	glebe_tv.setText(Integer.toString(glebe)+" "+"акр");
	EditOil = (EditText) findViewById(R.id.editText1);
	EditGlebe = (EditText) findViewById(R.id.editText2);
	}
	
	public void onRadioClick(View v) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		SharedPreferences.Editor editor = sharedPreferences.edit();
		Intent soldIntent = new Intent(Havings.this, MainActivity.class);
		switch (v.getId()) 
		{
		case R.id.radioButton1:
			Toast.makeText(getBaseContext(), "Вы продали "+apart+" +"+df.format(apart_cost) +"гроблей", Toast.LENGTH_SHORT).show();
	        score = score + apart_cost;
			profit= profit + apart_cost;
			apart = "";
			//apart_tv.setText(apart);
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("APART", apart);
	        editor.commit();
	        
	        
	        break;
		
		case R.id.radioButton2:
			Toast.makeText(getBaseContext(), "Вы продали "+car+" +"+df.format(car_cost) +"гроблей", Toast.LENGTH_SHORT).show();
			score = score + car_cost;
			profit= profit + car_cost;
			car = "";
	        //car_tv.setText(car);
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("CAR", car);
	        editor.commit();
	        break;
	        
		case R.id.radioButton3:
			if(oil>0 && EditOil.getText().toString() != null){
			//oil = Integer.parseInt(getDefaults("oil",this))+100;
			oil = oil - Integer.parseInt(EditOil.getText().toString());
				oil_tv.setText(Integer.toString(oil)+" "+"бар.");
				score = score + (oil*(Integer.parseInt(getDefaults("oil_cost",this))));
				profit = profit + (oil*(Integer.parseInt(getDefaults("oil_cost",this))));
				saldo_o = profit;
				saldo_os = saldo_o;
				Toast.makeText(getBaseContext(), "Вы продали "+ EditOil.getText().toString()+" барелей нефти", Toast.LENGTH_SHORT).show();
				SavePreferences("score",df.format(score));
				SavePreferences("profit",df.format(profit));
				SavePreferences("oil",Integer.toString(oil));
				SavePreferences("sales_o",EditOil.getText().toString());
				SavePreferences("saldo_os",df.format(saldo_os));
								 
			}
			else{
					Toast.makeText(getBaseContext(), "Недостаточно ресурсов для продажи", Toast.LENGTH_SHORT).show();
			    		
	}
			break;
		case R.id.radioButton4:
			if(glebe>0 && EditGlebe.getText().toString() != null){
				glebe = glebe - Integer.parseInt(EditGlebe.getText().toString());
				glebe_tv.setText(Integer.toString(glebe)+" "+"акр");
				score = score + (glebe*(Integer.parseInt(getDefaults("glebe_cost",this))));
				 profit = profit + (glebe*(Integer.parseInt(getDefaults("glebe_cost",this))));
				saldo_g = profit;
				saldo_gs = saldo_g;
				Toast.makeText(getBaseContext(), "Вы продали "+ EditGlebe.getText().toString()+" акров земли", Toast.LENGTH_SHORT).show(); 
				SavePreferences("score",df.format(score));
				 SavePreferences("profit",df.format(profit));
				 SavePreferences("glebe",Integer.toString(glebe));
				 SavePreferences("sales_g",EditGlebe.getText().toString());
				 SavePreferences("saldo_gs",df.format(saldo_gs));
				 
			}
			else{
				Toast.makeText(getBaseContext(), "Недостаточно ресурсов для продажи", Toast.LENGTH_SHORT).show();
			}
			
		default:
			break;
		}
		setResult(RESULT_OK, soldIntent);
		finish();	
	}
	public static String getDefaults(String key, Context context) {
	    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
	    return preferences.getString(key, null);
	}
	private void SavePreferences(String key, String value){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
        }
	@Override
	public void onStop(){
		super.onStop();
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	return super.onCreateOptionsMenu(menu);

	}		
	}
