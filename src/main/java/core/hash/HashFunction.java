package core.hash;

public class HashFunction {
    public int stringHash(String key) {
        int hash = 0;
        for (char c : key.toCharArray()) {
            hash = (hash * 31 + c) % 10007;
        }
        return hash;
    }
}
