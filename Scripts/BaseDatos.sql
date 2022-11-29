CREATE TABLE `prueba`.`cliente` (
  `cliente_id` INT(10) NOT NULL AUTO_INCREMENT COMMENT 'Llave principal de la tabla', 
  `nombre` VARCHAR(100) NOT NULL COMMENT 'nombre cliente', 
  `genero` VARCHAR(5) NULL COMMENT 'genero cliente', 
  `edad` INT(3) NULL COMMENT 'edad cliente', 
  `identificacion` VARCHAR(10) NOT NULL COMMENT 'identificacion cliente', 
  `direccion` VARCHAR(100) NULL COMMENT 'direccion cliente', 
  `telefono` INT(10) NULL COMMENT 'telefono cliente', 
  `contrasena` VARCHAR(100) NOT NULL COMMENT 'clave cliente', 
  `estado` BOOLEAN NOT NULL COMMENT 'estado cliente', 
  PRIMARY KEY (`cliente_id`)
);


CREATE TABLE `prueba`.`cuenta` (
  `cuenta_id` INT(18) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria', 
  `numero_cuenta` INT(18) NOT NULL COMMENT 'numero cuenta', 
  `tipo_cuenta` VARCHAR(10) NOT NULL COMMENT 'tipo de cuenta', 
  `saldo_inicial` INT(20) NOT NULL COMMENT 'saldo inicial', 
  `estado` BOOLEAN NOT NULL COMMENT 'estado cuenta', 
  `cliente_id` INT(20) NOT NULL COMMENT 'id del cliente',
  `saldo_actual` INT(20) NOT NULL COMMENT 'saldo actual de la cuenta',  
  PRIMARY KEY (`cuenta_id`)
);

CREATE TABLE `prueba`.`movimientos` (
  `movimiento_id` INT(18) NOT NULL AUTO_INCREMENT COMMENT 'llave primaria', 
  `fecha` DATE NOT NULL COMMENT 'fecha movimiento', 
  `tipo_movimiento` VARCHAR(50) NOT NULL COMMENT 'tipo movimiento', 
  `valor` INT(20) NOT NULL COMMENT 'valor del movimiento', 
  `saldo` INT(20) NOT NULL COMMENT 'saldo despues del movimiento', 
  `cuenta_id` INT(18) NOT NULL COMMENT 'id de la cuenta', 
  PRIMARY KEY (`movimiento_id`)
);


ALTER TABLE `cuenta` 
ADD CONSTRAINT `fk_clientid_cuenta` 
FOREIGN KEY (`cliente_id`) 
REFERENCES `cliente`(`cliente_id`) 
ON DELETE CASCADE ON UPDATE NO ACTION;


ALTER TABLE `movimientos` 
ADD CONSTRAINT `fk_cuentaid_mov` 
FOREIGN KEY (`cuenta_id`) 
REFERENCES `cuenta`(`cuenta_id`) 
ON DELETE CASCADE ON UPDATE NO ACTION;






