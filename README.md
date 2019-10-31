# ADN_CEIBA

Modelo de Negocio:

## Órdenes de compra  pendiente por aprobar
  
*	Requerimiento: realizar una aplicación para aprobar una orden de compra, dicha orden debe contener la siguiente información:

## Rol de comprador:
 * Traer o consultas información de la oc en estado INCOMPLETE (estado de inicial de oc)
   *El comprador debe enviar la oc para aprobación. Dicho proceso contiene actualizar el estado de la oc a REQ_APPROVAL(Pendiente por aprobación)
  
 ## Rol aprobador
*	Consultar las OC que están pendiente x aprobación
*	Aprobar OC de compra (cambia el estado a APPROVED)

## Validaciones 
* Al momento de enviar la OC a pendiente por aprobación, el sistema de validar el monto de la oc con respecto a la tabla de aprobacionXmonto,
 * Comparar el monto entre los rango inicial y final, y enviar la notificación al aprobador
 * Insertar en la tabla Aprobacion_OC
 * Enviar notificación o correo  al aprobador con  el número de OC, proveedor  y monto

*	Al momento de realizar la aprobación de la OC, se debe de cambiar el estado dependiendo la decisión (REJECTED, APPROVED)
*	Debe actualizar el estado de la tabla Aprobación OC y el estado de la tabla OC
