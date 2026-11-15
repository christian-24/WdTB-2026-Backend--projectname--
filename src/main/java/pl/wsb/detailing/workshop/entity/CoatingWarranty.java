package pl.wsb.detailing.workshop.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

/** Certyfikat gwarancji powłoki ceramicznej albo folii PPF: jedno zlecenie → najwyżej jedna gwarancja. */
@Entity
@Table(name = "coating_warranty")
public class CoatingWarranty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "certificate_number", nullable = false, unique = true, length = 20)
    private String certificateNumber;

    @Column(name = "product_name", nullable = false, length = 80)
    private String productName;

    @Column(name = "valid_from", nullable = false)
    private LocalDate validFrom;

    @Column(name = "valid_until", nullable = false)
    private LocalDate validUntil;

    // kiedy klient ma przyjechać na przegląd, inaczej gwarancja wygasa
    @Column(name = "next_inspection_on", nullable = false)
    private LocalDate nextInspectionOn;

    // zlecenie, przy którym nałożono powłokę: jeden do jednego
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "work_order_id", nullable = false, unique = true)
    private WorkOrder workOrder;

    protected CoatingWarranty() {
    }

    public CoatingWarranty(String certificateNumber, String productName, LocalDate validFrom, LocalDate validUntil,
                           LocalDate nextInspectionOn, WorkOrder workOrder) {
        this.certificateNumber = certificateNumber;
        this.productName = productName;
        this.validFrom = validFrom;
        this.validUntil = validUntil;
        this.nextInspectionOn = nextInspectionOn;
        this.workOrder = workOrder;
    }

    public Long getId() {
        return id;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public String getProductName() {
        return productName;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public LocalDate getNextInspectionOn() {
        return nextInspectionOn;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }
}
