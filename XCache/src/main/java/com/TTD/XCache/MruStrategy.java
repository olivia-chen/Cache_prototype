package XCache;

import java.util.LinkedList;

/**
 * Created by xi on 1/25/18.
 */
public class MruStrategy<K, V> implements EvictionStrategy<K, V> {
    @Override
    public void updateEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> hitEntry){
        currentStore.remove(hitEntry);
        addEntryByMRU(currentStore,hitEntry);
    }
    @Override
    public void putEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> toAdd){
        addEntryByMRU(currentStore,toAdd);
    }
    @Override
    public void replaceEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> toAdd){
        currentStore.removeFirst();
        addEntryByMRU(currentStore,toAdd);
    }

    private void addEntryByMRU(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> toAdd) {
        currentStore.addFirst(toAdd);
    }

}


