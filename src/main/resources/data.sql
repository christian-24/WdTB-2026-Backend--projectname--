-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: konta zespołu
insert into user_account (email, display_name, role, created_at) values
    ('wrx81871@student.wroclaw.merito.pl', 'Krystian Stryjakiewicz', 'USER', current_timestamp),
    ('wrx81906@student.wroclaw.merito.pl', 'Adrian Misztal',         'USER', current_timestamp),
    ('wrx81958@student.wroclaw.merito.pl', 'Wiktor Mayer',           'USER', current_timestamp);

-- ===== LAB 02 · customer =====
insert into customer (full_name, company_name, source, registered_on, marketing_consent, phone, email) values
    ('Marek Zieliński',   null,                    'INSTAGRAM', '2026-09-03', true,  '601234567', 'marek.zielinski@example.com'),
    ('Katarzyna Wójcik',  null,                    'REFERRAL',  '2026-09-18', false, '602345678', null),
    ('Tomasz Lewandowski','TL Transport sp. z o.o.','FLEET',    '2026-10-02', true,  '713456789', 'flota@tltransport.example.com'),
    ('Paulina Kamińska',  null,                    'GOOGLE',    '2026-10-21', true,  '604567890', 'paulina.k@example.com');

-- ===== LAB 03 · vehicle =====
-- customer_id: numer klienta z sekcji customer (1 Marek, 2 Katarzyna, 3 TL Transport, 4 Paulina)
insert into vehicle (plate_number, make, model, production_year, color, customer_id) values
    ('DW 1234A',  'BMW',    '330i',     2021, 'czarny',        1),
    ('DW 5K821',  'Skoda',  'Octavia',  2023, 'srebrny',       3),
    ('DW 5K822',  'Skoda',  'Octavia',  2023, 'biały',         3),
    ('DWR 77TS',  'Tesla',  'Model 3',  2024, 'perłowy biały', 4),
    ('DSW 40210', 'Toyota', 'Corolla',  2019, 'czerwony',      2);

-- ===== LAB 03 · customer_contact =====
-- customer_id: klient z sekcji customer; user_account_id: kto kontaktował (5 Krystian, 6 Adrian, 7 Wiktor)
insert into customer_contact (contacted_at, channel, subject, note, follow_up_on, customer_id, user_account_id) values
    ('2026-11-04 16:30:00', 'PHONE',     'Auto gotowe do odbioru',            'Odbiór dziś do 18:00',                     null,         1, 5),
    ('2026-11-10 10:15:00', 'EMAIL',     'Oferta na ceramikę dla floty',      'Wycena dla 2 kolejnych Octavii, rabat 10%', '2026-11-24', 3, 6),
    ('2026-11-12 12:40:00', 'PHONE',     'Odwołanie prania tapicerki',        'Klient zadzwoni po nowy termin',           '2026-11-26', 3, 6),
    ('2026-11-13 09:05:00', 'INSTAGRAM', 'Pytanie o folię PPF na przód',      'Wysłano zdjęcia realizacji i cennik',      null,         4, 7),
    ('2026-11-14 18:20:00', 'SMS',       'Potwierdzenie terminu 20.11 10:00', null,                                       '2026-11-19', 2, null);

-- ===== LAB 02 · service_offering =====
insert into service_offering (name, category, base_price, duration_minutes, warranty_months, active) values
    ('Mycie detailingowe premium',        'WASH',      180.00,  120, null, true),
    ('Korekta lakieru jednoetapowa',      'POLISH',    900.00,  480, null, true),
    ('Powłoka ceramiczna 3 lata',         'CERAMIC',  2200.00,  960,   36, true),
    ('Folia PPF – przód auta',            'PPF',      4500.00, 1440,   60, true),
    ('Pranie tapicerki i czyszczenie skór','INTERIOR',  450.00,  240, null, false);

-- ===== LAB 02 · work_order =====
-- vehicle_id: numer auta z sekcji vehicle; user_account_id: detailer (5 Krystian, 6 Adrian, 7 Wiktor), null = nieprzydzielone
insert into work_order (order_number, status, bay_number, total_price, deposit, notes, starts_at, ends_at, vehicle_id, user_account_id) values
    ('ZL/2026/11/001', 'PICKED_UP',   1, 2380.00,  500.00, 'Rysy na masce, ceramika całego auta', '2026-11-03 08:00:00', '2026-11-04 16:00:00', 1, 5),
    ('ZL/2026/11/002', 'IN_PROGRESS', 2,  900.00,    null, 'Auto flotowe, ślady po myjni',          '2026-11-14 09:00:00', '2026-11-14 17:00:00', 2, 6),
    ('ZL/2026/11/003', 'CONFIRMED',   3, 4500.00, 1000.00, 'Folia na przód',                         '2026-11-18 08:00:00', '2026-11-19 16:00:00', 4, 7),
    ('ZL/2026/11/004', 'NEW',         1,  180.00,    null, null,                                     '2026-11-20 10:00:00', '2026-11-20 12:00:00', 5, null),
    ('ZL/2026/11/005', 'CANCELLED',   2,  450.00,    null, 'Klient odwołał telefonicznie',           '2026-11-12 13:00:00', '2026-11-12 17:00:00', 3, null),
    ('ZL/2026/09/002', 'PICKED_UP',   3, 4500.00, 1000.00, 'Folia PPF na przód przed sezonem',       '2026-09-08 08:00:00', '2026-09-09 16:00:00', 1, 5),
    ('ZL/2026/10/003', 'PICKED_UP',   2, 1980.00,    null, 'Ceramika, rabat flotowy 10%',            '2026-10-06 08:00:00', '2026-10-07 16:00:00', 3, 6);

-- ===== LAB 03 · work_order_item =====
-- wiele-do-wielu zlecenie ↔ usługa; service_offering_id: 1 mycie, 2 korekta, 3 ceramika, 4 PPF, 5 wnętrze
insert into work_order_item (work_order_id, service_offering_id, quantity, unit_price, discount_percent) values
    (1, 3, 1, 2200.00,  0),
    (1, 1, 1,  180.00,  0),
    (2, 2, 1,  900.00,  0),
    (3, 4, 1, 4500.00,  0),
    (4, 1, 1,  180.00,  0),
    (5, 5, 1,  450.00,  0),
    (6, 4, 1, 4500.00,  0),
    (7, 3, 1, 2200.00, 10);

-- ===== LAB 03 · coating_warranty =====
-- jedno zlecenie → najwyżej jedna gwarancja (work_order_id unikalne)
insert into coating_warranty (certificate_number, product_name, valid_from, valid_until, next_inspection_on, work_order_id) values
    ('GW/2026/0007', 'Gtechniq Crystal Serum Ultra', '2026-11-04', '2029-11-04', '2027-11-04', 1),
    ('GW/2026/0003', 'XPEL Ultimate Plus (PPF)',     '2026-09-09', '2031-09-09', '2027-09-09', 6),
    ('GW/2026/0005', 'Gtechniq Crystal Serum Ultra', '2026-10-07', '2029-10-07', '2027-10-07', 7);
