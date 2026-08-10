# Gestor de Tareas

Aplicación desarrollada en **Java** para gestionar tareas y usuarios. El sistema permite crear usuarios, crear y asignar tareas, cambiar el estado de las tareas y consultar las tareas según diferentes criterios.

## 📋 Descripción

El proyecto consiste en un gestor de tareas que permite organizar las actividades de diferentes usuarios.

Cada tarea cuenta con:

* ID
* Título
* Descripción
* Prioridad
* Estado
* Usuario asignado

La aplicación utiliza **JOptionPane** como interfaz para interactuar con el usuario mediante ventanas.

## 🎯 Funcionalidades

El sistema cuenta con las siguientes opciones principales:

1. **Crear usuario**
2. **Crear tarea**
3. **Asignar tarea**
4. **Cambiar estado de una tarea**
5. **Ver todas las tareas**
6. **Ver tareas por prioridad**
7. **Ver tareas por estado**
8. **Salir**

---

## 🛠️ Tecnologías utilizadas

* **Java**
* **JOptionPane** para la interfaz gráfica
* **Git** para control de versiones
* **GitHub** para almacenar el proyecto
* Arquitectura organizada por responsabilidades

---

## 📁 Estructura del proyecto

El proyecto está organizado en diferentes paquetes para separar las responsabilidades:

```text
src/
├── aplicacion/
│   ├── asignarTarea/
│   ├── cambiarEstado/
│   ├── consultarTareas/
│   ├── crearTarea/
│   └── crearUsuario/
│
├── dominio/
│   ├── estados/
│   ├── prioridades/
│   ├── tareas/
│   └── usuarios/
│
├── infraestructura/
│   └── almacenamiento/
│
└── interfaz/
    └── menu/
```

### Aplicación

Contiene las operaciones principales del sistema.

Por ejemplo, `CrearTarea` se encarga de recibir los datos necesarios para crear una tarea y guardarla mediante el repositorio.

```java
public Tarea ejecutar(
        int id,
        String titulo,
        String descripcion,
        Prioridad prioridad
) {

    Tarea tarea = new Tarea(
            id,
            titulo,
            descripcion,
            prioridad
    );

    tareaRepository.guardar(tarea);

    return tarea;
}
```

### Dominio

Contiene las entidades y elementos principales del sistema.

Entre ellos:

* `Tarea`
* `Usuario`
* `Prioridad`
* `Estado`

### Infraestructura

Contiene los componentes relacionados con el almacenamiento de la información.

En este proyecto se utiliza `TareaRepository` para guardar y consultar las tareas.

### Interfaz

Contiene el menú principal y la interacción con el usuario.

La clase `MenuPrincipal` utiliza `JOptionPane` para solicitar información y mostrar resultados.

---

## 📝 Creación de una tarea

Para crear una tarea, el programa solicita:

### 1. ID

El usuario introduce el identificador de la tarea.

```java
String idTexto = JOptionPane.showInputDialog(
        "Ingresa el ID de la tarea:"
);
```

Antes de convertirlo a `int`, se verifica si el usuario canceló:

```java
if (idTexto == null) {
    return;
}
```

Después se convierte:

```java
int id = Integer.parseInt(idTexto);
```

### 2. Título

Se solicita el título de la tarea:

```java
String titulo = JOptionPane.showInputDialog(
        "Ingresa el título de la tarea:"
);

if (titulo == null) {
    return;
}
```

### 3. Descripción

También se solicita la descripción:

```java
String descripcion = JOptionPane.showInputDialog(
        "Ingresa la descripción de la tarea:"
);

if (descripcion == null) {
    return;
}
```

Es importante declarar la variable `descripcion` antes de utilizarla. El error:

```text
descripcion cannot be resolved to a variable
```

aparecía porque se intentaba comprobar `descripcion` sin haber creado previamente esa variable.

### 4. Prioridad

El usuario puede seleccionar entre:

* ALTA
* MEDIA
* BAJA

La opción seleccionada se convierte en un valor del enum `Prioridad`.

```java
switch (prioridadTexto) {

    case "1":
        prioridad = Prioridad.ALTA;
        break;

    case "2":
        prioridad = Prioridad.MEDIA;
        break;

    case "3":
        prioridad = Prioridad.BAJA;
        break;

    default:
        JOptionPane.showMessageDialog(
                null,
                "Prioridad no válida."
        );
        return;
}
```

Finalmente, todos los datos se envían al caso de uso `CrearTarea`:

```java
Tarea tarea = crearTarea.ejecutar(
        id,
        titulo,
        descripcion,
        prioridad
);
```

---

## 👤 Creación de usuarios

El sistema permite crear usuarios introduciendo:

* ID
* Nombre

Ejemplo:

```java
int id = Integer.parseInt(
        JOptionPane.showInputDialog(
                "ID del usuario:"
        )
);

String nombre = JOptionPane.showInputDialog(
        "Nombre del usuario:"
);
```

Después se ejecuta:

```java
Usuario usuario = crearUsuario.ejecutar(
        id,
        nombre
);
```

---

## 📌 Asignación de tareas

Una tarea puede ser asignada a un usuario mediante:

* ID de la tarea
* ID del usuario

El sistema obtiene ambos identificadores y los envía al proceso encargado de realizar la asignación.

---

## 🔄 Estados de las tareas

Las tareas pueden cambiar entre diferentes estados:

```text
POR_REALIZAR
EN_PROCESO
FINALIZADA
```

El usuario selecciona una opción desde `JOptionPane` y el sistema convierte esa opción al enum correspondiente.

Ejemplo:

```java
case "1":
    estado = Estado.POR_REALIZAR;
    break;

case "2":
    estado = Estado.EN_PROCESO;
    break;

case "3":
    estado = Estado.FINALIZADA;
    break;
```

---

## 🔎 Consultas

El sistema permite consultar las tareas de diferentes maneras.

### Todas las tareas

Muestra información como:

```text
ID
Título
Descripción
Prioridad
Estado
```

### Por prioridad

Permite consultar tareas que tengan una prioridad específica:

* ALTA
* MEDIA
* BAJA

### Por estado

Permite consultar tareas según su estado:

* POR_REALIZAR
* EN_PROCESO
* FINALIZADA

---

## ⚠️ Manejo de errores

El programa utiliza `try-catch` para controlar errores cuando el usuario introduce valores que deberían ser números.

Por ejemplo:

```java
try {
    int id = Integer.parseInt(idTexto);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(
            null,
            "El ID debe ser un número."
    );
}
```

También se controla cuando el usuario cancela una ventana de `JOptionPane`:

```java
if (idTexto == null) {
    return;
}
```

Esto evita que el programa continúe intentando procesar un dato que no fue introducido.

---

## 🧠 Conceptos aplicados

Durante el desarrollo del proyecto se trabajaron diferentes conceptos de programación orientada a objetos y organización de software:

* Clases y objetos
* Encapsulamiento
* Constructores
* Métodos
* Parámetros
* Enumeraciones (`enum`)
* Colecciones
* Interfaces
* Repositorios
* Separación de responsabilidades
* Manejo de excepciones
* Inyección de dependencias mediante constructores
* Arquitectura por capas
* Control de versiones con Git

---

## 🚀 Flujo general

El funcionamiento principal del sistema puede resumirse así:

```text
Usuario
   ↓
MenuPrincipal
   ↓
Caso de uso
   ↓
Entidad de dominio
   ↓
Repository
   ↓
Almacenamiento
```

Por ejemplo, para crear una tarea:

```text
Usuario introduce los datos
          ↓
MenuPrincipal
          ↓
CrearTarea.ejecutar()
          ↓
new Tarea(...)
          ↓
TareaRepository.guardar()
```

---

## ▶️ Ejecución

Para ejecutar el proyecto se debe iniciar la clase principal que construye las dependencias y posteriormente iniciar el menú.

Una vez iniciado, aparecerá el menú:

```text
GESTOR DE TAREAS

1. Crear usuario
2. Crear tarea
3. Asignar tarea
4. Cambiar estado
5. Ver todas las tareas
6. Ver tareas por prioridad
7. Ver tareas por estado
8. Salir
```

El usuario puede seleccionar una opción y seguir las instrucciones mostradas por `JOptionPane`.

---

## 📚 Objetivo del proyecto

El objetivo principal es desarrollar una aplicación sencilla de gestión de tareas aplicando conceptos de **Java, programación orientada a objetos, separación de responsabilidades y control de versiones**.

El proyecto también sirve como práctica para comprender cómo dividir una aplicación en diferentes partes, evitando colocar toda la lógica dentro de una única clase.

---

## 👨‍💻 Autor

**Santiago Villamizar Mantilla**

Proyecto desarrollado como práctica de programación en Java.
