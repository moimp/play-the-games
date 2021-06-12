package org.slipp.masil.games.domains.highrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slipp.masil.games.domains.highrow.judge.HighLowJudge;
import org.slipp.masil.games.domains.target.Target;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

//TODO start command 가 널 일때
// TODO contextId 를 아무나 넘길수 있다... 개똥이가 플레이하고 길동이 가 개똥이 컨택스트 아이디로 하면 어까지?
@ExtendWith(MockitoExtension.class)
class HighLowPlayServiceStartTest {

    public static final long ANY_CTX_ID = 1L;

    @Mock
    HighLowPlayingContextRepository repository;

    @Mock
    HighLowPlayingContext context;

    @Mock
    HighLowJudge judge;


    @Mock
    HighLowPlayingContextFactory contextFactory;


    HighLowPlayService sut;

    @BeforeEach
    void setUp() {
        sut = new HighLowPlayService(contextFactory, repository, judge);
    }

    HighLowPlayStart command = new HighLowPlayStart("Foo");
    Target target = Target.createBy(() -> 10L);

    @Test
    void start() {
        given(contextFactory.create(command, target)).willReturn(context);

        sut.start(command, target);

        verify(context).start();
        verify(repository).save(context);
    }
}
