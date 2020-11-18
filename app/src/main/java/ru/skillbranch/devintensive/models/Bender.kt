package ru.skillbranch.devintensive.models

class Bender(var status:Status = Status.NORMAL, var question: Question = Question.NAME) {

    fun askQuestion(): String = when(question){
        Question.NAME->Question.NAME.question
        Question.PROFESSION->Question.PROFESSION.question
        Question.MATERIAL->Question.MATERIAL.question
        Question.BDAY->Question.BDAY.question
        Question.SERIAL->Question.SERIAL.question
        Question.IDLE->Question.IDLE.question

    }
    var i=0
    fun listenAnswer(answer:String):Pair<String, Triple<Int, Int, Int>> {

        if (i<3){
       return if(question.answer.contains(answer)){
           i=0
           question=question.nextQuestion()
            "Отлично - ты справился\n${question.question}" to status.color
        }else{
           i++
           status=status.nextStatus()
            "Это неправильный ответ\n${question.question}" to status.color
        }}else{
            i=0
            status=Status.NORMAL
            question=Question.NAME
            var reset =  "Это не правильный ответ. Давай все по новой\n${question.question}" to status.color
            return reset
    }}

    enum class Status(val color: Triple<Int,Int,Int>){
        NORMAL(Triple(255,255,255)),
        WARNING(Triple(255,120,0)),
        DANGER(Triple(255,60,60)),
        CRITICAL(Triple(255,255,0));

        fun nextStatus():Status{
            return if (this.ordinal< values().lastIndex){
                values()[this.ordinal +1]
            }else{
                values()[0]
            }

        }
    }


    enum class Question(val question: String, val answer: List<String>){
        NAME("Как меня зовут?", listOf("бендер", "bender")) {
            override fun nextQuestion():Question = PROFESSION
        },
        PROFESSION ("Назови мою профессию?", listOf("сгибальщик", "bender")){
            override fun nextQuestion():Question = MATERIAL
        },
        MATERIAL ("Из чего я сделан?", listOf("металл", "дерево", "metal", "iron","wood")){
            override fun nextQuestion():Question = BDAY
        },
        BDAY ("Когда меня создали?", listOf("2993")){
            override fun nextQuestion():Question = SERIAL
        },

        SERIAL("Мой серийный номер?", listOf("2716057")){
            override fun nextQuestion():Question = IDLE
        },
        IDLE("На этом впоросов больше нет", listOf()){
            override fun nextQuestion():Question = IDLE
        };

        abstract fun nextQuestion():Question
    }
}