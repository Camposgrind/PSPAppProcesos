package Models;

public class Proceso {
	//ESTADO
	/**
	 * letra del proceso
	 */
	String letra;
	/**
	 * tiempo de llegada del proceso
	 */
	int tiempoLlegada;
	/**
	 * Ráfaga del proceso
	 */
	int rafaga;
	/**
	 * tiempo en el que sale el proceso del sistema
	 */
	int tiempoSalida;
	/**
	 * Rafaga inicial guardada ya que haremos setter de la rafaga<br>
	 * vendrá bien para hacer luego los cualculos de indice de penalización
	 */
	int rafagaInicial;
	
	
	/**
	 * CONSTRUCTOR
	 * @param miLetra, es la letra del proceso
	 * @param miTiempoLlegada , el tiempo de llegada del proceso
	 * @param miRafaga , tiempo que dura el proceso en el sistema
	 */
	public Proceso(String miLetra,int miTiempoLlegada, int miRafaga) {
		
		letra = miLetra;
		tiempoLlegada = miTiempoLlegada;
		rafaga = miRafaga;
		rafagaInicial = miRafaga;
		tiempoSalida = 0;
	}

	//RESTO COMPORTAMIENTOS
	
	public int getRafagaInicial() {
		return rafagaInicial;
	}

	public void setRafagaInicial(int rafagaInicial) {
		this.rafagaInicial = rafagaInicial;
	}
	/**
	 * Método que me crea la frase para imprimir por pantalla <br>
	 * con los atributos de la clase
	 */
	public String toString() {
		String linea;
		
		linea = "Proceso "+ letra + ", Rafagas restantes: " + rafaga;
		return linea;
	}

	public int getTiempoSalida() {
		return tiempoSalida;
	}

	public void setTiempoSalida(int tiempoSalida) {
		this.tiempoSalida = tiempoSalida;
	}

	public String getLetra() {
		return letra;
	}



	public void setLetra(String letra) {
		this.letra = letra;
	}



	public int getTiempoLlegada() {
		return tiempoLlegada;
	}



	public void setTiempoLlegada(int tiempoLlegada) {
		this.tiempoLlegada = tiempoLlegada;
	}



	public int getRafaga() {
		return rafaga;
	}



	public void setRafaga(int rafaga) {
		this.rafaga = rafaga;
	}
}
