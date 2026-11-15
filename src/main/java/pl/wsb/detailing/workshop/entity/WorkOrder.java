package pl.wsb.detailing.workshop.entity;

import jakarta.persistence.*;
import pl.wsb.detailing.account.domain.UserAccount;
import pl.wsb.detailing.customer.entity.Vehicle;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/** Zlecenie: auto klienta przyjęte na stanowisko w danym terminie, z listą usług z cennika. */
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

    // które auto: wiele zleceń → jedno auto (klienta znamy przez auto)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    // detailer prowadzący zlecenie (konto pracownika); puste, dopóki nikt go nie przejął
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private UserAccount assignedTo;

    // pozycje zlecenia: drugi koniec relacji WorkOrderItem.workOrder
    @OneToMany(mappedBy = "workOrder")
    private List<WorkOrderItem> items = new ArrayList<>();

    protected WorkOrder() {
    }

    public WorkOrder(String orderNumber, WorkOrderStatus status, Integer bayNumber, BigDecimal totalPrice,
                     BigDecimal deposit, String notes, TimeSlot slot, Vehicle vehicle, UserAccount assignedTo) {
        this.orderNumber = orderNumber;
        this.status = status;
        this.bayNumber = bayNumber;
        this.totalPrice = totalPrice;
        this.deposit = deposit;
        this.notes = notes;
        this.slot = slot;
        this.vehicle = vehicle;
        this.assignedTo = assignedTo;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public UserAccount getAssignedTo() {
        return assignedTo;
    }

    public List<WorkOrderItem> getItems() {
        return items;
    }
}
