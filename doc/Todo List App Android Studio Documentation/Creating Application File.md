#### Important steps to be implemented when creating application file:
1. Add the datastore library to save any data, especially the ones related to authentication, see the code example below to add the datastore library inside application file **(Don't forget to import required modules)**
```
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(  
    name = "datastore_name"  
)
```

2. Initialize application container in this application file, see the example code below to initialize application container
```
class TodoListApplication: Application() {  
    lateinit var container: AppContainer  
    override fun onCreate() {  
        super.onCreate()  
        container = DefaultAppContainer(dataStore)  
    }  
}
```

3. Add this application file to AndroidManfiest.xml inside the ```<application``` tag, see the code below as an example
```
<application  
    android:name=".TodoListApplication"
    ...
    ...
    ...
```

4. ***Please refer to the Android Studio project in this Github repo for example and more details***
