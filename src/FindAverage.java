import java.util.ArrayList;

public class FindAverage {
    public Integer findAverage(ArrayList<Integer> arrray) {
        Integer sum = 0;
        for (int i = 0; i < arrray.size(); i++) {
            sum += arrray.get(i);
        }
        return sum / arrray.size();
    }
}
