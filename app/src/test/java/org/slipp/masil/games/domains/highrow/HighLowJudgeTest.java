package org.slipp.masil.games.domains.highrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slipp.masil.games.domains.highrow.HighLowJudgement.*;

// TODO Target 을 Context 가 알아야 하는 이유는 무엇일까?
//  그럼 Score 와 같은 동급이라는 건데, 그런 의미가 있나?
class HighLowJudgeTest {

    HighLowJudge sut;

    @BeforeEach
    void setUp() {
        Target target = Target.of(3L);
        sut = new HighLowJudge(target);
    }

    @Test
    void judge() {

        // Target is 3
        assertThat(sut.judge(1L)).isEqualTo(LOW);
        assertThat(sut.judge(4L)).isEqualTo(HIGH);
        assertThat(sut.judge(3L)).isEqualTo(MATCH);
    }

}
