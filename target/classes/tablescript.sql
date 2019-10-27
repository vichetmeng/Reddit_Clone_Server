CREATE TABLE IF NOT exists USER (
	username VARCHAR(20) primary KEY,
    email VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    date_signed_up DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS TOPIC (
	id int primary key auto_increment,
    creator_username varchar(10) not null,
    name varchar(20) not null,
    rule text,
    description text,
    date_created DATE NOT NULL,
    constraint topic_creator_constraint foreign key(creator_username) references user(username)
);

CREATE TABLE IF NOT EXISTS POST (
	id int primary key auto_increment,
    topic_id int not null,
    username varchar(20) not null,
    title varchar(50) not null,
    content text not null,
    date_posted date not null,
    num_of_upvotes int default 0,
    num_of_downvotes int default 0,
    constraint post_topic_constraint foreign key(topic_id) references topic(id),
    constraint post_user_constraint foreign key (username) references user(username)
);

create table if not exists COMMENT (
	id int primary key,
    parent_comment_id int,
    post_id int not null,
    username varchar(20),
    content text not null,
    date_added date not null,
    num_of_upvotes int default 0,
    num_of_downvotes int default 0,
    constraint comment_parcomment_constraint foreign key (parent_comment_id) references comment(id),
    constraint comment_post_constraint foreign key (post_id) references post(id),
    constraint comment_user_constraint foreign key (username) references user(username)
);

create table if not exists MODERATOR_TOPIC (
	username varchar(20) not null,
    topic_id int not null,
    constraint moderator_pk_constraint primary key(username, topic_id)
);
create table if not exists USER_TOPIC (
	username varchar(20) not null,
    topic_id int not null,
    constraint user_topic_pk_constraint primary key(username, topic_id)
);

create table if not exists user_post_upvote (
	username varchar(20) not null,
    post_id int not null,
    constraint user_post_upvote_pk_constraint primary key(username, post_id)
);

create table if not exists user_post_downvote (
	username varchar(20) not null,
    post_id int not null,
    constraint user_post_downvote_pk_constraint primary key(username, post_id)
);



insert into user(username, email, password, date_signed_up) Values("vichetmeng", "vichet@infosys.com", "123456", CURDATE());


insert into topic(creator_username, name, date_created) values("vichetmeng", "FirstTopic", CURDATE());

insert into post(topic_id, username, title, content, date_posted) values(1,"vichetmeng", "post1 title", "post1 content", CURDATE());

drop table comment;
create table if not exists COMMENT (
	id int primary key auto_increment,
    parent_comment_id int,
    post_id int not null,
    username varchar(20),
    content text not null,
    date_added date not null,
    num_of_upvotes int default 0,
    num_of_downvotes int default 0,
    constraint comment_parcomment_constraint foreign key (parent_comment_id) references comment(id),
    constraint comment_post_constraint foreign key (post_id) references post(id),
    constraint comment_user_constraint foreign key (username) references user(username)
);

insert into comment(post_id, username, content, date_added) values(1, "vichetmeng", "First comment's content by vichet", CURDATE());
insert into comment(post_id, username, content, date_added) values(1, "vichetmeng", "second comment's content by vichet", CURDATE());
insert into comment(post_id, username, content, date_added) values(1, "vichetmeng", "third comment's content by vichet", CURDATE());
insert into comment(post_id, username, content, date_added) values(1, "vichetmeng", "fourth comment's content by vichet", CURDATE());
insert into comment(post_id, username, content, date_added) values(1, "vichetmeng", "fifth comment's content by vichet", CURDATE());

select * from user;
select * from topic;
select * from post;
select * from comment;



