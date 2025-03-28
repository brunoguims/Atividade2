package resposta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int codigo = 0;
        String nome = "";
        double valor = 0.0;
        int estoque = 0;
        boolean cadastrado = false;

        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Vender");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Exibir");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = input.nextInt();
            input.nextLine();

            if (opcao == 1) {
                System.out.println("\nCadastro:");
                System.out.print("Codigo: ");
                codigo = input.nextInt();
                input.nextLine();
                System.out.print("Nome: ");
                nome = input.nextLine();
                System.out.print("Valor: ");
                valor = input.nextDouble();
                System.out.print("Estoque: ");
                estoque = input.nextInt();
                cadastrado = true;
                System.out.println("Cadastrado!");
            } else if (opcao == 2) {
                if (cadastrado) {
                    System.out.println("\nVender:");
                    System.out.print("Quantidade: ");
                    int qtdVenda = input.nextInt();
                    if (qtdVenda > 0 && estoque >= qtdVenda) {
                        double total = valor * qtdVenda;
                        estoque -= qtdVenda;
                        System.out.println("Venda! Total: " + total);
                        pagamento(total, input);
                    } else {
                        System.out.println("Sem estoque ou qtdade invalida.");
                    }
                } else {
                    System.out.println("Cadastre antes.");
                }
            } else if (opcao == 3) {
                if (cadastrado) {
                    System.out.println("\nAdicionar:");
                    System.out.print("Quantidade: ");
                    int qtdAdd = input.nextInt();
                    if (qtdAdd > 0) {
                        estoque += qtdAdd;
                        System.out.println("Adicionado!");
                    } else {
                        System.out.println("Qtdade invalida.");
                    }
                } else {
                    System.out.println("Cadastre antes.");
                }
            } else if (opcao == 4) {
                if (cadastrado) {
                    System.out.println("\nEstoque:");
                    System.out.println("Codigo: " + codigo);
                    System.out.println("Nome: " + nome);
                    System.out.println("Valor: " + valor);
                    System.out.println("Estoque: " + estoque);
                } else {
                    System.out.println("Cadastre antes.");
                }
            } else if (opcao == 0) {
                System.out.println("Saindo.");
            } else {
                System.out.println("Invalido.");
            }

        } while (opcao != 0);

        input.close();
    }

    public static void pagamento(double valorTotal, Scanner input) {
        System.out.println("\nPagamento: " + valorTotal);
        System.out.println("1 - Pix/Especie/Transf/Deb (5% off)");
        System.out.println("2 - Credito (3x sem juros)");
        System.out.print("Forma: ");
        int forma = input.nextInt();

        if (forma == 1) {
            double finalValor = valorTotal * 0.95;
            System.out.println("Valor final: " + finalValor);
            System.out.print("Pago: ");
            double pago = input.nextDouble();
            if (pago >= finalValor) {
                if (forma == 2) {
                    System.out.println("Troco: " + (pago - finalValor));
                } else {
                    System.out.println("Pago!");
                }
            } else {
                System.out.println("Incompleto.");
            }
        } else if (forma == 2) {
            double parcela = valorTotal / 3;
            System.out.println("3 parcelas de: " + parcela);
            System.out.println("Pago!");
        } else {
            System.out.println("Invalida.");
        }
    }
}