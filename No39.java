package GitProject;

import java.util.ArrayList;
import java.util.List;

public class No39 {
    public static void main(String[] args) {
        int[] array = {2,3,4,6};
        int target = 7;
        List<List<Integer>> lists = new No39().combinationSum(array, target);
        System.out.println(lists);

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backTrack1(target,candidates,list,cur,0);
        return list;
    }


    public void backTrack1(int target , int[] array , List list, List cur,int index){
        if(target == 0){
//            System.out.println(cur);
            list.add(new ArrayList<>(cur));
            return;
        }
        if(target < 0){
            return ;
        }

        for(int i = index; i < array.length; i++){
            cur.add(array[i]);
            backTrack1(target - array[i],array,list,cur,i);
            cur.remove(cur.size() - 1);
        }
    }




    public void backTrack(int target , int[] array , List list, List cur){
        if(target == 0){
//            System.out.println(cur);
            list.add(new ArrayList<>(cur));
            return;
        }
        if(target < 0){
            return ;
        }

        for(int i = 0; i < array.length; i++){
            cur.add(array[i]);
            backTrack(target - array[i],array,list,cur);
            cur.remove(cur.size() - 1);
        }
    }



}
