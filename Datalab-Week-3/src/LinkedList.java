public class LinkedList <T extends Comparable> {
    private Node<T> head ;

    public String toString(){
        return head.toString();
    }
    public void display(){
        if (head == null){
            System.out.println("List is Empty");
        }else{
            Node<T> iterrator = head;
            while(iterrator != null){
                System.out.print(iterrator.toString() + " ");
                iterrator = iterrator.next;
            }
        }
    }
    public void addToFront(T val){
        Node<T> newNode = new Node<>(val);
        newNode.next = head;
        head = newNode;
    }

    public void addToEnd(T val){
        Node<T> newNode = new Node<>(val);
        if (head == null){
            head = newNode;
        }else {
            Node<T> iterriator = head;
            while (iterriator.next != null){
                iterriator = iterriator.next;
            }
            iterriator.next = newNode;
        }
    }

    public boolean booleanSearch(T val){
        if(head == null){
            return false;
        }else{
            Node<T> iterriator = head;
            boolean flag = false;
            do {
                if(iterriator.value.compareTo(val) == 0){
                    return true;
                }
                iterriator=iterriator.next;
            }while (iterriator != null);
            return flag ;
        }
    }

    public void addByeOrder(T val){
        Node<T> newNode=new Node<>(val);
        if (head==null){
            head=newNode;
        }else if(head.value.compareTo(val)==1){
            newNode.next=head;
            head=newNode;
        }else{
            Node<T> prev, iterator;
            prev=iterator=head;
            while(iterator!=null && iterator.value.compareTo(val)!=1 ){
                prev=iterator;
                iterator=iterator.next;
            }
            prev.next=newNode;
            newNode.next=iterator;
        }

    }
}
