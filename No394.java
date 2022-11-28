package GitProject;

import java.util.LinkedList;

public class No394 {
    int index;

    public static void main(String[] args) {
        No394 no394 = new No394();
        String s = no394.decodeString("3[a]");
        System.out.println(s);
    }

    public String decodeString(String s) {
        index = 0;
        LinkedList<String> list = new LinkedList<> ();
        while(index < s.length()){
            char c = s.charAt(index);
            if(Character.isDigit(c)){
                list.add(getDigit(s));
            }else if(Character.isLetter(c) || c == '['){
                list.add(String.valueOf(c));
                index++;
            }else if(c == ']'){
                LinkedList<String> temp = new LinkedList<>();
                while(!list.peekLast().equals("[")){
                    temp.addFirst(list.pollLast());
                }
                list.pollLast();
                int n = Integer.valueOf(list.pollLast());
                String tempString = getString(temp);
                for(int i = 0; i < n; i++){
                    list.add(tempString);
                }
                index++;
            }
        }
        return getString(list);
    }


    public String getDigit(String s){
        StringBuilder builder = new StringBuilder();
//        while(Character.isDigit(s.charAt(index))){
//            builder.append(s.charAt(index));
//            index++;
//        }

        //false 跳了一个
        char c = s.charAt(index++);
        while(Character.isDigit(c)){
            builder.append(c);
            c = s.charAt(index++);
        }
        return builder.toString();
    }

    public String getString(LinkedList<String> list){
        StringBuilder builder = new StringBuilder();
        while(list.size() != 0){
            builder.append(list.poll());
        }
        return builder.toString();
    }
}
