/**
 * Creado: 15 jun. 2021
 */
package concierto.organizar;

import java.io.*;
import java.time.*;
import java.util.*;
import concierto.artistas.Artista;
import concierto.contrato.ContratoFinal;
import concierto.patrocinadores.Patrocinador;
import concierto.ventas.Evento;
import concierto.servicios.Servicio;

/**
 * @author Flores Jacobo Alejandro matricula 2193037519
 * @author Profesor: Dra. Rafaela Blanca Silva López
 * @author Proyecto Final POO Tema: Organizar un concierto
 */
public class OrganizarConcierto
{

  /**
   * @param args
   */
  public static void main( String[] args )
  {
    
    // Crear Evento  
    Evento evento = null;
    Vector <Patrocinador> patrocinadores = new Vector<Patrocinador>();
    Cola colaServicios = new Cola();
    
    evento = crearEvento(200000, 850.50, "2022-09-18", "Foro Pegazo", "Thanos");    
    
    /*
     * Para contratar a alguien necesitamos conocer:
     * nombre, servicio que brinda, tiempo y costo 
     */
    evento.setArtista(contratarArtista(
        evento.getArtista(),"Pop","03:00:00",30000.00));
   
    /*
     * Necesitamos patrocinadores para solventar gastos
     */
    contratarPatrocinadores(patrocinadores);
   
    /*
     * Necesitamos de algunos servicios para hacer un concierto
     */
    contratarServicios(colaServicios);        
    /*
     * Desplegamos los datos de nuestro concierto
     */
    desplegarDatos(evento,evento.getArtista(),patrocinadores,colaServicios);
    
    /*
     * Buscamos y Eliminamos algunos servicios 
     */
    System.out.println("Buscamos un servicio. ");
    colaServicios.buscarServicio("Seguridad");
    
    System.out.println("Eliminamos el primer servicio en cola.");
    colaServicios.borraServicio();
    
    System.out.println("Concluimos el primer servicio en cola.");
    colaServicios.concluirServicio();
    
    /*
     * Desmplegamos datos
     */
    desplegarDatos(evento,evento.getArtista(),patrocinadores,colaServicios);
    
    /*
     * Conluimos los servicios, los eliminamos y exportamos el contrato
     */
    String rutaArchivo = "C:\\Users\\DELL\\Documents\\"+
        "--------- ALE ------------\\UAM ICT\\4to trimestre\\"+
        "POO\\proyecto final\\Contrato_Final.txt";
    Artista artista = evento.getArtista();
    
    ContratoFinal contratoFinal;
    contratoFinal = new ContratoFinal(artista,patrocinadores,
        colaServicios, rutaArchivo);
    
    contratoFinal.escribirContrato();
  }
      

  private static void desplegarDatos( Evento evento,Artista artista, 
      Vector<Patrocinador> patrocinadores, Cola servicios)
  {
    System.out.println("\n\t***Crea un concierto***\n" );
    desplegarDatos(artista);
    desplegarDatos(patrocinadores);
    servicios.desplegarDatos();
  }
  
  private static void desplegarDatos( Vector<Patrocinador> patrocinadores )
  {
    System.out.println("\tContratos de patrocinadores\n");
    for(Patrocinador variable : patrocinadores) {
     System.out.println(variable.contrato()+"\n"); 
    }
    
  }

  private static void desplegarDatos( Artista artista)
  {
    System.out.println("\tContrato de Artista\n");
    System.out.println(artista.contrato()+"\n");
  }
  
  private static Evento crearEvento( 
      int entradas, double costoEntrada, 
      String fecha,String lugar, String nom_Artista)
  {
    Evento evento= new Evento();
    evento.setCantidadEntradas(entradas);
    evento.setCostoEntrada(costoEntrada);
    
    //excepcion
    evento.setFecha(LocalDate.parse(fecha) );
    
    evento.setLugarEvento(lugar);
    evento.setArtista(new Artista(nom_Artista));
    
    return evento;
  }
    
  // redefinimos al objeto artista y culminamos el contrato
  private static Artista contratarArtista(
      Artista artista, String genero, String tiempo, double costo)
  {
    // artista ya cuenta con nombre, solo faltan el resto de atributos
    artista.setTiempo(LocalTime.parse(tiempo) );
    artista.setCosto(costo);
    artista.setGenero(genero);
    
    return artista;
  }
  
  // Contratamos patrocinadores y los organisamos
  private static void contratarPatrocinadores(
      Vector<Patrocinador> patrocinadores )
  {
    patrocinadores.add(
        new Patrocinador("Coca-Cola", "Refresco", 20000, 5000, 12.5));
    patrocinadores.add(
        new Patrocinador("Dominos", "Pizza", 1500, 2000, 15));
    patrocinadores.add(
        new Patrocinador("Corona", "Cerveza", 25000, 7000, 17));
    
  }
  
  // Necesitamos contratar servicios para hacer un concierto
  private static void contratarServicios(Cola colaServicios)
  {
    /*Estados del servicio      Acceso
     *Proceso                   case 1: _acceso = "Entrada trasera al lugar"
     *Concluido
     *Finalizado
     */
    colaServicios.registarServicio(
        new Servicio("Sounds","Sonido","07:00","Juan","Proceso",50000,1));
    colaServicios.registarServicio(
        new Servicio("Luz","Iluminacion","07:00","Hector","Proceso",60000,1));
    colaServicios.registarServicio(
        new Servicio("Cguro","Seguridad","10:00","Valeria","Proceso",25000,1));
    colaServicios.registarServicio(
        new Servicio("Clean","Limpieza","15:00","Marco","Proceso",25000,1));   
  }

  
}
