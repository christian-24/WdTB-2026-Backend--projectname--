package pl.wsb.detailing.workshop.entity;

/** Cykl życia zlecenia: od zapisu klienta do odbioru auta. */
public enum WorkOrderStatus {
    NEW,
    CONFIRMED,
    IN_PROGRESS,
    READY,
    PICKED_UP,
    CANCELLED
}
