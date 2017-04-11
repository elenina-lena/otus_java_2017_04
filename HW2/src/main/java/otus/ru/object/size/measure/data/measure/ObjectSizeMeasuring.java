package otus.ru.object.size.measure.data.measure;

import otus.ru.object.size.measure.data.generator.DataGenerator;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public interface ObjectSizeMeasuring {
    void measure(int length, DataGenerator... data);

    void measure(DataGenerator data);

    List<MeasuringResult> getMeasuredData();

    long getSize(DataGenerator data);
}


