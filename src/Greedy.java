import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Greedy {
    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length-1;i++){
            if(Math.abs(arr[i] - arr[i+1])<result){
                result = Math.abs(arr[i] - arr[i+1]);
            }
        }
        return result;
    }

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        Integer result = 0;

        ArrayList importantContests = new ArrayList<Integer>();
        ArrayList unimportantContests = new ArrayList<Integer>();
        for(int i=0;i<contests.length;i++){
            if(contests[i][1] == 1){
                importantContests.add(contests[i][0]);
            }else{
                unimportantContests.add(contests[i][0]);
            }
        }

        Collections.sort(importantContests);

        System.out.println(importantContests);

        for(int j=0;j<importantContests.size();j++){
            if(j<importantContests.size()-k){
                result = result - (Integer) importantContests.get(j);
            }else {
                result = result + (Integer) importantContests.get(j);
            }
        }

        for(int n = 0; n < unimportantContests.size();n++){
            result = result + (Integer) unimportantContests.get(n);
        }
       return result;
    }

    public static void main(String[] args) throws IOException {
        int arr[][] = new int[6][2];
        arr[0][0] = 5;
        arr[0][1] = 1;
        arr[1][0] = 2;
        arr[1][1] = 1;
        arr[2][0] = 1;
        arr[2][1] = 1;

        arr[3][0] = 8;
        arr[3][1] = 1;
        arr[4][0] = 10;
        arr[4][1] = 0;
        arr[5][0] = 5;
        arr[5][1] = 0;

        System.out.println(luckBalance(3, arr));
    }
}

