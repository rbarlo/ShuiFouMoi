package rbarlo.shuifoumoi.basic.exception;

/**
 * Created by rbarlo
 *
 *
 */
public class InconsistentRuleToAddInGameException extends ShuiFouMoiBasicException{

    protected static final String EXCEPTION_MESSAGE_STR
             = "Rule to add is irrelevant and cannot be add due to a previous Rule in the game";

    public InconsistentRuleToAddInGameException(){
        super(EXCEPTION_MESSAGE_STR);
    }
}
