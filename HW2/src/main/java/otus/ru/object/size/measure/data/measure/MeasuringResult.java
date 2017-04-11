package otus.ru.object.size.measure.data.measure;

import otus.ru.object.size.measure.data.generator.DataGenerator;

public class MeasuringResult {
    private DataGenerator dataGenerator;
    private long bytes;
    private int length;

    MeasuringResult(DataGenerator dataGenerator, long bytes, int length){
        this.dataGenerator = dataGenerator;
        this.bytes = bytes;
        this.length = length;
    }

    public DataGenerator getDataGenerator() {
        return dataGenerator;
    }

    public long getBytes() {
        return bytes;
    }

    public int getLength() {
        return length;
    }
}
