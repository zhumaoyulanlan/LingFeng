create database LingFeng


use LingFeng;


-- -----------------------------------------------------------
-- Entity Designer DDL Script for MySQL Server 4.1 and higher
-- -----------------------------------------------------------
-- Date Created: 05/11/2018 23:01:57

-- Generated from EDMX file: C:\Users\zhumaoyu\source\repos\LingFeng.OA\Lingfeng.OA.Modal\DataModel.edmx
-- Target version: 3.0.0.0

-- --------------------------------------------------



-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- NOTE: if the constraint does not exist, an ignorable error will be reported.
-- --------------------------------------------------


--    ALTER TABLE `card` DROP CONSTRAINT `FK_card_ibfk_1`;

--    ALTER TABLE `card` DROP CONSTRAINT `FK_card_ibfk_2`;

--    ALTER TABLE `clocking_in_detail` DROP CONSTRAINT `FK_clocking_in_detail_ibfk_1`;

--    ALTER TABLE `clocking_in_detail` DROP CONSTRAINT `FK_clocking_in_detail_ibfk_2`;

--    ALTER TABLE `clocking_in` DROP CONSTRAINT `FK_clocking_in_ibfk_1`;

--    ALTER TABLE `employee_info` DROP CONSTRAINT `FK_employee_info_ibfk_1`;

--    ALTER TABLE `employee_info` DROP CONSTRAINT `FK_employee_info_ibfk_2`;

--    ALTER TABLE `pay_detail` DROP CONSTRAINT `FK_pay_detail_ibfk_1`;

--    ALTER TABLE `pay_detail` DROP CONSTRAINT `FK_pay_detail_ibfk_2`;

--    ALTER TABLE `pay_detail` DROP CONSTRAINT `FK_pay_detail_ibfk_3`;

--    ALTER TABLE `pay_detail_record` DROP CONSTRAINT `FK_pay_detail_record_ibfk_1`;

--    ALTER TABLE `pay_detail_record` DROP CONSTRAINT `FK_pay_detail_record_ibfk_2`;

--    ALTER TABLE `pay_detail_record` DROP CONSTRAINT `FK_pay_detail_record_ibfk_3`;

--    ALTER TABLE `pay_detail_record` DROP CONSTRAINT `FK_pay_detail_record_ibfk_4`;

--    ALTER TABLE `pay_detail_record` DROP CONSTRAINT `FK_pay_detail_record_ibfk_5`;

--    ALTER TABLE `pay` DROP CONSTRAINT `FK_pay_ibfk_1`;

--    ALTER TABLE `pay` DROP CONSTRAINT `FK_pay_ibfk_2`;

--    ALTER TABLE `salary_day_plan` DROP CONSTRAINT `FK_salary_day_plan_ibfk_1`;

--    ALTER TABLE `salary_night_plan` DROP CONSTRAINT `FK_salary_night_plan_ibfk_1`;

--    ALTER TABLE `salary_pay_detail` DROP CONSTRAINT `FK_salary_pay_detail_ibfk_1`;

--    ALTER TABLE `salary_pay_detail` DROP CONSTRAINT `FK_salary_pay_detail_ibfk_2`;

--    ALTER TABLE `salary_pay` DROP CONSTRAINT `FK_salary_pay_ibfk_1`;


-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------
SET foreign_key_checks = 0;

    DROP TABLE IF EXISTS `bank`;

    DROP TABLE IF EXISTS `card`;

    DROP TABLE IF EXISTS `clocking_in`;

    DROP TABLE IF EXISTS `clocking_in_detail`;

    DROP TABLE IF EXISTS `company`;

    DROP TABLE IF EXISTS `department`;

    DROP TABLE IF EXISTS `employee`;

    DROP TABLE IF EXISTS `employee_info`;

    DROP TABLE IF EXISTS `pay`;

    DROP TABLE IF EXISTS `pay_detail`;

    DROP TABLE IF EXISTS `pay_detail_record`;

    DROP TABLE IF EXISTS `salary_day_plan`;

    DROP TABLE IF EXISTS `salary_night_plan`;

    DROP TABLE IF EXISTS `salary_pay`;

    DROP TABLE IF EXISTS `salary_pay_detail`;

    DROP TABLE IF EXISTS `user`;

SET foreign_key_checks = 1;

-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------


CREATE TABLE `bank`(
	`bank_id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`bank_name` varchar (20));

ALTER TABLE `bank` ADD PRIMARY KEY (`bank_id`);





CREATE TABLE `card`(
	`card_id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`employee_id` int, 
	`card_name` varchar (20) NOT NULL, 
	`card_number` varchar (20) NOT NULL, 
	`bank_id` int NOT NULL, 
	`bank_detail_name` varchar (40));

ALTER TABLE `card` ADD PRIMARY KEY (`card_id`);





CREATE TABLE `clocking_in`(
	`clocking_in_id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`year_index` int, 
	`month_index` int, 
	`lister_id` int, 
	`add_time` time, 
	`modefiy_time` time, 
	`remark` varchar (50));

ALTER TABLE `clocking_in` ADD PRIMARY KEY (`clocking_in_id`);





CREATE TABLE `clocking_in_detail`(
	`clocking_in_detail_id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`employee_id` int, 
	`clocking_plan` decimal( 10, 2 ) , 
	`clocking_day` decimal( 10, 2 ) , 
	`clocking_night` decimal( 10, 2 ) , 
	`clocking_total` decimal( 10, 2 ) , 
	`work_time` decimal( 10, 2 ) , 
	`overtime` decimal( 10, 2 ) , 
	`lister_id` int, 
	`add_time` time, 
	`modefiy_time` time, 
	`remark` varchar (50));

ALTER TABLE `clocking_in_detail` ADD PRIMARY KEY (`clocking_in_detail_id`);





CREATE TABLE `company`(
	`company_id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`company_name` varchar (20));

ALTER TABLE `company` ADD PRIMARY KEY (`company_id`);





CREATE TABLE `department`(
	`department_id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`department_name` varchar (20));

ALTER TABLE `department` ADD PRIMARY KEY (`department_id`);





CREATE TABLE `employee`(
	`employee_id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`job_number` int, 
	`name` varchar (20) NOT NULL, 
	`state` int);

ALTER TABLE `employee` ADD PRIMARY KEY (`employee_id`);





CREATE TABLE `employee_info`(
	`employee_id` int NOT NULL, 
	`gender` int, 
	`age` int, 
	`id_card_no` varchar (18), 
	`department_id` int, 
	`post` varchar (40), 
	`phone` varchar (40), 
	`phone_other` varchar (60), 
	`native_place` varchar (10), 
	`address` varchar (60), 
	`politics_status` varchar (10), 
	`remark` varchar (120));

ALTER TABLE `employee_info` ADD PRIMARY KEY (`employee_id`);





CREATE TABLE `pay`(
	`pay_id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`year_index` int, 
	`month_index` int, 
	`salary_pay_id` int, 
	`salary_paid` decimal( 10, 2 ) , 
	`lister_id` int, 
	`add_time` time, 
	`modefiy_time` time, 
	`remark` varchar (50));

ALTER TABLE `pay` ADD PRIMARY KEY (`pay_id`);





CREATE TABLE `pay_detail`(
	`pay_detail_id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`pay_id` int, 
	`salary_pay_detail_id` int, 
	`salary_paid` decimal( 10, 2 ) , 
	`lister_id` int, 
	`add_time` time, 
	`modefiy_time` time, 
	`remark` varchar (50));

ALTER TABLE `pay_detail` ADD PRIMARY KEY (`pay_detail_id`);





CREATE TABLE `pay_detail_record`(
	`pay_detail_record_id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`pay_detail_id` int, 
	`employee_id` int, 
	`pay_type` int, 
	`card_id` int, 
	`money` decimal( 10, 2 ) , 
	`company_id` int, 
	`lister_id` int, 
	`add_time` time, 
	`modefiy_time` time, 
	`remark` varchar (50));

ALTER TABLE `pay_detail_record` ADD PRIMARY KEY (`pay_detail_record_id`);





CREATE TABLE `salary_day_plan`(
	`employee_id` int NOT NULL, 
	`base_salary` decimal( 10, 2 ) , 
	`subsidies` decimal( 10, 2 ) , 
	`award` decimal( 10, 2 ) , 
	`award_each_day` decimal( 10, 2 ) );

ALTER TABLE `salary_day_plan` ADD PRIMARY KEY (`employee_id`);





CREATE TABLE `salary_night_plan`(
	`employee_id` int NOT NULL, 
	`base_salary` decimal( 10, 2 ) , 
	`subsidies` decimal( 10, 2 ) , 
	`award` decimal( 10, 2 ) , 
	`award_each_day` decimal( 10, 2 ) );

ALTER TABLE `salary_night_plan` ADD PRIMARY KEY (`employee_id`);





CREATE TABLE `salary_pay`(
	`salary_pay_id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`year_index` int, 
	`month_index` int, 
	`salary_total` decimal( 10, 2 ) , 
	`lister_id` int, 
	`add_time` time, 
	`modefiy_time` time, 
	`remark` varchar (50));

ALTER TABLE `salary_pay` ADD PRIMARY KEY (`salary_pay_id`);





CREATE TABLE `salary_pay_detail`(
	`salary_pay_detail_id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`salary_pay_id` int, 
	`base_salary` decimal( 10, 2 ) , 
	`attendance_bonus` decimal( 10, 2 ) , 
	`personal_award` decimal( 10, 2 ) , 
	`company_award` decimal( 10, 2 ) , 
	`charge` decimal( 10, 2 ) , 
	`fine` decimal( 10, 2 ) , 
	`fine_text` varchar (20), 
	`award` decimal( 10, 2 ) , 
	`award_text` varchar (20), 
	`subsidy` decimal( 10, 2 ) , 
	`subsidy_text` varchar (20), 
	`lister_id` int, 
	`add_time` time, 
	`modefiy_time` time, 
	`remark` varchar (50));

ALTER TABLE `salary_pay_detail` ADD PRIMARY KEY (`salary_pay_detail_id`);





CREATE TABLE `user`(
	`id` int NOT NULL AUTO_INCREMENT UNIQUE, 
	`login_name` varchar (20) NOT NULL, 
	`pwd` varchar (20) NOT NULL, 
	`privilege` int NOT NULL, 
	`lister_id` int);

ALTER TABLE `user` ADD PRIMARY KEY (`id`);







-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------


-- Creating foreign key on `bank_id` in table 'card'

ALTER TABLE `card`
ADD CONSTRAINT `FK_card_ibfk_2`
    FOREIGN KEY (`bank_id`)
    REFERENCES `bank`
        (`bank_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_card_ibfk_2'

CREATE INDEX `IX_FK_card_ibfk_2`
    ON `card`
    (`bank_id`);



-- Creating foreign key on `employee_id` in table 'card'

ALTER TABLE `card`
ADD CONSTRAINT `FK_card_ibfk_1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_card_ibfk_1'

CREATE INDEX `IX_FK_card_ibfk_1`
    ON `card`
    (`employee_id`);



-- Creating foreign key on `card_id` in table 'pay_detail_record'

ALTER TABLE `pay_detail_record`
ADD CONSTRAINT `FK_pay_detail_record_ibfk_3`
    FOREIGN KEY (`card_id`)
    REFERENCES `card`
        (`card_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_pay_detail_record_ibfk_3'

CREATE INDEX `IX_FK_pay_detail_record_ibfk_3`
    ON `pay_detail_record`
    (`card_id`);



-- Creating foreign key on `lister_id` in table 'clocking_in'

ALTER TABLE `clocking_in`
ADD CONSTRAINT `FK_clocking_in_ibfk_1`
    FOREIGN KEY (`lister_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_clocking_in_ibfk_1'

CREATE INDEX `IX_FK_clocking_in_ibfk_1`
    ON `clocking_in`
    (`lister_id`);



-- Creating foreign key on `employee_id` in table 'clocking_in_detail'

ALTER TABLE `clocking_in_detail`
ADD CONSTRAINT `FK_clocking_in_detail_ibfk_1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_clocking_in_detail_ibfk_1'

CREATE INDEX `IX_FK_clocking_in_detail_ibfk_1`
    ON `clocking_in_detail`
    (`employee_id`);



-- Creating foreign key on `lister_id` in table 'clocking_in_detail'

ALTER TABLE `clocking_in_detail`
ADD CONSTRAINT `FK_clocking_in_detail_ibfk_2`
    FOREIGN KEY (`lister_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_clocking_in_detail_ibfk_2'

CREATE INDEX `IX_FK_clocking_in_detail_ibfk_2`
    ON `clocking_in_detail`
    (`lister_id`);



-- Creating foreign key on `company_id` in table 'pay_detail_record'

ALTER TABLE `pay_detail_record`
ADD CONSTRAINT `FK_pay_detail_record_ibfk_5`
    FOREIGN KEY (`company_id`)
    REFERENCES `company`
        (`company_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_pay_detail_record_ibfk_5'

CREATE INDEX `IX_FK_pay_detail_record_ibfk_5`
    ON `pay_detail_record`
    (`company_id`);



-- Creating foreign key on `department_id` in table 'employee_info'

ALTER TABLE `employee_info`
ADD CONSTRAINT `FK_employee_info_ibfk_2`
    FOREIGN KEY (`department_id`)
    REFERENCES `department`
        (`department_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_employee_info_ibfk_2'

CREATE INDEX `IX_FK_employee_info_ibfk_2`
    ON `employee_info`
    (`department_id`);



-- Creating foreign key on `employee_id` in table 'employee_info'

ALTER TABLE `employee_info`
ADD CONSTRAINT `FK_employee_info_ibfk_1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;



-- Creating foreign key on `lister_id` in table 'pay_detail'

ALTER TABLE `pay_detail`
ADD CONSTRAINT `FK_pay_detail_ibfk_3`
    FOREIGN KEY (`lister_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_pay_detail_ibfk_3'

CREATE INDEX `IX_FK_pay_detail_ibfk_3`
    ON `pay_detail`
    (`lister_id`);



-- Creating foreign key on `employee_id` in table 'pay_detail_record'

ALTER TABLE `pay_detail_record`
ADD CONSTRAINT `FK_pay_detail_record_ibfk_2`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_pay_detail_record_ibfk_2'

CREATE INDEX `IX_FK_pay_detail_record_ibfk_2`
    ON `pay_detail_record`
    (`employee_id`);



-- Creating foreign key on `lister_id` in table 'pay_detail_record'

ALTER TABLE `pay_detail_record`
ADD CONSTRAINT `FK_pay_detail_record_ibfk_4`
    FOREIGN KEY (`lister_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_pay_detail_record_ibfk_4'

CREATE INDEX `IX_FK_pay_detail_record_ibfk_4`
    ON `pay_detail_record`
    (`lister_id`);



-- Creating foreign key on `lister_id` in table 'pay'

ALTER TABLE `pay`
ADD CONSTRAINT `FK_pay_ibfk_2`
    FOREIGN KEY (`lister_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_pay_ibfk_2'

CREATE INDEX `IX_FK_pay_ibfk_2`
    ON `pay`
    (`lister_id`);



-- Creating foreign key on `employee_id` in table 'salary_day_plan'

ALTER TABLE `salary_day_plan`
ADD CONSTRAINT `FK_salary_day_plan_ibfk_1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;



-- Creating foreign key on `employee_id` in table 'salary_night_plan'

ALTER TABLE `salary_night_plan`
ADD CONSTRAINT `FK_salary_night_plan_ibfk_1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;



-- Creating foreign key on `lister_id` in table 'salary_pay_detail'

ALTER TABLE `salary_pay_detail`
ADD CONSTRAINT `FK_salary_pay_detail_ibfk_1`
    FOREIGN KEY (`lister_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_salary_pay_detail_ibfk_1'

CREATE INDEX `IX_FK_salary_pay_detail_ibfk_1`
    ON `salary_pay_detail`
    (`lister_id`);



-- Creating foreign key on `lister_id` in table 'salary_pay'

ALTER TABLE `salary_pay`
ADD CONSTRAINT `FK_salary_pay_ibfk_1`
    FOREIGN KEY (`lister_id`)
    REFERENCES `employee`
        (`employee_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_salary_pay_ibfk_1'

CREATE INDEX `IX_FK_salary_pay_ibfk_1`
    ON `salary_pay`
    (`lister_id`);



-- Creating foreign key on `pay_id` in table 'pay_detail'

ALTER TABLE `pay_detail`
ADD CONSTRAINT `FK_pay_detail_ibfk_1`
    FOREIGN KEY (`pay_id`)
    REFERENCES `pay`
        (`pay_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_pay_detail_ibfk_1'

CREATE INDEX `IX_FK_pay_detail_ibfk_1`
    ON `pay_detail`
    (`pay_id`);



-- Creating foreign key on `salary_pay_id` in table 'pay'

ALTER TABLE `pay`
ADD CONSTRAINT `FK_pay_ibfk_1`
    FOREIGN KEY (`salary_pay_id`)
    REFERENCES `salary_pay`
        (`salary_pay_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_pay_ibfk_1'

CREATE INDEX `IX_FK_pay_ibfk_1`
    ON `pay`
    (`salary_pay_id`);



-- Creating foreign key on `salary_pay_detail_id` in table 'pay_detail'

ALTER TABLE `pay_detail`
ADD CONSTRAINT `FK_pay_detail_ibfk_2`
    FOREIGN KEY (`salary_pay_detail_id`)
    REFERENCES `salary_pay_detail`
        (`salary_pay_detail_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_pay_detail_ibfk_2'

CREATE INDEX `IX_FK_pay_detail_ibfk_2`
    ON `pay_detail`
    (`salary_pay_detail_id`);



-- Creating foreign key on `pay_detail_id` in table 'pay_detail_record'

ALTER TABLE `pay_detail_record`
ADD CONSTRAINT `FK_pay_detail_record_ibfk_1`
    FOREIGN KEY (`pay_detail_id`)
    REFERENCES `pay_detail`
        (`pay_detail_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_pay_detail_record_ibfk_1'

CREATE INDEX `IX_FK_pay_detail_record_ibfk_1`
    ON `pay_detail_record`
    (`pay_detail_id`);



-- Creating foreign key on `salary_pay_id` in table 'salary_pay_detail'

ALTER TABLE `salary_pay_detail`
ADD CONSTRAINT `FK_salary_pay_detail_ibfk_2`
    FOREIGN KEY (`salary_pay_id`)
    REFERENCES `salary_pay`
        (`salary_pay_id`)
    ON DELETE NO ACTION ON UPDATE NO ACTION;


-- Creating non-clustered index for FOREIGN KEY 'FK_salary_pay_detail_ibfk_2'

CREATE INDEX `IX_FK_salary_pay_detail_ibfk_2`
    ON `salary_pay_detail`
    (`salary_pay_id`);



-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------