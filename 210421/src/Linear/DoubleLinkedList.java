package Linear;


public class DoubleLinkedList {
	
	private Node head; 
	private Node tail;
	private int size; 
	
	public DoubleLinkedList() {
		size = 0; 
	} 
	
	public void addFirst(Object data) { 
		Node newNode = new Node(data); 
		if (head != null) { 
			// 기존 노드가 있음
			newNode.nextNode = head; 
			head.prevNode = newNode; 
			} 
		head = newNode; 
		if (head.nextNode == null) { 
			tail = head; 
			} 
		size++; 
		} 
	
	public void addLast(Object data) {
		if (size == 0) { 
			addFirst(data); 
			} 
		else { 
			Node newNode = new Node(data); 
			tail.nextNode = newNode; 
			newNode.prevNode = tail; 
			tail = newNode; 
			size++; 
			} 
		} 
	
	public void add(int index, Object data) { 
		if (index == 0) { 
			addFirst(data); 
			} 
		else if (index == size - 1) { 
			addLast(data); 
		} else { 
			Node newNode = new Node(data); 
			Node prevNode = getNode(index - 1); 
			Node nextNode = prevNode.nextNode; 
			// 추가된 노드의 전후 설정
			newNode.prevNode = prevNode; 
			newNode.nextNode = nextNode; 
			// 이전 노드의 전후 설정 
			prevNode.nextNode = newNode; 
			// 다음 노드의 전후 설정
			nextNode.prevNode = newNode; 
			size++; 
			} 
		} 
	
	// 지우기 
	public Object removeFirst() { 
		if(size == 0) { 
			return null; 
			} 
		Node removeNode = head; 
		head = null; 
		head = removeNode.nextNode;
		head.prevNode = null; 
		size--; 
		return removeNode.data; 
		} 
	
	public Object removeLast() { 
		if(size == 0) { 
			return null; 
			} 
		Node removeNode = tail; 
		tail = null; 
		tail = removeNode.prevNode; 
		tail.nextNode = null; 
		size--; 
		return removeNode.data; 
		} 
	
	public Object remove(int index) { 
		if(size == 0) { 
			return null; 
			} 
		if(index == 0) {
			return removeFirst(); 
			}
		else if(index == size-1) { 
			return removeLast(); 
			}
		else { 
			Node removeNode = getNode(index);  //20
			Node prevNode = removeNode.prevNode; //10
			Node nextNode = removeNode.nextNode; //30
			
			// 이전 노드 전후 설정 
			prevNode.nextNode = nextNode; 
			
			// 다음 노드 전후 설정
			nextNode.prevNode = prevNode; 
			size--; 
			return removeNode.data; 
			} 
		} 
	
	private Node getNode(int index) { 
		if (index < size / 2) { 
			Node node = head; 
			for (int i = 0; i < index; i++) { 
				node = node.nextNode; 
				} 
			return node; 
			} 
		else { 
			Node node = tail; 
			for (int i = size - 1; i > index; i--) { 
				node = node.prevNode; 
				} 
			return node; 
			} 
		} 
	
	public String toString() { 
		StringBuffer result = new StringBuffer("["); 
		if (size != 0) {
			Node node = head; 
			result.append(node.data); 
			while (node.nextNode != null) {
				node = node.nextNode; 
				result.append(", "); 
				result.append(node.data); 
				} 
			} 
		result.append("]"); 
		return result.toString(); 
		} 
	
	private class Node { 
		// 단일 연결 리스트와의 차이점은
		// 이전 노드를 기록할 수 있는 변수를 가지고 있다. 
		private Node nextNode; 
		private Node prevNode; 		// * 
		private Object data; 
		Node(Object data) { 
			this.data = data; 
			this.nextNode = null; 
			this.prevNode = null; 
			} 
		} 


	public static void main(String[] args) { 
		DoubleLinkedList list = new DoubleLinkedList(); 
		list.addFirst(40); 
		list.addFirst(30); 
		list.addFirst(20); 
		list.addFirst(10); 
		System.out.println(list.toString()); // 10 20 30 40 
		list.add(2, 25); // 10 20 25 30 40 
		System.out.println(list.toString()); 
		list.addLast(50); 
		System.out.println(list.toString()); // 10 20 25 30 40 50 
		list.removeFirst(); 
		System.out.println(list.toString()); // 20 25 30 40 50 
		list.removeLast(); 
		System.out.println(list.toString()); // 20 25 30 40 
		list.remove(1); 
		System.out.println(list.toString()); // 20 30 40 
		} 
}
	

