package concierto.contrato;

import java.io.*;
import java.util.*;

import concierto.artistas.Artista;
import concierto.organizar.Cola;
import concierto.patrocinadores.Patrocinador;
import concierto.servicios.Servicio;

public class ContratoFinal
{
  private Artista _artista;
  private Vector<Patrocinador> _patrocinadores;
  private Cola _colaServicios;
  private String _rutaArchivo;
  
  private FileWriter contratoFinal = null;
  
  public ContratoFinal(Artista _artista,Vector<Patrocinador> _patrocinadores, 
      Cola _colaServicios, String _rutaArchivo ){
    this._artista = _artista;
    this._patrocinadores = _patrocinadores;
    this._colaServicios = _colaServicios;
    this._rutaArchivo = _rutaArchivo;      
  }
  
  public void escribirContrato() 
  {
    try {
      contratoFinal = new FileWriter(_rutaArchivo);
      System.out.println("Contrato concluido y exportado\n");
      escribirDatos();
      
    }
    catch(Exception e)
    {
      System.out.println("Error de escritura del fichero");
      System.out.println(e.getMessage());
    }
    finally {
      try {
      //Cerrar el fichero si se ha abierto
        if(contratoFinal != null)
          contratoFinal.close();
      }
      catch(Exception e){
        System.out.println("Error al cerrar el fichero");
        System.out.println(e.toString());
      }
    }
  }

  private void escribirDatos() throws IOException
  {
    contratoFinal.write("\tCONTRATO DE EVENTO\n\n");
    
    contratoFinal.write("\tContrato de Artista\n\n" );
    contratoFinal.write(_artista.contrato()+"\n\n");
    
    contratoFinal.write("\tContratos de patrocinadores\n\n");
    for(Patrocinador variable: _patrocinadores) {
      contratoFinal.write(variable.contrato()+"\n\n");
    }
    
    contratoFinal.write("\n\tContrato de Servicios\n\n");
    
    int tamano = _colaServicios.tamano();
    for(int i=0 ; i<tamano; i++) {
      contratoFinal.write(_colaServicios.concluirServicio().contrato()+"\n\n");
      _colaServicios.borraServicio();
    }
  }
  
  
}
