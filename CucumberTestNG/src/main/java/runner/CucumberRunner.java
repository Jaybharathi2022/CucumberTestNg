package runner;

import hooks.BaseClass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/features", 
					glue = { "steps", "hooks" }, 
					monochrome = true, publish = true,
					tags="@Sanity"
					)
public class CucumberRunner extends BaseClass {

}
