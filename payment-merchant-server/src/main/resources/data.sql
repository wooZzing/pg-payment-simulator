-- 사용자 데이터
INSERT INTO users (name, email, phone) VALUES ('홍길동', 'hong@test.com', '010-1111-2222');
INSERT INTO users (name, email, phone) VALUES ('김영희', 'kim@test.com', '010-2222-3333');

-- 상품 데이터
INSERT INTO products (name, price, stock) VALUES ('무선 이어폰', 99000, 50);
INSERT INTO products (name, price, stock) VALUES ('스마트 워치', 149000, 30);
INSERT INTO products (name, price, stock) VALUES ('휴대용 충전기', 39000, 100);

-- (초기 주문 데이터는 없어도 됨. 이후 API로 생성)