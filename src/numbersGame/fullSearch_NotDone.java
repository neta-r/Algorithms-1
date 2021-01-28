package numbersGame;

import java.util.Arrays;

public class fullSearch_NotDone {
    int[] arr;
    node[] tree;

    public fullSearch_NotDone(int[] arr) {
        this.arr = arr;
        int size = (int) Math.pow(2, arr.length);
        this.tree = new node[size];
        buildTree();
        Arrays.toString(findPath());
    }

    public void buildTree() {
        int start = 0, end = arr.length-1;
        node nd = new node(start, end);
        buildTree(1, nd);
    }

    public void buildTree(int index, node nd) {
        if (nd.start > nd.end) return;
        this.tree[index] = nd;
        node left = new node(nd.start + 1, nd.end);
        buildTree(index * 2, left);
        node right = new node(nd.start, nd.end - 1);
        buildTree(index * 2 + 1, right);

    }

    public int[] findPath() {
        int[] path = new int[arr.length];
        path(1, false);
        return path;
    }

    public void path(int index, boolean flag) {
        if (this.tree[index].start == this.tree[index].end) {
            this.tree[index].profit = -this.arr[this.tree[index].start];
        }
        path(index * 2, !flag);
        path(index * 2 + 1, !flag);
        if (flag) {
            if (this.arr[this.tree[index].start] > this.arr[this.tree[index].end]) {
                this.tree[index].profit = this.arr[this.tree[index].start] + this.tree[index * 2].profit;
            } else {
                this.tree[index].profit = this.arr[this.tree[index].end] + this.tree[index * 2 + 1].profit;
            }
        } else {
            if (this.arr[this.tree[index].start] > this.arr[this.tree[index].end]) {
                this.tree[index].profit = this.arr[this.tree[index].start] - this.tree[index * 2].profit;
            } else {
                this.tree[index].profit = this.arr[this.tree[index].end] - this.tree[index * 2 + 1].profit;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 6};
        fullSearch_NotDone a = new fullSearch_NotDone(arr);
    }

}

class node {
    int start, end, profit = 0;

    public node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
}
