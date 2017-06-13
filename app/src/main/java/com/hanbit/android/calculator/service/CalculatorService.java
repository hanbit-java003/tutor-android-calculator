package com.hanbit.android.calculator.service;

import android.widget.TextView;

/**
 * Created by 1027 on 2017-06-13.
 */

public class CalculatorService {

    private TextView textBuffer;
    private TextView textResult;

    private String buffer = "";
    private String result = "0";

    public CalculatorService(TextView textBuffer, TextView textResult) {
        this.textBuffer = textBuffer;
        this.textResult = textResult;
    }

    private void updateTextView() {
        textBuffer.setText(buffer);
        textResult.setText(result);
    }

    public void inputNumber(int number) {
        if ("0".equals(result)) {
            result = "";
        }

        result += number;

        updateTextView();
    }

    public void inputFunction(String function) {
        if ("C".equals(function)) {
            buffer = "";
            result = "0";
        }

        updateTextView();
    }

}
