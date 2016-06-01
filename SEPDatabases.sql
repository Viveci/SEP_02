CREATE SCHEMA viaevents;

CREATE TABLE users(
	name VARCHAR(40) NOT NULL, 
	userid VARCHAR PRIMARY KEY,
	password VARCHAR(20),
	usertype INT NOT NULL);
	
CREATE TABLE facilities(
	roomnumber VARCHAR(10) PRIMARY KEY,
	roomname VARCHAR(40) NOT NULL, 
	capacity INT NOT NULL);
	
CREATE TABLE events(
	eventid  INT PRIMARY KEY ,
	eventname VARCHAR(20) NOT NULL, 
	capacity INT NOT NULL,
	eventdescription VARCHAR(300) NOT NULL,
	signupdeadline TIMESTAMP,
	roomnumber VARCHAR(10) NOT NULL, 
	FOREIGN KEY(roomnumber) REFERENCES facilities(roomnumber));	

CREATE TABLE bookings(
	bookingsid INT PRIMARY KEY,
	createdby VARCHAR NOT NULL,
	eventid INT,
	roomnumber VARCHAR,
	reservationdate DATE NOT NULL,
	hoursfrom TIME NOT NULL,
	hoursto TIME NOT NULL,
	FOREIGN KEY(roomnumber) REFERENCES facilities(roomnumber),
	FOREIGN KEY(eventid) REFERENCES events(eventid),
	FOREIGN KEY(createdby) REFERENCES users(userid));	
	
CREATE TABLE subscribe(
	userid VARCHAR NOT NULL,
	eventid INT NOT NULL,
	FOREIGN KEY(eventid) REFERENCES events(eventid),
	FOREIGN KEY(userid) REFERENCES users(userid));	

-- JUST FOR TESTING
INSERT INTO bookings VALUES
(1, '240124', 2, 'E.201b', '2016-11-10', '08:10:47', '09:11:47');
-- (2, '240309', 3, 'E.201a', '2016-11-10', '10:10:47', '11:11:47');
	
INSERT INTO users VALUES 
	('Stefani Ivanova','240124', '1234', 4);
-- 	('240309', 'Emilie Michelsen Kuhn', 3, '1234'),
-- 	('240190', 'Marton Teperics', 1, '1234'),
-- 	('sva','Steffen Vissing Andersen', 2, '1234');		

INSERT INTO events VALUES 
	(1, 'JAVA Workshop', 50, 'For all students who are interested in programming!', NULL, 'E.201b'),
	(2, 'JAVABlaa', 50, 'We will held a Java workshop.', NULL, 'E.201a');	
	
INSERT INTO subscribe VALUES
('240124', 2);
	
SELECT * FROM users;

SELECT * FROM facilities;

SELECT * FROM events;	

SELECT * FROM bookings;	

-- 1)TRIGGER FOR EVENTS TABLE FOR EVENTID

CREATE SEQUENCE event_sequence START 1 INCREMENT 1;

SELECT nextval('event_sequence');

CREATE OR REPLACE FUNCTION event_id() RETURNS TRIGGER AS $$
  BEGIN
  	NEW.eventid := nextval('event_sequence');
	RETURN NEW;
  END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER event_trig BEFORE INSERT ON events
FOR EACH ROW
EXECUTE PROCEDURE event_id();		

-- 2)TRIGGER FOR BOOKINGS TABLE FOR BOOKINGID

CREATE SEQUENCE bookings_sequence START 1 INCREMENT 1;

SELECT nextval('bookings_sequence');

CREATE OR REPLACE FUNCTION booking_id() RETURNS TRIGGER AS $$
  BEGIN
  	NEW.bookingsid := nextval('bookings_sequence');
	RETURN NEW;
  END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER booking_trig BEFORE INSERT ON bookings
FOR EACH ROW
EXECUTE PROCEDURE booking_id();	


-- SELECT *
-- FROM events
-- FULL OUTER JOIN bookings
-- ON events.eventid = bookings.eventid
-- ORDER BY bookings.reservationdate,bookings.hoursfrom;

-- CREATING A VIEW WITH JOIN statements for bookings + events table + order by the reservationdate
CREATE OR REPLACE VIEW firstview AS
SELECT events.eventname, events.capacity, events.eventdescription, events.signupdeadline, events.roomnumber,
bookings.bookingsid, bookings.createdby, bookings.eventid, bookings.reservationdate, bookings.hoursfrom, bookings.hoursto
FROM events
FULL OUTER JOIN bookings
ON events.eventid = bookings.eventid
ORDER BY bookings.reservationdate,bookings.hoursfrom;

SELECT * FROM firstview;

-- CREATING A VIEW WITH JOIN statements for bookings + subscribe + events 
CREATE OR REPLACE VIEW secondview AS
SELECT events.eventname, events.capacity, events.eventdescription, events.signupdeadline, events.roomnumber,
bookings.bookingsid, bookings.createdby, bookings.eventid, bookings.reservationdate, bookings.hoursfrom, bookings.hoursto,
subscribe.userid
FROM subscribe
FULL OUTER JOIN bookings
ON subscribe.eventid = bookings.eventid
FULL OUTER JOIN events
ON events.eventid = bookings.eventid
ORDER BY bookings.reservationdate,bookings.hoursfrom;

-- VIEW USERS+BOOKINGS
CREATE OR REPLACE VIEW secondview AS
SELECT events.eventname, events.capacity, events.eventdescription, events.signupdeadline, events.roomnumber,
bookings.bookingsid, bookings.createdby, bookings.eventid, bookings.reservationdate, bookings.hoursfrom, bookings.hoursto,
subscribe.userid
FROM subscribe
FULL OUTER JOIN bookings
ON subscribe.eventid = bookings.eventid
FULL OUTER JOIN events
ON events.eventid = bookings.eventid
ORDER BY bookings.reservationdate,bookings.hoursfrom;

SELECT * FROM secondview;

-- ALL ROOMS IN THE UNIVERSITY
INSERT INTO facilities VALUES 
	('A.001a', 'Workshop', 25),
	('A.001b', 'Workshop', 25),
	('A.101a', 'Classroom', 50),
	('A.101b', 'Classroom', 50),
	('A.102', 'Office', 10),
	('A.103', 'Office', 10),
	('A.104', 'Office', 10),
	('A.105', 'Workshop', 25),
	('A.201a', 'Office', 10),
	('A.201b', 'Office', 10),
	('A.202', 'Computer Room', 50),
	('A.203', 'Classroom', 50),
	('A.204', 'Classroom', 50),
	('A.301a', 'Classroom', 50),
	('A.301b', 'Classroom', 50),
	('A.302', 'Classroom', 50),
	('A.303a', 'Classroom', 50),
	('A.303b', 'Classroom', 50),
	('B.001', 'Workshop', 25),
	('B.002', 'Workshop', 25),
	('B.003', 'Workshop', 25),
	('B.004', 'Workshop', 25),
	('B.101a', 'Classroom', 50),
	('B.101b', 'Classroom', 50),
	('B.102', 'Classroom', 50),
	('B.103', 'Classroom', 50),
	('B.104a', 'Classroom', 50),
	('B.104b', 'Classroom', 50),
	('B.201a', 'Classroom', 50),
	('B.201b', 'Classroom', 50),
	('B.202', 'Classroom', 50),
	('B.203', 'Classroom', 50),
	('B.301a', 'Classroom', 50),
	('B.301b', 'Classroom', 50),
	('B.302', 'Classroom', 50),
	('B.303', 'Classroom', 50),
	('B.304', 'Classroom', 50),
	('C.001', 'Workshop', 25),
	('C.003', 'Workshop', 25),
	('C.004', 'Workshop', 25),
	('C.005', 'Workshop', 25),
	('C.101', 'Office', 10),
	('C.102', 'Office', 10),
	('C.103', 'Office', 10),
	('C.104', 'Classroom', 50),
	('C.105', 'Classroom', 50),
	('C.107', 'Classroom', 50),
	('C.201', 'Classroom', 50),
	('C.202', 'Classroom', 50),
	('C.203', 'Classroom', 50),
	('C.204', 'Classroom', 50),
	('C.205', 'Classroom', 50),
	('C.301', 'Classroom', 50),
	('C.302', 'Classroom', 50),
	('C.303', 'Classroom', 50),
	('C.304', 'Classroom', 50),
	('C.305', 'Classroom', 50),
	('D.002', 'Workshop', 25),
	('D.101', 'Workshop', 25),
	('D.201', 'Library', 25),
	('D.202', 'Library', 25),
	('D.203', 'Library', 25),
	('D.301', 'Classroom', 50),
	('D.302', 'Classroom', 50),
	('D.304', 'Classroom', 50),
	('D.305', 'Classroom', 50),
	('E.001b', 'Workshop', 25),
	('E.002', 'Workshop', 25),
	('E.003', 'Workshop', 25),
	('E.004', 'Workshop', 25),
	('E.005', 'Workshop', 25),
	('E.006', 'Workshop', 25),
	('E.007', 'Workshop', 25),
	('E.101', 'Drosellbo', 10),
	('E.101a', 'IT support', 10),
	('E.102', 'IT support', 10),
	('E.170', 'Guest Canteen', 50),
	('E.172', 'Cafe', 30),
	('E.201a', 'Classroom', 50),
	('E.201b', 'Classroom', 50),
	('E.202', 'Office', 10),
	('E.203', 'Office', 10),
	('E.204', 'Office', 10),
	('E.204a', 'Office', 10),
	('E.205', 'Office', 10),
	('E.301a', 'Classroom', 50),
	('E.301b', 'Classroom', 50),
	('E.302', 'Classroom', 50),
	('E.303', 'Classroom', 50),
	('F.001', 'Classroom', 50),
	('F.002', 'Classroom', 50),
	('F.003a', 'Classroom', 50),
	('F.004', 'Classroom', 50),
	('F.005', 'Classroom', 50),
	('F.006', 'Classroom', 50),
	('F.007', 'Classroom', 50),
	('F.009', 'Classroom', 50),
	('F.010', 'Classroom', 50),
	('F.011', 'Classroom', 50),
	('F.101a', 'Classroom', 50),
	('F.101b', 'Classroom', 50),
	('F.102a', 'Classroom', 50),
	('F.102b', 'Classroom', 50),
	('F.104', 'Classroom', 50),
	('F.105a', 'Classroom', 50),
	('F.105b', 'Classroom', 50),
	('F.106a', 'Classroom', 50),
	('F.106b', 'Classroom', 50),
	('F.107', 'Classroom', 50),
	('F.201a', 'Classroom', 50),
	('F.201b', 'Classroom', 50),
	('F.202a', 'Classroom', 50),
	('F.204', 'Classroom', 50),
	('F.205a', 'Classroom', 50),
	('F.206a', 'Classroom', 50),
	('F.207', 'Classroom', 50),
	('F.301a', 'Classroom', 50),
	('F.301b', 'Classroom', 50),
	('F.302a', 'Office', 10),
	('F.302b', 'Classroom', 50),
	('F.304', 'Classroom', 50),
	('F.305a', 'Classroom', 50),
	('F.305b', 'Classroom', 50),
	('F.306a', 'Classroom', 50),
	('F.306b', 'Classroom', 50),
	('F.307', 'Classroom', 50),
	('G.001', 'Kitchen', 15),
	('G.002', 'Workshop', 25),
	('G.003', 'Workshop', 25),
	('G.004', 'Workshop', 25),
	('G.005', 'Classroom', 50),
	('G.006', 'Depot', 1),
	('G.020', 'Depot', 1),
	('G.021', 'Depot', 1),
	('G.022', 'Depot', 1),
	('G.023', 'Auditorium', 200),
	('G.024', 'Music Room', 10),
	('G.025', 'Music Room', 10),
	('G.026', 'Depot', 1),
	('G.027', 'Depot', 1),
	('G.028', 'Group Room', 5),
	('G.029', 'Group Room', 5),
	('G.030', 'Group Room', 5),
	('G.031', 'Group Room', 5),
	('G.032', 'Group Room', 5),
	('G.033', 'Group Room', 5),
	('G.034', 'Group Room', 5),
	('G.035', 'Group Room', 5),
	('G.036', 'Classroom', 50),
	('G.037', 'Classroom', 50),
	('G.038', 'Classroom', 50),
	('G.039', 'Workshop', 25),
	('G.040', 'Workshop', 25),
	('G.041', 'Classroom', 50),
	('G.042', 'Classroom', 50),
	('G.043', 'Depot', 1),
	('G.044', 'Depot', 1),
	('G.101', 'Office', 10),
	('G.102', 'Office', 10),
	('G.103', 'Office', 10),
	('G.104', 'Office', 10),
	('G.105', 'Office', 10),
	('G.106', 'Office', 10),
	('G.107', 'Office', 10),
	('G.108', 'Office', 10),
	('G.110', 'Office', 10),
	('G.111', 'Office', 10),
	('G.112', 'Office', 10),
	('G.113', 'Office', 10),
	('G.120', 'Office', 10),
	('G.121', 'Office', 10),
	('G.122', 'Office', 10),
	('G.123', 'Office', 10),
	('G.124', 'Office', 10),
	('G.125', 'Office', 10),
	('G.126', 'Office', 10),
	('G.127', 'Office', 10),
	('G.128', 'Office', 10),
	('G.129', 'Office', 10),
	('G.130', 'Office', 10),
	('G.131', 'Office', 10),
	('G.132', 'Office', 10),
	('G.133', 'Office', 10),
	('G.134', 'Office', 10),
	('G.135', 'Office', 10),
	('G.136', 'Office', 10),
	('G.137', 'Office', 10),
	('G.138', 'Office', 10),
	('G.201', 'Group Room', 5),
	('G.202', 'Office', 10),
	('G.203', 'Office', 10),
	('G.204', 'Office', 10),
	('G.205', 'Office', 10),
	('G.206', 'Office', 10),
	('G.207', 'Office', 10),
	('G.208', 'Office', 10),
	('G.209', 'Depot', 1),
	('G.210', 'Office', 10),
	('G.211', 'Office', 10),
	('G.212', 'Office', 10),
	('G.213', 'Office', 10),
	('G.214', 'Office', 10),
	('G.220a', 'Classroom', 50),
	('G.220b', 'Classroom', 50),
	('G.221a', 'Classroom', 50),
	('G.221b', 'Classroom', 50),
	('G.222a', 'Classroom', 50),
	('G.222b', 'Classroom', 50),
	('G.223a', 'Classroom', 50),
	('G.301', 'Group Room', 5),
	('G.302', 'Group Room', 5),
	('G.303', 'Group Room', 5),
	('G.304', 'Group Room', 5),
	('G.305', 'Group Room', 5),
	('G.306', 'Group Room', 5),
	('G.307a', 'Classroom', 50),
	('G.307b', 'Classroom', 50),
	('G.308', 'Group Room', 5),
	('G.309', 'Group Room', 5),
	('G.310', 'Group Room', 5),
	('G.311', 'Classroom', 50),
	('G.320a', 'Classroom', 50),
	('G.321a', 'Classroom', 50),
	('G.321b', 'Classroom', 50),
	('G.322a', 'Classroom', 50),
	('G.322b', 'Classroom', 50),
	('G.323', 'Classroom', 50),
	('G.324', 'Classroom', 50);