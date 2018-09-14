package XCache;

import java.util.LinkedList;

/**
 * Created by xi on 1/25/18.
 */


public interface EvictionStrategy<K, V> {
    /**
     * update the state of the entry got hit and store the entry placed.
     *
     * @param currentStore is the list where the entry placed.
     * @param hitEntry is the entry that was found in the store.
     *
     */
    void updateEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> hitEntry);

    /**
     * put the entry into the store when the store is not full.
     *
     * @param currentStore is the list where the entry need to add in.
     * @param toAdd is the entry that need to add.
     *
     */
    void putEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> toAdd);

    /**
     * when the store is full, replace one entry in the list by the entry need to add in.
     *
     * @param currentStore is the list where the entry need to add in.
     * @param toAdd is the entry that need to add.
     *
     */
    void replaceEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> toAdd);

}
