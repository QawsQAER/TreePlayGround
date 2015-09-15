package edu.cmu.zilongh.BinarySearchTree;

import java.util.List;

/*
 * My own implementation of some classical Binary Search Tre
 * only support Integer type
 */
public interface BinarySearchTree<ValType extends Comparable<ValType>> {
	public boolean search(ValType i);
	public void insert(ValType i);
	public void remove(ValType i);
	public List<ValType> inorder();
	public List<ValType> preorder();
	public List<ValType> postorder();
}
