drop table bienes_pedido_detalle
drop table cliente_bien_list
select * from impuesto_bienes
select * from impuesto
select * from bienes
select * from cliente
select * from cliente_bien_servicio
select * from estado
select * from pedido
select * from pedido_detalle
select * from pedido_impuesto
select * from usuario
insert into bienes 
values ( 1,2,3,4,5,6,7,8,9,10,11,12)
insert into impuesto 
values ('IVA', 20)
insert into cliente 
values (1,2,'calle','eze',5,6,7,'s.a.',9,'asd','a@gmail.com')
insert into estado 
values ( 20)
insert into pedido
values (1,2,3,4,'s.a.',6,7,8,2)
insert into pedido_detalle
values (1,2,3,4,5,6,7,'8',2,1,1)
insert into pedido_impuesto
values (2,2,1)
insert into usuario
values ('Ezequiel','123456',1,'Eze')