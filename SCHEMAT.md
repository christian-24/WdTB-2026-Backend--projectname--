# Schemat bazy danych

Plik generują reguły projektu (panel Maven → Lifecycle → verify). Nie edytujcie go ręcznie.

Tabele: 8 · kolumny: 59 · relacje: 7 × @ManyToOne, 3 × @OneToMany, 1 × @OneToOne, 0 × @ManyToMany

| Tabela | Encja | Kolumny | Klucze obce |
|---|---|---|---|
| coating_warranty | CoatingWarranty | 7 | work_order_id |
| customer | Customer | 8 | — |
| customer_contact | CustomerContact | 8 | customer_id, user_account_id |
| service_offering | ServiceOffering | 7 | — |
| user_account | UserAccount | 5 | — |
| vehicle | Vehicle | 7 | customer_id |
| work_order | WorkOrder | 11 | user_account_id, vehicle_id |
| work_order_item | WorkOrderItem | 6 | service_offering_id, work_order_id |

```mermaid
erDiagram
    coating_warranty {
        Long id PK
        String certificate_number
        LocalDate next_inspection_on
        String product_name
        LocalDate valid_from
        LocalDate valid_until
        Long work_order_id FK
    }
    customer {
        Long id PK
        String company_name
        String email
        String full_name
        Boolean marketing_consent
        String phone
        LocalDate registered_on
        CustomerSource source
    }
    customer_contact {
        Long id PK
        ContactChannel channel
        LocalDateTime contacted_at
        Long customer_id FK
        LocalDate follow_up_on
        String note
        String subject
        Long user_account_id FK
    }
    service_offering {
        Long id PK
        Boolean active
        BigDecimal base_price
        ServiceCategory category
        Integer duration_minutes
        String name
        Integer warranty_months
    }
    user_account {
        Long id PK
        LocalDateTime created_at
        String display_name
        String email
        AccountRole role
    }
    vehicle {
        Long id PK
        String color
        Long customer_id FK
        String make
        String model
        String plate_number
        Integer production_year
    }
    work_order {
        Long id PK
        Integer bay_number
        BigDecimal deposit
        LocalDateTime ends_at
        String notes
        String order_number
        LocalDateTime starts_at
        WorkOrderStatus status
        BigDecimal total_price
        Long user_account_id FK
        Long vehicle_id FK
    }
    work_order_item {
        Long id PK
        Integer discount_percent
        Integer quantity
        Long service_offering_id FK
        BigDecimal unit_price
        Long work_order_id FK
    }
    customer ||--o{ customer_contact : "customer_id"
    customer ||--o{ vehicle : "customer_id"
    service_offering ||--o{ work_order_item : "service_offering_id"
    user_account |o--o{ customer_contact : "user_account_id"
    user_account |o--o{ work_order : "user_account_id"
    vehicle ||--o{ work_order : "vehicle_id"
    work_order ||--o{ work_order_item : "work_order_id"
    work_order ||--o| coating_warranty : "work_order_id"
```
