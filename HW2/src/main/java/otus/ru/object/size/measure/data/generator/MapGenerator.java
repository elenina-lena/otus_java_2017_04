package otus.ru.object.size.measure.data.generator;

import java.util.*;

public class MapGenerator extends AbstractCollectionGenerator {
    private static final String DESCRIPTION = "HahsMap";

    private Map<Long, Long> data = new HashMap<>();

    @Override
    void createObject() {
        if (data == null){
            data = new HashMap<>();
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
            Long key = new Random().nextLong();
            Long value = new Random().nextLong();

            data.put(key, value);
        }
    }

    @Override
    public Object getData(){
        return data;
    }
}
