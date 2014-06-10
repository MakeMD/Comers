package com.chemart.comers;

import java.io.IOException;
import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bank extends Activity {
	
	TextView oil_tv,glebe_tv,oil_tv_c,glebe_tv_c;
	TextView g_tv_jan,g_tv_feb,g_tv_mar,g_tv_apr,g_tv_may,g_tv_jun,g_tv_jul,g_tv_aug,g_tv_sep,g_tv_oct,g_tv_nov,g_tv_dec;
	TextView o_tv_jan,o_tv_feb,o_tv_mar,o_tv_apr,o_tv_may,o_tv_jun,o_tv_jul,o_tv_aug,o_tv_sep,o_tv_oct,o_tv_nov,o_tv_dec;
	int oil, glebe;
	int glebe_c, oil_c;
	int month_now;
	int buyes_g,buyes_o;
	int buyes_g1;
	int srok;
	String g_jan, g_feb,g_mar,g_apr,g_may,g_jun,g_jul,g_aug,g_sep,g_oct,g_nov,g_dec;
	String o_jan, o_feb,o_mar,o_apr,o_may,o_jun,o_jul,o_aug,o_sep,o_oct,o_nov,o_dec;
	
	EditText EditDepozBank;
	EditText EditKreditBank;
	EditText EditSrok;
	double score, profit,saldo_o,saldo_g, saldo_ob, saldo_gb;
	DecimalFormat df = new DecimalFormat("###########");
	
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.bank);
	SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	score = Double.parseDouble(sharedPreferences.getString("score", ""));
    profit = Double.parseDouble(sharedPreferences.getString("profit", ""));
    EditDepozBank = (EditText) findViewById(R.id.editText1);
	EditKreditBank = (EditText) findViewById(R.id.editText2);
	EditSrok = (EditText) findViewById(R.id.editText3);
	}
	public void onRadioClick(View v){
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		SharedPreferences.Editor editor = sharedPreferences.edit();
		Intent buyIntent = new Intent(Bank.this, MainActivity.class);
		switch (v.getId()) 
		{
		case R.id.radioButton2:
			try{
				if (EditSrok.getText().toString()   != null){
					if(EditKreditBank.getText().toString() != null){
				score = Integer.parseInt(getDefaults("score",this))+Integer.parseInt(EditKreditBank.getText().toString());	
				
				score = score + (Integer.parseInt(getDefaults("score",this))+Integer.parseInt(EditKreditBank.getText().toString()));
					profit = profit + (Integer.parseInt(getDefaults("score",this))+Integer.parseInt(EditKreditBank.getText().toString()));
					SavePreferences("score",df.format(score));
					 SavePreferences("profit",df.format(profit));
					 Toast.makeText(getBaseContext(), "Вы взяли в кредит "+ EditKreditBank.getText().toString()+" гроблей", Toast.LENGTH_SHORT).show();
					
				}
				
				else{
					Toast.makeText(getBaseContext(), "Введите сумму", Toast.LENGTH_SHORT).show();
				}
			
				}
					}
				
			  catch(NumberFormatException e) 
              {
                  	e.printStackTrace();
                  	Toast.makeText(getBaseContext(), "Введите сумму", Toast.LENGTH_SHORT).show();
        			}
		break;
		
		case R.id.radioButton1:
			try{
			
			if (EditSrok.getText().toString() != null){
				if(EditDepozBank.getText().toString() != null){
				
				score = score - Integer.parseInt(EditDepozBank.getText().toString());	
					score = score - (Integer.parseInt(getDefaults("score",this))-Integer.parseInt(EditDepozBank.getText().toString()));
					profit = profit - (Integer.parseInt(getDefaults("score",this))-Integer.parseInt(EditDepozBank.getText().toString()));
					 SavePreferences("score",df.format(score));
					 SavePreferences("profit",df.format(profit));
					 Toast.makeText(getBaseContext(), "Вы вложили "+ EditDepozBank.getText().toString()+" гроблей", Toast.LENGTH_SHORT).show();
				}
				else{
			}
				
			}
			else{
				Toast.makeText(getBaseContext(), "Введите срок", Toast.LENGTH_SHORT).show();
		}
			
	//	default:
			}
			  catch(NumberFormatException e) 
              {
                  	e.printStackTrace();
                  	Toast.makeText(getBaseContext(), "Введите сумму", Toast.LENGTH_SHORT).show();
        			}
			break;
		}
		setResult(RESULT_OK, buyIntent);
		finish();
	}
	
	private void SavePreferences(String key, String value){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
        }
	public static String getDefaults(String key, Context context) {
	    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
	    return preferences.getString(key, null);
	}
	@Override
	public void onStop(){
		super.onStop();
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bank, menu);
		return true;
	}	
}
