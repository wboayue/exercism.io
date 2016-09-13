import java.util.NoSuchElementException;

public class Deque<T> {

  private Node<T> front = null;
  private Node<T> back = null;

  public boolean isEmpty() {
    return this.front == null || this.back == null;
  }

  public Deque push(T item) {
    if (isEmpty()) {
      addFirstItem(item);
    } else {
      this.front = this.front.addItemAhead(item);
    }
    return this;
  }

  private void addFirstItem(T item) {
    this.front = this.back = new Node(item);
  }

  public T pop() {
    if (isEmpty()) throw new NoSuchElementException();
  
    T item = this.front.item;
    this.front = this.front.next;
    if (this.front != null) this.front.previous = null;
    return item;
  }

  public T shift() {
    if (isEmpty()) throw new NoSuchElementException();

    T item = this.back.item;
    this.back = this.back.previous;
    if (this.back != null) this.back.next = null;
    return item;
  }

  public Deque unshift(T item) {
    if (isEmpty()) {
      addFirstItem(item);
    } else {
      this.back = this.back.addItemBehind(item);
    }
    return this;    
  }

  private static class Node<T> {
    
    private T item;
    private Node previous = null;
    private Node next = null;

    private Node(T item) {
      this.item = item;
    }

    private Node(T item, Node previous, Node next) {
      this.item = item;
      this.previous = previous;
      this.next = next;
    }

    private Node addItemAhead(T item) {
      Node inserted = new Node(item, null, this);
      this.previous = inserted;
      return inserted;
    }

    private Node addItemBehind(T item) {
      Node inserted = new Node(item, this, null);
      this.next = inserted;
      return inserted;
    }

  }

}