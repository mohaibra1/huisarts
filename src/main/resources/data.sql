insert into DOCTOR (ID,FIRST_NAME,LAST_NAME)
values(1,'Mohamed', 'Ali');

insert into patient (id, first_name, last_name, address, city, email, password, telephone, doctor_id)
values(1,'Jay','lay', 'waterloosstraat', 'Antwerpen', 'mimohadinho@gmail.com', 'achteraf','0492117785',1 );

insert into visits(id,date_visit,description,patient_id)
values (1, '2020-03-26','Longontsteking',1)

