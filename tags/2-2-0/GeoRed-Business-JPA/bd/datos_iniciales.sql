/*BACKOFFICE*/
/* Tipos Administradores*/
insert into geored.tipo_administrador (ID, NOMBRE) values (1, 'Aplicación');

insert into geored.tipo_administrador (ID, NOMBRE) values (2, 'Empresa');

/* Administrador aplicacion */
insert into geored.administrador (ID, EMAIL, NOMBRE, PASS, TIPO_ADMINISTRADOR_FK) values (1, 'tsi2.g1@gmail.com', 'admin', '21232f297a57a5a743894a0e4a801fc3', 1);

/* Administrador de Empresa Beauty */
insert into geored.administrador (ID, EMAIL, NOMBRE, PASS, TIPO_ADMINISTRADOR_FK) values (2, 'maxi.silveraf@gmail.com', 'Maximiliano Silvera', '21232f297a57a5a743894a0e4a801fc3', 2);

/* Administrador de Il mondo */
insert into geored.administrador (ID, EMAIL, NOMBRE, PASS, TIPO_ADMINISTRADOR_FK) values (3, 'lavarece@gmail.com', 'Vanessa Revetria', '21232f297a57a5a743894a0e4a801fc3', 2);

/* Administrador de Teatro Solis */
insert into geored.administrador (ID, EMAIL, NOMBRE, PASS, TIPO_ADMINISTRADOR_FK) values (4, 'juanma.miraballes@gmail.com', 'Juan Manuel Miraballes', '21232f297a57a5a743894a0e4a801fc3', 2);


/*Empresa con administrador */
insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values (1, 'Empresa de cosmeticos', '2012-12-22', 'Beauty', 'http://3.bp.blogspot.com/_jJXpVP_ML4I/SwL_OT1Nx6I/AAAAAAAAABw/OW8tlgJeN2U/S660/beauty.jpg', 2);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values (2, 'La pizza del mondo es un clásico de este restaurante de minutas y comida rápida. Y tiene de todo: jamón, tomate en rodajas, huevo, morrón, palmitos y salsa golf.', '2012-12-22', 'Il Mondo della Pizza', 'http://profile.ak.fbcdn.net/hprofile-ak-prn1/27535_133395436676362_7639_n.jpg', 3);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values (3, 'El Teatro Solís es hoy el mayor referente patrimonial de las artes escénicas de Uruguay y su primer escenario.', '2012-12-22', 'Teatro Solis', 'http://www.ithu.edu.uy/imagenes/teatro-solis.jpg', 4);


/*Sitio de interés*/
insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) values (1, 'Buen lugar para hacer ejercicio', 'Gym Astro', '-34.883611, -56.181944', 'http://theawkwardpint.files.wordpress.com/2012/05/93_1.jpeg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) values (2, 'Excelente lugar para tomarse', 'Cabo Bar', '-34.909522,-56.167894', 'http://lamochilademama.files.wordpress.com/2011/09/bar-fun-fun-mvdo.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) values (3, 'Para pasar la tarde', 'Plaza Seregni', '-34.896843,-56.171982', 'http://www.infocasas.com.uy/sitio/repo/img/plaza_seregni.jpeg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) values (4, 'Parque de juegos', 'Parque Rodó', '-34.913068,-56.1684', 'http://www.enlacesuruguayos.com/prodo1.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) values (5, 'Biblioteca pública', 'Biblioteca Nacional', '-34.902809,-56.177884', 'http://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Biblioteca_Nacional_de_Uruguay_-_fachada.JPG/300px-Biblioteca_Nacional_de_Uruguay_-_fachada.JPG');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) values (6, 'Monumento nacional', 'Palacio Legislativo', '-34.891194,-56.187197', 'http://www.generalflores.com/imagenes/palacio/8379.jpg');


/*CONFIGURACIÓN*/

/*Tipos de notificacion*/
insert into geored.tipo_notificacion (ID, NOMBRE) values (1, 'Nueva oferta cercana');

insert into geored.tipo_notificacion (ID, NOMBRE) values (2, 'Nueva sitio cercano');

insert into geored.tipo_notificacion (ID, NOMBRE) values (3, 'Nuevo evento cercano');

insert into geored.tipo_notificacion (ID, NOMBRE) values (4, 'Check-in amigo cercano');

insert into geored.tipo_notificacion (ID, NOMBRE) values (5, 'Solicitud de amistad');

/*Tematicas*/
insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (1, 'Lugar para ir de compras', 'Centro Comercial');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (2, 'Lugar para ir a comer', 'Patio de Comidas');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (3, 'Lugar no contemplado', 'Otros');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (4, 'Plaza publica', 'Plaza');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (5, 'Lugar para salir de noche', 'Club Nocturno');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (6, 'Ir de peliculas', 'Cine');

/*Tematicas de Sitios*/
insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (3, 1);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (5, 2);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (4, 3);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (4, 4);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (3, 5);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (3, 6);

/*FRONTOFFICE*/
/* Usuarios de la aplicación */
insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) values (1, true, 'vanessa@gmail.com', 'Vanessa Revetria', 'vanessa', 'https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-ash4/405360_10151190370950526_1747813305_n.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) values (2, true, 'juanma.miraballes@gmail.com', 'Juan Miraballes', 'juan', 'https://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-snc7/399982_285605288159727_192778982_n.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) values (3, true, 'maximiliano@gmail.com', 'Maximiliano silvera', 'Maximiliano', 'https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-ash3/576335_3810865271033_638128563_n.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) values (4, false,'marcelo@gmail.com', 'Marcelo Basan', 'marcelo', 'https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-ash4/431186_3072919616909_1477253359_n.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) values (5, false, 'javier@gmail.com', 'Javier Dominguez', 'javier', 'https://fbcdn-sphotos-c-a.akamaihd.net/hphotos-ak-prn1/s480x480/542861_10151281688040851_465206331_n.jpg');

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
insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (1, 1);/*Vanessa con tematica Centro Comercial*/
insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (2, 1);/*Vanessa con tematica Patio de Comidas*/

insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (3, 2);/*Juan con tematica Otros*/
insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (4, 2);/*Juan con tematica Plaza*/

/*CheckIns*/

insert into geored.check_in(ID, FECHA_CREACION, NOMBRE, SITIO_FK, USUARIO_FK) values (1, '2012-09-22', 'Gym Astro' ,  1, 3);

insert into geored.check_in(ID, FECHA_CREACION, NOMBRE, SITIO_FK, USUARIO_FK) values (2, '2012-11-11', 'Plaza Seregni' , 3, 1);

insert into geored.check_in(ID, FECHA_CREACION, NOMBRE, SITIO_FK, USUARIO_FK) values (3, '2012-07-01', 'Biblioteca Nacional' , 5, 4);

insert into geored.check_in(ID, FECHA_CREACION, NOMBRE, SITIO_FK, USUARIO_FK) values (4, '2012-09-15', 'Palacion Legislativo' , 6, 2);
