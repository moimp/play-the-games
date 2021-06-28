package org.slipp.masil.games.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slipp.masil.games.domains.highrow.DifficultyLevel;
import org.slipp.masil.games.domains.highrow.HighLowPlayService;
import org.slipp.masil.games.domains.highrow.HighLowPlayingContextRepository;
import org.slipp.masil.games.domains.highrow.StartHighLowPlay;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class HighLowApplicationServiceTest {


    @InjectMocks
    HighLowApplicationService sut;

    @Mock
    HighLowPlayService service;

    ArgumentCaptor<StartHighLowPlay> ac = ArgumentCaptor.forClass(StartHighLowPlay.class);

    @Test
    void startWithLevel() {

        sut.start("GilDong", "EASY");

        verify(service).start(ac.capture());

        assertThat(ac.getValue())
                .isEqualTo(StartHighLowPlay.of("GilDong", DifficultyLevel.EASY));

    }
}