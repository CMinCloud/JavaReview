package com.controller;

import com.pojo.QueryParams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @Author：CM
 * @Package：dataTransfer.controller
 * @Project：JavaReview
 * @name：DemoController
 * @Date：2023/6/17 12:25
 * @Filename：DemoController
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/01")
    public QueryParams helloWorld(@RequestBody QueryParams queryParams){
        System.out.println(queryParams);
        return queryParams;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        list.size();
    }
}
