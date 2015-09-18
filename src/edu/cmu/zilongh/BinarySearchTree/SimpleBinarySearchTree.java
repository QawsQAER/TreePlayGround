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
		return (root == null) ? false : root.searchVal(val) != null;
	}
	
	public SimpleBSTNode<ValType> searchForNode(ValType val){
		return (root == null) ? null : root.searchVal(val);
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
	public boolean remove(ValType val) {
		if(root == null)
			return false;
		List<SimpleBSTNode<ValType>> l = root.searchValWithParent(val);
		if(l.size() == 0)
			return false;
		SimpleBSTNode<ValType> n = l.get(0);
		SimpleBSTNode<ValType> parent = l.get(1);
		if(n.left == null || n.right == null){
			if(parent == null){
				root = n.left == null ? n.right : n.left;
			}else{
				if(parent.left == n){
					parent.left = n.left == null ? n.right : n.left;
				}else{
					parent.right = n.left == null ? n.right : n.left;
				}
			}
		}else{
			SimpleBSTNode<ValType> rightMin = n.right;
			SimpleBSTNode<ValType> rightMinParent = null;
			while(rightMin.left != null){
				rightMinParent = rightMin;
				rightMin = rightMin.left;
			}
			if(parent == null){
				root = rightMin;
			}else{
				if(parent.left == n){
					parent.left = rightMin;
				}else{
					parent.right = rightMin;
				}
			}
			if(rightMinParent == null){
				//rightMin is exactly n.right;
				rightMin.left = n.left;
			}else{
				SimpleBSTNode<ValType> rightMinRightNode = rightMin.right;
				rightMin.left = n.left;
				rightMin.right = n.right;
				n.left = null;
				n.right = rightMinRightNode;
				rightMinParent.left = rightMinRightNode;
			}
		}
		return true;
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
