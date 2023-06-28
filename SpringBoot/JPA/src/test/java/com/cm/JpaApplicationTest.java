package com.cm;

import com.cm.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;
import java.util.List;

/**
 * @Author：CM
 * @Package：com.cm
 * @Project：JavaReview
 * @name：JpaApplicationTest
 * @Date：2023/6/28 21:44
 * @Filename：JpaApplicationTest
 */
@SpringBootTest
public class JpaApplicationTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testQuery() {
        List<User> allById = userRepository.findAllById(Collections.singleton(1L));
        System.out.println(allById);
    }

    @Test
    public void testAdd() {

        User save = userRepository.save(User.builder().userName("aaa")
                .nickName("23e").password("sdadadasdada").userType("1").build());

//        获得返回的实体的id
        Long id = save.getId();
        System.out.println(id);
    }

    @Test
    public void testUpdate(){
        userRepository.findAll(PageRequest.of(0,2)).forEach(System.out::println);
    }

    @Test
    public void testQuerys(){
        List<User> allUser = userRepository.findAllUser();
        System.out.println(allUser);
    }


}
