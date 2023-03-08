package com.marko112.lecturepresenceapp

import android.media.Image
import java.util.Date

class Lecture(
    var id: String,
    val qrCode: Image,
    val type: LectureType,
    val date: Date,
    val presentStudents: ArrayList<Student>,
    val professor: Professor,
    val number: Int
) {

    enum class LectureType{
        PR, AV, LV, KV
    }
}