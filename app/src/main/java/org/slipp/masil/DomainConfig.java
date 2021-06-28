package org.slipp.masil;

import org.slipp.masil.games.domains.highrow.HighLowPlayService;
import org.slipp.masil.games.domains.highrow.HighLowPlayingContextRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {
    @Bean
    HighLowPlayService highLowPlayService(HighLowPlayingContextRepository highLowPlayingContextRepository){
        return new HighLowPlayService(highLowPlayingContextRepository);
    }
}
