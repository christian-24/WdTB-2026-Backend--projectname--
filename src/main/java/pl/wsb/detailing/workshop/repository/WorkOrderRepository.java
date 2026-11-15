package pl.wsb.detailing.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsb.detailing.workshop.entity.WorkOrder;
import pl.wsb.detailing.workshop.entity.WorkOrderStatus;

import java.util.List;

public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {

    // historia zleceń auta po numerze rejestracyjnym (przez relację vehicle)
    List<WorkOrder> findByVehicle_PlateNumber(String plateNumber);

    // zlecenia detailera w danym statusie (przez relację assignedTo → user_account)
    List<WorkOrder> findByAssignedTo_EmailAndStatus(String email, WorkOrderStatus status);
}
