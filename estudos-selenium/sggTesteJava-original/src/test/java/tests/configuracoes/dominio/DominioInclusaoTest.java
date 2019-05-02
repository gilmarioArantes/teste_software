package tests.configuracoes.dominio;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dominio.PaginaDominioInclusao;
import pages.genericas.PaginaInicial;
import tests.DadosTesteGenerico;
import utils.InstanciaDriver;
import utils.Mensagem;

public class DominioInclusaoTest extends InstanciaDriver {

    @Test
    public void CriarUmDominioTest() {
        PaginaInicial pi = new PaginaInicial(driver);
        PaginaDominioInclusao pdi = new PaginaDominioInclusao(driver);
        DadosTesteGenerico dtg = new DadosTesteGenerico();
        DadosTestDominio dtd = new DadosTestDominio();
        try{
            pdi.cadastrarDominio(dtg.getGrupoMenuConfiguracoes(), dtd.getSubMenuDominio(), dtd.getNomeDominioTesteAutomatizado(),
                    dtd.getEmailDominioTesteAutomatizado(), dtd.getDescricaoDominioTesteAutomatizado());
            boolean result = pi.validaMensagemSucesso(Mensagem.getMensagemInclusaoSucesso());
            Assert.assertTrue(result);
        }catch (InterruptedException ie){
            log.error("Erro ao cadastrar um domínio!");
        }
    }
}

