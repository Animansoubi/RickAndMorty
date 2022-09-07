package com.mahdyar.rickandmorty

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.mahdyar.rickandmorty.network.CharacterResponse
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    // what do you know about activity?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)//  what saveInstance state do?
        setContentView(R.layout.activity_main)// vew by id VS view binding

        val dependencyProvider = DependencyProvider()

        val client = dependencyProvider.provideRickSndMortyService().fetchCharacters("1")

        // do you know how did you create retrofit call and enqueue vs execute
        //what is the call back that you've used here
        client.enqueue(object : retrofit2.Callback<CharacterResponse> {
            // On Successful Response
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d("characters", "" + response.body())
                    val result = response.body()?.result
                    result?.let {
                        val adapter = MainAdapter(result)
                        val recyclerView = findViewById<RecyclerView>(R.id.charactersRv)
                        recyclerView?.layoutManager =
                            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                        recyclerView?.adapter = adapter
                    }
                }
            }
            // On Failure Response
            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("failed", "Network Call Failed with this message:" + t.message)
            }
        })
    }
}