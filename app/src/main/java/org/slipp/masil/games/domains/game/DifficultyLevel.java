package org.slipp.masil.games.domains.game;

import org.slipp.masil.games.domains.Target;

import java.util.function.Supplier;

public enum DifficultyLevel {

    EASY(() -> 1L);

    private final Supplier<Long> generator;

    DifficultyLevel(Supplier<Long> generator) {
        this.generator = generator;
    }

    public Target create() {
        //TODO Generate RandomNumber
        return Target.of(generator.get());
    }
}
