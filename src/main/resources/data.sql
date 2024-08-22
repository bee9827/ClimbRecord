insert into member (arm_length,introduction,length,name,start_date,member_id) values ('181','소개란1','182','A','2023-11-03',1);
insert into member (arm_length,introduction,length,name,start_date,member_id) values ('167','소개란2','165','B','2022-11-03',2);

insert into gym (name,gym_id) values ('더클라임 연남점',1);
insert into difficulty (color,gym_id,maximum,minimum,difficulty_id) values ('#ffffff',1,'V1','V0',1);
insert into difficulty (color,gym_id,maximum,minimum,difficulty_id) values ('#ff7f00',1,'V2','V1',2);
insert into difficulty (color,gym_id,maximum,minimum,difficulty_id) values ('#00ff80',1,'V3','V2',3);
insert into difficulty (color,gym_id,maximum,minimum,difficulty_id) values ('#0019f4',1,'V4','V3',4);

insert into record (body,climbing_date,success,taken_time,try_count,difficulty_id,gym_id,member_id,status,record_id) values ('좀 쉽네?','2024-08-11',NULL,NULL,NULL,4,1,1,0,1);
insert into record (body,climbing_date,success,taken_time,try_count,difficulty_id,gym_id,member_id,status,record_id) values ('할만하네','2024-08-11',NULL,NULL,NULL,4,1,1,0,2);
insert into record (body,climbing_date,success,taken_time,try_count,difficulty_id,gym_id,member_id,status,record_id) values ('많이 어렵네','2024-08-11',NULL,NULL,NULL,3,1,2,0,3);
