package pl.camp.micro.book.store.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CleanCacheAfterTransactionUpdatedListener {

    @EventListener
    public void on(TransactionUpdatedEvent event) {
        log.info("Clean cache {}", event.getTransactionDto());
    }
}
