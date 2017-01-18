package rbarlo.shuifoumoi.basic.exception;

/**
 * Created by Romain on 13/11/2016.
 */
public class NoAvailableChoiceForPlayer extends ShuiFouMoiBasicException {

    protected static final String EXCEPTION_MESSAGE_STR
            = "No Available Choice for the player";


    public NoAvailableChoiceForPlayer(){
        super(EXCEPTION_MESSAGE_STR);
    }
}
