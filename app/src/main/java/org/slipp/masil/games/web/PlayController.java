package org.slipp.masil.games.web;

import org.slipp.masil.games.application.HighLowApplicationService;
import org.slipp.masil.games.application.RankingApplicationService;
import org.slipp.masil.games.domains.highrow.GuessHighLowNumber;
import org.slipp.masil.games.domains.highrow.HighLowJudgement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayController {

    @Autowired
    HighLowApplicationService highLowApplicationService;

    @PostMapping(value = "/games/{gameId}/turn")
    public ModelAndView playingTurn(
            @PathVariable String gameId,
            @RequestParam("guessNumber") Long guessNumber,
            @RequestParam("contextId") Long contextId,
            @RequestParam("userName") String userName
    ) {

        HighLowJudgement play = highLowApplicationService.play(GuessHighLowNumber.of(contextId, guessNumber));

        ModelAndView mv = new ModelAndView();
        if (play == HighLowJudgement.MATCH){
            mv.setViewName("redirect:/rankingView");
            mv.addObject("result", play.name());
            mv.addObject("userName", userName);
            mv.addObject("contextId", contextId);
            return mv;
        }
        mv.setViewName("playingHighLowGame");
        mv.addObject("result", play.name());
        mv.addObject("userName", userName);
        mv.addObject("contextId", contextId);
        return mv;
    }
}
