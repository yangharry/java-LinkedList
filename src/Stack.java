import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    private MyLinkedList<T> list = new MyLinkedList<>();

    public void push(T data) {
        list.add(data);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T data = list.get(list.size() - 1);
        list.delete(list.size() - 1);
        return data;
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return list.get(list.size() - 1);
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
