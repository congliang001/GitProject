package GitProject;

import java.util.ArrayList;
import java.util.List;

public class No17 {

    public static void main(String[] args) {
        List<String> strings = new No17().letterCombinations("234");
        System.out.println(strings);
    }

    public List<String> letterCombinations(String digits) {
        char[][] number = new char[][]{
                {},
                {},{'a','b','c'},{'d','e','f'},
                {'g','h','i'},{'j','k','l'},{'m','n','o'},
                {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
        };
        List<String> result = new ArrayList<>();

            StringBuilder sb = new StringBuilder();
            dfs(number,digits,0,sb,result);
            return result;

//        for(int i = 0; i < digits.length(); i++){
//            StringBuilder sb = new StringBuilder();
//            dfs(number,digits,i,sb,result);
//        }
//        return result;


    }

    public void dfs(char[][] charArray,String digits,int index,StringBuilder sb,List<String> list){
        if(digits.length() == index){
            list.add(sb.toString());
            return;
        }
        int toNumber = digits.charAt(index) - 48;
        for(int i = 0; i < charArray[toNumber].length; i++){
            sb.append(charArray[toNumber][i]);
            dfs(charArray,digits,index + 1,sb,list);
            sb.deleteCharAt(index);
        }



    }
}
