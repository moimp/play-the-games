package org.slipp.masil.games.domains.context;

import lombok.Value;

@Value(staticConstructor = "of")
public class PlayingContextId {

    long value;
}
