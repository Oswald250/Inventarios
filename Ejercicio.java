public class Ejercicio {

private double demandaAnual;
private double costoPedido;
private double costoMantenimiento;

public Ejercicio(double demandaAnual, double costoMantenimiento, double costoPedido){

this.demandaAnual = demandaAnual;
this.costoMantenimiento = costoMantenimiento;
this.costoPedido = costoPedido;

}


public double calcularCantidadOptima(){

return Math.sqrt((2 *demandaAnual * costoPedido)/costoMantenimiento);

}

public double calcularCostoTotal(double Q){
    return Math.sqrt((demandaAnual/Q) * costoPedido + (Q/2) * costoMantenimiento);
}


public double calcularTiempoEntreOrdes(double Q){
     return Q / demandaAnual;

}
    
public double calcularTiempoEntreOrdesEnDias(double Q){
   double tiempoAnios = calcularTiempoEntreOrdes(Q);
   return tiempoAnios * 350;

}


public double calcularNumeroOrdes(double Q){
    return demandaAnual / Q;


}

public static void main(String[] args) {
    
Ejercicio modelo = new Ejercicio(1000, 10, 5);

double Optimo = modelo.calcularCantidadOptima();
double Ctotal = modelo.calcularCostoTotal(Optimo);
double tiempoDias = modelo.calcularTiempoEntreOrdes(Optimo);
double numerOrdes = modelo.calcularTiempoEntreOrdesEnDias(Optimo);


System.out.println("====MODELO EOQ(OPERACION)====");
System.out.printf("Cantidad optima del pedido (Q*): %.2f unidades%n", Optimo );
System.out.printf("Costo total anual minimo: %.2f $.2f unidades $%n",Ctotal);
System.out.printf("Numero esperando de ordenes por año: %.2f%n",numerOrdes);
System.out.printf("Tiempo esperando entre ordenes: %.2f dias%n",tiempoDias);




}






}