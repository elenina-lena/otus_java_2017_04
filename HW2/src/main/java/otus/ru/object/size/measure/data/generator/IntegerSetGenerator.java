package otus.ru.object.size.measure.data.generator;

import java.util.HashSet;
import java.util.Set;

public class IntegerSetGenerator implements DataGenerator {
    private static final String DESCRIPTION = "Integer set";

    private Set<Integer> data = new HashSet<>();

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

