INSERT INTO patient (name, birth_date, email, gender, blood_group)
VALUES
('Amit Sharma', '1990-05-14', 'amit.sharma@example.com', 'Male', 'O_POSITIVE'),
('Priya Verma', '1985-11-22', 'priya.verma@example.com', 'Female', 'A_POSITIVE'),
('Rohit Mehta', '1992-03-10', 'rohit.mehta@example.com', 'Male', 'B_POSITIVE'),
('Sneha Gupta', '1995-07-18', 'sneha.gupta@example.com', 'Female', 'AB_POSITIVE'),
('Arjun Nair', '1988-09-25', 'arjun.nair@example.com', 'Male', 'O_NEGATIVE'),
('Neha Kulkarni', '1993-12-05', 'neha.kulkarni@example.com', 'Female', 'A_NEGATIVE'),
('Karan Singh', '1997-02-14', 'karan.singh@example.com', 'Male', 'B_NEGATIVE'),
('Meera Iyer', '1991-06-30', 'meera.iyer@example.com', 'Female', 'AB_NEGATIVE'),
('Vikram Das', '1986-04-20', 'vikram.das@example.com', 'Male', 'O_POSITIVE'),
('Ritu Chauhan', '1994-08-09', 'ritu.chauhan@example.com', 'Female', 'A_POSITIVE');


INSERT INTO doctor (name, specialization, email)
VALUES ('Dr. Rakesh Mehta', 'Cardiology', 'rakesh.mehta@example.com'),
       ('Dr. Sneha Kapoor', 'Dermatology', 'sneha.kapoor@example.com'),
       ('Dr. Arjun Nair', 'Orthopedics', 'arjun.nair@example.com');

INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
    ('2025-07-01 10:30:00', 'General Checkup', 1, 2),
    ('2025-07-02 11:00:00', 'Skin Rash', 2, 2),
    ('2025-07-03 09:45:00', 'Knee Pain', 3, 3),
    ('2025-07-04 14:00:00', 'Follow-up Visit', 1, 1),
    ('2025-07-05 16:15:00', 'Consultation', 1, 4),
    ('2025-07-06 08:30:00', 'Allergy Treatment', 2, 5);
