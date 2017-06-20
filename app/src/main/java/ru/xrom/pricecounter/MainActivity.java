package ru.xrom.pricecounter;
import android.graphics.*;
import android.os.*;
import android.support.v7.app.*;
import android.text.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity
{
	EditText editP, editW, tv, editP2, editW2, tv2, editP3, editW3, tv3;
	Double price, price2, price3;
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
		price = price2 = price3 =(double) Double.MAX_VALUE;
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
        editP = (EditText) findViewById(R.id.editPrice1);
        editW = (EditText) findViewById(R.id.editWeight1);
		tv = (EditText) findViewById(R.id.itogo);
		editP2 = (EditText) findViewById(R.id.editPrice2);
        editW2 = (EditText) findViewById(R.id.editWeight2);
		tv2 = (EditText) findViewById(R.id.itogo2);
		editP3 = (EditText) findViewById(R.id.editPrice3);
        editW3 = (EditText) findViewById(R.id.editWeight3);
		tv3 = (EditText) findViewById(R.id.itogo3);
        editW.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

				}

				@Override
				public void onTextChanged(CharSequence s, int start,
										  int before, int count) {
					if(s.length() != 0)
						setPrice(1);
				}

				@Override
				public void afterTextChanged(Editable editable) {

				}
			});
        editP.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

				}

				@Override
				public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
					if(charSequence.length() != 0)
						setPrice(1);
				}

				@Override
				public void afterTextChanged(Editable editable) {

				}
			});
		editW2.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

				}

				@Override
				public void onTextChanged(CharSequence s, int start,
										  int before, int count) {
					if(s.length() != 0)
						setPrice(2);
				}

				@Override
				public void afterTextChanged(Editable editable) {

				}
			});
        editP2.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

				}

				@Override
				public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
					if(charSequence.length() != 0)
						setPrice(2);
				}

				@Override
				public void afterTextChanged(Editable editable) {

				}
			});
		editW3.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

				}

				@Override
				public void onTextChanged(CharSequence s, int start,
										  int before, int count) {
					if(s.length() != 0)
						setPrice(3);
				}

				@Override
				public void afterTextChanged(Editable editable) {

				}
			});
        editP3.addTextChangedListener(new TextWatcher() {
				@Override
				public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

				}

				@Override
				public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
					if(charSequence.length() != 0)
						setPrice(3);
				}

				@Override
				public void afterTextChanged(Editable editable) {

				}
			});
			Button btn = (Button) findViewById(R.id.closebtn);
			btn.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v){
					//Intent intent = new Intent();
					//intent.putExtra("name", tv.getText().toString());
					//setResult(RESULT_OK, intent);
					//finish();
					editP.setText(""); editW.setText(""); tv.setText("");
					editP2.setText(""); editW2.setText(""); tv2.setText("");
					editP3.setText(""); editW3.setText(""); tv3.setText("");
					price = price2 = price3 = (double) Double.MAX_VALUE;
					tv.setBackgroundColor(Color.TRANSPARENT);
                    tv2.setBackgroundColor(Color.TRANSPARENT);
                    tv3.setBackgroundColor(Color.TRANSPARENT);
				}
			});
		
	}
		
	private void setPrice(int i) {
        switch (i) {
            case 1: {
					if (editP.getText().length() > 0 && editW.getText().length() > 0) {
						price = Double.parseDouble(editP.getText().toString()) / Double.parseDouble(editW.getText().toString()) * 1000;
						
						tv.setText("Цена за килограмм: " + String.format("%.2f", price));
					}
					break;
				}
            case 2: {
					if (editP2.getText().length() > 0 && editW2.getText().length() > 0) {
						price2 = Double.parseDouble(editP2.getText().toString()) / Double.parseDouble(editW2.getText().toString()) * 1000;
						
						tv2.setText("Цена за килограмм: " + String.format("%.2f", price2));
					}
					break;
				}
            case 3: {
					if (editP3.getText().length() > 0 && editW3.getText().length() > 0) {
						price3 = Double.parseDouble(editP3.getText().toString()) / Double.parseDouble(editW3.getText().toString()) * 1000;
						
						tv3.setText("Цена за килограмм: " + String.format("%.2f", price3));
					}
					break;
				}
				
        }
		Double smallest = Math.min(price, Math.min(price2, price3));
		if (smallest == price)
		{
			tv.setBackgroundColor(Color.GREEN);
			tv2.setBackgroundColor(Color.TRANSPARENT);
			tv3.setBackgroundColor(Color.TRANSPARENT);
		}
		else if (price2 == smallest)
		{
			tv2.setBackgroundColor(Color.GREEN);
			tv.setBackgroundColor(Color.TRANSPARENT);
			tv3.setBackgroundColor(Color.TRANSPARENT);
		}
		else if (price3 == smallest)
		{
			tv3.setBackgroundColor(Color.GREEN);
			tv2.setBackgroundColor(Color.TRANSPARENT);
			tv.setBackgroundColor(Color.TRANSPARENT);
		}
		/*if(price < price2)
			if(price < price3)
				{
				tv.setBackgroundColor(Color.GREEN);
				tv2.setBackgroundColor(Color.TRANSPARENT);
				tv3.setBackgroundColor(Color.TRANSPARENT);
				}
			else
			{
				tv3.setBackgroundColor(Color.GREEN);
				tv2.setBackgroundColor(Color.TRANSPARENT);
				tv.setBackgroundColor(Color.TRANSPARENT);
			}
		else
			if(price2 < price3)
			{
				tv2.setBackgroundColor(Color.GREEN);
				tv.setBackgroundColor(Color.TRANSPARENT);
				tv3.setBackgroundColor(Color.TRANSPARENT);
			}
			else
			{
				tv3.setBackgroundColor(Color.GREEN);
				tv2.setBackgroundColor(Color.TRANSPARENT);
				tv.setBackgroundColor(Color.TRANSPARENT);
			}
					*/
			
//        if (price > 0 & price2 > 0 & price3 > 0 || price > 0 & price2 > 0 || price3 > 0 & price2 > 0 || price > 0 & price3 > 0) {
//            if (price < price2 & price > 0 & price2 > 0) {
//                if (price < price3 & price3 > 0) {
//                    TRANSPARENT
//                    tv2.setBackgroundColor(Color.TRANSPARENT);
//                    tv3.setBackgroundColor(Color.TRANSPARENT);
//                } else {
//                    TRANSPARENT
//                    tv2.setBackgroundColor(Color.TRANSPARENT);
//                    tv.setBackgroundColor(Color.TRANSPARENT);
//                }
//            } else if (price2 < price3 & price2 > 0 & price3 > 0) {
//                tv2.setBackgroundColor(Color.GREEN);
//                tv.setBackgroundColor(Color.TRANSPARENT);
//                tv3.setBackgroundColor(Color.TRANSPARENT);
//
//            } else {
//                tv3.setBackgroundColor(Color.GREEN);
//                tv2.setBackgroundColor(Color.TRANSPARENT);
//                tv.setBackgroundColor(Color.TRANSPARENT);
//            }
//       } 
    }
}
