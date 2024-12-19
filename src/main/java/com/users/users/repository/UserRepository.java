package com.users.users.repository;

import com.users.users.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// Dependencies에 설정
// implementation 'org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3'

// xml기반 mapper을 사용했으므로 @Mapper 어노테이션은 필요 없음.
public interface UserRepository {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(int id);
    void addUser(@Param("user") UserDTO user);
    void updateUser(int id, @Param("user") UserDTO user);
    void deleteUser(int id);
}
