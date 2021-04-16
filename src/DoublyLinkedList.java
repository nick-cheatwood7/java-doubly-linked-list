public class DoublyLinkedList {

  // Create Node object
  class Node {
    String data;
    Node prev;
    Node next;

    public Node(String data) {
      this.data = data;
    }
  }

  // Keep track of size of list
  public int size = 0;

  public int getSize() {
    return this.size;
  }

  // Init head and tail for the list
  Node head = null;
  Node tail = null;

  // Method for inserting a node into the list
  public void insertNode(String data) {
    // Create the node
    Node newNode = new Node(data);
    // Check if the doubly linked list is empty or not
    if (head == null) {
      // Make sure the node points to the correct head and tail
      head = newNode;
      tail = newNode;
      // This is the first node, so the previous will be null
      head.prev = null;
      // This is also the last node, so the tail's next will also be null
      tail.next = null;
    } else {
      // List is not empty
      // Node will be inserted on the end, so update the tail's next
      tail.next = newNode;
      // Update the previous for the new node
      newNode.prev = tail;
      // Overwrite the existing tail with the new node (also update the 'next' value)
      tail = newNode;
      tail.next = null;
    }
    size++;
  }

  // Method for adding to beginning of list
  public void addFirst(Node node) {
    // The node overwrites the head and tail
    head.prev = node;
    node.next = head;
    // It is also the first node, so head prev and tail next is empty
    node.prev = null;
    head = node;
  }

  // Method for adding to end of list
  public void addLast(Node node) {
    // Tail next will point to the new node
    tail.next = node;
    // Point to existing tail
    node.prev = tail;
    // Overwrite tail
    tail = node;
    // Empty out tail's next
    tail.next = null;
  }

  // Method for inserting node at a given position
  public void insertNode(String data, int pos) {
    // Init the node
    Node newNode = new Node(data);
    // Check if the list is empty or not
    if (head == null) {
      System.out.println("The specified position is not available");
    } else {
      // List is populated
      if (pos == size + 1) {
        // Insert in last
        addLast(newNode);
      } else if (pos == 1) {
        // Add to beginning
        addFirst(newNode);
      } else {
        // Insert at position
        // Current node will initially be the head
        Node current = head;
        Node temp = null;

        // Loop over DLL until we reach given position
        for (int i = 1; i < pos - 1; i++) {
          current = current.next;
        }

        // Temp node points to the node next to current
        temp = current.next;
        temp.prev = current;

        // newNode will be inserted between current and temp
        current.next = newNode;
        newNode.prev = current;
        newNode.next = temp;
        temp.prev = newNode;

      }
      size++;
    }
  }

  // Method for deleting node at a specified position
  public void deleteNode(int pos) {
    // Check if the DLL is empty
    if (head == null || pos > size) {
      System.out.println("\nThe position " + pos + " is not available in the list.");
    } else {
      // List is populated
      if (pos == 1) {
        // Remove the first node
        head = head.next;
        size--;
      } else if (pos == size) {
        // Remove the last node
        tail = tail.prev;
        size--;
      } else {
        // Remove Nth position
        Node current = head;
        for (int i = 1; i < pos; i++) {
          current = current.next;
        }

        // Delete current node
        current.next.prev = current.prev;
        current.prev.next = current.next;
      }
      switch (pos) {
      case 1:
        System.out.println("\nThe " + pos + "st node was deleted successfully.");
        break;
      case 2:
        System.out.println("\nThe " + pos + "nd node was deleted successfully.");
        break;
      case 3:
        System.out.println("\nThe " + pos + "rd node was deleted successfully.");
        break;
      default:
        System.out.println("\nThe " + pos + "th node was deleted successfully.");
      }
    }
  }

  // TODO: Add Deep Copy Method

  // Method for getting the contents of a DLL
  public void getData() {
    // Init a new node pointing to the head
    Node current = head;
    // Check if the list if empty or not
    if (head == null) {
      // Print an exception
      System.out.println("The list is empty");
      return;
    } else {
      // List is populated
      System.out.println("\nNodes in the list:");
      // Iterate over the list
      int index = 1;
      while (current != null) {
        // Print data on each node and increment pointer
        System.out.println(index + " ~> " + current.data);
        current = current.next;
        index++;
      }
    }
  }

}
