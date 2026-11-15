package pl.wsb.detailing.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.detailing.customer.entity.CustomerContact;

import java.time.LocalDate;
import java.util.List;

public interface CustomerContactRepository extends JpaRepository<CustomerContact, Long> {

    // historia kontaktów z klientem, od najnowszego (przez relację customer)
    List<CustomerContact> findByCustomer_IdOrderByContactedAtDesc(Long customerId);

    // do kogo trzeba zadzwonić / napisać do danego dnia
    List<CustomerContact> findByFollowUpOnLessThanEqual(LocalDate day);
}
