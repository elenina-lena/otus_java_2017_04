package otus.ru.object.size.measure.data.measure;

import otus.ru.object.size.measure.data.generator.DataGenerator;
import java.util.List;

public interface ObjectSizeMeasuring<MeasureConfiguration> {
    void measure(DataGenerator... data);

    List<MeasuringResult> getMeasuredData();

    long getSize(DataGenerator data);

    MeasureConfiguration getMeasureConfiguration();

    String getDescription();
}


