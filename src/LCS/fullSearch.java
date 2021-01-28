package LCS;

import java.util.ArrayList;
import java.util.List;

public class fullSearch {
    String a;
    String b;
    List<String> aHelp;
    List<String> bHelp;

    public fullSearch(String a, String b){
        this.a= a;
        this.b=b;
        this.aHelp= new ArrayList<>();
        this.bHelp= new ArrayList<>();
        findAllCombo(aHelp, a);
        findAllCombo(bHelp, b);
        System.out.println(commonSharedString());
    }

    public void findAllCombo(List l, String s){
        int num=1;
        String t="1";
        while (t.length()-1!=s.length()){
            t=t+0;
        }
        while (Integer.parseInt(t)!=num){
            l.add(translateToString(num, s));
            num=plusOne(num);
        }
    }

    public int plusOne(int num){
        int count=0;
        if (num%10==0){
            num+=1;
        }
        else {
            while (num%10!=0){
                count++;
                num/=10;
            }
            num+=1;
            while (count!=0){
                num*=10;
                count--;
            }
        }
        return num;
    }

    public String translateToString(int num, String s){
        String res="";
        while (num>0){
            int last= num%10;
            if (last==1){
                res=s.charAt(s.length()-1)+res;
            }
            num/=10;
            s=s.substring(0,s.length()-1);
        }
        return res;
    }

    public String commonSharedString(){
        int max=0;
        String ans="";
        for (int i=0; i<aHelp.size(); i++){
            for (int j=0; j< bHelp.size(); j++){
                if (aHelp.get(i).equals(bHelp.get(j))&&aHelp.get(i).length()>max){
                    max=aHelp.get(i).length();
                    ans=aHelp.get(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        fullSearch b = new fullSearch("abfc", "adc");
    }
}
