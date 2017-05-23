package com.thoughtworks;

class BowlingGame {
    private int score = 0;

    public int getScore() {
        return score;
    }

    public void roll( int pins ) {
        setScore( pins );
    }

    public void setScore( int score ) {
        this.score += score;
    }
}
