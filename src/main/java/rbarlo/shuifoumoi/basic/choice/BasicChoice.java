package rbarlo.shuifoumoi.basic.choice;

/**
 * Created by rbarlo on 16/10/2016.
 *
 * BasicChoice Class, is an abstract class  that represents a Choice of
 *
 */
public abstract class BasicChoice {


    private String name;

    protected BasicChoice(String name) {
        this.name = name;
    }

    public String getName() {return name;}

    @Override
    public  final boolean equals(Object obj){

        return (obj != null  && getClass() == obj.getClass() );
    }

    @Override
    public final String toString() {
        return name;
    }



}
