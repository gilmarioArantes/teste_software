package tests.configuracoes.dominio;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dominio.PaginaDominioAlteracaoExclusao;
import pages.genericas.PaginaInicial;
import tests.DadosTesteGenerico;
import utils.InstanciaDriver;
import utils.Mensagem;

public class DominioAlteracaoTest extends InstanciaDriver {

    private PaginaInicial pi;
    private PaginaDominioAlteracaoExclusao pdae;
    private DadosTesteGenerico dtg;
    private DadosTestDominio dt;
    private boolean result;

    @BeforeMethod
    public void instanciaDependencias(){
        pi = new PaginaInicial(driver);
        pdae = new PaginaDominioAlteracaoExclusao(driver);
        dtg = new DadosTesteGenerico();
        dt = new DadosTestDominio();
        pi.abreMenu();
        try{
            pi.clicaMenu(dtg.getGrupoMenuConfiguracoes());
        }catch (InterruptedException ie){
            log.error("Erro ao abrir o menu", ie);
        }

    }

    @Test (priority = 0)
    public void AlteraNomeDominioTest() {
        try{
            pdae.alteraNomeDominio(dtg.getGrupoMenuConfiguracoes(), dt.getSubMenuDominio(), dt.getNomeDominioTesteAutomatizado(),
                    dt.getNomeDominioTesteAutomatizado(), dt.getNomeDominioTesteAutomatizadoAlterado());
            validaAlteracaoSucesso();
        }catch (InterruptedException ie){
            log.error("Erro ao alterar o nome do domínio", ie);
        }
    }

    @Test (priority = 1)
    public void ReverterAlteracaoNomeDominioTest() {
        try{
            pdae.alteraNomeDominio(dtg.getGrupoMenuConfiguracoes(), dt.getSubMenuDominio(), dt.getNomeDominioTesteAutomatizado(),
                dt.getNomeDominioTesteAutomatizadoAlterado(), dt.getNomeDominioTesteAutomatizado());
            validaAlteracaoSucesso();
        }catch (InterruptedException ie){
            log.error("Erro ao alterar o nome do domínio", ie);
        }
    }

    @Test (priority = 2)
    public void AlteraDescricaoDominioTest() {
        try{
            pdae.alteraDescricao(dtg.getGrupoMenuConfiguracoes(), dt.getSubMenuDominio(), dt.getNomeDominioTesteAutomatizado(),
                dt.getNomeDominioTesteAutomatizado(), dt.getDescricaoDominioTesteAutomatizado());
            validaAlteracaoSucesso();
        }catch (InterruptedException ie){
            log.error("Erro ao alterar a descrição do domínio", ie);
        }
    }

    @Test (priority = 3)
    public void ReverterAlteracaoDescricaoDominioTest() {
        try{
            pdae.alteraDescricao(dtg.getGrupoMenuConfiguracoes(), dt.getSubMenuDominio(), dt.getNomeDominioTesteAutomatizado(),
                dt.getNomeDominioTesteAutomatizado(), dt.getDescricaoDominioTesteAutomatizado());
            validaAlteracaoSucesso();
        }catch (InterruptedException ie){
            log.error("Erro ao alterar a descrição do domínio", ie);
        }
    }

    @Test (priority = 4)
    public void RemoveNomeDominioTest() {
        String nomeDominio = "";
        try{
            pdae.alteraNomeDominio(dtg.getGrupoMenuConfiguracoes(), dt.getSubMenuDominio(), dt.getNomeDominioTesteAutomatizado(),
                    dt.getNomeDominioTesteAutomatizado(), nomeDominio);
            validaAlteracaoErro();
        }catch (InterruptedException ie){
            log.error("Erro ao remover o nome do domínio", ie);
        }
    }

    @Test (priority = 5)
    public void RemoveDescricaoDominioTest() {
        String nomeDescricao = "";
        try{
            pdae.alteraDescricao(dtg.getGrupoMenuConfiguracoes(), dt.getSubMenuDominio(), dt.getNomeDominioTesteAutomatizado(),
                    dt.getNomeDominioTesteAutomatizado(), nomeDescricao);
            validaAlteracaoErro();
        }catch (InterruptedException ie){
            log.error("Erro ao remover a descrição do domínio", ie);
        }
    }

    @Test (priority = 6)
    public void AlteraEmailDominioTest() {
        try{
            pdae.alteraEmail(dtg.getGrupoMenuConfiguracoes(), dt.getSubMenuDominio(), dt.getNomeDominioTesteAutomatizado(),
                    dt.getNomeDominioTesteAutomatizado(), dt.getEmailDominioTesteAutomatizado());
            validaAlteracaoSucesso();
        }catch (InterruptedException ie){
            log.error("Erro ao alterar o email domínio", ie);
        }
    }

    @Test (priority = 7)
    public void ReverteAlteracaoEmailDominioTest() {
        try{
            pdae.alteraEmail(dtg.getGrupoMenuConfiguracoes(), dt.getSubMenuDominio(), dt.getNomeDominioTesteAutomatizado(),
                    dt.getNomeDominioTesteAutomatizado(), dt.getEmailDominioTesteAutomatizado());
            validaAlteracaoSucesso();
        }catch (InterruptedException ie){
            log.error("Erro ao alterar o email domínio", ie);
        }
    }

    private void validaAlteracaoSucesso() throws InterruptedException{
        result = pi.validaMensagemSucesso(Mensagem.getMensagemAlteracaoSucesso());
        Assert.assertTrue(result);
    }

    private void validaAlteracaoErro() throws InterruptedException{
        result = pi.validaMensagemErro(Mensagem.getMensagemErro());
        Assert.assertTrue(result);
    }
}

