--비밀번호demo
INSERT INTO user (userName, password, roleName) VALUES ('dkdm', '$2a$08$bFa01KtL9g52kwfFG2jUhekHP5NVTKtWpUv82qd8jKVpVMCU24E8W', 'USER');
INSERT INTO user (userName, password, roleName) VALUES ('아으', '$2a$08$RM9N/ky8rcR.xJ9qboGWCO3E9jSq.muJerlp/LVy2RoeeSTtBSWtK', 'USER');

--레시피
INSERT INTO recipe (recipeId, recipeName, neededFood) VALUES(1, '김치찌게','김치 고춧가루 돼지고기 양파');
INSERT INTO recipe (recipeId, recipeName, neededFood) VALUES(2,'등갈비찜','등갈비 김치 마늘 된장 멸치 간장 고춧가루 참기름');
INSERT INTO recipe (recipeId, recipeName, neededFood) VALUES(3,'생크림케이크','생크림 빵');
INSERT INTO recipe (recipeId, recipeName, neededFood) VALUES(4,'떡볶이','떡 고추장 된장 어묵');
