
/**
 * FelixList - NRW Compliant
 * 
 * @author Felix Naumann
 * @version 2017-03-16
 */
public class List
{
    private Node start;
    private Node current;
    private Node last = null;

    public List() {
        this.start = null;
        this.current = null;
    }

    public boolean isEmpty() {
        if (start == null) return true; else return false;
    }

    public boolean hasAccess() {
        if (current == null) return false; else return true;
    }

    public void append(Object pInhalt) {
        if (pInhalt != null) {
            if (isEmpty()) {
                insert(pInhalt);
            } else {
                if (last != null) {
                    last.setNextNode(new Node(pInhalt));
                    last = last.getNextNode();
                }
            }
        }
    }

    public void toFirst() {
        current = start;
    }

    public void toLast() {
        current = last;
    }

    public void next() {
        current = current.getNextNode();
    }

    public void insert(Object pInhalt) {
        if (pInhalt != null) {
            if (isEmpty()) {
                this.start = new Node(pInhalt); 
                last = start;
            } else if(hasAccess()) {
                if (current == start) {
                    Node neu = new Node(pInhalt);
                    start = neu;
                    start.setNextNode(current);
                } else {
                    if (current == last) {
                        Node vorlast = new Node(pInhalt);
                        vorlast.setNextNode(last);
                    } else {
                        Node query = start;
                        while (query.getNextNode() != current) {
                            query = query.getNextNode();
                        }
                        Node vorCurrent = new Node(pInhalt);
                        vorCurrent.setNextNode(current);
                    }
                }
            }
        }
    }

    public void remove() {
        if (!isEmpty() && hasAccess()) {
            if (current == start) {
                start = start.getNextNode();      
                current = current.getNextNode();
            } else if (current == last) {
                Node cache = current;
                toFirst();
                while (current.getNextNode() != cache) {
                    next();
                }
                last = current;
                current.setNextNode(null);
                current = null;
            } else {
                Node cache = current;
                toFirst();
                while (current.getNextNode() != cache) {
                    next();
                }
                current.setNextNode(cache.getNextNode());
                current = cache.getNextNode();
            }
        }
    }
}
