# Guia de entrega - Simulador Social TEA

## Nombre del proyecto

Simulador de Situaciones Sociales para Personas con Autismo.

## Problema

Algunas personas con autismo pueden necesitar apoyo para practicar situaciones sociales cotidianas, como pedir ayuda, expresar una emocion, esperar turno o interactuar en espacios publicos. El proyecto propone una herramienta educativa que presenta escenarios guiados, opciones de respuesta y retroalimentacion clara.

El sistema no reemplaza una terapia ni un diagnostico profesional. Es una herramienta de practica y orientacion.

## Objetivo general

Desarrollar una aplicacion de escritorio en Java que permita practicar situaciones sociales mediante escenarios interactivos, evaluacion de respuestas y seguimiento del progreso del usuario.

## Objetivos especificos

- Representar usuarios, situaciones, opciones y progreso mediante clases orientadas a objetos.
- Aplicar herencia, abstraccion, interfaz, sobrescritura y polimorfismo.
- Guardar usuarios, situaciones, opciones y progreso en MySQL.
- Permitir exportar el progreso del usuario a un archivo de texto.
- Ofrecer una interfaz grafica en Java Swing con validaciones y mensajes claros.
- Verificar la logica principal con pruebas unitarias en JUnit.

## Funcionalidades

- Ingreso de usuario por nombre y edad.
- Menu principal con acceso a simulacion, progreso y exportacion de reporte.
- Seleccion de categoria: Escolar, Familiar o Publica.
- Seleccion de situacion y respuesta.
- Retroalimentacion inmediata segun la respuesta.
- Actualizacion de puntaje, situaciones completadas y nivel.
- Persistencia en MySQL.
- Exportacion de reporte `.txt`.

## Arquitectura

El proyecto usa una estructura MVC:

- `Modelo`: clases principales del dominio, como `Usuario`, `SituacionSocial`, `OpcionRespuesta` y `Progreso`.
- `Vista`: ventanas Swing, como `InicioFrame`, `MenuPrincipalFrame`, `SimuladorFrame` y `ProgresoFrame`.
- `Controlador`: conecta la vista con el modelo y la persistencia.
- `Persistencia`: conexion con MySQL y clases DAO.
- `Util`: validaciones y exportacion de reportes.

## Conceptos de POO usados

- Encapsulamiento: atributos privados con metodos `get` y `set`.
- Sobrecarga: varios constructores en clases como `Usuario`, `OpcionRespuesta`, `SituacionSocial` y `Progreso`.
- Clase abstracta: `SituacionSocial`.
- Interfaz: `Evaluable`.
- Herencia: `SituacionEscolar`, `SituacionFamiliar` y `SituacionPublica` heredan de `SituacionSocial`.
- Sobrescritura: cada clase hija implementa `obtenerConsejo()`.
- Polimorfismo: el controlador maneja diferentes tipos de situaciones como objetos `SituacionSocial`.
- Composicion: una situacion contiene varias opciones de respuesta.

## Base de datos

La base de datos se llama `simulador_social` y tiene estas tablas:

- `usuarios`: datos del usuario.
- `situaciones`: escenarios sociales.
- `opciones_respuesta`: respuestas asociadas a cada situacion.
- `progreso`: avance del usuario.

Relaciones:

- Una situacion tiene muchas opciones de respuesta.
- Un usuario tiene un registro de progreso.

## Pruebas unitarias

Se crearon pruebas con JUnit 4:

- `UsuarioTest`: valida suma de puntos y edad registrada.
- `SituacionEscolarTest`: valida evaluacion de respuestas correctas, incorrectas y nulas.
- `ProgresoTest`: valida registro de resultados, puntaje, promedio y niveles.

Resultado verificado:

```text
Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
```

## Como ejecutar

1. Abrir XAMPP.
2. Iniciar MySQL.
3. Verificar que exista la base `simulador_social`.
4. Abrir el proyecto en NetBeans.
5. Ejecutar `Vista.InicioFrame`.
6. Ingresar nombre y edad.
7. Usar el menu para iniciar simulacion, ver progreso o exportar reporte.

## Como sustentar en pocas palabras

El sistema usa POO para representar situaciones sociales como objetos. La clase abstracta `SituacionSocial` define los atributos y comportamientos comunes, mientras que las clases hijas representan contextos especificos: escolar, familiar y publico. La interfaz `Evaluable` obliga a que toda situacion pueda evaluar una respuesta. El controlador coordina la logica, la vista muestra la interfaz Swing y la capa de persistencia guarda la informacion en MySQL. Ademas, el progreso puede exportarse a un archivo de texto.

