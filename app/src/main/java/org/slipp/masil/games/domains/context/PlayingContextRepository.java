package org.slipp.masil.games.domains.context;

public interface PlayingContextRepository {

    PlayingContext save(PlayingContext playingContext);

    @Deprecated
    default PlayingContext findById(Long id) {
        PlayingContextId of = PlayingContextId.of(id);
        return findById(of);
    }

    PlayingContext findById(PlayingContextId id);
}
