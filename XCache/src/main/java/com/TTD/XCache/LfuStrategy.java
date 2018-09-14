package XCache;

import java.util.LinkedList;

/**
 * Created by xi on 1/28/18.
 */
public class LfuStrategy<K, V> implements EvictionStrategy<K, V> {
    @Override
    public void updateEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> hitEntry){
        hitEntry.updateAccessStatistics();
    }
    @Override
    public void putEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> toAdd){

        addEntryByLFU(currentStore,toAdd);
    }
    @Override
    public void replaceEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> toAdd){
        CacheEntry<K,V> toBeReplacedEntry = replacedEntryByStrategy(currentStore,toAdd);
        addEntryByLFU(currentStore,toBeReplacedEntry);
    }

    private void addEntryByLFU(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> toAdd) {
        currentStore.addLast(toAdd);
    }
    private CacheEntry<K, V> replacedEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> toAdd) {
        if (currentStore.size() == 1) {
            return currentStore.get(0);
        }
        CacheEntry<K, V> leastFrequentEntry = null;
        for (CacheEntry<K, V> entry : currentStore) {
            if(leastFrequentEntry == null) {
                leastFrequentEntry = entry;
                continue;
            }
            if(compare(leastFrequentEntry, entry)) {
                leastFrequentEntry = entry;
            }
        }
        return leastFrequentEntry;
    }

    private boolean compare(CacheEntry<K, V> entry1, CacheEntry<K, V> entry2) {
        return entry1.getHitCount() > entry2.getHitCount();
    }
}
