package tests;

import pages.genericas.PaginaAlteracaoExclusao;
import pages.genericas.PaginaConsulta;
import pages.genericas.PaginaInclusao;
import utils.InstanciaDriver;

public class TesteGenerico extends InstanciaDriver {

    protected PaginaAlteracaoExclusao pae;
    protected PaginaConsulta pc;
    protected PaginaInclusao pinc;
    protected Boolean result;


    public TesteGenerico() {
        super();
        pae = new PaginaAlteracaoExclusao(driver);
        pc = new PaginaConsulta(driver);
        pinc = new PaginaInclusao(driver);
    }
    /*
        public Boolean RN01(String Menu, String SubMenu) {
            pinc.clicaMenu(Menu);
            pinc.clicaMenu(SubMenu);
            return pc.validaCampoDominioPreenchidoUnicoAcesso();
        }

        public Boolean RN02(String Menu, String SubMenu) {
            pinc.clicaMenu(Menu);
            pinc.clicaMenu(SubMenu);
            return pc.ValidaCampoDominioPreenchidoVariosAcessos();
        }
    */
    public Boolean RN04(String Menu, String SubMenu, String nomeDominio, String nomeObjeto) throws InterruptedException{
        pinc.clicaMenu(Menu);
        pinc.clicaMenu(SubMenu);
        pc.consultaIndividualParaAlteracaoExclusao(SubMenu, nomeDominio, nomeObjeto);
        return pae.validaCampoDominioHabilitado();
    }

    public Boolean RN05(String nomeFuncionalidade) {
        return pinc.validaUsuarioSemPerfilAcessoFuncionalidade(nomeFuncionalidade);
    }

    public Boolean ValidaUsuarioSemAcessoDominio(String Menu, String SubMenu) throws InterruptedException{
        return pinc.validaUsuarioSemAcessoDominio(Menu, SubMenu);
    }


}
