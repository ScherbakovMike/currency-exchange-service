package ru.mikescherbakov.currencyexchangeservice;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name="exchange_value")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class ExchangeValue {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="currency_from")
    private String from;
    @Column(name="currency_to")
    private String to;
    @Column(name="conversion_multiple")
    private BigDecimal conversionMultiple;
    @Setter
    @Column(name="port")
    private int port;

}
