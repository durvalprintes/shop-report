package com.casa.codigo.model;

import com.casa.codigo.constants.Status;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ShopReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Integer amount;

}
