public class LinkedListDeque<T> {
    private class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> previous;

        public Node() {
            data = null;
            next = null;
            previous = null;
        }

        public Node(T d, Node<T> n, Node<T> p) {
            data = d;
            next = n;
            previous = p;
        }

        public Node(T d) {
            data = d;
        }

        public Node(T d, Node<T> n) {
            data = d;
            previous = null;
            next = n;
        }

        public Node(Node<T> p, T d) {
            data = d;
            previous = p;
            next = null;
        }
    }

    private Node<T> headSentinel;
    private Node<T> endSentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        headSentinel = null;
        endSentinel = null;
    }

    public LinkedListDeque(T item) {
        headSentinel = new Node<>(item);
        endSentinel = headSentinel;
        size = 1;
    }

    public void addFirst(T item) {
        headSentinel = new Node<>(item, headSentinel);
        if (size > 0) {
            headSentinel.next.previous = headSentinel;
        } else {
            endSentinel = headSentinel;
        }
        size++;
    }

    public void addLast(T item) {
        endSentinel = new Node<>(endSentinel, item);
        if (size > 0) {
            endSentinel.previous.next = endSentinel;
        } else {
            headSentinel = endSentinel;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node<T> p = headSentinel;
        while (p != null) {
            System.out.println(p.data);
            System.out.println(" ");
            p = p.next;
        }
    }

    public T removeFirst() {
        if (headSentinel != null) {
            Node<T> p=headSentinel;
            if(size!=1)
            {
                headSentinel=headSentinel.next;
                headSentinel.previous=null;
            }
            else{
                headSentinel=null;
                endSentinel=null;
            }
            size--;
            T data=p.data;
            p.next=null;
            p=null;
            return data;
        } else {
            return null;
        }
    }

    public T removeLast() {
        if (endSentinel != null) {
            Node<T> p = endSentinel;
            if (size != 1) {
                endSentinel = endSentinel.previous;
                endSentinel.next= null;
            } else {
                endSentinel =null;
                headSentinel=null;
            }
            T data=p.data;
            p.previous=null;
            p=null;
            size--;
            return data;
        } else {
            return null;
        }
    }

    public T get(int index) {
        if (index <= 0 || index > size) {
            return null;
        } else {
            int i = 0;
            Node<T> p = headSentinel;
            while (i < index) {
                p = p.next;
                i++;
            }
            return p.data;
        }
    }

    public T getRecursion(int index) {
        if (index < 0 || index > size) {
            return null;
        }
        return getRecursionhelper(headSentinel, index);
    }

    public T getRecursionhelper(Node<T> p, int index) {
        if (index == 0) {
            return p.data;
        }
        return (T) getRecursionhelper(p.next, index - 1);
    }
}
