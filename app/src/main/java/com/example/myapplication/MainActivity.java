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
    int rnd;
    int attempts = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rnd = generateRandomInt(100);
        refreshAttempts();
    }

    public void showRnd() {
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
        Toast toast = null;
        Button btn = (Button) view;
        if (editText.getText().toString().equals("")) {
            toast = Toast.makeText(this, "Введите число!", Toast.LENGTH_SHORT);
        } else {
            if (attempts > 0) {
                int numb = Integer.parseInt(editText.getText().toString());
                if (numb == rnd) {
                    btn.setEnabled(false);
                    toast = Toast.makeText(this, "Победа! Вы угадали!", Toast.LENGTH_SHORT);
                } else {
                    if (numb > rnd - 20 && numb < rnd + 20) {
                        toast = Toast.makeText(this, "Очень тепло!", Toast.LENGTH_SHORT);
                    } else if (numb > rnd - 40 && numb < rnd + 40) {
                        toast = Toast.makeText(this, "Тепло!", Toast.LENGTH_SHORT);
                    } else if (numb > rnd - 60 && numb < rnd + 60) {
                        toast = Toast.makeText(this, "Холодно!", Toast.LENGTH_SHORT);
                    } else {
                        toast = Toast.makeText(this, "Очень холодно!", Toast.LENGTH_SHORT);
                    }
                    attempts--;
                    refreshAttempts();
                }
            } else {
                toast = Toast.makeText(this, "У вас не осталось попыток, начните новую игру! Число которое было загадано: " + rnd, Toast.LENGTH_SHORT);
            }
        }
        toast.show();
        //TODO вылет видимо выходим за диапозон надо еще один else
    }

    public void onButtonClickHint(View view) {
        Toast toast = null;
        Button btn = (Button) view;
        String switcher = btn.getText() + "";
        if (attempts - 2 < 0) {
            toast = Toast.makeText(this, "Невозможно получить подсказку! У вас меньше 2-х попыток", Toast.LENGTH_SHORT);
        } else {
            attempts -= 2;
            refreshAttempts();
            switch (switcher) {
                case "Чет/нечет":
                    toast = Toast.makeText(this, dividesByTwo(rnd), Toast.LENGTH_SHORT);
                    break;
                case "0-49/50-99":
                    toast = Toast.makeText(this, whatRange(rnd), Toast.LENGTH_SHORT);
                    break;
                case "меньше 10":
                    toast = Toast.makeText(this, sumLessTen(rnd), Toast.LENGTH_SHORT);
                    break;
            }
        }
        toast.show();
    }

    public void onButtonClickNewGame(View view) {
        attempts = 10;
        rnd = generateRandomInt(100);
        refreshAttempts();
        Button btn = (Button) findViewById(R.id.buttonGuess);
        btn.setEnabled(true);
    }

    static String dividesByTwo(int num) {
        if (num % 2 == 0) {
            return ("Четное");
        } else {
            return ("Нечетное");
        }
    }

    static String whatRange(int num) {
        if (num < 50) {
            return ("0-49");
        } else {
            return ("50-99");
        }
    }

    static String sumLessTen(int num) {
        num = Math.abs(num);
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum < 10) {
            return ("Меньше 10");
        } else {
            return ("Больше или равно 10");
        }
    }
}