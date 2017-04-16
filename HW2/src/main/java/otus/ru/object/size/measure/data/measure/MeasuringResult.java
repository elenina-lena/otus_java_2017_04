package otus.ru.object.size.measure.data.measure;

public class MeasuringResult {
    private String description;
    private long bytes;
    private int length;
    private boolean isCollection;

    public MeasuringResult(String description, long bytes, int length, boolean isCollection){
        this.description = description;
        this.bytes = bytes;
        this.length = length;
        this.isCollection = isCollection;
    }

    public long getBytes() {
        return bytes;
    }

    public int getLength() {
        return length;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCollection() {
        return isCollection;
    }
}
