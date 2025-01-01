
1. Create a new Android Studio compose project
2. Go to build.gradle.kts (Module:app)
3. Copy the codes below and add it to build.gradle.kts (Module:app)
```
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.6")  
implementation("androidx.navigation:navigation-compose:2.7.4")
implementation("androidx.datastore:datastore-preferences:1.0.0")
implementation("com.squareup.retrofit2:retrofit:2.11.0")
implementation("com.squareup.retrofit2:converter-gson:2.11.0")
implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
```
4. Click on "sync now"
5. Go to AndroidManifest.xml
6. below the ```<manifest xmlns.....```, copy and paste the code below
```
<uses-permission android:name="android.permission.INTERNET"/>
```
7. below the ```<application```, copy and paste the codes below
``` 
android:usesCleartextTraffic="true"
```
8. Please refer to the Android Studio project in this github repo for more details
9. For the next step, please read [[Steps on Creating Project Features]]