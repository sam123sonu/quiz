package com.example.sambitmohapatra.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;
    private TextView qsn1;
    private ImageButton next;
    private int index = 0;
    private question[] questionbank = new question[]
            {new question(R.string.qsn1, true),
                    new question(R.string.qsn2, false),
                    new question(R.string.qsn3, false),
                    new question(R.string.qsn4, true),
                    new question(R.string.qsn5, true),
                    new question(R.string.qsn6, false),
                    new question(R.string.qsn7, false),
                    new question(R.string.qsn8, true),
                    new question(R.string.qsn9, false),
                    new question(R.string.qsn10, false)
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        falseButton = findViewById(R.id.false_Button);
        trueButton = findViewById(R.id.true_Button);
        qsn1 = findViewById(R.id.text);
        next = findViewById(R.id.nextbutton);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.true_Button:
                check(true);
                break;
            case R.id.false_Button:
                check(false);
                break;
            case R.id.nextbutton: {
                index = (index + 1) % questionbank.length;
                update();
            }
        }
    }
    private void update() {
        int click = Log.d("click", "onClick: " + index);
        qsn1.setText(questionbank[index].getAnswerResId());
    }

    private void check(boolean user) {
        boolean answerTrue = questionbank[index].isAnswerTrue();
        int numid;
        if (answerTrue == user)
            numid = R.string.true_answer;
        else
            numid = R.string.false_answer;
        Toast.makeText(MainActivity.this, numid, Toast.LENGTH_SHORT).show();
    }

}