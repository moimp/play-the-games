package org.slipp.masil.games.web;

import org.slipp.masil.games.application.HighLowApplicationService;
import org.slipp.masil.games.domains.highrow.GuessHighLowNumber;
import org.slipp.masil.games.domains.highrow.HighLowJudgement;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayController {

    private final HighLowApplicationService highLowApplicationService;

    public PlayController(HighLowApplicationService highLowApplicationService) {
        this.highLowApplicationService = highLowApplicationService;
    }

    @GetMapping(value = "/games/{gameId}")
    public ModelAndView beforeGameStart(@PathVariable String gameId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("highlow/beforePlaying");
        mv.addObject("gameId", gameId);
        return mv;
    }

    @PostMapping(value = "/games/{gameId}")
    public ModelAndView getUserName(
            @PathVariable String gameId,
            @RequestParam(value = "userName") String userName
    ) {
        Long contextId = highLowApplicationService.start(userName);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("highlow/playing");
        mv.addObject("contextId", contextId);
        mv.addObject("userName", userName);
        mv.addObject("gameId", gameId);

        return mv;
    }

    @PostMapping(value = "/games/{gameId}/turn")
    public ModelAndView playingTurn(
            @PathVariable String gameId,
            @RequestParam("guessNumber") Long guessNumber,
            @RequestParam("contextId") Long contextId,
            @RequestParam("userName") String userName
    ) {

        HighLowJudgement play = highLowApplicationService.play(GuessHighLowNumber.of(contextId, guessNumber));

        ModelAndView mv = new ModelAndView();
        mv.setViewName("highlow/playing");
        mv.addObject("result", play.name());
        mv.addObject("userName", userName);
        mv.addObject("contextId", contextId);
        mv.addObject("gameId", gameId);
        return mv;
    }
}
