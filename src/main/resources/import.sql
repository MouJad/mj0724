INSERT INTO TOOL (id, code, type, brand) VALUES (1, 'CHNS', 'Chainsaw', 'Stihl');
INSERT INTO TOOL (id, code, type, brand) VALUES (2, 'LADW', 'Ladder', 'Werner');
INSERT INTO TOOL (id, code, type, brand) VALUES (3, 'JAKD', 'Jackhammer', 'DeWalt');
INSERT INTO TOOL (id, code, type, brand) VALUES (4, 'JAKR', 'Jackhammer', 'Ridgid');


INSERT INTO RENTAL_CHARGE (id, type, daily_charge, weekday_charge, weekend_charge, holiday_charge) VALUES (1, 'Ladder', 1.99, 't', 't', 'f');
INSERT INTO RENTAL_CHARGE (id, type, daily_charge, weekday_charge, weekend_charge, holiday_charge) VALUES (2, 'Chainsaw', 1.49, 't', 'f', 't');
INSERT INTO RENTAL_CHARGE (id, type, daily_charge, weekday_charge, weekend_charge, holiday_charge) VALUES (3, 'Jackhammer', 2.99, 't', 'f', 'f');
