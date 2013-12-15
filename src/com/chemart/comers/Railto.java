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
	TextView g_tv_jan,g_tv_feb,g_tv_mar,g_tv_apr,g_tv_may,g_tv_jun,g_tv_jul,g_tv_aug,g_tv_sep,g_tv_oct,g_tv_nov,g_tv_dec;
	TextView o_tv_jan,o_tv_feb,o_tv_mar,o_tv_apr,o_tv_may,o_tv_jun,o_tv_jul,o_tv_aug,o_tv_sep,o_tv_oct,o_tv_nov,o_tv_dec;
	int oil, glebe;
	int glebe_c, oil_c;
	int month_now;
	String g_jan, g_feb,g_mar,g_apr,g_may,g_jun,g_jul,g_aug,g_sep,g_oct,g_nov,g_dec;
	String o_jan, o_feb,o_mar,o_apr,o_may,o_jun,o_jul,o_aug,o_sep,o_oct,o_nov,o_dec;
	DecimalFormat df = new DecimalFormat("###########");

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	setContentView(R.layout.railto);
	month_now = Integer.parseInt(getDefaults("month_now",this));
	g_tv_jan = (TextView) findViewById(R.id.textView13);
	g_tv_feb = (TextView) findViewById(R.id.TextView01);
	g_tv_mar = (TextView) findViewById(R.id.TextView03);
	g_tv_apr = (TextView) findViewById(R.id.TextView06);
	g_tv_may = (TextView) findViewById(R.id.TextView07);
	g_tv_jun = (TextView) findViewById(R.id.TextView10);
	g_tv_jul = (TextView) findViewById(R.id.TextView11);
	g_tv_aug = (TextView) findViewById(R.id.TextView14);
	g_tv_sep = (TextView) findViewById(R.id.TextView15);
	g_tv_oct = (TextView) findViewById(R.id.TextView18);
	g_tv_nov = (TextView) findViewById(R.id.TextView19);
	g_tv_dec = (TextView) findViewById(R.id.TextView22);
	glebe_tv = (TextView) findViewById(R.id.textView25);
	
	o_tv_jan = (TextView) findViewById(R.id.TextView02);
	o_tv_feb = (TextView) findViewById(R.id.textView14);
	o_tv_mar = (TextView) findViewById(R.id.TextView05);
	o_tv_apr = (TextView) findViewById(R.id.TextView04);
	o_tv_may = (TextView) findViewById(R.id.TextView09);
	o_tv_jun = (TextView) findViewById(R.id.TextView08);
	o_tv_jul = (TextView) findViewById(R.id.TextView13);
	o_tv_aug = (TextView) findViewById(R.id.TextView12);
	o_tv_sep = (TextView) findViewById(R.id.TextView17);
	o_tv_oct = (TextView) findViewById(R.id.TextView16);
	o_tv_nov = (TextView) findViewById(R.id.TextView20);
	o_tv_dec = (TextView) findViewById(R.id.TextView21);
	oil_tv = (TextView) findViewById(R.id.textView26);
	switch(month_now){
	case 0:
		glebe_tv_c = g_tv_jan;
		g_jan = getDefaults("glebe_cost", this);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		glebe_tv.setText(getDefaults("glebe_cost", this)+" за акр");
		
		oil_tv_c = o_tv_jan;
		o_jan = getDefaults("oil_cost", this);
		oil_tv_c.setText(getDefaults("oil_cost", this));
		oil_tv.setText(getDefaults("oil_cost", this)+" за барель");
		break;
	case 1:
		g_tv_jan.setText(getDefaults("g_jan",this));
		glebe_tv_c = g_tv_feb;
		g_feb = getDefaults("glebe_cost", this);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		glebe_tv.setText(getDefaults("glebe_cost", this)+" за акр");
		
		o_tv_jan.setText(getDefaults("o_jan",this));
		oil_tv_c = o_tv_feb;
		o_feb = getDefaults("oil_cost", this);
		oil_tv_c.setText(getDefaults("oil_cost", this));
		oil_tv.setText(getDefaults("oil_cost", this)+" за барель");
		break;
	case 2:
		g_tv_jan.setText(getDefaults("g_jan",this));
		g_tv_feb.setText(getDefaults("g_feb",this));
		glebe_tv_c = g_tv_mar;
		g_mar = getDefaults("glebe_cost", this);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		glebe_tv.setText(getDefaults("glebe_cost", this)+" за акр");

		o_tv_jan.setText(getDefaults("o_jan",this));
		o_tv_feb.setText(getDefaults("o_feb",this));
		oil_tv_c = o_tv_mar;
		o_mar = getDefaults("oil_cost", this);
		oil_tv_c.setText(getDefaults("oil_cost", this));
		oil_tv.setText(getDefaults("oil_cost", this)+" за барель");
		break;
	case 3:
		g_tv_jan.setText(getDefaults("g_jan",this));
		g_tv_feb.setText(getDefaults("g_feb",this));
		g_tv_mar.setText(getDefaults("g_mar",this));
		glebe_tv_c = g_tv_apr;
		g_apr = getDefaults("glebe_cost", this);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		glebe_tv.setText(getDefaults("glebe_cost", this)+" за акр");
		
		o_tv_jan.setText(getDefaults("o_jan",this));
		o_tv_feb.setText(getDefaults("o_feb",this));
		o_tv_mar.setText(getDefaults("o_mar",this));
		oil_tv_c = o_tv_mar;
		o_mar = getDefaults("oil_cost", this);
		oil_tv_c.setText(getDefaults("oil_cost", this));
		oil_tv.setText(getDefaults("oil_cost", this)+" за барель");
		break;
	case 4:
		g_tv_jan.setText(getDefaults("g_jan",this));
		g_tv_feb.setText(getDefaults("g_feb",this));
		g_tv_mar.setText(getDefaults("g_mar",this));
		g_tv_apr.setText(getDefaults("g_apr",this));
		glebe_tv_c = g_tv_may;
		g_may = getDefaults("glebe_cost", this);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		glebe_tv.setText(getDefaults("glebe_cost", this)+" за акр");
		
		o_tv_jan.setText(getDefaults("o_jan",this));
		o_tv_feb.setText(getDefaults("o_feb",this));
		o_tv_mar.setText(getDefaults("o_mar",this));
		o_tv_apr.setText(getDefaults("o_apr",this));
		oil_tv_c = o_tv_mar;
		o_mar = getDefaults("oil_cost", this);
		oil_tv_c.setText(getDefaults("oil_cost", this));
		oil_tv.setText(getDefaults("oil_cost", this)+" за барель");
		break;
	case 5:
		g_tv_jan.setText(getDefaults("g_jan",this));
		g_tv_feb.setText(getDefaults("g_feb",this));
		g_tv_mar.setText(getDefaults("g_mar",this));
		g_tv_apr.setText(getDefaults("g_apr",this));
		g_tv_may.setText(getDefaults("g_may",this));
		glebe_tv_c = g_tv_jun;
		g_jun = getDefaults("glebe_cost", this);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		glebe_tv.setText(getDefaults("glebe_cost", this)+" за акр");
		
		o_tv_jan.setText(getDefaults("o_jan",this));
		o_tv_feb.setText(getDefaults("o_feb",this));
		o_tv_mar.setText(getDefaults("o_mar",this));
		o_tv_apr.setText(getDefaults("o_apr",this));
		o_tv_may.setText(getDefaults("o_may",this));
		oil_tv_c = o_tv_mar;
		o_mar = getDefaults("oil_cost", this);
		oil_tv_c.setText(getDefaults("oil_cost", this));
		oil_tv.setText(getDefaults("oil_cost", this)+" за барель");
		break;
	case 6:
		g_tv_jan.setText(getDefaults("g_jan",this));
		g_tv_feb.setText(getDefaults("g_feb",this));
		g_tv_mar.setText(getDefaults("g_mar",this));
		g_tv_apr.setText(getDefaults("g_apr",this));
		g_tv_may.setText(getDefaults("g_may",this));
		g_tv_jun.setText(getDefaults("g_jun",this));
		glebe_tv_c = g_tv_jul;
		g_jul = getDefaults("glebe_cost", this);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		glebe_tv.setText(getDefaults("glebe_cost", this)+" за акр");
	
		o_tv_jan.setText(getDefaults("o_jan",this));
		o_tv_feb.setText(getDefaults("o_feb",this));
		o_tv_mar.setText(getDefaults("o_mar",this));
		o_tv_apr.setText(getDefaults("o_apr",this));
		o_tv_may.setText(getDefaults("o_may",this));
		o_tv_jun.setText(getDefaults("o_jun",this));
		oil_tv_c = o_tv_mar;
		o_mar = getDefaults("oil_cost", this);
		oil_tv_c.setText(getDefaults("oil_cost", this));
		oil_tv.setText(getDefaults("oil_cost", this)+" за барель");
		break;
	case 7:
		g_tv_jan.setText(getDefaults("g_jan",this));
		g_tv_feb.setText(getDefaults("g_feb",this));
		g_tv_mar.setText(getDefaults("g_mar",this));
		g_tv_apr.setText(getDefaults("g_apr",this));
		g_tv_may.setText(getDefaults("g_may",this));
		g_tv_jun.setText(getDefaults("g_jun",this));
		g_tv_jul.setText(getDefaults("g_jul",this));
		glebe_tv_c = g_tv_aug;
		g_aug = getDefaults("glebe_cost", this);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		glebe_tv.setText(getDefaults("glebe_cost", this)+" за акр");
		
		o_tv_jan.setText(getDefaults("o_jan",this));
		o_tv_feb.setText(getDefaults("o_feb",this));
		o_tv_mar.setText(getDefaults("o_mar",this));
		o_tv_apr.setText(getDefaults("o_apr",this));
		o_tv_may.setText(getDefaults("o_may",this));
		o_tv_jun.setText(getDefaults("o_jun",this));
		o_tv_jul.setText(getDefaults("o_jul",this));
		oil_tv_c = o_tv_mar;
		o_mar = getDefaults("oil_cost", this);
		oil_tv_c.setText(getDefaults("oil_cost", this));
		oil_tv.setText(getDefaults("oil_cost", this)+" за барель");
		break;
	case 8:
		g_tv_jan.setText(getDefaults("g_jan",this));
		g_tv_feb.setText(getDefaults("g_feb",this));
		g_tv_mar.setText(getDefaults("g_mar",this));
		g_tv_apr.setText(getDefaults("g_apr",this));
		g_tv_may.setText(getDefaults("g_may",this));
		g_tv_jun.setText(getDefaults("g_jun",this));
		g_tv_jul.setText(getDefaults("g_jul",this));
		g_tv_aug.setText(getDefaults("g_aug",this));
		glebe_tv_c = g_tv_sep;
		g_sep = getDefaults("glebe_cost", this);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		glebe_tv.setText(getDefaults("glebe_cost", this)+" за акр");
		
		o_tv_jan.setText(getDefaults("o_jan",this));
		o_tv_feb.setText(getDefaults("o_feb",this));
		o_tv_mar.setText(getDefaults("o_mar",this));
		o_tv_apr.setText(getDefaults("o_apr",this));
		o_tv_may.setText(getDefaults("o_may",this));
		o_tv_jun.setText(getDefaults("o_jun",this));
		o_tv_jul.setText(getDefaults("o_jul",this));
		o_tv_aug.setText(getDefaults("o_aug",this));
		oil_tv_c = o_tv_mar;
		o_mar = getDefaults("oil_cost", this);
		oil_tv_c.setText(getDefaults("oil_cost", this));
		oil_tv.setText(getDefaults("oil_cost", this)+" за барель");
		break;
	case 9:
		g_tv_jan.setText(getDefaults("g_jan",this));
		g_tv_feb.setText(getDefaults("g_feb",this));
		g_tv_mar.setText(getDefaults("g_mar",this));
		g_tv_apr.setText(getDefaults("g_apr",this));
		g_tv_may.setText(getDefaults("g_may",this));
		g_tv_jun.setText(getDefaults("g_jun",this));
		g_tv_jul.setText(getDefaults("g_jul",this));
		g_tv_aug.setText(getDefaults("g_aug",this));
		g_tv_sep.setText(getDefaults("g_sep",this));
		glebe_tv_c = g_tv_oct;
		g_oct = getDefaults("glebe_cost", this);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		glebe_tv.setText(getDefaults("glebe_cost", this)+" за акр");
		
		o_tv_jan.setText(getDefaults("o_jan",this));
		o_tv_feb.setText(getDefaults("o_feb",this));
		o_tv_mar.setText(getDefaults("o_mar",this));
		o_tv_apr.setText(getDefaults("o_apr",this));
		o_tv_may.setText(getDefaults("o_may",this));
		o_tv_jun.setText(getDefaults("o_jun",this));
		o_tv_jul.setText(getDefaults("o_jul",this));
		o_tv_aug.setText(getDefaults("o_aug",this));
		o_tv_sep.setText(getDefaults("o_sep",this));
		oil_tv_c = o_tv_mar;
		o_mar = getDefaults("oil_cost", this);
		oil_tv_c.setText(getDefaults("oil_cost", this));
		oil_tv.setText(getDefaults("oil_cost", this)+" за барель");
		break;
	case 10:
		g_tv_jan.setText(getDefaults("g_jan",this));
		g_tv_feb.setText(getDefaults("g_feb",this));
		g_tv_mar.setText(getDefaults("g_mar",this));
		g_tv_apr.setText(getDefaults("g_apr",this));
		g_tv_may.setText(getDefaults("g_may",this));
		g_tv_jun.setText(getDefaults("g_jun",this));
		g_tv_jul.setText(getDefaults("g_jul",this));
		g_tv_aug.setText(getDefaults("g_aug",this));
		g_tv_sep.setText(getDefaults("g_sep",this));
		g_tv_oct.setText(getDefaults("g_oct",this));
		glebe_tv_c = g_tv_nov;
		g_nov = getDefaults("glebe_cost", this);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		glebe_tv.setText(getDefaults("glebe_cost", this)+" за акр");
		
		o_tv_jan.setText(getDefaults("o_jan",this));
		o_tv_feb.setText(getDefaults("o_feb",this));
		o_tv_mar.setText(getDefaults("o_mar",this));
		o_tv_apr.setText(getDefaults("o_apr",this));
		o_tv_may.setText(getDefaults("o_may",this));
		o_tv_jun.setText(getDefaults("o_jun",this));
		o_tv_jul.setText(getDefaults("o_jul",this));
		o_tv_aug.setText(getDefaults("o_aug",this));
		o_tv_sep.setText(getDefaults("o_sep",this));
		o_tv_oct.setText(getDefaults("o_oct",this));
		oil_tv_c = o_tv_mar;
		o_mar = getDefaults("oil_cost", this);
		oil_tv_c.setText(getDefaults("oil_cost", this));
		oil_tv.setText(getDefaults("oil_cost", this)+" за барель");
		break;
	case 11:
		g_tv_jan.setText(getDefaults("g_jan",this));
		g_tv_feb.setText(getDefaults("g_feb",this));
		g_tv_mar.setText(getDefaults("g_mar",this));
		g_tv_apr.setText(getDefaults("g_apr",this));
		g_tv_may.setText(getDefaults("g_may",this));
		g_tv_jun.setText(getDefaults("g_jun",this));
		g_tv_jul.setText(getDefaults("g_jul",this));
		g_tv_aug.setText(getDefaults("g_aug",this));
		g_tv_sep.setText(getDefaults("g_sep",this));
		g_tv_oct.setText(getDefaults("g_oct",this));
		g_tv_nov.setText(getDefaults("g_nov",this));
		glebe_tv_c = g_tv_dec;
		g_dec = getDefaults("glebe_cost", this);
		glebe_tv_c.setText(getDefaults("glebe_cost", this));
		glebe_tv.setText(getDefaults("glebe_cost", this)+" за акр");
		
		o_tv_jan.setText(getDefaults("o_jan",this));
		o_tv_feb.setText(getDefaults("o_feb",this));
		o_tv_mar.setText(getDefaults("o_mar",this));
		o_tv_apr.setText(getDefaults("o_apr",this));
		o_tv_may.setText(getDefaults("o_may",this));
		o_tv_jun.setText(getDefaults("o_jun",this));
		o_tv_jul.setText(getDefaults("o_jul",this));
		o_tv_aug.setText(getDefaults("o_aug",this));
		o_tv_sep.setText(getDefaults("o_sep",this));
		o_tv_oct.setText(getDefaults("o_oct",this));
		o_tv_nov.setText(getDefaults("o_nov",this));
		oil_tv_c = o_tv_mar;
		o_mar = getDefaults("oil_cost", this);
		oil_tv_c.setText(getDefaults("oil_cost", this));
		oil_tv.setText(getDefaults("oil_cost", this)+" за барель");
		break;
	}
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
}
