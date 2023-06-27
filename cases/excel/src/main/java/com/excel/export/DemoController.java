package com.excel.export;

import com.excel.util.ExcelUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName DemoController
 * @Description TODO
 * @date 2023/6/27 23:04
 * @Version 1.0
 */


@RestController
@RequestMapping("/demo")
public class DemoController {


    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws MalformedURLException {
//        展示列标题要一致
        List<Object> l = Arrays.asList("姓名", "年龄", "性别", "电话","头像");
        ArrayList<Object> list = new ArrayList<>();
        list.add("张三");
        list.add(20);
        list.add("男");
        list.add("18273470279");
        list.add(new URL("https://img2.baidu.com/it/u=879699163,2812801552&fm=253&fmt=auto&app=120&f=JPEG?w=800&h=500"));
        ArrayList<Object> list1 = new ArrayList<>();
        list1.add("李四");
        list1.add(48);
        list1.add("女");
        list1.add("18273411111");
        list1.add(new URL("https://i0.hdslb.com/bfs/archive/c917f38c6269ed940f2b2d44a6d0032f5e06c27d.jpg"));

//        第一个list对应行，第二个list对应行的列
        List<List<Object>> data = new ArrayList<>();
        data.add(l);
        data.add(list);
        data.add(list1);
        ExcelUtils.export(response,"学生信息",data);

    }
}
