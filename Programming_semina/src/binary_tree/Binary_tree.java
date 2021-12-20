package binary_tree;

import java.io.*;
import java.util.*;

class Node {
	public int data;
	public Node left, right;

	public Node() {
		this.data = 0;
		this.left = null;
		this.right = null;
	}

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public void setData(int data) {
		this.data = data;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public void setRight(Node right) {
		this.right = right;
	}
}

public class Binary_tree {
	private Node root;

	public Binary_tree() {
		this.root = null;
	}

	public Node getRoot() {
		return this.root;
	}

	/* 삽입 함수(반복문) */
//	public void insertNode(int data) {
//		Node newNode = new Node(data);
//
//		if (root == null) {
//			root = newNode;
//		} else {
//			Node tempNode = root;
//			Node parent;
//
//			while (true) {
//				parent = tempNode;
//
//				if (data < parent.data) {
//					tempNode = parent.left;
//
//					if (tempNode == null) {
//						parent.left = newNode;
//						return;
//					}
//				} else {
//					tempNode = parent.right;
//
//					if (tempNode == null) {
//						parent.right = newNode;
//						return;
//					}
//				}
//			}
//		}
//	}
	
	/* 삽입 함수(재귀) */
	public void insertNode(int data) {
		Node newNode = new Node(data);

		if (root == null) {
			root = newNode;
		} else {
			insertNode(root, data);
		}
	}

	public void insertNode(Node rootNode, int data) {
		Node tempNode;
		if (data <= rootNode.data) {
			if (rootNode.left == null) {
				tempNode = new Node();
				tempNode.setData(data);
				rootNode.setLeft(tempNode);
			}
			else 
				insertNode(rootNode.left, data);
		}
		else {
			if (rootNode.right == null) {
				tempNode = new Node();
				tempNode.setData(data);
				rootNode.setRight(tempNode);
			}
			else
				insertNode(rootNode.right, data);
		}
	}

	/* 검색 함수 */
	public boolean searchNode(int data) {
		Node tempNode = this.root;

		if (root == null)
			return false;
		while (tempNode.data != data) {
			if (data < tempNode.data)
				tempNode = tempNode.left;
			else
				tempNode = tempNode.right;
			if (tempNode == null)
				return false;
		}
		return true;
	}

	/* 삭제 함수 */
	public boolean deleteNode(int data) {
		Node tempNode = this.root;
		Node parent = this.root;

		boolean isLeft = true;

		while (tempNode.data != data) {
			parent = tempNode;

			if (data < tempNode.data) {
				isLeft = true;
				tempNode = parent.left;
			} else {
				isLeft = false;
				tempNode = parent.right;
			}

			if (tempNode == null)
				return false;
		}

		Node replace;
		/* 양쪽 자식노드가 없는 경우(단말노드인 경우) */
		if (tempNode.left == null && tempNode.right == null) {
			if (tempNode == root)
				this.root = null;
			else if (isLeft)
				parent.left = null;
			else
				parent.right = null;
		}

		/* 왼쪽 자식 노드만 있는 경우 */
		else if (tempNode.right == null) {
			replace = tempNode.left;

			if (tempNode == root)
				root = replace;

			else if (isLeft)
				parent.left = replace;
			else
				parent.right = replace;
		}
		/* 오른쪽 자식 노드만 있는 경우 */
		else if (tempNode.left == null) {
			replace = tempNode.right;
			if (tempNode == root)
				root = replace;
			else if (isLeft)
				parent.left = replace;
			else
				parent.right = replace;
		}

		/* 양쪽 모두 있는 경우 */
		else {
			Node rightsubTree = tempNode.right;
			replace = getRightMin(rightsubTree);

			if (tempNode == root)
				root = replace;
			else if (isLeft)
				parent.left = replace;
			else
				parent.right = replace;

			replace.right = rightsubTree;
			if (replace == rightsubTree)
				replace.right = null;

			replace.left = tempNode.left;

		}
		return true;

	}

	private Node getRightMin(Node rightsubRoot) {
		Node parent = rightsubRoot;
		Node tempNode = rightsubRoot;

		while (tempNode.left != null) {
			parent = tempNode;
			tempNode = tempNode.left;
		}

		parent.left = null;
		return tempNode;
	}

	/* 중위순회 출력 */
	public void inOrder(Node tempNode) {
		if (tempNode != null) {
			inOrder(tempNode.left);
			System.out.print(tempNode.data + " ");
			inOrder(tempNode.right);
		}
	}

	public void pop(Node tempNode) {
		if (tempNode != null) {

		}
	}

	public static void main(String args[]) {
		Binary_tree bt = new Binary_tree();
		Scanner sc = new Scanner(System.in);
		int num, value;

		while (true) {
			System.out.println("0.종료, 1.등록, 2.삭제, 3.검색>> ");
			num = sc.nextInt();

			if (num == 1) {
				System.out.print("등록할 숫자를 입력하시오 >> ");
				value = sc.nextInt();
				bt.insertNode(value);
				bt.inOrder(bt.getRoot());
				System.out.println();
			} else if (num == 2) {
				System.out.print("삭제할 데이터를 입력하시오 >>");
				value = sc.nextInt();
				bt.deleteNode(value);
				bt.inOrder(bt.getRoot());
				System.out.println();
			} else if (num == 3) {
				System.out.print("검색할 데이터를 입력하시오 >>");
				value = sc.nextInt();
				bt.searchNode(value);
				if (bt.searchNode(value) == true)
					System.out.println("성공적으로 검색했습니다!");
				else if (bt.searchNode(value) == false)
					System.out.println("데이터가 존재하지 않습니다.");

			} else if (num == 4) {
				bt.pop(bt.getRoot());
				System.out.println();
			} else if (num == 0) {
				System.out.println("종료합니다...");
				break;
			} else
				System.out.println("잘못된 입력입니다!");
		}
	}
}