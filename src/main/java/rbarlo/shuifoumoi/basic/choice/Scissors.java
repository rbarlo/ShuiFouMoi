package rbarlo.shuifoumoi.basic.choice;

/**
 * Created by rbarlo on 16/10/2016.
 *
 * Scissors  is a choice players can use in the basic version of the game
 */
public final class Scissors extends BasicChoice {

    private static final String PAPER_NAME = "Scissors";

    private static final Scissors instance = new Scissors();

    private Scissors() {super(PAPER_NAME);}

    public static Scissors getInstance(){
        return instance;
    }


}
