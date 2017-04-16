package otus.ru.object.size.measure.data.measure.algorithms;

import otus.ru.object.size.measure.data.generator.DataGenerator;
import otus.ru.object.size.measure.data.measure.MeasuringResult;
import otus.ru.object.size.measure.data.measure.ObjectSizeMeasuring;
import otus.ru.object.size.measure.data.measure.configuration.MeasureConfiguration;

import java.util.ArrayList;
import java.util.List;

public class FreeSizeMemoryCounter  implements ObjectSizeMeasuring<MeasureConfiguration> {
    private static final String DESCRIPTION = "Free memory measuring algorithm";

    private static final long SLEEPING_TIME_BEFORE_DATA_CLEAN = 1500;
    private static final long SLEEPING_TIME_AFTER_DATA_CLEAN = 3000;
    private static final int MAX_TRY_GC_COUNTS = 3;

    private final Runtime runtime = Runtime.getRuntime();

    private MeasureConfiguration measureConfiguration;
    private List<MeasuringResult> measuredDate = new ArrayList<>();
    private int configMaxValue;
    private int configStep;
    private long size;

    public FreeSizeMemoryCounter(MeasureConfiguration configuration){
        this.measureConfiguration = configuration;

        configMaxValue = configuration.getMaxSizeItems();
        configStep = configuration.getStep();
    }

    @Override
    public MeasureConfiguration getMeasureConfiguration(){
        return measureConfiguration;
    }

    @Override
    public List<MeasuringResult> getMeasuredData(){
        return measuredDate;
    }

    @Override
    public void measure(DataGenerator... data){
        for(DataGenerator item : data){
            measure(item);
        }
    }

    @Override
    public long getSize(DataGenerator data){
        return size;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    private void measure(DataGenerator data){
        if (!data.isCollection())
            measure(data,1);
        else
            measureCollectionData(data);
    }

    private void measureCollectionData(DataGenerator data){
        int step = configMaxValue / configStep;

        for (int i = 0; i <= configMaxValue; i += step){
            measure(data, i);
        }
    }

    private void measure(DataGenerator data, int i){
        clearGC(SLEEPING_TIME_BEFORE_DATA_CLEAN);
        data.generate(i);
        measureFreeMemory(data, i);
        createMeasuringResult(data, i);
    }

    private void measureFreeMemory(DataGenerator data, int i){
        clearGC(SLEEPING_TIME_BEFORE_DATA_CLEAN);
        long freeMemoryBefore = runtime.freeMemory();

        data.clearData();

        clearGC(SLEEPING_TIME_AFTER_DATA_CLEAN);
        long freeMemoryAfter = tryCallGCAgain(freeMemoryBefore, runtime.freeMemory());

        size = freeMemoryAfter - freeMemoryBefore;
    }

    private void clearGC(long sleep){
        System.gc();
        sleep(sleep);
    }

    private void sleep(long sleep){
        try {
            System.out.println(String.format("Sleeping for %d ms", sleep));
            Thread.sleep(sleep);
            System.out.println("Stop sleeping");

        } catch (InterruptedException e) {
            System.out.println("Sleep error " + e.getMessage());
        }
    }

    private long tryCallGCAgain(long memoryBefore, long memoryAfter){
        int tryCount = 0;

        while (memoryAfter < memoryBefore && tryCount < MAX_TRY_GC_COUNTS){
            System.out.println("Try call GC again...");

            clearGC(SLEEPING_TIME_AFTER_DATA_CLEAN);
            memoryAfter = runtime.freeMemory();
            tryCount++;
        }

        return memoryAfter;
    }

    private void createMeasuringResult(DataGenerator dataGenerator, int dataCount) {
        measuredDate.add(new MeasuringResult(dataGenerator.getDescription(), getSize(dataGenerator), dataCount, dataGenerator.isCollection()));
    }
}