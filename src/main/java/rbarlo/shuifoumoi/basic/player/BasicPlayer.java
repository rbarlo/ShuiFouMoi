package rbarlo.shuifoumoi.basic.player;

import rbarlo.shuifoumoi.basic.choice.BasicChoice;
import rbarlo.shuifoumoi.basic.exception.NoAvailableChoiceForPlayer;


import java.util.List;

/**
 * Created by rbarlo
 */
public abstract class BasicPlayer {

    /**
     *
     * @param choices, a list of available choices the player can play
     * @return the choice the player choose
     * @throws NoAvailableChoiceForPlayer
     */
    public abstract BasicChoice play(List<BasicChoice> choices) throws NoAvailableChoiceForPlayer;

    private int    score ;

    private String name;

    public BasicPlayer(String name){
        this(name,0);
    }


    public BasicPlayer(String name, int score){
        this.name = name;
        this.score = score;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }






}
