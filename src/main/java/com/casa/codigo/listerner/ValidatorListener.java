package com.casa.codigo.listerner;

import com.casa.codigo.dto.ShopStatusDto;
import com.casa.codigo.repository.ShopReportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ValidatorListener {

    private final ShopReportRepository repository;

    @Transactional
    @KafkaListener(topics = "${topic.shop.status}", groupId = "group-report")
    public void listenStatusTopic(ShopStatusDto dto) {
        try {
            log.info("Status da compra {} recebida no tópico.", dto.getIdentifier());
            repository.incrementShopStatus(dto.getStatus());
        } catch (Exception e) {
            log.error("Erro no processamento da compra {}: {}", dto.getIdentifier(), e.getMessage());
        }
    }
}
