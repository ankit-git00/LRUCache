package lruCache;

public class DoubleLinkedList<K,V> {


    private final Node<K,V> head;
    private final Node<K,V> tail;

    public DoubleLinkedList(){
        this.head = new Node<>(null,null);
        this.tail = new Node<>(null,null);
        head.right = tail;
        tail.left = head;
    }

    public   void addToFront(Node<K,V> node){

        node.right = head.right;
        head.right.left = node;
        node.left = head;
        head.right = node;

    }


   public void remove(Node<K,V> node){
        node.left.right = node.right;
        node.right.left = node.left;
   }

   public void moveToFront(Node<K,V> node){
        remove(node);
        addToFront(node);
   }

   public void removeLast(){
       if(head.right == tail){
           return;
       }

       remove(tail.left);

   }



}
