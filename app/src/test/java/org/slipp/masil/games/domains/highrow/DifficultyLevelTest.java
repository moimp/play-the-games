package org.slipp.masil.games.domains.highrow;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DifficultyLevelTest {

    @Test
    void rangeOfLevel() {
       assertThat(DifficultyLevel.EASY.range())
               .isEqualTo(DifficultyLevel.Range.of(1L,10L));
        assertThat(DifficultyLevel.NORMAL.range())
                .isEqualTo(DifficultyLevel.Range.of(1L,1000L));
        assertThat(DifficultyLevel.HARD.range())
                .isEqualTo(DifficultyLevel.Range.of(1L,10000L));
    }
}