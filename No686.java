package GitProject;

public class No686 {
    public static void main(String[] args) {
        No686 no686 = new No686();
        int i = no686.repeatedStringMatch("a", "aa");
        System.out.println(i);
    }

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < b.length() && ++ans > 0) sb.append(a);
        sb.append(a);
        int idx = sb.indexOf(b);
        if (idx == -1) return -1;
        return idx + b.length() > a.length() * ans ? ans + 1 : ans;
    }
}
