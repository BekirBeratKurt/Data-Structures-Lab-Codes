public class DoublyLinkedListWithTail <T extends Comparable>{
    private DNode<T> head, tail;

    public void addToFront(T val) {
        DNode<T> newNode = new DNode<>(val);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        else
            tail=newNode;
        head = newNode;
    }

    public void addToEnd(T val) {
        DNode<T> newNode = new DNode<>(val);
        if (head == null) {
            head = newNode;
            tail=newNode;
        } else {

            tail.next = newNode;
            newNode.prev = tail;
            tail=newNode;
        }
    }


    public boolean search(T val) {
        DNode<T> iterator = head;
        while (iterator != null) {
            if (iterator.value.compareTo(val) == 0) {
                return true;
            }
            iterator = iterator.next;
        }
        return false;
    }

    public void delete(T val) {
        if (!search(val))
            return;
        if (head.value.compareTo(val) == 0) {
            head = head.next;
            //head.prev.next=null; olmasa da olur
            if (head != null)
                head.prev = null;
            else
                tail=null;
        } else {
            DNode<T> iterator = head;
            while (iterator.value.compareTo(val) != 0)
                iterator = iterator.next;
            iterator.prev.next = iterator.next;
            if (iterator.next != null)
                iterator.next.prev = iterator.prev;
            else{
                tail=tail.prev;
            }

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
            DNode<T> iterator=head;
            while(iterator!=null){
                if(iterator.value.compareTo(min)==-1)
                    min=iterator.value;
                iterator=iterator.next;
            }
            return min;
        }
    }

    public void deleteAll(T val) {
        while (search(val)) {
            if (head.value.compareTo(val) == 0) {
                head = head.next;
                //head.prev.next=null; olmasa da olur
                if (head != null)
                    head.prev = null;
            } else {
                DNode<T> iterator = head;
                while (iterator.value.compareTo(val) != 0)
                    iterator = iterator.next;
                iterator.prev.next = iterator.next;
                if (iterator.next != null)
                    iterator.next.prev = iterator.prev;

            }
        }
    }


    public void display() {
        if (head != null) {
            DNode<T> iterator = head;
            while (iterator.next != null) {
                System.out.print(iterator + "-->");
                iterator = iterator.next;
            }
            System.out.println(iterator);
        }
    }
}
