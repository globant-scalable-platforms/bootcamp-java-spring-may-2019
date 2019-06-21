package davidAcuna.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import davidAcuna.domain.Score;

@RestController
public class StageTwoController {
    
    @Autowired
    @Qualifier(value="scoreSingleton")
    private Score scoreTotal;
    
    @Autowired
    @Qualifier(value="scorePrototype")
    private Score scoreStage;
    
    @RequestMapping(value="/stage-two")
    public List<Score> getScopes() {
        final List<Score> result = new ArrayList<>();
        scoreTotal.setCount(scoreTotal.getCount()+1);
        scoreStage.setCount(scoreStage.getCount()+1);
        result.add(scoreTotal);
        result.add(scoreStage);
        
        return result;
    }    
}
