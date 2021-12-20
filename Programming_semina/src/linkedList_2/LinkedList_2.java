package linkedList_2;

import java.io.*;
import java.util.*;

class ListNode {
	int data; 
	public ListNode link; 
	public int size = 0;

	public ListNode() {
		this.data = 0;
		this.link = null;
	}

	public ListNode(int data) {
		this.data = data;
		this.link = null;
	}
	public int getData() {
		return this.data;
	}
	public int size() {
		return size;
	}
}

public class LinkedList_2 {
	private ListNode[] node;
	int size;
	public LinkedList_2(int size) {
		node = new ListNode[size];
		for (int i=0;i<size;i++)
			node[i] = null;
		this.size = size;
	}
	
	public void insertNode(int data) {
		ListNode newNode = new ListNode(data); 
		int n = data % size;  // �ؽ� �Լ�
		
		if (node[n] == null) {
			this.node[n] = newNode;
		} else {
			ListNode tempNode = node[n];

			while (tempNode.link != null) {
				tempNode = tempNode.link; 
			}
			tempNode.link = newNode;
		}
	}

//	public void deleteNode(int a, int index) {
//		ListNode preNode = this.node[a];
//		ListNode tempNode = this.node[a].link;
//		
//		if(index == 0) {
//			node[a] = preNode.link;
//			preNode.link = null;
//		}
//		else {
//			for (int i=0;i<index-1; i++) {
//				preNode = tempNode;
//				tempNode = tempNode.link;
//			}
//			preNode.link = tempNode.link;
//		}
//	}

	public int searchNode(int data) {
		int n = data % size;
		ListNode tempNode = this.node[n];
		int size = 0;
		
		while (tempNode != null) {
			if (data == tempNode.getData()) {
				return size;
			} else {
				tempNode = tempNode.link;
				size++;
			}
		}
		return size;
	}

	public void printList() {
		for (int i=0; i<size; i++) {
			ListNode tempNode = this.node[i]; 
			while (tempNode != null) {
				System.out.print(tempNode.getData() + " ");
				tempNode = tempNode.link; 
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("�ؽ� ���̺� ũ�� �Է� >> ");
		int size = sc.nextInt();
		LinkedList_2 LinkedList = new LinkedList_2(size);
		int num, value, index;

		while (true) {
			System.out.println("0.����, 1.���, 2.�˻�>> ");
			num = sc.nextInt();

			if (num == 1) {
				System.out.print("����� ���ڸ� �Է��Ͻÿ� >> ");
				value = sc.nextInt();
				LinkedList.insertNode(value);
				LinkedList.printList();
			}
//			else if (num == 2) {   // ���� �ʿ�
//				System.out.print("������ �ε����� �Է��Ͻÿ� >>");   // �ε��� �Է��ϸ� �� �����ϵ���
//				index = sc.nextInt();
//				int a = sc.nextInt();
//				LinkedList.deleteNode(a, index);
//				LinkedList.printList();
//			}
			else if (num == 2) { 
				System.out.print("�˻��� �����͸� �Է��Ͻÿ� >>");  
				value = sc.nextInt();
				int key = value % size;
				System.out.println(value + "�� " + key + "��° ���̺� " +  LinkedList.searchNode(value) + "��° �ε����� �ֽ��ϴ�.");
				//linkedList.printList();
			}
			else if (num == 0) {
				System.out.println("�����մϴ�...");
				break;
			}
			else 
				System.out.println("�߸��� �Է��Դϴ�!");
		}
	}

}