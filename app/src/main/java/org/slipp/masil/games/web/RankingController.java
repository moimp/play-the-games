package org.slipp.masil.games.web;

import org.slipp.masil.games.domains.ranking.Ranking;
import org.slipp.masil.games.domains.ranking.RankingId;
import org.slipp.masil.games.domains.ranking.RankingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RankingController {

    private final RankingRepository repository;

    public RankingController(RankingRepository repository) {
        this.repository = repository;
    }


    @GetMapping(value = "ranking/{gameId}")
    public ModelAndView redirectRanking(
            @PathVariable String gameId
    ) {

        // TODO 랭킹 순위 확인 필요
        Ranking ranking = repository.findById(RankingId.of(Long.parseLong(gameId)));
        ModelAndView mv = new ModelAndView();
        mv.setViewName("rankingView");
        mv.addObject("ranking", ranking.getItems());
        mv.addObject("gameId", gameId);
        return mv;
    }
}
