package plainProblem;

public class node {
    int i,j, costRight, costDown, price, nPaths;
    String path;

    public node(int i, int j, int costRight, int costDown){
        this.i=i;
        this.j=j;
        this.costRight=costRight;
        this.costDown=costDown;
        this.price=0;
        this.nPaths=0;
        this.path="";
    }

    public node(node nd){
        this.i=nd.i;
        this.j=nd.j;
        this.costRight=nd.costRight;
        this.costDown=nd.costDown;
    }

    public node(int i, int j, int cost, boolean right){
        this.i=i;
        this.j=j;
        if (right){
            this.costRight=cost;
            this.costDown=Integer.MAX_VALUE;
        }
        else {
            this.costDown=cost;
            this.costRight=Integer.MAX_VALUE;
        }
        this.price=-1;
        this.nPaths=-1;
    }

    public node(int i, int j){
        this.i=i;
        this.j=j;
        this.costRight=Integer.MAX_VALUE;
        this.costDown=Integer.MAX_VALUE;
        this.price=-1;
        this.nPaths=-1;
    }


    public int getCostRight() {
        return costRight;
    }

    public int getCostDown() {
        return costDown;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "node{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }


    public void setnPaths(int nPaths) {
        this.nPaths = nPaths;
    }
}
