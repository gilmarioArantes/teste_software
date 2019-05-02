package tests.configuracoes.dominio;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dominio.PaginaDominioAlteracaoExclusao;
import pages.genericas.PaginaInicial;
import tests.DadosTesteGenerico;
import utils.InstanciaDriver;
import utils.Mensagem;

public class DominioExclusaoTest extends InstanciaDriver {


    @Test
    public void ExcluirUmDominioTest()
    {
        PaginaInicial pi = new PaginaInicial(driver);
        PaginaDominioAlteracaoExclusao pdae = new PaginaDominioAlteracaoExclusao(driver);
        DadosTesteGenerico dtg = new DadosTesteGenerico();
        DadosTestDominio dtd = new DadosTestDominio();
        pi.abreMenu();
        try{
            pi.clicaMenu(dtg.getGrupoMenuConfiguracoes());
            pdae.excluirDominio(dtg.getGrupoMenuConfiguracoes(), dtd.getSubMenuDominio(), dtd.getNomeDominioTesteAutomatizado());
            boolean result = pi.validaMensagemSucesso(Mensagem.getMensagemExclusaoSucesso());
            Assert.assertTrue(result);
        }catch (InterruptedException ie){
            log.error("Erro ao excluir um domínio", ie);
        }
    }
}
