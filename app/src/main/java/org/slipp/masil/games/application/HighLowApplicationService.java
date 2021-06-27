package org.slipp.masil.games.application;

import lombok.AccessLevel;
import lombok.Getter;
import org.slipp.masil.games.domains.highrow.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.slipp.masil.games.domains.highrow.DifficultyLevel.EASY;

@Service
@Transactional
public class HighLowApplicationService {

    @Getter(value = AccessLevel.PACKAGE)
    final HighLowPlayService highLowPlayService;

    public HighLowApplicationService(HighLowPlayService service) {
        this.highLowPlayService = service;
    }

    @Transactional
    public Long start(String name) {
        StartHighLowPlay command = StartHighLowPlay.of(name, EASY);
        return getHighLowPlayService().start(command);
    }

    @Transactional
    public Long start(String name, String level) {
        StartHighLowPlay command = StartHighLowPlay.of(name, EASY);
        return getHighLowPlayService().start(command);
    }

    @Transactional
    public HighLowJudgement play(GuessHighLowNumber guessHighLowNumber) {
        HighLowPlayingResult result = getHighLowPlayService().play(guessHighLowNumber);
        return result.getJudgement();
    }

    @Transactional
    public void exit() {
        throw new UnsupportedOperationException("Not yet implement");
        //getHighLowPlayService().stop(command);
    }
}
