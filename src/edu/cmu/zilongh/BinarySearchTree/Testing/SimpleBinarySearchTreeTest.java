package edu.cmu.zilongh.BinarySearchTree.Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import edu.cmu.zilongh.BinarySearchTree.SimpleBinarySearchTree;

public class SimpleBinarySearchTreeTest {
	
	@Test
	public void TestBSTConstructor(){
		SimpleBinarySearchTree<Integer> t1 = new SimpleBinarySearchTree<Integer>();
		SimpleBinarySearchTree<Double> t2 = new SimpleBinarySearchTree<Double>();
		SimpleBinarySearchTree<String> t3 = new SimpleBinarySearchTree<String>();
		assertNotEquals(null,t1);
		assertNotEquals(null,t2);
		assertNotEquals(null,t3);
	}
	
	@Test
	public void TestBSTIntegerTree(){
		for(int i = 0; i < 10; i++){
			List<Integer> l = generateRandomNumberList(10000);
			SimpleBinarySearchTree<Integer> tree = new SimpleBinarySearchTree<Integer>();
			for(Integer num : l){
				tree.insert(num);
			}
			Collections.sort(l);
			List<Integer> testResult = tree.inorder();
			assertEquals(l,testResult);
		}
	}
	
	@Test
	public void TestBSTRemove(){
		//Random randomGenerator = new Random(System.currentTimeMillis());
		Integer arr[] = new Integer[] {90, 50, 100, 25, 40, 91, 101};
		ArrayList<Integer> l = new ArrayList<Integer>();
		for(Integer num : arr){
			l.add(num);
		}
		
		SimpleBinarySearchTree<Integer> tree = new SimpleBinarySearchTree<Integer>();
		for(Integer num : l){
			tree.insert(num);
		}
		Collections.sort(l);
		int idx = 5;
		System.out.printf("removing %d\n",l.get(idx));
		tree.remove(l.get(idx));
		l.remove(idx);
		List<Integer> l2 = tree.inorder();
		assertEquals(l,l2);
	}
	
	private List<Integer> generateRandomNumberList(int size){
		Random randomGenerator = new Random(System.currentTimeMillis());
		List<Integer> l = new ArrayList<Integer>();
		for(int i = 0; i < size; i++){
			l.add(randomGenerator.nextInt(size));
		}
		return l;
	}
}
