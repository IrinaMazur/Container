/**
 * Класс Container представляет собой реализацию односвязного списка
 *
 * @param <T> тип данных элементов списка, который пользователь хочет использовать в классе
 */
public class Container <T> {
    private Node<T> head;

    /**
     * Конструктор по умолчанию
     */
    public Container() {
        head=null;
    }

    /**
     * Конструктор, принимающий один параметр на вход
     *
     * @param data принимает любой тип данных
     *
     */
    public Container(T data) {
        head=new Node<>(data);
    }

    /**
     * Node - класс узлов, из которых состоит список
     *
     * @param <T> тип данных элемента узла
     */
    public static class Node<T> {
        private final T data;
        private Node<T> next;

        /**
         * Конструктор с параметром
         *
         * @param data данные, которые будут храниться в узле
         */
        private Node(T data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * Метод добавления элемента в конец списка
     *
     * @param data элемент, которые будет добавлен в узел списка
     */
    public void add(T data){
        Node<T> newNode = new Node<>(data);
        Node<T> curNode = head;
        if (head == null){
            head = newNode;
        } else {
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next=newNode;
        }
    }

    /**
     * Метод удаления хранящегося в списке значения
     *
     * @param data удаляемое значение
     */
    public void remove(T data){
        Node<T> curNode = head;
        Node<T> prevNode =null;
        while (curNode.next != null) {
            if (curNode.data == data){
                if (curNode == head){
                    head = head.next;
                } else {
                    prevNode.next = curNode.next;
                }
            }
            prevNode = curNode;
            curNode = curNode.next;
        }

    }

    /**
     * Метод получения хранящегося в списке значения по индексу
     *
     * @param index индекс, по которому находится значение
     *
     * @return Значение найденного элемента
     */
    public T get(int index){
        if (index < 0){
            System.out.print("the index must be greater than 0 \n");
        } else {
            Node<T> curNode = head;
            int curInd = 0;
            while (curNode != null) {
                if (curInd == index){
                    return curNode.data;
                }
                curNode = curNode.next;
                curInd++;
            }
            System.out.print("there are not enough elements in the container \n");
        }
        return null;
    }

    /**
     * Вывод элементов списка через пробел
     */
    public void print(){
        if (head==null){
            System.out.print("Container is empty");
        }
        Node<T> curNode = head;
        while (curNode != null){
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
        System.out.println();
    }

}
