/**
 * 类说明:
 * 1. when 关键词的使用
 * 2. is   关键词的使用
 * 3. else 关键词的使用
 *
 * Created by liyu on 2017/6/1.
 */
fun main(args: Array<String>) {
    test("Hello")
    test("hello")
    test(1)
    test(0L)
    test(TestClass())
}

fun test(arg: Any) {
    print("Arg is $arg,")
    when (arg) {
        1          -> println("Number 1")
        "Hello"    -> println("Hello")
        is Long    -> println("Long")
        !is String -> println("Not a string")
        else       -> println("Unknown")
    }
}

class TestClass() {}