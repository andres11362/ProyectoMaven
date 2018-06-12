/* Populate tables */
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(1, 'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2017-08-28');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(2, 'John', 'Doe', 'john.doe@gmail.com', '2017-08-28');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(3, 'Andrei', 'Tafur', 'correo1@gmail.com', '2018-06-08');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(4, 'Andres', 'Gongora', 'correo2@gmail.com', '2018-06-08');
INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(5, 'Prueba', 'Ache2', 'correo3@gmail.com', '2018-06-08');

INSERT INTO productos(id, nombre, cantidad, precio, observacion) VALUES(1,'Lulo', 100, 20000, 'Esto es un lulo');
INSERT INTO productos(id, nombre, cantidad, precio, observacion) VALUES(2,'Maracuya', 200, 12000, 'Esto es un maracuya');
INSERT INTO productos(id, nombre, cantidad, precio, observacion) VALUES(3,'Mora', 500, 17000, 'Esto es una mora');

INSERT INTO facturas(id, nombre, id_cliente) VALUES(1,'Empresa',1);
INSERT INTO facturas(id, nombre, id_cliente) VALUES(2,'Empresa',2);
INSERT INTO facturas(id, nombre, id_cliente) VALUES(3,'Empresa',5);

INSERT INTO productos_lista_factura(lista_productos_id, lista_factura_id) VALUES(1,1);
INSERT INTO productos_lista_factura(lista_productos_id, lista_factura_id) VALUES(2,1);
INSERT INTO productos_lista_factura(lista_productos_id, lista_factura_id) VALUES(3,1);
INSERT INTO productos_lista_factura(lista_productos_id, lista_factura_id) VALUES(1,2);
INSERT INTO productos_lista_factura(lista_productos_id, lista_factura_id) VALUES(2,2);
INSERT INTO productos_lista_factura(lista_productos_id, lista_factura_id) VALUES(3,2);
INSERT INTO productos_lista_factura(lista_productos_id, lista_factura_id) VALUES(3,3);
INSERT INTO productos_lista_factura(lista_productos_id, lista_factura_id) VALUES(2,3);



