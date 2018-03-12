/*
 * A Node Class Implementation
 * 
 * @author Brent Garcia
 */
public class Node<Item> {
	
	/** reference to next & prev node in list*/
	private Node<Item> next, prev;
	
	/** element stored in at this node*/
	private Item element;
	
	/**
	 * Creates an empty node.
	 */
	public Node() {
		next = null;
		prev = null;
		element = null;
	}
	
	/**
	 * Creates a node storing the specified element.
	 * @param elem element to be stored
	 */
	
	public Node(Item elem) {
		next = null;
		prev = null;
		element = elem;
	}
	
	/**
	 * Returns the node that follows this one.
	 * @return Node<Item> reference to next node.
	 */
	public Node<Item> getNext(){
		return next;
	}
	
	/**
	 * Returns the node before this one.
	 * @return Node<Item> reference to prev node.
	 */
	public Node<Item> getPrev(){
		return prev;
	}
	
	/**
	 * Sets the node that follows this one.
	 * @param node node to follow this one
	 */
	public void setNext(Node<Item> node) {
		next = node;
	}
	
	/**
	 * Sets the node that follows this one.
	 * @param node node before this one.
	 */
	public void setPrev(Node<Item> node) {
		prev = node;
	}
	
	/**
	 * Return the element stored in this node.
	 * @return
	 */
	public Item getElement() {
		return element;
	}
	
	/**
	 * Sets the element stored in this node.
	 * @param elem element to be stored at this node
	 */
	public void setElement(Item elem) {
		element = elem;
	}
}
