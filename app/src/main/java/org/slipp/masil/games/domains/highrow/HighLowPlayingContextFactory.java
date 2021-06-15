package org.slipp.masil.games.domains.highrow;

import org.slipp.masil.games.domains.Target;

import java.time.LocalDateTime;

public interface HighLowPlayingContextFactory {

    HighLowPlayingContextFactory DEFAULT = new HighLowPlayingContextFactory() {
        @Override
        public HighLowPlayingContext create(StartHighLowPlay command) {
            return HighLowPlayingContextFactory.super.create(command);
        }
    };


    default HighLowPlayingContext create(StartHighLowPlay command) {
        return HighLowPlayingContext.by(command.getGameId(), command.getUsername(),
                LocalDateTime.now(), Target.of(10));
    }
}
