package otus.ru.object.size.measure.data.generator;

public class IntegerGenerator  implements DataGenerator {
    private static final String DESCRIPTION = "Integer";

    @Override
    public String getDescription(){
        return DESCRIPTION;
    };

    @Override
    public void generate(int dataLength){

    };

    @Override
    public Object getData(){
        return new Integer(10000);
    };

    @Override
    public boolean isCollection(){
        return false;
    }
}

