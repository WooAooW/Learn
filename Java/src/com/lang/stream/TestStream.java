package com.lang.stream;

import com.common.bean.User;
import com.common.util.UserUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Created by liyu on 01/11/2017.
 */
public class TestStream {

    public static void main(String[] args) {
        List<User> userList = UserUtils.getUserList();

        List<String> result = userList.stream()
                .filter(user -> user.getAge() > 18)
                .map(User::getName)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
