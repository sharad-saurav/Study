package com.learning.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Tree {
	
	Node root;
	
	public Node getTree() {
		this.root = new Node(1);
		this.root.left = new Node(2);
		this.root.right = new Node(3);
		this.root.left.left = new Node(4);
		this.root.left.right = new Node(5);
		this.root.right.left = new Node(6);
		this.root.right.right = new Node(7);
		return root;
	}
	
	public static void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.println(root.data);
		printInorder(root.right);
		
	}
	
	public static void printPreorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		printInorder(root.right);
		System.out.println(root.data);
				
	}
	
	public static void printPostorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		printInorder(root.left);
		printInorder(root.right);		
				
	}
	
	public static void printHighorder(Node root) {
		if (root == null) {
			return;
		}
		printHighorder(root.left);
		if(root.data > 5) {
			System.out.println(root.data);
		}
		printHighorder(root.right);
		
	}
	
	public static void printSameLevelSum(Node root, Map<Integer, Integer> sumMap, int distance) {
		if (root == null) {
			return;
		}
		printSameLevelSum(root.left, sumMap, distance - 1);
		
		if (sumMap.get(distance) != null) {
			int sum = sumMap.get(distance)  + root.data;
			
			sumMap.put(distance, sum);
		} else {
			sumMap.put(distance, root.data);
		}
		// System.out.println(root.data);
		printSameLevelSum(root.right, sumMap, distance + 1);
		
	}
	
	public static int printSumAll(Node root) {
		if (root == null) {
			return 0;
		}
//		printInorder(root.left);
////		System.out.println(root.data);
//		sum = sum + root.data;
//		printInorder(root.right);
		
		return root.data + printSumAll(root.left) + printSumAll(root.right);
		
	}
	
	public static int maxDepth(Node node) { 
        if (node == null) 
            return 0; 
        else 
        { 
            /* compute the depth of each subtree */
            int lDepth = maxDepth(node.left); 
            System.out.println("lDepth " + lDepth);
            int rDepth = maxDepth(node.right); 
            System.out.println("rDepth " + rDepth);
   
            /* use the larger one */
            if (lDepth > rDepth) 
                return (lDepth + 1); 
             else 
                return (rDepth + 1); 
        } 
    } 
	
	public static void printLevelOrder(Node root) {
		if (root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		int currLvlCount = 1;
		int nextLvlCount = 0;
		
		q.add(root);
		
		while(!q.isEmpty()) {
			Node tmpNode = q.poll();
			currLvlCount--;
			System.out.println(tmpNode.data);
			
			if (tmpNode.left != null) {
				q.add(tmpNode.left);
				nextLvlCount++;
			}
			
			if (tmpNode.right != null) {
				q.add(tmpNode.right);
				nextLvlCount++;
			}
			
			if (currLvlCount == 0) {
				currLvlCount = nextLvlCount;
				nextLvlCount = 0;
			}
		}		
		
	}
	
	public static void printLeftView(Node root) {
		if (root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		int currLvlCount = 1;
		int currLvlCountCopy = 1;
		int nextLvlCount = 0;
		
		q.add(root);
		
		while(!q.isEmpty()) {
			Node tmpNode = q.poll();
			
			// System.out.println(tmpNode.data);
			
			if (nextLvlCount == 0 && currLvlCount == currLvlCountCopy) {
				System.out.println(tmpNode.data);
			}
			currLvlCount--;
			
			if (tmpNode.left != null) {
				q.add(tmpNode.left);
				nextLvlCount++;
			}
			
			if (tmpNode.right != null) {
				q.add(tmpNode.right);
				nextLvlCount++;
			}
			
			if (currLvlCount == 0) {
				currLvlCount = nextLvlCount;
				currLvlCountCopy = nextLvlCount;
				nextLvlCount = 0;
			}
		}		
		
	}
	
	public static void printRightView(Node root) {
		if (root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		int currLvlCount = 1;
		int nextLvlCount = 0;
		
		q.add(root);
		
		while(!q.isEmpty()) {
			Node tmpNode = q.poll();
			currLvlCount--;
			
			
			if (tmpNode.left != null) {
				q.add(tmpNode.left);
				nextLvlCount++;
			}
			
			if (tmpNode.right != null) {
				q.add(tmpNode.right);
				nextLvlCount++;
			}
			
			if (currLvlCount == 0) {
				System.out.println(tmpNode.data);
				currLvlCount = nextLvlCount;
				nextLvlCount = 0;
			}
		}		
		
	}
	
	public static Map<Integer, Integer> printTopView(Node root) {
		if (root == null) {
			return new HashMap<>();
		}
		
		Queue<QNode> q = new LinkedList<>();
		Map<Integer, Integer> topViewMap = new HashMap<>();
		int currLvlCount = 1;
		int nextLvlCount = 0;
		
		QNode qNode = new QNode();
		qNode.node = root;
		qNode.distance = 0;
		
		q.add(qNode);
		
		while(!q.isEmpty()) {
			QNode tmpNode = q.poll();
			currLvlCount--;
			
			
			if (topViewMap.get(tmpNode.distance) == null) {
				topViewMap.put(tmpNode.distance, tmpNode.node.data);
			}
			
			if (tmpNode.node.left != null) {
				
				QNode leftNode = new QNode();
				leftNode.node = tmpNode.node.left;
				leftNode.distance = tmpNode.distance - 1;
				q.add(leftNode);
				nextLvlCount++;
			}
			
			if (tmpNode.node.right != null) {
				QNode rightNode = new QNode();
				rightNode.node = tmpNode.node.right;
				rightNode.distance = tmpNode.distance + 1;
				q.add(rightNode);
				nextLvlCount++;
			}
			
			if (currLvlCount == 0) {
				currLvlCount = nextLvlCount;
				nextLvlCount = 0;
			}
		}
		
		return topViewMap;
		
	}

}
