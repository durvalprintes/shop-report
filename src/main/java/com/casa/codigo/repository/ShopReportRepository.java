package com.casa.codigo.repository;

import com.casa.codigo.constants.Status;
import com.casa.codigo.model.ShopReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ShopReportRepository extends JpaRepository<ShopReport, Long> {

    @Modifying
    @Query("update ShopReport s set s.amount = s.amount + 1 where s.status = ?1")
    void incrementShopStatus(Status status);

}
