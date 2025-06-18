package br.com.agenda.view;

import java.util.Scanner;
import br.com.agenda.model.Contato;
import br.com.agenda.model.ContatoDAO;

public class Main {
    public static void main(String[] args) {
        ContatoDAO contatoDAO = new ContatoDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n===== AGENDA DE CONTATOS =====");
            System.out.println("1 - Cadastrar Contato");
            System.out.println("2 - Listar Contatos");
            System.out.println("3 - Atualizar Contato");
            System.out.println("4 - Deletar Contato");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Cadastrar
                    System.out.print("Digite o nome do novo contato: ");
                    String nome = scanner.nextLine();
                    Contato novoContato = new Contato();
                    novoContato.setNomeContato(nome);
                    contatoDAO.save(novoContato);
                    break;
                case 2:
                    // Listar
                    System.out.println("\n--- Lista de Contatos ---");
                    for (Contato c : contatoDAO.getContatos()) {
                        System.out.println("ID: " + c.getIdContato() + " | Nome: " + c.getNomeContato());
                    }
                    break;
                case 3:
                    // Atualizar
                    System.out.print("Digite o ID do contato para atualizar: ");
                    int idUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    Contato contatoAtualizado = new Contato();
                    contatoAtualizado.setIdContato(idUpdate);
                    contatoAtualizado.setNomeContato(novoNome);
                    contatoDAO.update(contatoAtualizado);
                    System.out.println("Contato atualizado com sucesso!");
                    break;
                case 4:
                    // Deletar
                    System.out.print("Digite o ID do contato para deletar: ");
                    int idDelete = scanner.nextInt();
                    contatoDAO.deleteByID(idDelete);
                    System.out.println("Contato deletado com sucesso!");
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }
}