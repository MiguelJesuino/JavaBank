import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nomeCliente = "Miguel";
        String tipoDeConta = "Corrente";
        double saldo = 5000.00;
        int opc = 0;

        Scanner input = new Scanner(System.in);

        String informacoesDaConta = String.format(
                "*".repeat(40) +
                        "\nDados iniciais do cliente:\n\n" +
                        "Nome:           %s\n" +
                        "Tipo conta:     %s\n" +
                        "Saldo inicial:  R$ %,.2f\n" +
                        "*".repeat(40),
                nomeCliente, tipoDeConta, saldo
        );

        String menu = """
                
                Operações
                
                1 - Consultar Saldo
                2 - Depositar Valor
                3 - Transferir Valor
                4 - Sair
                """;

        System.out.println(informacoesDaConta);

        while (opc != 4) {
            System.out.println(menu);
            System.out.print("Escolha uma opção: ");

            opc = input.nextInt();

            switch (opc) {
                case 1 -> System.out.printf("Seu saldo atual é de: R$ %,.2f%n", saldo);
                case 2 -> {
                    System.out.print("Quanto deseja depositar? R$ ");
                    double valorDeposito = input.nextDouble();
                    saldo += valorDeposito;
                    System.out.printf("Depósito realizado! Saldo atual: R$ %,.2f%n", saldo);
                }
                case 3 -> {
                    System.out.print("Quanto deseja transferir? R$ ");
                    double valorTransferencia = input.nextDouble();
                    if (valorTransferencia > saldo) {
                        System.out.println("Saldo insuficiente para realizar a transferência.");
                    } else {
                        saldo -= valorTransferencia;
                        System.out.printf("Transferência realizada! Saldo atual: R$ %,.2f%n", saldo);
                    }
                }
                case 4 -> System.out.println("Encerrando o programa. Obrigado!");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        input.close();
    }
}