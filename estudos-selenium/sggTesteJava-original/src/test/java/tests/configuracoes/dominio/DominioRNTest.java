package tests.configuracoes.dominio;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dominio.PaginaDominio;
import pages.dominio.PaginaDominioAlteracaoExclusao;
import pages.genericas.PaginaInicial;
import tests.DadosTesteGenerico;
import tests.TesteGenerico;
import utils.InstanciaDriver;

public class DominioRNTest extends InstanciaDriver {

    private PaginaInicial pi;
    private PaginaDominio pd;
    private PaginaDominioAlteracaoExclusao pdae;
    private DadosTesteGenerico dtg;
    private DadosTestDominio dtd;
    String mensagemErro;
    boolean result;

    @BeforeMethod
    public void instanciaDependencias() {
        pi = new PaginaInicial(driver);
        pd = new PaginaDominio(driver);
        pdae = new PaginaDominioAlteracaoExclusao(driver);
        dtg = new DadosTesteGenerico();
        dtd = new DadosTestDominio();
        mensagemErro = "Domínio não pode ser excluído";
        pi.abreMenu();
        try{
            pi.clicaMenu(dtg.getGrupoMenuConfiguracoes());
        }catch(InterruptedException ie){
            log.error("Erro ao abrir o menu", ie);
        }

    }

    @Test
    public void DominioRN01Test(){
        try{
            result = pdae.RN01(dtg.getGrupoMenuConfiguracoes(), dtd.getSubMenuDominio(), dtd.getNomeDominioTesteAutomatizado(), mensagemErro);
        }catch (InterruptedException ie){
            log.error("Erro ao Testar a RN01 de Domínio", ie);
        }

        Assert.assertTrue(result);
    }

    @Test
    public void DominioRN02Test() {
        try{
            result = pdae.RN01(dtg.getGrupoMenuConfiguracoes(), dtd.getSubMenuDominio(), dtd.getNomeDominioTesteAutomatizado(), mensagemErro);
        }catch (InterruptedException ie){
            log.error("Erro ao Testar a RN02 de Domínio", ie);
        }

        Assert.assertTrue(result);
    }

    @Test
    public void UsuarioGestorGeralProgramaTest(){
        result = pd.RN03(dtg.getGrupoMenuCadastros());
        Assert.assertFalse(result);
    }
}

