package org.slipp.masil.games.domains.highrow;

import lombok.Value;
import org.slipp.masil.games.util.RandomUtil;

public enum DifficultyLevel {
    EASY(Range.of(1L,10L)),
    NORMAL(Range.of(1L,1000L)),
    HARD(Range.of(1L,10000L));

    private final Range range;

    DifficultyLevel(Range range) {
        this.range = range;
    }

    public Target create() {
        return Target.of(RandomUtil.generateNumbers(this.range.startInclusive, this.range.endInclusive));
    }

    Range range() {
        return range;
    }

    @Value(staticConstructor = "of")
    static class Range {
        long startInclusive;
        long endInclusive;
    }
}
