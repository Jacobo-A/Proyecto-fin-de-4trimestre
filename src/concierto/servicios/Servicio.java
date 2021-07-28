package concierto.servicios;

import java.time.LocalTime;

import concierto.contrato.Contrato;

public class Servicio extends Contrato implements AdministrarServicios
{
  public String _empresa;
  public String _servicio;
  private LocalTime _tiempo;
  private String _nombrePersonal;
  private String _estadodelServicio;
  private double _costo;
  private String _acceso;
  
  
  public Servicio(String _empresa,String _servicio, String _tiempo, 
   String _nombrePersonal, String _estadodelServicio,double _costo, int _acceso) 
  {
    this._empresa = _empresa;
    this._servicio = _servicio;
    this._tiempo = LocalTime.parse(_tiempo);
    this._nombrePersonal = _nombrePersonal;
    this._estadodelServicio = _estadodelServicio;
    this._costo = _costo;
    this._acceso = tipoAcceso(_acceso);
  }
  
  public Servicio()
  {
    // TODO Auto-generated constructor stub
  }

  
  
  public String getEstadodelServicio()
  {
    return _estadodelServicio;
  }


  public void setEstadodelServicio( String estadodelServicio )
  {
    _estadodelServicio = estadodelServicio;
  }


  @Override
  public void registrarServicio(String servicio)
  {
    System.out.println("Se a registrado servicio de: "+servicio);
  }

  @Override
  public void borrarServicio()
  {
    System.out.println("Se a borrado servicio en cola.\n");
  }

  @Override
  public String concluirServicio()
  {
    String mensaje = "A conluido servicio";
    return mensaje;
  }

  @Override
  public void buscarServicio(String servicio)
  {
    System.out.println("Servicio: "+servicio+
        " ,encontrado en cola, Empresa: "+_empresa+"\n");

  }
  

  @Override
  public String contrato()
  {
   _contrato = 
       "Empresa: "+_empresa+
       "\nServicio: "+_servicio+
       "\nTiempo: "+_tiempo+" horas."+
       "\nPersona Encargada: "+ _nombrePersonal+
       "\nEstado del servicio: "+_estadodelServicio+
       "\nCosto del servicio: $"+_costo+
       "\nAcceso: "+_acceso;
    return _contrato;
  }

}
