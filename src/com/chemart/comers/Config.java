package com.chemart.comers;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class Config extends Activity {
	double score_conf= 53657.00;
	double profit_conf = 137.00;
	double income_tax_conf = 0.98;
	double land_rent_conf = 0.98;
	double house_rent_conf = 0.71;
	double car_cost,apart_cost;
	String car,apart;
	int splashTime = 500;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.config);
		//score = getIntent().getExtras().getDouble("score");
		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra("score_conf", score_conf);
		intent.putExtra("profit_conf", profit_conf);
		intent.putExtra("income_tax_conf", income_tax_conf);
		intent.putExtra("land_rent_conf", land_rent_conf);
		intent.putExtra("house_rent_conf", house_rent_conf);
		intent.putExtra("splashTime", splashTime);
		//car_cost = getIntent().getExtras().getDouble("CAR_COST");
		//car = getIntent().getExtras().getString("CAR");
		//apart_cost = getIntent().getExtras().getDouble("APART_COST");
		//apart = getIntent().getExtras().getString("APART");
		
		startActivity(intent);
	finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.config, menu);
		return true;
	}

}
