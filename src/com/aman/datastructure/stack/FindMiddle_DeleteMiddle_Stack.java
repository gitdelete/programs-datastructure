package com.aman.datastructure.stack;
/*
*
*       How to implement a stack which will support the following operations in O(1) time complexity?
        1) push() which adds an element to the top of stack.
        2) pop() which removes an element from top of stack.
        3) findMiddle() which will return middle element of the stack.
        4) deleteMiddle() which will delete the middle element.
        Push and pop are standard stack operations.
* */

public class FindMiddle_DeleteMiddle_Stack {

    DLLNode head;
    DLLNode mid;
    DLLNode prev;
    DLLNode next;
    int size;
    /* Function to push an element to the stack */
    void push(int new_data)
    {

        /* allocate DLLNode and put in data */
        DLLNode new_node = new DLLNode(new_data);
        // if stack is empty
        if (size == 0) {
            head = new_node;
            mid = new_node;
            size++;
            return;
        }
        head.next = new_node;
        new_node.prev = head;

        head = head.next;
        if (size % 2 != 0) {
            mid = mid.next;
        }
        size++;
    }

    /* Function to pop an element from stack */
    int pop()
    {
        int data = -1;
        /* Stack underflow */
        if (size == 0) {
            System.out.println("Stack is empty");
            // return -1;
        }

        if (size != 0) {
            data = head.data;
            if (size == 1) {
                head = null;
                mid = null;
            }
            else {
                head = head.prev;
                head.next = null;
                if (size % 2 == 0) {
                    mid = mid.prev;
                }
            }
            size--;
        }
        return data;
    }

    // Function for finding middle of the stack
    int findMiddle()
    {
        if (size == 0) {
            System.out.println("Stack is empty now");
            return -1;
        }
        return mid.data;
    }
    void deleteMiddleElement()
    {
        // This function will not only delete the middle
        // element
        // but also update the mid in case of even and
        // odd number of Elements
        // when the size is even then findmiddle() will show the
        // second middle element as mentioned in the problem
        // statement
        if (size != 0) {
            if (size == 1) {
                head = null;
                mid = null;
            }
            else if (size == 2) {
                head = head.prev;
                mid = mid.prev;
                head.next = null;
            }
            else {
                mid.next.prev = mid.prev;
                mid.prev.next = mid.next;
                if (size % 2 == 0) {
                    mid = mid.prev;
                }
                else {
                    mid = mid.next;
                }
            }
            size--;
        }
    }

    // Driver program to test functions of myStack
    public static void main(String args[])
    {
        FindMiddle_DeleteMiddle_Stack ms = new FindMiddle_DeleteMiddle_Stack();
        ms.push(11);
        ms.push(22);
        ms.push(33);
        ms.push(44);
        ms.push(55);
        ms.push(66);
        ms.push(77);
        ms.push(88);
        ms.push(99);
        System.out.println("Middle Element : "
                + ms.findMiddle());

        System.out.println("Popped : " + ms.pop());
        System.out.println("Popped : " + ms.pop());
        System.out.println("Middle Element : "
                + ms.findMiddle());
        ms.deleteMiddleElement();
        System.out.println("New Middle Element : "
                + ms.findMiddle());
    }

    class DLLNode {
        DLLNode prev;
        int data;
        DLLNode next;
        DLLNode(int data) { this.data = data; }
    }
}


/*
*       USING STACK and DEQUE
*
    class MyStack {
    Stack<Integer> s;
    Deque<Integer> dq;

    MyStack()
    {
        s = new Stack<Integer>();
        dq = new ArrayDeque<Integer>();
    }
    void add(int data)
    {
        dq.addLast(data);
        if (dq.size() > s.size() + 1) {
            int temp = dq.pollFirst();
            s.push(temp);
        }
    }
    void pop()
    {
        int data = dq.pollLast();
        if (s.size() > dq.size()) {
            int temp = s.pop();
            dq.offerFirst(temp);
        }
    }
    int getMiddleElement() { return dq.getFirst(); }
    void deleteMiddleElement()
    {
        dq.pollFirst();
        if (s.size() > dq.size()) {
            int temp = s.pop();
            dq.offerFirst(temp);
        }
    }
}
*
* */
