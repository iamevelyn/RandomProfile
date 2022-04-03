package com.example.randomprofile.activities

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.randomprofile.API.APIService
import com.example.randomprofile.R
import com.example.randomprofile.entities.User
import com.example.randomprofile.resources.CircleTransform
import com.example.randomprofile.resources.Connectivity
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Profile: AppCompatActivity() {

    lateinit var name : TextView
    lateinit var lastName : TextView
    lateinit var age : TextView
    lateinit var sex : TextView
    lateinit var birthday : TextView
    lateinit var userName : TextView
    lateinit var password : TextView
    lateinit var phone : TextView
    lateinit var phone2 : TextView
    lateinit var mail : TextView
    lateinit var street_number : TextView
    lateinit var state : TextView
    lateinit var city : TextView
    lateinit var postcode : TextView
    lateinit var country : TextView
    lateinit var photo: ImageView
    lateinit var layout2: LinearLayout
    lateinit var layout3: LinearLayout
    lateinit var btRandom: Button





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        setControls()
        SetEvents()

    }
    fun setControls(){
        this.name = findViewById<View>(R.id.tvName) as TextView
        this.age = findViewById<View>(R.id.tvAge) as TextView
        this.sex = findViewById<View>(R.id.tvSex) as TextView
        this.birthday = findViewById<View>(R.id.etBirthday) as TextView
        this.userName = findViewById<View>(R.id.etUser) as TextView
        this.password = findViewById<View>(R.id.etpassword) as TextView
        this.phone = findViewById<View>(R.id.etphone) as TextView
        this.phone2 = findViewById<View>(R.id.etphone2) as TextView
        this.mail = findViewById<View>(R.id.etmail) as TextView
        this.street_number = findViewById<View>(R.id.etstreet_number) as TextView
        this.city = findViewById<View>(R.id.etcity) as TextView
        this.state = findViewById<View>(R.id.etstate) as TextView
        this.postcode = findViewById<View>(R.id.etpostcode) as TextView
        this.country = findViewById<View>(R.id.etcountry) as TextView
        this.photo = findViewById<View>(R.id.ivprofile_image) as ImageView
        this.layout2 = findViewById<View>(R.id.layout2) as LinearLayout
        this.layout3 = findViewById<View>(R.id.layout3) as LinearLayout
        this.btRandom = findViewById<View>(R.id.btRandom) as Button

        layout2.setVisibility(LinearLayout.GONE)

    }


    fun SetEvents()
    {
        btRandom!!.setOnClickListener{

            try {

                if (Connectivity().VerifyConnection(this) == true) {
                    if(Connectivity().isOnlineNet() == true){
                        Search()

                    }else{
                        Toast.makeText(this, getString(R.string.internet_access) , Toast.LENGTH_LONG).show()
                    }

                }else{

                    Toast.makeText(this, getString(R.string.internet_access) , Toast.LENGTH_LONG).show()
                }

            } catch (e: Exception) {
                e.localizedMessage

            }
        }



    }


    fun Search(){

        CoroutineScope(Dispatchers.IO).launch {


            val call = getRetrofit().create(APIService::class.java).getUsers()
            val puppies = call.body()
            runOnUiThread {
                if (call.isSuccessful) {

                    val result = puppies?.users ?: emptyList()
                    if (result != null){
                        Picasso.get().load(result[0].picture.medium.toString()).transform(CircleTransform())
                            .into(photo)

                        name.setText("Hi " + result[0].name.title + " " + result[0].name.first + " " + result[0].name.last)
                        age.setText(result[0].dob.age+ " years")
                        sex.setText(result[0].gender)
                        birthday.setText(result[0].dob.date)
                        userName.setText(result[0].security.username)
                        password.setText(result[0].security.password)
                        phone.setText(result[0].phone)
                        phone2.setText(result[0].cell)
                        mail.setText(result[0].email)
                        street_number.setText(result[0].location.street.name + " " + result[0].location.street.number  )
                        city.setText(result[0].location.city)
                        state.setText(result[0].location.state)
                        postcode.setText(result[0].location.postcode)
                        country.setText(result[0].location.country)

                        layout3.setVisibility(LinearLayout.GONE)
                        layout2.setVisibility(LinearLayout.VISIBLE)

                    }


                } else {
                    showError()
                }


            }

        }

    }

    fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://randomuser.me/api/")
            .build()
    }

    private fun showError(){
        
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
    


}