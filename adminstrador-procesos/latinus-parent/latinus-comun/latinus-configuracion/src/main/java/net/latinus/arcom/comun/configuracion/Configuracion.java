/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.latinus.arcom.comun.configuracion;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cristhian Herrera - Latinus
 */
public class Configuracion implements Serializable
{

    
    private static final Logger LOG = LoggerFactory.getLogger(Configuracion.class);
    Properties properties = null;
    public final static String ENDPOINT_RABC = "configuracion.endpoint.rbac";
    public final static String TEMPLATE_CORREO = "configuracion.template.correo";
    //configuracion de alfresco
    public final static String ALFRESCO_URL = "configuracion.alfresco.url";
    public final static String ALFRESCO_USER = "configuracion.alfresco.usuario";
    public final static String ALFRESCO_PASS = "configuracion.alfresco.password";
    public final static String ALFRESCO_FOLDER = "configuracion.alfresco.carpeta";
    public final static String ALFRESCO_ILEGAL_CAR = "configuracion.alfresco.ilegalCaracteres";
    public final static String ALFRESCO_CONTENT_SIZE = "configuracion.alfresco.size";
    public final static String INTALIO_HOST = "configuracion.intalio.host";
    public final static String APACHE_HOST = "configuracion.apache.host";
    public final static String ENDPOINT_CATALOGO = "configuracion.endpoint.catalogo";
    public final static String ENDPOINT_PASAPORTE = "configuracion.endpoint.pasaporte4";
    //configuracion envio de correos
    public final static String MAIL_CONTENT_TYPE = "configuracion.mail.contentType";
    public final static String MAIL_RETURN_ADDRESS = "configuracion.mail.returnAddress";
    public final static String MAIL_PROTOCOL = "configuracion.mail.transport.protocol";
    public final static String MAIL_SMTP_GMAIL = "configuracion.mail.smtp.gmail";
    public final static String MAIL_HOST = "configuracion.mail.host";
    public final static String MAIL_PORT = "configuracion.mail.smtp.port";
    public final static String MAIL_AUTH = "configuracion.mail.smtp.auth";
    public final static String MAIL_SOCKET_PORT = "configuracion.mail.smtp.socketFactory.port";
    public final static String MAIL_SOCKET_CLASS = "configuracion.mail.smtp.socketFactory.class";
    public final static String MAIL_SOCKET_FALLBACK = "configuracion.mail.smtp.socketFactory.fallback=";
    public final static String MAIL_TTLS = "configuracion.mail.smtp.starttls.enable";
    public final static String MAIL_QUITWAIT = "configuracion.mail.smtp.quitwait";
    public final static String MAIL_USERNAME = "configuracion.mail.authUsername";
    public final static String MAIL_PASSWORD = "configuracion.mail.authPassword";
    public final static String MAIL_PATH_TEMPLATE = "configuracion.mail.path.template";
        //conexion DB Intalio
    public final static String JDBC_INTALIO_URL = "configuracion.jdbc.urlIntalio";
    public final static String JDBC_INTALIO_USUARIO = "configuracion.jdbc.userIntalio";
    public final static String JDBC_INTALIO_PASSWORD = "configuracion.jdbc.passIntalio";
    public final static String JDBC_INTALIO_DRIVER = "configuracion.jdbc.driverIntalio";
    //Propiedades de servicios
    public final static String SECURITY_USER_BSG_ARCOM                          = "configuracion.ws.security.arcom.sge.usuario";
    public final static String SECURITY_USER_REGISTRO_CIVIL                     = "configuracion.ws.security.registrocivil.usuario";
    public final static String SECURITY_PASSWORD_REGISTRO_CIVIL                 = "configuracion.ws.security.registrocivil.clave";
    public final static String WS_ENDPOINT_REGISTRO_CIVIL_BUSQUEDA_POR_CEDULA   = "configuracion.ws.url.endpoint.registrocivil.buscar.por.cedula";
    public final static String WS_ENDPOINT_REGISTRO_CIVIL_BUSQUEDA_POR_NOMBRE   = "configuracion.ws.url.endpoint.registrocivil.buscar.por.nombre";        
    public final static String WS_ENDPOINT_SRI_CONSULTA_CONTRIBUYENTE           = "configuracion.ws.url.endpoint.sri.consulta.contribuyente"; 
    public final static String WS_ENDPOINT_SRI_CONSULTA_ESTABLECIMIENTOS        = "configuracion.ws.url.endpoint.sri.consulta.establecimientos"; 
    public final static String WS_ENDPOINT_SRI_CONSULTA_ESTADO_TRIBUTARIO_EXT   = "configuracion.ws.url.endpoint.sri.consulta.estado.tributario.ext"; 
    public final static String WS_ENDPOINT_SENESCYT_CONSULTA_TITULO             = "configuracion.ws.url.endpoint.senescyt.consulta.titulo"; 
    public final static String WS_ENDPOINT_SRI_CONSULTA_CONTRIBUYENTE_PRUEBA    = "configuracion.ws.url.endpoint.sri.consulta.contribuyente.prueba"; 
    
    
    //Propiedades Broker
    public final static String BROKER_URL           = "broker.url";
    public final static String BROKER_URL_LOCAL     = "broker.url.local";
    public final static String BROKER_QUEUE_NAME    = "broker.queue.name";
    public final static String BROKER_OBJECT        = "broker.object";
    public final static String BROKER_OBJECT_TYPE   = "broker.object.type";
    
    //Propiedades codigo catastro
    public final static Long LONGITUD_CODIGO_CATASTRO    = new Long("7");
    public final static String COMPLETAR_CODIGO_CATASTRO = "0";
    
     //Propiedades codigo comprobante
    public final static Long LONGITUD_CODIGO_COMPROBANTE    = new Long("8");
    public final static String COMPLETAR_CODIGO_COMPROBANTE = "0";
    public final static String PREFIJO_GENERAL_COMPROBANTE  = "A-";
    
    //Propiedades para texto de notificacion
    public final static String NOTIFICACION_COMODIN_NOMBRE          = "configuracion.notificacion.comodin.nombre";
    public final static String NOTIFICACION_COMODIN_TRAMITE         = "configuracion.notificacion.comodin.tramite";
    public final static String NOTIFICACION_COMODIN_SUBSECRETARIA   = "configuracion.notificacion.comodin.subsecretaria";
    public final static String NOTIFICACION_COMODIN_REGIONAL        = "configuracion.notificacion.comodin.regional";
    public final static String NOTIFICACION_RECEPCION_DOCUMENTOS_SI = "configuracion.notificacion.recepcion.documentos.si";
    public final static String NOTIFICACION_RECEPCION_DOCUMENTOS_NO = "configuracion.notificacion.recepcion.documentos.no";
    public final static String NOTIFICACION_COMODIN_OBSERVACION     = "configuracion.notificacion.comodin.subsanar";
    public final static String NOTIFICACION_DOCUMENTOS_SUBSANAR     = "configuracion.notificacion.documentos.subsanar";
    public final static String NOTIFICACION_DOCUMENTOS_OTORGA       = "configuracion.notificacion.documentos.otorga";
    public final static String NOTIFICACION_PLAZO_MINERIAS          = "configuracion.notificacion.plazo.solicitud.mineria";
    public final static String NOTIFICACION_PLAZO_OTORGAMIENTO      = "configuracion.notificacion.plazo.solicitud.otorgamiento.derecho.minero";
    
    public final static String ARCOM_CONFIG = "ARCOM_CONFIG";
    
    public final static String SHOW_SYSTEM_OUT = "configuracion.show.system.out";
    
    public final static String ORIGEN_PARAMETROS_URL = "configuracion.origen.parametros.url"; 
    
    
    public final static String REST_URL_MINERIAS_PRODUCCION_ZONE_17     = "rest.url.minerias.produccion.zone.17";
    public final static String REST_URL_MINERIAS_PRODUCCION_ZONE_18     = "rest.url.minerias.produccion.zone.18";
    public final static String REST_URL_MINERIA_ARTESANAL_ZONE_17       = "rest.url.mineria.artesanal.zone.17";
    public final static String REST_URL_MINERIA_ARTESANAL_ZONE_18       = "rest.url.mineria.artesanal.zone.18";
    public final static String REST_URL_LIBRE_APROVECHAMIENTO_ZONE_17   = "rest.url.libre.aprovechamiento.zone.17";
    public final static String REST_URL_LIBRE_APROVECHAMIENTO_ZONE_18   = "rest.url.libre.aprovechamiento.zone.18";
    public final static String REST_URL_ARTESANAL_PEQUENIA_ZONE_17      = "rest.url.artesanal.pequenia.zone.17";
    public final static String REST_URL_ARTESANAL_PEQUENIA_ZONE_18      = "rest.url.artesanal.pequenia.zone.18";
    
    public final static String TOKEN_NOMBRE_USUARIO     = "token.nombre.usuario";
    public final static String TOKEN_CODIGO_CATASTRO    = "token.codigo.catastro";
    public final static String TOKEN_NUMERO_SOLICITUD   = "token.numero.solicitud";
    public final static String TOKEN_NUMERO_DIAS        = "token.numero.dias";
    public final static String TOKEN_NOMBRE_CONCESION   = "token.nombre.concesion";
    public final static String TOKEN_MOTIVO             = "token.motivo";
    public final static String TOKEN_NUMERO_CATASTRO    = "token.numero.catastro";
    
    public final static String MENSAJE_ENVIO_SOLICITUD_MINERIA_SUBJECT_ARTESANAL                = "mnsj.envio.solicitud.mineria.subject.artesanal";
    public final static String MENSAJE_ENVIO_SOLICITUD_MINERIA_SUBJECT_LIBRE_APROVECHAMIENTO    = "mnsj.envio.solicitud.mineria.subject.libre.aprovechamiento";
    public final static String MENSAJE_ENVIO_SOLICITUD_MINERIA_SUBJECT_ARTESANAL_A_PEQUENIA     = "mnsj.envio.solicitud.mineria.subject.artesanal.a.pequenia";
    public final static String MENSAJE_ENVIO_SOLICITUD_MINERIA_SUBJECT_PEQUENIA_MINERIA         = "mnsj.envio.solicitud.mineria.subject.pequenia.mineria";
    
    public final static String MENSAJE_ENVIO_SOLICITUD_MINERIA_EXITO = "mnsj.envio.solicitud.mineria.exito";
    public final static String MENSAJE_ENVIO_SOLICITUD_MINERIA_ERROR = "mnsj.envio.solicitud.mineria.error";
    
    public final static String MENSAJE_ENVIO_SOLICITUD_ESTIMADO             = "mnsj.envio.solicitud.estimado";
    public final static String MENSAJE_ENVIO_SOLICITUD_TEXTO_SATISFACTORIO  = "mnsj.envio.solicitud.texto.satisfatorio";
    public final static String MENSAJE_ENVIO_SOLICITUD_TEXTO_CATASTRO       = "mnsj.envio.solicitud.texto.catastro";
    public final static String MENSAJE_ENVIO_SOLICITUD_TEXTO_ESTATUTO       = "mnsj.envio.solicitud.texto.estatuto";
    public final static String MENSAJE_ENVIO_SOLICITUD_TEXTO_SEGUIMIENTO    = "mnsj.envio.solicitud.texto.seguimiento";
    public final static String MENSAJE_ENVIO_SOLICITUD_TEXTO_ATENTAMENTE    = "mnsj.envio.solicitud.texto.atentamente";
    public final static String MENSAJE_ENVIO_SOLICITUD_TEXTO_SUBSECRETARIA  = "mnsj.envio.solicitud.texto.subsecretaria";
    public final static String MENSAJE_ENVIO_SOLICITUD_TEXTO_TELEFONO       = "mnsj.envio.solicitud.texto.telefono";
    public final static String MENSAJE_ENVIO_SOLICITUD_TEXTO_URL            = "mnsj.envio.solicitud.texto.url";
    
    public final static String MENSAJE_ENVIO_CADUCIDAD_ESTIMADO             = "mnsj.envio.caducidad.estimado";
    public final static String MENSAJE_ENVIO_CADUCIDAD_TEXTO_NOTIFICA       = "mnsj.envio.caducidad.texto.notifica";
    public final static String MENSAJE_ENVIO_CADUCIDAD_TEXTO_PLAZO          = "mnsj.envio.caducidad.texto.plazo";
    public final static String MENSAJE_ENVIO_CADUCIDAD_TEXTO_SEGUIMIENTO    = "mnsj.envio.caducidad.texto.seguimiento";
    public final static String MENSAJE_ENVIO_CADUCIDAD_TEXTO_ATENTAMENTE    = "mnsj.envio.caducidad.texto.atentamente";
    public final static String MENSAJE_ENVIO_CADUCIDAD_TEXTO_SUBSECRETARIA  = "mnsj.envio.caducidad.texto.subsecretaria";
    public final static String MENSAJE_ENVIO_CADUCIDAD_TEXTO_TELEFONO       = "mnsj.envio.caducidad.texto.telefono";
    public final static String MENSAJE_ENVIO_CADUCIDAD_TEXTO_URL            = "mnsj.envio.caducidad.texto.url";
    
    //Otorgamiento
    public final static String MENSAJE_ENVIO_SOLICITUD_OTORGAMIENTO         = "mnsj.envio.solicitud.notificacion.otorgamiento";
    
    //Cesión y Transferencia 
    public final static String MENSAJE_ENVIO_SOLICITUD_CESION_TRANSFERENCIA = "mnsj.envio.notificacion.cesion.transferencia";
    
    //Caducidad y Extinción 
    public final static String MENSAJE_ENVIO_SOLICITUD_CADUCIDAD_EXTINCION  = "mnsj.envio.notificacion.caducidad.extincion";
       
    public final static String CONFIGURACION_TEMPLATES_PATH                 = "email.templates.path";
    
    // Variables de ARCGIS
    public final static String ARCGIS_LOCALIZACION_SDK                      = "arcgis.localizacionSDK";
    public final static String ARCGIS_CLIENTE_ID                            = "arcgis.clienteID";
    public final static String ARCGIS_NOMBRE_USUARIO                        = "arcgis.nombreUsuario";
    public final static String ARCGIS_CLAVE_USUARIO                         = "arcgis.claveUsuario";
    public final static String ARCGIS_URL_SERVER                            = "arcgis.urlServer";
    public final static String ARCGIS_CAPA_CANTONES                         = "arcgis.capaCantones";
    public final static String ARCGIS_CAPA_CONCESIONES_PSAD56               = "arcgis.capaConcesionesPSAD56";
    public final static String ARCGIS_CAPA_CONCESIONES_WG84                 = "arcgis.capaConcesionesWG84";
    public final static String ARCGIS_AUTENTICAR_API                        = "arcgis.autenticarAPI";
    public final static String ARCGIS_CAPA_ZONAS_URBANAS                    = "arcgis.capaZonasUrbanas";
    public final static String ARCGIS_CAPA_BOSQUES_PROTECTORES              = "arcgis.capaBosquesProtectores";
    public final static String ARCGIS_CAPA_PATRIMONIO_AREA_NATURAL          = "arcgis.capaPatrimonioAreaNatural";
    public final static String ARCGIS_CAPA_PATRIMONIO_FORESTAL              = "arcgis.capaPatrimonioForestal";
    public final static String ARCGIS_SERVER_PUERTO                         = "arcgis.server.puerto";
    public final static String ARCGIS_SERVER_IP                             = "arcgis.server.ip";
    
    private Configuracion() 
    {
        InputStream is = null;
        String str = System.getProperties().getProperty(ARCOM_CONFIG);
        if (str == null) {
            is = Configuracion.class.getResourceAsStream("/configuracion.properties");
            LOG.warn("Property net.latinus.configDirectory is not set.");
            LOG.info("Obteniendo Propiedades del classpath");
        } else {
            try {
                File localFile = new File(str, "configuracion.properties");
                is = new FileInputStream(localFile);
                LOG.info("Property net.latinus.configDirectory is set.");
            } catch (FileNotFoundException ex) {
                LOG.error("Archivo no encontrado", ex);
            }
        }
        //File localFile = new File(str, "EmailWS.properties");
        this.properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException ex) {
            LOG.error("Archivo no encotrado", ex);
        }
    }

    public static Configuracion getInstance() {
        return ConfiguracionHolder.INSTANCE;
    }

    private static class ConfiguracionHolder {

        private static final Configuracion INSTANCE = new Configuracion();
    }

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    
}
