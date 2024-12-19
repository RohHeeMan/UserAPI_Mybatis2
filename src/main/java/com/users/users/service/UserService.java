package com.users.users.service;

import com.users.users.dto.UserDTO;
import com.users.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    // 생성자 주입 방식
    private final UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserDTO getUserById(int id) {
        return userRepository.getUserById(id);
    }

    public UserDTO addUser(UserDTO user){
        // 저장할 경우는 user만 리턴한다.
        // userRepository에서 void로 넘긴다. void addUser(UserDTO user);
        userRepository.addUser(user);
        return user;
    }

    public UserDTO updateUser(@PathVariable("id") int id, @RequestBody UserDTO user) {
        userRepository.updateUser(id, user); // 업데이트 수행
        return user; // 업데이트된 user 반환
    }

//    public void deleteUser(@PathVariable("id") int id) {
//        // DB에서 id가 있는지 없는지 확인
//        UserDTO userById = userRepository.getUserById(id);
//        if (userById == null) {
//            // 이렇게하면 500 internal Error가 나는데 이걸
//             throw new IllegalArgumentException("삭제하려는 ID가 존재하지 않습니다: " + id);
//        }
//
//        // 존재한다면 삭제 실행
//        userRepository.deleteUser(id);
//    }

    // getUserById를 통해서 존재하는지 안하는지 확인하여 컨트롤러러 돌아가 메시지 발생시킴
    public boolean deleteUser(@PathVariable("id") int id) {
        // DB에서 id가 있는지 없는지 확인
        UserDTO userById = userRepository.getUserById(id);
        if (userById == null) {
            return false;
        }

        // 존재한다면 삭제 실행
        userRepository.deleteUser(id);
        return true;

        // 그 다음.
        // 컨트롤러에서 처리 결과를 기반으로 응답 반환
        // 서비스 계층의 반환값을 활용해 적절한 HTTP 상태 코드를 반환합니다.
    }

}
