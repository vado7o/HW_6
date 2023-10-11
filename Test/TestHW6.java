import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.AssertionsForClassTypes.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestHW6 {
    FormLists formLists = new FormLists();
    /**
     * 1. СНАЧАЛА ПРОВОДИМ СЕРИЮ UNIT-ТЕСТОВ ДЛЯ КАЖДОГО МОДУЛЯ ОТДЕЛЬНО
     */

    @Test
    /**
     * Тестируем модуль FormLists
     */
    void testFormLists() {
        // Проверяем, что размер списка, созданного через метод formList действительно соответствует переданному аргументу
        assertThat(formLists.formList(10).size()).isEqualTo(10);
        // Проверяем, что каждое число сгенерированное в списке соответствует типу Integer
        assertThat(formLists.formList(1).get(0)).isInstanceOf(Integer.class);
        // Проверяем, что при обращении к несуществующему индексу списка выбрасывается исключение IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> formLists.formList(3).get(4));
    }

    @Test
    /**
     * Тестируем модуль FindAverage
     */
    void testFindAverage() {
        FindAverage findAverage = new FindAverage();
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        ArrayList<Integer> array2 = new ArrayList<>();

        // Проверяем, что среднее арифметическое функции findAverage определяется правильно
        assertThat(findAverage.findAverage(array1)).isEqualTo(3);
        // Проверяем, что выбрасывается исключение ArithmeticException при передачи в метод findAverage пустого массива
        assertThrows(ArithmeticException.class, () -> findAverage.findAverage(array2));
    }

    @Test
    /**
     * Тестируем модуль CompareNums
     */
    void testCompareNumbs() {
        Integer num1 = 90;
        Integer num2 = 33;
        Integer num3 = null;
        CompareNums compareNums = new CompareNums();

        // Проверяем, что метод при передаче разных чисел выдаёт правильное решение
        assertThat(compareNums.compareNums(num1, num2)).isEqualTo("Первый список имеет большее среднее значение");
        assertThat(compareNums.compareNums(num2, num1)).isEqualTo("Второй список имеет большее среднее значение");
        assertThat(compareNums.compareNums(num1, num1)).isEqualTo("Средние значения равны");

        // Проверяем, что при передаче в качестве числа Null, выбрасывается исключение NullPointerException
        assertThrows(NullPointerException.class, () -> compareNums.compareNums(num3, num2));
    }

    @Test
    /**
     * Тестируем при помощи заглушек Mock
     */
    /**
     * Для начала пробуем глушить класс CompareNums
     */
    void testCompareNumsMock() {
        CompareNums compareNums = mock(CompareNums.class);
        when(compareNums.compareNums(5, 10)).thenReturn("Второй список имеет большее среднее значение");

        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(10, 3, 3, 4, 5));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(20, 3, 10, 7, 10));
        FindAverage findAverage = new FindAverage();

        assertThat(compareNums.compareNums(findAverage.findAverage(array1), findAverage.findAverage(array2))).
                isEqualTo("Второй список имеет большее среднее значение");
    }
    /**
     * Пробуем также глушить класс FindAverage
     */
    @Test
    void testFindAverageMock() {
        FindAverage findAverage = mock(FindAverage.class);
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(20, 3, 10, 7, 10));

        when(findAverage.findAverage(array1)).thenReturn(2);
        when(findAverage.findAverage(array1)).thenReturn(1);

        CompareNums compareNums = new CompareNums();
        assertThat(compareNums.compareNums(findAverage.findAverage(array1), findAverage.findAverage(array2))).
                isEqualTo("Первый список имеет большее среднее значение");
    }

    /**
     * 2. ПРОВОДИМ ИНТЕГРАЦИОННЫЙ ТЕСТ ВСЕГО ПРИЛОЖЕНИЯ, ЗАДЕЙСТВУЯ ВСЕ ЕГО МОДУЛИ
     */
    @Test
    void testAllModules() {
        FormLists formLists = new FormLists();
        FindAverage findAverage = new FindAverage();
        CompareNums compareNums = new CompareNums();

        ArrayList<Integer> arrayList1 = formLists.formList(20);
        ArrayList<Integer> arrayList2 = formLists.formList(2);

        Integer num1 = findAverage.findAverage(arrayList1);
        Integer num2 = findAverage.findAverage(arrayList2);

        Integer num = num1;
        if (num1 < num2) {
            num1 = num2;
            num2 = num;
        }
        assertThat(compareNums.compareNums(num1, num2)).isEqualTo("Первый список имеет большее среднее значение");
    }
}
