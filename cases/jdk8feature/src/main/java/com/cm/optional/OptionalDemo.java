package com.cm.optional;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author：CM
 * @Package：com.cm.optional
 * @Project：JavaReview
 * @name：OptionDemo
 * @Date：2023/6/21 13:52
 * @Filename：OptionDemo
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Member> optional = getMemberByIdFromDB();
        optional.ifPresent(mem -> {
            System.out.println("会员姓名是：" + mem.getName());
        });

//        ofNullable();

//        ifPresent();

//        orElseGet();

//        filter();

        chanFilter();
    }

    public static Optional<Member> getMemberByIdFromDB() {
        boolean hasName = true;
        if (hasName) {
            return Optional.of(new Member("沉默王二"));
        }
        return Optional.empty();
    }

    public static void ofNullable() {
        Optional<Member> optional = Optional.ofNullable(new Member("zzz"));
        System.out.println(optional);
//        获得Optional中的对象
        Member member = optional.get();
        System.out.println(member);
    }


    public static void ifPresent() {
        Optional<Member> optional = Optional.ofNullable(new Member("zzz"));
        optional.ifPresent(member -> System.out.println(member.getName()));
    }

    public static void orElseGet(){
        String name = null;
        String aaa = Optional.ofNullable(name).orElse("aaa");
        System.out.println(aaa);
        String s = Optional.ofNullable(name).orElseGet(new Supplier<String>() {
            @Override
            public String get() {
                return "abab";
            }
        });
        System.out.println(s);
    }

    public static void filter(){
        String password = "12345";
        Optional<String> optional = Optional.ofNullable(password); //如果不为空就返回Optional<String>对象，反之返回Optional<Empty>对象
        boolean present = optional.filter(pwd -> pwd.length() > 6).isPresent();
        System.out.println(present);
    }

    public static void chanFilter(){
        String password = "1234567";
        Predicate<String> p1 = pwd-> pwd.length() > 6;
        Predicate<String> p2 = pwd-> pwd.length() < 20;
        Optional<String> optional = Optional.ofNullable(password);
//        boolean present = optional.filter(p1.and(p2)).isPresent();//判断密码是否既大于6位又小于20位
        Optional<String> present = optional.filter(((Predicate<String>) s -> s.length() > 6).and(s -> s.length() < 20));
        System.out.println(present.get());

//        传统写法
        if(password.length() < 20 && password.length() > 6){

        }
    }
}

@Data
@AllArgsConstructor
class Member {
    private String name;

    public String getName() {
        return name;
    }

    // getter / setter
}

