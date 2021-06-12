package org.slipp.masil.games.domains.highrow.judge;

import org.slipp.masil.games.domains.highrow.HighLowJudgement;
import org.slipp.masil.games.domains.target.Target;
import org.springframework.stereotype.Component;

@Component
public class ThreeDigitHighLowJudge implements HighLowJudge {

    @Override
    public HighLowJudgement judge(Long guessNumber, Target target) {
        if (guessNumber <= 0 || guessNumber > 999) {
            throw new IllegalArgumentException("Invalid guess number");
        }

        if (target.getValue() <= 0 || target.getValue() > 999) {
            throw new IllegalArgumentException("Invalid target number");
        }

        if (target.getValue() > guessNumber) {
            return HighLowJudgement.LOW;
        }

        if (target.getValue() < guessNumber) {
            return HighLowJudgement.HIGH;
        }

        return HighLowJudgement.MATCH;
    }
}
