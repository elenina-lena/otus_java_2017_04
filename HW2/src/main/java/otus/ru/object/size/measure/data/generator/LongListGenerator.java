package otus.ru.object.size.measure.data.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LongListGenerator  implements DataGenerator {
    private static final String DESCRIPTION = "Long list";

    private List<Long> data = new ArrayList<>();

    @Override
    public String getDescription(){
        return DESCRIPTION;
    };

    @Override
    public void generate(int dataLength){
        for (int i = 0; i < dataLength; i++){
            data.add(new Random().nextLong());
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

