package com.example.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(this);
        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(this);
        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(this);
        Button divisonButton = (Button) findViewById(R.id.divisonButton);
        divisonButton.setOnClickListener(this);
        Button equalButton = (Button) findViewById(R.id.equalButton);
        equalButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        TextView calculation = (TextView) findViewById(R.id.calculationTextView);

        switch(v.getId()){

            case R.id.button7:{
           String number = String.valueOf(calculation.getText());



           calculation.setText(number+"7");
           break;
            }
            case R.id.button8:{
                String number = calculation.getText().toString();
                calculation.setText(number+"8");
                break;
            }
            case R.id.button9:{
                String number = calculation.getText().toString();
                calculation.setText(number+"9");
                break;
            }
            case R.id.divisonButton:{
                String number = calculation.getText().toString();
                if(number.length()<=0)
                calculation.setText("0"+"/");

                else if (number.substring(number.length()-1).equals("/")){
                    break;
                }

                else{
                    calculation.setText(number+"/");
                }
                break;

            }

            case R.id.equalButton:{

                String expression = calculation.getText().toString();

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                Scriptable scriptable = rhino.initSafeStandardObjects();
                String finalResult = rhino.evaluateString(scriptable,expression, "javascript",1, null).toString();

                System.out.println(finalResult);

                calculation.setText(finalResult);

                break;






            }


        }





    }
}
