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
	double score,profit, car_cost=0, apart_cost=0;
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
			car_cost = 7620;
			score = score - car_cost;
			profit = profit - car_cost;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("CAR","����");
	        editor.putString("car_cost", df.format(car_cost));
	        editor.commit();
			Toast.makeText(getBaseContext(), "�� ������ ����! -7620 �������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton5:
			car_cost = 23827;
			score = score - car_cost;
			profit = profit - car_cost;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("CAR","�������");
	        editor.putString("car_cost", df.format(car_cost));
	        editor.commit();
			Toast.makeText(getBaseContext(), "�� ������ �������! -23827 �������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton7:
			car_cost = 30603;
			score = score - car_cost;
			profit = profit - car_cost;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("CAR","��� 2106");
	        editor.putString("car_cost", df.format(car_cost));
	        editor.commit();
			Toast.makeText(getBaseContext(), "�� ������ ��� 2106! -30603 �������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton9:
			car_cost = 44269;
			score = score - car_cost;
			profit = profit - car_cost;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("CAR","��� 2109");
	        editor.putString("car_cost", df.format(car_cost));
	        editor.commit();
			Toast.makeText(getBaseContext(), "�� ������ ��� 2109! -44269 �������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton13:
			car_cost = 74879;
			score = score - car_cost;
			profit = profit - car_cost;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("CAR","��� 3102");
	        editor.putString("car_cost", df.format(car_cost));
	        editor.commit();
	        Toast.makeText(getBaseContext(), "�� ������ ��� 3102! -74879 �������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton2:
			apart_cost = 8304;
			score = score - apart_cost;
			profit = profit - apart_cost;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("APART","1 -����.");
	        editor.putString("apart_cost", df.format(apart_cost));
	        editor.commit();
			Toast.makeText(getBaseContext(), "�� ������ 1-��������� ��������! -8304 �������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton4:
			apart_cost = 17286;
			score = score - apart_cost;
			profit = profit - apart_cost;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("APART","2 -����.");
	        editor.putString("apart_cost", df.format(apart_cost));
	        editor.commit();
			Toast.makeText(getBaseContext(), "�� ������ 2-��������� ��������! -17286 �������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton6:
			apart_cost = 18934;
			score = score - apart_cost;
			profit = profit - apart_cost;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("APART","3 -����.");
	        editor.putString("apart_cost", df.format(apart_cost));
	        editor.commit();
	        Toast.makeText(getBaseContext(), "�� ������ 3-��������� ��������! -18934 �������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton8:
			apart_cost = 34304;
			score = score - apart_cost;
			profit = profit - apart_cost;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("APART","4 -����.");
	        editor.putString("apart_cost", df.format(apart_cost));
	        editor.commit();
	        Toast.makeText(getBaseContext(), "�� ������ 4-��������� ��������! -34304 �������", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton10:
			apart_cost = 34574;
			score = score - apart_cost;
			profit = profit - apart_cost;
			editor.putString("profit", df.format(profit));
	        editor.putString("score", df.format(score));
	        editor.putString("APART","5 -����.");
	        editor.putString("apart_cost", df.format(apart_cost));
	        editor.commit();
			Toast.makeText(getBaseContext(), "�� ������ 5-��������� ��������! -34574 �������", Toast.LENGTH_SHORT).show();
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
