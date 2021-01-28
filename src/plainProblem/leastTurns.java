package plainProblem;

import java.util.ArrayList;
import java.util.List;

public class leastTurns {
    node[][] mat;

    public leastTurns(node[][] mat) {
        this.mat = mat;
        fillMatrix();
        traceBack();
    }

    public void fillMatrix() {
        for (int i = 1; i < mat.length; i++) {
            mat[0][i].setPrice(mat[0][i - 1].price + mat[0][i - 1].costRight);
            mat[0][i].path=mat[0][i-1].path+"R";
            mat[0][i].setnPaths(1);
            mat[i][0].setPrice(mat[i - 1][0].price + mat[i - 1][0].costDown);
            mat[i][0].path=mat[i-1][0].path+"D";
            mat[i][0].setnPaths(1);
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat.length; j++) {
                int a = mat[i - 1][j].price + mat[i - 1][j].costDown;
                int b = mat[i][j - 1].price + mat[i][j - 1].costRight;
                if (a>b){
                    mat[i][j].setPrice(b);
                    mat[i][j].setnPaths(mat[i][j - 1].nPaths);
                    mat[i][j].path= "D"+mat[i - 1][j].path;
                }
                if (a<b){
                    mat[i][j].setPrice(a);
                    mat[i][j].setnPaths(mat[i - 1][j].nPaths);
                    mat[i][j].path="R"+mat[i][j - 1].path;
                }
                if (a==b){
                    mat[i][j].setPrice(a);
                    mat[i][j].setnPaths(mat[i - 1][j].nPaths+mat[i][j - 1].nPaths);
                    if (mat[i][j-1].path.charAt(mat[i][j-1].path.length()-1)=='R') mat[i][j].path="R"+mat[i][j - 1].path;
                    else mat[i][j].path="D"+mat[i - 1][j].path;
                }
            }
        }
    }


    public void traceBack() {
        List<node> ans = new ArrayList<>();
        int count = 0;
        for (int i = mat.length - 1, j = mat.length - 1; count < mat.length; ) {
            if (j-1>=0 && mat[i][j].path.charAt(mat[i][j].path.length()-1)=='R') {
                ans.add(mat[i][j - 1]);
                j--;
                count++;
            }
            else if (i-1 >=0 && mat[i][j].path.charAt(mat[i][j].path.length()-1)=='D'){
                ans.add(mat[i - 1][j]);
                i--;
                count++;
            }
            else {
                break;
            }
        }
        ans.add(mat[0][0]);
        ans.add(0, mat[mat.length - 1][mat.length - 1]);
        for (int i = ans.size() - 1; i >= 0; i--) {
            System.out.println(ans.get(i) + ",");
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
        leastTurns m = new leastTurns(mat);
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
        leastTurns n = new leastTurns(mat2);
    }
}
