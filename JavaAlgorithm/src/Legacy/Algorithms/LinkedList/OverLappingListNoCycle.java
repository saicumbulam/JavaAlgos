package Legacy.Algorithms.LinkedList;


public class OverLappingListNoCycle {
    public ListNode<Integer> overLappingNoCycleLists( ListNode<Integer> l0,
                                                      ListNode<Integer> l1){
        int lolength = length(l0), l1length=length(l1);

        if (lolength > l1length) {
            l0 = advanceListbyK(lolength-l1length, l0);
        } else {
            l1 = advanceListbyK(l1length-lolength, l1);
        }

        while(l0 != null && l1 != null && l0 != l1){
            l0 = l0.next;
            l1 = l1.next;
        }
        return l0; // null implies there is no overlap
    }

    private ListNode<Integer> advanceListbyK(int k, ListNode<Integer> l){
        while (k-- > 0){
            l = l.next;
        }
        return l;
    }

    private int length(ListNode<Integer> l ){
        int length = 0;
        while (l != null){
            length++;
            l = l.next;
        }
        return length;
    }
}
