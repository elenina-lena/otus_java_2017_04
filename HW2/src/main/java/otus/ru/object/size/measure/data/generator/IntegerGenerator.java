package otus.ru.object.size.measure.data.generator;

import java.util.Random;

public class IntegerGenerator  extends AbstractSingleDataGenerator {
    private static final String DESCRIPTION = "Integer";
    private Integer data;

    @Override
    public String getDescription(){
        return DESCRIPTION;
    }

    @Override
    public void generate(int dataLength){
        data = new Random().nextInt();
    }

    @Override
    public Object getData(){
        return data;
    }

    @Override
    public void clearData() {
        data =  null;
    }
}

