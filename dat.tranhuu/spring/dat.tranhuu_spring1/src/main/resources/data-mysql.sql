INSERT INTO `vtispring`.`role` (`created_by`, `last_modified_by`,`name`)
SELECT * FROM (SELECT 'admin' as created_by , 'admin' as last_modified_by, 'ADMIN' as name) AS tmp
WHERE NOT EXISTS (
        SELECT name FROM `vtispring`.`role` WHERE name = 'ADMIN'
    ) LIMIT 1;
INSERT INTO `vtispring`.`role` (`created_by`, `last_modified_by`, `name`)
SELECT * FROM (SELECT 'admin' as created_by, 'admin' as last_modified_by,'SALER' as name) AS tmp
WHERE NOT EXISTS (
        SELECT name FROM `vtispring`.`role` WHERE name = 'SALER'
    ) LIMIT 1;
INSERT INTO `vtispring`.`role` (`created_by`, `last_modified_by`, `name`)
SELECT * FROM (SELECT 'admin' as created_by, 'admin' as last_modified_by, 'STAFFWARE' as name) AS tmp
WHERE NOT EXISTS (
        SELECT name FROM `vtispring`.`role` WHERE name= 'STAFFWARE'
    ) LIMIT 1;
INSERT INTO `vtispring`.`user` (`created_by`, `last_modified_by`, `password`, `username`, `enabled`)
SELECT * FROM (SELECT 'admin' as created_by, 'admin' as last_modified_by, '$2y$10$L1PZpGhYShaAzbdxeuTj9.Sf99byWcmSCbVerHKXV.WO6GSOjDQGq' as password, 'admin' as username, 1 as enabled) AS tmp
WHERE NOT EXISTS (
        SELECT username FROM `vtispring`.`user` WHERE username = 'admin'
    ) LIMIT 1;
INSERT INTO `vtispring`.`user_role` (`user_id`, `role_id`)
SELECT * FROM (SELECT 1 as user_id, 1 as role_id) AS tmp
WHERE NOT EXISTS (
        SELECT * FROM `vtispring`.`user_role` WHERE user_id = 1 AND role_id=1
    ) LIMIT 1;