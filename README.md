# Empowerment Labs

- Se aplicó Clean Architecture para la separación del proyecto por capas, 4 en total "data" (Procesamiento de los datos),
  "di" (Inyección de dependencias con Dagger Hilt), "domain" (Logica de negocio, se decide de que data source será tomaran
  los datos, si del remote o del local), "ui" (todo lo que tenga que ver con la interfaz de usuario; activity, fragment, adapter)
  
- Implementación del patron de diseño MVVM, se basa en tener un viewmodel; la ui solicita información al viewmodel, el viewmodel
  a su vez le solicita información a la data y esta se la devuelve, al  devolverla, en el viewmodel nos subscribimos a un evento
  con LiveData, que va a ser la encargada de la comunicación viewmodel-actitvity/fragment, en el activity/fragment estaremos
  "oyendo" este evento con un Observer, la cual actualiza la ui.
  
- Podría decir que se me presenatron inconveniente a la hora de obtener los datos del API, lo que hice fue buscar el porque del problema
  con logs y/o depurando, pense en porque estaría sucediendo esto, luego inplementé posibles soluciones, elegi la más factible y
  asi fue como solucione el inconveniente.

### Tecnologías usadas

- 👉 Principios SOLID
- 👉 Clean Architecture
- 👉 Navigation Component
- 👉 MVVM Architecture
- 👉 Architectural Components
- 👉 Coroutines
- 👉 Room
- 👉 Inyección de dependencias con Dagger Hilt
- 👉 Retrofit
- 👉 Gson
- 👉 Unit Test
- 👉 viewBinding
- 👉 Coil
- 👉 Glide
- 👉 Clean Code
- 👉 Manejo de estados
- 👉 Versionamiento del código con GIT