
/**
 * @author hz
 * @Description: 实现单链表节点
 * @create 2019-12-22
 */
public class Node {
    static Node nodeHead = new Node(null);//头结点
    Object head;
    Node next = null;

    public Node(Object head) {
        this.head = head;
    }

    // input
    public static void addNode(int d) {
        Node newNode = new Node(d);
        Node tmp = nodeHead;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    public static void main(String[] args) {
        addNode(5);
        addNode(8);
        Node tmp = nodeHead.next;
        while (tmp != null) {
            System.out.println(tmp.head);
            tmp = tmp.next;
        }
    }
}
