package XCache;

import java.util.ArrayList;

/**
 * Created by xi on 1/24/18.
 */
public class XCache<K, V> implements Cache<K, V>{
    private static final int DEFAULT_WAYS = 2;
    private static final int DEFAULT_SETS = 1;
    private final int numberOfSets;
    private final int numberOfWays;
    private final ArrayList<CacheStore> xCache;
    /**
     * the replacement strategy to use.
     */
    private EvictionStrategy<K,V> strategy;

    /**
     * Constructor.
     * @param numberOfSets number of sets or the size of the cache
     * @param numberOfWays N-Way cache.
     * @param strategy the replacment strategy the cache will apply when the capacity reach max limit.
     */

    public XCache(int numberOfSets, int numberOfWays, EvictionStrategy strategy) {
        this.numberOfSets = numberOfSets;
        this.numberOfWays = numberOfWays;
        this.xCache = new ArrayList<>(numberOfSets);
        this.strategy = strategy;
        for (int i = 0; i < numberOfSets; i++){
            this.xCache.add(new CacheStore(numberOfWays));
        }
    }

    public XCache() {
        this(DEFAULT_SETS, DEFAULT_WAYS, new LruStrategy());
    }

    public XCache(int numberOfSets, int numberOfWays) {
        this(numberOfSets, numberOfWays, new LruStrategy());
    }

    public XCache(EvictionStrategy strategy) {
        this(DEFAULT_SETS, DEFAULT_WAYS, strategy);
    }

    @Override
    public V get(K key){
        CacheStore<K, V> store = getStore(key);
        CacheEntry<K, V> entry = store.getEntry(key);
        if(entry != null) {
            strategy.updateEntryByStrategy(store.getStoreList(), entry);
        }
        return entry != null ? entry.getValue() : null;
    }

    @Override
    public void put(K key, V value){
        if(containsKey(key)) {
            remove(key);
        }
        CacheStore<K, V> store = getStore(key);
        CacheEntry<K, V> entry = new CacheEntry<>(key, value);
        if(store.isFull()){
            strategy.replaceEntryByStrategy(store.getStoreList(), entry);
        }else {
            strategy.putEntryByStrategy(store.getStoreList(), entry);
        }
    }

    @Override
    public boolean containsKey(K key){
        CacheStore<K, V> store = getStore(key);
        return store.containsKey(store, key);
    }

    @Override
    public void remove(K key){
        CacheStore<K, V> store = getStore(key);
        store.removeEntryByKey(store,key);
    }

    public CacheStore<K, V> getStore(K key) {
        int index = Math.abs(key.hashCode()) % numberOfSets;
        return xCache.get(index);
    }

    public void printAll(){
        for(CacheStore<K, V> eachStore : xCache) {
            System.out.println("new set");
            eachStore.printEntry(eachStore);
        }
    }

    /**
     * Sets the strategy. Use this method to inject a custom strategy. This can be done while the store is alive.
     *
     * @param strategy a new strategy to be used in evicting elements in this store
     */
    public void setEvictionStrategy(EvictionStrategy<K, V> strategy) {
        this.strategy = strategy;
    }


}
