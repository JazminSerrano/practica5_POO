import java.util.*;

public class Entrada{

    public static String capturarPIN(String msg){
        Scanner sc = new Scanner(System.in);
        String pin;
        do{
            System.out.print(""+msg+": ");
            pin = sc.nextLine();
            if(!Validacion.validarNuevoPIN(pin))
                System.out.print("Ingrese un PIN de 4 (cuatro) digitos\n");
        }while(!Validacion.validarNuevoPIN(pin));
        return pin;
    }
    public static boolean capturarPIN(String msg,String pin){
        int i=3;
        boolean bandera=false;
        String str;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(""+msg+": ");
            str = sc.nextLine();
            if(!Validacion.validarPIN(str,pin)){
                i--;
                System.out.print("El pin ingresado es incorrecto, quedan "+i+" intentos\n");
            }else
                bandera=true;
        }while( (!Validacion.validarPIN(str,pin))&&(i>0) );
        return bandera;
    }

    public static float capturarFlotante(String msg){
        Scanner sc = new Scanner(System.in);
        String flotante;
        do{
            System.out.print(""+msg+": ");
            flotante = sc.nextLine();
            if(!Validacion.validarDecimal(flotante))
                System.out.print("Ingrese una cantidad valida, sin letras ni signos\n");
        }while(!Validacion.validarDecimal(flotante));
        return Float.parseFloat(flotante);
    }
    public static String capturarCadena(String msg){
        Scanner sc = new Scanner(System.in);
        System.out.print(""+msg+": ");
        return (sc.nextLine());
    }

    public static String capturarSNMenu(String msg){
        String opcion="";
        do{
            opcion = capturarCadena(msg);
            if(!Validacion.validarConsonante(opcion))
                System.out.print("Ingrese una S para si y una N para no.\n");
        }while(!Validacion.validarConsonante(opcion));
        return opcion;
    }
    public static int capturarOpcionMenu(String msg,int numOp){
        String opcion="";
	    System.out.print(msg+"\n");
        do{
            opcion = capturarCadena("Opcion");
            if(!Validacion.validarEntero(opcion)||Integer.parseInt(opcion)>numOp)
                System.out.print("Ingrese una opcion numerica del menu.\n");
        }while(!Validacion.validarEntero(opcion)||Integer.parseInt(opcion)>numOp);
        return (Integer.parseInt(opcion));
    }
}
