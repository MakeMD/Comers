package com.chemart.comers;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class Railto extends Activity {
	
	TextView oil_tv,glebe_tv,oil_tv_c,glebe_tv_c;
	int oil, glebe;
	int glebe_c, oil_c;
	int month_now;
	DecimalFormat df = new DecimalFormat("###########");

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.railto);
	month_now = Integer.parseInt(getDefaults("month_now",this));
	switch(month_now){
	case 0:
		glebe_tv_c = (TextView) findViewById(R.id.textView13);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		break;
	case 1:
		glebe_tv_c = (TextView) findViewById(R.id.TextView01);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		break;
	case 2:
		glebe_tv_c = (TextView) findViewById(R.id.TextView03);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		break;
	case 3:
		glebe_tv_c = (TextView) findViewById(R.id.TextView06);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		break;
	case 4:
		glebe_tv_c = (TextView) findViewById(R.id.TextView07);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		break;
	case 5:
		glebe_tv_c = (TextView) findViewById(R.id.TextView10);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		break;
	case 6:
		glebe_tv_c = (TextView) findViewById(R.id.TextView11);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		break;
	case 7:
		glebe_tv_c = (TextView) findViewById(R.id.TextView14);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		break;
	case 8:
		glebe_tv_c = (TextView) findViewById(R.id.TextView15);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		break;
	case 9:
		glebe_tv_c = (TextView) findViewById(R.id.TextView18);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		break;
	case 10:
		glebe_tv_c = (TextView) findViewById(R.id.TextView19);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		break;
	case 11:
		glebe_tv_c = (TextView) findViewById(R.id.textView22);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		break;
	}
	}
	public static String getDefaults(String key, Context context) {
	    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
	    return preferences.getString(key, null);
	}
}
