package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

class BowlingGame {
    private List<Integer> rolls = new ArrayList();

    public void roll( int pins ) {
        rolls.add( pins );
    }

    public int getScore() {
        int score = 0;
        int rollIndex = 0;
        int frame = 0;

        while ( frame <= 9 ) {
            if ( isStrike( rollIndex ) ) {
                score += 10 + rolls.get( rollIndex + 1 ) + rolls.get( rollIndex + 2 );
                rollIndex += 1;
                frame++;
            }
            if ( isSpare( rollIndex ) ) {
                score += 10 + rolls.get( rollIndex + 2 );
                rollIndex += 2;
                frame++;
            } else {
                score += rolls.get( rollIndex ) + rolls.get( rollIndex + 1 );
                rollIndex += 2;
                frame++;
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

}
