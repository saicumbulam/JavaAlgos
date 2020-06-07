package Legacy.Algorithms.LinkedList;

public class DeleteNode {
    public void deleteList(ListNode<Integer> aNode){
        aNode.next = aNode.next.next;
    }
}
