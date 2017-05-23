package com.thoughtworks;

import org.junit.Assert;
import org.junit.Test;

public class BowlingGameTest {

    @Test
    public void failsToKnockEvenSinglePin() {
        final BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll( 0 );
        bowlingGame.roll( 0 );
        Assert.assertEquals( 0, bowlingGame.getScore() );
    }

    @Test
    public void knockOfSinglePinResultsInScore1() {
        final BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll( 1 );
        bowlingGame.roll( 0 );
        Assert.assertEquals( 1, bowlingGame.getScore() );
    }

    @Test
    public void getsScoreOfNumberOfBallsKnocked() {
        final BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll( 5 );
        bowlingGame.roll( 2 );
        bowlingGame.roll( 6 );
        bowlingGame.roll( 7 );
        bowlingGame.roll( 8 );
        bowlingGame.roll( 1 );
        bowlingGame.roll( 4 );
        bowlingGame.roll( 7 );
        bowlingGame.roll( 6 );
        bowlingGame.roll( 8 );
        Assert.assertEquals( 54, bowlingGame.getScore() );
    }
}

