package org.slipp.masil.games.domains.highrow;

import lombok.Getter;
import org.slipp.masil.games.domains.PlayState;
import org.slipp.masil.games.domains.Score;
import org.slipp.masil.games.domains.game.GameId;
import org.slipp.masil.games.domains.target.Target;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.relational.core.mapping.Embedded;

import java.time.LocalDateTime;
import java.util.Objects;

import static org.slipp.masil.games.domains.PlayState.ENDED;
import static org.slipp.masil.games.domains.PlayState.ON_GAME;

public class HighLowPlayingContext extends AbstractAggregateRoot<HighLowPlayingContext> {

    public static final Long INIT_VERSION = null;
    @Id
    @Getter
    private final Long id;
    @Getter
    @Version
    private final Long version;
    @Getter
    private GameId gameId;
    @Getter
    private String userName;
    @Getter
    private LocalDateTime startAt;
    @Getter
    @Embedded(onEmpty = Embedded.OnEmpty.USE_EMPTY)
    private Target target;
    @Getter
    private PlayState state;
    @Getter
    private Score score;

    private HighLowPlayingContext(Long id,
                                  GameId gameId, String userName,
                                  LocalDateTime startAt,
                                  Target target,
                                  PlayState state, Score score,
                                  Long version) {
        this.id = id;
        if (Objects.isNull(gameId) && Objects.isNull(userName)) {
            throw new IllegalStateException(" is invalid");
        }
        setGameId(gameId);
        setUserName(userName);
        setStartAt(startAt);
        setTarget(target);
        setState(state);
        setScore(score);
        this.version = version;
    }

    public static HighLowPlayingContext by(GameId gameId, String userName, LocalDateTime startAt, Target target) {
        return new HighLowPlayingContext(null, gameId, userName, startAt, target, ON_GAME, Score.of(0), INIT_VERSION);
    }

    private void setStartAt(LocalDateTime startAt) {
        this.startAt = startAt;
    }


    private void setUserName(String userName) {
        this.userName = userName;
    }

    private void setGameId(GameId gameId) {
        this.gameId = gameId;
    }

    private void setTarget(Target target) {
        if (target.getValue() < 0) {
            throw new IllegalStateException("target is invalid");
        }
        this.target = target;
    }

    public void setState(PlayState state) {
        if (Objects.isNull(state)) {
            throw new IllegalArgumentException("state is invalid");
        }
        this.state = state;
    }

    public void setScore(Score score) {
        if (Objects.isNull(score) || score.isValid() == false) {
            throw new IllegalArgumentException("score is invalid");
        }
        this.score = score;
    }

    public void start() {
        andEvent(new StartedHighLowPlay(this));
    }

    public void stop() {
        this.setState(ENDED);
        andEvent(new StoppedHighLowPlay(this));
    }

    public void match() {
        andEvent(new MatchedHighLowPlay(this));
    }

}
