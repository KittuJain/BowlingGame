package com.thoughtworks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() throws Exception {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void failsToKnockEvenSinglePin() {
        rollEmpty( 20 );
        Assert.assertEquals( 0, bowlingGame.getScore() );
    }

    @Test
    public void getsScoreWhenSinglePinIsKnocked() {
        bowlingGame.roll( 1 );
        rollEmpty( 19 );
        Assert.assertEquals( 1, bowlingGame.getScore() );
    }

    @Test
    public void getsScoreOfNumberOfBallsKnocked() {
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
        rollEmpty( 10 );
        Assert.assertEquals( 54, bowlingGame.getScore() );
    }

    @Test
    public void getsScoreWhenNoBonusGivenOnSpare() {
        bowlingGame.roll( 5 );
        bowlingGame.roll( 5 );
        rollEmpty( 18 );
        Assert.assertEquals( 10, bowlingGame.getScore() );
    }

    @Test
    public void getsScoreWhenBonusGivenOnSpare() {
        bowlingGame.roll( 7 );
        bowlingGame.roll( 3 );
        bowlingGame.roll( 3 );
        rollEmpty( 17 );
        Assert.assertEquals( 16, bowlingGame.getScore() );
    }

    @Test
    public void getsScoreOnStrike() {
        bowlingGame.roll( 10 );
        bowlingGame.roll( 3 );
        bowlingGame.roll( 4 );
        rollEmpty( 17 );
        Assert.assertEquals( 24, bowlingGame.getScore() );
    }

    private void rollEmpty( int times ) {
        for ( int i = 0; i < times; i++ ) {
            bowlingGame.roll( 0 );
        }
    }
}


