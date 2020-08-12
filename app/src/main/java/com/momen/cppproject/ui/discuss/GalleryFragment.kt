package com.momen.cppproject.ui.discuss

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.auth.User
import com.momen.cppproject.Authentication.welcomeScreen
import com.momen.cppproject.MainActivity
import com.momen.cppproject.R
import com.momen.cppproject.recycler_view.chatAdapter
import kotlinx.android.synthetic.main.fragment_gallery.*
import model.Users
import model.dataChat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import services.serviceBuilder
import services.usersService
import java.util.ArrayList

class GalleryFragment : Fragment() {


    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        galleryViewModel =
            ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        return root


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Getting the email from login
        val sharedPref : SharedPreferences ? = activity?.getSharedPreferences("saving" , Context.MODE_PRIVATE)
        var email : String ? =  sharedPref!!.getString("email" , "Error")



        //get the data by using real time counter ....
       // count.start()
        getUsers()



        imageSend.setOnClickListener {

            //To add a new message to the backEnd
            val name : List<String> = email!!.split('@')
            val email : String ? = email
            val message : String = edTxtMessage.text.toString()

            var newUser = Users(name[0] , email!! , message) //pause till i complete
            addUsers(newUser)



            //Change the image when the button clicked
            imageSend.setImageResource(R.drawable.send_icon_clicked)
            //Return to the first image
            val handler = Handler()
            handler.postDelayed({
                imageSend.setImageResource(R.drawable.send_icon2)
            }, 100)

            //Remove the text in the edit text
            edTxtMessage.text = null
            getUsers()

        }

    }

    fun getUsers(){

        val usersService = serviceBuilder.buildService(usersService::class.java)

        val requestCall = usersService.getUsers()

        requestCall.enqueue(object : Callback<List<Users>>{
            override fun onFailure(call: Call<List<Users>>, t: Throwable) {
                Toast.makeText(context , t.message.toString() , Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<List<Users>>, response: Response<List<Users>>) {
                if (response.isSuccessful){

                    var myMessage = ArrayList<dataChat>()
                    for ( x in 0 .. (response.body()!!.size - 1 )){
                        myMessage.add(dataChat(response.body()!![x].email , response.body()!![x].message))
                           chatRecycler.layoutManager = LinearLayoutManager(context , RecyclerView.VERTICAL , false)
                            val adapter = chatAdapter(myMessage)
                           chatRecycler.adapter = adapter
                    }
                }
            }

        })

    }
    fun addUsers(newUser : Users){
        val usersService = serviceBuilder.buildService(usersService::class.java)
        val requestCall = usersService.addUser(newUser)

        requestCall.enqueue(object : Callback<Users>{
            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(context , "Something went wrong !!" , Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Users>, response: Response<Users>) {

                if (response.isSuccessful){


                }else{
                    Toast.makeText(context , "Something went wrong !!" , Toast.LENGTH_LONG).show()
                }


            }

        })
    }


}

