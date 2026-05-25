# Simulador Social TEA

Proyecto de Programacion Orientada a Objetos desarrollado en Java con NetBeans.

## Descripcion

Aplicacion de escritorio para practicar situaciones sociales cotidianas mediante escenarios guiados, opciones de respuesta, retroalimentacion y seguimiento del progreso.

El proyecto esta dirigido a personas con autismo como herramienta educativa de practica. No reemplaza acompanamiento profesional, diagnostico ni terapia.

## Tecnologias

- Java
- Java Swing
- Maven
- MySQL
- JUnit 4
- NetBeans

## Estructura

- `Modelo`: clases principales del dominio.
- `Vista`: interfaces graficas Swing.
- `Controlador`: logica que conecta vistas, modelo y persistencia.
- `Persistencia`: conexion a MySQL y clases DAO.
- `Util`: validaciones y exportacion de reportes.
- `docs`: documentacion, UML y script SQL.

## Funcionalidades

- Registro o ingreso de usuario.
- Seleccion de categoria social: Escolar, Familiar o Publica.
- Seleccion de situaciones sociales.
- Evaluacion de respuestas.
- Retroalimentacion inmediata.
- Puntaje, nivel y situaciones completadas.
- Persistencia en MySQL.
- Exportacion de reporte `.txt`.
- Pruebas unitarias con JUnit.

## Conceptos de POO aplicados

- Encapsulamiento.
- Sobrecarga de constructores.
- Clase abstracta.
- Interfaz.
- Herencia.
- Sobrescritura.
- Polimorfismo.
- Composicion.

## Base de datos

La base de datos se llama `simulador_social`.

Tablas principales:

- `usuarios`
- `situaciones`
- `opciones_respuesta`
- `progreso`

El script se encuentra en:

```text
docs/SCRIPT_BD.sql
```

## Pruebas

Pruebas unitarias creadas:

- `UsuarioTest`
- `SituacionEscolarTest`
- `ProgresoTest`

Resultado verificado:

```text
Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
```

## Ejecucion

1. Iniciar MySQL desde XAMPP.
2. Crear la base de datos con `docs/SCRIPT_BD.sql`.
3. Abrir el proyecto en NetBeans.
4. Ejecutar `Vista.InicioFrame`.

