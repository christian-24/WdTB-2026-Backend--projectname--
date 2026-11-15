package pl.wsb.detailing.workshop.entity;

import jakarta.persistence.*;
import pl.wsb.detailing.catalog.entity.ServiceOffering;

import java.math.BigDecimal;

/**
 * Pozycja zlecenia: tabela łącząca wiele-do-wielu zlecenie ↔ usługa z cennika.
 * Para ma własne dane (ilość, cena w chwili przyjęcia, rabat), dlatego jest osobną encją.
 */
@Entity
@Table(name = "work_order_item")
public class WorkOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // którego zlecenia dotyczy pozycja
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "work_order_id", nullable = false)
    private WorkOrder workOrder;

    // która usługa z cennika
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_offering_id", nullable = false)
    private ServiceOffering serviceOffering;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    // cena z chwili przyjęcia zlecenia; cennik może się później zmienić
    @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "discount_percent", nullable = false)
    private Integer discountPercent;

    protected WorkOrderItem() {
    }

    public WorkOrderItem(WorkOrder workOrder, ServiceOffering serviceOffering, Integer quantity, BigDecimal unitPrice,
                         Integer discountPercent) {
        this.workOrder = workOrder;
        this.serviceOffering = serviceOffering;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.discountPercent = discountPercent;
    }

    public Long getId() {
        return id;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public ServiceOffering getServiceOffering() {
        return serviceOffering;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }
}
