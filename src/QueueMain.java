public class QueueMain {
    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();

        queue.enqueue("yang");
        queue.enqueue("hee");
        queue.enqueue("il");
        queue.enqueue("yang");
        queue.enqueue("hee");
        queue.enqueue("il");

        System.out.println("Size of queue: " + queue.size());
        System.out.println("delete element: " + queue.dequeue());
        System.out.println("Size of queue: " + queue.size());
        queue.dequeue();
        System.out.println("Size of queue: " + queue.size());
        System.out.println("Peek of queue: " + queue.peek());
        System.out.println("Size of queue: " + queue.isEmpty());

        for (String i : queue) {
            System.out.println(i);
        }
    }
}
