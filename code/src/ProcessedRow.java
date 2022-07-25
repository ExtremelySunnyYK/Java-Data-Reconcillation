import java.util.ArrayList;

public class ProcessedRow<T> {
    public final String key;
    public final ArrayList<String> data;

    public ProcessedRow(String key, ArrayList<String> data) {
        this.key = key;
        this.data = data;
    }
}