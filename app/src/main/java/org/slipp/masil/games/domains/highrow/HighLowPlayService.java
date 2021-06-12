package org.slipp.masil.games.domains.highrow;


import org.slipp.masil.games.domains.PlayState;
import org.slipp.masil.games.domains.highrow.judge.HighLowJudge;
import org.slipp.masil.games.domains.target.Target;

public class HighLowPlayService {

    private final HighLowJudge judge;
    private final HighLowPlayingContextFactory contextFactory;
    private final HighLowPlayingContextRepository contextRepository;

    public HighLowPlayService(HighLowPlayingContextRepository contextRepository, HighLowJudge judge) {
        this(HighLowPlayingContextFactory.DEFAULT, contextRepository,judge);
    }

    public HighLowPlayService(HighLowPlayingContextFactory contextFactory, HighLowPlayingContextRepository contextRepository, HighLowJudge judge) {
        this.judge = judge;
        this.contextFactory = contextFactory;
        this.contextRepository = contextRepository;
    }

    public Long start(HighLowPlayStart highLowStart, Target target) {

        HighLowPlayingContext context = contextFactory.create(highLowStart, target);
        context.start();
        contextRepository.save(context);
        return context.getId();
    }

    public void stop(HighLowPlayStop highLowPlayStop) {
        HighLowPlayingContext context = contextRepository.findById(highLowPlayStop.getContextId());
        context.stop();
        contextRepository.save(context);
    }

    public HighLowPlayingResult play(HighLowNumberGuess guess) {
        HighLowPlayingContext context = contextRepository.findById(guess.getContextId());
        HighLowJudgement judgement = this.judge.judge(guess.getGuessNumber(), context.getTarget());
        if (judgement == HighLowJudgement.MATCH) {
            context.match();
            contextRepository.save(context);
        }
        return new HighLowPlayingResult(guess.getContextId(), judgement);
    }
}
