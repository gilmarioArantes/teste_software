package br.gov.goias.intra.driversTeste.util;

/**
 * Classe definido para encapsular a emissão de mensagens do sistema.
 */
public class Mensagem {

    public static final String APLICACAO_PORTAL             = "Erro ao obter informação se a aplicação consta do portal.";
    public static final String ARQUIVO_NAO_ENCONTRADO       = "Não foi possível localizar o arquivo informado.";
    public static final String CARGA_ARQUIVO_PROPRIEDADES   = "Não foi possível carregar o arquivo de propriedades.";
    public static final String INSTANCIA_DRIVER             = "Erro ao instanciar o driver.";
    public static final String LOGIN_PORTAL                 = "Erro ao logar no portal.";
    public static final String LINK_APLICACAO_PORTAL        = "Link da Aplicação não encontrado na página inicial do portal!";
    public static final String MENSAGEM_LOGIN_SUCESSO       = "Login efetuado com sucesso.";
    public static final String MENSAGEM_LOGIN_ERRO          = "Erro ao Logar no Portal";
    public static final String MENSAGEM_INCLUSAO_SUCESSO    = "Sucesso! Inclusão realizada com sucesso.";
    public static final String MENSAGEM_ALTERACAO_SUCESSO   = "Sucesso! Alteração realizada com sucesso.";
    public static final String MENSAGEM_EXCLUSAO_SUCESSO    = "Sucesso! Exclusão realizada com sucesso.";
    public static final String MENSAGEM_ERRO                = "Erro! Existem inconsistências.";
    public static final String NAVEGADOR                    = "Erro ao obter o navegador.";
    public static final String NOME_CAMPO_USUARIO           = "Elemento [usuário/login], não encontrado pelo nome informado!";
    public static final String NOME_CAMPO_SENHA             = "Elemento [senha/password], não encontrado pelo nome informado!";
    public static final String NOME_SISTEMA                 = "Nome do Sistema não Encontrado.";
    public static final String SENHA_PORTAL                 = "Erro ao obter a senha do usuário do portal.";
    public static final String URL_APLICACAO                = "Erro ao obter URL da Aplicação.";
    public static final String URL_DRIVER                   = "Erro ao obter URL do Selenium Web Driver.";
    public static final String USUARIO_PORTAL               = "Erro ao obter o usuário do Portal.";
    public static final String WEB_ELEMENT                  = "Elemento Web não encontrado.";

    public static String getMensagemElementoNaoEncontrado(String nomeElemento){
        return "O Elemento " + nomeElemento + " não foi encontrado!";
    }

}
