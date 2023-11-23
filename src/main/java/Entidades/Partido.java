package Entidades;

import java.util.List;

public class Partido {

	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;
	
	public Partido() {}
	
	//MEOTODOS SETs Y GETs
	public Equipo getEquipo1() { return equipo1; }
	public Equipo getEquipo2() { return equipo2; }
	public int getGolesEquipo1() { return golesEquipo1; }
	public int getGolesEquipo2() { return golesEquipo2 ; }
	public void setEquipo1(Equipo equipo1) { this.equipo1 = equipo1; }
    public void setEquipo2(Equipo equipo2) { this.equipo2 = equipo2; }
    public void setGolesEquipo1(int golesEquipo1) { this.golesEquipo1 = golesEquipo1; }
    public void setGolesEquipo2(int golesEquipo2) { this.golesEquipo2 = golesEquipo2; }	

	public ResultadoEnum ganoEmpatoOPerdioElEquipo1(List<Partido> goles){
		   
		for (Partido partido : goles) {
			
			if (partido.getEquipo1().equals(this.equipo1)) {
				if (this.getGolesEquipo1() == this.getGolesEquipo2())
					return ResultadoEnum.Empate;
				else if (this.getGolesEquipo1() > this.getGolesEquipo2())
					return ResultadoEnum.Ganador;
				else 
					return ResultadoEnum.Perdedor;
			}
			else if (partido.getEquipo2().equals(this.equipo2)) {
				if (this.getGolesEquipo1() == this.getGolesEquipo2())
					return ResultadoEnum.Empate;
				else if (this.getGolesEquipo1() > this.getGolesEquipo2())
					return ResultadoEnum.Perdedor;
				else 
					return ResultadoEnum.Ganador;
			}
						
		}
		return ResultadoEnum.Empate;
	}
}
