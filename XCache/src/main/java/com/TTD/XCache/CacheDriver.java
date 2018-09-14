package XCache;


public class CacheDriver {
    public static void main(String[] args) {
        //2 sets, 2-way set associative cache
        XCache<Integer, String> xCache = new XCache(2,2);
        xCache.setEvictionStrategy(new LruStrategy<Integer, String>());
        xCache.put(1,"1");
        xCache.put(2,"2");
        xCache.put(3,"3");
        System.out.println(xCache.get(1));
        xCache.put(5,"4");
        xCache.put(4,"2");
       // xCache.put(2,"5");
       xCache.put(6,"6");
        System.out.println(xCache.get(6));
//        System.out.println(xCache.get(4));
       //xCache.put(8,"6");

        xCache.printAll();
    }
}
