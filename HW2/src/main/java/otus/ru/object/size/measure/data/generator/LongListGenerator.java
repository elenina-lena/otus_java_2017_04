package otus.ru.object.size.measure.data.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LongListGenerator extends AbstractCollectionGenerator {
    private static final String DESCRIPTION = "Long list";

    private List<Long> data = new ArrayList<>();

    @Override
    void createObject() {
        if (data == null){
            data = new ArrayList<>();
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
            data.add(new Random().nextLong());
        }
    }

    @Override
    public Object getData(){
        return data;
    }
}

