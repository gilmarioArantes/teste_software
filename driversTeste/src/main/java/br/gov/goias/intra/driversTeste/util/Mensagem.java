package utils;

/**
 * Classe definido para encapsular a emissão de mensagens do sistema.
 */
public class Mensagem {

    private static final String mensagemLoginSucesso = "Login efetuado com sucesso.";
    private static final String mensagemLoginErro = "Erro ao Logar no Portal";
    private static final String mensagemInclusaoSucesso = "Sucesso! Inclusão realizada com sucesso.";
    private static final String mensagemAlteracaoSucesso = "Sucesso! Alteração realizada com sucesso.";
    private static final String mensagemExclusaoSucesso = "Sucesso! Exclusão realizada com sucesso.";
    private static final String mensagemErro = "Erro! Existem inconsistências.";

    public static String getMensagemElementoNaoEncontrado(String nomeElemento){
        return "O Elemento " + nomeElemento + " não foi encontrado!";
    }

    public static String getMensagemLoginSucesso(){
        return mensagemLoginSucesso;
    }

    public static String getMensagemLoginErro(){
        return mensagemLoginErro;
    }

    public static String getMensagemInclusaoSucesso(){
        return mensagemInclusaoSucesso;
    }

    public static String getMensagemAlteracaoSucesso(){
        return mensagemAlteracaoSucesso;
    }

    public static String getMensagemExclusaoSucesso(){
        return mensagemExclusaoSucesso;
    }

    public static String getMensagemErro(){
        return mensagemErro;
    }

}
