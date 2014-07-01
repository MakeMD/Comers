package com.chemart.comers;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.widget.TextView;

public class Secret extends Activity {

	double score,profit,saldo_os,saldo_gs,saldo_ob,saldo_gb,saldo_o,saldo_g;
	int oil,glebe,energo;
	int sales_g,buyes_g,sales_o,buyes_o;
	String birth;
	TextView energo_tv,birth_tv,sales_o_tv,sales_g_tv,buyes_o_tv,buyes_g_tv,saldo_o_tv,saldo_g_tv;
	DecimalFormat df = new DecimalFormat("###########");
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secret);
		score = Double.parseDouble(getDefaults("score",this));
		profit = Double.parseDouble(getDefaults("profit",this));
		oil = Integer.parseInt(getDefaults("oil",this));
		glebe = Integer.parseInt(getDefaults("glebe",this));
		sales_g = sales_g + Integer.parseInt(getDefaults("sales_g",this));
		sales_o = sales_o + Integer.parseInt(getDefaults("sales_o",this));
		buyes_g = buyes_g + Integer.parseInt(getDefaults("buyes_g",this));
		buyes_o = buyes_o + Integer.parseInt(getDefaults("buyes_o",this));
		saldo_o = saldo_o + (Double.parseDouble(getDefaults("saldo_ob",this))+Double.parseDouble(getDefaults("saldo_os",this)));
		saldo_g = saldo_g + (Double.parseDouble(getDefaults("saldo_gb",this))+Double.parseDouble(getDefaults("saldo_gs",this)));
		//
		energo_tv = (TextView) findViewById(R.id.textView2);
		birth_tv = (TextView) findViewById(R.id.textView4);
		sales_g_tv = (TextView) findViewById(R.id.textView14);
		sales_o_tv = (TextView) findViewById(R.id.textView10);
		buyes_g_tv = (TextView) findViewById(R.id.textView13);
		buyes_o_tv = (TextView) findViewById(R.id.textView9);
		saldo_o_tv = (TextView) findViewById(R.id.textView11);
		saldo_g_tv = (TextView) findViewById(R.id.textView15);
		//
	
		sales_g_tv.setText(Integer.toString(sales_g));
		sales_o_tv.setText(Integer.toString(sales_o));
		buyes_g_tv.setText(Integer.toString(buyes_g));
		buyes_o_tv.setText(Integer.toString(buyes_o));
		saldo_o_tv.setText(df.format(saldo_o));
		saldo_g_tv.setText(df.format(saldo_g));
		
		//
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
			// Inflate the menu; this adds items to the action bar if it is present.
			
			return true;
		}
}
