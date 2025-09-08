
import java.io.*;
import java.util.*;

public class Main implements Runnable {

    // -------------------- Write your solution here --------------------
    void solve() throws Exception {
        
    }

    // -------------------- Config --------------------
    static final boolean DEBUG = false;
    static final long MOD = 1_000_000_007L;
    // ------------------------------------------------

    FastScanner fs;
    PrintWriter out;

    public static void main(String[] args) {
        new Thread(null, new Main(), "cp", 1 << 26).start();
    }

    @Override
    public void run() {
        try {
            fs  = new FastScanner(System.in);
            out = new PrintWriter(new BufferedOutputStream(System.out));
            solve();
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // -------------------- Fast Scanner --------------------
    static final class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        private int skip() throws IOException {
            int c;
            while ((c = read()) <= 32) {
                if (c == -1) return -1;
            }
            return c;
        }
        String next() throws IOException {
            int c = skip();
            if (c == -1) return null;
            StringBuilder sb = new StringBuilder();
            do {
                sb.append((char) c);
                c = read();
            } while (c > 32);
            return sb.toString();
        }
        String nextLine() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c = read()) != -1 && c != '\n') {
                if (c == '\r') continue;
                sb.append((char) c);
            }
            return sb.length() == 0 && c == -1 ? null : sb.toString();
        }
        int nextInt() throws IOException {
            int c = skip(), sgn = 1;
            if (c == '-') { sgn = -1; c = read(); }
            int val = 0;
            while (c > 32) { val = val * 10 + (c - '0'); c = read(); }
            return val * sgn;
        }
        long nextLong() throws IOException {
            int c = skip(), sgn = 1;
            if (c == '-') { sgn = -1; c = read(); }
            long val = 0;
            while (c > 32) { val = val * 10 + (c - '0'); c = read(); }
            return val * sgn;
        }
        double nextDouble() throws IOException { return Double.parseDouble(next()); }
        int[] readIntArray(int n) throws IOException { int[] a = new int[n]; for (int i = 0; i < n; i++) a[i] = nextInt(); return a; }
        long[] readLongArray(int n) throws IOException { long[] a = new long[n]; for (int i = 0; i < n; i++) a[i] = nextLong(); return a; }
    }

    // -------------------- Utilities --------------------
    static long gcd(long a, long b) { while (b != 0) { long t = a % b; a = b; b = t; } return Math.abs(a); }
    static long lcm(long a, long b) { return a / gcd(a, b) * b; }
    static long addMod(long a, long b, long m) { a += b; if (a >= m) a -= m; return a; }
    static long subMod(long a, long b, long m) { a -= b; if (a < 0) a += m; return a; }
    static long mulMod(long a, long b, long m) { return (a % m) * (b % m) % m; }
    static long powMod(long a, long e, long m) { a %= m; long r = 1; while (e > 0) { if ((e & 1) == 1) r = (r * a) % m; a = (a * a) % m; e >>= 1; } return r; }

    static boolean[] sieve(int n, List<Integer> primesOut) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        if (n >= 0) prime[0] = false;
        if (n >= 1) prime[1] = false;
        for (int p = 2; p * p <= n; p++) if (prime[p]) { for (int q = p * p; q <= n; q += p) prime[q] = false; }
        if (primesOut != null) for (int i = 2; i <= n; i++) if (prime[i]) primesOut.add(i);
        return prime;
    }

    static final class Pair implements Comparable<Pair> {
        int a, b;
        Pair(int a, int b) { this.a = a; this.b = b; }
        public int compareTo(Pair o) { return a != o.a ? Integer.compare(a, o.a) : Integer.compare(b, o.b); }
        public String toString() { return "(" + a + "," + b + ")"; }
    }
    static final class LPair implements Comparable<LPair> {
        long a, b;
        LPair(long a, long b) { this.a = a; this.b = b; }
        public int compareTo(LPair o) { return a != o.a ? Long.compare(a, o.a) : Long.compare(b, o.b); }
        public String toString() { return "(" + a + "," + b + ")"; }
    }

    static final class DSU {
        int n; int[] p, sz;
        DSU(int n) { this.n = n; p = new int[n]; sz = new int[n]; for (int i = 0; i < n; i++) { p[i] = i; sz[i] = 1; } }
        int find(int x) { while (x != p[x]) { p[x] = p[p[x]]; x = p[x]; } return x; }
        boolean union(int a, int b) { a = find(a); b = find(b); if (a == b) return false; if (sz[a] < sz[b]) { int t = a; a = b; b = t; } p[b] = a; sz[a] += sz[b]; return true; }
    }

    static void dbg(Object... o) { if (DEBUG) System.err.println(Arrays.deepToString(o)); }
}
