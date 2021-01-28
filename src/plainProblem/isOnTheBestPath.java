package plainProblem;

public class isOnTheBestPath {
    node nd;
    node[][] mat;
    node[][] fromStartToNode;
    node[][] fromNodeToEnd;

    public isOnTheBestPath(node[][] mat, node nd) {
        this.nd = nd;
        this.mat = mat;
        buildOtherMat();
        isOnThePath();
    }

    public void isOnThePath() {
        int all = fillMatrix(this.mat);
        int start = fillMatrix(fromStartToNode);
        int end = fillMatrix(fromNodeToEnd);
        if (all == start + end) System.out.println("The node is on the cheapest path");
        else System.out.println("The node is not on the cheapest path");
    }

    public void buildOtherMat() {
        this.fromStartToNode = new node[nd.i + 1][nd.j + 1];
        for (int i = 0; i < fromStartToNode.length; i++) {
            for (int j = 0; j < fromStartToNode[0].length; j++) {
                this.fromStartToNode[i][j] = new node(mat[i][j]);
                //this.fromStartToNode[i][j] = mat[i][j];
            }
        }
        this.fromNodeToEnd = new node[mat.length - fromStartToNode.length + 1][mat[0].length - fromStartToNode[0].length + 1];
        for (int i = 0; i < fromNodeToEnd.length; i++) {
            for (int j = 0; j < fromNodeToEnd[0].length; j++) {
                this.fromNodeToEnd[i][j] = new node(mat[i + nd.i][j + nd.j]);
                //this.fromNodeToEnd[i][j] = mat[i + nd.i][j + nd.j];
            }
        }
    }

    public int fillMatrix(node[][] m) {
        for (int i = 1; i < m.length; i++) {
            m[i][0].setPrice(m[i - 1][0].price + m[i - 1][0].costDown);
            m[i][0].path = m[i - 1][0].path + "D";
            m[i][0].setnPaths(1);
        }
        for (int i = 1; i < m[0].length; i++) {
            m[0][i].setPrice(m[0][i - 1].price + m[0][i - 1].costRight);
            m[0][i].path = m[0][i - 1].path + "R";
            m[0][i].setnPaths(1);
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                int a = m[i - 1][j].price + m[i - 1][j].costDown;
                int b = m[i][j - 1].price + m[i][j - 1].costRight;
                if (a > b) {
                    m[i][j].setPrice(b);
                    m[i][j].setnPaths(m[i][j - 1].nPaths);
                }
                if (a < b) {
                    m[i][j].setPrice(a);
                    m[i][j].setnPaths(m[i - 1][j].nPaths);
                }
                if (a == b) {
                    m[i][j].setPrice(a);
                    m[i][j].setnPaths(m[i - 1][j].nPaths + m[i][j - 1].nPaths);
                }
            }
        }
        return m[m.length - 1][m[0].length - 1].price;
    }

    public static void main(String[] args) {
        node a = new node(0, 0, 1, 77);
        node b = new node(0, 1, 1, 9);
        node c = new node(0, 2, 10, false);
        node d = new node(1, 0, 9, 50);
        node e = new node(1, 1, 20, 23);
        node f = new node(1, 2, 13, false);
        node g = new node(2, 0, 4, true);
        node h = new node(2, 1, 5, true);
        node i = new node(2, 2);
        node[][] mat = new node[3][3];
        mat[0][0] = a;
        mat[0][1] = b;
        mat[0][2] = c;
        mat[1][0] = d;
        mat[1][1] = e;
        mat[1][2] = f;
        mat[2][0] = g;
        mat[2][1] = h;
        mat[2][2] = i;
        isOnTheBestPath m = new isOnTheBestPath(mat, b);
        System.out.println("----");
        node[][] mat2 = new node[3][3];
        node one = new node(0, 0, 50, 1);
        node two = new node(0, 1, 50, 50);
        node three = new node(0, 2, 50, false);
        node four = new node(1, 0, 1, 1);
        node five = new node(1, 1, 50, 1);
        node six = new node(1, 2, 50, false);
        node seven = new node(2, 0, 1, true);
        node eight = new node(2, 1, 1, true);
        node nine = new node(2, 2);
        mat2[0][0] = one;
        mat2[0][1] = two;
        mat2[0][2] = three;
        mat2[1][0] = four;
        mat2[1][1] = five;
        mat2[1][2] = six;
        mat2[2][0] = seven;
        mat2[2][1] = eight;
        mat2[2][2] = nine;
        isOnTheBestPath n = new isOnTheBestPath(mat2, six);
    }
}
