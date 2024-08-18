package com.HotelRes.HotelRes.repository;

import com.HotelRes.HotelRes.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findUserEntityByEmail(String email);
}
