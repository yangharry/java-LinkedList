
public class MyLinkedListMain {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("yang");
        list.add("hee");
        list.add("il");

        System.out.println("Element at index 1: " + list.get(1));
        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("Size of list: " + list.size());

        list.delete(2);

        System.out.println("Size of list: " + list.size());

        for (String i : list) {
            System.out.println(i);
        }
    }
}
