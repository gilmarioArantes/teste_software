package alfa.br.com.gilmario;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by gilmario on 17/03/17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty","html:reports/test-report"}
//    ,tags= "@smokeTest"
    ,glue={"alfa.br.com.gilmario"}
    ,features= {"src/test/resources/avaliacao.feature"}
)
public class CucumberRunner {
}
