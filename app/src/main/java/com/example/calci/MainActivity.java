package com.example.calci;

//Importing the required classes
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static java.lang.Double.NaN;

public class MainActivity extends AppCompatActivity {
//    Declaring the buttons and the textviews
    private Button zero,one,two,three,four,five,six,seven,eight,nine,add,sub,multi,divide,equ,clear,percentage,point,power;
    private TextView info;
    private TextView Result;

//    Initialising the variables required
    private final char ADDITION = '+',SUBTRACTION = '-',MULTIPLICATION = '*',DIVISION = '/',EQU = '=',PERCENTAGE = '%',POWER = '^';
    private Double val1 = NaN,val2 = NaN;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Initialising the buttons and the textviews
        setupUIView();

//        Adding onclick listener to all the buttons which specifies what is to be done when clicked
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                calling the compute method to calculate the result
                compute();

//                setting the action to addition
                ACTION = ADDITION;

//                displaying the result
                Result.setText(String.valueOf(val1) + "+");

//                Clearing the input area
                info.setText(null);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                Result.setText(String.valueOf(val1) + "-");
                info.setText(null);
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                Result.setText(String.valueOf(val1) + "*");
                info.setText(null);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                Result.setText(String.valueOf(val1) + "/");
                info.setText(null);
            }
        });
        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;

//                displaying the result
                if(Double.isNaN(val2)) Result.setText(String.valueOf(val1));
                else Result.setText(Result.getText().toString() + String.valueOf(val2) + " = " + String.valueOf(val1));

//                clearing the screen
                info.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length() > 0 )
                {
                    CharSequence name = info.getText().toString();

//                    clearing one integer at a time
                    info.setText(name.subSequence(0,name.length()-1));
                }
                else
                {
//                    resetting everything
                    val1  = NaN;
                    val2 = NaN;
                    info.setText(null);
                    Result.setText(null);
                }
            }
        });
        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = PERCENTAGE;
                Result.setText(String.valueOf(val1) + "%");
                info.setText(null);
            }
        });
        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = POWER;
                Result.setText(String.valueOf(val1) + "^");
                info.setText(null);
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                info.setText(info.getText().toString()+".");
            }
        });
    }

    private void setupUIView(){
        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        add = (Button)findViewById(R.id.btnadd);
        sub = (Button)findViewById(R.id.btnsub);
        multi = (Button)findViewById(R.id.btnmulti);
        divide = (Button)findViewById(R.id.btndivide);
        equ = (Button)findViewById(R.id.btnequ);
        info = (TextView)findViewById(R.id.tvControl);
        Result = (TextView)findViewById(R.id.tvResult);
        clear = (Button)findViewById(R.id.btnclear);
        percentage  = (Button)findViewById(R.id.btnperc);
        point = (Button)findViewById(R.id.btnpoint);
        power = (Button)findViewById(R.id.btnpow);


    }

    private void compute()
    {
//        checking if the val1 is not a NULL
        if(!Double.isNaN(val1))
        {
            if(ACTION == PERCENTAGE) val1 = val1/100.0;
            else {

//                Saving the input to val2
                val2 = Double.parseDouble(info.getText().toString());

//                Checking if the val2 is not NULL
                if(!Double.isNaN(val2)){
                    switch (ACTION) {
                        case ADDITION:
                            val1 = (val1 + val2);
                            break;
                        case SUBTRACTION:
                            val1 = val1 - val2;
                            break;
                        case MULTIPLICATION:
                            val1 = val1 * val2;
                            break;
                        case DIVISION:
                            val1 = val1 / val2;
                            break;
                        case EQU:
                            break;
                        case POWER:
                            val1 = Math.pow(val1, val2);
                            break;
                    }
                }
                else Result.setText(String.valueOf(val1) + info.getText().toString());
            }
        }
        else
        {
//            if val1 is NULL take the input
            val1 = Double.parseDouble(info.getText().toString());
        }
    }
}