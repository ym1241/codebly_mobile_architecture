package com.codebly.recyclerview_example1;

public class QnAItem {
    private String question;
    private String answer;
    private boolean isExpanded;

    public QnAItem(String question, String answer) {
        this.question = question;
        this.answer = answer;
        this.isExpanded = false;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}

