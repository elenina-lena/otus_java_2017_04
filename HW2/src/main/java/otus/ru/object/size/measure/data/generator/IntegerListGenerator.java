package otus.ru.object.size.measure.data.generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class IntegerListGenerator extends AbstractCollectionGenerator {
    private static final String DESCRIPTION = "Integer list";

    private List<Integer> data = new ArrayList<>();

    @Override
    public void createObject(){
        if (data == null) {
            data = new ArrayList<>();
        }
    }

    @Override
    public void clearData() {
        data = null;
    }

    @Override
    public String getDescription(){
        return DESCRIPTION;
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
