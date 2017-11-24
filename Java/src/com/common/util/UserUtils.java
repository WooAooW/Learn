package com.common.util;

import com.common.bean.User;

import java.util.Arrays;
import java.util.List;

/**
 * 用户工具包
 * Created by liyu on 01/11/2017.
 */
public class UserUtils {

    /**
     * 获取用户列表
     */
    public static List<User> getUserList() {
        return Arrays.asList(
            new User(1, "小明", 10, "男"),
            new User(2, "小红", 20, "女")
        );
    }
}
