package projecteuler.app;

// Class that represents a prime power of a number, i.e. p^e
public class PrimePower {
    public long prime;   // The prime.
    public int exp;      // The exponent.

    public PrimePower(long p, int e) {
        prime = p;
        exp = e;
    }
}
