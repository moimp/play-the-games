package org.slipp.masil.games.infrastructures.events.jdbc;

import org.junit.jupiter.api.Test;
import org.slipp.masil.games.domains.highrow.StartHighLowPlay;
import org.slipp.masil.games.domains.highrow.HighLowPlayingContext;
import org.slipp.masil.games.domains.highrow.HighLowPlayingContextFactory;
import org.slipp.masil.games.domains.highrow.HighLowPlayStarted;
import org.slipp.masil.games.infrastructures.events.EventEnvelop;
import org.slipp.masil.games.infrastructures.events.sotre.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;


@Transactional
@SpringBootTest
@ActiveProfiles("local")
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
class JdbcEventStoreRepositoryTest {


    @Autowired
    EventStore eventStore;

    @Test
    @Rollback
    void save() {
        HighLowPlayingContext context = HighLowPlayingContextFactory.DEFAULT.create(new StartHighLowPlay("Foo"));
        HighLowPlayStarted domainEvent = new HighLowPlayStarted(context);
        EventEnvelop eventEnvelop = EventEnvelop.of(domainEvent);
        eventStore.save(eventEnvelop);
    }
}