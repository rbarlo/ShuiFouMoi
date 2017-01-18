package rbarlo.shuifoumoi.basic.choice;


import org.hamcrest.MatcherAssert;
import org.junit.Test;

/**
 * Created by rbarlo
 *
 * Tests of The BasicChoice Class
 */
public class BasicChoiceTest {

    public static  String CHOICE_A_NAME = "A";
    public static  String CHOICE_B_NAME = "B";

     class ChoiceA extends BasicChoice {
        protected ChoiceA() {
            super(CHOICE_A_NAME);
        }
    }

    class ChoiceB extends BasicChoice {
        protected ChoiceB() { super(CHOICE_B_NAME); }
    }

    /**
     * Tests that no matter what, choices of the same class are still equals
     */
    @Test
    public void instances_should_be_equals(){

        ChoiceA firstAChoice  = new ChoiceA();
        ChoiceA secondAChoice = new ChoiceA();

        MatcherAssert.assertThat("the 2 references are not the same instance", firstAChoice != secondAChoice);
        MatcherAssert.assertThat("the two choices are equals", firstAChoice.equals(secondAChoice));

        ChoiceB bChoice = new ChoiceB();

        MatcherAssert.assertThat("2 subclass of basic choice are not equals", !firstAChoice.equals(bChoice));

    }



}