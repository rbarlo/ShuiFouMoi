package rbarlo.shuifoumoi.basic;

import rbarlo.shuifoumoi.basic.game.BasicGame;
import rbarlo.shuifoumoi.basic.player.BasicPlayer;

/**
 * Created by rbarlo
 *
 */
public class Party {

    //a party has two players
    protected BasicPlayer firstPlayer;
    protected BasicPlayer secondPlayer;




    //a party has a game
    protected BasicGame game;

    public Party(BasicPlayer firstPlayer, BasicPlayer secondPlayer, BasicGame game ){

        this.firstPlayer  = firstPlayer ;
        this.secondPlayer = secondPlayer;
        this.game         = game;
    }
/*
    public BasicPlayer start(){


    }

*/
}