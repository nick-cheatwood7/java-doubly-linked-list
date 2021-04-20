package Java;

public class Node {

  // Create Node object
  private String data;
  private Node prev;
  private Node next;

  public Node(String data) {
    this.data = data;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getPrevious() {
    return prev;
  }

  public void setPrevious(Node prev) {
    this.prev = prev;
  }

}
