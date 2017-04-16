package otus.ru.object.size.measure.data.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StringListGenerator extends AbstractCollectionGenerator {
    private static final String DESCRIPTION = "String list";

    private List<String> data = new ArrayList<>();

    @Override
    public void createObject() {
        if (data == null) {
            data = new ArrayList<>();
        }
    }

    @Override
    public void clearData() {
        data = null;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public void generate(int dataLength) {
        createObject();

        for (int i = 0; i < dataLength; i++) {
            data.add(UUID.randomUUID().toString());
        }
    }

    @Override
    public Object getData() {
        return data;
    }
}

