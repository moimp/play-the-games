package org.slipp.masil.games.infrastructures.events;

import org.junit.jupiter.api.Test;
import org.slipp.masil.games.application.HighLowApplicationService;
import org.slipp.masil.games.domains.highrow.HighLowPlayingContextRepository;
import org.slipp.masil.games.domains.highrow.StartedHighLowPlay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import static org.assertj.core.api.Assertions.assertThat;

@RecordApplicationEvents
@SpringBootTest
class HighLowPlayingContextDomainEventTest {

    @Autowired
    HighLowApplicationService highLowApplicationService;

    @Autowired
    HighLowPlayingContextRepository repository;

    @Autowired
    ApplicationEvents applicationEvents;

    @Test
    void publishStartedEvent() {
        highLowApplicationService.start();

        assertThat(applicationEvents.stream(StartedHighLowPlay.class)).hasSize(1);
    }
}