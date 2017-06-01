/**
 * 类说明:
 * 1. data class的使用
 * 2. copy()
 * 3. == 机制判断机制
 *
 * Created by liyu on 2017/6/1.
 */
fun main(args: Array<String>) {
    val user = User(1, "Kiss")
    println("ID: ${user.id},Name: ${user.name}")

    val (id, name) = user
    println("ID: $id,Name: $name")

    val user2 = User(1, "Kiss")
    var user3 = User(2, "Fei")
    var user4 = user

    println("toString()")
    println(user)
    println(user2)
    println(user3)
    println(user4)

    println("user == user2 ${user == user2}") //true
    println("user == user3 ${user == user3}") //false
    println("user == user4 ${user == user4}") //true

    println("change()")
    user2.id = 99
    println(user)  //1, Kiss
    println(user2) //99, Kiss
    println("user == user2 ${user == user2}") //false

    println("copy()")
    println(user.copy())
    println(user.copy(88))
    println(user.copy(name = "Yu"))
    println(user.copy(66, "Test"))

    println(user == user.copy())                //true
    println(user == user.copy(77))              //false
    println(user == user.copy(name = "Test==")) //false
    println(user == user.copy(55, "=="))        //false
}

data class User(var id: Int, var name: String)