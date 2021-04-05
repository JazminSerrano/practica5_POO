public class Banco{
    public static void crearCuenta(Cuenta[] cuentas){
        int i=0;
        boolean bandera=true;
        do{
            if(cuentas[i].getNomTitular()==null){
                bandera=false;
                cuentas[i] = new Cuenta( Entrada.capturarCadena("\nNombre del Titular"),Entrada.capturarPIN("Nuevo PIN") );
            }else
                i++;
        }while((i<10)&&bandera);
        if(bandera)
            System.out.print("Lo lamentamos pero el banco ha alcanzado su limite de capacidad para administrar cuentas de ahorro :(\n");
        else
            System.out.print("La cuenta "+cuentas[i].getNumCuenta()+" ha sido registrada a nombre de "+cuentas[i].getNomTitular()+" con un saldo actual de $"+cuentas[i].getSaldo()+" MXN\n");
    }

    public static void accederCuenta(Cuenta[] cuentas){
        int i=0,opcion;
        boolean bandera=true;
        String cuenta = Entrada.capturarCadena("\nIngresa el nombre del titular o numero de cuenta");
        do{
            if(cuenta.equalsIgnoreCase(cuentas[i].getNomTitular())){
                bandera=false;
            }else
                if(cuenta.equals(cuentas[i].getNumCuenta())){
                    bandera=false;
                }else
                    i++;
        }while((i<10)&&bandera);
        if(bandera)
            System.out.print("No se encontro la cuenta :(");
        else{
            System.out.print("Titular "+cuentas[i].getNomTitular()+"\nCuenta "+cuentas[i].getNumCuenta()+"\n");
            if(Entrada.capturarPIN("PIN",cuentas[i].getPIN()))
                do{
                    opcion = Entrada.capturarOpcionMenu("\n1.Depositar\n2.Retirar\n0.Salir",2);
                    switch(opcion){
                    case 1:
                        cuentas[i].setSaldo( (cuentas[i].getSaldo()+depositarCuenta()) );
                        System.out.print("\nSaldo Actual\n$"+cuentas[i].getSaldo()+" MXN\n");
                        break;
                    case 2:

                        cuentas[i].setSaldo( retirarCuenta(cuentas[i].getSaldo()) );
                        System.out.print("\nSaldo Actual\n$"+cuentas[i].getSaldo()+" MXN\n");
                        break;
                    }
                }while(opcion!=0);
        }
    }

    public static float depositarCuenta(){
        float depositar = Entrada.capturarFlotante("Cantidad a depositar");
        float deposito = Entrada.capturarFlotante("Ingrese el dinero");
        do{
            if(deposito<depositar){
                System.out.print("Faltan $"+(depositar-deposito)+" MXN\n");
                deposito += Entrada.capturarFlotante("Ingrese el dinero");
            }else
                if(deposito>depositar){
                    System.out.print("Ha ingresado una cantidad mayor, recoja el cambio de $"+(deposito-depositar)+" MXN en la bandeja");
                    deposito-=(deposito-depositar);
                }
        }while(deposito!=depositar);
        System.out.print("\nUsted ha depositado "+deposito);
        return deposito;
    }

    public static float retirarCuenta(float saldo){
        String opcion;
        float retiro;
        do{
            retiro = Entrada.capturarFlotante("Ingrese cantidad a retirar");
            if(retiro>saldo){
                System.out.print("No posee saldo suficiente\nSu saldo es de $"+saldo+" MXN\n");
                opcion="N";
            }else{
                opcion = Entrada.capturarSNMenu(("Desea retirar $"+retiro+" MXN? (S/N)"));
                if(opcion.matches("[S]{1}"))
                    System.out.print("Usted ha retirado $"+retiro+" MXN");
            }
        }while(opcion.matches("[N]{1}"));
        return retiro;
    }

    public static void main(String args[]){
        int opcion;
        Cuenta[] cuentas = new Cuenta[10];
        for(int i=0;i<10;i++)
            cuentas[i] = new Cuenta();
        do{
            System.out.println("\n======Banco El Trasquilado======");
            opcion = Entrada.capturarOpcionMenu("1. Crear Cuenta de Ahorros\n2. Acceder a una Cuenta\n0. Salir",2);
            switch(opcion){
            case 1:
                crearCuenta(cuentas);
                break;
            case 2:
                accederCuenta(cuentas);
                break;
            }
        }while(opcion!=0);
	}
}
