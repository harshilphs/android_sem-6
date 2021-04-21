package com.harshilphs.calcprac4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private TextView res;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (EditText) findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        res = (TextView) findViewById(R.id.resultView);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                    res.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0,cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
            display.setSelection(cursorPos+1);
        } else {
            display.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
            display.setSelection(cursorPos+1);
        }

    }

    public void zeroBtn(View view){
        updateText("0");
    }
    public void oneBtn(View view){
        updateText("1");
    }
    public void twoBtn(View view){
        updateText("2");
    }
    public void threeBtn(View view){
        updateText("3");
    }
    public void fourBtn(View view){
        updateText("4");
    }
    public void fiveBtn(View view){
        updateText("5");
    }
    public void sixBtn(View view){
        updateText("6");
    }
    public void sevenBtn(View view){
        updateText("7");
    }
    public void eightBtn(View view){
        updateText("8");
    }
    public void nineBtn(View view){
        updateText("9");
    }


    public void clearBtn(View view){
        display.setText("");
        res.setText("");
    }
    public void exponentBtn(View view){
        updateText("^");
    }
    public void parenthesisBtn(View view){
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closePar = 0;
        int textLen = display.getText().length();

        for(int i=0;i<cursorPos;i++){
            if(display.getText().toString().substring(i,i+1).equals("(")){
                openPar += 1;
            }
            if(display.getText().toString().substring(i,i+1).equals(")")){
                closePar += 1;
            }
        }
        if(openPar == closePar || display.getText().toString().substring(textLen-1,textLen).equals("(")){
            updateText("(");
        }
        else if(closePar < openPar && !display.getText().toString().substring(textLen-1,textLen).equals("(")){
            updateText(")");
        }
        display.setSelection(cursorPos+1);
    }
    public void divideBtn(View view){
        updateText("/");
    }
    public void multiplyBtn(View view){
        updateText("*");
    }
    public void addBtn(View view){
        updateText("+");
    }
    public void subtractBtn(View view){
        updateText("-");
    }
    public void pointBtn(View view){
        updateText(".");
    }
    public void equalsBtn(View view){
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷","/");
        userExp = userExp.replaceAll("×","*");

        Expression exp =new Expression(userExp);
        String result = String.valueOf(exp.calculate());
//        display.setText(result);
//        display.setSelection(result.length());
        res.setText(result);

    }
    public void backspaceBtn(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();
        if(cursorPos!=0 && textLen!=0){
            SpannableStringBuilder selection = (SpannableStringBuilder)display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
}