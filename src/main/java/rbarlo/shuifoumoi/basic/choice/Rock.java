package rbarlo.shuifoumoi.basic.choice;

/**
 * Created by rbarlo on 16/10/2016.
 *
 * Rock  is a choice players can use in the basic version of the game
 */
public final class Rock extends BasicChoice {

    private static final String ROCK_NAME = "Rock";

    private static final Rock instance = new Rock();

    private Rock(){
        super(ROCK_NAME);
    }

    public static Rock getInstance(){
            return instance;
    }


}
