package edu.cmu.zilongh.BinarySearchTree;

import java.util.*;

public class SimpleBSTNode<ValType extends Comparable<ValType> > {
	SimpleBSTNode<ValType> left;
	SimpleBSTNode<ValType> right;
	ValType val;
	int times;
	
	public SimpleBSTNode(ValType val){
		this.val = val;
		times = 1;
		left = null;
		right = null;
	}
	
	public void increamentTimes(){
		times++;
	}
	
	public void decrementTimes(){
		times--;
	}
	
	public int getTimes(){
		return times;
	}
	
	public void insertVal(ValType val){
		SimpleBSTNode<ValType> last = null, n = this;
		while(n != null){
			last = n;
			int compareResult = val.compareTo(n.val);
			if(compareResult == 0){
				n.increamentTimes();
				return ;
			}else if(compareResult > 0){
				n = n.right;
			}else if(compareResult < 0){
				n = n.left;
			}
		}
		n = new SimpleBSTNode<ValType>(val);
		if(last.val.compareTo(n.val) > 0){
			last.left = n;
		}else{
			last.right = n;
		}
	}
	
	public boolean searchVal(ValType val){
		SimpleBSTNode<ValType> n = this;
		while(n != null){
			int compareResult = val.compareTo(n.val);
			if(compareResult == 0){
				return true;
			}else if(compareResult > 0){
				n = n.right;
			}else if(compareResult < 0){
				n = n.left;
			}
		}
		return false;
	}
	
	public List<ValType> preorder(){
		List<ValType> l = new ArrayList<ValType>();
		SimpleBSTNode<ValType> n = this;
		Stack<SimpleBSTNode<ValType>> s = new Stack<SimpleBSTNode<ValType>>();
		while(s.isEmpty() == false || n != null){
			if(n == null){
				n = s.pop();
			}else{
				if(n.right != null){
					s.push(n.right);
				}
				for(int i = 0; i < n.times; i++)
					l.add(n.val);
				n = n.left;
			}
		}
		return l;
	}
	
	public List<ValType> inorder(){
		List<ValType> l = new ArrayList<ValType>();
		SimpleBSTNode<ValType> n = this;
		Stack<SimpleBSTNode<ValType>> s = new Stack<SimpleBSTNode<ValType>>();
		while(s.isEmpty() == false || n != null){
			if(n == null){
				n = s.pop();
				for(int i = 0; i < n.times; i++)
					l.add(n.val);
				n = n.right;
			}else{
				s.push(n);
				n = n.left;
			}
		}
		return l;
	}
	
	public List<ValType> postoreder(){
		List<ValType> l = new ArrayList<ValType>();
		SimpleBSTNode<ValType> n = this, lastNode = null;
		Stack<SimpleBSTNode<ValType>> s = new Stack<SimpleBSTNode<ValType>>();
		while(s.isEmpty() == false || n != null){
			if(n == null){
				SimpleBSTNode<ValType> node = s.peek();
				if(node.right != null && lastNode != node.right){
					//if right child exists and not traversing node from right child
					n = node.right;
				}else{
					for(int i = 0; i < n.times; i++)
						l.add(n.val);
					lastNode = s.pop();
				}
			}else{
				s.push(n);
				n = n.left;
			}
		}
		return l;
	}
	
	public boolean deleteVal(ValType val){
		return false;
	}
}
