package edu.cmu.zilongh.BinarySearchTree;

import java.util.List;

public class SimpleBinarySearchTree<ValType extends Comparable<ValType> > 
			implements BinarySearchTree<ValType>{
	
	SimpleBSTNode<ValType> root = null;
	int size = 0;
	public SimpleBinarySearchTree(){
		size = 0;
	}
	
	@Override
	public boolean search(ValType val) {
		return root == null ? false : root.searchVal(val);
	}

	@Override
	public void insert(ValType val) {
		size++;
		if(root == null){
			root = new SimpleBSTNode<>(val);
		}else{
			root.insertVal(val);
		}
	}

	@Override
	public void remove(ValType val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ValType> inorder() {
		if(root == null)
			return null;
		return root.inorder();
	}

	@Override
	public List<ValType> preorder() {
		if(root == null)
			return null;
		return root.preorder();
	}

	@Override
	public List<ValType> postorder() {
		if(root == null)
			return null;
		return root.postoreder();
	}
	
}
