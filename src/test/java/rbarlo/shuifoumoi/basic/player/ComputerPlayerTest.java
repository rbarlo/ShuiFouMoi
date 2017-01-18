package rbarlo.shuifoumoi.basic.player;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import rbarlo.shuifoumoi.basic.choice.BasicChoice;
import rbarlo.shuifoumoi.basic.choice.Paper;
import rbarlo.shuifoumoi.basic.choice.Rock;
import rbarlo.shuifoumoi.basic.choice.Scissors;
import rbarlo.shuifoumoi.basic.exception.NoAvailableChoiceForPlayer;
import rbarlo.shuifoumoi.basic.exception.ShuiFouMoiBasicException;

import java.util.ArrayList;

import static org.junit.Assert.fail;

/**
 * Created by Romain on 13/11/2016.
 */
public class ComputerPlayerTest {

    @Test
    public void play_should_throws_NoAvailableChoiceForPlayer()  {

        ComputerPlayer cmpPlayer = new ComputerPlayer("Player");

        try {
            cmpPlayer.play(null);
            fail("Exception should be thrown if the list is null");
        }
        catch(NoAvailableChoiceForPlayer e){}
        catch(Exception e){
            fail("NoAvailableChoiceForPlayer should not be thrown");
        }


        try {
            cmpPlayer.play(new ArrayList<BasicChoice>());
            fail("Exception should be thrown if the list is empty");
        }
        catch(NoAvailableChoiceForPlayer e){}
        catch(Exception e){
            fail("NoAvailableChoiceForPlayer should not be thrown");
        }
    }

    @Test
    public void play_should_return_random_choice(){

        ComputerPlayer cmpPlayer = new ComputerPlayer("Player");
        ArrayList<BasicChoice> list = new ArrayList<>();

        list.add(Paper.getInstance());

        try {
            MatcherAssert.assertThat("Paper must be chosen by the player", cmpPlayer.play(list) instanceof Paper);
        } catch (NoAvailableChoiceForPlayer noAvailableChoiceForPlayer) {
            fail("NoAvailableChoiceForPlayer should not be thrown if the list is empty");
        }

        list.add(Rock.getInstance());

        try {
            BasicChoice choice =  cmpPlayer.play(list);
            MatcherAssert.assertThat("Paper or Rock must be chosen by the player", choice instanceof  Paper ||
                                                                                   choice instanceof  Rock  );
        } catch (NoAvailableChoiceForPlayer noAvailableChoiceForPlayer) {
            fail("NoAvailableChoiceForPlayer should not be thrown if the list is empty");
        }

    }

    @Test
    public void play_should_return_different_choice() throws ShuiFouMoiBasicException{

        ComputerPlayer cmpPlayer = new ComputerPlayer("Player");
        ArrayList<BasicChoice> list = new ArrayList<>();

        list.add(Paper.getInstance());
        list.add(Rock.getInstance());
        list.add(Scissors.getInstance());

        boolean paper    = false;
        boolean scissors = false;
        boolean rock     = false;

        for(int i = 0 ; i < 100;++i){
            if (paper && scissors && rock) break;

            BasicChoice choice =  cmpPlayer.play(list);

            paper    = (choice.equals(Paper.getInstance())? true:paper);
            scissors = (choice.equals(Scissors.getInstance())? true:scissors);
            rock     = (choice.equals(Rock.getInstance())? true:rock);

        }

        MatcherAssert.assertThat("all the choices have been played ", paper && scissors && rock);

    }

}
