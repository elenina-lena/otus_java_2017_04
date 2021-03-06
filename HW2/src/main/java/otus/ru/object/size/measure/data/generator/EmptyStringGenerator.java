package otus.ru.object.size.measure.data.generator;

import org.apache.commons.lang3.StringUtils;

public class EmptyStringGenerator extends AbstractSingleDataGenerator {
    private static final String EMPTY_STRING_DESCRIPTION = "Empty string";
    private String data;

    @Override
    public String getDescription(){
        return EMPTY_STRING_DESCRIPTION;
    }

    @Override
    public void generate(int dataLength){
        data = StringUtils.EMPTY;
    }

    @Override
    public Object getData(){
        return data;
    }

    @Override
    public void clearData() {
        data =  null;
    }
}
