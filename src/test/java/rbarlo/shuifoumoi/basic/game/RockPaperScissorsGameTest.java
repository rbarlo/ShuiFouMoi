package rbarlo.shuifoumoi.basic.game;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import rbarlo.shuifoumoi.basic.Rule;
import rbarlo.shuifoumoi.basic.choice.Paper;
import rbarlo.shuifoumoi.basic.choice.Rock;
import rbarlo.shuifoumoi.basic.choice.Scissors;
import rbarlo.shuifoumoi.basic.exception.ShuiFouMoiBasicException;

import java.util.Optional;

/**
 * Created by Romain on 14/11/2016.
 */
public class RockPaperScissorsGameTest {

    @Test
    public void RockPaperScissorsGame_should_have_the_correct_rules() throws ShuiFouMoiBasicException {

        RockPaperScissorsGame rockPaperScissorsGame = new RockPaperScissorsGame();

        Optional<Rule> rule = rockPaperScissorsGame.getMatchingRule(Rock.getInstance(),Scissors.getInstance());
        MatcherAssert.assertThat("Rule is  not empty", rule.isPresent());
        MatcherAssert.assertThat("Scissors are the loosingChoice" ,
                                    rule.get().getLoosingChoice().equals(Scissors.getInstance()) );
        MatcherAssert.assertThat("Rock must be the winning choice",
                                    rule.get().getWinningChoice().equals(Rock    .getInstance()) );

        rule = rockPaperScissorsGame.getMatchingRule(Scissors.getInstance(), Paper.getInstance());
        MatcherAssert.assertThat("Rule is  not empty", rule.isPresent());
        MatcherAssert.assertThat("Paper are the loosingChoice"        ,
                                    rule.get().getLoosingChoice().equals(Paper    .getInstance()) );
        MatcherAssert.assertThat("Scissors must be the winning choice",
                                    rule.get().getWinningChoice().equals(Scissors .getInstance()) );


        rule = rockPaperScissorsGame.getMatchingRule(Paper.getInstance(), Rock.getInstance());
        MatcherAssert.assertThat("Rule is  not empty", rule.isPresent());
        MatcherAssert.assertThat("Rock are the loosingChoice"        ,
                                    rule.get().getLoosingChoice().equals(Rock .getInstance()) );
        MatcherAssert.assertThat("Paper must be the winning choice"  ,
                                    rule.get().getWinningChoice().equals(Paper.getInstance()) );

    }

    @Test
    public void RockPaperScissorsGame_should_have_the_correct_number_of_rules() throws ShuiFouMoiBasicException {

        RockPaperScissorsGame rockPaperScissorsGame = new RockPaperScissorsGame();

        MatcherAssert.assertThat("Rock Paper Scissors has 3 rules", rockPaperScissorsGame.getNumberOfRules() == 3);


    }
}
