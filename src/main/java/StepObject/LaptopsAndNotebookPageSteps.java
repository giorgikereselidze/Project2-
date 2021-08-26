package StepObject;

import PageObjects.LaptopsAndNotebooksPage;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class LaptopsAndNotebookPageSteps {
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();

    @Step("Select sorting option high to low price")
    public LaptopsAndNotebookPageSteps SelectHighToLowSortOption(){
        laptopsAndNotebooksPage.SortByBtn.selectOptionByValue("http://tutorialsninja.com/demo/index.php?route=product/category&path=18&sort=p.price&order=DESC");
        return this;
    }
    @Step("Sorting functional check")
    public LaptopsAndNotebookPageSteps CheckThatSortingWorks(){
        ElementsCollection highToLowPrices = $$(By.xpath("//span[@class='price-tax']"));

        List<String> list = new ArrayList<String>();
        list.add(highToLowPrices.get(0).toString().replaceAll("[^0-9]", ""));
        list.add(highToLowPrices.get(1).toString().replaceAll("[^0-9]", ""));
        list.add(highToLowPrices.get(2).toString().replaceAll("[^0-9]", ""));
        list.add(highToLowPrices.get(3).toString().replaceAll("[^0-9]", ""));
        list.add(highToLowPrices.get(4).toString().replaceAll("[^0-9]", ""));

//        Collections.reverse(list);
        System.out.println(list);

        List<String> sortedList = new ArrayList<String>(list);

//        Collections.sort(sortedList);

        Assert.assertEquals(list,sortedList);
        System.out.println(sortedList);


        return this;
    }

}
