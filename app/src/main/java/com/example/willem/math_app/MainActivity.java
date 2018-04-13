package com.example.willem.math_app;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView firstNumber;
    private TextView secondNumber;
    private TextView operator;

    private EditText anwser;

    private Button check;
    private Button next;

    private int first,second,oper;

    private boolean rightAwnser = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = findViewById(R.id.firstNumber);
        //Log.d("findViewByID","firstnumber added");
        secondNumber = findViewById(R.id.secondNumber);
        //Log.d("findViewByID","Second NUmber added");
        operator = findViewById(R.id.operator);
        //Log.d("findViewByID","operator added");

        check = findViewById(R.id.checkButton);
        next = findViewById(R.id.nextButton);

        anwser = findViewById(R.id.answer);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checksum();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rightAwnser){
                    anwser.setBackgroundColor(Color.WHITE);
                    createQuestion();
                }
            }
        });

        createQuestion();

    }

    public void createQuestion(){
        anwser.setText("");
        rightAwnser = false;
        int first,second,operator;
        first   =   (int)   (Math.random() * 50);
        Log.d("CreateQuestion", "createQuestion: first value "+ first);
        second  =   (int)   (Math.random() * 50);
        operator = (int) (Math.random()*3);

        if(operator == 0) {
            this.operator.setText("+");
            this.oper = operator;
        }else if(operator == 1) {

            this.operator.setText("-");
            this.oper = operator;
        }else if (operator == 2) {
            this.operator.setText("*");
            this.oper = operator;
        }

        this.first = first;
        this.firstNumber.setText(""+first); //why does this work and doesn't this "this.firstNumber.setText(first)"

        this.second = second;
        this.secondNumber.setText(""+second);

    }

    public void checksum(){
        if (checkAnwser()){
            anwser.setBackgroundColor(Color.rgb(0,255,0));
            rightAwnser = true;
        }else{
            anwser.setBackgroundColor(Color.rgb(255,0,0));
            rightAwnser = false;
        }
    }

    private boolean checkAnwser(){
        int anwser = Integer.parseInt(this.anwser.getText().toString());
        switch (this.oper){
            case 0:
                if((this.first + this.second) == anwser ){
                    return true;
                }
                break;
            case 1:
                if((this.first - this.second) == anwser){
                    return true;
                }
                break;
            case 2:
                if ((this.first * this.second) == anwser){
                    return true;
                }
        }

        return false;

    }

}
