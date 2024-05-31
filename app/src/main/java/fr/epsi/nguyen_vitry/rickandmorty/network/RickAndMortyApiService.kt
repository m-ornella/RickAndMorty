package fr.epsi.nguyen_vitry.rickandmorty.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import fr.epsi.nguyen_vitry.rickandmorty.model.Characters
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL = "https://rickandmortyapi.com/api/character"
private var retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()
interface RickAndMortyApiService {
    @GET("characters")
    suspend fun getCharactersName(): List<Characters>
}

object RickAndMortyApi{
    val retrofitService: RickAndMortyApiService by lazy {
        retrofit.create(RickAndMortyApiService::class.java)
    }
}