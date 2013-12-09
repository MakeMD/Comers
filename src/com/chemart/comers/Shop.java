package com.chemart.comers;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Shop extends Activity {
	double score,profit;
	String str;
	DecimalFormat df = new DecimalFormat("###########");

    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shop);
		  SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		     score = Double.parseDouble(sharedPreferences.getString("score", ""));
		     profit = Double.parseDouble(sharedPreferences.getString("profit", ""));
		     //Toast.makeText(getBaseContext(), df.format(score), Toast.LENGTH_SHORT).show();
	}
	public static String getDefaults(String key, Context context) {
	    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
	    return preferences.getString(key, null);
	}
	public void onRadioClick(View v) {
		SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		SharedPreferences.Editor editor = sharedPreferences.edit();
		Intent shopIntent = new Intent(Shop.this,MainActivity.class);
		switch (v.getId()) 
		{
		
		case R.id.radioButton1:
			score = score - 7620;
			profit = profit - 7620;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("CAR","ЛуАЗ");
	        editor.commit();
			Toast.makeText(getBaseContext(), "Вы купили Луаз! -7620 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton5:
			score = score - 23827;
			profit = profit - 23827;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("CAR","Москвич");
	        editor.commit();
			Toast.makeText(getBaseContext(), "Вы купили Москвич! -23827 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton7:
			score = score - 30603;
			profit = profit - 30603;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("CAR","Ваз 2106");
	        editor.commit();
			Toast.makeText(getBaseContext(), "Вы купили Ваз 2106! -30603 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton9:
			score = score - 44269;
			profit = profit - 44269;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("CAR","Ваз 2109");
	        editor.commit();
			Toast.makeText(getBaseContext(), "Вы купили Ваз 2109! -44269 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton13:
			score = score - 74879;
			profit = profit - 74879;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("CAR","Газ 3102");
	        editor.commit();
	        Toast.makeText(getBaseContext(), "Вы купили Газ 3102! -74879 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton2:
			score = score - 8304;
			profit = profit - 8304;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("APART","1 -комн.");
	        editor.commit();
			Toast.makeText(getBaseContext(), "Вы купили 1-комнатную квартиру! -8304 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton4:
			score = score - 17286;
			profit = profit - 17286;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("APART","2 -комн.");
	        editor.commit();
			Toast.makeText(getBaseContext(), "Вы купили 2-комнатную квартиру! -17286 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton6:
			score = score - 18934;
			profit = profit - 18934;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("APART","3 -комн.");
	        editor.commit();
	        Toast.makeText(getBaseContext(), "Вы купили 3-комнатную квартиру! -18934 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton8:
			score = score - 34304;
			profit = profit - 34304;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("APART","4 -комн.");
	        editor.commit();
	        Toast.makeText(getBaseContext(), "Вы купили 4-комнатную квартиру! -34304 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton10:
			score = score - 34574;
			profit = profit - 34574;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("APART","5 -комн.");
	        editor.commit();
			Toast.makeText(getBaseContext(), "Вы купили 5-комнатную квартиру! -34574 гроблей", Toast.LENGTH_SHORT).show();
			break;
			
		default:
			break;
		}
		setResult(RESULT_OK, shopIntent);
		finish();
		
	}
@Override
public void onStop(){
	super.onStop();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shop, menu);
		return true;
	}

}
