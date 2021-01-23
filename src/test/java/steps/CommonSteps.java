package steps;

import io.cucumber.java.en.Given;
import service.constants.Constant;
import service.utils.PropertyUtils;
import service.utils.RestUtils;

public class CommonSteps extends RestUtils {
    @Given("^set the base URI$")
    public void set_the_base_URI() {
        setBaseURI();
    }
}
