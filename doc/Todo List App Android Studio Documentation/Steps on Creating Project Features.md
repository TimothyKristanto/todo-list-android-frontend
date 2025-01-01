
**Disclaimer:** 
- The steps below are only a rough steps on how to create a single feature in Android Studio compose
- Please note that the implementation of the steps below may differ between individuals based on the feature that will be developed
- You can open the Android Studio compose project in this Github repo for further details and example

### When creating a feature, you may follow these steps below:
1. Inside the services folder **(you can create one if you don't have it)**, create a new kotlin file **(you may name it like the following example: AuthenticationService.kt)**
2. The content of this service file is filled only with retrofit services which send http requests to the backend application that you have made **(please refer to the Android Studio project in this Github repo for example and more details)**
3. After creating the service file, create a new kotlin file inside the models folder **(you can create one if you don't have it)** and you may name it, for example, like AuthenticationModel.kt
4. The content of this model file is filled only with data classes which will define the data received from the backend application **(please refer to the Android Studio project in this Github repo for example and more details)**
5. After creating the model file, create a new kotlin file inside the repositories folder **(you can create one if you don't have it)** and you may name it, for example, like AuthenticationRepository.kt
6. The content of this repository file is filled only with data processing logic **(please refer to the Android Studio project in this Github repo for example and more details)**
7. After creating the repository file, create a new kotlin file as the application container in the root folder, you may name it as AppContainer.kt **(Skip this step if you have made the container file before)**
8. For the content of this AppContainer.kt will be explained deeper in page [[Creating Application Container File]]
9. The next file to be created would be the application file **(Skip this step if you have made the application file before)** which you can name it, for example, like TodoListApplication.kt
10. For the content of this Application file will be explained deeper in page [[Creating Application File]]
11. After creating an application file, you may create a new kotlin view model file inside the viewmodels folder **(you can create one if you don't have it)**
12. The content of this viewmodels is mainly about the application logic **(please refer to the Android Studio project in this Github repo for example and more details)**
13. A deeper explanation about calling retrofit services in view model can be found in [[Calling Retrofit Services in View Model File]]
14. After creating the view model file, you may create a new kotlin file inside the views folder **(you can create one if you don't have it)**
15. The content of this file will be the Android UI/UX of your application using compose **(please refer to the Android Studio project in this Github repo for example and more details)**
16. A deeper explanation about displaying fetched data in view can be found in [[Displaying Fetched Data from Backend App in View File]]
17. You can repeat Step 1-16 when to implement a new feature