package concierto.artistas;

import java.time.LocalTime;


import concierto.contrato.*;

public class Artista extends Contrato
{
  // atributos
  private String _nombre;
  private LocalTime _tiempo;
  private double _costo; 
  private String _genero;
  private String _acceso = tipoAcceso(0);
  
  //constructores  
  public Artista(String _nombre){
    this._nombre = _nombre;   
  }
  
  //metodos GETTERS Y SETTERS

  public String getNombre()
  {
    return _nombre;
  }

  public LocalTime getTiempo()
  {
    return _tiempo;
  }

  public double getCosto()
  {
    return _costo;
  }

  public String getGenero()
  {
    return _genero;
  }

  public void setGenero( String genero )
  {
    _genero = genero;
  }

  public void setNombre( String nombre )
  {
    _nombre = nombre;
  }

  public void setTiempo( LocalTime tiempo )
  {
    _tiempo = tiempo;
  }

  public void setCosto( double costo )
  {
    _costo = costo;
  }


  // metodos
  
  // definir el atributo contrato
  @Override
  public String contrato() 
  {
    _contrato = "Artista: "+ _nombre + 
        "\nGenero: "+ _genero +
        "\nTiempo: "+ _tiempo+" horas"+
        "\nCosto: $"+_costo+
        "\nEntrada: "+ _acceso;
    
    return _contrato ;
  }
    
}
