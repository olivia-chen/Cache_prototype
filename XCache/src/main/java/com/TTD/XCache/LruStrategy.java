package XCache;

import java.util.LinkedList;

/**
 * Created by xi on 1/25/18.
 */
public class LruStrategy<K, V> implements EvictionStrategy<K, V> {
    @Override
    public void updateEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> hitEntry){
        currentStore.remove(hitEntry);
        addEntryByLRU(currentStore,hitEntry);
    }
    @Override
    public void putEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> toAdd){
        addEntryByLRU(currentStore,toAdd);
    }
    @Override
    public void replaceEntryByStrategy(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> toAdd){
        currentStore.removeLast();
        addEntryByLRU(currentStore,toAdd);
    }

    private void addEntryByLRU(LinkedList<CacheEntry<K, V>> currentStore, CacheEntry<K, V> toAdd) {
        currentStore.addFirst(toAdd);
    }
}