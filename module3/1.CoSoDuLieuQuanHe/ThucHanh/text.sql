SELECT * FROM studen_05.student;
INSERT INTO `studen_05`.`student` (`id`, `name`, `gioi tinh`, `email`) VALUES ('6', 'Khanh', 'nam', 'Khanh@gmail.com');
DELETE FROM `studen_05`.`student` WHERE (`id` = '5');
UPDATE `studen_05`.`student` SET `name` = 'Khanh', `gioi tinh` = 'nam' WHERE (`id` = '3');
INSERT INTO `studen_05`.`student` (`id`, `name`, `gioi tinh`, `email`) VALUES ('5', 'abc', 'nam', 'abc@gmail.com');
