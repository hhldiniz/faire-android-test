# faire-android-test
This project is a test for an Android position at Faire

## Trade offs
* Project architecture

    This project uses Clean Architecture to organize it's classes, but this also means that a lot of boilerplate is necessary 
    in the beginning of the project, but this allows one to extend and maintain the project more easily.
* First-party Libraries 

    Some 1st party libs were used to improve project maintainability and scalability like Jetpack Navigation and Databinding, but this also means that some initial time is necessary to setup classes and resources while it also increases the final package size (since it now has more dependencies in it).
    
* Delegate image loading to a 3rd party library

    This project used Glide to load images. While it's a great tool and easy to use, it also breaks the code architecture a bit since it has it's own lifecycle

## How to run this project
1. The easiest way to run this project is with Android Studio. Download it from google (https://developer.android.com/studio) 
or install it from your system's package distribution platform.
2. Download the project either by cloning it with git or as a zip file. In case you opt for a zip file, extract it in a folder of your choice.
3. Open Android Studio and open the project folder in it.
4. After the indexing is completed, connect a physical device or an emulator (The device must be in developer mode with USB debugging enabled).
5. Select the device you want the app running

![image](https://user-images.githubusercontent.com/11294748/187683435-c91217f3-ad19-4b6c-b582-76ccba2a0e13.png)

6. Click on the green play button at the right and wait for the app to come online (this can take some time, especially in the first run). 
Note that you need an internet connection.
## 3rd party libraries used
This project uses some Third-party libraries
* Glide

    Glide is used to download and show images. In the case of this project, is used to show an illustrative image of the weather state
* Retrofit

    This is well-known library responsible to map Rest APIs and facilitate data parsing of the response.
* Koin

    One of many options for dependency injection. It's a lightweight easy-to-use DI lib made with Kotlin in mind. 
    It uses a declarative-style syntax that takes advantage of the Kotlin code style that is easy to understand.
## Additional information
* This project is configured to run starting from API level 27 (Android Oreo) 
