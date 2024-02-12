-- INSERT INTO account VALUES (default, 'admin', '1234');


INSERT INTO users (name, phone_number, email, address, password, grade)
VALUES
    ('김철수', '010-1234-5678', 'kim@example.com', '서울시 강남구', '123456', 1),
    ('박지영', '010-2345-6789', 'park@example.com', '서울시 마포구', '234567', 2),
    ('이지훈', '010-3456-7890', 'lee@example.com', '서울시 용산구', '345678', 3);

INSERT INTO stores (name, category, location, business_hours, day_off, delivery_fee, minimum_order_amount)
VALUES
    ('피자헛', '피자', '서울시 강남구', '10:00-22:00', '월요일', 2000, 15000),
    ('맥도날드', '햄버거', '서울시 마포구', '24시간 운영', '없음', 3000, 10000),
    ('스타벅스', '커피', '서울시 용산구', '07:00-23:00', '없음', 0, 5000);


INSERT INTO menus (store_id, name, price, description)
VALUES
    (1, '슈퍼슈프림 피자', 18000, '모짜렐라 치즈, 페퍼로니, 이탈리안 소시지, 양파, 피망, 버섯 토핑'),
    (1, '콰트로 치즈 피자', 19000, '모짜렐라 치즈, 체다 치즈, 파마산 치즈, 블루 치즈 토핑'),
    (2, '불고기 버거', 7000, '100% 소고기 패티, 불고기 소스, 양상추, 토마토, 피클'),
    (2, '새우 버거', 7500, '새우 패티, 타르타르 소스, 양상추, 토마토, 피클'),
    (3, '카페라떼', 4500, '에스프레소와 우유의 조화로운 맛'),
    (3, '아메리카노', 4000, '깊고 풍부한 커피의 맛');


INSERT INTO orders (user_id, store_id, ordered_menus, order_time, order_status, payment_method, payment_amount, delivery_address)
VALUES
    (1, 1, '슈퍼슈프림 피자', '2023-11-14 12:34:56', '배달 완료', '카드', 18000, '서울시 강남구'),
    (2, 2, '불고기 버거, 새우 버거', '2023-11-14 13:00:00', '배달 중', '현금', 14500, '서울시 마포구'),
    (3, 3, '카페라떼, 아메리카노', '2023-11-14 13:30:00', '주문 완료', '카드', 8500, '서울시 용산구');

INSERT INTO reviews (user_id, store_id, rating, content, created_at)
VALUES
    (1, 1, 5, '피자 맛있었어요!', '2023-11-14 13:00:00'),
    (2, 2, 4, '불고기 버거 맛있었지만, 새우 버거는 조금 아쉬웠어요.', '2023-11-14 13:30:00'),
    (3, 3, 5, '커피 맛있고 분위기도 좋았어요!', '2023-11-14 14:00:00');


INSERT INTO comments (review_id, user_id, content, created_at)
VALUES
    (1, 2, '피자 사진도 올려주세요!', '2023-11-14 13:10:00'),
    (2, 3, '저도 새우 버거는 조금 아쉬웠어요.', '2023-11-14 13:40:00'),
    (3, 1, '다음에 또 방문할게요!', '2023-11-14 14:10:00');


INSERT INTO likes (review_id, user_id)
VALUES
    (1, 3),
    (2, 1),
    (3, 2);
