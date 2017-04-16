package otus.ru.object.size.measure.data.generator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class IntegerSetGenerator extends AbstractCollectionGenerator {
    private static final String DESCRIPTION = "Integer set";

    private Set<Integer> data = new HashSet<>();

    @Override
    public void createObject(){
        if (data == null) {
            data = new HashSet<>();
        }
    }

    @Override
    public String getDescription(){
        return DESCRIPTION;
    }

    @Override
    public void clearData() {
        data = null;
    }

    @Override
    public void generate(int dataLength){
        createObject();

        for (int i = 0; i < dataLength; i++){
            data.add(new Random().nextInt());
        }
    }

    @Override
    public Object getData(){
        return data;
    }
}

