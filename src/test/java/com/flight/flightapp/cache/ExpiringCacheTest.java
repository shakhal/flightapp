package com.flight.flightapp.cache;

import org.junit.Before;
import org.junit.Test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExpiringCacheTest {

    public static final String VALUE = "MY DUMMY VALUE";
    public static final String KEY = "DUMMY";
    private ExpiringCache<String, String> cache = new ExpiringCache<>();

    @Before
    public void before() {
        cache.clear();
    }

    @Test
    public void shouldGetNonExpiredValueFromCache() {
        cache.add(KEY, VALUE, 1);
        assertThat(cache.get(KEY), is(VALUE));
    }

    @Test
    public void shouldReturnNullForExpiredValue() {
        cache.add(KEY, VALUE, 1);
        await().atMost(2, SECONDS).until(()-> cache.get(KEY) == null);
    }

}
