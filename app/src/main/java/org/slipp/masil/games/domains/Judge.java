package org.slipp.masil.games.domains;

import org.slipp.masil.games.domains.highrow.HighLowJudgement;

public interface Judge {
    //TODO Long Type ->  별도의 타입
    //Judge 는 하이로우만 사용하는데 ?/
    HighLowJudgement judge(Long guessNumber);

}
