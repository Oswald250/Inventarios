public class Ejercicio {

private double demandaAnual;
private double costoPedido;
private double costoMantenimiento;
private double descuento;
private double cantidadDescuento;
private int diasAnios;

public Ejercicio(double demandaAnual, double costoMantenimiento, double costoPedido, int diasAnios,
double descuento,double cantidadDescuento){

this.demandaAnual = demandaAnual;
this.costoMantenimiento = costoMantenimiento;
this.costoPedido = costoPedido;
this.descuento = descuento;
this.cantidadDescuento = cantidadDescuento;
this.diasAnios = diasAnios;

}


public double calcularCantidadOptima(){

return Math.sqrt((2 *demandaAnual * costoPedido)/costoMantenimiento);

}


public double calcularCostoTotal(double Q){
    double precio = Q >= cantidadDescuento ? 20*(1-descuento) : 20;
    return (demandaAnual/Q*costoPedido + (Q/2)*costoMantenimiento + demandaAnual*precio);
}


public double calcularTiempoEntreOrdes(double Q){
     return Q / demandaAnual;

}
    
public double calcularTiempoEntreOrdesEnDias(double Q){
   double tiempoAnios = calcularTiempoEntreOrdes(Q);
   return tiempoAnios * diasAnios;

}


public double calcularNumeroOrdes(double Q){
    return demandaAnual / Q;


}

public static void main(String[] args) {
    
Ejercicio modelo = new Ejercicio(1000, 5, 10,36,0.1,50);

double Optimo = modelo.calcularCantidadOptima();
double Ctotal = modelo.calcularCostoTotal(Optimo);
double tiempoDias = modelo.calcularTiempoEntreOrdesEnDias(Optimo);
double numerOrdes = modelo.calcularNumeroOrdes(Optimo);

double precioUnirario = Optimo >= modelo.cantidadDescuento ? modelo.descuento * 20 * (1 - modelo.descuento) :20;
double descuentoAplicado = 20 * modelo.demandaAnual - precioUnirario * modelo.demandaAnual;


System.out.println("====MODELO EOQ(OPERACION)====");
System.out.printf("Cantidad optima del pedido (Q*): %.0f unidades%n", Optimo );
System.out.printf("Costo total anual minimo: %.0f unidades $%n",Ctotal);
System.out.printf("Numero esperando de ordenes por año: %.0f%n",numerOrdes);
System.out.printf("Tiempo esperando entre ordenes: %.0f dias%n",tiempoDias);
System.out.printf("Descuento aplicado: %.0f $%n", descuentoAplicado);




}






}