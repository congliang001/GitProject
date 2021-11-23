package GitProject;

public class No859 {
    public static void main(String[] args) {
        boolean b = buddyStrings("ab", "babbb");
        System.out.println(b);
    }
    public static boolean buddyStrings(String s, String goal) {
        int slong = s.length();
        int glong = goal.length();
        if(slong != glong){
            return false;
        }
        int[] sarray = new int [26];
        int[] garray = new int [26];
        int different = 0;
        boolean ok = false;
            for(int i = 0; i < slong; i++){
                sarray[s.charAt(i) - 'a'] ++;
                garray[goal.charAt(i) - 'a'] ++;
                if(s.charAt(i) - 'a' != goal.charAt(i) - 'a'){
                    different ++;
                }
            }
            for(int i = 0; i < 26; i++){
                if(sarray[i] != garray[i]){
                    return false;
                }
                if(sarray[i] > 1){
                    ok = true;
                }
            }
        if(different == 2){
            return true;
        }else if(different == 0 && ok){
            return true;
        }else{
            return false;
        }
    }
}
