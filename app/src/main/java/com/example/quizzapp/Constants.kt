package com.example.quizzapp

object Constants{

    const val User_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"


    fun getQuestions(): ArrayList<Questions>{

        val questionList = ArrayList<Questions>()

        val quest1 = Questions(
            1,
            "capitale cameroun ?",
            R.drawable.cmr,
            "Yaoundé",
            "Douala",
            "Kribi",
            "Edéa",
            1)
        questionList.add(quest1)

        val quest2 = Questions(
            2,
            "capitale cameroun ?",
            R.drawable.ngr,
            "Yaoundé",
            "Douala",
            "Kribi",
            "Edéa",
            1)
        questionList.add(quest2)

        val quest3 = Questions(
            3,
            "capitale cameroun ?",
            R.drawable.gabon,
            "Yaoundé",
            "Douala",
            "Kribi",
            "Edéa",
            1)
        questionList.add(quest3)

        val quest4 = Questions(
            4,
            "capitale cameroun ?",
            R.drawable.civ,
            "Yaoundé",
            "Douala",
            "Kribi",
            "Edéa",
            1)
        questionList.add(quest4)

        val quest5 = Questions(
            5,
            "capitale cameroun ?",
            R.drawable.sen,
            "Yaoundé",
            "Douala",
            "Kribi",
            "Edéa",
            1)
        questionList.add(quest5)

        val quest6 = Questions(
            6,
            "capitale cameroun ?",
            R.drawable.ngr,
            "Yaoundé",
            "Douala",
            "Kribi",
            "Edéa",
            1)
        questionList.add(quest6)

        val quest7 = Questions(
            7,
            "capitale cameroun ?",
            R.drawable.mali,
            "Yaoundé",
            "Douala",
            "Kribi",
            "Edéa",
            1)
        questionList.add(quest7)

        val quest8 = Questions(
            8,
            "capitale cameroun ?",
            R.drawable.moz,
            "Yaoundé",
            "Douala",
            "Kribi",
            "Edéa",
            1)
        questionList.add(quest8)

        val quest9 = Questions(
            9,
            "capitale cameroun ?",
            R.drawable.ethiop,
            "Yaoundé",
            "Douala",
            "Kribi",
            "Edéa",
            1)
        questionList.add(quest9)

        val quest10 = Questions(
            10,
            "capitale cameroun ?",
            R.drawable.cmr,
            "Yaoundé",
            "Douala",
            "Kribi",
            "Edéa",
            1)
        questionList.add(quest10)

        return questionList
    }
}