package com.flight.flightapp.cache;

import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ExpiringCache<K, V> {

    private Map<K, ExpiringElement> cache;

    public ExpiringCache() {
        cache = new HashMap<>();
    }

    public void add(K key, V value, int ttlSec) {
        cache.put(key, elementOf(value, ttlSec));
    }

    private ExpiringElement elementOf(V value, int ttlSec) {
        long currentTimeMillis = System.currentTimeMillis();
        long ttlMillis = TimeUnit.SECONDS.toMillis(ttlSec);
        return ExpiringElement.builder().value(value).ttl(currentTimeMillis + ttlMillis).build();
    }

    public boolean contains(K key) {
        return cache.containsKey(key) &&
                !isExpired(cache.get(key));
    }

    public V get(K key) {
        ExpiringElement<V> expiringElement = cache.get(key);
        if (expiringElement == null || isExpired(expiringElement)) {
            cache.remove(key);
            return null;
        }
        else {
            return expiringElement.getValue();
        }
    }

    private boolean isExpired(ExpiringElement<V> expiringElement) {
        long currentTime = System.currentTimeMillis();
        return currentTime > expiringElement.getTtl();
    }

    public void clear() {
        cache.clear();
    }

    @Builder
    @Data
    private static class ExpiringElement<V> {
        private V value;
        private long ttl;
    }
}
