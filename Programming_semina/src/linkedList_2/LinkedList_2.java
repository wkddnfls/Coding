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
		int n = data % size;  // 해시 함수
		
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
		
		System.out.print("해시 테이블 크기 입력 >> ");
		int size = sc.nextInt();
		LinkedList_2 LinkedList = new LinkedList_2(size);
		int num, value, index;

		while (true) {
			System.out.println("0.종료, 1.등록, 2.검색>> ");
			num = sc.nextInt();

			if (num == 1) {
				System.out.print("등록할 숫자를 입력하시오 >> ");
				value = sc.nextInt();
				LinkedList.insertNode(value);
				LinkedList.printList();
			}
//			else if (num == 2) {   // 수정 필요
//				System.out.print("삭제할 인덱스를 입력하시오 >>");   // 인덱스 입력하면 값 삭제하도록
//				index = sc.nextInt();
//				int a = sc.nextInt();
//				LinkedList.deleteNode(a, index);
//				LinkedList.printList();
//			}
			else if (num == 2) { 
				System.out.print("검색할 데이터를 입력하시오 >>");  
				value = sc.nextInt();
				int key = value % size;
				System.out.println(value + "는 " + key + "번째 테이블 " +  LinkedList.searchNode(value) + "번째 인덱스에 있습니다.");
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