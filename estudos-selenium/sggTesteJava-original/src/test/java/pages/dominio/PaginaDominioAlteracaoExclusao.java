package pages.dominio;

import org.openqa.selenium.WebDriver;
import pages.genericas.PaginaConfirmacaoExclusao;

public class PaginaDominioAlteracaoExclusao extends PaginaDominio {

    public PaginaDominioAlteracaoExclusao(WebDriver driver){
        super(driver);
    }

    public void alteraNomeDominio(String menu, String subMenu, String nomeDominio, String nomeAtual, String novoNome) throws InterruptedException{
        pi.clicaMenu(menu);
        pi.clicaMenu(subMenu);
        pc.consultaIndividualParaAlteracaoExclusao(subMenu, nomeDominio, nomeAtual);
        pae.alteraNome(novoNome);
    }

    public void alteraDescricao(String menu, String subMenu, String nomeDominio, String nome, String descricao)throws InterruptedException{
        pi.clicaMenu(menu);
        pi.clicaMenu(subMenu);
        pc.consultaIndividualParaAlteracaoExclusao(subMenu, nomeDominio, nome);
        pae.alteraDescricao(descricao);
    }

    public void alteraEmail(String menu, String subMenu, String nomeDominio, String nome, String email) throws InterruptedException{
        pi.clicaMenu(menu);
        pi.clicaMenu(subMenu);
        pc.consultaIndividualParaAlteracaoExclusao(subMenu, nomeDominio, nome);
        setEmail(email);
        pi.salvar();
    }

    public void excluirDominio(String menu, String subMenu, String nomeDominio) throws InterruptedException{
        pi.clicaMenu(menu);
        pi.clicaMenu(subMenu);
        pc.consultaIndividualParaAlteracaoExclusao(subMenu, nomeDominio, nomeDominio);
        pae.excluir();
    }

    public Boolean RN01(String menu, String subMenu, String nomeDominio, String mensagemErro) throws InterruptedException{
        excluirDominio(menu, subMenu, nomeDominio);
        return new PaginaConfirmacaoExclusao(driver).validaMensagemErro(mensagemErro);
    }


}
