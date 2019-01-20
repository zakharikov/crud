USE test;

DROP TABLE IF EXISTS part;
CREATE TABLE part (
    id INT(11) NOT NULL AUTO_INCREMENT,
    part_name VARCHAR(60) NOT NULL,
    mandatory BOOLEAN,
    quantity INT(7),
    PRIMARY KEY (id)
)  ENGINE=INNODB DEFAULT CHARACTER SET=UTF8;

INSERT INTO PART (part_name, mandatory, quantity) VALUES
('motherboard', true, 10),
('soundcard', false, 5),
('cpu', true, 7),
('hdd', true, 8),
('ssd', false, 8),
('box', true, 30),
('box l.e.d.', false, 1),
('videocard', true, 9),
('ram', true, 23),
('monitor', false, 17),
('mouse', false, 6),
('keyboard', false, 8),
('trackpad', false, 2),
('webcam', false, 4),
('microphone', false, 2),
('printer', false, 5),
('scanner', false, 7),
('speakers', false, 3),
('cooler', true, 9),
('power supply', true, 5),
('bluetooth module', false, 1),
('wifi module', false, 3),
('gsm module', false, 0),
('usb port', false, 2),
('network adaptor', false, 3);