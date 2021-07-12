package org.slipp.masil.games.domains.baseball;

import org.slipp.masil.games.domains.context.PlayingContextId;

public class BaseballTarget {

    private PlayingContextId playingContextId;
    private long value;

    public BaseballTarget(Long id, PlayingContextId playingContextId, long value) {
        this.playingContextId = playingContextId;
        this.value = value;
    }

    public static BaseballTarget of(PlayingContextId playingContextId, long value) {
        return new BaseballTarget(null, playingContextId, value);

    }

    public PlayingContextId getPlayingContextId() {
        return this.playingContextId;
    }

    public long getValue() {
        return this.value;
    }
}
