package org.slipp.masil.games.application;

import lombok.AccessLevel;
import lombok.Getter;
import org.slipp.masil.games.domains.highrow.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HighLowApplicationService {

    @Getter(value = AccessLevel.PACKAGE)
    final HighLowPlayService highLowPlayService;

    public HighLowApplicationService(HighLowPlayingContextRepository contextRepository) {
        this.highLowPlayService = new HighLowPlayService(guessNumber -> HighLowJudgement.LOW, contextRepository);
    }

    @Transactional
    public void start() {
        StartHighLowPlay command = new StartHighLowPlay("Foo");
        getHighLowPlayService().start(command);
    }

    @Transactional
    public void exit() {
        StartHighLowPlay command = new StartHighLowPlay("Foo");
        getHighLowPlayService().start(command);
    }
}
