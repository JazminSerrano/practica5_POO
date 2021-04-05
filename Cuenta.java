import java.util.*;

public class Cuenta{
    private String nomTitular,numCuenta,pin;
    private float saldo;

    public Cuenta(){}
    public Cuenta(String nomTitular,String pin){
        setNomTitular(nomTitular);
        setSaldo(0);
        setPIN(pin);
        setNumCuenta();
    }

    public void setNomTitular(String nomTitular){
        this.nomTitular=nomTitular;
    }
    public void setSaldo(float saldo){
        this.saldo=saldo;
    }
    public void setPIN(String pin){
        this.pin=pin;
    }
    public void setNumCuenta(){
        Random gen = new Random();
        numCuenta="";
        for(int i=0;i<8;i++)
            numCuenta+=Integer.toString(gen.nextInt(10));
    }

    public String getNomTitular(){
        return nomTitular;
    }
    public float getSaldo(){
        return saldo;
    }
    public String getPIN(){
        return pin;
    }
    public String getNumCuenta(){
        return numCuenta;
    }
}
