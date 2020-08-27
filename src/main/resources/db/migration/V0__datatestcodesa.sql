CREATE TABLE rol(
    r_id_rol serial not null,
    r_nombre character varying  not null
);

CREATE TABLE usuario(
    u_id_usuario serial not null,
    u_nombre character varying(30) not null,
    u_estado boolean  not null,
    u_id_rol INTEGER not null
);
--Agrega la llave primaria en  la tabla  rol
ALTER TABLE rol ADD CONSTRAINT pk_id_rol
PRIMARY KEY (r_id_rol);

--Agrega la llave primaria en  la tabla usuario
ALTER  TABLE usuario ADD CONSTRAINT  pk_id_usuario
PRIMARY KEY (u_id_usuario);

--Agrega la llave foranea en la tabla usuario
ALTER TABLE usuario ADD CONSTRAINT  fk_id_rol
FOREIGN KEY (u_id_rol)
REFERENCES rol (r_id_rol);
