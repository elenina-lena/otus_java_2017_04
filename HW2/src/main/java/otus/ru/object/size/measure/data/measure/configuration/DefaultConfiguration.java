package otus.ru.object.size.measure.data.measure.configuration;

public final class DefaultConfiguration implements MeasureConfiguration {
    private static final int MAX_VALUE_ELEMENTS = 1_000;
    private static final int STEP = 5;

    @Override
    public int getMaxSizeItems() {
        return MAX_VALUE_ELEMENTS;
    }

    @Override
    public int getStep() {
        return STEP;
    }
}
