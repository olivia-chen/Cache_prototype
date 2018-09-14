package XCache;

import java.util.LinkedList;

/**
 * Created by xi on 1/24/18.
 */
public class CacheStore<K, V>{
    /**
     * the capacity of one cache set.
     */
    private final int capacity;

    /**
     * store the cache entry in the linked list.
     */
    private final LinkedList<CacheEntry<K,V>> store;

    /**
     * Constructs the cache set.
     *
     * @param numberOfWays the set has.
     *
     */
    public CacheStore(int numberOfWays) {
        this.capacity = numberOfWays;
        this.store = new LinkedList<>();
    }

    /**
     * get the store as the linked list.
     * @return LinkedList
     *
     */
    public LinkedList<CacheEntry<K,V>> getStoreList(){
        return store;
    }

    /**
     * get the capacity(ways/lines) of the store.
     * @return integer
     *
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * get the entry in the store, return null if not exist;
     *
     * @param key
     * @return CacheEntry
     *
     */
    public CacheEntry<K, V> getEntry(K key){
        if (key != null) {
            for (CacheEntry<K, V> entry : store) {
                if (key.equals(entry.getKey())) {
                    return entry;
                }
            }
        }
        return null;
    }

    /**
     * check whether the store reaches the max limit capacity.
     * @return true if max limit hits, otherwise false
     *
     */
    public boolean isFull() {
        return store.size() >= getCapacity();
    }

    /**
     * check whether the store contains the key
     * @param currentStore
     * @param key
     *
     * @return true if contains, otherwise false
     */
    public boolean containsKey(CacheStore<K,V> currentStore, K key) {
        for(CacheEntry<K, V> currentEntry : currentStore.getStoreList()){
            if (key.equals(currentEntry.getKey())) {
                return true;
            }
        }
        return false;
    }

    /**
     * remove the entry from the store list with the key and value given
     * @return true if remove successfully, otherwise false
     */
    public Boolean removeEntry(CacheEntry<K, V> entry) {
        return store.remove(entry);
    }

    /**
     * remove the entry from the store list with the key given
     * @return true if remove successfully, otherwise false
     */
    public boolean removeEntryByKey(CacheStore<K,V> currentStore, K key) {
        for(CacheEntry<K, V> currentEntry : currentStore.getStoreList()){
            if (key.equals(currentEntry.getKey())) {
                return currentStore.removeEntry(currentEntry);
            }
        }
        return false;
    }

    public void printEntry(CacheStore<K, V> eachStore){
        for(CacheEntry<K, V> entry : eachStore.getStoreList()) {
            System.out.println("key: " + entry.getKey() + "; value: " + entry.getValue());
        }
    }

}
