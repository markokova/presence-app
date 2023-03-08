package com.marko112.lecturepresenceapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class MySubjectsFragment : Fragment() {

    private val db = Firebase.firestore
    private val auth = FirebaseAuth.getInstance()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_subjects, container, false)

        val name = view.findViewById<TextView>(R.id.fragment_my_subjects_user_name)
        val recyclerView = view.findViewById<RecyclerView>(R.id.fragment_my_subjects_list_of_subjects)

        val subjects = ArrayList<Subject>()
        val recyclerAdapter = SubjectRecyclerAdapter(subjects)
        var flag = 1
        //val currentUser: IUser   => napravit sucelje IUser za profesora i studenta
        var currentUser: IUser
        //iterate through database and find the name of current student => to fill the textView with
        db.collection("students")
            .get()
            .addOnSuccessListener {
            for(data in it.documents){
                val student = data.toObject(Student::class.java)
                if(student?.email == auth.currentUser?.email){
                    if (student != null) {
                        currentUser = student
                        name.text = (currentUser as Student).name
                        flag = 2
                    }
                }
            }
        }

        //iterate through database and find the name of current professor => to fill the textView with
        db.collection("professors")
            .get()
            .addOnSuccessListener {
                for(data in it.documents){
                    val professor = data.toObject(Professor::class.java)
                    if(professor?.email == auth.currentUser?.email){
                        if (professor != null) {
                            currentUser = professor
                            name.text = (currentUser as Professor).name
                            flag = 3
                        }
                    }
                }
            }

        db.collection("subjects")
            .get()
            .addOnSuccessListener {
                for(data in it.documents){
                    val subject = data.toObject(Subject::class.java)
                    if(flag == 2){
                        if((currentUser as Student).)
                    }
                    else if(flag == 3){

                    }
                }
            }

        recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MySubjectsFragment.activity)
            adapter = recyclerAdapter
        }

        name.text = auth.currentUser?.email
        return view
    }

}