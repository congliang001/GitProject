package GitProject;

public class No1763 {
    public static void main(String[] args) {
        No1763 no1763 = new No1763();
        String aAa = no1763.longestNiceSubstring("aAa");
        System.out.println(aAa);
    }
    public String longestNiceSubstring(String s) {
        int maxLength = 0;
        String ans = "";
        int length = s.length();
        for(int left = 0; left < length; left++){
            for(int right = left + 1; right <= length; right++){
                String s1 = s.substring(left,right);
                if(s1.length() > maxLength && check(s1)){
                    maxLength = s1.length();
                    ans = s.substring(left,right);
                }
            }
        }
        return ans;

    }

    public boolean check (String s){
        int length = s.length();
        for(int i = 0; i < length; i++){
            Character c = new Character(s.charAt(i));
            if(s.indexOf(c.toString().toLowerCase()) == -1 || s.indexOf(c.toString().toUpperCase()) == -1){
                return false;
            }
        }
        return true;
    }
}
