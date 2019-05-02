package pages.dominio;

import org.openqa.selenium.WebDriver;

public class PaginaDominioInclusao extends PaginaDominio {

    public PaginaDominioInclusao(WebDriver driver) {
        super(driver);
    }

    public void cadastrarDominio(String menu, String subMenu, String nome, String email, String descricao) throws InterruptedException{
            pi.clicaMenu(menu);
            pi.clicaMenu(subMenu);
            pc.clicaBotaoNovoItem();
            pi.setNome(nome);
            setEmail(email);
            pi.setDescricao(descricao);
            pi.salvar();
    }
}
