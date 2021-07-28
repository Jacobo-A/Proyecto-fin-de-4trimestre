package concierto.ventas;

import java.time.LocalDate;
import concierto.artistas.Artista;

public class Evento
{
  protected int _cantidadEntradas;
  protected double _costoEntrada;
  protected LocalDate _fecha;
  protected String _lugarEvento;
  protected Artista _artista;
  //vector<Patrocinador> _patrocinadores;
  // Cola<Servicio> _servcios;

  //metodos
  public int getCantidadEntradas()
  {
    return _cantidadEntradas;
  }
  public double getCostoEntrada()
  {
    return _costoEntrada;
  }
  public LocalDate getFecha()
  {
    return _fecha;
  }
  public String getLugarEvento()
  {
    return _lugarEvento;
  }
  public Artista getArtista()
  {
    return _artista;
  }
  
  public void setCantidadEntradas( int cantidadEntradas )
  {
    _cantidadEntradas = cantidadEntradas;
  }
  public void setCostoEntrada( double costoEntrada )
  {
    _costoEntrada = costoEntrada;
  }
  public void setFecha( LocalDate fecha )
  {
    _fecha = fecha;
  }
  public void setLugarEvento( String lugarEvento )
  {
    _lugarEvento = lugarEvento;
  }
  public void setArtista( Artista artista )
  {
    _artista = artista;
  }

}
