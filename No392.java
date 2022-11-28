package GitProject;

public class No392 {
    public static void main(String[] args) {
        boolean subsequence = isSubsequence("abbc", "abbbbc");
        System.out.println(subsequence);
    }


    public static boolean isSubsequence(String s, String t) {
        int slength = s.length();
        int tlength = t.length();

        int[][] dp = new int [tlength + 1][26];
        for(int i = 0; i < 26; i++){
            dp[tlength][i] = tlength;
        }

        for(int i = tlength - 1; i >= 0; i--){
            for(int j = 0; j <26; j++){
                if(t.charAt(i) == j + 'a'){
                    dp[i][j] = i;
                }else{
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        int len = 0;
        for(int i = 0; i < slength; i++){
            if(dp[len][s.charAt(i) - 'a'] == slength){
                return false;
            }else{
                len = dp[len][s.charAt(i) - 'a'] + 1;
            }
        }

        return true;
    }
}
