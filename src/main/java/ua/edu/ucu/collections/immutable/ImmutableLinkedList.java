package ua.edu.ucu.collections.immutable;


public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int n = 0;

    public ImmutableLinkedList(Object[] elements) {
        for (Object el : elements) {
            this.add(el);
        }
    }

    public ImmutableLinkedList() {
    }

    @Override
    public ImmutableList add(Object e) {
        ImmutableList immutableList = this.copy();

        Node newNode = new Node(e, n);

        if (head == null) {
            head = newNode;
        } else {
            if (tail == null) {
                head.setNext(newNode);
                tail = newNode;
                newNode.setPrevious(head);
                n++;
                return immutableList;
            }
            Node prev = head;

            while (prev.getNext() != null) {
                prev = prev.getNext();
            }
            prev.setNext(newNode);
            newNode.setPrevious(prev);
            tail = newNode;
        }

        n++;

        return immutableList;
    }

    private Object[] getNodes() {
        Object[] nodes = new Object[n];
        int i = 0;

        Node node = this.head;

        while (node != null) {
            nodes[i] = (node);
            node = node.getNext();
            i++;
        }

        return nodes;
    }

    private void reduceIdx(int bound) {
        Object[] nodes = this.getNodes();

        for (Object node : nodes) {
            if (((Node) node).getIdx() > bound) {
                ((Node) node).setIdx(((Node) node).getIdx() - 1);
            }
        }
    }

    private void increaseIdx(int bound) {
        Object[] nodes = this.getNodes();

        for (Object node : nodes) {
            if (((Node) node).getIdx() >= bound) {
                ((Node) node).setIdx(((Node) node).getIdx() + 1);
            }
        }
    }

    private ImmutableList copy() {
        ImmutableList immutableList;
        try {
            immutableList = (ImmutableList) this.clone();
        } catch (CloneNotSupportedException error) {
            immutableList = new ImmutableLinkedList();
        }

        return immutableList;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        ImmutableList immutableList = this.copy();

        Node newNode = new Node(e, index);

        if (0 <= index & index <= n) {
            n++;
            Node node = head;

            if (node == null) {
                head = newNode;
                return immutableList;
            }
            if (tail == null & index != 0) {
                head.setNext(newNode);
                newNode.setPrevious(head);
                tail = newNode;
                return immutableList;
            } else if (tail == null & index == 0) {
                tail = node;
                newNode.setNext(node);
                head = node;
            }

            if (node.getIdx() == index) {
                newNode.setNext(node);
                node.setPrevious(newNode);
                head = newNode;
            } else {
                while (node.getNext().getIdx() != index) {
                    node = node.getNext();
                }

                newNode.setPrevious(node);
                newNode.setNext(node.getNext());
                node.getNext().setPrevious(newNode);
                node.setNext(newNode);
            }

            this.increaseIdx(index);
        }

        return immutableList;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        ImmutableList immutableList = this.copy();

        for (Object el : c) {
            this.add(el);
        }

        return immutableList;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        int i = index;

        ImmutableList immutableList = this.copy();

        for (Object el : c) {
            Node newNode = new Node(el, index);
            this.add(i, newNode);
            i++;
        }

        return immutableList;
    }

    @Override
    public Object get(int index) {
        Node node = head;

        while (node != null) {
            if (node.getIdx() == index) {
                return node;
            }
            node = node.getNext();
        }

        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        ImmutableList immutableList = this.copy();

        Node node = head;
        Node prev = null;

        if (index == n-1) {
            this.reduceIdx(index);
            tail = tail.getPrevious();

            if (tail == null) {
                head = null;
                tail = null;
            } else {
                tail.setNext(null);
            }
            n--;
            return immutableList;
        }

        if (node != null & node.getIdx() == index) {
            this.reduceIdx(index);
            head = node.getNext();
            n--;
            return immutableList;
        }

        while (node != null) {
            if (node.getIdx() == index) {
                break;
            }
            prev = node;
            node = node.getNext();
        }

        if (node == null) {
            return  immutableList;
        }

        this.reduceIdx(index);
        prev.setNext(node.getNext());
        n--;

        return immutableList;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        ImmutableList immutableList = this.copy();

        Node newNode = new Node(e, index);
        Node prev = (Node) this.get(index);

        newNode.setPrevious(prev.getPrevious());
        newNode.setNext(prev.getNext());

        if (prev.getNext() == null) {
            tail = newNode;
        }
        if (prev.getPrevious() == null) {
            head = newNode;
        }
        if (prev.getNext() != null & prev.getPrevious() != null) {
            prev.getPrevious().setNext(newNode);
            prev.getNext().setPrevious(newNode);
        }

        if (index == 0)  {
            head = newNode;
        } else if (index == n-1) {
            tail = newNode;
        }

        return immutableList;
    }

    @Override
    public int indexOf(Object e) {
        Node node = head;

        while (node != null) {
            if (node.getValue() == e) {
                return node.getIdx();
            }
            node = node.getNext();
        }

        return -1;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public ImmutableList clear() {
        ImmutableList immutableList = this.copy();

        head = null;
        tail = null;
        n = 0;

        return immutableList;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Object[] toArray() {
        return getNodes();
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) this.add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) this.add(n, e);
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return head;
    }

    public Object getLast() {
        return tail;
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) this.remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) this.remove(n-1);
    }
}
