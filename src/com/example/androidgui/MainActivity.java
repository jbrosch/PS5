package com.example.androidgui;

import java.text.DecimalFormat;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	TextView numberView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String[] nums = new String[101];
		for(int i=0; i<nums.length; i++)
			nums[i] = Integer.toString(i);
		final NumberPicker np = (NumberPicker) findViewById(R.id.np);
		np.setMaxValue(nums.length-1);
		np.setMinValue(0);
		np.setWrapSelectorWheel(false);
		np.setDisplayedValues(nums);
		
		final Button button1 = (Button)findViewById(R.id.button1);

		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				final EditText invest =(EditText)findViewById(R.id.editText1);
				final EditText time = (EditText)findViewById(R.id.editText2);
				final TextView amountPrint = (TextView)findViewById(R.id.textView5);
				
				double interest = .01*(double)np.getValue();
				double amount = Double.parseDouble(invest.getText().toString());
				double years=Double.parseDouble(time.getText().toString());
				double value = Lab1.PMT(years,amount,interest);
				DecimalFormat df = new DecimalFormat("#.##");
				//String result = new Double(value).toString();
				String result = String.valueOf(df.format(value));
				amountPrint.setText(result);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
