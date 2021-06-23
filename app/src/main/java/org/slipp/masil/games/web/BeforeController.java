package org.slipp.masil.games.web;

import org.slipp.masil.games.application.HighLowApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BeforeController {

    @Autowired
    HighLowApplicationService highLowApplicationService;

    @PostMapping(value = "/games/{gameId}")
    public ModelAndView getUserName(
            @PathVariable String gameId,
            @RequestParam(value = "userName") String userName
    ) {
        Long contextId = highLowApplicationService.start(userName);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("playingHighLowGame");
        mv.addObject("contextId", contextId);
        mv.addObject("userName", userName);
        mv.addObject("gameId", gameId);

      return mv;
    }
}
