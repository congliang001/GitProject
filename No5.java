package GitProject;

public class No5 {
    public static void main(String[] args) {
        String babad = longestPalindrome2("babad");
        String babad1 = longestPalindrome1("babad");
        System.out.println(babad.equals(babad1));
    }

    public static String longestPalindrome1(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            len = 1;
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left + 1;
            }
        }
        return s.substring(maxStart , maxStart + maxLen );

    }

    public static String longestPalindrome2(String s) {
        int length = s.length();
        if(s == null || length < 1){
            return null;
        }
        boolean[][] dp = new boolean [length][length];
        for(int i = 0; i < length; i ++){
            dp[i][i] = true;
        }
        int len = 1;
        int maxLen = 1;
        int startIndex = 0;
        String result = "";
        for(int right = 1; right < length; right ++){
            for(int left = 0; left < right; left ++){
                if(s.charAt(left) == s.charAt(right)){
                    if(right - left + 1 < 4){
                        dp[left][right] = true;
                        len = right -left + 1;
                    }else if (dp[left+1][right-1]){
                        dp[left][right] = true;
                        len = right -left + 1;
                    }
                    if(maxLen < len){
                        maxLen = len;
                        startIndex = left;
                    }
                }else{
                    dp[left][right] = false;
                }
            }
        }
        return s.substring(startIndex,startIndex + maxLen);
    }


    public static String longestPalindrome3(String s) {
        int length = s.length();
        int leftIndex = 0;
        int maxLength = 0;
        boolean[][] dp = new boolean[length][length];


        for(int left = length - 1; left >= 0; left--){
            for(int right = left; right < length; right++){
                if(s.charAt(left) == s.charAt(right)){
                    if(right - left + 1 <= 3){
                        dp[left][right] = true;
                    }else{
                        dp[left][right] = dp[left + 1][right - 1];
                    }
                }else{
                    dp[left][right] = false;
                }
                if(dp[left][right]){
                    if(maxLength < right - left + 1){
                        maxLength = right - left + 1;
                        leftIndex = left;
                    }
                }
            }
        }
        return s.substring(leftIndex,leftIndex + maxLength);
    }
}
