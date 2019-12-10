package com.jofiagtech.truecitizenquiz;

public class Question
{
    private int answerId;
    private boolean rightAnswer;

    public Question(int answerId, boolean rightAnswer)
    {
        this.answerId = answerId;
        this.rightAnswer = rightAnswer;
    }

    public int getAnswerId()
    {
        return answerId;
    }

    public void setAnswerId(int answerId)
    {
        this.answerId = answerId;
    }

    public boolean isRightAnswer()
    {
        return rightAnswer;
    }

    public void setRightAnswer(boolean rightAnswer)
    {
        this.rightAnswer = rightAnswer;
    }
}
