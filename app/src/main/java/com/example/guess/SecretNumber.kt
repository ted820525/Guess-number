package com.example.guess

import java.util.*

class SecretNumber{
    val secret : Int = Random().nextInt(10)+1
    var count =0
    fun validate(number:Int):Int{
        count ++
        return number - secret
    }

    fun reset(){
        val secret : Int = Random().nextInt(10)+1
        count= 0

    }
}
fun main(){
    val secretNumber = SecretNumber()
    print(secretNumber.secret)
    println("${secretNumber.validate(2)},cunt:${secretNumber.count}")

}