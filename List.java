
/**
 * FelixList
 * 
 * @author Felix Naumann
 * @version 2017-02-16
 */
public class List
{
    private Node start;
    private int nodes;

    public List() {
        this.start = null;
        this.nodes = 0;
    }

    public void add(Object addition) {
        if (nodes == 0) {
            start = new Node(addition);
        } else if (nodes == 1) {
            Node neu = new Node(addition);
            start.setNextNode(neu);
        } else {
            Node neu;
            Node next = start;
            for (int i = 0; i < nodes - 1; i++) {
                next = next.getNextNode();
            }
            neu = new Node(addition);
            next.setNextNode(neu);
        }
        nodes++;
    }

    private void setStartNode(Node pStart) {
        this.start = pStart;
    }

    private Node getNode(int position) {
        if (position <= 0) return null;
        if (position > nodes) return null;
        if (position == 1) return start;
        Node query = start;
        for (int i = 0; i < position - 1;i++) {
            query = query.getNextNode();
        }
        return query;
    }

    public void replace(int position, Object content) {
        if (position <= 0 || nodes <= 0) return;
        if (position > nodes) return;
        Node replace = start;
        for (int i = 0; i < position - 1;i++) {
            replace = replace.getNextNode();
        }
        replace.setContent(content);
    }

    private Node getStartNode() {
        return this.start;
    }

    public Object get(int position) {
        Node query = this.getNode(position);
        if (query == null) return null;
        return this.getNode(position).getContent();
    }

    public int size() {
        return this.nodes;
    }

    public boolean contains(Object check) {
        boolean found = false;
        for (int i = 1; i <= nodes; i++) {
            if (get(i).equals(check)) found = true;
        }
        return found;
    }
    
    public int getPosition(Object check) {
        int pos = -1;
        for (int i = 1; i <= nodes; i++) {
            if (get(i).equals(check)) pos = i;
        }
        return pos;
    }

    public void remove(int position) {
        if (nodes <= 0 || position <= 0 || position > nodes) return;
        if (position == 1) {
            start = start.getNextNode();
        } else {
            Node before = this.getNode(position - 1);
            Node after = this.getNode(position + 1);
            if (after == null) {
                before.setNextNode(null);
            } else {
                before.setNextNode(after);
            }
        }
        nodes--;
    }
}
