#### Important steps to be implemented in the application container file:
1. Please add your backend application link **(please refer to the Android Studio project in this Github repo for example and more details)**
2. Do not use localhost for the backend application link, use your current wifi's IP address
3. Copy the function below to initialize retrofit 
```
private fun initRetrofit(): Retrofit {  
    val logging = HttpLoggingInterceptor()  
    logging.level = (HttpLoggingInterceptor.Level.BODY)  
  
    val client = OkHttpClient.Builder()  
    client.addInterceptor(logging)  
  
    return Retrofit  
        .Builder()  
        .addConverterFactory(  
            GsonConverterFactory.create()  
        )  
        .client(client.build())  
        .baseUrl(baseUrl)  
        .build()  
}
```
3. Initialize retrofit for every feature in your app, see the example of the code to initialize retrofit for a single feature below:
```
private val authenticationRetrofitService: AuthenticationAPIService by lazy {  
    val retrofit = initRetrofit()  
  
    retrofit.create(AuthenticationAPIService::class.java)  
}
```
***Note: Please refer to the Android Studio project in this Github repo for example and more details***

4. Initialize repository for every feature in your app, see the example of the code to initialize repository for a single feature below:
```
override val authenticationRepository: AuthenticationRepository by lazy {  
    NetworkAuthenticationRepository(authenticationRetrofitService)  
}
```
***Note: Please refer to the Android Studio project in this Github repo for example and more details***