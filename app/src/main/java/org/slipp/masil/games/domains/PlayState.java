package org.slipp.masil.games.domains;

public enum PlayState {
    INIT, ON_GAME, ENDED;

    public PlayState changeTo(PlayState state) {
        return state;
    }
}
