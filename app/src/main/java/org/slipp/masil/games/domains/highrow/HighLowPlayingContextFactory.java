package org.slipp.masil.games.domains.highrow;

import org.slipp.masil.games.domains.target.Target;

import java.time.LocalDateTime;

public interface HighLowPlayingContextFactory {

    HighLowPlayingContextFactory DEFAULT = new HighLowPlayingContextFactory() {
        @Override
        public HighLowPlayingContext create(HighLowPlayStart command, Target target) {
            return HighLowPlayingContextFactory.super.create(command, target);
        }
    };


    default HighLowPlayingContext create(HighLowPlayStart command, Target target) {
        return HighLowPlayingContext.by(command.getGameId(), command.getUsername(), LocalDateTime.now(), target);
    }
}
