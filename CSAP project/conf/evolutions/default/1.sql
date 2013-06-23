# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table apply (
  email                     varchar(255) not null,
  name                      varchar(255),
  graduationyear            integer,
  job                       varchar(255),
  constraint pk_apply primary key (email))
;

create table archive (
  title                     varchar(255) not null,
  description               varchar(255),
  constraint pk_archive primary key (title))
;

create table contact (
  email                     varchar(255) not null,
  message                   varchar(255),
  constraint pk_contact primary key (email))
;

create table news (
  title                     varchar(255) not null,
  description               varchar(255),
  privacy                   varchar(255),
  file                      varchar(255),
  path                      varchar(255),
  constraint pk_news primary key (title))
;

create table Student (
  id                        integer auto_increment not null,
  name                      varchar(255),
  pic                       varchar(255),
  lastname                  varchar(255),
  fathername                varchar(255),
  email                     varchar(255),
  cn                        integer,
  ecn                       integer,
  password                  varchar(255),
  passwordconf              varchar(255),
  current                   varchar(255),
  main                      varchar(255),
  constraint pk_Student primary key (id))
;

create table sign (
  email                     varchar(255) not null,
  password                  varchar(255),
  constraint pk_sign primary key (email))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table apply;

drop table archive;

drop table contact;

drop table news;

drop table Student;

drop table sign;

SET FOREIGN_KEY_CHECKS=1;

