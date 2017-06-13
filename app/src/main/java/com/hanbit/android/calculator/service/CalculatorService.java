package com.hanbit.android.calculator.service;

import android.widget.TextView;

import java.math.BigDecimal;

/**
 * Created by 1027 on 2017-06-13.
 */

public class CalculatorService {

    private TextView textBuffer;
    private TextView textResult;

    private String buffer;
    private String result;

    private String tempBuffer;
    private String tempResult;
    private String tempOperator;
    private String lastOperator;

    private BigDecimal decimalResult;

    public CalculatorService(TextView textBuffer, TextView textResult) {
        this.textBuffer = textBuffer;
        this.textResult = textResult;

        clearAll();
        updateTextView();
    }

    private void updateTextView() {
        textBuffer.setText(buffer);
        textResult.setText(result);
    }

    public void inputNumber(int number) {
        if (!lastOperator.isEmpty()) {
            result = "";
        }

        lastOperator = "";

        if ("0".equals(result)) {
            result = "";
        }

        result += number;
        tempResult = result;

        if (buffer.isEmpty()) {
            decimalResult = new BigDecimal(result);
        }

        updateTextView();
    }

    public void inputFunction(String function) {
        lastOperator = "";

        switch (function) {
            case "C": {
                clearAll();
                break;
            }
            case "CE": {
                clearResult();
                break;
            }
            case "<-": {
                removeLastNumber();
                break;
            }
            case "+-": {
                negative();
                break;
            }
            case "+":
            case "-":
            case "*":
            case "/": {
                inputOperator(function);
                break;
            }
        }

        updateTextView();
    }

    private void inputOperator(String operator) {
        lastOperator = operator;

        if (buffer.isEmpty()) {
            tempBuffer = result;
        }
        else if (!tempResult.isEmpty()) {
            tempBuffer = buffer + " " + result;

            if ("+".equals(tempOperator)) {
                decimalResult = decimalResult.add(new BigDecimal(result));
            }
            else if ("-".equals(tempOperator)) {
                decimalResult = decimalResult.subtract(new BigDecimal(result));
            }
            else if ("*".equals(tempOperator)) {
                decimalResult = decimalResult.multiply(new BigDecimal(result));
            }
            else if ("/".equals(tempOperator)) {
                decimalResult = decimalResult.divide(new BigDecimal(result),
                        10, BigDecimal.ROUND_DOWN);
            }

            result = decimalResult.toString();
        }

        tempResult = "";
        buffer = tempBuffer + " " + operator;
        tempOperator = operator;
    }

    private void clearAll() {
        buffer = "";
        result = "0";

        tempBuffer = "";
        tempResult = "";
        tempOperator = "";
        lastOperator = "";

        decimalResult = new BigDecimal(result);
    }

    private void clearResult() {
        result = "0";
    }

    private void removeLastNumber() {
        if ("0".equals(result)) {
            return;
        }
        else if (result.length() == 1) {
            result = "0";
            return;
        }

        result = result.substring(0, result.length() - 1);
    }

    private void negative() {
        BigDecimal decimalResult = new BigDecimal(result);
        decimalResult = decimalResult.multiply(new BigDecimal("-1"));

        result = decimalResult.toString();
        tempResult = result;
    }

}
