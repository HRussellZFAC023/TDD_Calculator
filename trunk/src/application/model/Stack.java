package application.model;

import application.model.exceptions.EmptyStackException;

import java.util.ArrayList;
import java.util.List;


/**
 * An implementation of last in, first out stack to store data entries.
 *
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see Entry
 *
 */
public class Stack {

  /**
   * The stack is internally represented as an ArrayList of Entries.
   */
  private List<Entry> stackEntries = new ArrayList<>();

  /**
   * Creates and entry and adds it to the top of the stack.
   *
   * @param entry to be added at the top of the stack.
   *
   */
  public void push(Entry entry) {
    stackEntries.add(entry);
  }

  /**
   * Returns the last element added to the stack then removes it.
   *
   * @return the last element to be added to the stack
   * @throws EmptyStackException if the stack is popped when empty.
   */
  public Entry pop() throws EmptyStackException {
    if (this.isEmpty()) {
      throw new EmptyStackException("EmptyStackException: Cannot pop on empty stack");
    }

    int stackHeadIndex = size() - 1;
    Entry stackHead = stackEntries.get(stackHeadIndex);
    stackEntries.remove(stackHeadIndex);
    return stackHead;
  }


  /**
   * Returns string version of the last element added to the stack then removes it.
   * 
   * @return the String of last element to be added to the stack
   * @throws EmptyStackException if the stack is popped when empty.
   */
  String popStr() throws EmptyStackException {
    return this.pop().toString();
  }

  /**
   * Returns the number of entries in the stack.
   *
   * @return number of items in the stack.
   */
  public int size() {
    return stackEntries.size();
  }

  /**
   * Returns the most recent element added to the stack.
   *
   * @return the element in the top of the stack
   * @throws EmptyStackException if the stack is popped when empty.
   */
  public Entry top() throws EmptyStackException {
    if (this.isEmpty()) {
      throw new EmptyStackException("EmptyStackException: Cannot call top() on empty stack");
    }
    return stackEntries.get(size() - 1);
  }

  /**
   * Returns the String version of most recent element added to the stack.
   *
   * @return the element in the top of the stack as String
   * @throws EmptyStackException if the stack is popped when empty.
   */
  String topStr() throws EmptyStackException {
    return top().toString();
  }


  /**
   * Returns if there are no entries in the stack.
   *
   * @return false if there is more than one entry in the stack.
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * Returns a string representation of entries in the stack.
   */
  @Override
  public String toString() {
    return "Stack: " + stackEntries.toString();
  }
}
