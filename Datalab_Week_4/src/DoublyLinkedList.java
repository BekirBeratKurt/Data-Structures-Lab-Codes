public class DoublyLinkedList<T extends Comparable> {
    private DNode<T> head;

    public void addToFront(T val) {
        DNode<T> newNode = new DNode<>(val);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
    }

    

    public void addToEnd(T val) {
        DNode<T> newNode = new DNode<>(val);
        if (head == null) {
            head = newNode;
        } else {
            DNode<T> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
            newNode.prev = iterator;
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
        } else {
            DNode<T> iterator = head;
            while (iterator.value.compareTo(val) != 0)
                iterator = iterator.next;
            iterator.prev.next = iterator.next;
            if (iterator.next != null)
                iterator.next.prev = iterator.prev;

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

    public DNode<T> findMinNode() throws Exception {
        if (head == null)
            throw new Exception("Liste boş");
        else {
            DNode<T> iterator = head;
            DNode<T> minNode = head;
            while (iterator != null) {
                if (iterator.value.compareTo(minNode.value) == -1)
                    minNode = iterator;
                iterator = iterator.next;
            }
            return minNode;
        }
    }

    public DNode<T> findMinNode(DNode<T> start) throws Exception {
        if (head == null)
            throw new Exception("Liste boş");
        else {
            DNode<T> iterator = start;
            DNode<T> minNode = start;
            while (iterator != null) {
                if (iterator.value.compareTo(minNode.value) == -1)
                    minNode = iterator;
                iterator = iterator.next;
            }
            return minNode;
        }
    }

    public void selectionSort() throws Exception{
        if(head==null){
            throw new Exception("Liste Boş");
        }else{
            T tempMin;
            DNode<T> iterator=head;
            while(iterator!=null){
                DNode<T> minNode = findMinNode(iterator);
                tempMin = minNode.value;
                minNode.value=iterator.value;
                iterator.value= tempMin;
                iterator = iterator.next;
        }
        }
    }

    public void bubbleSort() throws Exception{
        if(head==null) {
            throw new Exception("Liste Boş");
        }else{
            T tempMin;
            DNode<T> iterator1=head;
            DNode<T> iterator2=head;
            while(iterator1 != null){
                while (iterator2.next!= null){
                    if(iterator2.value.compareTo(iterator2.next.value)==1){
                        tempMin = iterator2.value;
                        iterator2.value=iterator2.next.value;
                        iterator2.next.value=tempMin;
                    }
                    iterator2 = iterator2.next;
                }
                iterator1=iterator1.next;
                iterator2 = head;
            }

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






