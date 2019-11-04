ALTER TABLE SubRedditMonitor DROP FOREIGN KEY FKSubRedditM670013;
ALTER TABLE SubRedditMonitor DROP FOREIGN KEY FKSubRedditM440551;
ALTER TABLE SubRedditMember DROP FOREIGN KEY FKSubRedditM666300;
ALTER TABLE SubRedditMember DROP FOREIGN KEY FKSubRedditM534752;
ALTER TABLE Post DROP FOREIGN KEY FKPost964424;
ALTER TABLE Post DROP FOREIGN KEY FKPost734962;
ALTER TABLE User_Upvoted DROP FOREIGN KEY FKUser_Upvot266903;
ALTER TABLE User_Upvoted DROP FOREIGN KEY FKUser_Upvot507957;
ALTER TABLE User_Downvoted DROP FOREIGN KEY FKUser_Downv55394;
ALTER TABLE User_Downvoted DROP FOREIGN KEY FKUser_Downv296448;
ALTER TABLE Comment DROP FOREIGN KEY FKComment916862;
ALTER TABLE Comment DROP FOREIGN KEY FKComment675808;
ALTER TABLE Comment DROP FOREIGN KEY FKComment504122;
ALTER TABLE User_Save DROP FOREIGN KEY FKUser_Save464157;
ALTER TABLE User_Save DROP FOREIGN KEY FKUser_Save223103;
ALTER TABLE Blacklist DROP FOREIGN KEY FKBlacklist253807;
ALTER TABLE Blacklist DROP FOREIGN KEY FKBlacklist516730;
DROP TABLE IF EXISTS User_Downvoted;
DROP TABLE IF EXISTS User_Save;
DROP TABLE IF EXISTS User_Upvoted;
DROP TABLE IF EXISTS SubRedditMember;
DROP TABLE IF EXISTS SubRedditMonitor;
DROP TABLE IF EXISTS Blacklist;
DROP TABLE IF EXISTS Comment;
DROP TABLE IF EXISTS Post;
DROP TABLE IF EXISTS Topic;
DROP TABLE IF EXISTS User;


CREATE TABLE Blacklist (
  UserUId int(10) NOT NULL, 
  TopicId int(10) NOT NULL, 
  PRIMARY KEY (UserUId, 
  TopicId));
CREATE TABLE Comment (
  CId            int(10) NOT NULL AUTO_INCREMENT, 
  Content        text NOT NULL, 
  Upvote_Count   int(10) DEFAULT 0 NOT NULL, 
  Downvote_Count int(10) DEFAULT 0 NOT NULL, 
  PostPId        int(10) NOT NULL, 
  UserUId        int(10), 
  ParentCId      int(10), 
  Date_Created   datetime NOT NULL, 
  PRIMARY KEY (CId), 
  UNIQUE INDEX (CId));
CREATE TABLE Post (
  PId            int(10) NOT NULL AUTO_INCREMENT,
  title          varchar(255) not null,
  Content        text NOT NULL, 
  TopicId        int(10) NOT NULL, 
  UserUId        int(10), 
  picture_url    varchar(255) NOT NULL, 
  Upvote_Count   int(10) DEFAULT 0 NOT NULL, 
  Downvote_Count int(10) DEFAULT 0 NOT NULL, 
  Date_Created   datetime NOT NULL, 
  PRIMARY KEY (PId), 
  UNIQUE INDEX (PId));
CREATE TABLE SubRedditMember (
  UserUId int(10) NOT NULL, 
  TopicId int(10) NOT NULL, 
  PRIMARY KEY (UserUId, 
  TopicId));
CREATE TABLE SubRedditMonitor (
  UserUId int(10) NOT NULL, 
  TopicId int(10) NOT NULL, 
  PRIMARY KEY (UserUId, 
  TopicId));
CREATE TABLE Topic (
  TId          int(10) NOT NULL AUTO_INCREMENT, 
  Name         varchar(50) NOT NULL UNIQUE, 
  Rules        varchar(255), 
  Description  text, 
  Date_Created datetime NOT NULL, 
  PRIMARY KEY (TId), 
  UNIQUE INDEX (TId));
CREATE TABLE `User` (
  UId           int(10) NOT NULL AUTO_INCREMENT, 
  Email         varchar(40) NOT NULL UNIQUE, 
  Password_Hash varchar(100) NOT NULL, 
  Username      varchar(50) NOT NULL UNIQUE, 
  Avatar        varchar(255), 
  Date_Joined   datetime NOT NULL, 
  PRIMARY KEY (UId), 
  UNIQUE INDEX (UId));
CREATE TABLE User_Downvoted (
  PostPId int(10) NOT NULL, 
  UserUId int(10) NOT NULL, 
  PRIMARY KEY (PostPId, 
  UserUId));
CREATE TABLE User_Save (
  PostPId int(10) NOT NULL, 
  UserUId int(10) NOT NULL, 
  PRIMARY KEY (PostPId, 
  UserUId));
CREATE TABLE User_Upvoted (
  PostPId int(10) NOT NULL, 
  UserUId int(10) NOT NULL, 
  PRIMARY KEY (PostPId, 
  UserUId));
ALTER TABLE SubRedditMonitor ADD CONSTRAINT FKSubRedditM670013 FOREIGN KEY (UserUId) REFERENCES `User` (UId);
ALTER TABLE SubRedditMonitor ADD CONSTRAINT FKSubRedditM440551 FOREIGN KEY (TopicId) REFERENCES Topic (TId);
ALTER TABLE SubRedditMember ADD CONSTRAINT FKSubRedditM666300 FOREIGN KEY (UserUId) REFERENCES `User` (UId);
ALTER TABLE SubRedditMember ADD CONSTRAINT FKSubRedditM534752 FOREIGN KEY (TopicId) REFERENCES Topic (TId);
ALTER TABLE Post ADD CONSTRAINT FKPost964424 FOREIGN KEY (TopicId) REFERENCES Topic (TId);
ALTER TABLE Post ADD CONSTRAINT FKPost734962 FOREIGN KEY (UserUId) REFERENCES `User` (UId);
ALTER TABLE User_Upvoted ADD CONSTRAINT FKUser_Upvot266903 FOREIGN KEY (PostPId) REFERENCES Post (PId);
ALTER TABLE User_Upvoted ADD CONSTRAINT FKUser_Upvot507957 FOREIGN KEY (UserUId) REFERENCES `User` (UId);
ALTER TABLE User_Downvoted ADD CONSTRAINT FKUser_Downv55394 FOREIGN KEY (PostPId) REFERENCES Post (PId);
ALTER TABLE User_Downvoted ADD CONSTRAINT FKUser_Downv296448 FOREIGN KEY (UserUId) REFERENCES `User` (UId);
ALTER TABLE Comment ADD CONSTRAINT FKComment916862 FOREIGN KEY (PostPId) REFERENCES Post (PId);
ALTER TABLE Comment ADD CONSTRAINT FKComment675808 FOREIGN KEY (UserUId) REFERENCES `User` (UId);
ALTER TABLE Comment ADD CONSTRAINT FKComment504122 FOREIGN KEY (ParentCId) REFERENCES Comment (CId);
ALTER TABLE User_Save ADD CONSTRAINT FKUser_Save464157 FOREIGN KEY (PostPId) REFERENCES Post (PId);
ALTER TABLE User_Save ADD CONSTRAINT FKUser_Save223103 FOREIGN KEY (UserUId) REFERENCES `User` (UId);
ALTER TABLE Blacklist ADD CONSTRAINT FKBlacklist253807 FOREIGN KEY (UserUId) REFERENCES `User` (UId);
ALTER TABLE Blacklist ADD CONSTRAINT FKBlacklist516730 FOREIGN KEY (TopicId) REFERENCES Topic (TId);


INSERT INTO Blacklist(UserUId, TopicId) VALUES (?, ?);
INSERT INTO Comment(CId, Content, Upvote_Count, Downvote_Count, PostPId, UserUId, ParentCId, Date_Created) VALUES (?, ?, ?, ?, ?, ?, ?, ?);
INSERT INTO Post(PId, Content, TopicId, UserUId, picture_url, Upvote_Count, Downvote_Count, Date_Created) VALUES (?, ?, ?, ?, ?, ?, ?, ?);
INSERT INTO SubRedditMember(UserUId, TopicId) VALUES (?, ?);
INSERT INTO SubRedditMonitor(UserUId, TopicId) VALUES (?, ?);
INSERT INTO Topic(TId, Name, Rules, Description, Date_Created) VALUES (?, ?, ?, ?, ?);
INSERT INTO  User (UId, Email, Password_Hash, Username, Avatar, Date_Joined) VALUES (?, ?, ?, ?, ?, ?);
INSERT INTO User_Downvoted(PostPId, UserUId) VALUES (?, ?);
INSERT INTO User_Save(PostPId, UserUId) VALUES (?, ?);
INSERT INTO User_Upvoted(PostPId, UserUId) VALUES (?, ?);

  
INSERT INTO USER(email,password_hash,username, Date_Joined) values("vichet@infosys.com", "vichet123", "vichet", CURDATE());
INSERT INTO USER(email,password_hash,username, Date_Joined) values("john@infosys.com", "john123", "john", CURDATE());
INSERT INTO USER(email,password_hash,username, Date_Joined) values("tom@infosys.com", "tom123", "tom", CURDATE());
INSERT INTO USER(email,password_hash,username, Date_Joined) values("khang@infosys.com", "khang123", "khang", CURDATE());
INSERT INTO USER(email,password_hash,username, Date_Joined) values("roden@infosys.com", "roden123", "roden", CURDATE());

  
INSERT INTO topic(name,description, date_created) values("cars", "This topic is about cars", CURDATE());
INSERT INTO topic(name,description, date_created) values("uci", "This topic is about anything related to University of Cal, Irvine", CURDATE());
INSERT INTO topic(name,description, date_created) values("nature", "This topic is about natures", CURDATE());
INSERT INTO topic(name,description, date_created) values("programming", "This topic is for anything related to programming", CURDATE());


INSERT INTO post(title,content,topicid, useruid, date_created) values("Car post title 1", "Car post content 1 posted by vichet", 1, 1, CURDATE());
INSERT INTO post(title,content,topicid, useruid, date_created) values("Car post title 2", "Car post content 1 posted by khang", 1, 4, CURDATE());
INSERT INTO post(title,content,topicid, useruid, date_created) values("Car post title 3", "Car post content 1 posted by john", 1, 2, CURDATE());
INSERT INTO post(title,content,topicid, useruid, date_created) values("Car post title 4", "Car post content 2 posted by vichet", 1, 1, CURDATE());
INSERT INTO post(title,content,topicid, useruid, date_created) values("UCI post title 1", "UCI post content 1 posted by vichet", 2, 1, CURDATE());
INSERT INTO post(title,content,topicid, useruid, date_created) values("UCI post title 2", "UCI post content 1 posted by khang", 2, 4, CURDATE());
INSERT INTO post(title,content,topicid, useruid, date_created) values("Nature post title 3", "Nature post content 1 posted by john", 3, 2, CURDATE());
INSERT INTO post(title,content,topicid, useruid, date_created) values("Programming post title 4", "Programming post content 1 posted by vichet", 3, 1, CURDATE());


select * from user;
select * from post;
select * from topic;

