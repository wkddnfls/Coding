package linkedList_1;

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

public class LinkedList {
	private ListNode head; 

	public LinkedList() {
		head = null;
	}
	
	public void insertNode(int data) {
		ListNode newNode = new ListNode(data); 
		if (head == null) {
			this.head = newNode;
		} else {
			ListNode tempNode = head;

			while (tempNode.link != null) {
				tempNode = tempNode.link; 
			}
			tempNode.link = newNode;
		}
	}

	public void deleteNode(int index) {
		ListNode preNode = this.head;
		ListNode tempNode = this.head.link;
		
		if(index == 0) {
			head = preNode.link;
			preNode.link = null;
		}
		else {
			for (int i=0;i<index-1; i++) {
				preNode = tempNode;
				tempNode = tempNode.link;
			}
			preNode.link = tempNode.link;
		}
	}

	public int searchNode(int data) {
		ListNode tempNode = this.head;
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
		ListNode tempNode = this.head; 

		while (tempNode != null) {
			System.out.print(tempNode.getData() + " ");
			tempNode = tempNode.link; 
		}
		System.out.println();
		System.out.println("--------------------");
	}

	public static void main(String args[]) {
		LinkedList linkedList = new LinkedList(); 
		Scanner sc = new Scanner(System.in);
		int num, value, index;

		while (true) {
			System.out.println("0.����, 1.���, 2.����, 3.�˻�>> ");
			num = sc.nextInt();

			if (num == 1) {
				System.out.print("����� ���ڸ� �Է��Ͻÿ� >> ");
				value = sc.nextInt();
				linkedList.insertNode(value);
				linkedList.printList();
			}
			else if (num == 2) {   // ���� �ʿ�
				System.out.print("������ �ε����� �Է��Ͻÿ� >>");   // �ε��� �Է��ϸ� �� �����ϵ���
				index = sc.nextInt();
				linkedList.deleteNode(index);
				linkedList.printList();
			}
			else if (num == 3) { 
				System.out.print("�˻��� �����͸� �Է��Ͻÿ� >>");  
				value = sc.nextInt();
				System.out.println(value + "�� '" + linkedList.searchNode(value) + "'��° �ε����� �ֽ��ϴ�.");
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