import java.util.Arrays;

public class Tasks {
    public static void main(String[] args) {
       // System.out.println(Arrays.toString(oddNumbers(5,13)));
       // printBinaryform(6);
        //System.out.println(Integer.toBinaryString(6));
       // System.out.println(getIntegerComplement(50));
        System.out.println(Integer.parseInt("111",2));
    }

    static String findNumber(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return "YES";
            }
        }
        return "NO";
    }

    static int[] oddNumbers(int l, int r) {
        int arr[];
        if(l%2==0 && r%2==0){
             arr=new int[(r-l)/2];
        }else{
             arr=new int[(r-l)/2+1];
        }
        int index = 0;

        for(int i =l;i<=r;i++){
            if(i%2!=0){
                arr[index]=i;
                index++;
            }
        }
        return arr;
    }

    private static void printBinaryform(int number) {
        int remainder;

        if (number <= 1) {
            System.out.print(number);
            return;   // KICK OUT OF THE RECURSION
        }

        remainder = number %2;
        printBinaryform(number >> 1);
        System.out.print(remainder);
    }

    static int getIntegerComplement(int n) {
        StringBuilder complement=new StringBuilder("");
        String binaryNum=Integer.toBinaryString(n);

        for(int i =0;i<binaryNum.length();i++){
            if(binaryNum.charAt(i)=='0'){
                complement.append('1');
            }else{
                complement.append('0');
            }
        }

        return Integer.parseInt(complement.toString(),2);
    }


}
