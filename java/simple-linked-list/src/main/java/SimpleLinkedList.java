import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class SimpleLinkedList {

  private Node head = null;
  private int size = 0;

  public SimpleLinkedList() {
  }

  public SimpleLinkedList(Integer[] items) {
    for (Integer item : reverse(items)) {
      push(item);
    }
  }

  public int size() {
    return this.size;
  }

  public SimpleLinkedList push(Integer item) {
    this.head = new Node(item, this.head);
    this.size += 1;
    return this;
  }

  public Integer pop() {
    if (this.head == null) {
      throw new NoSuchElementException();
    }

    Integer item = (Integer) this.head.item;
    this.head = this.head.next;
    this.size -= 1;

    return item;
  }

  public SimpleLinkedList reverse() {
    Integer[] items = asArray(Integer.class);
    this.head = null;

    for (Integer item : items) {
      push(item);
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

  private static class Node {
    private Object item;
    private Node next;

    private Node(Object item, Node next) {
      this.item = item;
      this.next = next;
    }
  }

  private List<Integer> reverse(Integer[] items) {
    List<Integer> list = Arrays.asList(items);
    Collections.reverse(list);
    return list;
  }

}