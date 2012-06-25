-- CREATE TABLE Script 
CREATE TABLE `tbl_user_profile` (
  `guid` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email_address` varchar(80) NOT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`guid`),
  UNIQUE KEY `guid_UNIQUE` (`guid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8$$

--INSERT Sample DATA
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('5d71a44b', 'pass', '5d71a44b@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('a3d02b18', 'pass', 'a3d02b18@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('462185e1', 'pass', '462185e1@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('6e398d0a', 'pass', '6e398d0a@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('b56cef25', 'pass', 'b56cef25@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('46401679', 'pass', '46401679@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('a82a704c', 'pass', 'a82a704c@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('a1eda416', 'pass', 'a1eda416@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('b392999d', 'pass', 'b392999d@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('0f60249d', 'pass', '0f60249d@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('b1f129e6', 'pass', 'b1f129e6@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('aa5180d1', 'pass', 'aa5180d1@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('b322f364', 'pass', 'b322f364@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('719f3d41', 'pass', '719f3d41@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('8a7c38a0', 'pass', '8a7c38a0@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('1c5f68e6', 'pass', '1c5f68e6@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('886a3d00', 'pass', '886a3d00@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('e4e01301', 'pass', 'e4e01301@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('ba108a78', 'pass', 'ba108a78@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('9a7b5213', 'pass', '9a7b5213@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('6e9801a1', 'pass', '6e9801a1@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('a0b05f9d', 'pass', 'a0b05f9d@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('8abf9eb5', 'pass', '8abf9eb5@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('b4ded42a', 'pass', 'b4ded42a@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('49d41951', 'pass', '49d41951@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('535491f7', 'pass', '535491f7@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('52e0eaf0', 'pass', '52e0eaf0@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('eb80552d', 'pass', 'eb80552d@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('e0d4d041', 'pass', 'e0d4d041@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('78d0e1cb', 'pass', '78d0e1cb@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('f228b13c', 'pass', 'f228b13c@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('e5222075', 'pass', 'e5222075@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('55b53838', 'pass', '55b53838@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('9866f35c', 'pass', '9866f35c@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('6179a578', 'pass', '6179a578@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('c409eaff', 'pass', 'c409eaff@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('f2fb2be9', 'pass', 'f2fb2be9@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('140f8d48', 'pass', '140f8d48@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('0e895e3d', 'pass', '0e895e3d@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('2d0e70e2', 'pass', '2d0e70e2@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('17c318cf', 'pass', '17c318cf@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('67329301', 'pass', '67329301@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('4314f131', 'pass', '4314f131@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('00e507bc', 'pass', '00e507bc@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('d69918fb', 'pass', 'd69918fb@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('09c8e98c', 'pass', '09c8e98c@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('bf452455', 'pass', 'bf452455@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('375df21a', 'pass', '375df21a@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('11d5268b', 'pass', '11d5268b@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('0d9c8638', 'pass', '0d9c8638@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('d6b3e2f6', 'pass', 'd6b3e2f6@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('2702b41c', 'pass', '2702b41c@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('4068e0cf', 'pass', '4068e0cf@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('52a0c35c', 'pass', '52a0c35c@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('0d6f5c4d', 'pass', '0d6f5c4d@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('14c90fc8', 'pass', '14c90fc8@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('ea637ab2', 'pass', 'ea637ab2@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('7a08e8fe', 'pass', '7a08e8fe@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('ed3eeee7', 'pass', 'ed3eeee7@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('4c1e5c31', 'pass', '4c1e5c31@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('f72ce396', 'pass', 'f72ce396@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('351f293b', 'pass', '351f293b@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('e9136019', 'pass', 'e9136019@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('1cfe8fd7', 'pass', '1cfe8fd7@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('fb4c5027', 'pass', 'fb4c5027@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('b423ca46', 'pass', 'b423ca46@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('265a42f2', 'pass', '265a42f2@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('a5c7a77a', 'pass', 'a5c7a77a@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('c80aee72', 'pass', 'c80aee72@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('fba03f50', 'pass', 'fba03f50@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('54331444', 'pass', '54331444@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('24815720', 'pass', '24815720@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('34201812', 'pass', '34201812@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('94ce4756', 'pass', '94ce4756@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('0027bc36', 'pass', '0027bc36@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('a4f93351', 'pass', 'a4f93351@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('025b92ca', 'pass', '025b92ca@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('35bcc755', 'pass', '35bcc755@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('fc6aecc4', 'pass', 'fc6aecc4@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('19b5c501', 'pass', '19b5c501@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('556444c2', 'pass', '556444c2@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('2be93656', 'pass', '2be93656@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('2cb47173', 'pass', '2cb47173@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('1f71e2cb', 'pass', '1f71e2cb@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('16dd93b4', 'pass', '16dd93b4@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('452d73e9', 'pass', '452d73e9@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('07efb275', 'pass', '07efb275@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('c49213ef', 'pass', 'c49213ef@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('fb7c29e5', 'pass', 'fb7c29e5@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('25456ef2', 'pass', '25456ef2@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('ed34ce6f', 'pass', 'ed34ce6f@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('b20e28e1', 'pass', 'b20e28e1@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('b043de17', 'pass', 'b043de17@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('26be4162', 'pass', '26be4162@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('b62e74e5', 'pass', 'b62e74e5@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('fecdb235', 'pass', 'fecdb235@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('3c19930b', 'pass', '3c19930b@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('79a158e0', 'pass', '79a158e0@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('ba67a0fc', 'pass', 'ba67a0fc@gmail.com');
INSERT INTO test.tbl_user_profile (user_name, password, email_address) VALUES ('b7adea71', 'pass', 'b7adea71@gmail.com');