import java.util.*;

class GFG {
    // Function that keeps all
    // the odd power numbers upto n
    static long powerNumbers(int n) {
        HashSet<Long> v = new HashSet<Long>();
        for (long i = 2; i * i * i <= n; i++) {
            long j = i * i;
            while (j * i <= n) {
                j *= i;

                // We need exclude
                // perfect squares.
                long s = (long) Math.sqrt(j);
                if (s * s != j)
                    v.add(j);
            }
        }
        // sort the vector
        // v.Sort();
        // v.erase(unique(v.begin(),
        // v.end()), v.end());

        // Return sum of odd
        // and even powers.
        return v.size() + (long) Math.sqrt(n);
    }

    // Driver Code
    public static void main(String args[]) {
        System.out.print(powerNumbers(50));
    }
}
