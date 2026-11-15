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

-- ===== LAB 02 · service_offering =====
insert into service_offering (name, category, base_price, duration_minutes, warranty_months, active) values
    ('Mycie detailingowe premium',        'WASH',      180.00,  120, null, true),
    ('Korekta lakieru jednoetapowa',      'POLISH',    900.00,  480, null, true),
    ('Powłoka ceramiczna 3 lata',         'CERAMIC',  2200.00,  960,   36, true),
    ('Folia PPF – przód auta',            'PPF',      4500.00, 1440,   60, true),
    ('Pranie tapicerki i czyszczenie skór','INTERIOR',  450.00,  240, null, false);

-- ===== LAB 02 · work_order =====
insert into work_order (order_number, status, bay_number, total_price, deposit, notes, starts_at, ends_at) values
    ('ZL/2026/11/001', 'PICKED_UP',   1, 2380.00, 500.00, 'BMW 330i, lakier czarny, rysy na masce',  '2026-11-03 08:00:00', '2026-11-04 16:00:00'),
    ('ZL/2026/11/002', 'IN_PROGRESS', 2,  900.00, null,   'Skoda Octavia flotowa',                     '2026-11-14 09:00:00', '2026-11-14 17:00:00'),
    ('ZL/2026/11/003', 'CONFIRMED',   3, 4500.00, 1000.00,'Tesla Model 3, folia na przód',             '2026-11-18 08:00:00', '2026-11-19 16:00:00'),
    ('ZL/2026/11/004', 'NEW',         1,  180.00, null,   null,                                        '2026-11-20 10:00:00', '2026-11-20 12:00:00'),
    ('ZL/2026/11/005', 'CANCELLED',   2,  450.00, null,   'Klient odwołał telefonicznie',              '2026-11-12 13:00:00', '2026-11-12 17:00:00');
