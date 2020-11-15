package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        if(fullName=="") {
            return null to null
        }else if (fullName==" ")
            return null to null
            else{
        val parts:List<String>? = fullName?.split(" ")

        val firstName =parts?.getOrNull(0)
        val lastName =parts?.getOrNull(1)
        //return Pair(firstName, lastName)
        return firstName to lastName
    }}

    fun transliterations(payload: String, divider:String = " "): String {
        TODO ("not implemented") // To change bode of created fuctions use File | Settings| File Templates

    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO ("not implemented") // To change bode of created fuctions use File | Settings| File Templates
    }
}