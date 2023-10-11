import java.util.ArrayList;
import java.util.Random;

public class FormLists {
    public ArrayList<Integer> formList(Integer size) {
        Random rnd = new Random();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            array.add(rnd.nextInt(0, 100));
        }
        return array;
    }
}
