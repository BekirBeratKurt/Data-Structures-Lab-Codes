import java.util.Iterator;

public class LinkedList <T extends Comparable> {
    private Node<T> head;
    //bu field ı bellek erişimi sayısını tutmak için oluşturdum
    private int memoryAccessCounter;

    public LinkedList(){
        this.head=null;
    }

    public void addToFront(T val){
        Node<T> newNode=new Node<>(val);
        newNode.next=head;
        head=newNode;
    }
    //Bu methodlar bu ödev projesi için özel yazılmıştır ve genellikle zaten var olan methodların bellek erişimi
    //sayısını tutabilmek için yazılmıştır
    //***********************************************************


    public int getMemoryAccessCounter() {
        int temp=memoryAccessCounter;
        memoryAccessCounter=0;
        return temp;
    }

    public void addIfNotInTheList(T val){
        //bu method adındanda anlaşılacağı üzere değer listede yoksa ekler
        if(!(search(val))){
            addToEnd(val);
        }
    }
    public void specialDelete(T val){
        if(!searchWithCounter(val)){
            return;
        }else if(head.value.compareTo(val)==0){
            head=head.next;
            memoryAccessCounter++;
        }else{
            Node<T> prev, iterator;
            prev=iterator=head;
            while(iterator.value.compareTo(val)!=0){
                memoryAccessCounter+=2;
                prev=iterator;
                iterator=iterator.next;
            }
            prev.next=iterator.next;
            memoryAccessCounter++;
        }
    }

    public boolean specialSearchWCounter(T val){
        if(searchWithCounter(val)){
            specialDelete(val);
            addToFront(val);
            memoryAccessCounter++;
            return true;
        }
        return false;
    }

    public boolean searchWithCounter(T val){
        Node<T> iterator=head;
        while(iterator!=null){
            memoryAccessCounter++;
            if(iterator.value.compareTo(val)==0){
                return true;
            }
            iterator=iterator.next;
        }
        return false;
    }
    //************************************************************

    public void addToEnd(T val){
        Node<T> newNode=new Node<>(val);
        if(head==null)
            head=newNode;
        else {
            Node<T> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
        }
    }

    public boolean search(T val){
        Node<T> iterator=head;
        while(iterator!=null){
            if(iterator.value.compareTo(val)==0){
                return true;
            }
            iterator=iterator.next;
        }
        return false;
    }



    public void display(){
        if(head!=null) {
            Node<T> iterator = head;
            while (iterator.next != null) {
                System.out.print(iterator + "-->");
                iterator = iterator.next;
            }
            System.out.println(iterator);
        }
    }

    public void sortedInsert(T val){
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

    public void delete(T val){
        if(!search(val)){
            return;
        }else if(head.value.compareTo(val)==0){
            head=head.next;
        }else{
            Node<T> prev, iterator;
            prev=iterator=head;
            while(iterator.value.compareTo(val)!=0){
                prev=iterator;
                iterator=iterator.next;
            }
            prev.next=iterator.next;
        }
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


}
