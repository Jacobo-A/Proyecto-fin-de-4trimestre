package concierto.patrocinadores;

import concierto.contrato.Contrato;
import concierto.ventas.Mercancia;

public class Patrocinador extends Contrato
{
  private String _marca;
  private String _producto;
  private int _montoPatrocinio;
  private Mercancia _mercancia;
  private String _acceso = tipoAcceso(1);
  

  
  public  Patrocinador(
      String _marca,String _producto, int _montoPatrocinio, 
      int _unidades, double _costoUnidad) 
  {
    this._marca = _marca;
    this._producto = _producto;
    this._montoPatrocinio = _montoPatrocinio;
    _mercancia = new Mercancia(_unidades, _costoUnidad);
  }

  @Override 
  public String contrato()
  { 
    _contrato = "Marca: "+_marca+ 
        "\nProducto: "+_producto+
        "\nMonto patrocinado: $"+_montoPatrocinio+
        "\nUnidades: "+_mercancia.getUnidades()+
        "\nCosto por unidad: $"+_mercancia.getCostoUnidad()+
        "\nEntrada: "+_acceso;
    
    return _contrato;
  }

}
