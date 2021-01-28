package plainProblem;

public class greedySolution {
    node[][] mat;

    public greedySolution(node[][] mat) {
        this.mat = mat;
        cheapestPath();
    }

    public void cheapestPath() {
        node[] ans = new node[this.mat.length+2];
        ans[0] = mat[0][0];
        int index = 1, count = 1;
        for (int i = 0, j = 0; count+1<ans.length; ) {
            if (mat[i][j].costDown > mat[i][j].costRight && j + 1 < mat.length) {
                ans[index] = mat[i][j + 1];
                j++;
                index++;
                count++;
            } else {
                ans[index] = mat[i + 1][j];
                i++;
                index++;
                count++;
            }
        }
        ans[ans.length-1] = mat[mat.length-1][mat.length-1];
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i] + ",");
        }
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
        greedySolution m = new greedySolution(mat);
        System.out.println("----");
        node[][] mat2 = new node[3][3];
        node one = new node(0, 0, 13, 1);
        node two = new node(0, 1, 9, 7);
        node three = new node(0, 2, 10, false);
        node four = new node(1, 0, 2, 95);
        node five = new node(1, 1, 3, 5);
        node six = new node(1, 2, 14, false);
        node seven = new node(2, 0, 4, true);
        node eight = new node(2, 1, 5, true);
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
        greedySolution n = new greedySolution(mat2);
    }
}
