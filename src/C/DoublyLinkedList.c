#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

/* Create the Node struct object */
struct Node
{
  int data;
  struct Node *next; // Points to next node in list
  struct Node *prev; // Points to prev node in list
};

/* Method to push to front of list */
void push(struct Node **head_ref, int new_data)
{
  // Same as "Add First"
  // Assign the node via memory allocation (malloc)
  struct Node *new_node = (struct Node *)malloc(sizeof(struct Node));

  // Insert given data
  new_node->data = new_data;

  // Inserting at front of list overwrites previous and re-assigns next
  new_node->next = (*head_ref);
  new_node->prev = NULL;
}

/* Method to insert after a given index */
void insert(struct Node *prev_node, int new_data)
{
  // Check if the given prev_node is empty
  if (prev_node == NULL)
  {
    printf("The given previous node cannot be empty");
    return;
  }
  // Assign the node via memory allocation
};