package com.jofiagtech.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button trueButton;
    private Button falseButton;
    private TextView questionText;
    private ImageButton nextButton;
    private ImageButton previewButton;

    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[]{
            new Question(R.string.question_amendments, false),
            new Question(R.string.question_constitution, true),
            new Question(R.string.question_declaration, true),
            new Question(R.string.question_independence_rights, true),
            new Question(R.string.question_religion, true),
            new Question(R.string.question_government, false),
            new Question(R.string.question_government_feds, false),
            new Question(R.string.question_government_senators, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        questionText = findViewById(R.id.question_text);
        nextButton = findViewById(R.id.next_button);
        previewButton = findViewById(R.id.preview_button);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        previewButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.true_button:
                checkAnswer(true);
                break;
            case R.id.false_button:
                checkAnswer(false);
                break;
            case R.id.next_button:
                //go to next question
                currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                updateQuestion();
                break;
            case R.id.preview_button:
                if (currentQuestionIndex == 0)
                    currentQuestionIndex = questionBank.length;
                if (currentQuestionIndex >= 1)
                    currentQuestionIndex  -= 1;
                updateQuestion();
                break;
        }
    }

    private void updateQuestion(){
        questionText.setText(questionBank[currentQuestionIndex].getAnswerId());
    }

    private void checkAnswer(boolean userAnswer) {
        boolean trueAnswer = questionBank[currentQuestionIndex].isRightAnswer();
        int toastMessage;

        if (userAnswer == trueAnswer)
            toastMessage = R.string.correct_answer;
        else
            toastMessage = R.string.wrong_answer;

        Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_SHORT).show();

    }
}
