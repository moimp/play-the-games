package org.slipp.masil.games.domains.highrow;

import org.slipp.masil.games.domains.Target;
import org.slipp.masil.games.domains.game.DifficultyLevel;

public interface HighLowPlayingContextFactory {

    HighLowPlayingContextFactory DEFAULT = new HighLowPlayingContextFactory() {
        @Override
        public HighLowPlayingContext create(StartHighLowPlay command) {
            return HighLowPlayingContextFactory.super.create(command);
        }
    };


    default HighLowPlayingContext create(StartHighLowPlay command) {
        Target target = DifficultyLevel.EASY.create();
        return HighLowPlayingContext.by(command.getGameId(), command.getUsername(), target);
    }
}
