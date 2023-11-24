
// 필요한 자바 유틸리티 클래스들을 임포트
import java.util.Iterator; // Iterator 인터페이스를 임포트. 리스트와 같은 컬렉션을 반복 순회하는데 사용.
import java.util.NoSuchElementException; // NoSuchElementException 예외를 임포트. 이터레이터에서 더 이상 요소가 없을 때 발생하는 예외.

// MyLinkedList 클래스 정의: 제네릭 타입 T를 사용하는 연결 리스트를 구현
public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head; // 연결 리스트의 첫 번째 노드를 가리킴
    private int size; // 리스트의 현재 크기 저장

    // 노드 클래스 정의: 연결 리스트의 각 요소를 나타냄
    private static class Node<T> {
        T data; // 노드가 저장하는 데이터
        Node<T> next; // 다음 노드를 가리키는 포인터

        // 노드 생성자
        Node(T data) {
            this.data = data;
            this.next = null; // 다음 노드는 초기에는 없음
        }
    }

    // MyLinkedList 생성자
    public MyLinkedList() {
        head = null; // 처음에는 리스트가 비어있음
        size = 0; // 크기는 0으로 초기화
    }

    // 리스트의 마지막에 요소 추가 메서드
    public void add(T data) {
        if (head == null) { // 리스트가 비어있는 경우
            head = new Node<>(data); // 새 노드를 head로 설정
        } else {
            Node<T> current = head;
            while (current.next != null) { // 마지막 노드 찾기
                current = current.next;
            }
            current.next = new Node<>(data); // 마지막 노드 뒤에 새 노드 추가
        }
        size++; // 크기 증가
    }

    // 특정 인덱스의 요소 반환 메서드
    public T get(int index) {
        if (index < 0 || index >= size) { // 인덱스 유효성 검사
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) { // 해당 인덱스까지 이동
            current = current.next;
        }
        return current.data; // 데이터 반환
    }

    // 특정 인덱스의 요소 삭제 메서드
    public void delete(int index) {
        if (index < 0 || index >= size) { // 인덱스 유효성 검사
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) { // 첫 번째 요소 삭제
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) { // 삭제할 노드의 바로 전 노드까지 이동
                current = current.next;
            }
            current.next = current.next.next; // 삭제할 노드를 건너뛰도록 연결 변경
        }
        size--; // 크기 감소
    }

    // 리스트의 크기 반환 메서드
    public int size() {
        return size;
    }

    // 리스트의 첫 번째 요소를 확인하는 메서드
    public T peek() {
        if (head != null) {
            return head.data; // 첫 번째 요소 반환
        }
        return null; // 리스트가 비어있으면 null 반환
    }

    // 이터레이터 구현: 리스트 순회 가능
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    // MyLinkedListIterator 클래스: MyLinkedList를 순회하는 이터레이터
    private class MyLinkedListIterator implements Iterator<T> {
        private Node<T> current = head; // 현재 노드를 가리키는 포인터

        @Override
        public boolean hasNext() {
            return current != null; // 다음 요소가 존재하는지 확인
        }

        @Override
        // `@Override` 애너테이션: 이 메서드가 부모 클래스 또는 인터페이스의 메서드를 오버라이드(재정의)한다는 것을 명시
        // 여기서는 Iterator 인터페이스의 next 메서드를 오버라이드함.
        public T next() {
            if (!hasNext()) { // 더 이상 요소가 없으면 예외 발생
                throw new NoSuchElementException();
            }
            T data = current.data; // 현재 데이터 반환
            current = current.next; // 다음 노드로 이동
            return data;
        }

    }
}
