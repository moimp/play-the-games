package org.slipp.masil.games.infrastructures.listeners;

import org.slipp.masil.games.domains.highrow.HighLowPlayingContext;
import org.slipp.masil.games.domains.highrow.MatchedHighLowPlay;
import org.slipp.masil.games.infrastructures.events.DomainEvent;
import org.slipp.masil.games.infrastructures.events.sotre.EventStore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HighLowPlayEventListener {

    EventStore eventStore;
    ApplicationContext applicationContext;

    public HighLowPlayEventListener(EventStore eventStore ,ApplicationContext applicationContext) {
        this.eventStore = eventStore;
        this.applicationContext = applicationContext;
    }


    @EventListener
    public void onApplicationEvent(DomainEvent<HighLowPlayingContext> event) {
        //TODO 추후 relay 가 만들어지면 사용하자
        // this.eventStore.save(EventEnvelop.of(event));

        if (event instanceof MatchedHighLowPlay ) {
            HighLowPlayingContext aggregateRoot = event.getAggregateRoot();
            RankingRefreshEvent rankingRefresh = new RankingRefreshEvent(aggregateRoot);
            applicationContext.publishEvent(rankingRefresh);
        }

    }
}
