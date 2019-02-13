import java.util.*;

public class CCI {
    public static boolean one (String s){
        boolean arr[] = new boolean[128];
        for(int i=0;i<s.length();i++){
            char value = s.charAt(i);
            if(arr[value]){
                return false;
            }
            arr[value] = true;
        }
        return true;
    }

    public static boolean two(String s1, String s2){
        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1,arr2);
    }

    public static boolean four(String s, String pal){
        char chart_set[] = ((s+pal).toUpperCase()).toCharArray();
        boolean odd[] = new boolean[52];
        int count = 0;

        for(int i=0;i<chart_set.length;i++){
            odd[chart_set[i]-65] = !odd[chart_set[i]-65];
        }

        for(int j=0;j<odd.length;j++){
            if(odd[j]){
                count++;
            }
        }

        return count == 0 || count == 1;
    }

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] newArr = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            newArr[i] = a[(i+a.length+d)%a.length];
        }
        return newArr;
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i < arr.length - 2; i++){
            for(int j = 0; j < arr.length - 2;j++){
                currSum = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                                        + arr[i+1][j+1]
                        + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];

                if(currSum > maxSum){
                    maxSum = currSum;
                }
            }
        }
        return maxSum;
    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        String flag = "NO";
        for(char c: s1.toCharArray()){
            if(s2.contains(""+c)){
                flag = "YES";
                break;
            }
        }
        return flag;
    }

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer> table = new Hashtable<>();

        for (String aMagazine : magazine) {
            if (table.containsKey(aMagazine)) {
                table.replace(aMagazine, table.get(aMagazine) + 1);
            } else {
                table.put(aMagazine, 1);
            }
        }

        for (String aNote : note){
            if(table.containsKey(aNote)){
                if(table.get(aNote)==0){
                    table.remove(aNote);
                }else{
                    table.replace(aNote, table.get(aNote) - 1);
                }
            }else{
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");
    }



    private static long gcd(long a, long b)
    {
        while (b > 0)
        {
            long temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static long lcm(long a, long b)
    {
        return a * (b / gcd(a, b));
    }

    static ArrayList<String> words = new ArrayList<>();
    public static void possibleStrings(int maxLength, char[] alphabet, String curr) {

        // If the current string has reached it's maximum length
        if(curr.length() == maxLength) {
            words.add("D" + curr + "M");
            //System.out.println("D" + curr + "M");

            // Else add each letter from the alphabet to new strings and process these new strings again
        } else {
            for(int i = 0; i < alphabet.length; i++) {
                String oldCurr = curr;
                curr += alphabet[i];
                possibleStrings(maxLength,alphabet,curr);
                curr = oldCurr;
            }
        }
    }

    static void analyze(ArrayList<String> arr){
        int x = 2;
        Stack<Integer> s = new Stack<>();

        s.push(x);

        for(int i = 0; i<arr.size();i++){
            String word = arr.get(i);
            for(int j = 0;j<word.length();j++){
                if(word.charAt(j) == 'D'){
                    s.push(s.peek());
                }else{
                    int top = s.pop();
                    if(s.isEmpty()){
                        s.push(top);
                    }else{
                        int secodElem = s.pop();
                        s.push(top*secodElem);
                    }
                }
            }
            System.out.println(s + word);
            s = new Stack<>();
            s.push(2);
        }
    }


    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        ArrayList<char[]> a = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                a.add(s.substring(i,j).toCharArray());
            }
        }

        for(char[] arr : a){
            Arrays.sort(arr);
            System.out.println(arr);
        }

        for(int i = 0; i < a.size();i++){
            for(int j = i+1; j < a.size();j++){
                char[] currentArray = a.get(i);
                char[] arrayToCheck = a.get(j);
                if(Arrays.equals(currentArray, arrayToCheck)){
                    count++;
                }
            }
        }

        return count;
    }

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int count = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    count++;
                }
            }
        }
        System.out.println("Array is sorted in " + count + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length-1]);
    }

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int sumSoFar = 0;
        int numOfToys = 0;

        Arrays.sort(prices);

        for (int price : prices) {
            if (sumSoFar + price > k) {
                break;
            } else {
                sumSoFar += price;
                numOfToys++;
            }
        }
        return numOfToys;
    }



    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int sum = 0;
        for(int i = 0; i<arr.length-2;i++){
            sum = arr[i];
            for(int j = i + 2; j <= arr.length-1; j+=2){
                int adjacent = arr[j];

                sum += adjacent;
                System.out.println(sum);
            }

        }
        return 0;
    }

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int sum = 0;
        Hashtable<Character, Integer> table = new Hashtable<>();

        for(char c : a.toCharArray()){
            if(table.containsKey(c)){
                table.replace(c, table.get(c)+1);
            }else{
                table.put(c,1);
            }
        }

        for(char c : b.toCharArray()){
            if(table.containsKey(c)){
                table.replace(c, table.get(c)-1);
            }else{
                sum++;
            }
        }

        for(Integer i : table.values()){
            sum += Math.abs(i);
        }
        return sum;
    }

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int deletions = 0;
        char[] chars = s.toCharArray();

        for(int i = 1; i < s.length();i++){
            if(chars[i] == chars[i-1]){
                deletions++;
            }
        }
        return deletions;
    }

    // Complete the isValid function below.
    static String isValid(String s) {
        int numOfDifferences = 0;
        String isValid = "YES";
        HashMap<Character, Integer> table = new HashMap<>();

        for(char c : s.toCharArray()){
            if(table.containsKey(c)){
                table.replace(c, table.get(c)+1);
            }else{
                table.put(c,1);
            }
        }

        ArrayList<Integer> a = new ArrayList<>(table.values());

        int fst = a.get(0);

        for(int i = 1; i<a.size();i++){
            if(a.get(i) != fst){
                if(Math.abs(a.get(i)-fst)>1){
                    isValid = "NO";
                    break;
                }
                numOfDifferences++;
            }
        }

        if(!Objects.equals(isValid, "NO")){
            if(numOfDifferences <= 1){
                isValid = "YES";
            }else{
                isValid = "NO";
            }
        }

        return isValid;
    }

    // Complete the oddNumbers function below.
    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> odds = new ArrayList<>();

        for(int i = l; i <= r; i++){
            if(i%2 != 0){
                odds.add(i);
            }
        }
        return odds;
    }

    static int coinProblem(int amount, int[] coins){
        int[] combinations = new int[amount+1];

        combinations[0] = 1;

        for(int coin : coins){
            for(int i = 1; i< combinations.length;i++){
                if(i >= coin){
                    combinations[i] += combinations[i - coin];
                }
            }
        }
        return combinations[amount];
    }

    // Complete the count_coins function below.
    static List<Integer> count_coins(List<Integer> coinDenominations, int monetaryValue) {
        int currValue = 0;
        List<Integer> coins = new ArrayList<>();

        Collections.reverse(coinDenominations);

        for(int coin : coinDenominations){
            while(currValue <= monetaryValue){
                if(currValue + coin <= monetaryValue){
                    coins.add(coin);
                    currValue += coin;
                }else{
                    break;
                }
            }
        }
        return coins;
    }

    static int[] contacts(String[][] queries) {
        int[] nums = new int[queries.length];

        class Node{
            Character value;
            HashMap<Character,Node> children = new HashMap<>();

            public Node(){

            }

            public Node(Character value){
                this.value = value;
            }
        }

        class Trie{
            Node root;

            public Trie(){
                this.root = new Node();
            }

            public void add(String s){
                HashMap<Character, Node> children = root.children;

                for(int i = 0; i < s.length(); i++){
                    char c = s.charAt(i);

                    Node t;
                    if(children.containsKey(c)){
                        t = children.get(c);
                    }else{
                        t = new Node(c);
                        children.put(c, t);
                    }

                    children = t.children;
                }
            }

            public int find(String s){
                Node current = root;
                int numberOfChildren = 0;

                for(int i = 0; i <= s.length(); i++){
                    if(i == s.length()){
                        if(current.children != null){
                            numberOfChildren = current.children.size();
                        }else{
                            numberOfChildren = 0;
                        }
                    }else{
                        if (current.children != null) {
                            current = current.children.get(s.charAt(i));
                        }
                    }
                }
                return numberOfChildren;
            }
        }

        Trie t = new Trie();

        for(int i = 0,j = 0; i < queries.length; i++){
            if(queries[i][0].equals("add")){
                t.add(queries[i][1]);
            }else{
                nums[j] = t.find(queries[i][1]);
                j++;
            }
        }

        return nums;
    }

    public static int reverse(int x) {
        char[] charList = String.valueOf(x).toCharArray();
        Stack stack = new Stack();
        StringBuilder sb = new StringBuilder();
        boolean negative = false;

        for(char c: charList){
            stack.push(c);
        }

        for (char c : charList) {
            if(c == '-'){
                negative = true;
            }else{
                sb.append(stack.pop());
            }
        }


        return negative ? -1 * Integer.parseInt(sb.toString()) : Integer.parseInt(sb.toString());
    }

    public static boolean isPalindrome(int x) {
        int num = x;
        int reverse = 0;

        if(x < 0){
            return false;
        }

        while(num != 0)
        {
            reverse = reverse * 10;
            reverse = reverse + num%10;
            num = num/10;
        }

        return reverse == x;
    }

    public static int romanToInt(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length();i++){
            switch (chars[i]) {
                case 'I' :
                    if(i != chars.length -1){
                        if(chars[i+1] == 'V' || chars[i+1] == 'X'){
                            res -= 1;
                            continue;
                        }else {
                            res += 1;
                            continue;
                        }
                    }else {
                        res += 1;
                        continue;
                    }
                case 'V' : res += 5; continue;
                case 'X' :
                    if(i != chars.length -1){
                        if(chars[i+1] == 'L' || chars[i+1] == 'C'){
                            res -= 10;
                            continue;
                        }else {
                            res += 10;
                            continue;
                        }
                    }else {
                        res += 10;
                        continue;
                    }
                case 'L' : res += 50; continue;
                case 'C' :
                    if( i != chars.length - 1){
                        if(chars[i+1] == 'D' || chars[i+1] == 'M'){
                            res -= 100;
                            continue;
                        }else {
                            res += 100;
                            continue;
                        }
                    }else {
                        res += 100;
                        continue;
                    }
                case 'D' : res += 500; continue;
                case 'M' : res += 1000;
            }
        }
        return res;
    }

    public static int getMaxProfit(int[] stockPrices) {

        // calculate the max profit
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < stockPrices.length; i++){
            for(int j = i + 1; j < stockPrices.length; j++){
                if(stockPrices[j] - stockPrices[i] > max){
                    max = stockPrices[j] - stockPrices[i];
                }
            }
        }

        return max;
    }

    public static int paths(int[][] matrix){

        // initialise first row
        for(int i = 0; i < matrix[0].length; i ++){
            matrix[0][i] = 1;
        }

        // initialise first column
        for(int j = 0; j < matrix.length; j++){
            matrix[j][0] = 1;
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] +" ");

                if(j == matrix[i].length -1) {
                    System.out.println();
                }
            }
        }

        return matrix[matrix.length - 1][matrix[matrix.length - 1].length-1];
    }

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        int[] candies = new int[n];
       candies[0] = 1;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] <= arr[i-1]){
                candies[i] = 1;
            }else if(arr[i] > arr[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        for(int i = arr.length - 2; i >= 0; i--){
            if(arr[i] <= arr[i+1]){
                candies[i] = 1;
            }else if(arr[i] > arr[i+1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        int sum = 0;

        for(int c : candies){
            sum += c;
        }
        return sum;
    }

    public List<String> letterCombinations(String digits) {

        if(digits.length() == 0){
            return new ArrayList<>();
        }

        char[] numbers = digits.toCharArray();

        HashMap<Character, char[]> bindings = new HashMap<>();
        bindings.put('2', new char[] {'a', 'b', 'c'});
        bindings.put('3', new char[] {'d', 'e', 'f'});
        bindings.put('4', new char[] {'g', 'h', 'i'});
        bindings.put('5', new char[] {'j', 'k', 'l'});
        bindings.put('6', new char[] {'m', 'n', 'o'});
        bindings.put('7', new char[] {'p', 'q', 'r', 's'});
        bindings.put('8', new char[] {'t', 'u', 'v'});
        bindings.put('9', new char[] {'w', 'x', 'y', 'z'});

        String combination;

        for(char c : bindings.get(numbers[0])){
            combination = String.valueOf(c);
            combinations(numbers, bindings, combination);
        }

        return res;
    }


    List<String> res = new ArrayList<>();
    private  List<String> combinations(char[] numbers, HashMap<Character,char[]> bindings, String combination){


        if(combination.length() == numbers.length){
            res.add(combination);
            return res;
        }

        for(char letter : bindings.get(numbers[combination.length()])){
            res = combinations(numbers,bindings, combination+letter);
        }


        return res;
    }

    static long countTriplets(List<Long> arr, long r) {
        long triplets = 0;
        HashMap<Long,List<Long>> map = new HashMap<>();

        for(Long l : arr){
            List<Long> progression = new ArrayList<>();
            progression.add(l*r);
            progression.add(l*r*r);

            // store number of occurrences of keys
            if(map.get(l) != null){
                progression.add(map.get(l).get(2) + 1);
            }else{
                progression.add(1L);
            }

            map.put(l,progression);
        }

        for(Long k : map.keySet()){
            if(arr.contains(map.get(k).get(0)) && arr.contains(map.get(k).get(1))){
                long duplicates = map.get(k).get(2);
                triplets += (occurrences(arr,map.get(k).get(0)) * occurrences(arr,map.get(k).get(1))) * duplicates;
            }
        }
        return triplets;
    }

    private static long occurrences(List<Long> arr, long n){
        int count = 0;

        for(long l : arr){
            if(l == n){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Long> arr = new ArrayList<>();
        arr.add(1L);
        arr.add(2L);
        arr.add(2L);
        arr.add(4L);
        System.out.println(countTriplets(arr,2));
    }
}
