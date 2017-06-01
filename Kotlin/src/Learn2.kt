/**
 * 类说明:
 * 1.方法的调用
 * 2.方法的声明
 *
 * Created by liyu on 2017/6/1.
 */
fun main(args: Array<String>) {
    println(max(2, 5))
    println(min(-2, 0))
}

//方法的声明
//fun name([argName : argType]) :returnType {}
//fun name([argName : argType]) = returnValue

fun max(a: Int, b: Int) = if (a > b) a else b

fun min(a: Int, b: Int) : Int {
    if(a < b)
        return a
    else
        return b
}