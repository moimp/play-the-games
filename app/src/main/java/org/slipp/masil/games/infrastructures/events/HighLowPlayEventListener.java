package org.slipp.masil.games.infrastructures.events;

import org.slipp.masil.games.domains.highrow.AbstractHighLowPlayEvent;
import org.slipp.masil.games.infrastructures.events.sotre.EventStore;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class HighLowPlayEventListener implements ApplicationListener<AbstractHighLowPlayEvent<?>> {

    EventStore eventStore;

    public HighLowPlayEventListener(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public void onApplicationEvent(AbstractHighLowPlayEvent<?> event) {
        this.eventStore.save(EventEnvelop.of(event));
    }
}
