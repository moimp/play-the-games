package org.slipp.masil.games.domains.highrow;

import lombok.Value;

@Value(staticConstructor = "of")
public class GuessHighLowNumber {
    Long contextId;
    Long guessNumber;
}
