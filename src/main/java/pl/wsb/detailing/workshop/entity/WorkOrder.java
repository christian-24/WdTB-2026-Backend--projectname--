package pl.wsb.detailing.workshop.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

/**
 * Zlecenie: auto klienta przyjęte na stanowisko w danym terminie.
 * Klient, auto i usługi dojdą jako relacje na LAB 03.
 */
@Entity
@Table(name = "work_order")
public class WorkOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_number", nullable = false, unique = true, length = 20)
    private String orderNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private WorkOrderStatus status;

    @Column(name = "bay_number", nullable = false)
    private Integer bayNumber;

    @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "deposit", precision = 10, scale = 2)
    private BigDecimal deposit;

    @Column(name = "notes", length = 255)
    private String notes;

    @Embedded
    private TimeSlot slot;

    protected WorkOrder() {
    }

    public WorkOrder(String orderNumber, WorkOrderStatus status, Integer bayNumber, BigDecimal totalPrice,
                     BigDecimal deposit, String notes, TimeSlot slot) {
        this.orderNumber = orderNumber;
        this.status = status;
        this.bayNumber = bayNumber;
        this.totalPrice = totalPrice;
        this.deposit = deposit;
        this.notes = notes;
        this.slot = slot;
    }

    public Long getId() {
        return id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public WorkOrderStatus getStatus() {
        return status;
    }

    public Integer getBayNumber() {
        return bayNumber;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public String getNotes() {
        return notes;
    }

    public TimeSlot getSlot() {
        return slot;
    }
}
