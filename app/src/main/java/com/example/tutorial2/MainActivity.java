package com.example.tutorial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText temp_et_input;
    RadioButton temp_redio_btn_celcius;
    RadioButton temp_radio_btn_faran;
    Button temp_btn_calculate;
    TextView temp_txtView_answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp_et_input = findViewById(R.id.temp_et_input);
        temp_redio_btn_celcius = findViewById(R.id.temp_redio_btn_celcius);
        temp_radio_btn_faran = findViewById(R.id.temp_radio_btn_faran);
        temp_btn_calculate = findViewById(R.id.temp_btn_calculate);
        temp_txtView_answer = findViewById(R.id.temp_txtView_answer);







    }

    @Override
    protected void onResume() {
        super.onResume();
        temp_btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });

    }

    public void calculateAnswer(){

        calculate cal = new calculate();
        String value = temp_et_input.getText().toString();
        if(TextUtils.isEmpty(value)){
            Toast.makeText(this, "Please add a value",
                    Toast.LENGTH_LONG).show();


        } else {
            Float temp = Float.parseFloat(value);
            Float answer;
            if(temp_redio_btn_celcius.isChecked()){

            answer = cal.convertFahrenheitToCelcius(temp);

        } else if (temp_radio_btn_faran.isChecked()){
                answer = cal.convertCelciusToFahrenheit(temp);
            } else {
                Toast.makeText(this, "Please Select Type to Convert", Toast.LENGTH_SHORT).show();
                answer = 0.0f;
            }
            temp_txtView_answer.setText(Float.valueOf(answer).toString());
    }

    }
}