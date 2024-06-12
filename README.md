# RangTech

RangTech is an Android application built using Jetpack Compose, Kotlin, and Hilt for dependency injection. This application provides authentication features and interacts with APIs hosted locally.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Server Setup](#server-setup)
- [Running the Application](#running-the-application)
- [Testing](#testing)
- [License](#license)

## Features

- User authentication (Login and Registration)
- Jetpack Compose for modern UI development
- Hilt for dependency injection
- MVVM architecture

## Technologies Used

- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Hilt](https://dagger.dev/hilt/)
- [Navigation Component](https://developer.android.com/guide/navigation)
- [Retrofit](https://square.github.io/retrofit/) for API calls

## Setup and Installation

### Prerequisites

- [Android Studio](https://developer.android.com/studio) installed
- Local server setup (Flask)

### Steps

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-username/rangtech.git
   cd rangtech
   ```

2. **Open the project in Android Studio**:

   Open Android Studio and select `Open an existing project`. Navigate to the cloned repository.

3. **Sync the project**:

   Android Studio will prompt you to sync the project with Gradle files. Click on `Sync Now`.

## Server Setup

To set up the local Flask server that the Android application will interact with, follow these steps:

### Using Flask

1. **Ensure you have Python 3.10 or higher installed**.

2. **Open a terminal or command prompt**.

3. **Create a new directory and navigate to it**:

   ```bash
   mkdir tendable
   cd tendable
   ```

4. **Clone the repository**:

   ```bash
   git clone https://github.com/tendable/mobile-coding-excerise.git
   cd mobile-coding-excerise
   ```

5. **Create a virtual environment**:

   ```bash
   python -m venv tvenv
   ```

6. **Activate the virtual environment**:

   - On macOS/Linux:

     ```bash
     source tvenv/bin/activate
     ```

   - On Windows:

     ```bash
     tvenv\Scripts\activate
     ```

7. **Install the required dependencies**:

   ```bash
   pip install -r requirements.txt
   ```

8. **Run the Flask server**:

   ```bash
   python run.py
   ```

   The server should now be running at `http://localhost:5001` or `http://127.0.0.1:5001`. You will see the content of the Readme on the landing page.

Please refer to the API documentation for guidance. It is not necessary to use all of the APIs to complete the test.

### Modifying API URLs in the Android Project

Update the API URLs in your project to use `http://10.0.2.2:5001` for the Android emulator.

```kotlin
val apiUrl = "http://10.0.2.2:5001/api"
```

## Running the Application

1. **Start the Android emulator**:

   Launch an Android Virtual Device (AVD) from the AVD Manager in Android Studio.

2. **Run the application**:

   Click on the `Run` button in Android Studio or use the shortcut `Shift + F10`. The application should start on the emulator.

## Testing

To run the tests for this project:

1. **Unit Tests**:

   Run the unit tests using the command:

   ```bash
   ./gradlew test
   ```

2. **Instrumented Tests**:

   Run the instrumented tests on an emulator or connected device:

   ```bash
   ./gradlew connectedAndroidTest
   ```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
