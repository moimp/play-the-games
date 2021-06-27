package org.slipp.masil.games.domains.highrow;

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
