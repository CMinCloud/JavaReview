package com.cm.duplicateAnnotation;

import java.lang.annotation.Repeatable;

/**
 * @Author：CM
 * @Package：com.cm.duplicateAnnotation
 * @Project：JavaReview
 * @name：RepeatAnnotationUseNewVersion
 * @Date：2023/6/21 10:36
 * @Filename：RepeatAnnotationUseNewVersion
 */

@Repeatable(Authorities.class)
@interface Authority{

    String role();
}

@interface Authorities{

    Authority[] value();
}






public class RepeatAnnotationUseNewVersion {

    @Authority(role = "admin")
    @Authority(role = "Manager")
    public void doSomething(){}

}
