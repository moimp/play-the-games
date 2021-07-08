package org.slipp.masil.games.domains.context;

public class PlayingStopped extends AbstractBaseballPlayEvent<PlayingContext> {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public PlayingStopped(PlayingContext source) {
        super(source);
    }
}
