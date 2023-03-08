package com.marko112.lecturepresenceapp

import com.google.rpc.Help.Link
import java.util.Dictionary

class Student(
    private var id: String,
    val name: String,
    val email: String,
    private val attendance: LinkedHashMap<Subject, LinkedHashMap<String, Int>>
):IUser {

    fun attendActivity(currentSubject: Subject){
        if(currentSubject.lectures.last().type == Lecture.LectureType.PR){
            val lastValue = attendance[currentSubject]?.get(Lecture.LectureType.PR.toString())
            val newValue = lastValue!!.plus(1)
            attendance[currentSubject]?.set(Lecture.LectureType.PR.toString(), newValue)
        }
        if(currentSubject.lectures.last().type == Lecture.LectureType.AV){
                val lastValue = attendance[currentSubject]?.get(Lecture.LectureType.AV.toString())
                val newValue = lastValue!!.plus(1)
                attendance[currentSubject]?.set(Lecture.LectureType.AV.toString(), newValue)
        }
        if(currentSubject.lectures.last().type == Lecture.LectureType.LV){
                val lastValue = attendance[currentSubject]?.get(Lecture.LectureType.LV.toString())
                val newValue = lastValue!!.plus(1)
                attendance[currentSubject]?.set(Lecture.LectureType.LV.toString(), newValue)
        }
        if(currentSubject.lectures.last().type == Lecture.LectureType.KV){
                val lastValue = attendance[currentSubject]?.get(Lecture.LectureType.KV.toString())
                val newValue = lastValue!!.plus(1)
                attendance[currentSubject]?.set(Lecture.LectureType.KV.toString(), newValue)
        }
    }
}
/*
*
private operator fun Int?.set(currentSubject: Subject, value: Int) {
    value
}

private operator fun Int?.get(currentSubject: Subject) {

}

//nisam siguran sta ovo radi ali bez toga nisam mogao napraviti ovo => attendance[subject] = 4
private operator fun <K, V> LinkedHashMap<K, V>.set(subject: MutableMap.MutableEntry<K, V>, value: V) {

}
* */
