package otus.ru.object.size.measure.data.generator;

import java.util.ArrayList;
import java.util.List;

public class IntegerListGenerator implements DataGenerator {
    private static final String DESCRIPTION = "Integer list";

    private List<Integer> data = new ArrayList<>();

    @Override
    public String getDescription(){
        return DESCRIPTION;
    };

    @Override
    public void generate(int dataLength){
        for (int i = 0; i < dataLength; i++){
            data.add(i);
        }
    };

    @Override
    public Object getData(){
        return data;
    };

    @Override
    public boolean isCollection(){
        return true;
    }

}
