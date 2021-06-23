package org.slipp.masil.games.domains.highrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HighLowPlayServicePlayTest {

    private static final Long ANY_CONTEXT_ID = 0L;

    @Mock
    HighLowPlayingContextRepository repository;

    @Mock
    HighLowPlayingContext context;

    HighLowPlayService sut;

    @BeforeEach
    void setUp() {
        sut = new HighLowPlayService(repository);
        given(repository.findById(any())).willReturn(context);

    }

    @Test
    void in_high_judgement_the_context_makes_nothing() {
        given(context.getTarget()).willReturn(3L);

        sut.play(GuessHighLowNumber.of(ANY_CONTEXT_ID, 4L));

        verify(context).retry();
        verify(context, never()).match();
        verify(repository, times(1)).save(any(HighLowPlayingContext.class));
    }

    @Test
    void in_low_judgement_the_context_makes_nothing() {
        given(context.getTarget()).willReturn(3L);

        sut.play(GuessHighLowNumber.of(ANY_CONTEXT_ID, 2L));

        verify(context).retry();
        verify(context, never()).match();
        verify(repository, times(1)).save(any(HighLowPlayingContext.class));
    }

    @Test
    void in_match_judgement_the_context_occurs_command_to_match() {
        given(context.getTarget()).willReturn(3L);

        sut.play(GuessHighLowNumber.of(ANY_CONTEXT_ID, 3L));

        verify(context).match();
        verify(context).retry();
        verify(repository, times(2)).save(any(HighLowPlayingContext.class));
    }

}
