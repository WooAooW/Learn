/**
 * Created by liyu on 2017/6/1.
 */
fun main(args: Array<String>) {
    val user = User(1, "Kiss")
    println("ID: ${user.id},Name: ${user.name}")

    val (id, name) = user
    println("ID: $id,Name: $name")
}

data class User(var id: Int, var name: String)