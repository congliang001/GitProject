package GitProject;

public class No709 {
    public static void main(String[] args) {
        String hello = new No709().toLowerCase("Hello");
        System.out.println(hello);
    }

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                sb.append(s.charAt(i));
            }else{
                sb.append((char)(s.charAt(i) + 32));
            }
        }
        return sb.toString();
    }
}
