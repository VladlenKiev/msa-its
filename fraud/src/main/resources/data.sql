INSERT INTO fraud_check_history (id, customer_id, is_fraudster, created_at) VALUES
(nextval('fraud_id_sequence'), 101, false, NOW()),
(nextval('fraud_id_sequence'), 102, true, NOW()),
(nextval('fraud_id_sequence'), 103, false, NOW());