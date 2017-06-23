package org.androidtown.calcu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button0 = (Button) findViewById(R.id.btn0);
        final Button button1 = (Button) findViewById(R.id.btn1);
        final Button button2 = (Button) findViewById(R.id.btn2);
        final Button button3 = (Button) findViewById(R.id.btn3);
        final Button button4 = (Button) findViewById(R.id.btn4);
        final Button button5 = (Button) findViewById(R.id.btn5);
        final Button button6 = (Button) findViewById(R.id.btn6);
        final Button button7 = (Button) findViewById(R.id.btn7);
        final Button button8 = (Button) findViewById(R.id.btn8);
        final Button button9 = (Button) findViewById(R.id.btn9);
        final Button buttonAdd = (Button) findViewById(R.id.btnAdd);
        final Button buttonSub = (Button) findViewById(R.id.btnSub);
        final Button buttonMul = (Button) findViewById(R.id.btnMul);
        final Button buttonDiv = (Button) findViewById(R.id.btnDiv);

        final TextView textView =(TextView) findViewById(R.id.textView);

        final Map<String, String> calc = new HashMap<String, String>();
        calc.put("reset", "N");

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(v.getContext(), button1.getText(), Toast.LENGTH_SHORT).show();

                String text = "";

                //number => input
                if( !((Button)v).getText().equals("+")
                        && !((Button) v).getText().equals("-")
                        && !((Button) v).getText().equals("/")
                        && !((Button) v).getText().equals("*")
                        && !((Button) v).getText().equals("=")){

                    if( calc.get("reset").equals("Y")){
                        calc.put("reset", "N");
                        calc.put("number1", "");
                        calc.put("operation", "");

                        text = (String) ((Button) v).getText();
                        textView.setText(Integer.parseInt(text)+ "");
                    }
                    else {
                        text = (String) textView.getText();
                        text += ((Button) v).getText();

                        textView.setText( Integer.parseInt(text) + "" );
                    }
                }

                //연산자라면 연산자와 이전에 입력한 숫자 input
                if( ((Button) v).getText().equals("+")
                        || ((Button) v).getText().equals("-")
                        || ((Button) v).getText().equals("/")
                        || ((Button) v).getText().equals("*")) {
                    calc.put("operation",  (String) ((Button) v).getText());
                    calc.put("number1", (String) textView.getText());
                    textView.setText( "0" );
                }

                // = 이퀄 시 연산
                if ( ((Button) v).getText().equals("=") ){
                    int number1 = Integer.parseInt(calc.get("number1"));
                    int number2 = Integer.parseInt( (String) textView.getText());

                    int result = 0;

                    //연산자에 따른 연산 처리
                    if( calc.get("operation").equals("+") ){
                        result = number1 + number2;
                    }
                    else if ( calc.get("operation").equals("-")) {
                        result = number1 - number2;
                    }
                    else if( calc.get("operation").equals("*")) {
                        result = number1*number2;
                    }
                    else if( calc.get("operation").equals("/") ){
                        double divResult = number1/number2;
                        result = (int)divResult;
                    }

                    //리셋 값 (결과시)
                    calc.put("reset", "Y");

                    textView.setText( result + "" );
                }
            }
       };

        button0.setOnClickListener(clickListener);
        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);
        button3.setOnClickListener(clickListener);
        button4.setOnClickListener(clickListener);
        button5.setOnClickListener(clickListener);
        button6.setOnClickListener(clickListener);
        button7.setOnClickListener(clickListener);
        button8.setOnClickListener(clickListener);
        button9.setOnClickListener(clickListener);
        buttonAdd.setOnClickListener(clickListener);
        buttonMul.setOnClickListener(clickListener);
        buttonSub.setOnClickListener(clickListener);
        buttonMul.setOnClickListener(clickListener);
        buttonDiv.setOnClickListener(clickListener);

    }
}
