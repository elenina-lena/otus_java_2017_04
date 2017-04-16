package otus.ru.object.size.measure.data.generator;

public abstract class AbstractSingleDataGenerator implements DataGenerator {
    @Override
    public boolean isCollection() {
        return false;
    }
}
