package edu.cmu.zilongh.BinarySearchTree.Testing;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	
	public static void main(String[] argv){
		
		Result result = JUnitCore.runClasses(SimpleBinarySearchTreeTest.class);
		for(Failure failure : result.getFailures()){
			System.out.println(failure.toString());
		}
		
	}
	
}
