package com.android_lessons.belkin.day12converter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    private EditText mInputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputText = (EditText) findViewById(R.id.editText);
    }

    // Конвертируем в метры
    private float convertParrotToMeter(float parrot) {
        return (float) (parrot / 7.6);
    }

    // Конвертируем в попугаи
    private float convertMeterToParrot(float meter) {
        return (float) (meter * 7.6);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonConvert_Click(View view) {
        RadioButton meterRedioButton = (RadioButton)findViewById(R.id.radioButtonMeter);

        if(mInputText.getText().length() == 0){
            Toast.makeText(getApplicationContext(), "Введитедлину кота", Toast.LENGTH_SHORT).show();
            return;
        }

        float inputValue = Float.parseFloat(mInputText.getText().toString());
        if(meterRedioButton.isChecked()){
            mInputText.setText(String.valueOf(convertParrotToMeter(inputValue)));
        }else{
            mInputText.setText(String.valueOf(convertMeterToParrot(inputValue)));
        }
    }
}
