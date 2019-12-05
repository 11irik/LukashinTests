package ru.beru.dataProviders;

import org.testng.annotations.DataProvider;

public class ChangeCityTestDataProvider {
    @DataProvider(name = "data-provider")
    public static Object[][] dataProviderMethod() {
        return new Object[][]{ {"Саратов", "Хвалынск"}, {"Саратов", "Москва"}};
    }
}



