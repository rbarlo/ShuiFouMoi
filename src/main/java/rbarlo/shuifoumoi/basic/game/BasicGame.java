package rbarlo.shuifoumoi.basic.game;


import rbarlo.shuifoumoi.basic.Rule;
import rbarlo.shuifoumoi.basic.choice.BasicChoice;
import rbarlo.shuifoumoi.basic.exception.InconsistentRuleToAddInGameException;
import rbarlo.shuifoumoi.basic.exception.UndefinedChoiceInGameException;

import java.util.*;


/**
 * Created by rbarlo
 *
 */
public abstract class BasicGame {

    //game has a bench of rules
    private HashSet<Rule> rules = new HashSet<>();

    //game has also available choices for players
    private HashSet<BasicChoice> choices = new HashSet<>();

    /**
     * @param newRule, the rule to add in the game
     * @throws InconsistentRuleToAddInGameException if the rule is inconsistent compare to a previous added rule,.
     *
     */
    protected final void addRule(Rule newRule) throws InconsistentRuleToAddInGameException{
        if(newRule == null) throw new IllegalArgumentException("can't add a null Rule in a game");

        for(Rule rule : rules){
            if(rule.equals(newRule))throw new IllegalArgumentException("Two rules can't be the same in a BasicGame");

            if(rule.getLoosingChoice().equals(newRule.getWinningChoice()) &&
               rule.getWinningChoice().equals(newRule.getLoosingChoice()) ){
                throw new InconsistentRuleToAddInGameException();

            }
        }

        rules.add(newRule);

        choices.add(newRule.getLoosingChoice());
        choices.add(newRule.getWinningChoice());
    }

    /**
     *
     * @param yourChoice
     * @param otherPlayerChoice
     * @return Optional.empty if the choice are the same otherwise the rule that contains the two Choices in parameter.
     * @throws UndefinedChoiceInGameException if no matching rule is found.
     */
    public final Optional<Rule>  getMatchingRule(BasicChoice yourChoice, BasicChoice otherPlayerChoice)
            throws UndefinedChoiceInGameException {
      if(yourChoice ==null || otherPlayerChoice ==null)
        throw new IllegalArgumentException("Choice of player can't be null");

      if(yourChoice.equals(otherPlayerChoice)) return  Optional.empty();

       for(Rule rule : rules) {

          if ((rule.getWinningChoice().equals(yourChoice)        &&
               rule.getLoosingChoice().equals(otherPlayerChoice))
                ||
             ( rule.getWinningChoice().equals(otherPlayerChoice) &&
               rule.getLoosingChoice().equals(yourChoice)        )) {
              return Optional.of(rule);
          }

      }
      throw new UndefinedChoiceInGameException("No rule  defined for the choices: "+yourChoice.getName()
                  +" and "+ otherPlayerChoice.getName());
    }

    /**
     * @return the number of rules in the game
     */
    public final int getNumberOfRules(){return  rules.size();}

    /**
     * @return an unmodifiable set of available choices
     */
    public final Set<BasicChoice> getChoices(){return Collections.unmodifiableSet(choices);}


}
