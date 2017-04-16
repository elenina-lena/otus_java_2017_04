package otus.ru.object.size.measure.data.generator;

import java.util.Collection;

public abstract class AbstractCollectionGenerator implements DataGenerator {
    @Override
    public boolean isCollection()
    {
        return true;
    }

    abstract void createObject();
}
