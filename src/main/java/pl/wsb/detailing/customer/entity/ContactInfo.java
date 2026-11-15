package pl.wsb.detailing.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/** Dane kontaktowe klienta: kolumny trafiają do tabeli customer. */
@Embeddable
public class ContactInfo {

    @Column(name = "phone", nullable = false, length = 20)
    private String phone;

    @Column(name = "email", length = 120)
    private String email;

    protected ContactInfo() {
    }

    public ContactInfo(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
