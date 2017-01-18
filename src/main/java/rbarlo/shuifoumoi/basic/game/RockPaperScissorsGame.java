package rbarlo.shuifoumoi.basic.game;

import rbarlo.shuifoumoi.basic.Rule;
import rbarlo.shuifoumoi.basic.choice.BasicChoice;
import rbarlo.shuifoumoi.basic.choice.Paper;
import rbarlo.shuifoumoi.basic.choice.Rock;
import rbarlo.shuifoumoi.basic.choice.Scissors;
import rbarlo.shuifoumoi.basic.exception.InconsistentRuleToAddInGameException;
import sun.security.krb5.internal.PAData;

/**
 * Created by rbarlo
 */
public class RockPaperScissorsGame extends BasicGame {

    protected final BasicChoice rockChoice     = Rock    .getInstance();
    protected final BasicChoice paperChoice    = Paper   .getInstance();
    protected final BasicChoice scissorsChoice = Scissors.getInstance();

    public RockPaperScissorsGame () throws InconsistentRuleToAddInGameException {


        Rule firstRule  = new Rule(rockChoice     ,"Rock beats Scissors", scissorsChoice);
        Rule secondRule = new Rule(scissorsChoice ,"Scissors cuts Paper", paperChoice   );
        Rule thirdRule  = new Rule(paperChoice    ,"Paper covers Rock"  , rockChoice    );

        addRule(firstRule );
        addRule(secondRule);
        addRule(thirdRule );
    }
}
