### UserAPI_Mybatis2
XML매퍼 방식의 RestAPI CRUD처리

** getAllUsers() : 전체 사용자 조회
![image](https://github.com/user-attachments/assets/1ac4fa2d-1dc7-4d38-a653-8c9e508f9291)

** getUserById(int id) : 개별 조회
![image](https://github.com/user-attachments/assets/f96547a2-1676-4a51-a8c8-c8b66f028beb)

** public UserDTO addUser(UserDTO user) : 사용자 추가 / Json으로 데이터를 받아 UserDTO로 리턴 받음
![image](https://github.com/user-attachments/assets/a5645ec5-77bc-401c-b23d-fb160ab8c107)


** public UserDTO updateUser(@PathVariable("id") int id, @RequestBody UserDTO user)  / Json데이터로 수정 처리
* 원래 DB 화면
![image](https://github.com/user-attachments/assets/d2661927-d030-4970-9385-aa6af65acf21)

* 수정후 DB화면
![image](https://github.com/user-attachments/assets/c212b357-e3ac-4be7-8af6-a18df8eff60e)

* PostMan화면
![image](https://github.com/user-attachments/assets/f693c2f4-7185-40a5-bd8b-714867b9e78e)

** public ResponseEntity<String> deleteUser(@PathVariable("id") int id) : 삭제 처리
다만 삭제 처리시 없는 데이터를 삭제할 경우의 리턴값을 표기 하기 위한 코드 추가 ( ResponseEntity를 이용하여 Http응답을 받아 처리 )
![image](https://github.com/user-attachments/assets/aa0ffc9c-dc3e-49dd-8ed3-33d6acd86b81)

정상 삭제
![image](https://github.com/user-attachments/assets/ff71e616-a0c6-4564-8502-dc9d99961340)


*** 전체 구조
![image](https://github.com/user-attachments/assets/df31ed70-d621-46a9-953a-e766b03a0460)
