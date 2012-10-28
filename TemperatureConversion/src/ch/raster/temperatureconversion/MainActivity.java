package ch.raster.temperatureconversion;

import ch.raster.temperatureconversion.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.RadioButton;


public class MainActivity extends Activity {
	
	private EditText text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.editText1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void onClick(View view){
    	switch(view.getId()){
    	case R.id.button1:
    		RadioButton celsiusButton = (RadioButton) findViewById(R.id.radio0);
    		RadioButton fahrenheitButton = (RadioButton) findViewById(R.id.radio1);
    		
    		if(text.getText().length() == 0){
    			Toast.makeText(this, "Please enter a valid number",Toast.LENGTH_LONG).show();
    			return;
    		}
    		
    		float inputValue = Float.parseFloat(text.getText().toString());
    		
    		if(celsiusButton.isChecked()){
    			text.setText(String.valueOf(convertToCelsius(inputValue)));
    			celsiusButton.setChecked(true);
    			fahrenheitButton.setChecked(false);
    		}else{
    			text.setText(String.valueOf(convertToFahrenheit(inputValue)));
    			fahrenheitButton.setChecked(true);
    			celsiusButton.setChecked(false);
    		}
    		break;
    	}
    }

	private float convertToCelsius(float inputValue) {
		return (inputValue -32)*5/9;
    }

	private float convertToFahrenheit(float inputValue) {
		return ((inputValue *9)/5)+32;
	}
}
