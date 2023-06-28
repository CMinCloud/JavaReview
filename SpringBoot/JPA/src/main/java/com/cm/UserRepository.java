package com.cm;

import com.cm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author：CM
 * @Package：com.cm
 * @Project：JavaReview
 * @name：UserRepository
 * @Date：2023/6/28 21:43
 * @Filename：UserRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {



    @Query("select u from User u")
    List<User> findAllUser();
}
