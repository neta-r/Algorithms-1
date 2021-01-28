package findingCircles;

public class parkingProblem {

    public static int findCar(parkingLinkedlist l) {
        l.head.mark='v';
        int count=1;
        parkingNode i = l.head.next;
        while (i.mark != 'w') {
            while (i.mark != 'v') {
                i = i.next;
                count++;
            }
            i.mark = 'w';
            for (int j = 0; j < count; j++) {
                i = i.prev;
            }
            if (i.mark == 'w') return count;
            for (int j = 0; j < count; j++) {
                i = i.next;
            }
            i.mark='x';
        }
        return 0;
    }


    public static void main(String[] args) {
        parkingNode a = new parkingNode(null,null,'x',1);
        parkingNode b = new parkingNode(null,null,'x',2);
        parkingNode c = new parkingNode(null,null,'x',3);
        parkingNode d = new parkingNode(null,null,'v',4);
        parkingNode e = new parkingNode(null,null,'x',5);
        parkingNode f = new parkingNode(null,null,'x',6);
        parkingNode g = new parkingNode(null,null,'x',7);
        parkingNode h = new parkingNode(null,null,'x',8);
        parkingNode i = new parkingNode(null,null,'v',9);
        parkingNode j = new parkingNode(null,null,'v',10);
        parkingLinkedlist l = new parkingLinkedlist(a);
        l.add(b);
        l.add(c);
        l.add(d);
        l.add(e);
        l.add(f);
        l.add(g);
        l.add(h);
        l.add(i);
        l.add(j);
        l.closeCircle();
        System.out.println(findCar(l));
    }
}

class parkingNode {
    parkingNode next;
    parkingNode prev;
    char mark;
    int id;

    public parkingNode(parkingNode next, parkingNode prev, char c, int id){
        this.id=id;
        this.mark=c;
        this.next=next;
        this.prev=prev;
    }
}

class parkingLinkedlist {
    parkingNode head;

    public parkingLinkedlist(parkingNode head){
        this.head=head;
    }

    public void add(parkingNode nd){
        if (head==null) {
            head=nd;
            nd.next=null;
        }
        parkingNode i= head;
        while (i.next!=null){
            i=i.next;
        }
        i.next=nd;
        nd.prev=i;
        nd.next=null;
    }

    public void closeCircle(){
        parkingNode i= head;
        while (i.next!=null){
            i=i.next;
        }
        i.next=head;
        head.prev=i;
    }
}

