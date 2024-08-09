package practice;

import java.util.Iterator;

public class QueueDesign<Item> implements Iterable<Item>{

    Node<Item> start = null;
    Node<Item> end = null;

    public void enQueue(Item item){
        //Add at last
        Node<Item> newNode = new Node<>(item);
        if(start == null){
            start = newNode;
            end = newNode;
        }else{
            end.next = newNode;
            end = newNode;
        }
    }

    public Item deQueue(){
        //check if queue has elements, return first
        if(start != null){
            Node<Item> temp = start;
            if(start.equals(end)){
                start = end = null;
            }else{
                start = start.next;
            }
            return temp.val;
        }else
            return null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    class QueueIterator implements Iterator<Item>{

        Node<Item> current;

        public QueueIterator(){
            current = start;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Node<Item> tmp = current;
            current = current.next;
            return tmp.val;
        }
    }

}

class Node<Item> {
    Item val;
    Node next;

    public Node(Item val){
        this.val = val;
        this.next = null;
    }
}

class QueueTest{
    public static void main(String[] args) {
        QueueDesign<String> myQ = new QueueDesign();

        myQ.enQueue("one");
        Iterator<String> iterator = myQ.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        myQ.enQueue("two");
        myQ.enQueue("three");
        System.out.println("\n");
        iterator = myQ.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        myQ.deQueue();
        iterator = myQ.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        myQ.deQueue();
        myQ.deQueue();
        iterator = myQ.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}


