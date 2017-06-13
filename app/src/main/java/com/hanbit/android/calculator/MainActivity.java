package com.hanbit.android.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView textBuffer;
    private TextView textResult;

    private List<Button> btnNumbers;
    private Map<Button, String> btnFunctions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initEventHandlers();
    }

    private void initViews() {
        textBuffer = (TextView) findViewById(R.id.textBuffer);
        textResult = (TextView) findViewById(R.id.textResult);

        initNumberButtons();
        initFunctionButtons();
    }

    private void initNumberButtons() {
        btnNumbers = new ArrayList<>();
        btnNumbers.add((Button) findViewById(R.id.btn0));
        btnNumbers.add((Button) findViewById(R.id.btn1));
        btnNumbers.add((Button) findViewById(R.id.btn2));
        btnNumbers.add((Button) findViewById(R.id.btn3));
        btnNumbers.add((Button) findViewById(R.id.btn4));
        btnNumbers.add((Button) findViewById(R.id.btn5));
        btnNumbers.add((Button) findViewById(R.id.btn6));
        btnNumbers.add((Button) findViewById(R.id.btn7));
        btnNumbers.add((Button) findViewById(R.id.btn8));
        btnNumbers.add((Button) findViewById(R.id.btn9));
    }

    private void initFunctionButtons() {
        btnFunctions = new HashMap<>();
        btnFunctions.put((Button) findViewById(R.id.btnBackspace), "<-");
        btnFunctions.put((Button) findViewById(R.id.btnDelete), "CE");
        btnFunctions.put((Button) findViewById(R.id.btnClear), "C");
        btnFunctions.put((Button) findViewById(R.id.btnSign), "+-");
        btnFunctions.put((Button) findViewById(R.id.btnRoot), "ROOT");
        btnFunctions.put((Button) findViewById(R.id.btnDivide), "/");
        btnFunctions.put((Button) findViewById(R.id.btnMultiply), "*");
        btnFunctions.put((Button) findViewById(R.id.btnMinus), "-");
        btnFunctions.put((Button) findViewById(R.id.btnPlus), "+");
        btnFunctions.put((Button) findViewById(R.id.btnPercent), "%");
        btnFunctions.put((Button) findViewById(R.id.btnFraction), "1/X");
        btnFunctions.put((Button) findViewById(R.id.btnDot), ".");
        btnFunctions.put((Button) findViewById(R.id.btnEqual), "=");
    }

    private void initEventHandlers() {
        initNumberButtonEventHandlers();
        initFunctionButtonEventHandlers();
    }

    private void initNumberButtonEventHandlers() {
        for (int i=0; i<btnNumbers.size(); i++) {
            Button btnNumber = btnNumbers.get(i);
            final int number = i;

            btnNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textResult.setText(String.valueOf(number));
                }
            });
        }
    }

    private void initFunctionButtonEventHandlers() {
        Iterator<Button> btns = btnFunctions.keySet().iterator();

        while (btns.hasNext()) {
            Button btn = btns.next();

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    textBuffer.setText(btnFunctions.get(view));
                }
            });
        }
    }

}
