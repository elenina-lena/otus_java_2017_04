package otus.ru.object.size.measure.data.measure;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import otus.ru.object.size.measure.data.generator.DataGenerator;

import java.util.*;

public class ObjectMemorySizeMeasuring implements ObjectSizeMeasuring {
    private static final int STEP = 10;

    private List<MeasuringResult> measuredDate = new ArrayList<>();

    @Override
    public List<MeasuringResult> getMeasuredData(){
       return measuredDate;
    }

    @Override
    public void measure(int length, DataGenerator... data){
         int step = length / STEP;

        for(DataGenerator item : data){
            for (int i = 0; i <= length; i += step){
                item.generate(i);
                createMeasuringResult(item, i);
            }
        };
    }

    @Override
    public void measure(DataGenerator data){
        createMeasuringResult(data, 0);
    }

    @Override
    public long getSize(DataGenerator data){
        return ObjectSizeCalculator.getObjectSize(data.getData());
    };

    private void createMeasuringResult(DataGenerator dataGenerator, int dataCount) {
        measuredDate.add(new MeasuringResult(dataGenerator, getSize(dataGenerator), dataCount));
    }
}
