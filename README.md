# Módulo de Dirección Académica - Universidad de Barbosa (Java POO / MVC)

Este proyecto implementa el **Módulo de Dirección Académica** para la Universidad de Barbosa, siguiendo la arquitectura **MVC (Modelo-Vista-Controlador)** y los principios fundamentales de la **Programación Orientada a Objetos (POO)**: Abstracción, Herencia, Polimorfismo y Encapsulamiento.

## 📐 Estructura del Proyecto

```
src/
└── co/edu/barbosa/
    ├── Main.java
    └── direccionacademica/
        ├── modelo/
        │   ├── ActividadAcademica.java (Abstracta)
        │   ├── Taller.java
        │   ├── Quiz.java
        │   ├── Parcial.java
        │   ├── Proyecto.java
        │   ├── Materia.java
        │   ├── Nota.java
        │   └── IServicioAdmisiones.java (Interfaz para interacción entre componentes)
        ├── controlador/
        |   ├── AdmisionesController.java
        │   └── DireccionAcademicaController.java
        └── vista/
            └── DireccionAcademicaView.java
```

## 🚀 Cómo Compilar y Ejecutar

### Opción 1: Desde Terminal (javac / java)

1. Abrir la terminal dentro de la carpeta raíz del proyecto.
2. Compilar todos los archivos `.java`:
   ```bash
   javac -d bin src/co/edu/barbosa/Main.java src/co/edu/barbosa/direccionacademica/*/*.java
   ```
3. Ejecutar la clase principal `Main`:
   ```bash
   java -cp bin co.edu.barbosa.Main
   ```

### Opción 2: Desde un IDE (IntelliJ IDEA, Eclipse, NetBeans, VS Code)

1. Abrir/Importar la carpeta `direccion_academica_java` como proyecto Java.
2. Asegurar que la carpeta `src` está marcada como **Sources Root**.
3. Ejecutar la clase `co.edu.barbosa.Main`.

## ⚙️ Funcionalidades e Integración
- **Gestión de Materias**: Creación, edición de nombre y habilitación/deshabilitación.
- **Gestión de Notas**: Registro de calificaciones en Talleres, Quices, Parciales y Proyectos usando Polimorfismo.
- **Validación con Admisiones**: Interfaz `IServicioAdmisiones` para verificar la matrícula previa del estudiante.
- **Consulta Externa**: Exposición de materias disponibles para ser consultadas por el módulo de Admisiones.
