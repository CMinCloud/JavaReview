package redis;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

    private final int CACHE_SIZE;

    /**
     * 最多能缓存多少数据
     */

    public LRUCache(int cacheSize) {
//       true表示让linkedHashMap按照访问顺序来进行排序，最近访问的放在头部
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
//        当前数据量大于最大缓存个数时，进行清除
        return size() > CACHE_SIZE;
    }
}
