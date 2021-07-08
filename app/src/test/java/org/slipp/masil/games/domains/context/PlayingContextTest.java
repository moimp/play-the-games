package org.slipp.masil.games.domains.context;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slipp.masil.games.domains.game.GameId;
import org.slipp.masil.games.domains.highrow.Score;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slipp.masil.games.domains.PlayState.INIT;

class PlayingContextTest {

    GameId gameId = GameId.of(2L);
    String userName = "Mike";
    PlayingContext sut;

    @BeforeEach
    void setUp() {
        sut = PlayingContext.by(gameId, userName);
    }

    @Test
    void init() {
        assertThat(sut.getGameId()).isEqualTo(gameId);
        assertThat(sut.getUserName()).isEqualTo(userName);
        assertThat(sut.getStartAt()).isEqualToIgnoringNanos(LocalDateTime.now());
        assertThat(sut.getState()).isEqualTo(INIT);
        assertThat(sut.getScore()).isEqualTo(Score.of(0));
    }

    @Test
    void start() {
        sut.start();

        assertThat(sut.isOn()).isTrue();
    }

    @Test
    void stop() {
        sut.start();
        sut.stop();

        assertThat(sut.isOff()).isTrue();
    }

    @Test
    void match() {
        sut.start();
        sut.match();

        assertThat(sut.isOff()).isTrue();
    }

    @Test
    void tryPlay() {
        sut.start();
        sut.retry();

        assertThat(sut.getScore()).isEqualTo(Score.of(1));
    }
}
