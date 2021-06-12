package org.slipp.masil.games.domains.highrow.judge;

import org.slipp.masil.games.domains.highrow.HighLowJudgement;
import org.slipp.masil.games.domains.target.Target;

public interface HighLowJudge {
    HighLowJudgement judge(Long guessNumber, Target target);
}
