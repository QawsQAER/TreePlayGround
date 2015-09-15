package edu.cmu.zilongh.BinarySearchTree.Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
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
		List<Integer> l = generateRandomNumberList(10);
		SimpleBinarySearchTree<Integer> tree = new SimpleBinarySearchTree<Integer>();
		for(Integer num : l){
			tree.insert(num);
		}
		Collections.sort(l);
		List<Integer> testResult = tree.inorder();
		assertEquals(l,testResult);
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
