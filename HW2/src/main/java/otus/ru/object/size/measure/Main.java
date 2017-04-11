package otus.ru.object.size.measure;

import otus.ru.object.size.measure.data.generator.*;
import otus.ru.object.size.measure.data.measure.MeasuringResult;
import otus.ru.object.size.measure.data.measure.ObjectMemorySizeMeasuring;
import otus.ru.object.size.measure.data.measure.ObjectSizeMeasuring;

import java.util.List;

public  class Main {
    static final int MAX_SIZE = 1_000_000;
    static final ObjectSizeMeasuring objectSizeMeasuring = new ObjectMemorySizeMeasuring();

    public static void main(String[] args) {
        objectSizeMeasuring.measure(new EmptyStringGenerator());
        objectSizeMeasuring.measure(new IntegerGenerator());

        objectSizeMeasuring.measure(MAX_SIZE,
                new IntegerListGenerator(),
                new IntegerSetGenerator(),
                new LongListGenerator()
        );

        printObjectSizeInfo(objectSizeMeasuring.getMeasuredData());
    }

    private static void printObjectSizeInfo(List<MeasuringResult> measuredData){
        for(MeasuringResult measuringResult : measuredData){
            String description = measuringResult.getDataGenerator().getDescription();
            long bytes = measuringResult.getBytes();
            int itemsCount = measuringResult.getLength();

            if (measuringResult.getDataGenerator().isCollection()){
                System.out.println(String.format("%s of %d items is %d bytes", description, itemsCount, bytes));
            } else {
                System.out.println(String.format("%s is %d bytes", description, bytes));
            }
        }
     }
}
