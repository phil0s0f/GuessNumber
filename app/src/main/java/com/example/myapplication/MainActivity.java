package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    /*
    Boolean secNum = false;
    Boolean point = false;
    Boolean eql = false;
    */
    int rnd;
    int attempts = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rnd = generateRandomInt(100);
        refreshAttempts();
    }
    public void showRnd(){
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText("" + rnd);
    }
    public static int generateRandomInt(int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange);
    }
    public void refreshAttempts() {
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Количество попыток: " + attempts);
    }
    public void onButtonClickGuess(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        //TODO сделать отгадывание
    }

    public void onButtonClickHint(View view) {
        Toast toast;
        if (attempts - 2 >= 0) {
            attempts -= 2;
            refreshAttempts();
        } else {
            toast = Toast.makeText(this, "Невозможно получить подсказку! У вас меньше 2-х попыток", Toast.LENGTH_LONG);
            toast.show();
        }

        //TODO сделать действия для трех попыток
    }

    public void onButtonClickNewGame(View view) {
        attempts = 10;
        rnd = generateRandomInt(100);
        refreshAttempts();
    }
}

/*
    public void onButtonClickNumber(View view) {
        TextView num1 = (TextView) findViewById(R.id.num1);
        if (eql) {
            num1.setText("");
            eql = false;
        }
        Button btn = (Button) view;
        EditText text = (EditText) findViewById(R.id.editText);
        String str;
        if (text.getText().toString().equals("0")) {
            if (btn.getText().toString().equals(".")) {
                if (!point) {
                    str = "0" + btn.getText();
                    text.setText(str);
                    point = true;
                }
            } else {
                str = btn.getText().toString();
                text.setText(str);
            }

        } else {
            if (btn.getText().toString().equals(".")) {
                if (!point) {
                    str = text.getText().toString() + btn.getText();
                    text.setText(str);
                    point = true;
                }
            } else {
                str = text.getText().toString() + btn.getText();
                text.setText(str);
            }

        }
    }

    public void onButtonClickOperation(View view) {
        Button btn = (Button) view;
        EditText text = (EditText) findViewById(R.id.editText);
        TextView num1 = (TextView) findViewById(R.id.num1);
        TextView operation = (TextView) findViewById(R.id.operation);
        String str;
        float buf;
        if (eql) {
            num1.setText("");
            eql = false;
        }
        switch (btn.getText().toString()) {
            case "/":
                if (!secNum) {
                    num1.setText(text.getText());
                    operation.setText(btn.getText());
                    secNum = true;
                } else {
                    buf = Float.parseFloat(num1.getText().toString()) / Float.parseFloat(text.getText().toString());
                    str = "" + buf;
                    num1.setText(str);
                    operation.setText(btn.getText());
                }
                break;
            case "*":
                if (!secNum) {
                    num1.setText(text.getText());
                    operation.setText(btn.getText());
                    secNum = true;
                } else {
                    buf = Float.parseFloat(num1.getText().toString()) * Float.parseFloat(text.getText().toString());
                    str = "" + buf;
                    num1.setText(str);
                    operation.setText(btn.getText());
                }
                break;
            case "-":
                if (!secNum) {
                    num1.setText(text.getText());
                    operation.setText(btn.getText());
                    secNum = true;
                } else {
                    buf = Float.parseFloat(num1.getText().toString()) - Float.parseFloat(text.getText().toString());
                    str = "" + buf;
                    num1.setText(str);
                    operation.setText(btn.getText());
                }
                break;
            case "+":
                if (!secNum) {
                    num1.setText(text.getText());
                    operation.setText(btn.getText());
                    secNum = true;
                } else {
                    buf = Float.parseFloat(num1.getText().toString()) + Float.parseFloat(text.getText().toString());
                    str = "" + buf;
                    num1.setText(str);
                    operation.setText(btn.getText());
                }
                break;
        }
        text.setText("0");
        point = false;
    }

    public void onButtonClickStart(View view) {
        EditText text = (EditText) findViewById(R.id.editText);
        TextView num1 = (TextView) findViewById(R.id.num1);
        TextView operation = (TextView) findViewById(R.id.operation);
        String str;
        float buf;
        switch (operation.getText().toString()) {
            case "/":
                buf = Float.parseFloat(num1.getText().toString()) / Float.parseFloat(text.getText().toString());
                str = "" + buf;
                num1.setText(str);
                break;
            case "*":
                buf = Float.parseFloat(num1.getText().toString()) * Float.parseFloat(text.getText().toString());
                str = "" + buf;
                num1.setText(str);
                break;
            case "-":
                buf = Float.parseFloat(num1.getText().toString()) - Float.parseFloat(text.getText().toString());
                str = "" + buf;
                num1.setText(str);
                break;
            case "+":
                buf = Float.parseFloat(num1.getText().toString()) + Float.parseFloat(text.getText().toString());
                str = "" + buf;
                num1.setText(str);
                break;
        }
        operation.setText("");
        text.setText("0");
        secNum = false;
        eql = true;
        point = false;
    }
*/