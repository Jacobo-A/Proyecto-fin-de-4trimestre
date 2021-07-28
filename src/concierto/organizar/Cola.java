package concierto.organizar;

import java.util.*;

import concierto.servicios.Servicio;

public class Cola
{
  //atributos
  private Queue<Servicio>  _cola = new  LinkedList();
  
  //metodos
  public void registarServicio(Servicio servicio) {
    _cola.offer(servicio);
    servicio.registrarServicio(servicio._servicio);
  }
  
  public void borraServicio() {
    /*
     *Recupera y quita el encabezado de esta cola.
     */
    _cola.remove(); 
    Servicio servicio = new Servicio();
    servicio.borrarServicio();
  }
  
  // recupera el encabezado de la cola y modifica el estado del servicio
  public Servicio concluirServicio() {
    /* peek()
     * Recupera, pero no quita, el encabezado de esta cola, 
     * o devuelve si esta cola está vacía.null
     */
    Servicio servicio = _cola.peek();
    servicio.setEstadodelServicio(servicio.concluirServicio());
    servicio.concluirServicio();
    
    return servicio;
  }
  
  public Servicio buscarServicio(String _servicio) { 
    
    boolean vacio = true;
    Servicio servicio = null;   
    Queue<Servicio>  _colaCopia = new  LinkedList();
    
    // buscamos en cola
    while(_cola.size() != 0) 
    {
      servicio = _cola.peek();
      //si la marca coincide con el objeto
      if(servicio._servicio == _servicio) {
       
        servicio.buscarServicio(_servicio); 
       // regresamos los objetos a la cola princial
       while(_colaCopia.size() != 0) 
       {
         _cola.offer(_colaCopia.peek());
         _colaCopia.poll();
       }
       
       // regresamos el objeto encontrado
       return servicio;
      }
      else
      {
        // vamos moviendo los elementos de una cola a otra
        _cola.poll();
        _colaCopia.offer(servicio);
      }
    }
    
    // si no encontramos el objeto
    _cola = _colaCopia;
    _colaCopia = null;
    System.out.println("Marca del servicio no encontrado en cola");
    
    // regresamos un null
    return servicio;    
  }
    
  public void desplegarDatos() {
    Queue<Servicio>  _colaCopia = new  LinkedList();;
    Servicio servicio;
    int tamano = _cola.size();
    
    System.out.println("\tContrato de servicios\n");
    for(int i=0; i<tamano; i++)
    {
     servicio = _cola.remove();
     _colaCopia.offer(servicio);
     System.out.println(servicio.contrato()+ "\n");
    } 
    
    _cola = _colaCopia;
  }  

  public int tamano() {
    return _cola.size();
  }
}
