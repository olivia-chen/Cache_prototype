package XCache;

/**
 * Created by xi on 1/26/18.
 */
public class CacheEntry<K, V> {

    /**
     * the cache key.
     */
    private final K key;

    /**
     * the value associated to the key.
     */
    private V value;

    /**
     * The number of times the entry was hit.
     */
    private long hitCount;

    /**
     * The creation time.
     */
    private long creationTime;

    /**
     * The last access time.
     */
    private long lastAccessTime;

    /**
     * Constructs the cache entry.
     *
     * @param key
     * @param value
     */
    public CacheEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.creationTime = System.currentTimeMillis();
        this.hitCount = 0;
    }

    /**
     * Gets the key attribute of the CacheEntry object.
     *
     * @return the key
     */
    public K getKey() {
        return key;
    }

    /**
     * Gets the value attribute of the CacheEntry object.
     *
     *  @return the value
     */
    public V getValue() {
        return value;
    }

    /**
     * Gets the creationTime attribute of the CacheEntry object.
     *
     * @return the creationTime value
     */
    public final long getCreationTime() {
        return creationTime;
    }

    /**
     * Gets the lastAccessTime attribute of the CacheEntry object.
     *
     * @return the creationTime value
     */
    public final long getLastAccessTime() {
        return creationTime;
    }

    /**
     * Gets the hit count on this entry.
     *
     * @return the hitCount value
     */
    public final long getHitCount() {
        return hitCount;
    }

    /**
     * Resets the hit count to 0 and the last access time to 0.
     */
    public final void resetAccessStatistics() {
        lastAccessTime = 0;
        hitCount = 0;
    }

    /**
     * Sets the last access time to now;
     * accumulate the count of the hit number
     */
    public final void updateAccessStatistics() {
        lastAccessTime = System.currentTimeMillis();
        hitCount++;
    }


    /**
     * Equals comparison with another entry, based on the key.
     */
    @Override
    public final boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        CacheEntry other = (CacheEntry) object;
        return ((key == null) ? (other.key == null) : key.equals(other.key));
    }

    /**
     * Gets the hashcode, based on the key.
     */
    @Override
    public final int hashCode() {
        return key.hashCode();
    }


}
