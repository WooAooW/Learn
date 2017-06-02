import kotlin.properties.Delegates

/**
 * 类说明:
 * 1. Class的声明
 * 2. Delegates的使用
 * 3. lazy的使用
 *
 * Created by liyu on 2017/6/2.
 */
fun main(args: Array<String>) {
    val conf = Config()
    conf.name = "liyu"
    conf.name = "handsome"

    //println(conf.age) //java.lang.IllegalStateException: Property age should be initialized before get.
    conf.age = 20
    println(conf.age)
    println(conf.age2)

    println(conf.appName)
    println(conf.appName)
}

class Config {
    var name :String by Delegates.observable("kiss") {
        d, old, new ->
        println("name change, $old -> $new")
    }

    var age :Int by Delegates.notNull()

    var age2 = null

    val appName :String by lazy {
        println("exec appName by lazy") //只会执行一次
        "Kiss Learn Kotlin"
    }
}