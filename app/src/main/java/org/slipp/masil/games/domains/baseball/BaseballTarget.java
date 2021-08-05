package org.slipp.masil.games.domains.baseball;

import lombok.Getter;
import org.slipp.masil.games.domains.context.PlayingContextId;
import org.springframework.data.annotation.Id;

/**
 * TODO value 를 바꿔야 될 일이 있을까?
 */
public class BaseballTarget {

    @Id
    @Getter
    private BaseballTargetId id;
    @Getter
    private PlayingContextId playingContextId;
    @Getter
    private Long value;

    public BaseballTarget(BaseballTargetId id, PlayingContextId playingContextId, Long value) {
        this.id = id;
        this.playingContextId = playingContextId;
        this.value = value;
    }

    public static BaseballTarget of(PlayingContextId playingContextId, Long value) {
        return new BaseballTarget(null, playingContextId, value);
    }
}
