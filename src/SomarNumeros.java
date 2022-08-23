import java.util.Scanner;

class SomarNumeros {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);
        int a,b;

        System.out.println("Digite o primeiro numero: ");
        a = sc.nextInt();
        System.out.println("Digite o segundo numero: ");
        b = sc.nextInt();

        System.out.println("Soma: "+(a+b));

    }
}
