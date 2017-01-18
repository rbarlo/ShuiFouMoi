import rbarlo.shuifoumoi.basic.Rule;
import rbarlo.shuifoumoi.basic.choice.Paper;
import rbarlo.shuifoumoi.basic.choice.Rock;
import rbarlo.shuifoumoi.basic.choice.Scissors;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by rbarlo
 *
 * test class for Rule
 */
public class RuleTest {

    private Paper    paper       = Paper   .getInstance();
    private Rock     rock        = Rock    .getInstance();
    private Scissors scissor     = Scissors.getInstance();



    @Test
    public void should_be_equals(){

        Rule newRuleA = new Rule(paper,"Description A",rock);
        Rule newRuleB = new Rule(paper,"Description B",rock);

        MatcherAssert.assertThat("the 2 intances are equals",newRuleA.equals(newRuleB));

        Rule newRuleC = new Rule(paper,"Description C",scissor);

        MatcherAssert.assertThat("the 2 intances are not equals",!newRuleA.equals(newRuleC));

    }

    @Test
    public void constructor_should_throw_Exception(){
        try {
            new Rule(rock, "Description", rock);
            fail("Exception should be thrown if the same choice is used");
        }
        catch(IllegalArgumentException e){}

        try {
            new Rule(rock, "Description ", null);
            fail("Exception should be thrown if loosing choice is null");
        }
        catch(IllegalArgumentException e){}

        try {
            new Rule(null, "Description ", rock);
            fail("Exception should be thrown if winning choice is null");
        }
        catch(IllegalArgumentException e){}

        try {
            new Rule(null, "Description ", null);
            fail("Exception should be thrown if both choices are null");
        }
        catch(IllegalArgumentException e){}

        try {new Rule(rock, null, scissor);}
        catch(Exception e){
            fail("Exception should not be thrown if description is null");
        }


    }

}