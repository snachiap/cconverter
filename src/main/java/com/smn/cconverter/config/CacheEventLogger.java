package com.smn.cconverter.config;

import com.smn.cconverter.dto.ExchangeRateResponse;
import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

@Slf4j
public class CacheEventLogger
        implements CacheEventListener<String, ExchangeRateResponse> {

    @Override
    public void onEvent(CacheEvent<? extends String, ? extends ExchangeRateResponse> cacheEvent) {
        log.info("Cache event {} for item with key {}.", cacheEvent.getType(), cacheEvent.getKey());
    }
}