package com.sure.ti;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DAO dao = new DAO();

    dao.conectar();

    dao.init();

    while (true) {
      System.out.println(
          "==== Menu ====\nOpções:\n0 - Inserir usuário\n1 - Mostrar usuários do sexo masculino\n2 - Mostrar usuários\n3 - Excluir usuário\nOutro - Sair");
      switch (sc.nextInt()) {
        case 0:
          Usuario usuario = new Usuario(11, "pablo", "pablo", 'M');
          if (dao.inserirUsuario(usuario) == true)
            System.out.println("Inserção com sucesso -> " + usuario.toString());
          continue;
        case 1:
          System.out.println("==== Mostrar usuários do sexo masculino === ");
          Usuario[] usuarios = dao.getUsuariosMasculinos();
          for (int i = 0; i < usuarios.length; i++)
            System.out.println(usuarios[i].toString());
          continue;
        case 2:
          System.out.println("==== Mostrar usuários === ");
          Usuario[] usuarios2 = dao.getUsuariosMasculinos();
          usuarios2 = dao.getUsuarios();
          for (int i = 0; i < usuarios2.length; i++)
            System.out.println(usuarios2[i].toString());
          continue;
        case 3:
          Usuario usuario3 = new Usuario(11, "", "", '\0');
          if (dao.excluirUsuario(usuario3.getCodigo()))
            System.out.println("Exclusão com sucesso -> " + usuario3.toString());
          continue;
        default:
          sc.close();
          dao.close();
          return;
      }
    }
  }
}
