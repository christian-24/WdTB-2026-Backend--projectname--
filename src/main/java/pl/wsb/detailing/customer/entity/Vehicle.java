package pl.wsb.detailing.customer.entity;

import jakarta.persistence.*;

/** Auto klienta. Jeden klient (np. firma z flotą) może mieć wiele aut. */
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "plate_number", nullable = false, unique = true, length = 12)
    private String plateNumber;

    @Column(name = "make", nullable = false, length = 40)
    private String make;

    @Column(name = "model", nullable = false, length = 40)
    private String model;

    @Column(name = "production_year")
    private Integer productionYear;

    @Column(name = "color", length = 30)
    private String color;

    // właściciel auta: wiele aut → jeden klient
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    protected Vehicle() {
    }

    public Vehicle(String plateNumber, String make, String model, Integer productionYear, String color, Customer customer) {
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.productionYear = productionYear;
        this.color = color;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public String getColor() {
        return color;
    }

    public Customer getCustomer() {
        return customer;
    }
}
