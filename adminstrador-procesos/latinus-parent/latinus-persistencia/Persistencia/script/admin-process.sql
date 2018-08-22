DROP TABLE IF EXISTS "solicitud";
DROP TABLE IF EXISTS "evento";
DROP TABLE IF EXISTS "log";
DROP TABLE IF EXISTS "grilla";
DROP TABLE IF EXISTS "formulario";
DROP TABLE IF EXISTS "variable";
DROP TABLE IF EXISTS "tipo_evento";
DROP TABLE IF EXISTS "usuario";
DROP TABLE IF EXISTS "secuencia";
DROP TABLE IF EXISTS "proceso";
DROP TABLE IF EXISTS "catalogo";

-- ----------------------------
-- Tables
-- ----------------------------
CREATE TABLE "proceso" (
"id_proceso" bigserial Primary Key,
"nombre" varchar(250) COLLATE "default",
"descripcion" varchar(250) COLLATE "default"
);

INSERT INTO public.proceso(nombre, descripcion)
    VALUES ('Certificado de ciudadanía', 'El documento valida la nacionalidad del individuo');

INSERT INTO public.proceso(nombre, descripcion)
    VALUES ('Certificado bancario', 'El documento valida la cuenta activa de un banco');
    	
CREATE TABLE "variable" (
"id_variable" bigserial Primary Key,
"id_proceso" int8,
"numero_tramite" int8,
"nombre" varchar(250) COLLATE "default",
"valor" int4,
CONSTRAINT variable_id_proceso_fkey FOREIGN KEY (id_proceso)
      REFERENCES public.proceso (id_proceso) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE "catalogo" (
"id_catalogo" bigserial Primary Key,
"nombre" varchar(500) COLLATE "default",
"descripcion" varchar(500) COLLATE "default",
"nemonico" varchar(100) COLLATE "default",
"catalogo_padre" int8,
CONSTRAINT catalogo_padre_fkey FOREIGN KEY (catalogo_padre)
      REFERENCES public.catalogo (id_catalogo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);

INSERT INTO public.catalogo(nombre, descripcion, nemonico, catalogo_padre)
VALUES('Estado Formulario', 'Indican el estado del formulario', 'ESTFOR', NULL);

INSERT INTO public.catalogo(nombre, descripcion, nemonico, catalogo_padre)
VALUES('Creado', 'Creado', 'CRE', 1);

INSERT INTO public.catalogo(nombre, descripcion, nemonico, catalogo_padre)
VALUES('Tramite', 'Tramite', 'TRA', 1);
    
INSERT INTO public.catalogo(nombre, descripcion, nemonico, catalogo_padre)
VALUES('Finalizado', 'Finalizado', 'FIN', 1);

INSERT INTO public.catalogo(nombre, descripcion, nemonico, catalogo_padre)
VALUES('Estado Solicitud', 'Indican el estado del formulario', 'ESTSOL', NULL);

INSERT INTO public.catalogo(nombre, descripcion, nemonico, catalogo_padre)
VALUES('Activo', 'Activo', 'SOLACT', 5);

INSERT INTO public.catalogo(nombre, descripcion, nemonico, catalogo_padre)
VALUES('Pendiente', 'Pendiente', 'SOLPEN', 5);

INSERT INTO public.catalogo(nombre, descripcion, nemonico, catalogo_padre)
VALUES('Atendido', 'Atendido', 'SOLATE', 5);

CREATE TABLE "formulario" (
"id_formulario" bigserial Primary Key,
"id_proceso" int8,
"nombre" varchar(250) COLLATE "default",
"descripcion" varchar(500) COLLATE "default",
"estado_solicitud" int8,
CONSTRAINT id_proceso_fkey FOREIGN KEY (id_proceso)
      REFERENCES public.proceso (id_proceso) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
CONSTRAINT estado_solicitud_fkey FOREIGN KEY (estado_solicitud)
      REFERENCES public.catalogo (id_catalogo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);

INSERT INTO public.formulario(id_proceso, nombre, descripcion, estado_solicitud)
    VALUES (1, 'A', 'Solicitud', 2);

INSERT INTO public.formulario(id_proceso, nombre, descripcion, estado_solicitud)
    VALUES (1, 'B', 'Entrega de documentos', 3);

INSERT INTO public.formulario(id_proceso, nombre, descripcion, estado_solicitud)
    VALUES (1, 'C', 'Validacion de documentos', 3);

INSERT INTO public.formulario(id_proceso, nombre, descripcion, estado_solicitud)
    VALUES (1, 'D', 'Pago del trámite', 3);

INSERT INTO public.formulario(id_proceso, nombre, descripcion, estado_solicitud)
    VALUES (1, 'E', 'Entrega de la certificación ', 3);

INSERT INTO public.formulario(id_proceso, nombre, descripcion, estado_solicitud)
    VALUES (1, 'F', 'Notificacion', 4);

INSERT INTO public.formulario(id_proceso, nombre, descripcion, estado_solicitud)
    VALUES (2, 'A', 'Solicitud', 2);

INSERT INTO public.formulario(id_proceso, nombre, descripcion, estado_solicitud)
    VALUES (2, 'B', 'Entrega de documentos', 3);

INSERT INTO public.formulario(id_proceso, nombre, descripcion, estado_solicitud)
    VALUES (2, 'C', 'Validacion de documentos', 3);

INSERT INTO public.formulario(id_proceso, nombre, descripcion, estado_solicitud)
    VALUES (2, 'D', 'Pago del trámite', 3);

INSERT INTO public.formulario(id_proceso, nombre, descripcion, estado_solicitud)
    VALUES (2, 'E', 'Entrega de la certificación', 3);

INSERT INTO public.formulario(id_proceso, nombre, descripcion, estado_solicitud)
    VALUES (2, 'F', 'Notificacion', 4);
                                    
CREATE TABLE "usuario" (
"id_usuario" bigserial Primary Key,
"identificacion" varchar(13) COLLATE "default",
"apellido" varchar(250) COLLATE "default",
"nombre" varchar(250) COLLATE "default"
);

INSERT INTO public.usuario(identificacion, apellido, nombre)
    VALUES ('1721889515', 'Pedro', 'Muñoz');
    
INSERT INTO public.usuario(identificacion, apellido, nombre)
    VALUES ('1721889517', 'Juan', 'Salazar');

INSERT INTO public.usuario(identificacion, apellido, nombre)
    VALUES ('1765489873', 'Esteban', 'Flores');
    
CREATE TABLE "log" (
"id_log" bigserial Primary Key,
"id_usuario" int8,
"datos_grilla" varchar(2000) COLLATE "default",
"datos_variables" varchar(2000) COLLATE "default",
"fecha_atencion" timestamptz(6),
CONSTRAINT id_usuario_fkey FOREIGN KEY (id_usuario)
      REFERENCES public.usuario (id_usuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE "tipo_evento" (
"id_tipo_evento" bigserial Primary Key,
"nemonico" varchar(250) COLLATE "default",
"descripcion" varchar(500) COLLATE "default"
);

INSERT INTO public.tipo_evento(nemonico, descripcion)
    VALUES ('LOG', 'Registra un evento en el sistema ');

INSERT INTO public.tipo_evento(nemonico, descripcion)
    VALUES ('MEN', 'Envía una notificación de correo electrónico a uno o varios ');
    
CREATE TABLE "grilla" (
"id_grilla" bigserial Primary Key,
"id_proceso" int8,
"estado_actual" int8,
"estado_anterior" int8,
"funcion_transferencia" varchar(500) COLLATE "default",
"estado_siguiente" int8,
CONSTRAINT id_proces_fkey FOREIGN KEY (id_proceso)
      REFERENCES public.proceso (id_proceso) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
CONSTRAINT estado_actual_fkey FOREIGN KEY (estado_actual)
      REFERENCES public.formulario (id_formulario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
CONSTRAINT estado_anterior_fkey FOREIGN KEY (estado_anterior)
      REFERENCES public.formulario (id_formulario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
CONSTRAINT estado_siguiente_fkey FOREIGN KEY (estado_siguiente)
      REFERENCES public.formulario (id_formulario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);

INSERT INTO public.grilla(estado_actual, funcion_transferencia, 
            estado_siguiente, id_proceso)
    VALUES (1, '(Sin condicion)', 
            2, 1);

INSERT INTO public.grilla(estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente, id_proceso)
    VALUES (2, 1, '(Sin condicion)', 
            3, 1);

INSERT INTO public.grilla(estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente, id_proceso)
    VALUES (3, 2, 'a>30', 
            4, 1);

INSERT INTO public.grilla(estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente, id_proceso)
    VALUES (3, 2, 'a<31', 
            5, 1);

INSERT INTO public.grilla(estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente, id_proceso)
    VALUES (5, 3, '(Sin condicion)', 
            6, 1);

INSERT INTO public.grilla(estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente, id_proceso)
    VALUES (4, 3, '(Sin condicion)', 
            6, 1);

INSERT INTO public.grilla(estado_actual, funcion_transferencia, 
            estado_siguiente, id_proceso)
    VALUES (7, '(Sin condicion)', 
            8, 2);

INSERT INTO public.grilla(estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente, id_proceso)
    VALUES (8, 7, '(Sin condicion)', 
            9, 2);

INSERT INTO public.grilla(estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente, id_proceso)
    VALUES (9, 8, '(Paralelo)', 
            10, 2);

INSERT INTO public.grilla(estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente, id_proceso)
    VALUES (9, 8, '(Paralelo)', 
            11, 2);

INSERT INTO public.grilla(estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente, id_proceso)
    VALUES (10, 8, '(Sin condicion)', 
            12, 2);

INSERT INTO public.grilla(estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente, id_proceso)
    VALUES (11, 8, '(Sin condicion)', 
            12, 2);
                                               
CREATE TABLE "evento" (
"id_evento" bigserial Primary Key,
"id_tipo" int8,
"id_grilla" int8,
CONSTRAINT id_tipo_fkey FOREIGN KEY (id_tipo)
      REFERENCES public.tipo_evento (id_tipo_evento) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
CONSTRAINT id_grilla_fkey FOREIGN KEY (id_grilla)
      REFERENCES public.grilla (id_grilla) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);

INSERT INTO public.evento(id_tipo, id_grilla)
    VALUES (1, 1);

INSERT INTO public.evento(id_tipo, id_grilla)
    VALUES (2, 1);

CREATE TABLE "secuencia" (
"id_secuencia" bigserial Primary Key,
"id_proceso" int8,
"valor" int8,
CONSTRAINT id_proceso_fkey FOREIGN KEY (id_proceso)
      REFERENCES public.proceso (id_proceso) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);

INSERT INTO public.secuencia(id_proceso, valor)
    VALUES (1, 1);

INSERT INTO public.secuencia(id_proceso, valor)
    VALUES (2, 1);

CREATE TABLE "solicitud" (
"id_solicitud" bigserial Primary Key,
"id_proceso" int8,
"numero_tramite" int8,
"id_formulario" int8,
"estado_solicitud" int8,
"usuario_creacion" int8,
"usuario_modificacion" int8,
CONSTRAINT id_proceso_fkey FOREIGN KEY (id_proceso)
      REFERENCES public.proceso (id_proceso) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
CONSTRAINT id_formulario_fkey FOREIGN KEY (id_formulario)
      REFERENCES public.formulario (id_formulario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
CONSTRAINT usuario_creacion_fkey FOREIGN KEY (usuario_creacion)
      REFERENCES public.usuario (id_usuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
CONSTRAINT usuario_modificacion_fkey FOREIGN KEY (usuario_modificacion)
      REFERENCES public.usuario (id_usuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE,
CONSTRAINT estado_solicitud_fkey FOREIGN KEY (estado_solicitud)
      REFERENCES public.catalogo (id_catalogo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);
              
ALTER SEQUENCE "evento_id_evento_seq" OWNED BY "evento"."id_evento";
ALTER SEQUENCE "formulario_id_formulario_seq" OWNED BY "formulario"."id_formulario";
ALTER SEQUENCE "grilla_id_grilla_seq" OWNED BY "grilla"."id_grilla";
ALTER SEQUENCE "log_id_log_seq" OWNED BY "log"."id_log";
ALTER SEQUENCE "proceso_id_proceso_seq" OWNED BY "proceso"."id_proceso";
ALTER SEQUENCE "tipo_evento_id_tipo_evento_seq" OWNED BY "tipo_evento"."id_tipo_evento";
ALTER SEQUENCE "usuario_id_usuario_seq" OWNED BY "usuario"."id_usuario";
ALTER SEQUENCE "variable_id_variable_seq" OWNED BY "variable"."id_variable";