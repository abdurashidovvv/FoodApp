# FoodApp

![FoodApp](https://github.com/user-attachments/assets/faee4bb3-2a51-4450-bdbe-f4c890a322c9)

FoodApp is a simple Android application that demonstrates the usage of modern Android development tools and practices. This project follows the principles of Clean Architecture and MVVM (Model-View-ViewModel) pattern. It uses Dagger Hilt for dependency injection, Retrofit for network operations, and Jetpack Compose for the UI.

## Features

- Fetch meals data from a remote API
- Clean Architecture
- MVVM pattern
- Dependency Injection with Dagger Hilt
- Network operations with Retrofit
- Modern UI with Jetpack Compose

## Tech Stack

- **Programming Language**: Kotlin
- **Architecture**: Clean Architecture
- **Design Pattern**: MVVM (Model-View-ViewModel)
- **Dependency Injection**: Dagger Hilt
- **Networking**: Retrofit
- **UI**: Jetpack Compose

## Setup

1. **Clone the repository**:
    ```bash
    git clone https://github.com/abdurashidovvv/FoodApp.git
    ```

2. **Open the project in Android Studio**:
    - Open Android Studio
    - Select "Open an existing project"
    - Navigate to the cloned repository and open it

3. **Build the project**:
    - Click on the "Build" menu
    - Select "Make Project"

4. **Run the app**:
    - Click on the "Run" menu
    - Select "Run 'app'"

## Architecture Overview

This project is organized following the Clean Architecture principles. The codebase is divided into three main layers:

1. **Presentation Layer**: Contains the UI components and the ViewModel. This layer is responsible for displaying data and handling user interactions.

2. **Domain Layer**: Contains the business logic of the application. This layer is independent of any framework or library.

3. **Data Layer**: Handles data operations and provides data to the domain layer. This includes network operations using Retrofit and local database operations.

## Modules

- **app**: Contains the Android application class and dependency injection setup.
- **presentation**: Contains the UI components built with Jetpack Compose and ViewModels.
- **domain**: Contains the use cases and repository interfaces.
- **data**: Contains the repository implementations and network setup with Retrofit.

## Screenshots
![photo_2024-07-30_21-34-06](https://github.com/user-attachments/assets/faee4bb3-2a51-4450-bdbe-f4c890a322c9)


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [Jetpack Compose](https://developer.android.com/jetpack/compose) for the modern UI toolkit
- [Dagger Hilt](https://dagger.dev/hilt/) for the dependency injection framework
- [Retrofit](https://square.github.io/retrofit/) for the networking library

## Contributing

Contributions are welcome! Please read the [CONTRIBUTING](CONTRIBUTING.md) file for more information.

---

Happy coding! 😊
