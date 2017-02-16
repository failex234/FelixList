/**
 * @author Felix Naumann
 * @version 2017-02-02
 */
public class Node
{
    private Object content;
    private Node nextNode;

    public Node(Object pContent) {
        this.content = pContent;
        this.nextNode = null;
    }

    public void setContent(Object pContent) {
        this.content = pContent;
    }

    public void setNextNode(Node pNextNode) {
        this.nextNode = pNextNode;
    }

    public Object getContent() {
        return this.content;
    }

    public Node getNextNode() {
        return this.nextNode;
    }
}
