package com.learning.tree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestTree {

	public static void main(String[] args) {
		Tree tree = new Tree();
		
		Node root = tree.getTree();
		
		// Map<Integer, Integer> map = new LinkedHashMap<>();
		//Tree.printSameLevelSum(root, map, 0);
		// System.out.println(Tree.maxDepth(root));
		
		//Map<Integer, Integer> map = new HashMap<>();
		
		//Tree.printRightView(root);
		//(root);
		
		Map<Integer, Integer> map = Tree.printTopView(root);
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}
		
		

	}

}
