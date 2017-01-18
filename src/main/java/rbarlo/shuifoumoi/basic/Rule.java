package rbarlo.shuifoumoi.basic;

import rbarlo.shuifoumoi.basic.choice.BasicChoice;

/**
 * Created by rbarlo
  */
public class Rule {

    private BasicChoice winningChoice;

    private BasicChoice loosingChoice;

    private String description;



    public Rule(BasicChoice winningChoice, String description, BasicChoice loosingChoice){

        if(winningChoice == null || loosingChoice== null ){
            throw new IllegalArgumentException("the choice cant be null");
        }
        if(winningChoice.equals(loosingChoice)){
            throw new IllegalArgumentException("the choice cant be equals");
        }

        this.winningChoice = winningChoice;
        this.loosingChoice = loosingChoice;
        this.description   = description  ;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rule rule = (Rule) o;

        return winningChoice.equals(rule.getWinningChoice()) && loosingChoice.equals(rule.getLoosingChoice());
    }

    public BasicChoice getWinningChoice() {
        return winningChoice;
    }

    public String getDescription() {
        return description;
    }

    public BasicChoice getLoosingChoice() {
        return loosingChoice;
    }


}
