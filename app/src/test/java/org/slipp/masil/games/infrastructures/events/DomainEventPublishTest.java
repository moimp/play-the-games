package org.slipp.masil.games.infrastructures.events;

import org.junit.jupiter.api.Test;
import org.slipp.masil.games.application.HighLowApplicationService;
import org.slipp.masil.games.domains.highrow.HighLowPlayingContextRepository;
import org.slipp.masil.games.domains.highrow.HighLowPlayStarted;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@RecordApplicationEvents
@SpringBootTest
class DomainEventPublishTest {

    @Autowired
    HighLowApplicationService highLowApplicationService;

    @Autowired
    HighLowPlayingContextRepository repository;

    @Autowired
    ApplicationEvents applicationEvents;

    @Test
    @Rollback
    void publishStartedEvent() {
        highLowApplicationService.start("mike");

        assertThat(applicationEvents.stream(HighLowPlayStarted.class)).hasSize(1);
    }
}
