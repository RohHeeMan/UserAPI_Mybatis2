package com.users.users.controller;

import com.users.users.dto.UserDTO;
import com.users.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    // 생성자 주입방식
    private final UserService userService;

    // 조회 메서드 작성
    @GetMapping
    private List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    // 개별조회
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") int id){
        return userService.getUserById(id);
    }

    // 입력
    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO user){
        return userService.addUser(user);
    }

    // 수정
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable("id") int id, @RequestBody UserDTO user){
        return userService.updateUser(id, user);
    }

//    // 기본 삭제처리 / Delete는 UserDTO를 넘길 필요가 없다.
//    @DeleteMapping("/{id}")
//    public void deleteUser(@PathVariable("id") int id) {
//        userService.deleteUser(id);
//    }

    // UserService에서 존재하지 않는 아이디를 삭제할 경우에 대한 메시지 처리
    @DeleteMapping("/{id}")
    // ResponseEntity는 Http응답처리
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.ok("삭제가 완료되었습니다.");
        } else {
            // ID가 존재하지 않을 경우 404 반환
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("삭제하려는 ID가 존재하지 않습니다: " + id);
        }
    }

}
