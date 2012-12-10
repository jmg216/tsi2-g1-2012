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
values (3, ' Cadena de hoteles.', '2012-12-22', 'Days Inn', 'http://www.polticor.com/Clientes/days_inn.jpg', 4);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values(4, 'Contamos con un Resto-Pub donde podes disfrutar de nuestro delicioso menú con variedad de opciones y nuestra exclusiva carta de vinos.','2012-12-7','El Barzon', 'http://www.elbarzon.com.uy/wp-content/uploads/2010/09/elpub-300x198.jpg', 2);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values(5,'Indumentaria Unisex', '2012-12-7', 'Levis', 'http://www.blog.tendasesores.com/wp-content/uploads/2011/08/levis_historia12.jpg', 3);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values(6,'Todos los calzados para damas y caballeros.','2012-12-7', 'Toto', 'http://www.tarjetajoven.gub.uy/innovaportal/file/54035/1/toto_logo.jpg',2);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values(7, 'Tienda Inglesa ofrece 30.000 articulos de primera calidad que Ud. puede comprar en nuestras paginas seguras.', '2012-12-7', 'Tienda Inglesa', 'https://twimg0-a.akamaihd.net/profile_images/1669469797/41027_153194801363998_152900014726810_502492_5116700_n.jpg',3);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values(8, 'Empresa del estado cuyos negocios son el combustible, lubricantes, gas, alcoholes y portland.', '2012-12-7', 'Ancap', 'http://www.montevideotucasa.com/wp-content/uploads/2010/01/ancap_logo.gif', 4);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values(9, 'La empresa de comunicacion de los uruguayos.','2012-12-7', 'Antel', 'http://lh4.ggpht.com/_r5yemL8Ppv8/TPRLtw0M1KI/AAAAAAAAPtI/qs5yGsM82rA/Logo%20Antel%5B5%5D.jpg',2);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values(10, 'El Itaú es un banco que cuenta con varias sucursales en Montevideo y el Interior, en las que puede solicitar préstamos y obtener más información.', '2012-12-7', 'Itau', 'http://www.polticor.com/Clientes/banco-itau.jpg', 3);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values(11, 'Brinda una vasta gama de productos, acepta pedidos en línea y realiza envíos a domicilio.' ,'2012-12-7','Tata', 'http://www.polticor.com/Clientes/prom-tata01.gif', 4);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values(12, 'San Roque brinda un servicio integral e innovador en salud y belleza.' ,'2012-12-7', 'San Roque' , 'http://www.puntacarretasweb.com.uy/wp-content/uploads/2012/07/san-roque1.jpg', 2);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values(13, 'Un mundo con musical del uruguay y del mundo. Vende instrumentos musicales, accesorios, libros de música, partituras, entre otros productos.', '2012-12-7', 'Palacio de la Musica', 'http://a3.ec-images.myspacecdn.com/profile01/116/27468969b39d4fec8b2b93b9dc023452/p.jpg', 3);

insert into geored.empresa (ID, DESCRIPCION, FECHA_CREACION, NOMBRE, URL_IMAGEN,  ADMINISTRADOR_FK)
values(14, 'Red de cobranza y pagos, con locales en todo el país.', '2012-12-7', 'Abitab', 'http://www.conciertoproducciones.com/web/images/stories/logo_abitab_giros.jpg',4);


/*Locales de Beauty*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (1, '18 de Julio 922 esq. Convención, Montevideo', 'Local Centro' , '-34.905326, -56.185323', 2);

/*Locales de Ill Mondo de la Pizza*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (2, '21 de Setiembre 2816 esq. Ellauri, Montevideo', 'Local Pocitos' , '-34.918839,-56.156144', 2);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (3, '8 de Octubre 3401 esq. Bv. Batlle y Ordoñez, Montevideo', 'Local Union' , '-34.87896,-56.147776', 2);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (4, 'Francisco Vidal 722, Montevideo', 'Local Pocitos', '-34.91847,-56.149774', 1);

/*Locales de DaysInn*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (5, 'Acevedo Diaz 1821, Montevideo', 'Local Centro', '-34.893429,-56.167627', 3);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (6, 'Ruta 1, Colonia', 'Casa del Sol', '-34.445671,-57.783926', 3);

/*El Barzon*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (7, 'Rivera 2019', 'Local Cordon', '-34.902193,-56.172627', 4);

/*Levis*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (8, 'Los suspiros entre Syen y Exeter', 'Local Maldonado', '-34.909901,-54.853498', 5);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (9, 'Elias Regules y Carlos Reyles', 'Local Canelones, Costa de Oro', '-34.839978,-55.993799', 5);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (10, 'Ellauri 350', 'Local Punta Carretas, Montevideo', '-34.923502,-56.159581', 5);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (11, '18 de Julio 1069', 'Local Centro, Montevideo', '-34.903548,-56.180996', 5);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (12, 'Luis A. De Herrera 1290', 'Local Montevideo Shopping', '-34.90295,-56.136235', 5);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (13, 'Br. Artigas 1825', 'Local Tres Cruces, Montevideo', '-34.893781,-56.165567', 6);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (14, 'Luis A. De Herrera 1290', 'Local Montevideo Shopping', '-34.90295,-56.136235', 6);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (51, 'Ellauri 350', 'Local Punta Carretas, Montevideo', '-34.923502,-56.159581', 6);

/*Tienda inglesa*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (15, 'Avenida Italia 5820', 'Local Punta Gorda', '-34.88322,-56.081775', 7);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (16, 'José Batlle Ordoñez 3770', 'Local Joanico', '-34.853115,-56.181253', 7);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (17, 'Gral. L. Seregni Km 45', 'Local Atlantida', '-34.743869,-55.60741', 7);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (18, 'J.B.Blanco 966, Montevideo', 'Local Pocitos', '-34.910235,-56.14529', 7);

/*Ancap*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (19, 'Avenida Gral Eugenio Garzon, Montevideo', 'Local Colon', '-34.813803,-56.221957', 8);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (20, 'Juan Maria Perez entre Roque Graseras y Juan Benito Blanco, Montevideo', 'Local Pocitos', '-34.909021,-56.1478', 8);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (21, 'Ruta 8, Pando', 'Local Pando', '-34.721297,-55.960345', 8);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (22, 'Andres Areguati, Treinta y Tres', 'Local Treinta y Tres', '-33.238688,-54.395068', 2);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (23, 'Carmen, Durazno', 'Local Durazno', '-33.234093,-56.003687', 8);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (24, '25 de agosto esq. Alfredo Puig', 'Local Trinidad, Flores', '-33.516209,-56.896527', 8);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (25, '18 de Julio, Fray Bentos', 'Local Fray Bentos', '-33.142151,-58.28291', 8);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (26, 'Avenida Gral. Flores, Montevideo', 'Local Aguada', '-34.891273,-56.193171', 8);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (27, 'Avenida Dr. Luis A. de Herrera 2803, Montevideo', 'Local Larrañaga', '-34.877816,-56.156586', 8);

/*Antel*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (28, 'F. García Cortinas y Jose Luis Zorrilla de San Martin', 'Punta Carretas, Montevideo', '-34.924399,-56.160031',9);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (29, 'San Jose y Paraguay, Montevideo' , 'Local Centro' , '-34.906865,-56.192248' , 9);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (30, 'Cno. Capitan Pettirosi 4240,' , 'Local Manga' , '-34.80429,-56.13955' , 9);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (31, 'Treinta y Tres entre 25 de Mayo y Rincon, Montevideo' , 'Antel Telecentro' , '-34.906205,-56.205393' , 9);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (32, 'Avenida General José Gervasio Artigas' , 'Local Las Piedras' , '-34.723555,-56.215887' , 9);

/*Itau*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (33, 'Ellauri esq. 21 de Septiembre', 'Local Punta Carretas', '-34.919156,-56.155943',10);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (34, 'Dr. Gabriel Otero 6437','Local Carrasco, Montevideo','-34.889134,-56.057746', 10);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (35,'Avenida Brigadier General Juan Antonio Lavalleja 2084','Local Aguada, Montevideo','-34.89269,-56.187701',10);

/*Tata*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (36, 'Avenida General Jose Gervasio Artigas', 'Local Pando', '-34.716782,-55.961794', 11);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (37, 'Avenida General Jose Artigas esq. Avenida Dr. Enrique Pouey', 'Local Las Piedras', '-34.726659,-56.223492', 11);

/*San Roque*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (38, 'Avenida Ing. Luis Giannattasio, Ciudad de la Costa', 'Local Ciudad de la Costa', '-34.865651,-56.024193',12);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (39, 'Avda. Dr. Carlos Maria Ramirez 1490, Montevideo', 'Local Cerro', '-34.873134,-56.247064',12);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (40, 'José Ellauri 350, Montevideo', 'Local Punta Carretas Shopping', '-34.923977,-56.159498', 12);

/*Palacio de la musica*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (41, 'Avenida Italia 5775, Montevideo', 'Local Portones Shopping', '-34.881126,-56.081124',13);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (42, 'Av. 18 de Julio 1112 esq. Paraguay, Montevideo', 'Local Centro', '-34.906065,-56.192368',13);

/*Abitab*/
insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (43, 'Ituzaingo esq. Dr. Gallinal, Florida' , 'Local Florida' , '-34.100505,-56.215358', 14);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK)
values (44, 'Avda. Gral.San Martin 4250, Montevideo' , 'Local Cerrito 01-01' , '-34.848361,-56.170056', 14);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (45, 'Avenida Luis Battle Berres 6149, Montevideo' , 'Local Nuevo Paris 04-05' , '-34.839591,-56.262902',14);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (46, 'Cno. Castro 253, Montevideo' , 'Local Prado 05-01' , '-34.855299,-56.211598',14);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (48, 'Zabala 1384, Montevideo', 'Local Ciudad Vieja 12-00', '-34.907543,-56.207049', 14);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (49, 'Andes 1288, Montevideo', 'Local Ciudad Vieja', '-34.907754,-56.197865', 14);

insert into geored.local (ID, DIRECCION, NOMBRE, UBICACION_GEOGRAFICA, EMPRESA_FK) 
values (50, 'Paysandú 1341, Montevideo', 'Local Centro 19-25', '-34.9017,-56.187565', 14);

/*Sitio de interés*/
insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (1, 'Buen lugar para hacer ejercicio', 'Gym Astro', '-34.883611, -56.181944', 'http://theawkwardpint.files.wordpress.com/2012/05/93_1.jpeg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (2, 'Excelente lugar para tomarse', 'Cabo Bar', '-34.909522,-56.167894', 'http://lamochilademama.files.wordpress.com/2011/09/bar-fun-fun-mvdo.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (3, 'Para pasar la tarde', 'Plaza Seregni', '-34.896843,-56.171982', 'http://www.infocasas.com.uy/sitio/repo/img/plaza_seregni.jpeg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (4, 'Parque de juegos', 'Parque Rodó', '-34.913068,-56.1684', 'http://www.enlacesuruguayos.com/prodo1.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (5, 'Biblioteca pública', 'Biblioteca Nacional', '-34.902809,-56.177884', 'http://upload.wikimedia.org/wikipedia/commons/thumb/9/90/Biblioteca_Nacional_de_Uruguay_-_fachada.JPG/300px-Biblioteca_Nacional_de_Uruguay_-_fachada.JPG');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (6, 'Monumento nacional', 'Palacio Legislativo', '-34.891194,-56.187197', 'http://www.generalflores.com/imagenes/palacio/8379.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (7, 'Integrate de la Universidad de la Republica.', 'Faultad de Quimica', '-34.888589,-56.185373', 'http://www.vincealongi.com/montevideo/photos/Mvc-5900s.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (8, 'Central Termoelectrica', 'Central Termoelectrica Jose Batlle y Ordoñez', '-34.884382,-56.197778','http://woices.s3.amazonaws.com/audio_photos/26559/89ee6e1b.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN)
values (9, 'Lugar ideal para pasear, hacer caminatas o ejercicio y disfrutar del aire puro.', 'Parque Batlle', '-34.894414,-56.155464','http://www.reduruguaya.com/images/montevideo/Parque-Batlle-entrada.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (10, 'Club de Golf.', 'Club de golf, Punta Carretas', '-34.923414,-56.165978','http://t3.gstatic.com/images?q=tbn:ANd9GcSjyGppZKUDqFr-K1JeKRCooVWIKB_Htt8sTGe13c3P9YIbsSRgWyx6N4JL');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (11, 'Integrante de la Universidad de la Republica.', 'Facultad de Ingenieria', '-34.918206,-56.166027','http://www.stonek.com/FOTOS/_FOTOGRAFOS/dstonek/dstonek_12142.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN)
values (12, 'Principal Plaza de Montevideo.', 'Plaza Independencia', '-34.906381,-56.199814','http://www.mactravel.com.uy/img/montevideo_02.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN)
values (13, 'Estadio del Club Nacional de Futbol.', 'Gran Parque Central', '-34.884963,-56.15928','http://eldiario.com.uy/wp-content/uploads/2011/09/parquelleno2daetapa.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN)
values (14, 'Los cuernos de Battle.', 'Monumento a Batlle Berres', '-34.869472,-56.167735','http://mw2.google.com/mw-panoramio/photos/medium/17550985.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (15, 'Primer Hipodromo del Uruguay.', 'Hipodromo de Maroñas', '-34.838833,-56.143895','http://municipiof.montevideo.gub.uy/system/files/imagecache/articulo_completa/hip.-maronas10_0.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (16, 'Parque zoológico y centro de conservación de especies animales y vegetales.', 'Parque Lecocq', '-34.792237,-56.33517','http://www.uruguayeduca.edu.uy/UserFiles/P0001/Image/2009/AndrsHirigoyen/parque-lecocq.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN)
values (17, 'Aereopuerto internacional, Montevideo.', 'Aereopuerto Internacional de Carrasco', '-34.836632,-56.031698','http://eldiario.com.uy/wp-content/uploads/2011/07/aeropuerto-montevideo2.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN)
values (18, 'Parque para vacacionar. Amplias zonas destinadas al esparcimiento y a diferentes actividades al aire libre', 'Parque de Vaciones UTE-Antel', '-34.423054,-55.190214','http://2.bp.blogspot.com/_AqTTqzhaB44/R1cfjo5CCyI/AAAAAAAAA4k/Xqt7nbDVLG8/s400/parque+ute+antel1.jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (19, 'Area Natural Protegida.', 'Quebrada de los Cuervos', '-32.933488,-54.460653' ,'http://img.viajeauruguay.com/quebrada-de-los-cuervos(1).jpg');

insert into geored.sitio (ID, DESCRIPCION, NOMBRE, UBICACION_GEOGRAFICA, URL_IMAGEN) 
values (20, 'Barrio historico de Colonia del Sacramento.', 'Colonia del Sacramento', '-34.471397,-57.851521','http://www.arqhys.com/arquitectura/imagen/Colonia%20del%20Sacramento%20-%20Uruguay.jpg');


/*Tipos de notificacion*/
insert into geored.tipo_notificacion (ID, NOMBRE) values (1, 'Nueva oferta cercana');

insert into geored.tipo_notificacion (ID, NOMBRE) values (2, 'Nueva sitio cercano');

insert into geored.tipo_notificacion (ID, NOMBRE) values (3, 'Nuevo evento cercano');

insert into geored.tipo_notificacion (ID, NOMBRE) values (4, 'Check-in amigo cercano');

insert into geored.tipo_notificacion (ID, NOMBRE) values (5, 'Solicitud de amistad');

/*Tematicas*/
insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (1, 'Actividades relacionadas a los centros comerciales.', 'Centro Comercial');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (2, 'Relacionado a la gastronomia.', 'Patio de Comidas');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (3, 'Tematica no contemplada.', 'Otros');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (4, 'Plaza publica.', 'Plaza');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (5, 'Todo lo relacionado a la vida nocturna uruguaya.', 'Club Nocturno');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (6, 'Ir de peliculas.', 'Cine');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (7, 'Todo lo relacionado al ambito educativo.', 'Educacion');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (8, 'Relacionado a la industria.', 'Industria');

insert into geored.tematica (ID, DESCRIPCION, NOMBRE) values (9, 'Actividades recreativas.', 'Entretenimiento y Cultura');

/*Tematicas de Sitios*/
insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (3, 1);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (5, 2);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (4, 3);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (4, 4);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (3, 5);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (3, 6);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (7, 7);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (3, 8);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (4, 9);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (9, 10);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (7, 11);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (4, 12);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (9, 13);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (3, 14);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (9, 15);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (9, 16);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (3, 17);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (9, 18);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (3, 19);

insert into geored.sitio_tematica (TEMATICA_FK, SITIO_FK) values (3, 20);

/*FRONTOFFICE*/
/* Usuarios de la aplicación. Para la defensa probar con usuarios Marcelo y Juan*/
insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) 
values (1, true, 'lavarece@gmail.com', 'Vanessa Revetria', 'vanessa', 'https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-ash4/405360_10151190370950526_1747813305_n.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) 
values (2, true, 'juanma.miraballes@gmail.com', 'Juan Miraballes', 'juan', 'https://fbcdn-sphotos-f-a.akamaihd.net/hphotos-ak-snc7/399982_285605288159727_192778982_n.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) 
values (3, true, 'maxi.silveraf@gmail.com', 'Maximiliano silvera', 'maxi', 'https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-ash3/576335_3810865271033_638128563_n.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) 
values (4, false,'marcelobasan09@gmail.com', 'Marcelo Basan', 'marcelo', 'https://fbcdn-sphotos-h-a.akamaihd.net/hphotos-ak-ash4/431186_3072919616909_1477253359_n.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) 
values (5, false, 'jvrdom@gmail.com', 'Javier Dominguez', 'javier', 'https://fbcdn-sphotos-c-a.akamaihd.net/hphotos-ak-prn1/s480x480/542861_10151281688040851_465206331_n.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN)
values (6, false, 'andrea.geoplanet@gmail.com', 'Andrea Aravena', 'andrea', 'http://mouriz.files.wordpress.com/2010/02/cristina-aced.jpg?w=630');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN)
values (7, false, 'elizabetharmstrong39@gmail.com', 'Elizabeth Amstrong', 'elizabeth', 'http://www.juventudrebelde.cu/file/img/fotografia/2010/12/10380-fotografia-g.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) 
values (8, false, 'carlosarteaga.pef@gmail.com', 'Carlos Arteaga', 'carlos', 'http://elorbe.com/archivos/2011/03/En-2010-m%C3%A1s-de-800-mil-personas-incorporadas-a-un-empleo.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN)
values (9, false, 'oscar.brito@gmail.com', 'Oscar Brito', 'oscar', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcS2z-_v1tswMl9TSACwyoBZcFLamE27S5waKZBoAMDvPmH2hpen');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) 
values (10, false, 'carlaramosc@gmail.com', 'Carla Ramos', 'carla', 'http://cdn.enelbrasero.com/wp-content/uploads/2010/10/Taylor-Swift-gana-caso-contra-16-personas-vendiendo-mercanc%C3%ADa-falsificada-558x558.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN)
values (11, false, 'verorossic@gmail.com', 'Veronica Rossi', 'veronica', 'http://cdn.20minutos.es/img/2006/03/07/371969.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN)
values (12, false, 'victorvalenzuelal@gmail.com', 'Victor Valenzuela', 'victor', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTFwNTgd2BXxkPof_WEbGaLczqTetmP7-T_Su2dQPEdEAhWoGPdUg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN)
values (13, true, 'andrea.cardozo@gmail.com', 'Andrea Cardozo', 'andrea', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTJq7geogKdWp4Hv3RJD6sGOMho6owXQKUJvsCKQ9ckn3ifCPyz');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) 
values (14, true, 'victoriasansone@gmail.com', 'Victoria Sansone' , 'victoria' , 'http://cdn.vanidades.taconeras.net/files/2010/10/mujeres-felices.jpeg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN)
values (15, false, 'camila.diaz@gmail.com', 'Camila Diaz', 'camila', 'http://www.imagencr.com/imagenes/catalogo/mujeres/mujeres07.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN)
values (16, false, 'pablopereyra@gmail.com', 'Pablo Pereyra', 'pablo', 'http://3.bp.blogspot.com/-BKqLbGzomLA/Tui4vmV1G-I/AAAAAAAADvY/r2h2PmJpqSg/s320/pictures_of_dreadlock_hairstyles_6.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN)
values (17, true, 'leonardogonzalez@gmail.com', 'Leonardo Gonzalez', 'leonardo' , 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcRjj0FTgA7J-cDUVZi9onbceHfs1uGqNWYDIqsTSPb2-A_2nAb6eQ');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN)
values (18, false, 'eduardorocha@gmail.com', 'Eduardo Rocha', 'eduardo', 'http://4.bp.blogspot.com/_NVzPnvvYuLg/S63ZuIqshCI/AAAAAAAACCQ/AxnXs6JDvIY/s1600/adolescencia+sue%C3%B1o.jpg');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN) 
values (19, true, 'leticia.andrada@gmail.com', 'Leticia Andrada', 'leticia', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSRn83HyMjGst-DC1VtUTmPix_GGXCR7tJzCWKu0Bb0qIASt_-n');

insert into geored.usuario (ID, CONECTADO, EMAIL, NOMBRE, PASS, URL_IMAGEN)
values (20, false, 'luciaterra@gmail.com', 'Lucia Terra', 'lucia', 'https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTm-1Ob0JkYH-Xnc3cVR12u5d7uS5YQiMWdO_T0ESYfUq3_r8kp');

/*Ingreso amistades*/
insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (1, 1, 2);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (2, 1, 3);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (3, 1, 4);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (4, 1, 5);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (5, 2, 4);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (6, 2, 4);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (7, 2, 8);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (8, 2, 9);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (9, 2, 10);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (10, 2, 11);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (12, 2, 12);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (13, 2, 13);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (14, 4, 20);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (15, 4, 19);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (16, 4, 18);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (17, 4, 17);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (18, 4, 16);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (19, 4, 15);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (20, 4, 14);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (21, 4, 13);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (22, 4, 16);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (23, 3, 10);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (24, 3, 16);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (25, 3, 12);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (26, 4, 20);

insert into geored.amistad (ID, USUARIO_A_FK, USUARIO_B_FK) values (27, 3, 18);


/*Tematica de usuarios*/
insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (1, 1);/*Vanessa con tematica Centro Comercial*/

insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (2, 1);/*Vanessa con tematica Patio de Comidas*/

insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (3, 2);/*Juan con tematica Otros*/

insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (4, 2);/*Juan con tematica Plaza*/

insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (9, 2);/* Juan con tematica Entretenimeinto*/

insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (4, 4); /* Marcelo con tematica Plaza Publica*/

insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (9, 4); /* Marcelo con entretenimiento*/

insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (5, 4); /* Marcelo con tematica Club Nocturno*/

insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (6, 4); /* Marcelo con tematica Cine*/

insert into geored.usuario_tematica (TEMATICA_FK, USUARIO_FK) values (7, 4); /* Marcelo con tematica Educacion*/

/*CheckIns*/

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (1, '2012-09-22', 1, 3);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (2, '2012-11-11', 3, 1);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (3, '2012-07-01', 5, 4);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (4, '2012-12-15', 6, 2);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (5, '2012-11-15', 9, 4);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (6, '2012-12-22', 16, 4);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (7, '2012-12-01', 20, 4);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (8, '2012-11-07', 19, 4);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (9, '2012-12-13', 19, 2);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (10, '2012-12-14', 18, 2);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (11, '2012-11-19', 15, 2);

insert into geored.check_in(ID, FECHA_CREACION,SITIO_FK, USUARIO_FK) values (12, '2012-11-25', 11, 2);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (13, '2012-09-15', 11, 4);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (14, '2012-09-15', 4, 2);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (15, '2012-12-13', 12, 2);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (16, '2012-12-22', 16, 1);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (17, '2012-12-06', 11, 1);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (18, '2012-11-05', 4, 1);

insert into geored.check_in(ID, FECHA_CREACION, SITIO_FK, USUARIO_FK) values (19, '2012-12-18', 12, 1);

/* Eventos*/
insert into geored.evento (ID, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, UBICACION_GEOGRAFICA)
values (1, 'Exposicion de automoviles.', '2012-12-16', '2012-12-06', 'Semana del Automovilismo 2012', '-34.861127,-56.202861');

insert into geored.evento (ID, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, UBICACION_GEOGRAFICA) 
values (2, 'Fiesta de electronica', '2012-12-17', '2012-12-16', 'ElectronicFest', '-34.897816,-56.155914');

insert into geored.evento (ID, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, UBICACION_GEOGRAFICA)
values (3, 'Segundo congreso sobre el futuro de la industria uruguaya.', '2013-03-03', '2013-01-03', 'II Congreso Industria 2013', '-34.905695,-56.199544');

insert into geored.evento (ID, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, UBICACION_GEOGRAFICA) 
values (4, 'Concurso de carnaval 2013', '2013-01-23', '2013-01-10', 'Carnaval', '-34.919754,-56.169794');

insert into geored.evento (ID, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, UBICACION_GEOGRAFICA)
values (5, 'Festival de Jazz, Punta del Este 2013', '2013-01-06', '2013-01-03', 'Festival de Jazz', '-34.948498,-54.933596');

insert into geored.evento (ID, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, UBICACION_GEOGRAFICA)
values (6, 'Fiesta popular, Barrios Sur y Palermo', '2013-02-05', '2013-02-03', 'Desfile de Llamadas', '');

insert into geored.evento (ID, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, UBICACION_GEOGRAFICA)
values (7, 'Carnaval inspirado en el carnaval de Rio de Janeiro', '2013-02-15', '2013-02-09', 'Carnaval Artigas', '-30.404009,-56.469022');

insert into geored.evento (ID, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, UBICACION_GEOGRAFICA) 
values (8, 'Festival de Folklore a orillas del rio Olimar', '2013-04-13', '2013-04-09', 'Festival del Olimar', '-33.243022,-54.400576');

insert into geored.evento (ID, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, UBICACION_GEOGRAFICA)
values (9, 'Actividad para educar y hacer conciencia sobre la salud del corazon.', '2013-04-07', '2013-04-04', 'Semana del Corazon', '-34.888219,-56.186317');

insert into geored.evento (ID, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, UBICACION_GEOGRAFICA) 
values (10, 'La mayor fiesta folklorica del Pais', '2013-05-12', '2013-05-04', 'Fiesta de la Patria Gaucha', '-31.721889,-55.99913');

/* Eventos Tematica*/
insert into geored.evento_tematica (EVENTO_FK, TEMATICA_FK) values (1, 8);

insert into geored.evento_tematica (EVENTO_FK, TEMATICA_FK) values (1, 9);

insert into geored.evento_tematica (EVENTO_FK, TEMATICA_FK) values (2, 9);

insert into geored.evento_tematica (EVENTO_FK, TEMATICA_FK) values (3, 8);

insert into geored.evento_tematica (EVENTO_FK, TEMATICA_FK) values (4, 9);

insert into geored.evento_tematica (EVENTO_FK, TEMATICA_FK) values (5, 9);

insert into geored.evento_tematica (EVENTO_FK, TEMATICA_FK) values (6, 9);

insert into geored.evento_tematica (EVENTO_FK, TEMATICA_FK) values (7, 9);

insert into geored.evento_tematica (EVENTO_FK, TEMATICA_FK) values (8, 9);

insert into geored.evento_tematica (EVENTO_FK, TEMATICA_FK) values (9, 7);

insert into geored.evento_tematica (EVENTO_FK, TEMATICA_FK) values (10, 9);

/* Ofertas*/
insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK) 
values (1, 8080.19, 'Modelo JBP0605, Incluye 5 cuerpos de medidas standard : 12" /13" /14" / 16"/ 22"', '2012-12-30', '2012-12-15', 'Bateria Power Beat Completa', 'http://www.palaciodelamusica.com.uy/mvdcommerce/imgUpload/jbp0605_g.jpg', 41);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK) 
values (2, 8080.19, 'Modelo JBP0605, Incluye 5 cuerpos de medidas standard : 12" /13" /14" / 16"/ 22"', '2012-12-30', '2012-12-15', 'Bateria Power Beat Completa', 'http://www.palaciodelamusica.com.uy/mvdcommerce/imgUpload/jbp0605_g.jpg', 42);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (3, 4029.27, 'Modelo FT6418L, Fina terminación en baño dorado', '2012-12-30', '2012-12-15', 'Trompeta Memphis', 'http://www.palaciodelamusica.com.uy/mvdcommerce/imgUpload/ft6418l_g.jpg', 41);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (4, 4029.27, 'Modelo JBP0605, Incluye 5 cuerpos de medidas standard : 12" /13" /14" / 16"/ 22"', '2012-12-30', '2012-12-15', 'Trompeta Memphis', 'http://www.palaciodelamusica.com.uy/mvdcommerce/imgUpload/ft6418l_g.jpg', 42);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (5, 1500.00, 'Liquidacion de Jeans para damas y caballeros, todos los talles.', '2013-01-20', '2012-12-20', 'Jeans', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQErdj47n09VsMl6Kcy3WW3JlwYI6oVk8BVpAHEaDpUl-3nf1VqGQ', 51);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (6, 1500.00, 'Liquidacion de Jeans para damas y caballeros, todos los talles.', '2013-01-20', '2012-12-20', 'Jeans', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQErdj47n09VsMl6Kcy3WW3JlwYI6oVk8BVpAHEaDpUl-3nf1VqGQ', 14);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (7, 1500.00, 'Liquidacion de Jeans para damas y caballeros, todos los talles.', '2013-01-20', '2012-12-20', 'Jeans', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQErdj47n09VsMl6Kcy3WW3JlwYI6oVk8BVpAHEaDpUl-3nf1VqGQ', 13);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (8, 215.00, 'Cerveza Corona 355cc X6U', '2013-01-20', '2012-12-12', 'Cerveza Corona', 'http://fotosti.e-tradeconsult.com/390x315/VM098000/VM098012-1.jpg', 15);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK) 
values (9, 215.00, 'Cerveza Corona 355cc X6U', '2013-01-20', '2012-12-12', 'Cerveza Corona', 'http://fotosti.e-tradeconsult.com/390x315/VM098000/VM098012-1.jpg', 16);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK) 
values (10, 215.00, 'Cerveza Corona 355cc X6U', '2013-01-20', '2012-12-12', 'Cerveza Corona', 'http://fotosti.e-tradeconsult.com/390x315/VM098000/VM098012-1.jpg', 17);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK) 
values (11, 215.00, 'Cerveza Corona 355cc X6U', '2013-01-20', '2012-12-12', 'Cerveza Corona', 'http://fotosti.e-tradeconsult.com/390x315/VM098000/VM098012-1.jpg', 18);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (12, 9999.00, 'Televisor LG LCD 32, HD LK330', '2013-01-07', '2012-12-11', 'TV', 'http://fotosti.e-tradeconsult.com/230x170/VM301100/VM301194-1.jpg', 18);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (13, 9999.00, 'Televisor LG LCD 32, HD LK330', '2013-01-07', '2012-12-11', 'TV', 'http://fotosti.e-tradeconsult.com/230x170/VM301100/VM301194-1.jpg', 16);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (14, 9999.00, 'Televisor LG LCD 32, HD LK330', '2013-01-07', '2012-12-11', 'TV', 'http://fotosti.e-tradeconsult.com/230x170/VM301100/VM301194-1.jpg', 17);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (15, 850.00,'Entradas 2X1 para ver a Armandinho en vivo en el Teatro de Verano', '2012-12-20', '2012-12-10', 'Entradas 2X1 Armandinho', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSjhO33E5eeJJDbR3v1clRpesHI6pE6N15maiYHfH-74Xd2bh368A', 44);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK) 
values (16, 850.00,'Entradas 2X1 para ver a Armandinho en vivo en el Teatro de Verano', '2012-12-20', '2012-12-10', 'Entradas 2X1 Armandinho', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSjhO33E5eeJJDbR3v1clRpesHI6pE6N15maiYHfH-74Xd2bh368A', 45);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (17, 850.00,'Entradas 2X1 para ver a Armandinho en vivo en el Teatro de Verano', '2012-12-20', '2012-12-10', 'Entradas 2X1 Armandinho', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSjhO33E5eeJJDbR3v1clRpesHI6pE6N15maiYHfH-74Xd2bh368A', 46);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK) 
values (19, 850.00,'Entradas 2X1 para ver a Armandinho en vivo en el Teatro de Verano', '2012-12-20', '2012-12-10', 'Entradas 2X1 Armandinho', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSjhO33E5eeJJDbR3v1clRpesHI6pE6N15maiYHfH-74Xd2bh368A', 48);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (21, 850.00,'Entradas 2X1 para ver a Armandinho en vivo en el Teatro de Verano', '2012-12-20', '2012-12-10', 'Entradas 2X1 Armandinho', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSjhO33E5eeJJDbR3v1clRpesHI6pE6N15maiYHfH-74Xd2bh368A', 49);

insert into geored.oferta(ID, COSTO, DESCRIPCION, FECHA_FIN, FECHA_INICIO, NOMBRE, URL_IMAGEN, LOCAL_FK)
values (22, 850.00,'Entradas 2X1 para ver a Armandinho en vivo en el Teatro de Verano', '2012-12-20', '2012-12-10', 'Entradas 2X1 Armandinho', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcSjhO33E5eeJJDbR3v1clRpesHI6pE6N15maiYHfH-74Xd2bh368A', 50);

/* Compras*/
insert into geored.compra(ID, FECHA_CREACION, OFERTA_FK, USUARIO_FK) values (1, '2012-12-18', 22, 2); /*Compra Juan*/

insert into geored.compra(ID, FECHA_CREACION, OFERTA_FK, USUARIO_FK) values (2, '2012-12-12', 11, 2); /*Compra Juan*/

insert into geored.compra(ID, FECHA_CREACION, OFERTA_FK, USUARIO_FK) values (3, '2012-12-25', 5 ,4); /*Compra Marcelo*/

insert into geored.compra(ID, FECHA_CREACION, OFERTA_FK, USUARIO_FK) values (4, '2012-12-16', 11, 4); /*Compra Marcelo*/

insert into geored.compra(ID, FECHA_CREACION, OFERTA_FK, USUARIO_FK) values (5, '2012-12-11', 22, 4); /*Compra Marcelo*/

insert into geored.compra(ID, FECHA_CREACION, OFERTA_FK, USUARIO_FK) values (6, '2012-12-31', 8, 3); /*Compra Maxi*/

insert into geored.compra(ID, FECHA_CREACION, OFERTA_FK, USUARIO_FK) values (7, '2012-12-20',11 , 3); /*Compra Maxi*/

insert into geored.compra(ID, FECHA_CREACION, OFERTA_FK, USUARIO_FK) values (8, '2012-12-10', 22, 1); /*Compra Maxi*/

insert into geored.compra(ID, FECHA_CREACION, OFERTA_FK, USUARIO_FK) values (9, '2012-12-20', 5, 1); /*Compra Vane*/
