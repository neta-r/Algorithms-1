package LCS;

public class greedySolution {
    String a;
    String b;

    public greedySolution(String a, String b){
        this.a=a;
        this.b=b;
        System.out.println(findString());
    }

    public String findString(){
        String ans= "";
        for (int i=0 , j=0; i<a.length() && j<b.length(); i++){
            if (a.charAt(i)==b.charAt(j)){
                ans=ans+a.charAt(i);
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        greedySolution a = new greedySolution("ababcb", "cbab");
        greedySolution b = new greedySolution("cbab", "ababcb");
    }
}
