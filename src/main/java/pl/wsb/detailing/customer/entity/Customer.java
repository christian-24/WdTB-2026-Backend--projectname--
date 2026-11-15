package pl.wsb.detailing.customer.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Klient studia: osoba prywatna albo firma z flotą aut. */
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false, length = 80)
    private String fullName;

    @Column(name = "company_name", length = 100)
    private String companyName;

    @Enumerated(EnumType.STRING)
    @Column(name = "source", nullable = false, length = 20)
    private CustomerSource source;

    @Column(name = "registered_on", nullable = false)
    private LocalDate registeredOn;

    @Column(name = "marketing_consent", nullable = false)
    private Boolean marketingConsent;

    @Embedded
    private ContactInfo contact;

    // auta klienta: drugi koniec relacji Vehicle.customer (nie tworzy kolumny)
    @OneToMany(mappedBy = "customer")
    private List<Vehicle> vehicles = new ArrayList<>();

    // historia kontaktów: drugi koniec relacji CustomerContact.customer
    @OneToMany(mappedBy = "customer")
    private List<CustomerContact> contacts = new ArrayList<>();

    protected Customer() {
    }

    public Customer(String fullName, String companyName, CustomerSource source, LocalDate registeredOn,
                    Boolean marketingConsent, ContactInfo contact) {
        this.fullName = fullName;
        this.companyName = companyName;
        this.source = source;
        this.registeredOn = registeredOn;
        this.marketingConsent = marketingConsent;
        this.contact = contact;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public CustomerSource getSource() {
        return source;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public Boolean getMarketingConsent() {
        return marketingConsent;
    }

    public ContactInfo getContact() {
        return contact;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<CustomerContact> getContacts() {
        return contacts;
    }
}
