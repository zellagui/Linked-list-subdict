import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author Anis Zellagui
 * Comp 249, Assignement #4, return before 15/04/2022
 * This software have purpose to work with linked list.
 * @version 1.0
 */

public class CellList {

//  Attribute HEAD/LIST SIZE
    private CellNode head = null;
    public int size;
    LinkedList<CellNode> list;

//  Default constructor init list
    public CellList(){
        list = new LinkedList<CellNode>();
    }

// Copy constructor
    public CellList(CellList list){
        this.head = list.head;
        this.size = list.size;
    }


//  init the linked list
    public void addToStart(Cellphone cell){
//      Creating new node object
        CellNode newnode = new CellNode(cell);
//      Attribute it to head
        if(head == null){
            head = new CellNode(cell);
        }
        else {
            newnode.next = null;

            CellNode last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newnode;
        }
        size++;
    }

    public void insertAtIndex(CellList listt, Cellphone cell, int i){

        CellNode newNode = new CellNode(cell);

        //If list is empty
        if(listt.size == 0){
            System.out.println("List in empty buddy ");
        }

        //If value of Index less than one or bigger than size - 1 throw an error
        if(i < 1 || i > listt.size +1){
            System.out.println("The position " + i + " is an invalid index !");
            throw new NoSuchElementException();
        }
//      If index == 1, that mean the head is changing
        else if( i == 1 && head != null){
            newNode.next = head;
            head = newNode;
            size++;
        }
        else{
            CellNode temp = new CellNode(cell);
//            make a temp node and traverse to the node previous to the position
            temp = head;

            for(int j = 1; j < i-1; j++) {  //Loop until find
                if (temp != null) {
                    temp = temp.next;
                }
            }
//            If the previous node is not null, make newNode next as temp next and temp next as newNode.
                if(temp != null) {
                    newNode.next = temp.next;
                    temp.next = newNode;
                    size++;
                }
        }
    }

    public void deleteFromIndex(CellList listt, int i){
        if(listt.size == 0){
            System.out.println("List in empty buddy ");
        }
        else if(i < 1 || i > listt.size ){
            System.out.println("The position " + i + " is an invalid index !");
            throw new NoSuchElementException();
        }
        else if( head != null && i == 1){
            CellNode removed = head;
            head = head.next;
            removed = null;
            size--;
        }else{
            CellNode temp = new CellNode();
            temp = head;


//            loop through list until find the previous node
            for(int j = 1; j < i-1; j++){
                if(temp != null){
                    temp = temp.next;
                }
            }

            if(temp != null && temp.next != null){
                CellNode removed = temp.next;
                temp.next = temp.next.next;
                removed = null;
            }

        }
    }


    public void deleteFromStart(){
        CellNode removed = head; //Create new node and attribute it to head
        head = head.next; //head == next value
        removed = null; //Node which was head is removed by assigning it to null
        size--; //Down the size
    }


    public void replaceAtIndex(CellList list, Cellphone cell, int i){

        if(list.size == 0){
            System.out.println("List in empty buddy ");
        }
        else if(i < 1 || i > list.size ){
            System.out.println("The position " + i + " is an invalid index !");
            throw new NoSuchElementException();
        }
        else{
            CellNode temp = new CellNode();
            temp = head;

            //            loop through list until find the previous node
            for(int j = 1; j < i-1; j++){
                if(temp != null){
                    temp = temp.next;
                }
            }
            if(temp != null && temp.next != null){
                CellNode newNode = new CellNode(cell);
                temp = newNode;
//                NOT FINISHED +_+_+_+_+_+_+_+_+_+_+_+_+_+_+
            }
        }
    }

    public Object find(long SN){
        CellNode temp = head;

        if(temp == null ){
            System.out.println("your list is null buddy");
        }
        int count = 1;
        while(temp != null){

            if(SN == temp.cell.getSerialNum()){
                System.out.println("Phone was found in list after " + count + " interation");
                return temp;
            }
            else if(temp.next == null){
                System.out.println("After " + count + " iteration SN not found");
                return null;
            }
            temp = temp.next;
            count++;
        }
        return count;
    }

    public boolean contains(long SN){
        CellNode temp = new CellNode();
        temp = head;

        if(temp == null ){
            System.out.println("your list is null buddy");
        }

        while(temp.next != null){
            if(SN == temp.cell.getSerialNum()){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }


    public void display(){
        CellNode temp = head;

        if(temp == null ){
            System.out.println("your list is null buddy");
        }
        while(temp != null){
            System.out.print("["+temp.cell.getSerialNum()+": " + temp.cell.getBrand() + " " + temp.cell.getPrice() + " " + temp.cell.getYear() + "$ ] ---> " );
            temp = temp.next;

            if(temp == null){
                System.out.print(" X");
            }
        }

    }

    public boolean equals(CellList list) {
        if (this == list) return true;
        if (list == null || getClass() != list.getClass()) return false;
        return size == ((CellList) list).size && Objects.equals(head, ((CellList) list).head) && Objects.equals(list, ((CellList) list).list);
    }












/////////////// CELLNODE
    public class CellNode{
        private Cellphone cell;
        private CellNode next;


//      Constructor
//      Default
        public CellNode(){
            this.cell = null;
            this.next = null;
        }

//      parameterized
        public CellNode(Cellphone cell) {
            this.cell = cell;
            this.next =null;
        }

//      Copy
        public CellNode(CellNode node){
            this.cell = node.cell;
            this.next = node.next;
        }

        public CellNode(Cellphone cell, CellNode node) {
        this.cell = cell;
        this.next = node;
    }

    //      clone
        public Object clone() throws CloneNotSupportedException {
            Object clone = super.clone();
            return new CellNode(this.cell, this.next);
        }

//      Getter and setter
        public Cellphone getCell() {
            return cell;
        }

        public void setCell(Cellphone cell) {
            this.cell = cell;
        }

        public CellNode getNode() {
            return next;
        }

        public void setNode(CellNode node) {
            this.next = node;
        }


    }
}
