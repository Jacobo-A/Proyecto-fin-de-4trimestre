package concierto.contrato;

import java.time.LocalTime;

public abstract class Contrato
{
  //Atributos
  private String _acceso;
  protected String _contrato;
  
  // constuctor NA
  
  //metodos 
  
  
  protected abstract String contrato();
  
  protected String tipoAcceso(int tipo) {
    //exceptions
    if (tipo >= 0  &&  tipo <= 1) {     
      switch (tipo)
      {
        case 0: _acceso = "Entrada principal al lugar"; break;
        case 1: _acceso = "Entrada trasera al lugar"; break;
      }          
    }
    return _acceso;
     
  }
}
