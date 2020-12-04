package practice;

import java.util.Arrays;

public class fejmw {
    public static void main(String[] args) {
        int a[][] = {{0,1,1,1},
                   {1,1,1,1},
                   {1,1,0,1},
                   {0,0,0,0}};
        int ones = 0;
        int mx = 0;
        int ans = 0;
        for(int i=0;i<4;i++){
            ones = 0;
            for(int j=0;j<4;j++){
                if(a[i][j]==1) ones++;
            }
            if(ones > mx){
                mx = ones; 
                ans = i;
            }
        }
        System.out.println(ans);
    }
}

