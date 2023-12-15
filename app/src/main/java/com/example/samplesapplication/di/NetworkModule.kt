package com.example.samplesapplication.di

import com.example.samplesapplication.api.ApiService
import com.example.samplesapplication.utils.Constants.AUTH_TOKEN
import com.example.samplesapplication.utils.Constants.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header("authToken", AUTH_TOKEN)
                val request = requestBuilder.build()
                chain.proceed(request)
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Any::class.java, ArrayOrObjectDeserializer<Any>())
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun providesProjectsAPI(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)

    }
}

class ArrayOrObjectDeserializer<T> : JsonDeserializer<T> {

    private val gson = Gson()

    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): T {
        return if (json?.isJsonArray == true) {
            gson.fromJson(json, typeOfT)
        } else {
            val jsonArray = gson.toJsonTree(listOf(json)).asJsonArray
            gson.fromJson(jsonArray, typeOfT)
        }
    }
}