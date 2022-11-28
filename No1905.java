package GitProject;

import java.util.HashSet;
import java.util.Set;

public class No1905 {

    public static void main(String[] args) {
        No1905 no1905 = new No1905();
        int[][] grid1 = {{1,1,1,0,0}, {0,1,1,1,1}, {0,0,0,0,0}, {1,0,0,0,0},{1,1,0,1,1}};
        int[][] grid2 = {{1,1,1,0,0}, {0,0,1,1,1}, {0,1,0,0,0}, {1,0,1,1,0},{0,1,0,1,0}};
        int i = no1905.countSubIslands(grid1, grid2);
        System.out.println(i);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        UF uf = new UF(n * m + 1);
        int dumy = n * m;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid2[i][j] == 1){
                    if(i + 1 < n && grid2[i + 1][j] == 1){
                        uf.connect(i * m + j, (i + 1) * m + j);
                    }
                    if(j + 1 < m && grid2[i][j + 1] == 1){
                        uf.connect(i * m + j, i * m + j + 1);
                    }
                }else{
                    uf.connect(i * m + j, dumy);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!uf.isUnion(i * m + j, dumy)){
                    set.add(uf.findRoot(i * m + j));
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!uf.isUnion(i * m + j, dumy) && grid1[i][j] == 0){
                    set.remove(uf.findRoot(i * m + j));
                }
            }
        }
        return set.size() ;
    }
}


class UF{
    int count;
    int[] size;
    int[] root;

    public UF(int count){
        this.count = count;
        size = new int[count];
        root = new int[count];
        for(int i = 0; i < count; i++){
            size[i] = 1;
            root[i] = i;
        }
    }

    public int getCount(){
        return count;
    }

    public int findRoot(int i){
        while(i != root[i]){
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }

    public boolean isUnion(int i, int j){
        int rootI = findRoot(i);
        int rootJ = findRoot(j);
        return rootI == rootJ;
    }

    public void connect(int i, int j){
        int rootI = findRoot(i);
        int rootJ = findRoot(j);
        if(rootI == rootJ){
            return;
        }
        if(size[rootI] > size[rootJ]){
            root[rootJ] = root[rootI];
            size[rootI] += size[rootJ];
        }else{
            root[rootI] = root[rootJ];
            size[rootJ] += size[rootI];
        }
        count--;
    }
}