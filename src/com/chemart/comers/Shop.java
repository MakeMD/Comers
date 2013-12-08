package com.chemart.comers;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class Shop extends Activity {
	double score;
	//public final static String CAR="";
	//public final static int CAR_COST = 0;
	int splashTime = 2000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shop);
	
		}
	
	public void onRadioClick(View v) {
		
		Intent shopIntent = new Intent(Shop.this,MainActivity.class);
		Intent config_Intent = new Intent(Shop.this, Config.class);
		Intent conf_intent = getIntent();
		
		switch (v.getId()) 
		{
		
		case R.id.radioButton1:
			shopIntent.putExtra("CAR", R.string.luaz);
			shopIntent.putExtra("CAR_COST", 7620.00);
			score = conf_intent.getDoubleExtra("score_conf", 0);
			score = score - 10000;
			shopIntent.putExtra("score_conf", score);
			Toast.makeText(getBaseContext(), "Вы купили Луаз! -7620 гроблей", Toast.LENGTH_SHORT).show();
			//shopIntent.putExtra("splashTime", splashTime);
			break;
		case R.id.radioButton5:
			shopIntent.putExtra("CAR", R.string.moskvitch2);
			shopIntent.putExtra("CAR_COST", 23827.00);
			//score = getIntent().getExtras().getDouble("score");
			//score = score - 23827.00;
			//shopIntent.putExtra("score", score);
			Toast.makeText(getBaseContext(), "Вы купили Москвич! -23827 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton7:
			shopIntent.putExtra("CAR", R.string.vaz6);
			shopIntent.putExtra("CAR_COST", 30603.00);
			//score = getIntent().getExtras().getDouble("score");
			//score = score - 30603.00;
			//shopIntent.putExtra("score", score);
			Toast.makeText(getBaseContext(), "Вы купили Ваз 2106! -30603 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton9:
			shopIntent.putExtra("CAR", R.string.vaz9);
			shopIntent.putExtra("CAR_COST", 44269.00);
			//score = getIntent().getExtras().getDouble("score");
		//	score = score - 7620.00;
		//	shopIntent.putExtra("score", score);
			Toast.makeText(getBaseContext(), "Вы купили Ваз 2109! -44269 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton13:
			shopIntent.putExtra("CAR", R.string.gaz3102);
			shopIntent.putExtra("CAR_COST", 74879.00);
			//score = getIntent().getExtras().getDouble("score");
		//	score = score - 74879.00;
		//	shopIntent.putExtra("score", score);
			Toast.makeText(getBaseContext(), "Вы купили Газ 3102! -74879 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton2:
			shopIntent.putExtra("APART", R.string.onek);
			shopIntent.putExtra("APART_COST", 8304.00);
			//score = getIntent().getExtras().getDouble("score");
		//	score = score - 8304.00;
		//	shopIntent.putExtra("score", score);
			Toast.makeText(getBaseContext(), "Вы купили 1-комнатную квартиру! -8304 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton4:
			shopIntent.putExtra("APART", R.string.twok);
			shopIntent.putExtra("APART_COST", 17286.00);
			//score = getIntent().getExtras().getDouble("score");
		//	score = score - 17286.00;
		//	shopIntent.putExtra("score", score);
			Toast.makeText(getBaseContext(), "Вы купили 2-комнатную квартиру! -17286 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton6:
			shopIntent.putExtra("APART", R.string.threek);
			shopIntent.putExtra("APART_COST", 18934.00);
			//score = getIntent().getExtras().getDouble("score");
		//	score = score - 18934.00;
		//	shopIntent.putExtra("score", score);
			Toast.makeText(getBaseContext(), "Вы купили 3-комнатную квартиру! -18934 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton8:
			shopIntent.putExtra("APART", R.string.fourk);
			shopIntent.putExtra("APART_COST", 34304.00);
			//score = getIntent().getExtras().getDouble("score");
		//	score = score - 34304.00;
		//	shopIntent.putExtra("score", score);
			Toast.makeText(getBaseContext(), "Вы купили 4-комнатную квартиру! -34304 гроблей", Toast.LENGTH_SHORT).show();
			break;
		case R.id.radioButton10:
			shopIntent.putExtra("APART", R.string.fivek);
			shopIntent.putExtra("APART_COST", 34574.00);
			//score = getIntent().getExtras().getDouble("score");
		//	score = score - 34574.00;
		//	shopIntent.putExtra("score", score);
			Toast.makeText(getBaseContext(), "Вы купили 5-комнатную квартиру! -34574 гроблей", Toast.LENGTH_SHORT).show();
			break;
			
		default:
			break;
		}
		setResult(RESULT_OK, shopIntent);
		finish();
		shopIntent.putExtra("splashTime", splashTime);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shop, menu);
		return true;
	}

}
