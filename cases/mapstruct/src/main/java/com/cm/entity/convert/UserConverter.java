package com.cm.entity.convert;

import com.alibaba.fastjson.JSON;
import com.cm.entity.Address;
import com.cm.entity.User;
import com.cm.entity.vo.UserQuryParam;
import com.cm.entity.vo.UserVo;
import com.cm.entity.vo.UserWithAddressVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @ClassName UserConverter
 * @Description TODO
 * @date 2023/7/6 11:16
 * @Version 1.0
 */
@Mapper   //注意这个加mapStruct的jar包
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    /**
     * 将实体类转为UserVo
     *
     * @param var1
     * @return
     */
    @Mapping(target = "gender", source = "sex")
    @Mapping(target = "password", ignore = true)
    //这里名称一样，就不用加source了
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserVo do2Vo(User var1);   //转化为User实体类对象

    /**
     * 将实体类转为为
     *
     * @param var2
     * @return
     */
    @Mapping(target = "sex", source = "gender")
    //密码不进行转化
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    User vo2Do(UserVo var2);      // 将vo对象转化为User实体类对象


    /**
     * 将user对象转化为UserQueryParam类型
     * @param var3
     * @return
     */
    UserQuryParam User2Param(User var3);


    /**
     * 将User对象和Address对象 封装为UserWithAddressVo
     * @param user
     * @param address
     * @return
     */
    @Mappings({
            @Mapping(target = "zipCode",source = "address.code"),
            @Mapping(target = "houseNumber",source = "address.houseNo")
    })
    UserWithAddressVo UserAddressVo(User user, Address address);

    List<UserVo> do2VoList(List<User> userlist);

    default List<UserVo.UserConfig> strConfigToListUserConfig(String config) {
        return JSON.parseArray(config, UserVo.UserConfig.class);
    }

    default String listUserConfigToStrConfig(List<UserVo.UserConfig> list) {
        return JSON.toJSONString(list);
    }

}
