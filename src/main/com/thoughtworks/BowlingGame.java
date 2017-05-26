package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

class BowlingGame {
    private List<Integer> rolls = new ArrayList<>();

    public void roll( int pins ) {
        rolls.add( pins );
    }

    public int getScore() {
        int score = 0;
        int rollIndex = 0;

        for ( int counter = 0; counter < 9; counter++ ) {
            if ( isStrike( rollIndex ) ) {
                score += 10 + bonusScoreByStrike( rollIndex );
                rollIndex += 1;
            }
            if ( isSpare( rollIndex ) ) {
                score += 10 + bonusScoreBySpare( rollIndex );
                rollIndex += 2;
            } else {
                score += getScoreOfCurrentFrame( rollIndex );
                rollIndex += 2;
            }
        }
        return score;
    }
    private boolean isSpare( int rollIndex ) {
        return rolls.get( rollIndex ) + rolls.get( rollIndex + 1 ) == 10;
    }

    private boolean isStrike( int rollIndex ) {
        return rolls.get( rollIndex ) == 10;
    }

    private int bonusScoreByStrike( int rollIndex ) {
        return rolls.get( rollIndex + 1 ) + rolls.get( rollIndex + 2 );
    }

    private int bonusScoreBySpare( int rollIndex ) {
        return rolls.get( rollIndex + 2 );
    }

    private int getScoreOfCurrentFrame( int rollIndex ) {
        return rolls.get( rollIndex ) + rolls.get( rollIndex + 1 );
    }


}
