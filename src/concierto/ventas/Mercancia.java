package concierto.ventas;

public class Mercancia
{
  private int _unidades;
  private double _costoUnidad;
  
  public Mercancia(int _unidades, double _costoUnidad) {
    this._unidades = _unidades;
    this._costoUnidad = _costoUnidad; 
  }
  
  
  public int getUnidades()
  {
    return _unidades;
  }
  public void setUnidades( int unidades )
  {
    _unidades = unidades;
  }

  public double getCostoUnidad()
  {
    return _costoUnidad;
  }
  public void setCostoUnidad( double costUnidad )
  {
    _costoUnidad = costUnidad;
  }
}
