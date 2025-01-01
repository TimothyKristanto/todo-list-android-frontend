#### Important steps to be implemented when calling retrofit services in the view model file:
1. Create a data status ui state kotlin file in the uiStates folder **(you can create one if you don't have it)**
2. The content of this data status ui state kotlin file will define the status when calling retrofit services, such as Success, Failure, or even Loading **(please refer to the Android Studio project in this Github repo for example and more details)**
3. See the codes example below for the content of this file:
```
sealed interface AuthenticationStatusUIState {  
    data class Success(val userModelData: UserModel): AuthenticationStatusUIState  
    object Loading: AuthenticationStatusUIState  
    object Start: AuthenticationStatusUIState  
    data class Failed(val errorMessage: String): AuthenticationStatusUIState  
}
```
4. Create a variable to save the data status in view model, see the codes example below to implement this functionality:
```
var dataStatus: AuthenticationStatusUIState by mutableStateOf(AuthenticationStatusUIState.Start)  
    private set
```
6. Add a companion object to define the factory of the view model file, the purpose of this factory is to integrate repositories with the view model
7. See the codes example below to implement the view model's factory **(Ignore any errors which pop up and follow the steps until the very end)**:
```
companion object {  
    val Factory: ViewModelProvider.Factory = viewModelFactory {  
        initializer {  
            val application = (this[APPLICATION_KEY] as TodoListApplication)  
            val authenticationRepository = application.container.authenticationRepository  
            val userRepository = application.container.userRepository  
            AuthenticationViewModel(authenticationRepository, userRepository)  
        }  
    }}
```

6. Add parameters to the view model's factory, as you can see, the view model is called inside the factory with 2 arguments, which are authenticationRepository and userRepository, therefore we need to add 2 new parameters to the view model which are authenticationRepository and userRepository
7. See the example below to add new parameters:
```
class AuthenticationViewModel(  
    private val authenticationRepository: AuthenticationRepository,  
    private val userRepository: UserRepository  
....
....
....
....
....
```

8. After implementing all the steps above, you can start making the application logics, such as fetching data from the backend application or creating new data and send it to the backend application **(please refer to the Android Studio project in this Github repo for example and more details)**
9. See the example below to call the view model in a view file correctly:
```
fun TodoListApp(  
	...
    authenticationViewModel: AuthenticationViewModel = viewModel(factory = AuthenticationViewModel.Factory),
    ... 
)
```