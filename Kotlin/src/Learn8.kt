/**
 * 类说明:
 * 1. 函数指针的使用
 *
 * Created by liyu on 2017/6/2.
 */
fun main(args: Array<String>) {
    var numbers = listOf(1 , 2, 3, 4)
    println(numbers.filter(::isOdd))
}

fun isOdd(x :Int) = x % 2 == 0