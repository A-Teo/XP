CREATE TABLE responsable (
 idresponsable SERIAL,
 nombre VARCHAR(20),
 PRIMARY KEY(idresponsable)
);

CREATE TABLE tipogasto (
  idtipogasto SERIAL,
  tipo VARCHAR(50),
  PRIMARY KEY(idtipogasto)
);

CREATE TABLE gasto
(
  idgasto SERIAL,
  tipogasto_idtipogasto INTEGER,
  responsable_idresponsable INTEGER,
  item VARCHAR(50),
  moneda VARCHAR(3),
  fecha DATE,
  detalle VARCHAR(1000),
  monto DOUBLE PRECISION,
  PRIMARY KEY (idgasto, responsable_idresponsable),
  FOREIGN KEY (tipogasto_idtipogasto)
      REFERENCES tipogasto (idtipogasto)
      ON UPDATE NO ACTION
      ON DELETE NO ACTION,
  FOREIGN KEY (responsable_idresponsable)
      REFERENCES responsable (idresponsable)
      ON UPDATE NO ACTION
      ON DELETE NO ACTION
)