package com.example.numbers;

//import androidx.appcompat.;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Console;
import java.util.Random;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final Random RANDOM = new Random();
    private static final int MAX_NUMBER = 100;
    private TextView msgTv;
    private EditText numberEnteredEt;
    private Button validate;
    private int numberTries;
    private int numberToFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgTv = (TextView)findViewById(R.id.msg);
        numberEnteredEt=(EditText)findViewById(R.id.numberEnteredEt);
        validate=(Button)findViewById(R.id.validate);
        validate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == validate){
        validate();
        }
    }
    private void validate(){
        numberToFind = RANDOM.nextInt(MAX_NUMBER) + 1;
        int n = Integer.parseInt(numberEnteredEt.getText().toString());
                numberTries++;
        if(n == numberToFind){
            Toast.makeText(this, "Congratulations, you guessed the number:" + numberToFind + " in " + numberTries + " tries", Toast.LENGTH_SHORT).show();
            newGame();

        }else if(n > numberToFind){
            msgTv.setText(R.string.too_high);

        }else if(n < numberToFind){
            msgTv.setText(R.string.too_low);
        }
    }
    private void newGame(){
        numberToFind = RANDOM.nextInt(MAX_NUMBER) + 1;
        msgTv.setText(R.string.start_message);
        numberEnteredEt.setText("");
        numberTries = 0;
    }
}