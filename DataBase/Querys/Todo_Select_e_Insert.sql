select * from impuesto
select * from bienes
select * from cliente
select * from estado
select * from pedido
select * from pedido_detalle
select * from pedido_impuesto
select * from usuario
select * from bien_impuesto
insert into bienes 
values ( 'Producto',2,30.0, 'TV',500.0, null, null)
insert into impuesto 
values ('IVA', 20)
insert into cliente 
values ('Persona',2,'calle','eze@','123456',null,null,null,39000000,'Perez','Fer',null)
insert into pedido
values (1,'true',30,400,'s.a.',6,7,8,null,1,2)
insert into pedido_detalle
values (1,2,3,4,5,6,7,8,1,2,1)
insert into pedido_impuesto
values (2,2,1)
insert into usuario
values ('Ezequiel','123456',1,'Eze')
insert into bien_impuesto
values (1,1)