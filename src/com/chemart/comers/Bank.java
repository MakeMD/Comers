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
	
	int srok;
	
	EditText EditDepozBank;
	EditText EditKreditBank;
	EditText EditSrok;
	double score, profit;
	int kredit,depozit,kredit_srok,depoz_srok,kredit_proc,depoz_proc;
	DecimalFormat df = new DecimalFormat("###########");
	
	

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.bank);
	SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	score = Double.parseDouble(sharedPreferences.getString("score", ""));
    profit = Double.parseDouble(sharedPreferences.getString("profit", ""));
    kredit = Integer.parseInt(sharedPreferences.getString("kredit", ""));
    depozit = Integer.parseInt(sharedPreferences.getString("depozit", ""));
    kredit_srok = Integer.parseInt(sharedPreferences.getString("kredit_srok", ""));
    depoz_srok = Integer.parseInt(sharedPreferences.getString("depoz_srok", ""));
    kredit_proc = Integer.parseInt(sharedPreferences.getString("kredit_proc", ""));
    depoz_proc = Integer.parseInt(sharedPreferences.getString("depoz_proc", ""));
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
						kredit = Integer.parseInt(sharedPreferences.getString("kredit", ""))+ Integer.parseInt(EditKreditBank.getText().toString());
						score = Integer.parseInt(getDefaults("score",this))+Integer.parseInt(EditKreditBank.getText().toString());	
						//kredit_srok = Integer.parseInt(sharedPreferences.getString("kredit_srok", ""));
						kredit_srok = Integer.parseInt(EditSrok.getText().toString());
						//score = score + (Integer.parseInt(getDefaults("score",this))+kredit);
					//profit = profit + (Integer.parseInt(getDefaults("score",this))+kredit);
					SavePreferences("score",df.format(score));
					 SavePreferences("profit",df.format(profit));
					 SavePreferences("kredit",Integer.toString(kredit));
					 SavePreferences("kredit_srok",Integer.toString(kredit_srok));
					 
					 Toast.makeText(getBaseContext(), "Вы взяли в кредит "+ EditKreditBank.getText().toString()+" гроблей", Toast.LENGTH_SHORT).show();
					
				}
				
				else{
					Toast.makeText(getBaseContext(), "Введите срок", Toast.LENGTH_SHORT).show();
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
					depozit = Integer.parseInt(sharedPreferences.getString("depozit", ""))+ Integer.parseInt(EditDepozBank.getText().toString());
					depoz_srok = Integer.parseInt(EditSrok.getText().toString());
					//score = score - Integer.parseInt(EditDepozBank.getText().toString());	
					score = Integer.parseInt(getDefaults("score",this))-Integer.parseInt(EditDepozBank.getText().toString());	
					//profit = profit - (Integer.parseInt(getDefaults("score",this))-depozit);
					 SavePreferences("score",df.format(score));
					 SavePreferences("profit",df.format(profit));
					 SavePreferences("depozit",Integer.toString(depozit));
					 SavePreferences("depoz_srok",Integer.toString(depoz_srok));
					 Toast.makeText(getBaseContext(), "Вы вложили "+ EditDepozBank.getText().toString()+" гроблей", Toast.LENGTH_SHORT).show();
				}
				else{
					Toast.makeText(getBaseContext(), "Введите срок", Toast.LENGTH_SHORT).show();
			}
				
			}
			else{
				Toast.makeText(getBaseContext(), "Введите сумму", Toast.LENGTH_SHORT).show();
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
