package otus.ru.object.size.measure.data.generator;

public interface DataGenerator {
    String getDescription();

    void generate(int dataLength);

    Object getData();

    boolean isCollection();
}
