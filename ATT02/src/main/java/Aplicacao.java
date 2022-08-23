import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) throws Exception {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("1) Inserir\n2) Listar\n3) Atualizar\n4) Excluir\n5) Sair");
            String opc = sc.nextLine();

            if(opc.equals("1")){

                String nome,senha;
                char sexo;
                System.out.println("Digite o Nome de Usuário: ");
                nome = sc.nextLine();
                System.out.println("Digite a primeira letra do seu Sexo: ");
                sexo = sc.nextLine().charAt(0);
                System.out.println("Digite a Senha: ");
                senha = sc.nextLine();

                List<Usuario> aux = usuarioDAO.getOrderByCodigo();

                Usuario usuario = new Usuario(aux.get(aux.size()-1).getCodigo()+1,nome,senha,sexo);
                if(usuarioDAO.insert(usuario)){
                    System.out.println("Item Inserido com Sucesso !!!!");
                }

            } else if(opc.equals("2")){
                List<Usuario> usuarios = usuarioDAO.getOrderByCodigo();
                for (Usuario u : usuarios) {

                    System.out.println("Código: "+u.getCodigo()+" Sexo: "+u.getSexo()+" Login: "+u.getLogin()+" Senha: "+u.getSenha());

                }
            } else if(opc.equals("3")){
                System.out.println("Digite o Código do item a ser Editado: ");
                int cod = Integer.parseInt(sc.nextLine());

                Usuario usuario = usuarioDAO.get(cod);
                System.out.println("Código: "+usuario.getCodigo()+" Sexo: "+usuario.getSexo()+" Login: "+usuario.getLogin()+" Senha: "+usuario.getSenha());

                String nome,senha;
                char sexo;
                System.out.println("Digite o novo Nome de Usuário: ");
                nome = sc.nextLine();
                System.out.println("Digite a nova primeira letra do seu Sexo: ");
                sexo = sc.nextLine().charAt(0);
                System.out.println("Digite a nova Senha: ");
                senha = sc.nextLine();

                usuario.setLogin(nome);
                usuario.setSexo(sexo);
                usuario.setSenha(senha);

                if(usuarioDAO.update(usuario)){
                    System.out.println("Item Editado com Sucesso !!!");
                }

            } else if(opc.equals("4")){
                System.out.println("Digite o Código do item a ser Excluido: ");
                int cod = Integer.parseInt(sc.nextLine());

                if(usuarioDAO.delete(cod)){
                    System.out.println("Item Excluido com Sucesso !!!");
                }
            } else {
                break;
            }

        }

    }
}