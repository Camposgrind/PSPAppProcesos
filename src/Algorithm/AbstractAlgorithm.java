package Algorithm;

import java.util.ArrayList;

import Models.Proceso;

public abstract class AbstractAlgorithm {
	
	//ESTADO
	/**
	 * Lista de que tontendrá todos los procesos que necesitamos
	 */
	protected ArrayList<Proceso> listaProcesos;
	/**
	 * Lista que nos valdrá para ir metiendo los procesos que estarán<br>
	 * a la espera de ejecutarse porque estaba otro ejecutándose
	 */
	protected ArrayList<Proceso> colaProcesos;
	
	/**
	 * Constructor
	 * @param miLista lista de procesos a calcular
	 */
	public AbstractAlgorithm(ArrayList<Proceso> miLista) {
		listaProcesos = miLista;
		colaProcesos = new ArrayList<Proceso>();
		
	}
	
	//RESTO COMPORTAMIENTOS
	/**
	 * Comportamiento que busca el proceso que le toca entrar,<br>
	 * lo mete en nuestra cola de procesos por si no puede ejecutar en ese momento
	 * @param ciclo
	 */
	protected void buscarProceso(int ciclo) {
		Proceso miProceso = null;
		
		
		for(int i=0;i<listaProcesos.size();i++) {
			miProceso= listaProcesos.get(i);
			
			if(miProceso.getTiempoLlegada()==ciclo) {
				colaProcesos.add(miProceso);
			}
		}
	}
	/**
	 * Método para calcular las rafas totales pera hacer el bucle while 
	 * @return numeroRafagas numero de rafágas totales de todos los procesos
	 */
	protected int calcularRafagas() {
		int numeroRafagas= 0;
		
		for (int i = 0; i < listaProcesos.size(); i++) {
			numeroRafagas += listaProcesos.get(i).getRafaga();
		}
		
		return numeroRafagas;
	}
	/**
	 * Método para calcular los indices de penalización y <br> 
	 * las medias totales de penalización 
	 * @param miLista lista de procesos para calcular
	 */
	protected void calcularIndicePen(ArrayList<Proceso> miLista) {
		double resultado =0;
		Proceso miProceso;
		double tiempoLlegada;
		double tiempoSalida;
		double rafaga;
		double resultadoProceso;
		
		for (int i=0;i<listaProcesos.size();i++) {
			
			miProceso = listaProcesos.get(i);
			tiempoLlegada = miProceso.getTiempoLlegada();
			tiempoSalida = miProceso.getTiempoSalida()+1;
			rafaga = miProceso.getRafagaInicial();
			
			resultadoProceso= (tiempoSalida-tiempoLlegada)/rafaga;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("El indice de penalización del proceso "+ miProceso.getLetra() +" es " 
					+resultadoProceso);
			
			resultado += resultadoProceso; 	
					
			}
		
		resultado = resultado/(listaProcesos.size());
		System.out.println("La media de penalización es "+resultado);
	}
}
