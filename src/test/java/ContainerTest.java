import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ContainerTest {
    private Container<Integer> container;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    // Настраиваем поток вывода для перехвата сообщений
    @Before
    public void setUp() {
        container = new Container<>();
        System.setOut(new PrintStream(outContent));
    }

    // Тест конструктора без параметров
    @Test
    public void testConstructorWithoutParams() {
        assertNotNull(container);
    }

    // Тест конструктора с параметром
    @Test
    public void testConstructorWithParam() {
        Container<Integer> containerWithElement = new Container<>(10);
        assertEquals(Integer.valueOf(10), containerWithElement.get(0));
    }

    // Тест добавления элементов
    @Test
    public void testAdd() {
        container.add(1);
        container.add(2);
        container.add(3);

        assertEquals(Integer.valueOf(1), container.get(0));
        assertEquals(Integer.valueOf(2), container.get(1));
        assertEquals(Integer.valueOf(3), container.get(2));
    }

    // Тест получения элемента по индексу
    @Test
    public void testGet() {
        container.add(100);
        container.add(200);

        assertEquals(Integer.valueOf(100), container.get(0));
        assertEquals(Integer.valueOf(200), container.get(1));
    }

    // Тест получения элемента с отрицательным индексом (ожидаем сообщение)
    @Test
    public void testGetNegativeIndex() {
        container.add(1);
        container.get(-1);  // Некорректный индекс

        assertEquals("the index must be greater than 0 \n", outContent.toString());
    }

    // Тест получения элемента с индексом вне диапазона (ожидаем сообщение)
    @Test
    public void testGetOutOfRangeIndex() {
        container.add(1);
        container.get(5);  // Индекс вне диапазона

        assertEquals("there are not enough elements in the container \n", outContent.toString());
    }

    // Тест удаления элемента по значению
    @Test
    public void testRemove() {
        container.add(1);
        container.add(2);
        container.add(3);

        container.remove(2);

        assertEquals(Integer.valueOf(1), container.get(0));
        assertEquals(Integer.valueOf(3), container.get(1));
    }

    // Тест удаления несуществующего элемента
    @Test
    public void testRemoveNonExistentElement() {
        container.add(1);
        container.add(2);

        container.remove(3); // Элемента 3 нет в списке

        assertEquals(Integer.valueOf(1), container.get(0));
        assertEquals(Integer.valueOf(2), container.get(1));
    }

    // Тест печати пустого контейнера
    @Test
    public void testPrintEmpty() {
        container.print();
        assertEquals("Container is empty", outContent.toString().trim());
    }

    // Тест печати непустого контейнера
    @Test
    public void testPrintNonEmpty() {
        container.add(1);
        container.add(2);
        container.print();

        assertEquals("1 2", outContent.toString().trim());
    }
}