package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import application.model.Entry;
import application.model.Stack;
import application.model.Symbol;
import application.model.exceptions.BadTypeException;
import application.model.exceptions.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for the methods of the stack class.
 * 
 * @author Henry Russell &ltzfac023@live.rhul.ac.uk&gt
 * @see Stack
 */
public class AStackShouldBeAbleTo {

  private Stack testStack;
  private Stack populatedTestStack;

  /**
   * Creates an empty stack for testing.
   */
  // Code implemented? Create stack class.
  @Before
  public void setup() {
    testStack = new Stack();
  }

  /**
   * Test 1, Tests that a new stack is 'empty' when created.
   */
  // Code implemented? isEmpty() method of stack (hard coded to true).
  @Test
  public void beEmptyWhenCreated() {
    assertTrue("A stack should be empty when created", testStack.isEmpty());
  }

  /**
   * Test 2, tests that when an entry with value 5f is added to the stack, the stack increases in
   * size.
   */
  // Code implemented? Size field which gets incremented when entry is added.
  @Test
  public void increaseInSizeWhenEntryIsAdded() {
    testStack.push(new Entry(5f));
    assertEquals("A stack should be size 1 when a single entry is added", 1, testStack.size());
  }


  /**
   * Test 3, tests that a new stack is not 'empty' when it contains entry with value 5f.
   */
  // Code implemented? Updated isEmpty to return true if size!=0.
  @Test
  public void notBeEmptyWhenPopulated() {
    testStack.push(new Entry(5f));
    assertFalse("A stack should NOT be empty if it has items", testStack.isEmpty());
  }

  /**
   * Test 4, tests when an Entry with value 5f is removed from the stack, the stack decreases in
   * size.
   * 
   * @throws EmptyStackException if pop() is called on an empty.
   */
  // code implemented? A pop method which decreases size counter by one.
  @Test
  public void decreaseInSizeWhenEntryIsRemoved() throws EmptyStackException {
    testStack.push(new Entry(5f)); // size 1
    testStack.push(new Entry(5f)); // size 2
    testStack.pop(); // expected size 1

    assertEquals("A stack of size 2 should decrease to size 1 when an Entry is removed", 1,
        testStack.size());
  }

  /**
   * Test 5, tests that if the stack contains no entry and pop is called, an exception is thrown.
   */
  // Code implemented? Error message and custom error class for empty stacks.
  @Test
  public void throwAnExceptionIfPoppedWhenEmptyWithGoodErrorMessage() {
    try {
      testStack.pop();
      fail("A stack should throw an exception if popped when empty");
    } catch (EmptyStackException err) {
      assertEquals("A stack should give the error message if popped when empty",
          "EmptyStackException: Cannot pop on empty stack", err.getMessage());
    }
  }

  /**
   * Test 6, tests that when push() is called the Entry of 5f is stored and can be retrieved with
   * pop().
   * 
   * @throws BadTypeException    if the type of getValue() is not a float.
   * @throws EmptyStackException if pop() is called on an empty stack.
   */
  // Code implemented? Fixed size Array field so now entry stores its value. Pop now returns an
  // Entry.
  @Test
  public void returnTheLastItemPushed() throws BadTypeException, EmptyStackException {
    testStack.push(new Entry(5f));
    assertEquals("A stack should be able return the last item pushed", 5f,
        testStack.pop().getValue(), 0.0);
  }

  /**
   * Test 7, tests that 20 float entries can be stored in the stack, and can be removed in reverse
   * order.
   * 
   * @throws BadTypeException    if the type of getValue() is not a float.
   * @throws EmptyStackException if pop() is called on an empty stack.
   */
  // Code implemented? replaced fixed size array field with arraylist.
  @Test
  public void storeAndRetrieveTwentyFloats() throws BadTypeException, EmptyStackException {
    for (float i = 0f; i <= 20f; i++) {
      testStack.push(new Entry(i));
    }
    for (float j = 20f; j >= 0f; j--) {
      assertEquals("A stack should be able to store and retrieve the entry value:" + j,
          testStack.pop().getValue(), j, 0.0);
    }
  }

  /**
   * Setup a new stack object 3 Entries with values 5f, "string" and Symbol.DIVIDE.
   * 
   * @throws BadTypeException if push() is called with an invalid argument.
   */
  @Before
  public void populateStackForTesting() throws BadTypeException {
    populatedTestStack = new Stack();
    populatedTestStack.push(new Entry(5f));
    populatedTestStack.push(new Entry(Symbol.DIVIDE));
  }

  /**
   * Test 8, tests that a stack can store Entries of symbol Symbol.DIVIDE, str "string" and value 5f
   * retrieve these values in reverse order.
   * 
   * @throws BadTypeException    if the type of getValue() is an invalid type.
   * @throws EmptyStackException if pop() is called on an empty stack.
   */

  @Test
  public void storeAndRetrieveEntrysOfTypeFloatStringAndSymbol()
      throws BadTypeException, EmptyStackException {
    // Symbol is returned first as stack is a last in first out data structure.
    assertEquals("A stack should be able to store and retrieve entry of with symbol Symbol.DIVIDE",
        Symbol.DIVIDE, populatedTestStack.pop().getSymbol());
    assertEquals("A stack should be able to store and retrieve value 5f", 5f,
        populatedTestStack.pop().getValue(), 0.0);
  }

  /**
   * Test 9, tests that a stack can store Entries of symbol Symbol.DIVIDE, str "string" and value 5f
   * retrieve these values in reverse order.
   * 
   * @throws BadTypeException    if the type of getValue() is an invalid type.
   * @throws EmptyStackException if pop() is called on an empty stack.
   */
  // Code implemented? top() method which returns value at the top of the stack.
  @Test
  public void retrieveFloatStringAndSymbolFromTheTopOfTheStack()
      throws BadTypeException, EmptyStackException {
    assertEquals("A stack should return", Symbol.DIVIDE, populatedTestStack.top().getSymbol());
    // Check twice so we know value isn't removed.
    assertEquals("", Symbol.DIVIDE, populatedTestStack.top().getSymbol());
  }

  /**
   * Test 10, tests that top() method throws an exception is called when the stack size is 0.
   */
  // Code implemented? Updated top() method to throw error.
  @Test
  public void throwAnExceptionIfTopIsCalledWhenEmptyWithGoodErrorMessage() {
    try {
      testStack.top();
      fail("A stack should throw an exception if top is called when empty");
    } catch (EmptyStackException err) {
      assertEquals("A stack should give error message if popped when empty",
          "EmptyStackException: Cannot call top() on empty stack", err.getMessage());
    }
  }

  /**
   * Test 11, test toString() presents the stack Entries in a readable way.
   * 
   * @throws BadTypeException if the type of getValue() is an invalid type.
   */
  // Code implemented? toString method.
  @Test
  public void printItsContents() throws BadTypeException {
    assertEquals("Stack toString() Should print its contents Stack: [5.0, /]", "Stack: [5.0, /]",
        populatedTestStack.toString());
  }

}
