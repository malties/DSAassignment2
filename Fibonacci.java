import java.math.BigInteger;

public class Fibonacci {
    public static long memory[] = new long[45];
    // A naive implementation
    public static BigInteger fib1(int n) {
        if (n <= 1)
            return BigInteger.ONE;
        return fib1(n - 1).add(fib1(n - 2));
    }


    public int fib2(int j) {
        //this was with it also idk man
        return fib(j, new int[j+1]);
    }

    public int fib(int n, int[] memory) {
        //cause its the fuckin same always waste of computation
        if (n == 0 || n == 1) {
            return n;
        }
        //i'm not sure about this one i copied it from the net
        if (memory[n] == 0) {
            memory[n] = fib(n - 1, memory) + fib(n - 2, memory);
        }
        return memory[n];
    }

    public static int fibonacci(int n){
        return fibonacci(n, new int[n + 1]);
    }

    public static int fibonacci(int i, int[] memo) {

        if (i == 0 || i == 1) {
            return i;
        }

        if (memo[i] == 0) {
            memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
        }
        return memo[i];
    }

    public static BigInteger fibitup(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        }
        BigInteger[] array = new BigInteger[n];
        return recursiveMethod(n, array);
    }

    public static BigInteger recursiveMethod(int n, BigInteger[] array) {
        if (array[n - 1] != null) {
            return array[n - 1];
        }
        if (n <= 2) {
            return array[n - 1] = BigInteger.ONE;
        }
        return array[n - 1] = recursiveMethod(n - 1, array).add(recursiveMethod(n - 2, array));
    }











    public int fib2electricboogalo(int n) {//O(N) i believe
        int memory2electricboogaloo[] = new int[n + 2];//declare an array to store fib no.s
        int j;//i was being used in the main for some fucking reason
        memory2electricboogaloo[0] = 0; //store these no.s cause they the same always its a waste of processing time
        memory2electricboogaloo[1] = 1;
        if (n == 0 || n == 1) {//no need to calculate these values just return them
            return n;
        }if (n >= 2) {//if n is 2 or greater we need to make and store our calculations
            for (j = 2; j <= n; j++) {//this is wrong no recursion is happening here
                //start from 2, we already know what 0 and 1 will be
                //add previous 2 no.s and store it
                memory2electricboogaloo[j] = memory2electricboogaloo[j - 1] + memory2electricboogaloo[j - 2];
            }
        }return memory2electricboogaloo[n];
    }








    public static void main(String[] args) {
     for (int i = 0; i < 201; i++) {
           System.out.println("{ (" + i + "), (" + fibitup(i) + ") }");



        }
    }}
