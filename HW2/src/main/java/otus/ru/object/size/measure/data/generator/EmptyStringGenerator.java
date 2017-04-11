package otus.ru.object.size.measure.data.generator;

import org.apache.commons.lang3.StringUtils;

public class EmptyStringGenerator implements DataGenerator {
    private static final String EMPTY_STRING_DESCRIPTION = "Empty string";

    @Override
    public String getDescription(){
        return EMPTY_STRING_DESCRIPTION;
    };

    @Override
    public void generate(int dataLength){

    };

    @Override
    public Object getData(){
        return StringUtils.EMPTY;
    };

    @Override
    public boolean isCollection(){
        return false;
    }
}
