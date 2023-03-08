package com.marko112.lecturepresenceapp

class Subject(
    var id: String,
    val name: String,
    val toScan: Boolean,
    val professors: ArrayList<Professor>,
    val lectures: ArrayList<Lecture>,
    val totalAVNum: Int,
    val totalPRNum: Int,
    val totalLVNum: Int,
    val totalKVNum: Int
    ) {

}