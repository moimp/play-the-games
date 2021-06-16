package org.slipp.masil.games.infrastructures.jdbc;

import org.slipp.masil.games.domains.Score;
import org.slipp.masil.games.domains.Target;
import org.slipp.masil.games.domains.game.GameId;
import org.slipp.masil.games.domains.ranking.RankingId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

public class Converters {

    @WritingConverter
    public enum RankingIdToLong implements Converter<RankingId, Long> {
        INSTANCE;

        @Override
        public Long convert(RankingId source) {
            return source.getGameId().getId();
        }
    }

    @ReadingConverter
    public enum LongToRankingId implements Converter<Long, RankingId> {
        INSTANCE;

        @Override
        public RankingId convert(Long source) {
            return RankingId.of(source);
        }
    }

    @WritingConverter
    public enum ScoreToInteger implements Converter<Score, Integer> {
        INSTANCE;

        @Override
        public Integer convert(Score source) {
            return source.getValue();
        }
    }

    @ReadingConverter
    public enum IntegerToScore implements Converter<Integer, Score> {
        INSTANCE;

        @Override
        public Score convert(Integer source) {
            return Score.of(source);
        }
    }

    @WritingConverter
    public enum GameIdToLong implements Converter<GameId, Long> {
        INSTANCE;

        @Override
        public Long convert(GameId source) {
            return source.getId();
        }
    }

    @ReadingConverter
    public enum LongToGameId implements Converter<Long, GameId> {
        INSTANCE;

        @Override
        public GameId convert(Long source) {
            return GameId.of(source);
        }
    }

    @WritingConverter
    public enum TargetToLong implements Converter<Target, Long> {
        INSTANCE;

        @Override
        public Long convert(Target source) {
            return source.getValue();
        }
    }

    @ReadingConverter
    public enum LongToTarget implements Converter<Long, Target> {
        INSTANCE;

        @Override
        public Target convert(Long source) {
            return Target.of(source);
        }
    }
}
