package rbarlo.shuifoumoi.basic.choice;

/**
 * Created by rbarlo on 16/10/2016.
 *
 *  Paper is a choice players can use in the basic version of the game
 */
public final class Paper extends BasicChoice{

    private static final String PAPER_NAME = "Paper";

    private static final Paper instance = new Paper();

    private Paper() {super(PAPER_NAME);}

    public static Paper getInstance(){
        return instance;
    }

}
