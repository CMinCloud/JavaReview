package com.oop1.d4_genericity;


// 使用泛型接口：使用 声明的泛型类型来声明接口中方法的返回值和参数类型等
public interface genericInterface<T> {
    void add(T t);
    void delete(int id);
    void update(T t);
}
