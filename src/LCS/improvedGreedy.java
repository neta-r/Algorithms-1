package LCS;

public class improvedGreedy {
    String shorter;
    String longer;
    char [] help;

    public improvedGreedy(String a, String b){
        if (a.length()>b.length()){
            this.shorter=b;
            this.longer=a;
        }
        else {
            this.shorter=a;
            this.longer=b;
        }
        help= new char['z'-'a'];
        for (int i=0; i<shorter.length(); i++){
            this.help[shorter.charAt(i)-'a']++;
        }
        System.out.println(findString());
    }

    public String findString(){
        String ans= "";
        int index=0, start=0;
        for (int i=0; i<longer.length(); i++){
            if (this.help[longer.charAt(i)-'a']!=0){
                index = shorter.indexOf(longer.charAt(i),start);
                if (index!=-1) {
                    start = index+1;
                    ans = ans + longer.charAt(i);
                    this.help[longer.charAt(i) - 'a']--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        improvedGreedy b = new improvedGreedy("adcbc", "abca");
    }
}
