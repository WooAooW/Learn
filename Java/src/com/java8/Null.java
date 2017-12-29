package com.java8;

import java.util.Optional;

/**
 *
 * Created by liyu on 28/12/2017.
 */
public class Null {

    class Friend {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class Teacher {
        Optional<Friend> girlFriend;

        public Optional<Friend> getGirlFriend() {
            return girlFriend;
        }

        public void setGirlFriend(Optional<Friend> girlFriend) {
            this.girlFriend = girlFriend;
        }
    }

    class Student {
        Optional<Teacher> teacher;

        public Optional<Teacher> getTeacher() {
            return teacher;
        }

        public void setTeacher(Optional<Teacher> teacher) {
            this.teacher = teacher;
        }
    }

    public void doSomething(Student student) {
        String name = student.getTeacher()
                .orElseGet(Teacher::new)   /** 当对象为空的时候触发 */
                .getGirlFriend()
                .orElseGet(Friend::new)    /** 可以是读数据等等 */
                .getName();
        System.out.println(name);
    }


    public static void main(String[] args) {
        //new Null().doSomething();
    }
}
