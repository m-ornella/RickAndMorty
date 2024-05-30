package fr.epsi.nguyen_vitry.rickandmorty.network

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import fr.epsi.nguyen_vitry.rickandmorty.model.Characters
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://rickandmortyapi.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface RickAndMortyApiService {
    @GET("characters")
    suspend fun getCharacters(): List<Characters>
}