package rbarlo.shuifoumoi.basic.player;

import rbarlo.shuifoumoi.basic.choice.BasicChoice;
import rbarlo.shuifoumoi.basic.exception.NoAvailableChoiceForPlayer;

import java.util.List;
import java.util.Random;


/**
 * Created by rbarlo
 * an implementation of the BasicPlayer Class which
 * use random choice
 */
public class ComputerPlayer extends BasicPlayer {

    private static Random rand = new Random();


    public ComputerPlayer (String name){
        super(name);
    }

    /**
     *
     * @param choices, a list of available choices the player can play
     * @return a random choice
     * @throws NoAvailableChoiceForPlayer
     */
    @Override
    public BasicChoice play(List<BasicChoice> choices) throws NoAvailableChoiceForPlayer {

        if (choices == null || choices.size() == 0 ) throw new NoAvailableChoiceForPlayer();

        return choices.get(rand.nextInt(choices.size()));

    }
}
