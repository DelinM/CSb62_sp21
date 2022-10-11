package deque;

class MyLinkedList {

    /** implementation of a single linked list*/

    public int size;
    public IntNode sentinel;

    class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

    }

    public MyLinkedList() {
        size = 0;
        sentinel = new IntNode(-1, null);

    }

    public int get(int index) {

        /** if index is not vaild*/
        if (index < 0 || index >= size) {
            return -1;
        }

        IntNode temp = sentinel.next;

        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.item;

    }

    public void addAtHead(int val) {
        addAtIndex(0, val);

    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {

        if (index < 0 || index > size) {
            return;
        }

        size++;

        IntNode temp = sentinel;

        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }

        IntNode newNode = new IntNode(val, temp.next);
        temp.next = newNode;

    }

    public void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            return;
        }

        size--;

        IntNode temp = sentinel;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList something = new MyLinkedList();
        something.addAtHead(4);
        something.get(1);
        something.addAtHead(1);
        something.addAtHead(5);
        something.deleteAtIndex(3);
        something.addAtHead(7);
        something.get(3);
        something.get(3);
        something.get(3);
        something.addAtHead(1);
        something.deleteAtIndex(4);
    }
}

