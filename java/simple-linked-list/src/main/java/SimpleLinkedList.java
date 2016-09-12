import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleLinkedList<T> {

  private Node head = null;
  private int size = 0;

  public SimpleLinkedList() {
  }

  public SimpleLinkedList(T[] items) {
    for (T item : reverse(items)) {
      push(item);
    }
  }

  public int size() {
    return this.size;
  }

  public SimpleLinkedList push(T item) {
    this.head = new Node(item, this.head);
    this.size += 1;
    return this;
  }

  public T pop() {
    if (this.head == null) {
      throw new NoSuchElementException();
    }

    T item = (T) this.head.item;
    this.head = this.head.next;
    this.size -= 1;

    return item;
  }

  public SimpleLinkedList reverse() {
    Node old = this.head;
    for (this.head = null; old != null; old = old.next) {
      this.head = new Node(old.item, this.head);
    }
    return this;
  }

  public <U> U[] asArray(Class<U> clazz) {
    U[] result = (U[]) Array.newInstance(clazz, size());

    int i = 0;
    Node iter = this.head;
    while (iter != null) {
      result[i++] = (U) iter.item;
      iter = iter.next;
    }

    return result;
  }

  private static class Node<T> {
    private T item;
    private Node next;

    private Node(T item, Node next) {
      this.item = item;
      this.next = next;
    }
  }

  private List<T> reverse(T[] items) {
    List<T> list = Arrays.asList(items);
    Collections.reverse(list);
    return list;
  }

}