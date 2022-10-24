# Movies-TMDB
Android Kotlin+ MVVM + Retrofit2 + Room +Dagger2 +  Coroutines + Junit4 + + Espresso + Mockito + MockWebServer

Movies-TMDB
Android Movies-TMDB sample app to lists latest movies implementing MVVM with Clean Architecture using kotlin following solid and clean code principles .

Latest Movies Movies Search Hint Latest Search Movie Details Liked Movie Details

The goal of this app is to show how to implement MVVM design pattern with architecture components & clean architecture in Kotlin .

Tech stack:
Kotlin, MVVM, Dagger2, Retrofit2, OkHttp3, Room, Coroutines, Navigation-component, Ui-Testing - Espresso, Unit-Testing - Mockito.

Source Code Presentation :
Base : Base level classes (Activity, Fragment & Viewmodel).
Main : MainActivity handling navigation between fragment using navigation component.
Movies : Main Screen with grid displaying all movies list.
Detail : Detail screen displaying selected movie details & trailer list.
Utils : Configuration for Network layer, Database & Dagger alongside helper classes.
Each package is divided into multiple packages demonstrated as following.

Data : Contains data layer which has local & remote data sources with repository implementation.
Domain : Contains the domain layer wiht factory logic & mapper before.
Di : Contains all dagger depndencies mapping.
View : Contains the view layer that consists of views & viewModels.

If you find this repository useful please give it a star. Please feel free to make a pull request or fork.
