package org.slipp.masil.games.domains.baseball;

import org.junit.jupiter.api.Test;
import org.slipp.masil.games.domains.context.PlayingContextId;

import static org.assertj.core.api.Assertions.*;

class BaseballTargetTest {

    @Test
    void creation() {

        BaseballTarget baseballTarget = BaseballTarget.of(PlayingContextId.of(1L), 123L);

        assertThat(baseballTarget.getPlayingContextId()).isEqualTo(PlayingContextId.of(1L));
        assertThat(baseballTarget.getValue()).isEqualTo(123L);

    }


}