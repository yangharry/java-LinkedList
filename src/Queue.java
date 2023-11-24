import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    // 큐에 요소 추가
    public void enqueue(T data) {
        list.add(data);
    }

    // 큐에 요소 제거
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T data = list.peek();
        list.delete(0);
        return data;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.peek();
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
