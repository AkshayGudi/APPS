package com.calc.app.calciapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static Integer operand1;
    public static Integer operand2;
    public static String operator;
    public static Boolean operatorClicked;
    public TextView textViewValue;
    String tagValue;
    public  String num = "number";
    public  String op = "operator";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operatorClicked = Boolean.FALSE;
        operand1 = 0;
        operand2 = 0;
    }

    public void buttonClicked(View v){
        Integer operandValue;
        Button b = (Button)v;
        tagValue = b.getTag().toString();
        if (operand2 == null){
            operand2 = 0;
        }

        if (operand1 == null){
            operand1 = 0;
        }

        if (tagValue.equals(num)){
            if (operatorClicked){
                operand2 = operand2 * 10 + Integer.parseInt(b.getText().toString());
            }else{
                operand1 = operand1 * 10 + Integer.parseInt(b.getText().toString());
            }

        }else if (tagValue.equals(op)){
            if (!("=".equals(b.getText().toString()))) {
                operator = b.getText().toString();
                operatorClicked = Boolean.TRUE;
            }/*else{
                operator = "=";
            }*/
        }

        textViewValue = (TextView)findViewById(R.id.valueField);

        if (operatorClicked) {
            if (operand2 == 0) {
                if (!("=".equals(b.getText().toString()))) {
                    textViewValue.setText(operand1 + " " + operator);
                } else {
                    textViewValue.setText(operand1.toString());
                }
            } else if (!("=".equals(b.getText().toString()))) {
                textViewValue.setText(operand1 + " " + operator + " " + operand2);
            } else {
                //Toast.makeText(this,operator,Toast.LENGTH_SHORT).show();
                Float value = 0F;
                if (operator.equals("+")) {
                    value = Float.valueOf(operand1 + operand2);
                } else if (operator.equals("-")) {
                    value = Float.valueOf(operand1 - operand2);
                } else if (operator.equals("x")) {
                    value = Float.valueOf(operand1 * operand2);
                } else if (operator.equals("/")) {
                    value = Float.valueOf(operand1) / Float.valueOf(operand2);
                }
                textViewValue.setText(value.toString());
                operand1 = 0;
                operand2 = 0;
                operator = "";
                operatorClicked = Boolean.FALSE;
            }

        }
        else{
            textViewValue.setText(operand1.toString());
        }

    }



}
