/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex.p3_s7_grupo14;

/**
 *
 * @author sd
 */
import java.util.ArrayList;
import java.util.Scanner;

public class TeatroMoro {


    private static double totalIngresos = 0;
    private static int totalEntradasVendidas = 0;

   
    private ArrayList<String> ubicaciones = new ArrayList<>();
    private ArrayList<Double> costosFinales = new ArrayList<>();
    private ArrayList<Double> descuentosAplicados = new ArrayList<>();

    public static void main(String[] args) {
        TeatroMoro teatro = new TeatroMoro();
        teatro.menu();
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Venta de entradas");
            System.out.println("2. Visualizar resumen de ventas");
            System.out.println("3. Generar boleta");
            System.out.println("4. Calcular Ingresos Totales");
            System.out.println("5. Salir del programa");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ventaEntradas();
                    break;
                case 2:
                    visualizarResumenVentas();
                    break;
                case 3:
                    generarBoleta();
                    break;
                case 4:
                    calcularIngresosTotales();
                    break;
                case 5:
                    System.out.println("Gracias por su compra.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void ventaEntradas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ubicaciones disponibles: VIP, Platea, Balcón");
        System.out.print("Ingrese la ubicación deseada: ");
        String ubicacion = sc.nextLine();

        double precioBase;
        switch (ubicacion.toLowerCase()) {
            case "vip":
                precioBase = 4500;
                break;
            case "platea":
                precioBase = 3500;
                break;
            case "balcón":
                precioBase = 2000;
                break;
            default:
                System.out.println("Ubicación inválida.");
                return;
        }

        System.out.print("¿Es estudiante? (Sí/No): ");
        boolean esEstudiante = sc.nextLine().equalsIgnoreCase("sí");

        System.out.print("¿Es persona de la tercera edad? (Sí/No): ");
        boolean esTerceraEdad = sc.nextLine().equalsIgnoreCase("sí");

        double descuento = 0.0;
        if (esEstudiante) {
            descuento = 0.10;
        } else if (esTerceraEdad) {
            descuento = 0.15;
        }

        double costoFinal = precioBase * (1 - descuento);
        ubicaciones.add(ubicacion);
        costosFinales.add(costoFinal);
        descuentosAplicados.add(descuento);

        totalIngresos += costoFinal;
        totalEntradasVendidas++;

        System.out.println("Venta realizada con éxito.");
    }

    private void visualizarResumenVentas() {
        System.out.println("Resumen de ventas:");
        for (int i = 0; i < ubicaciones.size(); i++) {
            System.out.println("Ubicación: " + ubicaciones.get(i) + ", Costo final: " + costosFinales.get(i) + ", Descuento aplicado: " + (descuentosAplicados.get(i) * 100) + "%");
        }
    }

    private void generarBoleta() {
        System.out.println("Boleta:");
        for (int i = 0; i < ubicaciones.size(); i++) {
            System.out.println("Ubicación: " + ubicaciones.get(i));
            System.out.println("Costo base: " + (costosFinales.get(i) / (1 - descuentosAplicados.get(i))));
            System.out.println("Descuento aplicado: " + (descuentosAplicados.get(i) * 100) + "%");
            System.out.println("Costo final: " + costosFinales.get(i));
            System.out.println("Gracias por su compra.");
        }
    }

    private void calcularIngresosTotales() {
        System.out.println("Ingresos totales acumulados: " + totalIngresos);
    }
}
