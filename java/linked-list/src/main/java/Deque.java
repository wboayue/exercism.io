import java.util.NoSuchElementException;

public class Deque<T> {

  private Node front = null;
  private Node back = null;

  public Deque push(T item) {
    this.front = new Node(item, null, this.front);

    if (this.front.next != null) {
      this.front.next.previous = this.front;
    }

    if (this.back == null) {
      this.back = this.front;
    }

    return this;
  }

  public T pop() {
    if (this.front == null) {
      throw new NoSuchElementException();
    }

    Node<T> result = this.front;

    this.front = this.front.next;

    if (this.front == null) {
      this.back = null;
    }

    return result.item;
  }

  public T shift() {
    if (this.back == null) {
      throw new NoSuchElementException();
    }

    Node<T> result = this.back;

    this.back = this.back.previous;

    if (this.back == null) {
      this.front = null;
    }

    return result.item;
  }

  public Deque unshift(T item) {
    this.back = new Node(item, this.back, null);

    if (this.back.previous != null) {
      this.back.previous.next = this.back;
    }

    if (this.front == null) {
      this.front = this.back;
    }

    return this;    
  }

  private static class Node<T> {
    
    private T item;
    private Node previous;
    private Node next;

    public Node(T item, Node previous, Node next) {
      this.item = item;
      this.previous = previous;
      this.next = next;
    }

  }

}