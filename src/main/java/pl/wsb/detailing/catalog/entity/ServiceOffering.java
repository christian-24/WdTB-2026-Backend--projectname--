package pl.wsb.detailing.catalog.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

/** Pozycja cennika: usługa, którą studio wykonuje. */
@Entity
@Table(name = "service_offering")
public class ServiceOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 80)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 20)
    private ServiceCategory category;

    @Column(name = "base_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal basePrice;

    @Column(name = "duration_minutes", nullable = false)
    private Integer durationMinutes;

    @Column(name = "warranty_months")
    private Integer warrantyMonths;

    @Column(name = "active", nullable = false)
    private Boolean active;

    protected ServiceOffering() {
    }

    public ServiceOffering(String name, ServiceCategory category, BigDecimal basePrice, Integer durationMinutes,
                           Integer warrantyMonths, Boolean active) {
        this.name = name;
        this.category = category;
        this.basePrice = basePrice;
        this.durationMinutes = durationMinutes;
        this.warrantyMonths = warrantyMonths;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ServiceCategory getCategory() {
        return category;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public Integer getWarrantyMonths() {
        return warrantyMonths;
    }

    public Boolean getActive() {
        return active;
    }
}
