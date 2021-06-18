package org.slipp.masil.games.domains;

import java.util.Objects;

public enum PlayState {
    INIT, ON_GAME, ENDED;

    public PlayState changeTo(PlayState state) {
        if (Objects.isNull(state)) {
            throw new IllegalArgumentException("state is invalid");
        }
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
