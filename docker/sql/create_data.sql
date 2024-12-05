create table IF NOT EXISTS ticket (
id integer not null,
date_emission date not null,
constraint  pk_ticket_id primary key (id));

create table IF NOT EXISTS article (
id integer not null,
ticket_id integer not null,
quantite integer null,
libelle varchar(200),
montant smallint not null,
prix_unite smallint not null,
constraint  pk_artile_id primary key (id),
constraint  fk_ticket_id foreign key (id) references ticket(id)
);


insert into ticket values(1, '2024-12-01');
insert into ticket values(2, '2024-12-01');

insert into article values(1, 1,2,'pizza jambon champignon', 10.50, 5.25);
insert into article values(2, 1,1,'pack de biere', 9.99, 9.99);