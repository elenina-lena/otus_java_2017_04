package otus.ru.object.size.measure.data.measure.algorithms;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import otus.ru.object.size.measure.data.generator.DataGenerator;
import otus.ru.object.size.measure.data.measure.MeasuringResult;
import otus.ru.object.size.measure.data.measure.ObjectSizeMeasuring;
import otus.ru.object.size.measure.data.measure.configuration.MeasureConfiguration;

import java.util.*;

public class ObjectSizeCalculatorMeasuring implements ObjectSizeMeasuring<MeasureConfiguration> {
    private static final String DESCRIPTION = "ObjectSizeCalculator library algorithm";

    private MeasureConfiguration measureConfiguration;
    private List<MeasuringResult> measuredDate = new ArrayList<>();
    private int configMaxValue;
    private int configStep;

    public ObjectSizeCalculatorMeasuring(MeasureConfiguration configuration){
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
        return ObjectSizeCalculator.getObjectSize(data.getData());
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    private void measure(DataGenerator data){
        if (!data.isCollection())
            measure(data, 1);
        else
            measureCollectionData(data);
    }

    private void measureCollectionData(DataGenerator data){
        int step = configMaxValue / configStep;

        for (int i = 0; i <= configMaxValue; i += step){
            measure(data, i);

            data.clearData();
        }
    }

    private void measure(DataGenerator data, int i){
        data.generate(i);
        createMeasuringResult(data, i);
    }

    private void createMeasuringResult(DataGenerator dataGenerator, int dataCount) {
        measuredDate.add(new MeasuringResult(dataGenerator.getDescription(), getSize(dataGenerator), dataCount, dataGenerator.isCollection()));
    }
}
