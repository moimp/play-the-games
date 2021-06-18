package org.slipp.masil.games.domains;

public enum PlayState {
    INIT, ON_GAME, ENDED;

    public PlayState changeTo(PlayState state) {
        if(isOn() && state == ON_GAME) {
            throw new IllegalStateException();
        }

        if(! isOn() && state == ENDED) {
            throw new IllegalStateException();
        }

        if(isOff() && state == ON_GAME) {
            throw new IllegalStateException();
        }

        if(isOff() && state == ENDED) {
            throw new IllegalStateException();
        }
        return state;
    }

    public boolean isOn() {
        return ON_GAME == this;
    }

    public boolean isOff() {
        return ENDED == this;
    }
}
