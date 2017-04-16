package otus.ru.object.size.measure;

import otus.ru.object.size.measure.data.generator.*;
import otus.ru.object.size.measure.data.measure.MeasuringResult;
import otus.ru.object.size.measure.data.measure.algorithms.FreeSizeMemoryCounter;
import otus.ru.object.size.measure.data.measure.algorithms.ObjectSizeCalculatorMeasuring;
import otus.ru.object.size.measure.data.measure.ObjectSizeMeasuring;
import otus.ru.object.size.measure.data.measure.configuration.DefaultConfiguration;
import otus.ru.object.size.measure.data.measure.configuration.MeasureConfiguration;

import java.util.Arrays;
import java.util.List;

public  class Main {
    private static final MeasureConfiguration DEFAULT_CONFIGURATION = new DefaultConfiguration();
    private static final long SLEEP_TIME_MS = 10_000;

    private static final List<ObjectSizeMeasuring> measurementAlgorithms = Arrays.asList(
            new ObjectSizeCalculatorMeasuring(DEFAULT_CONFIGURATION),
            new FreeSizeMemoryCounter(DEFAULT_CONFIGURATION)
    );

    public static void main(String[] args) throws InterruptedException {
        for (ObjectSizeMeasuring measurementAlgorithm : measurementAlgorithms) {
            measurementAlgorithm.measure(
                    new EmptyStringGenerator(),
                    new IntegerGenerator(),
                    new ObjectGenerator(),

                    new IntegerListGenerator(),
                    new IntegerSetGenerator(),
                    new LongListGenerator(),
                    new MapGenerator(),
                    new ObjectListGenerator(),
                    new StringListGenerator()
            );

            printObjectSizeInfo(measurementAlgorithm);

            clearGC();
        }
    }

    private static void printObjectSizeInfo(ObjectSizeMeasuring objectSizeMeasuring){
        System.out.println();
        System.out.println(objectSizeMeasuring.getDescription());
        System.out.println();

        List<MeasuringResult> measuredData = objectSizeMeasuring.getMeasuredData();

        for(MeasuringResult measuringResult : measuredData){
            String description = measuringResult.getDescription();
            long bytes = measuringResult.getBytes();
            int itemsCount = measuringResult.getLength();

            if (measuringResult.isCollection()){
                System.out.println(String.format("%s of %d items is %d bytes", description, itemsCount, bytes));
            } else {
                System.out.println(String.format("%s is %d bytes", description, bytes));
            }
        }
     }

    private static void clearGC(){
        System.gc();
        sleep();
    }

    private static void sleep(){
        try {
            System.out.println(String.format("Sleeping for %d ms. Please, wait...", SLEEP_TIME_MS));
            Thread.sleep(SLEEP_TIME_MS);
            System.out.println("Stop sleeping");
        }
        catch (InterruptedException e) {
            System.out.println("Sleep error " + e.getMessage());
        }
    }
}
