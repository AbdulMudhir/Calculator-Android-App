package com.example.calculator;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
public class MainActivity extends AppCompatActivity implements OnClickListener{


    private final char number9 = '9';
    private final char number8 = '8';
    private final char number7 = '7';
    private final char number6 = '6';
    private final char number5 = '5';
    private final char number4 = '4';
    private final char number3 = '3';
    private final char number2 = '2';
    private final char number1 = '1';
    private final char number0 = '0';

    private final char dividable = '%';
    private final char division = '÷';
    private final char multiplication = '*';
    private final char minus = '-';
    private final char addition = '+';
    private final char decimal = '.';

    // to be used to check if an operator is not used twice by checking the last string is a number

    private final String numberRegex = "\\d";

    private boolean decimalPointUsed = false;

    private boolean darkMode = false;
    private Button darkModeButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(this);
        Button backspaceButton = findViewById(R.id.backspaceButton);
        backspaceButton.setOnClickListener(this);
        Button divisibleButton = findViewById(R.id.divisableButton);
        divisibleButton.setOnClickListener(this);
        Button divisionButton = findViewById(R.id.divisonButton);
        divisionButton.setOnClickListener(this);
        Button multiplicationButton = findViewById(R.id.multiplicationButton);
        multiplicationButton.setOnClickListener(this);
        Button minusButton = findViewById(R.id.minusButton);
        minusButton.setOnClickListener(this);
        Button additionButton = findViewById(R.id.plusButton);
        additionButton.setOnClickListener(this);
        Button equalButton = findViewById(R.id.equalButton);
        equalButton.setOnClickListener(this);
        darkModeButton=  findViewById(R.id.darktheme);
        darkModeButton.setOnClickListener(this);
        Button decimalButton =  findViewById(R.id.decimalButton);
        decimalButton.setOnClickListener(this);

        //number
        Button number7 = findViewById(R.id.number7);
        number7.setOnClickListener(this);
        Button number8 =  findViewById(R.id.number8);
        number8.setOnClickListener(this);
        Button number9 =  findViewById(R.id.number9);
        number9.setOnClickListener(this);
        Button number4 = findViewById(R.id.number4);
        number4.setOnClickListener(this);
        Button number5 =  findViewById(R.id.number5);
        number5.setOnClickListener(this);
        Button number6 =  findViewById(R.id.number6);
        number6.setOnClickListener(this);
        Button number1 =  findViewById(R.id.number1);
        number1.setOnClickListener(this);
        Button number2 =  findViewById(R.id.number2);
        number2.setOnClickListener(this);
        Button number3 = findViewById(R.id.number3);
        number3.setOnClickListener(this);
        Button number0 = findViewById(R.id.number0);
        number0.setOnClickListener(this);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        TextView expressionTextView = (TextView) findViewById(R.id.expressionTextView);

        String currentExpression = expressionTextView.getText().toString();


        switch(v.getId()){

            case R.id.number9:{
                expressionTextView.setText(currentExpression+number9);
                break;

            }
            case R.id.number8:{
                expressionTextView.setText(currentExpression+number8);
                break;

            }
            case R.id.number7:{
                expressionTextView.setText(currentExpression+number7);
                break;

            }
            case R.id.number6:{
                expressionTextView.setText(currentExpression+number6);
                break;

            }
            case R.id.number5:{
                expressionTextView.setText(currentExpression+number5);
                break;

            }
            case R.id.number4:{
                expressionTextView.setText(currentExpression+number4);
                break;

            }
            case R.id.number3:{
                expressionTextView.setText(currentExpression+number3);
                break;

            }
            case R.id.number2:{
                expressionTextView.setText(currentExpression+number2);
                break;

            }
            case R.id.number1:{
                expressionTextView.setText(currentExpression+number1);
                break;

            }
            case R.id.number0:{
                expressionTextView.setText(currentExpression+number0);
                break;
            }


            case R.id.clearButton:{
                expressionTextView.setText("");
                decimalPointUsed=false;
                break;
            }

            case R.id.backspaceButton:{

                if (expressionTextView.length() != 0){

                    // remove the last string
                    String newExpression = currentExpression.substring(0, currentExpression.length()-1);
                    char lastString = currentExpression.charAt(currentExpression.length() - 1);

                    if(lastString == decimal)
                        decimalPointUsed=false;


                    expressionTextView.setText(newExpression);
                    break;

                }

            }

            case R.id.divisableButton: {
                // make sure a number was entered beforehand
                if (currentExpression.length() != 0) {

                    // check the last string is not an expression
                    String lastString = currentExpression.substring(currentExpression.length() - 1);

                    boolean lastCharacterIsAnumber = lastString.matches(numberRegex);

                    if(lastCharacterIsAnumber) {
                        expressionTextView.setText(currentExpression + dividable);
                        decimalPointUsed=false;
                    }

                    break;



                }
            }

            case R.id.divisonButton: {
                // make sure a number was entered beforehand
                if (currentExpression.length() != 0) {
                    // check the last string
                    String lastString = currentExpression.substring(currentExpression.length() - 1);

                    boolean lastCharacterIsAnumber = lastString.matches(numberRegex);

                    if(lastCharacterIsAnumber) {
                        expressionTextView.setText(currentExpression + division);
                        decimalPointUsed=false;
                    }

                    break;
                }
            }

            case R.id.multiplicationButton: {
                // make sure a number was entered beforehand
                if (currentExpression.length() != 0) {
                    // check the last string
                    String lastString = currentExpression.substring(currentExpression.length() - 1);

                    boolean lastCharacterIsAnumber = lastString.matches(numberRegex);

                    if(lastCharacterIsAnumber) {
                        expressionTextView.setText(currentExpression + multiplication);
                        decimalPointUsed=false;
                    }

                    break;
                }
            }

            case R.id.minusButton: {
                // make sure a number was entered beforehand
                if (currentExpression.length() != 0) {
                    // check the last string
                    String lastString = currentExpression.substring(currentExpression.length() - 1);

                    boolean lastCharacterIsAnumber = lastString.matches(numberRegex);

                    if(lastCharacterIsAnumber) {
                        expressionTextView.setText(currentExpression + minus);
                        decimalPointUsed=false;
                    }

                    break;
                }
            }
            case R.id.plusButton: {
                // make sure a number was entered beforehand
                if (currentExpression.length() != 0) {
                    // check the last string
                    String lastString = currentExpression.substring(currentExpression.length() - 1);

                    boolean lastCharacterIsAnumber = lastString.matches(numberRegex);

                    if(lastCharacterIsAnumber){
                        expressionTextView.setText(currentExpression+addition);
                        decimalPointUsed=false;}


                    break;
                }
            }
            case R.id.decimalButton: {
                // make sure a number was entered beforehand
                if (currentExpression.length() != 0) {
                    // check the last string
                    String lastString = currentExpression.substring(currentExpression.length() - 1);

                    boolean lastCharacterIsAnumber = lastString.matches(numberRegex);

                    if(lastCharacterIsAnumber)

                        if(!decimalPointUsed) {
                            expressionTextView.setText(currentExpression + decimal);
                            decimalPointUsed = true;
                        }

                    break;
                }
            }

            case R.id.darktheme: {

                View background = findViewById(R.id.background);

                if(!darkMode){
                    background.setBackgroundColor(Color.BLACK);
                    darkModeButton.setText("Light");
                    darkMode=true;
                    break;

                }
                else{

                    String pinkHex = "#ff9878";

                    int pink = Color.parseColor(pinkHex);

                    background.setBackgroundColor(Color.parseColor(pinkHex));
                    darkModeButton.setText("Light");
                    darkMode=false;
                    break;

                }


                }









        }





            }









}
