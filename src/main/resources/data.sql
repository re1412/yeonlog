INSERT INTO customer(customer_id, mobile, name, email, active, profile_url) VALUES ('yeonKim', '010-5858-3030', '김형연', 'yeonKim@yeon.co.kr', true, 'http://localhost:8080/resources/profile_sample.png');
INSERT INTO address(address, zip_code, customer_id) VALUES ('경기도 용인시 수지구 디지털밸리로 81', '16878', 1);

INSERT INTO product(code, brand, name, summary, inventory, content, price, img_url) VALUES ('PRODUCT-TEST-01', 'Californialife', '스포츠 리서치 오메가3 1250mg 180캡슐 rTG EPA DHA', 'summary', 10, 'content', 48000, 'http://localhost:8080/resources/img_item_02.png');
INSERT INTO product(code, brand, name, summary, inventory, content, price, img_url) VALUES ('PRODUCT-TEST-02', 'LA Mall', '얼티메이트 오메가3 피쉬 젤라틴 1280 mg EPA 650 / DHA 450 레몬 180 소프트젤 Nordic', 'summary2', 100, 'content', 51950, 'http://localhost:8080/resources/img_item_03.png');
INSERT INTO product(code, brand, name, summary, inventory, content, price, img_url) VALUES ('PRODUCT-TEST-03', 'E-Mart Mall', '스포츠리서치(해외직구) Sports Research 스포츠리서치 마린 하이드롤라이즈드 콜라겐 펩타', 'summary2', 100, 'content', 101800, 'http://localhost:8080/resources/img_item_04.png');
INSERT INTO product(code, brand, name, summary, inventory, content, price, img_url) VALUES ('PRODUCT-TEST-04', '지스프레드(GSPREAD)', 'Mason Natural 메이슨 내추럴 콜라겐 구미 60개 3병 아스코르브산 나트륨 사탕수수 베타카', 'summary2', 100, 'content', 24070, 'http://localhost:8080/resources/img_item_01.png');
INSERT INTO product(code, brand, name, summary, inventory, content, price, img_url) VALUES ('PRODUCT-TEST-05', 'Californialife', '스포츠 리서치 오메가3 1250mg 180캡슐 rTG EPA DHA', 'summary', 10, 'content', 48000, 'http://localhost:8080/resources/img_item_02.png');
INSERT INTO product(code, brand, name, summary, inventory, content, price, img_url) VALUES ('PRODUCT-TEST-06', 'LA Mall', '얼티메이트 오메가3 피쉬 젤라틴 1280 mg EPA 650 / DHA 450 레몬 180 소프트젤 Nordic', 'summary2', 100, 'content', 51950, 'http://localhost:8080/resources/img_item_03.png');
INSERT INTO product(code, brand, name, summary, inventory, content, price, img_url) VALUES ('PRODUCT-TEST-07', 'E-Mart Mall', '스포츠리서치(해외직구) Sports Research 스포츠리서치 마린 하이드롤라이즈드 콜라겐 펩타', 'summary2', 100, 'content', 101800, 'http://localhost:8080/resources/img_item_04.png');
INSERT INTO product(code, brand, name, summary, inventory, content, price, img_url) VALUES ('PRODUCT-TEST-08', '지스프레드(GSPREAD)', 'Mason Natural 메이슨 내추럴 콜라겐 구미 60개 3병 아스코르브산 나트륨 사탕수수 베타카', 'summary2', 100, 'content', 24070, 'http://localhost:8080/resources/img_item_01.png');

INSERT INTO product_option(product_id, name, price) VALUES (3, '1+1묶음상품', 2177);
INSERT INTO product_option(product_id, name, price) VALUES (4, '1+1묶음상품', 2177);

INSERT INTO product_extension(product_id, name, price) VALUES (2, '멀티비타민 체험팩', 10183);
INSERT INTO product_extension(product_id, name, price) VALUES (4, '멀티비타민 체험팩', 10183);