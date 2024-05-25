# MedicineApp: Android Medicine Management Application

## Overview

MedicineApp is an Android application designed to simplify medicine management for users. The project follows the MVVM (Model-View-ViewModel) architecture pattern and leverages modern technologies such as Clean Architecture, Jetpack Compose, Jetpack ViewModel, Jetpack Navigation, Retrofit for network requests, Room DB for local storage, Coroutines for asynchronous operations, and comprehensive unit testing coverage.

## Screens

### Login Screen

- Provides a straightforward login interface.
- No validation requirements for logging in.

### Medication List with Greeting

- Greets the user based on the time of day after successful login.
- Presents a list of medications fetched from an external JSON API.

### Medication Details

- Displays detailed information about the selected medication.
- Accessed by tapping on a medication card from the list.

## Implementation Details

- **Architecture:** Follows MVVM (Model-View-ViewModel) architecture for separation of concerns and maintainability.
- **Clean Architecture:** Adheres to Clean Architecture principles for scalability and maintainability.
- **Jetpack Compose:** Utilizes Jetpack Compose for modern, declarative UI development.
- **Jetpack ViewModel:** Employs Jetpack ViewModel to manage UI-related data and lifecycle.
- **Jetpack Navigation:** Utilizes Jetpack Navigation for seamless screen transitions and navigation.
- **Retrofit:** Integrates Retrofit for simplified network requests and API communication.
- **Room DB:** Utilizes Room DB for local data storage, ensuring offline access and improved performance.
- **Coroutines:** Employs Coroutines for asynchronous operations, enhancing app responsiveness and efficiency.
- **Unit Test Coverage:** Includes comprehensive unit tests covering critical components and functionalities.
- **Kotlin 100% Coverage:** The entire project is written in Kotlin with complete code coverage.


