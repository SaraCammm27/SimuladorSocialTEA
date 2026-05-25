CREATE DATABASE IF NOT EXISTS simulador_social;
USE simulador_social;

CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    edad INT DEFAULT 0,
    puntaje_total INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS situaciones (
    id_situacion INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    descripcion TEXT NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    detalle VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS opciones_respuesta (
    id_opcion INT AUTO_INCREMENT PRIMARY KEY,
    id_situacion INT NOT NULL,
    texto TEXT NOT NULL,
    adecuada BOOLEAN NOT NULL,
    retroalimentacion TEXT NOT NULL,
    puntos INT DEFAULT 0,
    FOREIGN KEY (id_situacion) REFERENCES situaciones(id_situacion)
);

CREATE TABLE IF NOT EXISTS progreso (
    id_progreso INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    situaciones_completadas INT DEFAULT 0,
    puntaje_acumulado INT DEFAULT 0,
    nivel VARCHAR(50) DEFAULT 'Inicial',
    fecha_actualizacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Datos base. Ejecutar solo si las tablas situaciones y opciones_respuesta estan vacias.
INSERT INTO situaciones (titulo, descripcion, categoria, detalle)
VALUES
('Pedir ayuda al profesor', 'Estas en clase y no entendiste una instruccion del profesor.', 'Escolar', 'Matematicas'),
('Trabajo en grupo', 'Tus companeros quieren repartir las tareas, pero no sabes cual escoger.', 'Escolar', 'Sociales'),
('Cambio de actividad en clase', 'El profesor cambia la actividad que estaba planeada y ahora deben hacer algo diferente.', 'Escolar', 'Clase general'),
('Recreo con companeros', 'Estas en el recreo y quieres acercarte a un grupo de companeros que estan jugando.', 'Escolar', 'Recreo'),
('Exposicion frente al curso', 'Debes pasar al frente del salon para explicar una parte de un trabajo.', 'Escolar', 'Exposicion'),
('Ruido en casa', 'Estas haciendo una tarea y un familiar esta haciendo mucho ruido.', 'Familiar', 'mama'),
('Pedir un espacio tranquilo', 'Hay mucho ruido en casa y necesitas estar en un lugar mas tranquilo por unos minutos.', 'Familiar', 'familia'),
('Compartir un objeto personal', 'Un familiar quiere usar un objeto que es importante para ti.', 'Familiar', 'hermano'),
('Cambio en la rutina familiar', 'Tu familia cambia la hora de una actividad que normalmente haces todos los dias.', 'Familiar', 'familia'),
('Expresar una emocion', 'Te sientes frustrado porque algo no salio como esperabas en casa.', 'Familiar', 'papa'),
('Comprar en una tienda', 'Quieres comprar una botella de agua, pero no sabes donde esta.', 'Publica', 'tienda'),
('Pedir indicaciones en la calle', 'Estas en un lugar publico y no sabes hacia donde queda la entrada principal.', 'Publica', 'calle'),
('Esperar turno en una fila', 'Estas haciendo fila para pagar y la espera esta tomando mas tiempo de lo esperado.', 'Publica', 'supermercado'),
('Ruido en un lugar publico', 'Estas en un centro comercial y hay mucho ruido alrededor.', 'Publica', 'centro comercial'),
('Usar transporte publico', 'Necesitas subir a un bus y preguntarle al conductor si pasa por tu destino.', 'Publica', 'bus');

INSERT INTO opciones_respuesta (id_situacion, texto, adecuada, retroalimentacion, puntos)
VALUES
(1, 'Me quedo callado aunque no entienda.', false, 'Esta respuesta no es la mas adecuada, porque no permite resolver la duda.', 0),
(1, 'Levanto la mano y digo: profesor, puede repetir la instruccion, por favor?', true, 'Muy bien. Pedir ayuda de forma respetuosa permite entender mejor la actividad.', 10),
(1, 'Me enojo y salgo del salon.', false, 'Esta respuesta puede generar mas dificultades. Es mejor expresar la duda con calma.', 0),
(2, 'Escucho las opciones y digo cual tarea puedo hacer.', true, 'Muy bien. Participar y expresar lo que puedes hacer ayuda al trabajo en equipo.', 10),
(2, 'No digo nada y dejo que todos decidan por mi.', false, 'Es mejor intentar comunicar tus preferencias para participar en el grupo.', 0),
(2, 'Me molesto y digo que no quiero trabajar con nadie.', false, 'Esa respuesta puede afectar la convivencia. Es mejor pedir una tarea clara o ayuda.', 0),
(3, 'Me enojo porque cambiaron lo que esperaba hacer.', false, 'Es comprensible sentirse incomodo con los cambios, pero es mejor intentar pedir una explicacion o apoyo.', 0),
(3, 'Pregunto con calma que debo hacer ahora.', true, 'Muy bien. Pedir una explicacion ayuda a entender mejor el cambio de actividad.', 10),
(3, 'No hago nada y espero sin preguntar.', false, 'Esperar puede funcionar a veces, pero si no entiendes el cambio es mejor preguntar.', 5),
(4, 'Me acerco y pregunto si puedo jugar con ellos.', true, 'Muy bien. Pedir participar de forma respetuosa facilita la interaccion con companeros.', 10),
(4, 'Empujo a alguien para entrar al juego.', false, 'Esa accion puede incomodar a los demas. Es mejor pedir permiso antes de entrar al juego.', 0),
(4, 'Me quedo mirando sin decir nada aunque quiera jugar.', false, 'Observar puede ayudar, pero si deseas participar es util comunicarlo con una frase sencilla.', 5),
(5, 'Respiro profundo y explico mi parte con calma.', true, 'Muy bien. Respirar y hablar paso a paso puede ayudar durante una exposicion.', 10),
(5, 'Salgo del salon sin avisar.', false, 'Salir sin avisar puede generar confusion. Es mejor pedir apoyo al profesor si te sientes nervioso.', 0),
(5, 'Digo que no puedo hacerlo y me quedo en silencio.', false, 'Si te sientes nervioso, puedes pedir ayuda o empezar con una frase corta.', 5),
(6, 'Grito para que deje de hacer ruido.', false, 'Gritar puede generar una discusion. Es mejor expresar la molestia con calma.', 0),
(6, 'Le digo con calma: el ruido me esta molestando, puedes bajar el volumen?', true, 'Muy bien. Expresar la necesidad con calma ayuda a que la otra persona entienda.', 10),
(6, 'Me voy sin decir nada y me quedo molesto.', false, 'Alejarse puede ayudar a calmarse, pero tambien es importante comunicar lo que ocurre.', 5),
(7, 'Digo con calma que necesito estar en un lugar tranquilo unos minutos.', true, 'Muy bien. Expresar la necesidad de un espacio tranquilo ayuda a regularse.', 10),
(7, 'Grito para que todos hagan silencio.', false, 'Gritar puede aumentar el conflicto. Es mejor pedir el espacio con calma.', 0),
(7, 'Me escondo sin avisar a nadie.', false, 'Buscar tranquilidad puede ayudar, pero es importante avisar a una persona de confianza.', 5),
(8, 'Pregunto si puede usarlo despues o por un tiempo limitado.', true, 'Muy bien. Negociar permite cuidar tus objetos y mantener una buena comunicacion.', 10),
(8, 'Le quito el objeto de las manos sin hablar.', false, 'Quitar el objeto puede generar una discusion. Es mejor explicar como te sientes.', 0),
(8, 'Me quedo molesto sin decir nada.', false, 'Guardar la molestia puede hacerte sentir peor. Es mejor expresar tu incomodidad con calma.', 5),
(9, 'Pregunto cual sera el nuevo horario y que debo hacer.', true, 'Muy bien. Preguntar ayuda a anticipar el cambio y entender la nueva rutina.', 10),
(9, 'Me niego a hacer cualquier actividad.', false, 'Los cambios pueden ser dificiles, pero pedir informacion puede ayudar a manejarlos mejor.', 0),
(9, 'Me quedo confundido sin preguntar.', false, 'Si algo cambia y no lo entiendes, puedes pedir que te expliquen paso a paso.', 5),
(10, 'Digo: me siento frustrado y necesito un momento para calmarme.', true, 'Muy bien. Nombrar la emocion y pedir tiempo ayuda a manejar la situacion.', 10),
(10, 'Golpeo la mesa porque estoy frustrado.', false, 'Golpear objetos puede causar problemas. Es mejor expresar la emocion con palabras.', 0),
(10, 'Finjo que no pasa nada aunque sigo molesto.', false, 'Ignorar la emocion no siempre ayuda. Reconocer lo que sientes puede ser el primer paso para calmarte.', 5),
(11, 'Busco a un trabajador y pregunto: disculpe, donde encuentro agua?', true, 'Muy bien. Pedir informacion de forma clara y respetuosa facilita la compra.', 10),
(11, 'Me quedo caminando sin preguntar aunque no encuentre nada.', false, 'Puedes intentar buscar, pero si no encuentras el producto es valido pedir ayuda.', 0),
(11, 'Tomo cualquier producto sin revisar si es lo que necesito.', false, 'Es importante revisar antes de comprar y pedir ayuda si tienes dudas.', 0),
(12, 'Busco a una persona encargada y pregunto por la entrada principal.', true, 'Muy bien. Pedir indicaciones de forma clara puede ayudarte a orientarte.', 10),
(12, 'Camino sin rumbo aunque este perdido.', false, 'Caminar sin orientacion puede confundirte mas. Es mejor pedir ayuda a alguien confiable.', 0),
(12, 'Me enojo y dejo de intentar encontrar el lugar.', false, 'Sentirse perdido puede ser frustrante, pero pedir indicaciones puede resolver la situacion.', 0),
(13, 'Espero mi turno y, si me siento incomodo, respiro o pido apoyo.', true, 'Muy bien. Esperar turnos es una norma social importante y puedes usar estrategias para calmarte.', 10),
(13, 'Me paso adelante porque no quiero esperar.', false, 'Pasarse en la fila puede generar conflicto. Es importante respetar el turno.', 0),
(13, 'Abandono la fila sin decir nada aunque necesito pagar.', false, 'Si necesitas salir de la fila, puedes avisar o pedir ayuda si estas acompanado.', 5),
(14, 'Busco un lugar menos ruidoso o le digo a mi acompanante que necesito alejarme.', true, 'Muy bien. Identificar el ruido y buscar una estrategia ayuda a regularte.', 10),
(14, 'Grito para que todos se callen.', false, 'Gritar puede aumentar el ruido y el malestar. Es mejor buscar un lugar mas tranquilo.', 0),
(14, 'Me quedo ahi aunque el ruido me moleste mucho.', false, 'Si el ruido te afecta, es valido buscar apoyo o un espacio mas calmado.', 5),
(15, 'Pregunto al conductor: este bus pasa por mi destino?', true, 'Muy bien. Preguntar antes de subir ayuda a evitar confusiones.', 10),
(15, 'Subo sin preguntar aunque no este seguro.', false, 'Si no estas seguro, es mejor preguntar antes de subir al transporte.', 0),
(15, 'Me alejo y no intento preguntar.', false, 'Puede dar nervios preguntar, pero una frase corta puede ayudarte a resolver la duda.', 5);
