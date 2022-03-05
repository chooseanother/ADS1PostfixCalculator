import java.util.Date;

public class LinkedList<T> implements List<T>{
    private Node<T> head;
    private int size;

    public LinkedList() {
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addToFront(T data) {
        head = new Node<T>(data, head);
        size++;
    }

    @Override
    public T removeFirst() throws EmptyListException {
        if (size == 0)
            throw new EmptyListException();
        Node<T> removedNode = head;
        head = removedNode.getNext();
        size--;
        return removedNode.getData();
    }
}
