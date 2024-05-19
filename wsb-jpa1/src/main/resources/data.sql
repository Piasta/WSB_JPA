INSERT INTO MEDICAL_TREATMENT (DESCRIPTION, TYPE)
            VALUES ('Ultrasonography', 'USG');
INSERT INTO MEDICAL_TREATMENT (DESCRIPTION, TYPE)
            VALUES ('Electrocardiography', 'EKG');
INSERT INTO MEDICAL_TREATMENT (DESCRIPTION, TYPE)
            VALUES ('X-Ray', 'RTG');

INSERT INTO address (address_line1, address_line2, city, postal_code)
            VALUES ('Doktora1', 'xx', 'Doctorowo', '62-030');
INSERT INTO DOCTOR (doctor_number, email, first_name, last_name, specialization, telephone_number, address_id)
            VALUES ('123', 'malysz@wp.pl', 'Adam', 'Malysz', 'SURGEON', '123456789', 1);

INSERT INTO address (address_line1, address_line2, city, postal_code)
            VALUES ('Pacjenta1', 'yy', 'Pacjentowo', '30-062');
INSERT INTO PATIENT (date_of_birth, email, first_name, last_name, patient_number, telephone_number, address_id)
            VALUES ('2000-01-01', 'pp@wp.pl', 'Zuzanna', 'Kasztan', '333', '555333222', 2);

INSERT INTO VISIT (DESCRIPTION, TIME, DOCTOR_ID, PATIENT_ID, TREATMENT_ID)
            VALUES ('Ultrasonography', '2024-05-10 10:00:00', 1, 1, 1);

INSERT INTO VISIT (DESCRIPTION, TIME, DOCTOR_ID, PATIENT_ID, TREATMENT_ID)
            VALUES ('Ultrasonography', '2024-05-14 10:00:00', 1, 1, 2);

INSERT INTO PATIENT (date_of_birth, email, first_name, last_name, patient_number, telephone_number)
            VALUES ('1999-01-01', 'a@wp.pl', 'Zygfryd', 'Piasta', '333', '555333222');

INSERT INTO PATIENT (date_of_birth, email, first_name, last_name, patient_number, telephone_number)
            VALUES ('1975-01-01', 'b@wp.pl', 'Bonifacy', 'Piasta', '333', '555333222');

INSERT INTO VISIT (DESCRIPTION, TIME, DOCTOR_ID, PATIENT_ID, TREATMENT_ID)
            VALUES ('Ultrasonography', '2024-05-14 10:00:00', 1, 2, 2);