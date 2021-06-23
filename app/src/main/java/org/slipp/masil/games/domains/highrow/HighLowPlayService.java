package org.slipp.masil.games.domains.highrow;


public class HighLowPlayService {

    private final HighLowPlayingContextFactory contextFactory;
    private final HighLowPlayingContextRepository contextRepository;

    public HighLowPlayService(HighLowPlayingContextRepository contextRepository) {
        this(HighLowPlayingContextFactory.DEFAULT, contextRepository);
    }

    public HighLowPlayService(HighLowPlayingContextFactory contextFactory, HighLowPlayingContextRepository contextRepository) {
        this.contextFactory = contextFactory;
        this.contextRepository = contextRepository;
    }

    public Long start(StartHighLowPlay command) {
        HighLowPlayingContext context = contextFactory.create(command);
        context.start();
        HighLowPlayingContext save = contextRepository.save(context);
        return save.getId();
    }

    public void stop(StopHighLowPlay command) {
        HighLowPlayingContext context = contextRepository.findById(command.getContextId());
        context.stop();
        contextRepository.save(context);
    }

    public HighLowPlayingResult play(GuessHighLowNumber command) {
        HighLowPlayingContext context = contextRepository.findById(command.getContextId());
        context.retry();
        contextRepository.save(context);
        HighLowJudgement judgement = new HighLowJudge(Target.of(context.getTarget())).judge(command.getGuessNumber());
        if (judgement == HighLowJudgement.MATCH) {
            HighLowPlayingContext save = contextRepository.findById(command.getContextId());
            save.match();
            contextRepository.save(save);
        }
        return new HighLowPlayingResult(command.getContextId(), judgement);
    }
}
