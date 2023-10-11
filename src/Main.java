import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FormLists formLists = new FormLists();
        ArrayList<Integer> array1 = formLists.formList(10);
        ArrayList<Integer> array2 = formLists.formList(9);
        System.out.println(array1);
        System.out.println(array2);

        FindAverage findAverage = new FindAverage();
        Integer num1 = findAverage.findAverage(array1);
        Integer num2 = findAverage.findAverage(array2);
        System.out.println(findAverage.findAverage(array1));
        System.out.println(findAverage.findAverage(array2));

        CompareNums compareNums = new CompareNums();
        System.out.println(compareNums.compareNums(num1, num2));
    }
}