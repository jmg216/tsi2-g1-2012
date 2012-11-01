/* Tipos Administradores*/
insert into tipo_administrador (ID, NOMBRE)
values (1, 'Aplicación');

insert into tipo_administrador (ID, NOMBRE)
values (2, 'Empresa');

/* Administrador aplicacion */
insert into administrador (ID, EMAIL, NOMBRE, PASS, TIPO_ADMINISTRADOR_FK)
values (1, 'admin@geored.com', 'admin', 1);