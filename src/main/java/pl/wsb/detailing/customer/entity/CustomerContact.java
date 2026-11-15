package pl.wsb.detailing.customer.entity;

import jakarta.persistence.*;
import pl.wsb.detailing.account.domain.UserAccount;

import java.time.LocalDate;
import java.time.LocalDateTime;

/** Historia kontaktów z klientem: telefon, mail, SMS. Podstawa CRM i przypomnień (LAB 06). */
@Entity
@Table(name = "customer_contact")
public class CustomerContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contacted_at", nullable = false)
    private LocalDateTime contactedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "channel", nullable = false, length = 20)
    private ContactChannel channel;

    @Column(name = "subject", nullable = false, length = 120)
    private String subject;

    @Column(name = "note", length = 500)
    private String note;

    // kiedy odezwać się ponownie; puste = bez kolejnego kontaktu
    @Column(name = "follow_up_on")
    private LocalDate followUpOn;

    // z kim był kontakt: wiele kontaktów → jeden klient
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // kto ze studia kontaktował się z klientem
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private UserAccount handledBy;

    protected CustomerContact() {
    }

    public CustomerContact(LocalDateTime contactedAt, ContactChannel channel, String subject, String note,
                           LocalDate followUpOn, Customer customer, UserAccount handledBy) {
        this.contactedAt = contactedAt;
        this.channel = channel;
        this.subject = subject;
        this.note = note;
        this.followUpOn = followUpOn;
        this.customer = customer;
        this.handledBy = handledBy;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getContactedAt() {
        return contactedAt;
    }

    public ContactChannel getChannel() {
        return channel;
    }

    public String getSubject() {
        return subject;
    }

    public String getNote() {
        return note;
    }

    public LocalDate getFollowUpOn() {
        return followUpOn;
    }

    public Customer getCustomer() {
        return customer;
    }

    public UserAccount getHandledBy() {
        return handledBy;
    }
}
