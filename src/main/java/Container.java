public class Container <T> {
    private Node<T> head;

    public Container() {
        head=null;
    }

    public Container(T data) {
        head=new Node<>(data);
    }

    public static class Node<T> {
        private final T data;
        private Node<T> next;

        private Node(T data) {
            this.data = data;
            next = null;
        }
    }

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

    public T get(int index){
        if (index < 0){
            System.out.println("the index must be greater than 0 ");
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
            System.out.println("there are not enough elements in the container ");
        }
        return null;
    }

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
