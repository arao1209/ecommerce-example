package com.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class CacheUtil {

    @Autowired
    private CacheManager cacheManager;

    public void evictAllCacheValue(String cacheName){
        cacheManager.getCache(cacheName).clear();
    }

}
