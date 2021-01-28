package findingCircles;

public class oneDirectionalLinkedList {
    public static node findCircle(linkedlist l){
        node bunny = l.head.next.next;
        node turtle = l.head.next;
        while (bunny.id!=turtle.id){
            bunny = bunny.next.next;
            turtle = turtle.next;
        }
        return bunny;
    }

    public static node findCircleWithArm(linkedlist l){
        node bunny = l.head.next.next;
        node turtle = l.head.next;
        while (bunny.id!=turtle.id){
            bunny = bunny.next.next;
            turtle = turtle.next;
        }
        node cat = l.head;
        while (cat.id != turtle.id){
            cat=cat.next;
            turtle=turtle.next;
        }
        return cat;
    }

    public static void main(String[] args) {
        node a = new node(null,1);
        node b = new node(null,2);
        node c = new node(null,3);
        node d = new node(null,4);
        node e = new node(null,5);
        node f = new node(null,6);
        node g = new node(null,7);
        node h = new node(null,8);
        node i = new node(null,9);
        node j = new node(null,10);
        linkedlist l = new linkedlist(a);
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
        System.out.println(findCircle(l));
        node one = new node(null,1);
        node two= new node(null,2);
        node three = new node(null,3);
        node four = new node(null,4);
        node five = new node(null,5);
        node six = new node(null,6);
        node seven = new node(null,7);
        node eight = new node(null,8);
        node nine = new node(null,9);
        node ten = new node(null,10);
        linkedlist l2 = new linkedlist(one);
        l2.add(two);
        l2.add(three);
        l2.add(four);
        l2.add(five);
        l2.add(six);
        l2.add(seven);
        l2.add(eight);
        l2.add(nine);
        l2.add(ten);
        l2.closeCircleWithArm(seven);
        System.out.println(findCircleWithArm(l2));
    }
}

class node {
    node next;
    int id;

    @Override
    public String toString() {
        return "node{" +
                "id=" + id +
                '}';
    }

    public node(node next, int id){
        this.id=id;
        this.next=next;
    }
}

class linkedlist {
    node head;

    public linkedlist(node head){
        this.head=head;
    }

    public void add(node nd){
        if (head==null) {
            head=nd;
            nd.next=null;
        }
        node i= head;
        while (i.next!=null){
            i=i.next;
        }
        i.next=nd;
        nd.next=null;
    }

    public void closeCircle() {
        node i = head;
        while (i.next != null) {
            i = i.next;
        }
        i.next = head;
    }

    public void closeCircleWithArm(node nd) {
        node i = head;
        while (i.next != null) {
            i = i.next;
        }
        i.next = nd;
    }

}

