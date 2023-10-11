public class CompareNums {
    public String compareNums(Integer num1, Integer num2) {
        if (num1 > num2) return "Первый список имеет большее среднее значение";
        else if (num1 < num2) return "Второй список имеет большее среднее значение";
        else return "Средние значения равны";
    }
}
