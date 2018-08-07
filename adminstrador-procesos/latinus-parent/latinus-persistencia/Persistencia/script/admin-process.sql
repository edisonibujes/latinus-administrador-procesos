DROP TABLE IF EXISTS "evento";
DROP TABLE IF EXISTS "log";
DROP TABLE IF EXISTS "grilla";
DROP TABLE IF EXISTS "formulario";
DROP TABLE IF EXISTS "variable";
DROP TABLE IF EXISTS "tipo_evento";
DROP TABLE IF EXISTS "proceso";
DROP TABLE IF EXISTS "usuario";

-- ----------------------------
-- Tables
-- ----------------------------
CREATE TABLE "proceso" (
"id_proceso" bigserial Primary Key,
"nombre" varchar(250) COLLATE "default",
"descripcion" varchar(250) COLLATE "default"
);

INSERT INTO public.proceso(
            id_proceso, nombre, descripcion)
    VALUES (1, 'Certificado de ciudadanía', 'El documento valida la nacionalidad del individuo');
	
CREATE TABLE "variable" (
"id_variable" bigserial Primary Key,
"id_proceso" int8,
"nombre" varchar(250) COLLATE "default",
"valor" int4,
CONSTRAINT variable_id_proceso_fkey FOREIGN KEY (id_proceso)
      REFERENCES public.proceso (id_proceso) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);

INSERT INTO public.variable(
            id_variable, id_proceso, nombre, valor)
    VALUES (1, 1, 'a', '15');


CREATE TABLE "formulario" (
"id_formulario" bigserial Primary Key,
"id_proceso" int8,
"nombre" varchar(250) COLLATE "default",
"descripcion" varchar(500) COLLATE "default",
CONSTRAINT id_proceso_fkey FOREIGN KEY (id_proceso)
      REFERENCES public.proceso (id_proceso) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE
);

INSERT INTO public.formulario(
            id_formulario, id_proceso, nombre, descripcion)
    VALUES (1, 1, 'A', 'Solicitud');

INSERT INTO public.formulario(
            id_formulario, id_proceso, nombre, descripcion)
    VALUES (2, 1, 'B', 'Entrega de documentos');

INSERT INTO public.formulario(
            id_formulario, id_proceso, nombre, descripcion)
    VALUES (3, 1, 'C', 'Validacion de documentos');

INSERT INTO public.formulario(
            id_formulario, id_proceso, nombre, descripcion)
    VALUES (4, 1, 'D', 'Pago del trámite');

INSERT INTO public.formulario(
            id_formulario, id_proceso, nombre, descripcion)
    VALUES (5, 1, 'E', 'Entrega de la certificación ');

INSERT INTO public.formulario(
            id_formulario, id_proceso, nombre, descripcion)
    VALUES (6, 1, 'F', 'Notificacion');
            
CREATE TABLE "usuario" (
"id_usuario" bigserial Primary Key,
"identificacion" varchar(13) COLLATE "default",
"apellido" varchar(250) COLLATE "default",
"nombre" varchar(250) COLLATE "default"
);

INSERT INTO public.usuario(
            id_usuario, identificacion, apellido, nombre)
    VALUES (1, '1721889515', 'Pedro', 'Muñoz');
    
INSERT INTO public.usuario(
            id_usuario, identificacion, apellido, nombre)
    VALUES (2, '1721889517', 'Juan', 'Salazar');

INSERT INTO public.usuario(
            id_usuario, identificacion, apellido, nombre)
    VALUES (3, '1765489873', 'Esteban', 'Flores');
    
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

INSERT INTO public.tipo_evento(
            id_tipo_evento, nemonico, descripcion)
    VALUES (1, 'LOG', 'Registra un evento en el sistema ');

INSERT INTO public.tipo_evento(
            id_tipo_evento, nemonico, descripcion)
    VALUES (2, 'MEN', 'Envía una notificación de correo electrónico a uno o varios ');
    
CREATE TABLE "grilla" (
"id_grilla" bigserial Primary Key,
"estado_actual" int8,
"estado_anterior" int8,
"funcion_transferencia" varchar(500) COLLATE "default",
"estado_siguiente" int8,
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

INSERT INTO public.grilla(
            id_grilla, estado_actual, funcion_transferencia, 
            estado_siguiente)
    VALUES (1, 1, '(Sin condicion)', 
            2);

INSERT INTO public.grilla(
            id_grilla, estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente)
    VALUES (2, 2, 1, '(Sin condicion)', 
            3);

INSERT INTO public.grilla(
            id_grilla, estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente)
    VALUES (3, 3, 2, 'a>30', 
            4);

INSERT INTO public.grilla(
            id_grilla, estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente)
    VALUES (4, 3, 2, 'a<31', 
            5);

INSERT INTO public.grilla(
            id_grilla, estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente)
    VALUES (5, 5, 3, '(Sin condicion)', 
            6);

INSERT INTO public.grilla(
            id_grilla, estado_actual, estado_anterior, funcion_transferencia, 
            estado_siguiente)
    VALUES (6, 4, 3, '(Sin condicion)', 
            6);
                                               
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

INSERT INTO public.evento(
            id_evento, id_tipo, id_grilla)
    VALUES (1, 1, 1);

INSERT INTO public.evento(
            id_evento, id_tipo, id_grilla)
    VALUES (2, 2, 1);

ALTER SEQUENCE "evento_id_evento_seq" OWNED BY "evento"."id_evento";
ALTER SEQUENCE "formulario_id_formulario_seq" OWNED BY "formulario"."id_formulario";
ALTER SEQUENCE "grilla_id_grilla_seq" OWNED BY "grilla"."id_grilla";
ALTER SEQUENCE "log_id_log_seq" OWNED BY "log"."id_log";
ALTER SEQUENCE "proceso_id_proceso_seq" OWNED BY "proceso"."id_proceso";
ALTER SEQUENCE "tipo_evento_id_tipo_evento_seq" OWNED BY "tipo_evento"."id_tipo_evento";
ALTER SEQUENCE "usuario_id_usuario_seq" OWNED BY "usuario"."id_usuario";
ALTER SEQUENCE "variable_id_variable_seq" OWNED BY "variable"."id_variable";