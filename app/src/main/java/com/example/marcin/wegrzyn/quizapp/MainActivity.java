package com.example.marcin.wegrzyn.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "test";
    private boolean [] answer = new boolean[4];

    RadioButton firstRadioBtn;
    RadioButton secondRadioBtn;
    
    CheckBox firstCheckBox;
    CheckBox secondCheckBox;
    CheckBox fourthCheckBox;
    CheckBox fifthCheckBox;

    EditText editText;
    TextView submitTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstRadioBtn = (RadioButton) findViewById(R.id.firstQclick);
        secondRadioBtn = (RadioButton) findViewById(R.id.secondRadioBtn);

        firstCheckBox = (CheckBox) findViewById(R.id.firstCheckBox);
        secondCheckBox = (CheckBox) findViewById(R.id.secondCheckBox);
        fourthCheckBox = (CheckBox) findViewById(R.id.fourthCheckBox);
        fifthCheckBox = (CheckBox) findViewById(R.id.fifthCheckBox);

        editText = (EditText) findViewById(R.id.editText);
        submitTextView = (TextView) findViewById(R.id.submTextV);

        Button submitButton = (Button) findViewById(R.id.subminBtn);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
                showScore();
                Log.d(TAG,"-------->");
                Log.d(TAG,String.valueOf(answer[0]));
                Log.d(TAG,String.valueOf(answer[1]));
                Log.d(TAG,String.valueOf(answer[2]));
                Log.d(TAG,String.valueOf(answer[3]));
            }
        });

    }
    public void check(){
       
        answer[0] = firstRadioBtn.isChecked();
        
        if(firstCheckBox.isChecked()
                && secondCheckBox.isChecked()
                && fifthCheckBox.isChecked()
                &&!fourthCheckBox.isChecked()) answer[1] = true; else answer [1] = false;
        
        String s = String.valueOf(editText.getText());
        if (s.equalsIgnoreCase(getString(R.string.turbocharger))) answer[2] = true;
        else answer[2] = false;

        answer[3] = secondRadioBtn.isChecked();
    }
    public void showScore(){

        String textToshow = "";
        String nl = "\n";
        int score = 0;

        for (int i =0 ; i<answer.length; i++){
            if (answer[i]) score ++;
            else textToshow +=getString(R.string.answ_nr)+String.valueOf(i+1)+getString(R.string.not_correct)+nl;
        }
        Log.d(TAG,String.valueOf(score));

        textToshow+=nl+getString(R.string.result_is)+String.valueOf(score)+getString(R.string.for_for)+nl;
        submitTextView.setText(textToshow);

        if(score == answer.length)
            Toast.makeText(getBaseContext(), R.string.awesome,Toast.LENGTH_LONG).show();
    }

}
