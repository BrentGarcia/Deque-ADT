/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.
 * 
 * @author (Brent Garcia), Acuna
 * @version (1.0)
 */
import java.util.NoSuchElementException;
    
public class GarciaDeque<Item> implements Deque<Item> {

	private int count;
	private Node<Item> front, rear;
	
    /**
     * Program entry point for deque. 
     * @param args command line arguments
     */    
	
	public GarciaDeque() {
		count = 0;
		front = rear = null;
	}
	
	/**  
     * Adds one element to the front of this deque. 
     * @param element the element to be added to the front of the deque  
     */
    public void enqueueFront(Item element) {
    	// UNSURE OF THIS
    	Node<Item> node = new Node<Item> (element);
    	if (this.isEmpty())
    		front = node;
    	else {
    		node.setPrev(front);
    		front.setNext (node);   		
    	}
       	front = node;
    	count ++;
    }
    
    /**  
     * Adds one element to the back of this deque. 
     * @param element the element to be added to the back of the deque  
     */
    public void enqueueBack(Item element) {
    	Node<Item> node = new Node<Item> (element);
    	if (this.isEmpty())
    		front = node;
    	else {
    		rear.setPrev (node);
    		node.setNext(rear);
    	}
       	rear = node;
    	count ++;
    }

    /**  
     * Removes and returns the element at the front of this deque.
     * Throws an exception if the deque is empty.
     * @return the element at the front of this deque
     * @throws NoSuchElementException if the deque is empty
     */
    public Item dequeueFront() throws NoSuchElementException{
    	if (this.isEmpty())
    		throw new NoSuchElementException();
    	
    	Item result = front.getElement();
    	front = front.getPrev();
    	front.setNext(null);
    	count--;

    	if (isEmpty())
    		rear = null;
    	
    	return result;
    }
    
    /**  
     * Removes and returns the element at the back of this deque.
     * Throw an exception if the deque is empty.
     * @return the element at the back of the deque. 
     * @throws NoSuchElementException if the deque is empty
     */
    public Item dequeueBack() throws NoSuchElementException{
    	if (this.isEmpty())
    		throw new NoSuchElementException();
    	
    	Item result = rear.getElement();
    	rear = rear.getNext();
    	rear.setPrev(null);
    	count--;

    	if (isEmpty())
    		rear = null;
    	
    	return result;
    }

    /**  
     * Returns, without removing, the element at the front of this deque.
     * Should throw an exception if the deque is empty.
     * @return the first element in the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public Item first() throws NoSuchElementException{
    	if (this.isEmpty())
    		throw new NoSuchElementException();
    	
    	return front.getElement();
    }
    
    /**  
     * Returns, without removing, the element at the back of this deque.
     * Should throw an exception if the deque is empty.
     * @return the last element in the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public Item last() throws NoSuchElementException{
    	if (this.isEmpty())
    		throw new NoSuchElementException();
    	
    	return rear.getElement();
    	
    }
   
    /**  
     * Returns true if this deque is empty and false otherwise.
     * @return if deque empty
     */
    public boolean isEmpty() {
    	if (this.count == 0)
    		return true;
    	return false;
    }

    /**  
     * Returns the number of elements in this deque. 
     * @return the number of elements in the deque
     */
    public int size() {
    	return this.count;
    }

    /**  
     * Returns a string representation of this deque. The back element
     * occurs first, and each element is separated by a space. If the
     * deque is empty, returns "empty".
     * @return the string representation of the deque
     */
    @Override
    public String toString() {
    	Node<Item> node = rear;
    	Item iter = node.getElement();
    	String str = "";
    	while(node != null) {
    		iter = node.getElement();
    		str += String.valueOf(iter) + " ";
    		node = node.getNext();
    	}
    	return str;
    }
	
	
	
    public static void main(String[] args) {
        GarciaDeque<Integer> deque = new GarciaDeque<>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();        
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());   

        //deque features
        System.out.println(deque.dequeueFront());        
        deque.enqueueFront(1);
        deque.enqueueFront(11);                         
        deque.enqueueFront(3);                 
        deque.enqueueFront(5);         
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());        
        System.out.println(deque.last());                
        deque.dequeueFront();
        deque.dequeueFront();        
        System.out.println(deque.first());        
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());            
    }
} 