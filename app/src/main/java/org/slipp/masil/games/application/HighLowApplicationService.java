package org.slipp.masil.games.application;

import lombok.AccessLevel;
import lombok.Getter;
import org.slipp.masil.games.domains.highrow.*;
import org.slipp.masil.games.domains.highrow.judge.HighLowJudge;
import org.slipp.masil.games.domains.highrow.judge.ThreeDigitHighLowJudge;
import org.slipp.masil.games.domains.target.Target;
import org.slipp.masil.games.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HighLowApplicationService {

    @Getter(value = AccessLevel.PACKAGE)
    final HighLowPlayService highLowPlayService;

    public HighLowApplicationService(HighLowPlayingContextRepository contextRepository, HighLowJudge judge) {
        this.highLowPlayService = new HighLowPlayService(contextRepository, judge);
    }

    @Transactional
    public void start() {
        HighLowPlayStart command = new HighLowPlayStart("Foo");
        Target target = Target.createBy(() -> RandomUtils.nextLong(1, 999));
        getHighLowPlayService().start(command, target);
    }

    @Transactional
    public void exit() {
        HighLowPlayStop command = new HighLowPlayStop(1L, "Foo");
        getHighLowPlayService().stop(command);
    }
}
