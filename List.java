
/**
 * FelixList
 * 
 * @author Felix Naumann
 * @version 2017-02-16
 */
public class List
{
    private Node start;
    private int size;
    private int nodes;

    public List(Object initial) {
        Node starting = new Node(initial);
        this.start = starting;
        this.nodes = 1;
    }

    public void add(Object addition) {
        if (nodes == 1) {
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

    public void setStartNode(Node pStart) {
        this.start = pStart;
    }

    public Node getNode(int position) {
        if (position > nodes) return null;
        if (position == 1) return start;
        Node query = start;
        for (int i = 0; i < position - 1;i++) {
            query = query.getNextNode();
        }
        return query;
    }

    public void replace(int position, Object content) {
        if (position > nodes) return;
        Node replace = start;
        for (int i = 0; i < position - 1;i++) {
            replace = replace.getNextNode();
        }
        replace.setContent(content);
    }

    public Node getStartNode() {
        return this.start;
    }

    public Object getContent(int position) {
        return this.getNode(position).getContent();
    }

    public int getSize() {
        return this.nodes;
    }

    public void remove(int position) {
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
            nodes--;
        }
    }
}
