public class Validacion{
    public static boolean validarNuevoPIN(String str){
        return str != null && str.matches("\\d{4}");
    }
    public static boolean validarPIN(String str,String pin){
        return str != null && str.equals(pin);
    }
    public static boolean validarEntero(String str){
        return str != null && str.matches("[-+]?\\d+");
    }
    public static boolean validarDecimal(String str){
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }
    public static boolean validarConsonante(String str){
        return str != null && str.matches("[SN]{1}");
    }
}
