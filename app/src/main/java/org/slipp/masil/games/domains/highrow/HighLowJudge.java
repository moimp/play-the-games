package org.slipp.masil.games.domains.highrow;

import org.slipp.masil.games.domains.Judge;
import org.slipp.masil.games.domains.Target;


public class HighLowJudge implements Judge {

    private final Target target;

    public HighLowJudge(Target target) {
        this.target = target;
    }

    @Override
    public HighLowJudgement judge(Long guessNumber) {
        Long value = this.target.getValue();
        if (value > guessNumber) {
            return HighLowJudgement.LOW;
        } else if (value < guessNumber) {
            return HighLowJudgement.HIGH;
        }
        return HighLowJudgement.MATCH;
    }

}
