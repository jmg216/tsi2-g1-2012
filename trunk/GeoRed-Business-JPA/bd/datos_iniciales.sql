/*BACKOFFICE*/
/* Tipos Administradores*/
insert into geored.tipo_administrador (ID, NOMBRE) values (1, 'Aplicaci�n');

insert into geored.tipo_administrador (ID, NOMBRE) values (2, 'Empresa');

/* Administrador aplicacion */
insert into geored.administrador (ID, EMAIL, NOMBRE, PASS, TIPO_ADMINISTRADOR_FK) values (1, 'admin@geored.com', 'admin', 'admin', 1);

/* Administrador de Empresa Beauty */
insert into geored.administrador (ID, EMAIL, NOMBRE, PASS, TIPO_ADMINISTRADOR_FK) values (2, 'beauty@geored.com', 'beauty', 'beauty', 2);

/*Empresa con administrador */
insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, LOGO_URL, NOMBRE, ADMINISTRADOR_FK)
values (1, 'Empresa de cosmeticos', '22/12/2012', 'http://3.bp.blogspot.com/_jJXpVP_ML4I/SwL_OT1Nx6I/AAAAAAAAABw/OW8tlgJeN2U/S660/beauty.jpg', 'Beauty', 2);

/*Sitio de inter�s*/
insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, ADMINISTRADOR_FK) values (1, 'Buen lugar para hacer ejercicio', 'Gym Astro', '-34.883611, -56.181944', 1);

/*CONFIGURACI�N*/
/*Tematicas*/
insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (1, 'Lugar para ir de compras', 'Centro Comercial');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (2, 'Lugar para ir a comer', 'Patio de Comidas');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (3, 'Lugar no contemplado', 'Otros');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (4, 'Plaza publica', 'Plaza');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (5, 'Lugar para salir de noche', 'Club Nocturno');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (6, 'Ir de peliculas', 'Cine');


/*Tematicas de Sitios*/
insert into geored.tematica_sitio (ID, SITIO_FK, TEMATICA_FK) values (1, 1, 3);

/*FRONTOFFICE*/
/* Usuarios de la aplicaci�n */
insert into geored.usuario (ID, EMAIL, NOMBRE, PASS) values (1, 'vanessa@gmail,com', 'Vanessa Revetria', 'Vanessa');

insert into geored.usuario (ID, EMAIL, NOMBRE, PASS) values (2, 'juan@gmail,com', 'Juan Miraballes', 'Juan');

insert into geored.usuario (ID, EMAIL, NOMBRE, PASS) values (3, 'maximiliano@gmail,com', 'Maximiliano Silvera', 'Maximiliano');

insert into geored.usuario (ID, EMAIL, NOMBRE, PASS) values (4, 'marcelo@gmail,com', 'Marcelo Basan', 'Marcelo');

insert into geored.usuario (ID, EMAIL, NOMBRE, PASS) values (5, 'javier@gmail,com', 'Javier Dominguez', 'Javier');

/*Ingreso amistades*/
/*Vanessa amiga de todos*/
insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (1, 1, 2);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (2, 1, 3);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (3, 1, 4);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (4, 1, 5);

/*Juan amigo de Marcelo*/
insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (5, 2, 4);

/*Maxi amigo de Javier*/
insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (6, 3, 5);

/*Tematica de usuarios*/
insert into geored.tematica_usuario (ID, TEMATICA_FK, USUARIO_FK) values (1, 1, 1);/*Vanessa con tematica Centro Comercial*/
insert into geored.tematica_usuario (ID, TEMATICA_FK, USUARIO_FK) values (2, 2, 1);/*Vanessa con tematica Patio de Comidas*/

insert into geored.tematica_usuario (ID, TEMATICA_FK, USUARIO_FK) values (3, 3, 2);/*Juan con tematica Otros*/
insert into geored.tematica_usuario (ID, TEMATICA_FK, USUARIO_FK) values (4, 4, 2);/*Juan con tematica Plaza*/
