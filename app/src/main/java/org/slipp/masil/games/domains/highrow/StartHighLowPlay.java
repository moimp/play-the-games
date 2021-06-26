package org.slipp.masil.games.domains.highrow;

import lombok.Value;
import org.slipp.masil.games.domains.game.GameId;

@Value(staticConstructor = "of")
public class StartHighLowPlay {
    String username;
    DifficultyLevel level;

    public GameId getGameId() {
        return GameId.of(1L);
    }

    public String getUsername() {
        return username;
    }
}
