/**
 * Created by liyu on 2017/6/1.
 */
fun main(args: Array<String>) {
    val x = 10

    //Range循环
    //for(arg in start..end) {}
    for(i in 1..x) {
        println("i:" + i)
    }

    //模版输出
    // "$arg ${arg}"
    for(i in 1..x) {
        println("i: $i")
    }
}
