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
			System.out.println("0.종료, 1.등록, 2.삭제, 3.검색>> ");
			num = sc.nextInt();

			if (num == 1) {
				System.out.print("등록할 숫자를 입력하시오 >> ");
				value = sc.nextInt();
				linkedList.insertNode(value);
				linkedList.printList();
			}
			else if (num == 2) {   // 수정 필요
				System.out.print("삭제할 인덱스를 입력하시오 >>");   // 인덱스 입력하면 값 삭제하도록
				index = sc.nextInt();
				linkedList.deleteNode(index);
				linkedList.printList();
			}
			else if (num == 3) { 
				System.out.print("검색할 데이터를 입력하시오 >>");  
				value = sc.nextInt();
				System.out.println(value + "는 '" + linkedList.searchNode(value) + "'번째 인덱스에 있습니다.");
				//linkedList.printList();
			}
			else if (num == 0) {
				System.out.println("종료합니다...");
				break;
			}
			else 
				System.out.println("잘못된 입력입니다!");
		}
	}

}