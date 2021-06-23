package org.slipp.masil.games.domains.highrow;


public class HighLowJudge {

    private final Target target;

    public HighLowJudge(Target target) {
        this.target = target;
    }

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
