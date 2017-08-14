package pruebas;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import cfdi33.*;

public class Pruebas {

	public static void main(String[] args) throws DatatypeConfigurationException {
		// TODO Auto-generated method stub
		ObjectFactory factory = new ObjectFactory();
		Comprobante comp = factory.createComprobante();
		
		
		/*
		 * EMISOR 3.3
		 */
		comp.setEmisor(factory.createComprobanteEmisor());
			comp.getEmisor().setNombre("nombre");			//Opcional
			comp.getEmisor().setRegimenFiscal("regimen");	//Requerido
			comp.getEmisor().setRfc("RFC");					//Requerido
					
		/*
		 * RECEPTOR 3.3
		 */
		comp.setReceptor(factory.createComprobanteReceptor());
			comp.getReceptor().setNombre("string");				//Opcional
			comp.getReceptor().setNumRegIdTrib("string");		//Opcional
			comp.getReceptor().setResidenciaFiscal(CPais.MEX);	//Opcional	LOV
			comp.getReceptor().setRfc("string");				//Requerido
			comp.getReceptor().setUsoCFDI(CUsoCFDI.D_01);		//Requerido	LOV
		
			
		/*
		 * CONCEPTOS
		 */ //Objeto conceptos dentro de comprobante, aloja uno o más objetos concepto, llenarlos primero y luego añadirlos a "conceptos"
			comp.setConceptos(factory.createComprobanteConceptos());
			cfdi33.Comprobante.Conceptos.Concepto cepto = factory.createComprobanteConceptosConcepto();
				cepto.setClaveProdServ("String");				//Requerido	LOV
				cepto.setNoIdentificacion("String");			//Opcional
				cepto.setCantidad(BigDecimal.valueOf(20));		//Requerido
				cepto.setClaveUnidad("String");					//Requerido
				cepto.setUnidad("String");						//Opcional
				cepto.setDescripcion("String");					//Requerido
				cepto.setValorUnitario(BigDecimal.valueOf(20)); //Requerido
				cepto.setImporte(BigDecimal.valueOf(20));		//Requerido
				cepto.setDescuento(BigDecimal.valueOf(20));		//Opcional		
			comp.getConceptos().getConcepto().add(cepto);
			
			
			
		/*
		 * COMPROBANTE	
		 */
			comp.setVersion("String");							//Requerido
			comp.setSerie("String");							//Opcional
			comp.setFolio("String");							//Opcional
				
			GregorianCalendar c = new GregorianCalendar();
				c.setTime(Calendar.getInstance().getTime());
				XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			comp.setFecha(date2);								//REVISAR ESTÁ FORMA DE CONSEGUIR LA FECHA!! //Requerido
			comp.setSello("String");							//Requerido
			comp.setFormaPago("String");						//Opcional
			comp.setNoCertificado("String");					//Requerido
			comp.setCertificado("String");						//Requerido
			comp.setCondicionesDePago("String");				//Opcional
			comp.setSubTotal(BigDecimal.valueOf(20));			//Requerido
			comp.setDescuento(BigDecimal.valueOf(20));			//Opcional
			comp.setMoneda(CMoneda.MXN);						//Requerido
			comp.setTipoCambio(BigDecimal.valueOf(20));			//Opcional
			comp.setTotal(BigDecimal.valueOf(20));				//Requerido
			comp.setTipoDeComprobante(CTipoDeComprobante.I);	//Requerido
			comp.setMetodoPago(CMetodoPago.PUE);				//Opcional
			comp.setLugarExpedicion("String");					//Requerido
			comp.setConfirmacion("String");						//Opcional
			
			
		/*
		 *	IMPUESTOS
		 */
		 
			
		 /*
		  * COMPLEMENTO (NOMINA POR EJEMPLO)
		  */
		 comp.getComplemento().add(factory.createComprobanteComplemento());
			
			
		/*
		 * ADDENDA
		 */
		 
		comp.setAddenda(factory.createComprobanteAddenda());
					
		
	}

}
