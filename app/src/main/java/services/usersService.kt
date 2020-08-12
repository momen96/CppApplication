package services
import model.Users
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface usersService {

    @GET("get")
    fun getUsers() : Call<List<Users>>

    @POST("post")
    fun addUser(@Body newUser : Users) : Call<Users>


}