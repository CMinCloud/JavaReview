package com.cm.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName UserQuryParam
 * @Description TODO
 * @date 2023/7/6 14:03
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserQuryParam {

    private Long id;
    private String username;
}
