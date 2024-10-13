public class Main {
    public static void main(String[] args) {
        Container<Integer> L = new Container<>();
        L.print();
        L.add(2);
        L.add(7);
        L.add(4);
        L.add(9);
        L.add(4);
        L.add(1);
        System.out.println(L.get(-2));
        System.out.println(L.get(4));
        System.out.println(L.get(13));
        L.print();
        L.remove(4);
        L.print();
    }
}
