package ru.skillbranch.devintensive.models


import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

abstract class BaseMessage (
    val id:String,
    val from:User?,
    val chat:Chat,
    val isIncoming : Boolean = false,
    val date:Date= Date()
){

    abstract fun formatMessage():String

    companion object AbstractFactory{
        var lastId = -1;
        fun makeMessage(from:User?, chat: Chat, date: Date = Date(), type:String = "text", payload:Any?):BaseMessage{
            lastId++
            return when(type){
                "image"-> ImageMessage("",from,chat,date = date,image = payload as String)
                    else -> TextMessage("",from,chat,date = date,text = payload as String)

            }
        }
    }
}