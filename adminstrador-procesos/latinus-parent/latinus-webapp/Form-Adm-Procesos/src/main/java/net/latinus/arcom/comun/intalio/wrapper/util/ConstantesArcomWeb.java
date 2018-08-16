
package net.latinus.arcom.comun.intalio.wrapper.util;

import java.io.Serializable;

/**
 * Constantes para proyecto web ARCOM.
 * @author Latinus - Cristhian Herrera
 */

public class ConstantesArcomWeb implements Serializable 
{
    
    public static final String ACCION_INGRESO = "ingreso";
    public static final String ACCION_EDICION = "edicion";
    public static final String ACCION_VER = "ver";
    
    public static final String TERMINOS_CONDICIONES_MINERIA_ARTESANAL           = "Declaro bajo juramento que los datos consignados en el formulario son reales, auténticos y faculto a la administración a constatar en cualquier momento la autenticidad de dicha información, además me sujeto a las sanciones y/o penas en caso de falsedad de la información consignada, adicionalmente como peticionario no soy titular de ningún derecho minero (concesión o permiso para labores de Minería Artesanal), y no soy accionista o socio, de ninguna de las asociaciones, cooperativas, condominios, compañías, empresas, etc. que tengan permisos o concesiones para realizar actividades mineras, y que la inversión para infraestructura, maquinaria, herramientas, etc., provienen de origen lícito, por cuanto no están relacionados con ninguna actividad ilegal.";
    public static final String TERMINOS_CONDICIONES_LIBRE_APROVECHAMIENTO       = "Declaro bajo juramento que los datos consignados en el formulario son reales, auténticos y faculto a la administración a constatar en cualquier momento la autenticidad de dicha información, además me sujeto a las sanciones y/o penas en caso de falsedad de la información consignada, adicionalmente como peticionario no soy titular de ningún derecho minero (concesión o permiso para labores de Libre Aprovechamiento), y no soy accionista o socio, de ninguna de las asociaciones, cooperativas, condominios, compañías, empresas, etc. que tengan permisos o concesiones para realizar actividades mineras, y que la inversión para infraestructura, maquinaria, herramientas, etc., provienen de origen lícito, por cuanto no están relacionados con ninguna actividad ilegal.";
    public static final String TERMINOS_CONDICIONES_PLANTAS_BENEFICIO           = "Declaro bajo juramento que los datos consignados en el formulario son reales, auténticos y faculto a la administración a constatar en cualquier momento la autenticidad de dicha información, además me sujeto a las sanciones y/o penas en caso de falsedad de la información consignada, y que la inversión proviene de origen lícito, por cuanto no están relacionados con ninguna actividad ilegal.";
    public static final String TERMINOS_CONDICIONES_LICENCIA_COMERCIALIZACION   = "Declaro bajo juramento que los datos consignados en el formulario son reales, auténticos y faculto a la administración a constatar en cualquier momento la autenticidad de dicha información, además me sujeto a las sanciones y/o penas en caso de falsedad de la información consignada, y que la inversión proviene de origen lícito, por cuanto no están relacionados con ninguna actividad ilegal.";
    
    public static final String MENSAJE_TOKEN                                            = "@";
    public static final String MENSAJE_OTORGAMIENTO_PLANTAS_BENEFICIO_CONCEDIDO         = "Estimado (a) @. Su solicitud de Planta de Beneficio ha sido concedida";
    public static final String MENSAJE_OTORGAMIENTO_PLANTAS_BENEFICIO_NEGADO            = "Estimado (a) @. Su solicitud de Planta de Beneficio ha sido negada";
    public static final String MENSAJE_OTORGAMIENTO_LICENCIA_COMERCIALIZACION_CONCEDIDO = "Estimado (a) @. Su solicitud de Licencia de Comercialización ha sido concedida";
    public static final String MENSAJE_OTORGAMIENTO_LICENCIA_COMERCIALIZACION_NEGADO    = "Estimado (a) @. Su solicitud de Licencia de Comercialización ha sido negada";
    
    public static final String PERSONA_JURIDICA = "Juridica";
    public static final String PERSONA_NATURAL  = "Natural";
    
    public static final String SI = "S";
    public static final String NO = "N";
    
    public static final String STR_ID_INS                       = "&idIns=";
    public static final String STR_ID_INSTANCIA                 = "&idInstancia=";
    public static final String STR_ID_ARCOM                     = "&idArcom=";
    public static final String STR_ID_FORMULARIO                = "&idFormulario=";
    public static final String STR_ID_TABLA                     = "&idTabla=";
    public static final String STR_TABLA_ARCOM                  = "&tablaArcom=";
    public static final String STR_ACCION                       = "&accion=";
    public static final String STR_ACEPTA_CONDICIONES           = "&aceptaCondiciones=";
    public static final String STR_SOLICITANTE                  = "&solicitante=";
    public static final String STR_ENTREGA_DOCUMENTOS           = "&entregaDocumentos=";
    public static final String STR_PRESENTA_DOCUMENTOS          = "&presentaDocumentos=";
    public static final String STR_ABOGADO                      = "&abogado=";
    public static final String STR_TECNICO                      = "&tecnico=";
    public static final String STR_TECNICO_CATASTRO             = "&catastral=";
    public static final String STR_ECONOMICO                    = "&economico=";
    public static final String STR_COORDINADOR_REGIONAL         = "&coordinadorRegional=";
    public static final String STR_REGISTRADOR_REGIONAL         = "&registradorRegional=";
    public static final String STR_ABOGADO_NACIONAL             = "&abogadoNacional=";
    public static final String STR_DIRECTOR_EJECUTIVO           = "&directorEjecutivo=";
    public static final String STR_DIRECTOR_JURIDICO            = "&directorJuridico=";
    public static final String STR_SUBSANA                      = "&subsana=";
    public static final String STR_REALM_USUARIO_SOLICITANTE    = "&realmUsuario=";
    public static final String STR_CUMPLE                       = "&cumple=";
    public static final String STR_CUMPLE_PAGO                  = "&cumplePago=";
    public static final String STR_CUMPLE_INFORME_LEGAL         = "&cumpleInformeLegal=";
    public static final String STR_CUMPLE_INFORME_TECNICO       = "&cumpleInformeTecnico=";
    public static final String STR_CUMPLE_INFORME_ECONOMICO     = "&cumpleInformeEconomico=";
    public static final String STR_CUMPLE_INFORME_CATASTRO      = "&cumpleInformeCatastro=";
    public static final String STR_VERIFICA_INFORME_LEGAL       = "&verificaInformeLegal=";
    public static final String STR_VERIFICA_INFORME_TECNICO     = "&verificaInformeTecnico=";
    public static final String STR_VERIFICA_INFORME_ECONOMICO   = "&verificaInformeEconomico=";
    public static final String STR_VERIFICA_INFORME_CATASTRO    = "&verificaInformeCatastro=";
    public static final String STR_VERIFICA_RECURSO             = "&verificaRecurso=";
    public static final String STR_VERIFICA_RESOLUCION          = "&verificaResolucion=";
    public static final String STR_VERIFICA_DILIGENCIA          = "&verificaDiligencia=";
    public static final String STR_VERIFICA_REQUISITOS          = "&verificaRequisitos=";
    public static final String STR_SUBSANA_INFORME              = "&subsanaInforme=";
    public static final String STR_SUBSANA_USUARIO              = "&subsanaUsuario=";
    public static final String STR_ATENCION_INMEDIATA           = "&atencionInmediata=";
    public static final String STR_VALIDA_VIGENCIA              = "&validaVigencia=";
    public static final String STR_VALIDA_FACTURA               = "&validaFactura=";
    public static final String STR_OTORGA                       = "&otorga=";
    public static final String STR_NOTIFICACION                 = "&notificacion=";
    public static final String STR_REGIONAL                     = "&regional=";
    public static final String STR_REALM_REGIONAL               = "&realmRegional=";
    public static final String STR_SUBSECRETARIA                = "&subsecretaria=";
    public static final String STR_REALM_SUBSECRETARIA          = "&realmSubsecretaria=";
    public static final String STR_CODIGO_CATASTRO              = "&codigoCatastro=";
    public static final String STR_USUARIO_EXTERNO              = "&usuarioExterno=";
    public static final String STR_TITULAR_PLANTA               = "&titularPlanta=";
    public static final String STR_DETECTAN_IRREGULARIDADES     = "&detectaIrregularidades=";
    public static final String STR_VALOR_CORRECTO               = "&valorCorrecto=";
    public static final String STR_TIEMPO_RESPUESTA             = "&tiempoRespuesta=";
    public static final String STR_USUARIO_INTERNO              = "&usuarioInterno=";
    public static final String STR_APRUEBA_PAGO                 = "&apruebaPago=";
    public static final String STR_VERIFICA_PAGO                = "&verificaPago=";
    public static final String STR_VERIFICA_SOLICITUD           = "&valida=";
    public static final String STR_ALCANCE_PAGO                 = "&alcancePago=";
    public static final String STR_DESCRIPCION_PROCESO          = "&descripcion=";
    public static final String STR_TERMINAR_PROCESO             = "&terminarProceso=";
    public static final String STR_USUARIO                      = "&usuario=";
    public static final String STR_TIPO_TRAMITE                 = "&tipoTramite="; 
    public static final String STR_CONDICIONAL                  = "&condicional="; 
    public static final String STR_DESGRAFICAR                  = "&desgraficar=";
    public static final String STR_GRAFICAR                     = "&graficar=";
    public static final String STR_REQUIERE_INFORME             = "&requiereInforme=";
    public static final String STR_ROL_TECNICO                  = "&rolTecnico=";
    public static final String STR_ROL_ECONOMICO                = "&rolEconomico=";
    
    public static final String PARAM_ID                         = "id";
    public static final String PARAM_ID_INSTANCIA               = "idInstancia";
    public static final String PARAM_URL                        = "url";
    public static final String PARAM_TOKEN                      = "token";
    public static final String PARAM_USER                       = "user";
    public static final String PARAM_TYPE                       = "type";
    public static final String PARAM_CLAIM_TASK_ON_OPEN         = "claimTaskOnOpen";
    public static final String PARAM_ID_INS                     = "idIns";
    public static final String PARAM_ID_ARCOM                   = "idArcom";
    public static final String PARAM_ID_TABLA                   = "idTabla";
    public static final String PARAM_TABLA_ARCOM                = "tablaArcom";
    public static final String PARAM_PRESENTA_DOCUMENTOS        = "presentaDocumentos";
    public static final String PARAM_ACCION                     = "accion";
    public static final String PARAM_ACEPTA_CONDICIONES         = "aceptaCondiciones";
    public static final String PARAM_SOLICITANTE                = "solicitante";
    public static final String PARAM_ABOGADO                    = "abogado";
    public static final String PARAM_TECNICO                    = "tecnico";
    public static final String PARAM_TECNICO_CATASTRO           = "catastral";
    public static final String PARAM_ECONOMICO                  = "economico";
    public static final String PARAM_SUBSANA                    = "subsana";
    public static final String PARAM_SUBSANA_INFORME            = "subsanaInforme";
    public static final String PARAM_CUMPLE                     = "cumple";
    public static final String PARAM_CUMPLE_INFORME_LEGAL       = "cumpleInformeLegal";
    public static final String PARAM_CUMPLE_INFORME_TECNICO     = "cumpleInformeTecnico";
    public static final String PARAM_CUMPLE_INFORME_ECONOMICO   = "cumpleInformeEconomico";
    public static final String PARAM_CUMPLE_INFORME_CATASTRO    = "cumpleInformeCatastro";
    public static final String PARAM_VERIFICA_INFORME_LEGAL     = "verificaInformeLegal";
    public static final String PARAM_VERIFICA_INFORME_TECNICO   = "verificaInformeTecnico";
    public static final String PARAM_VERIFICA_INFORME_ECONOMICO = "verificaInformeEconomico";
    public static final String PARAM_VERIFICA_INFORME_CATASTRO  = "verificaInformeCatastro";
    public static final String PARAM_OTORGA                     = "otorga";
    public static final String PARAM_NOTIFICACION               = "notificacion";
    public static final String PARAM_REGIONAL                   = "regional";
    public static final String PARAM_REALM_REGIONAL             = "realmRegional";
    public static final String PARAM_SUBSECRETARIA              = "subsecretaria";
    public static final String PARAM_REALM_SUBSECRETARIA        = "realmSubsecretaria";
    public static final String PARAM_CODIGO_CATASTRO            = "codigoCatastro";
    public static final String PARAM_COORDINADOR_REGIONAL       = "coordinadorRegional";
    public static final String PARAM_SUJETO_IDENTIFICACION      = "sujetoId";
    public static final String PARAM_USUARIO_EXTERNO            = "usuarioExterno";
    public static final String PARAM_APRUEBA_PAGO               = "apruebaPago";
    public static final String PARAM_VERIFICA_PAGO              = "verificaPago";
    public static final String PARAM_COMPROBANTE_PAGO           = "comprobantePago";
    public static final String PARAM_ALCANCE_PAGO               = "alcancePago";
    public static final String PARAM_USUARIO                    = "usuario";
    public static final String PARAM_TIPO_TRAMITE               = "tipoTramite";
    public static final String PARAM_CONDICIONAL                = "condicional";
    public static final String PARAM_NUMERO_FORMULARIO          = "numeroFormulario";
    public static final String PARAM_ROL_TECNICO                = "rolTecnico";
    public static final String PARAM_ROL_ECONOMICO              = "rolEconomico";
   
    
    public static final String TEXTO_HEADER_INFORME_PRODUCCION                                                          = "Informe Anual de Producción";
    public static final String TEXTO_HEADER_INFORME_EXPLORACION                                                         = "Informe de Exploración";
    public static final String TEXTO_HEADER_INFORME_COMERCIALIZACION                                                    = "Informe Semestral de Comercialización";
    public static final String TEXTO_HEADER_INFORME_PLANTA_BENEFICIO                                                    = "Informe de Producción de Plantas de Beneficio";
    public static final String TEXTO_HEADER_INFORME_ACTIVIDADES_INVERSIONES_PREVIO_CONTRATO_EXPLOTACION                 = "Informe sobre actividades e inversiones previa a la suscripción del contrato de explotación";
    public static final String TEXTO_HEADER_INFORME_PREVIO_CAMBIO_PERIODO_EXPLORACION_INICIAL_A_EXPLORACION_AVANZADA    = "Informe previo al cambio de periodo de exploración inicial a exploración avanzada";
    
    public static final String TEXTO_HEADER_GUIA_REMISION_TRANSPORTE                                                    = "Guía de remisión de transporte";
    public static final String TEXTO_HEADER_GUIA_PRODUCCION                                                             = "Guía de movilización mensual";

    public static final String TEXTO_HEADER_INSCRIPCION_INSTRUMENTO                                                     = "Inscripción Instrumento";
    public static final String TEXTO_HEADER_INSCRIPCION_REGISTRO                                                        = "Informe Inscripción Registro";
    
    public static final String TEXTO_TABLA_SIN_DATOS        = "No se han encontrado datos";
    public static final String TEXTO_PROCESO_SIN_ADJUNTOS   = "No se han adjuntado documentos al proceso";
    public static final String TEXTO_GUARDADO_EXITOSO       = "Guardado exitoso";
    public static final String TEXTO_ACTUALIZACION_EXITOSA  = "Actualización exitoso";
    public static final String TEXTO_NOTIFICACION_ENVIADA   = "Notificación envíada";
    public static final String TEXTO_LLENAR                 = "Llenar";
    
    
    public static final String VAL_INFORME_LEGAL     = "INFLEG";
    public static final String VAL_INFORME_ECONOMICO = "INFECO";
    public static final String VAL_INFORME_TECNICO   = "INFTEC";
    public static final String VAL_INFORME_CATASTRAL = "INFCAT";
    
    public static final String EXTENSION_PDF = ".pdf";
    
    public static final String ETIQUETA_COMPROBANTE_PAGO_LUGAR_FECHA                    = "Lugar y Fecha: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_DATOS_OFICIO                   = "Datos del oficio con el que se recibe el comprobante: "; 
    public static final String ETIQUETA_COMPROBANTE_PAGO_FECHA                          = "Fecha: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_FECHA_GENERAL                  = "Fecha: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_NOMBRE_APELLIDO                = "Nombres y Apellidos o Razón Social del Cliente: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_LUGAR_FECHA_EMISION            = "Lugar y Fecha de Emisión: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_COMPROBANTE_PAGO               = "Comprobante de Pago";
    public static final String ETIQUETA_COMPROBANTE_PAGO_NUMERO                         = "Número: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_VALOR                          = "Valor: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_BANCO                          = "Banco: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_CONCEPTO_PAGO                  = "Concepto de Pago: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_CODIGO                         = "Código: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_PARA_TIPO_ENTIDAD_RELACIONADA  = "Para: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_NOMBRE_ENTIDAD_RELACIONADA     = "Nombre: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_DESCRIPCION_PAGO               = "Descripción: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_VALOR_TOTAL_PAGADO             = "Valor Pagado: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_VALOR_ADICIONAL                = "Valor Adicional: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_MOTIVO_VALOR_ADICIONAL         = "Motivo Valor Adicional: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_OBSERVACIONES                  = "Observaciones: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_ELABORADO_POR                  = "Elaborado Por: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_NOMBRE_FUNCIONARIO             = "Nombre Funcionario: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_ROL_FUNCIONARIO                = "Rol Funcionario: ";
    public static final String ETIQUETA_COMPROBANTE_PAGO_NO_APLICA                      = "N/A";
    public static final String VALOR_REFRENCIA_ZONA_18                                  = "24878";
    public static final String VALOR_REFRENCIA_ZONA_DEFAULT                             = "24877";
    public static final String NEMONICO_PAGO_MINERIA_ARTESANAL_PEQUENIA                 = "PAGDERTRA";
    public static final String NEMONICO_PAGO_PEQUENIA_MINERIA                           = "PAGPEQMIN";
    public static final String VALOR_S_SUBSANAR                                         =   "S";
    public static final String VALOR_FECHA_CULMINACION_VIGENCIA                         ="36";
    
    public static final String VALOR_TICALPATENTE                                       = "TICALPATENTE";
    public static final String VALOR_TICALREGALIA                                       = "TICALREGALIA";
    public static final String VALOR_TICALUTILIDAD                                      = "TICALUTILIDAD";
    public static final String PERIODO_PATENTE                                          = "PERPAT";
    public static final String PERIODO_REGALIA                                          = "PERREG";
    public static final String PERIODO_UTILIDAD                                         = "PERUTIL";
    
}   