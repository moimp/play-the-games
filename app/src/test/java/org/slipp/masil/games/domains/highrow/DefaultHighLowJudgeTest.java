package org.slipp.masil.games.domains.highrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slipp.masil.games.domains.highrow.judge.ThreeDigitHighLowJudge;
import org.slipp.masil.games.domains.target.Target;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DefaultHighLowJudgeTest {

    private ThreeDigitHighLowJudge highLowJudge;
    private Target target_10;

    @BeforeEach
    void setUp() {
        highLowJudge = new ThreeDigitHighLowJudge();
        target_10 = Target.createBy(() -> 10L);
    }

    @Test
    void can_accept_only_1_999_guess_number() {
        assertThatThrownBy(() -> highLowJudge.judge(0L, target_10))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid guess number");

        assertThatThrownBy(() -> highLowJudge.judge(1000L, target_10))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Invalid guess number");
    }

    @Test
    void high() {
        HighLowJudgement judge = highLowJudge.judge(15L, target_10);
        assertThat(judge).isEqualTo(HighLowJudgement.HIGH);
    }

    @Test
    void low() {
        HighLowJudgement judge = highLowJudge.judge(1L, target_10);
        assertThat(judge).isEqualTo(HighLowJudgement.LOW);
    }

    @Test
    void match() {
        HighLowJudgement judge = highLowJudge.judge(10L, target_10);
        assertThat(judge).isEqualTo(HighLowJudgement.MATCH);
    }
}
