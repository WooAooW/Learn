/**
 * 类说明:
 * 1. Map的声明
 * 2. Map的使用
 *
 * Created by liyu on 2017/6/1.
 */
fun main(args: Array<String>) {
    val map = HashMap<String, Any>()
    map.put("name", "Kiss")
    map.put("Age", 24)

    for((k, v) in map) {
        println("$k -> $v")
    }
}