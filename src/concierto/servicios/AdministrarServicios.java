/**
 * Creado: 17 jun. 2021
 */
package concierto.servicios;

/**
 * @author DELL
 */
interface AdministrarServicios
{
  void registrarServicio(String servicio);
  void borrarServicio();
  String concluirServicio();
  void buscarServicio(String Servicio);
}
