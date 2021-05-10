package Linear;


public class CircularLinkedList {
	
	private ListNode CL;
 
    public CircularLinkedList() {
        this.CL = null;
    }    
    
    
    //마지막 노드에 삽입
    void insertLastNode(String str){
        ListNode node = new ListNode(str);
        if(CL == null){
            CL = node;
            node.next = node;
        }else{
            ListNode current = CL;
            while(current.next!=CL){
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
    }
 
    //첫번째 노드에 삽입
    void insertFirstNode(String str){
        ListNode node = new ListNode(str);
        if(CL == null){
            CL = node;
        }else{
            ListNode current = CL;
            while(current.next!=CL){
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
            CL = node;
        }
    }
 
    //중간 노드에 삽입
    void insertMiddleNode(ListNode pre, String str){
        ListNode node = new ListNode(str);
        if(CL == null){
            CL = node;
        }else{
            ListNode current = CL;
            while(current.next!=pre){
                current = current.next;
            }
            current = current.next;
            node.next = current.next;
            current.next = node;
        }
    }
 
    //마지막 노드 삭제
    void deleteLastNode(){
        if(CL==null){
            System.out.println("지울 노드가 존재하지 않습니다.");
        }else{
            ListNode prev = CL;
            ListNode current = CL.next;
            while(current.next!=CL){
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
    }
 
    //첫번째 노드 삭제
    void deleteFirstNode(){
        if(CL==null){
            System.out.println("지울 노드가 존재하지 않습니다.");
        }else{
            ListNode current = CL;
            while(current.next!=CL){
                current = current.next;
            }
            ListNode old = current.next;
            CL = old.next;
            current.next = CL;
        }
    }
 
    //중간 노드 삭제
    void deleteMiddleNode(String str){
        ListNode node = new ListNode(str);
        if(CL==null){
            System.out.println("지울 노드가 존재하지 않습니다.");
        }else{
            ListNode prev = CL;
            ListNode current = CL.next;
            while(current.data!=node.data){
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
    }
 
    ListNode searchNode(String str){
        ListNode node = new ListNode(str);
        if(CL==null){
            System.out.println("노드가 비어있습니다.");
            return null;
        }else{
            ListNode current = CL;
            while(current.data!=node.data){
                current = current.next;
            }
            return current;
        }
    }
 
    void printList(){
        if(CL==null){
            System.out.println("출력할 리스트가 존재하지 않습니다.");
        }else{
            ListNode current = CL;
            System.out.print("[");
            while(current.next!=CL){
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.print(current.data);
            System.out.print("]");
            System.out.println();
        }
    }
    
    public class ListNode {
		   String data;
		   ListNode next;
		   
		   public ListNode(){
		      this.data = null;
		      this.next = null;
		   }
		   
		   public ListNode(String data){
		      this.data = data;
		      this.next = null;
		   }
		   
		   public ListNode(String data, ListNode next){
		      this.data = data;
		      this.next = next;
		      this.next = null;
		   }
		   
		   public String getData(){
		      return this.data;
		   }
		}     
	   
    
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
        list.insertLastNode("월");
        list.insertLastNode("수");
        list.insertLastNode("일");
        list.printList();
        
        System.out.println("(2) \"수\"노드 뒤에 \"금\" 노드 삽입하기");
        ListNode pre = list.searchNode("수");
        
        if(pre==null){
           System.out.println("검색 실패 >> 찾는 데이터가 없습니다.");
        }else{
           list.insertMiddleNode(pre, "금");
        }
        list.printList();
        
        System.out.println("(3) 리스트의 첫번째에 노드 추가하기");
        list.insertFirstNode("토");
        list.printList();
        
        System.out.println("(4) 리스트의 마지막 노드 삭제하기");
        list.deleteLastNode();
        list.printList();
        
        System.out.println("(5) 리스트의 중간 노드 \"수\" 삭제하기");
        list.deleteMiddleNode("수");
        list.printList();
        
        System.out.println("(6) 리스트의 첫번째 노드 삭제하기");
        list.deleteFirstNode();
        list.printList();
     }    
}