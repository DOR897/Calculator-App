package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView inputText,outputText ;
    private String output, input , newOutput ;
    private Button buttonC ,buttonAdds ,buttonSub ,buttonDiv ,buttonMul,buttonEquals,buttonOne,buttonTwo,buttonThree,buttonFour,buttonFive,buttonSix,buttonSeven,buttonEight,buttonNine,buttonZero;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);
        buttonC = findViewById(R.id.buttonC);
        buttonAdds = findViewById(R.id.buttonAdds);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonDiv= findViewById(R.id.buttonDiv);
        buttonZero = findViewById(R.id.buttonZero);
        buttonOne = findViewById(R.id.buttonOne);
        buttonTwo = findViewById(R.id.buttonTwo);
        buttonThree = findViewById(R.id.buttonThree);
        buttonFour = findViewById(R.id.buttonFour);
        buttonFive = findViewById(R.id.buttonFive);
        buttonSix = findViewById(R.id.buttonSix);
        buttonSeven = findViewById(R.id.buttonSeven);
        buttonEight = findViewById(R.id.buttonEight);
        buttonNine = findViewById(R.id.buttonNine);
    }

    public void ButtonClickFunction(View view) {
        if (view instanceof Button) {
            Button button = (Button) view;
            String str = button.getText().toString();
            inputText.append(str);
            switch (str) {
                case "C":
                    input = null;
                    output = null;
                    newOutput = null;
                    outputText.setText("");
                    break;

                case "*":
                    solve();
                    input += "*";
                    break;
                case "=":
                    solve();
                    break;
                default:
                    if (input == null) {
                        input = "";

                    }
                    if (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*")){
                        solve();
                    }
                    input += str;
            }
            inputText.setText(input);
        }
    }
    private void solve() {
        if (input.split("\\+").length == 2) {
            String numbers[] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDetc(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }

        }
        if (input.split("\\-").length == 2) {
            String numbers[] = input.split("\\-");
            try {
                if(Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])){
                double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                output = Double.toString(d);
                newOutput = cutDetc(output);
                outputText.setText("-" + newOutput);
                input = d + "";}
                else{
                        double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                        output = Double.toString(d);
                        newOutput = cutDetc(output);
                        outputText.setText(newOutput);
                        input = d + "";}

            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }
        if (input.split("\\*").length == 2) {
            String numbers[] = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDetc(output);
                outputText.setText( newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }

        }
        if (input.split("\\/").length == 2) {
            String numbers[] = input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDetc(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }

        }
    }
    private String cutDetc(String number)
    {
                String n [] = number.split("\\.");
                if(n.length > 1 )
                {
                    if (n[1].equals("0")){
                        number = n[0];
                    }
                }
                return number;


        }


}