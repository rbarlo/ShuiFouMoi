package rbarlo.shuifoumoi.basic.game;


import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Ignore;
import org.junit.matchers.JUnitMatchers;
import rbarlo.shuifoumoi.basic.Rule;
import rbarlo.shuifoumoi.basic.choice.Paper;
import rbarlo.shuifoumoi.basic.choice.Rock;
import rbarlo.shuifoumoi.basic.choice.Scissors;
import rbarlo.shuifoumoi.basic.exception.InconsistentRuleToAddInGameException;
import rbarlo.shuifoumoi.basic.exception.UndefinedChoiceInGameException;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by rbarlo
 *
 *  test Class for BasicGame
 */
public class BasicGameTest {


    @Test
    public void addRule_should_throws_IllegalArgumentException() throws InconsistentRuleToAddInGameException  {

        BasicGame myBasicGame = new BasicGame(){};

        Rule firstRule = new Rule(Rock.getInstance(),"Rock beats scissor", Scissors.getInstance());
        myBasicGame.addRule(firstRule);

        try {
            myBasicGame.addRule(null);
            fail("Exception should be thrown if the the rule to ass is null");
        }
        catch(IllegalArgumentException e){}

        Rule inconsistentRule = new Rule(Scissors.getInstance(),"Rock beat scissor", Rock.getInstance());
        try {
            myBasicGame.addRule(inconsistentRule);
            fail("Exception should be thrown if two rules inconsistent");
        }
        catch( InconsistentRuleToAddInGameException e){}


    }

    @Test
    public void getMatchingRule_should_return_BasicChoice() throws InconsistentRuleToAddInGameException, UndefinedChoiceInGameException {

        BasicGame myBasicGame = new BasicGame() {};

        Rule firstRule = new Rule(Rock.getInstance(), "Rock beat scissor", Scissors.getInstance());

        myBasicGame.addRule(firstRule);

        Optional<Rule> rule = myBasicGame.getMatchingRule(Rock.getInstance(), Scissors.getInstance());

        MatcherAssert.assertThat("Rule is  not empty", rule.isPresent());
        MatcherAssert.assertThat("Rule is  equals to the added Rule", firstRule.equals(rule.get()));

        rule = myBasicGame.getMatchingRule(Scissors.getInstance(), Rock.getInstance());

        MatcherAssert.assertThat("Rule is  not empty", rule.isPresent());
        MatcherAssert.assertThat("Rule is  equals to the added Rule", firstRule.equals(rule.get()));

    }

    @Test
    public void getMatchingRule_should_throws_IllegalArgumentException()  {

        BasicGame myBasicGame = new BasicGame(){};

        try {
            myBasicGame.getMatchingRule(null,Scissors.getInstance());
            fail("Exception should be thrown if the first choice is null");
        }
        catch(IllegalArgumentException e){}
        catch(UndefinedChoiceInGameException e){
            fail("UndefinedChoiceInGameException should not be thrown");
        }

        Rule inconsistentRule = new Rule(Scissors.getInstance(),"Rock beat scissor", Rock.getInstance());
        try {
            myBasicGame.getMatchingRule(Scissors.getInstance(),null);
            fail("Exception should be thrown if the first choice is null");
        }
        catch(IllegalArgumentException e){}
        catch(UndefinedChoiceInGameException e){
            fail("UndefinedChoiceInGameException should not be thrown");
        }

    }

    @Test
    public void getChoices_should_have_the_good_number_of_choice() throws InconsistentRuleToAddInGameException {
        BasicGame myBasicGame = new BasicGame(){};

        Rule firstRule = new Rule(Rock.getInstance(),"Rock beats scissor", Scissors.getInstance());
        myBasicGame.addRule(firstRule);

        MatcherAssert.assertThat("There are two choices", myBasicGame.getChoices().size() == 2);

        Rule secondRule = new Rule(Paper.getInstance(),"paper covers rock", Rock.getInstance());
        myBasicGame.addRule(secondRule);

        MatcherAssert.assertThat("There are three choices", myBasicGame.getChoices().size() == 3);


        Rule thirdRule = new Rule(Scissors.getInstance(),"scissors cuts paper", Paper.getInstance());
        myBasicGame.addRule(thirdRule);


        MatcherAssert.assertThat("There are still three choices", myBasicGame.getChoices().size() == 3);

    }
}