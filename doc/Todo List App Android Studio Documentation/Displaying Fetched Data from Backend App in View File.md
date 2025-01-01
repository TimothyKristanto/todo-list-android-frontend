#### Important steps to be implemented when displaying data in view file:
1. Initialize view model
2. call the data status variable from view model
3. see the codes example below to show the data:
```
when (dataStatus) {  
    is TodoDataStatusUIState.Success -> 
    // show something when data fetched successfully
    is TodoDataStatusUIState.Failed -> 
    // show something when there is failure when fetching new data
    else -> 
    // show loading bar or something when the data is being fetched 
}
```
4. Please refer to the Android Studio project in this Github repo for detailed example
