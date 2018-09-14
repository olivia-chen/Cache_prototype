package XCache;

/**
 * Created by xi on 1/24/18.
 */
public interface Cache<K, V> {
    /**
     * Retrieves the value currently mapped to the provided key.
     *
     * @param key the key, may not be {@code null}
     * @return the value mapped to the key, {@code null} if none
     *
     * @throws NullPointerException if the provided key is {@code null}
     */
    V get(K key);

    /**
     * Associates the given value to the given key in this {@code Cache};
     * If the key already exists in the cache, remove it from the cache first, then put the new <key, value> in.
     *
     * @param key the key, may not be {@code null}
     * @param value the value, may not be {@code null}
     *
     * @throws NullPointerException if the provided key is {@code null}
     */
    void put(K key, V value);

    /**
     * Checks whether a mapping for the given key is present, without retrieving the associated value.
     *
     * @param key the key, may not be {@code null}
     * @return {@code true} if a mapping is present, {@code false} otherwise
     *
     * @throws NullPointerException if the provided key is {@code null}
     */
    boolean containsKey(K key);

    /**
     * Removes the value, if any, associated with the provided key.
     *
     * @param key the key to remove the value for, may not be {@code null}
     *
     * @throws NullPointerException if the provided key is {@code null}
     */
    void remove(K key);

    /**
     * Removes all mappings currently present in the {@code Cache}.
     */

}
