public class CircularLinkedList <T extends Comparable>{
    private Node<T> head;

    public CircularLinkedList(){
        head=null;
    }
    public void addToFront(T val){

        Node<T> newNode=new Node<>(val);
        if(head==null) {
            head = newNode;
            head.next = head;
        }else{
            Node<T> iterator=head;
            while(iterator.next!=head){
                iterator=iterator.next;
            }
            iterator.next=newNode;
            newNode.next=head;
            head=newNode;
        }
    }
    public void addToEnd(T val){
        Node<T> newNode=new Node<>(val);
        if(head==null)
            addToFront(val);
        else{
            Node<T> iterator=head;
            while(iterator.next!=head){
                iterator=iterator.next;
            }
            iterator.next=newNode;
            newNode.next=head;
        }
    }
    public boolean search(T val){
        if(head==null)
            return false;
        Node<T> iterator=head;
        while(iterator.next!=head){
            if(iterator.value.compareTo(val)==0){
                return true;
            }
            iterator=iterator.next;
        }
        if(iterator.value.compareTo(val)==0){
            return true;
        }
        return false;
    }
    public void delete(T val){
        if(!search(val))
            return;
        if(head.value.compareTo(val)==0){
            Node<T> iterator=head;
            if(iterator.next==head){
                head=null;
                return;
            }
            while(iterator.next!=head){
                iterator=iterator.next;
            }
            head=head.next;
            iterator.next=head;
            return;
        }
        Node<T> iterator, prev;
        iterator=prev=head;
        while(iterator.value.compareTo(val)!=0){
            prev=iterator;
            iterator=iterator.next;
        }
        prev.next=iterator.next;

    }
    public boolean isEmpty(){
        return this.head==null;
    }
    public T findMin() throws Exception {
        if(head==null)
            throw  new Exception("Liste boş");
        else{
            T min=head.value;
            Node<T> iterator=head;
            while(iterator!=null){
                if(iterator.value.compareTo(min)==-1)
                    min=iterator.value;
                iterator=iterator.next;
            }
            return min;
        }
    }
    public void display(){
        if(head==null)
            return;
        Node<T> iterator=head;
        while(iterator.next!=head){
            System.out.print(iterator +"-->");
            iterator=iterator.next;
        }
        System.out.println(iterator);
    }




}
