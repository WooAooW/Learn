/**
 * Created by liyu on 2017/6/1.
 */
fun main(args: Array<String>) {
    println(max(2, 5))
    println(min(-2, 0))
}

fun max(a: Int, b: Int) = if (a > b) a else b

fun min(a: Int, b: Int) : Int {
    if(a < b)
        return a
    else
        return b
}