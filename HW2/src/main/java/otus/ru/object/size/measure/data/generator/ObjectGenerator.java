package otus.ru.object.size.measure.data.generator;

public class ObjectGenerator extends AbstractSingleDataGenerator {
    private static final String DESCRIPTION = "Simple Object";
    private Object data;

    @Override
    public String getDescription(){
        return DESCRIPTION;
    }

    @Override
    public void generate(int dataLength){
        data = new Object();
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

