
-- Apartment 테이블 더미데이터
INSERT INTO Apartment (apartment_name, apartment_address, apartment_total_household) VALUES
    ('강남아파트', '서울특별시 강남구 강남대로 1234', 100),
    ('종로아파트', '서울특별시 종로구 종로 567', 80),
    ('마포아파트', '서울특별시 마포구 마포대로 890', 120),
    ('송파아파트', '서울특별시 송파구 올림픽로 123', 150),
    ('영등포아파트', '서울특별시 영등포구 영등포로 456', 90),
    ('광진아파트', '서울특별시 광진구 뚝섬로 789', 110),
    ('서초아파트', '서울특별시 서초구 서초대로 101', 70),
    ('강북아파트', '서울특별시 강북구 삼양로 222', 60),
    ('동작아파트', '서울특별시 동작구 상도로 333', 80),
    ('강서아파트', '서울특별시 강서구 화곡로 444', 100),
    ('은평아파트', '서울특별시 은평구 통일로 555', 110),
    ('양천아파트', '서울특별시 양천구 신월로 666', 70),
    ('노원아파트', '서울특별시 노원구 동일로 777', 130),
    ('구로아파트', '서울특별시 구로구 구일로 888', 120),
    ('성북아파트', '서울특별시 성북구 동소문로 999', 90),
    ('금천아파트', '서울특별시 금천구 시흥대로 1010', 80),
    ('동대문아파트', '서울특별시 동대문구 회기로 1111', 110),
    ('서대문아파트', '서울특별시 서대문구 신촌로 1212', 100),
    ('강동아파트', '서울특별시 강동구 천호대로 1313', 140);



--     reservation_facility_id int          not null,
--     reservation_id          int auto_increment
--         primary key,
--     reservation_end_time    datetime(6)  not null,
--     reservation_start_time  datetime(6)  not null,
--     reservation_user_id     varchar(255) not null
INSERT INTO reservation (reservation_facility_id, reservation_start_time, reservation_end_time,
                         reservation_user_id, reservation_headcount)
VALUES
    (4, '2024-03-22 02:25:49', '2024-03-24 02:25:49', 'string', 2),
    (4, '2024-03-23 02:25:49', '2024-03-24 02:25:49', 'example', 3),
    (5, '2024-03-24 02:25:49', '2024-03-24 02:25:49', 'string', 3),
    (5, '2024-03-24 02:25:49', '2024-03-24 02:25:49', 'example', 4),
    (6, '2024-03-26 02:25:49', '2024-03-26 03:25:49', 'string', 3);


-- facility 기본 값
--     facility_fee                       int          not null,
--     facility_id                        int          not null
--     facility_operating_time            int          not null,
--     facility_reservation_availble_time int          null,
--     facility_membership_yn             varchar(255) not null,
--     facility_name                      varchar(255) not null
--      수영장0, 헬스장0, 스크린골프장, 테니스장, 바베큐장, 영화관, 독서실0, 회의실
INSERT INTO facility (facility_id, facility_name,
                             facility_reservation_availble_time, facility_operating_time,
                             facility_membership_yn, facility_fee)
VALUES
    (1, '수영장', 24, 522, true, 100000),
    (2, '헬스장', 24, 522, true, 100000),
    (3, '독서실', 24, 724, true, 100000),
    (4, '스크린골프장', 2, 522, false, 30000),
    (5, '테니스장', 2, 522, false, 30000),
    (6, '바베큐장', 3, 1622, false, 30000),
    (7, '영화관', 3, 724, false, 30000),
    (8, '회의실', 2, 724, false, 30000);

-- realtimefacility 기본 값
--     realtime_facility_current_users int not null,
--     realtime_facility_id            int not null

INSERT INTO realtime_facility (realtime_facility_id, realtime_facility_current_users)
VALUES
    (1, 0),
    (2, 0),
    (3, 0);

=======
-- User 테이블 더미데이터
INSERT INTO User (user_id, user_password, user_nickname, user_email, user_mobile, user_building_number, user_house_number, user_head_household_yn, created_at, updated_at, delete_yn, apartment_id)
VALUES
    ('john_doe', 'password123', 'JohnDoe', 'john@example.com', '010-1234-5678', 3, 201, true, CURRENT_TIMESTAMP, NULL, false, 1),
    ('jane_smith', 'password456', 'JaneSmith', 'jane@example.com', '010-2345-6789', 5, 202, true, CURRENT_TIMESTAMP, NULL, false, 2),
    ('mike_jones', 'password789', 'MikeJones', 'mike@example.com', '010-3456-7890', 7, 203, true, CURRENT_TIMESTAMP, NULL, false, 3),
    ('sara_brown', 'passwordabc', 'SaraBrown', 'sara@example.com', '010-7503-8901', 9, 204, true, CURRENT_TIMESTAMP, NULL, false, 4),
    ('alex_clark', 'passworddef', 'AlexClark', 'alex@example.com', '010-5678-9012', 11, 205, true, CURRENT_TIMESTAMP, NULL, false, 5),
    ('emily_white', 'passwordghi', 'EmilyWhite', 'emily@example.com', '010-6789-0123', 13, 206, true, CURRENT_TIMESTAMP, NULL, false, 6),
    ('matt_taylor', 'passwordjkl', 'MattTaylor', 'matt@example.com', '010-7890-1234', 15, 207, true, CURRENT_TIMESTAMP, NULL, false, 7),
    ('olivia_thomas', 'passwordmno', 'OliviaThomas', 'olivia@example.com', '010-8901-2345', 17, 208, true, CURRENT_TIMESTAMP, NULL, false, 8),
    ('william_lee', 'passwordpqr', 'WilliamLee', 'william@example.com', '010-9012-3456', 19, 209, true, CURRENT_TIMESTAMP, NULL, false, 9),
    ('sophia_kim', 'passwordstu', 'SophiaKim', 'sophia@example.com', '010-2073-4567', 21, 210, true, CURRENT_TIMESTAMP, NULL, false, 10),
    ('ethan_hall', 'passwordvwx', 'EthanHall', 'ethan@example.com', '010-5201-5678', 23, 211, true, CURRENT_TIMESTAMP, NULL, false, 11),
    ('emma_choi', 'passwordyz', 'EmmaChoi', 'emma@example.com', '010-5629-6789', 25, 212, true, CURRENT_TIMESTAMP, NULL, false, 12),
    ('liam_yang', 'password123', 'LiamYang', 'liam@example.com', '010-9565-7890', 27, 213, true, CURRENT_TIMESTAMP, NULL, false, 13),
    ('ava_huang', 'password456', 'AvaHuang', 'ava@example.com', '010-4567-8901', 29, 214, true, CURRENT_TIMESTAMP, NULL, false, 14),
    ('noah_wang', 'password789', 'NoahWang', 'noah@example.com', '010-7624-9012', 31, 215, true, CURRENT_TIMESTAMP, NULL, false, 15),
    ('mia_wong', 'passwordabc', 'MiaWong', 'mia@example.com', '010-7913-0123', 33, 216, true, CURRENT_TIMESTAMP, NULL, false, 19),
    ('james_liu', 'passworddef', 'JamesLiu', 'james@example.com', '010-0918-1234', 35, 217, true, CURRENT_TIMESTAMP, NULL, false, 3),
    ('emma_zhang', 'passwordghi', 'EmmaZhang', 'emma@example.com', '010-8564-2345', 37, 218, true, CURRENT_TIMESTAMP, NULL, false, 4),
    ('logan_chen', 'passwordjkl', 'LoganChen', 'logan@example.com', '010-5689-3456', 39, 219, true, CURRENT_TIMESTAMP, NULL, false, 5),
    ('charlotte_li', 'passwordmno', 'CharlotteLi', 'charlotte@example.com', '010-2645-4567', 41, 220, true, CURRENT_TIMESTAMP, NULL, false, 1),
    ('john_doe_2', 'password123', 'JohnDoe', 'john2@example.com', '010-3301-5678', 3, 221, true, CURRENT_TIMESTAMP, NULL, false, 1),
    ('jane_smith_2', 'password456', 'JaneSmith', 'jane2@example.com', '010-1123-6789', 5, 222, true, CURRENT_TIMESTAMP, NULL, false, 2),
    ('mike_jones_2', 'password789', 'MikeJones', 'mike2@example.com', '010-2234-7890', 7, 223, true, CURRENT_TIMESTAMP, NULL, false,3),
    ('sara_brown_2', 'passwordabc', 'SaraBrown', 'sara2@example.com', '010-3345-8901', 9, 224, true, CURRENT_TIMESTAMP, NULL, false,4),
    ('alex_clark_2', 'passworddef', 'AlexClark', 'alex2@example.com', '010-4456-9012', 11, 225, true, CURRENT_TIMESTAMP, NULL, false,5),
    ('emily_white_2', 'passwordghi', 'EmilyWhite', 'emily2@example.com', '010-0098-0123', 13, 226, true, CURRENT_TIMESTAMP,NULL, false, 6),
    ('matt_taylor_2', 'passwordjkl', 'MattTaylor', 'matt2@example.com', '010-9987-1234', 15, 227, true, CURRENT_TIMESTAMP, NULL, false,7),
    ('olivia_thomas_2', 'passwordmno', 'OliviaThomas', 'olivia2@example.com', '010-7655-2345', 17, 228, true, CURRENT_TIMESTAMP,NULL, false, 8),
    ('william_lee_2', 'passwordpqr', 'WilliamLee', 'william2@example.com', '010-1535-3456', 19, 229, true, CURRENT_TIMESTAMP, NULL, false,9),
    ('sophia_kim_2', 'passwordstu', 'SophiaKim', 'sophia2@example.com', '010-3698-4567', 21, 230, true, CURRENT_TIMESTAMP, NULL, false,10),
    ('ethan_hall_2', 'passwordvwx', 'EthanHall', 'ethan2@example.com', '010-0826-5678', 23, 231, true, CURRENT_TIMESTAMP, NULL, false,11),
    ('emma_choi_2', 'passwordyz', 'EmmaChoi', 'emma2@example.com', '010-6657-6789', 25, 232, true, CURRENT_TIMESTAMP, NULL, false,12),
    ('liam_yang_2', 'password123', 'LiamYang', 'liam2@example.com', '010-8623-7890', 27, 233, true, CURRENT_TIMESTAMP, NULL, false,13),
    ('ava_huang_2', 'password456', 'AvaHuang', 'ava2@example.com', '010-4483-8901', 29, 234, true, CURRENT_TIMESTAMP, NULL, false,14),
    ('noah_wang_2', 'password789', 'NoahWang', 'noah2@example.com', '010-5887-9012', 31, 235, true, CURRENT_TIMESTAMP, NULL, false,15),
    ('mia_wong_2', 'passwordabc', 'MiaWong', 'mia2@example.com', '010-3627-0123', 33, 236, true, CURRENT_TIMESTAMP, NULL, false,19),
    ('james_liu_2', 'passworddef', 'JamesLiu', 'james2@example.com', '010-3169-1234', 35, 237, true, CURRENT_TIMESTAMP,NULL, false, 3),
    ('emma_zhang_2', 'passwordghi', 'EmmaZhang', 'emma2@example.com', '010-2267-2345', 37, 238, true, CURRENT_TIMESTAMP, NULL, false,4),
    ('logan_chen_2', 'passwordjkl', 'LoganChen', 'logan2@example.com', '010-4775-3456', 39, 239, true, CURRENT_TIMESTAMP, NULL, false,5),
    ('charlotte_li_2', 'passwordmno', 'CharlotteLi', 'charlotte2@example.com', '010-3063-4567', 41, 240, true, CURRENT_TIMESTAMP,NULL, false, 1);

