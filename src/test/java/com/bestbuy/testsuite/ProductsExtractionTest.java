package com.bestbuy.testsuite;

import com.bestbuy.testbase.TestBase;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest extends TestBase {

    static ValidatableResponse response;

    @BeforeClass
    public static void response() {
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
        response.log().all();
    }

    //21. Extract the limit
    @Test
    public void test021(){
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //22. Extract the total
    @Test
    public void test022() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }
    //23. Extract the name of 5th product
    @Test
    public void test023(){
        String name = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th product is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //24. Extract the names of all the products
    @Test
    public void test024(){
        List<String> allProduct = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all product is : " + allProduct);
        System.out.println("------------------End of Test---------------------------");

    }

    //25. Extract the productId of all the products
    @Test
    public void test025(){
        List<?> productId = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The id of all product is : " + productId);
        System.out.println("------------------End of Test---------------------------");
    }

    //26. Print the size of the data list
    @Test
    public void test026(){
        List<String> sizeOfData = response.extract().path("data");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of all data is : " + sizeOfData.size());
        System.out.println("------------------End of Test---------------------------");
    }
    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test027(){
        List<HashMap<String, ?>> value = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values for store is: " + value);
        System.out.println("------------------End of Test---------------------------");
    }
    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test028(){
        List<HashMap<String, ?>> value = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The model is: " + value);
        System.out.println("------------------End of Test---------------------------");
    }
    //29. Get all the categories of 8th products
    @Test
    public void test029(){
        List<String> allCategories = response.extract().path("data[7].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories is : " + allCategories.size());
        System.out.println("------------------End of Test---------------------------");
    }
    //30. Get categories of the store where product id = 150115
    @Test
    public void test030() {
        List<?> categories = response.extract().path("data[2].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product id  is: " + categories);
        System.out.println("------------------End of Test---------------------------");
    }
    //31. Get all the descriptions of all the products
    @Test
    public void test031(){
        List<?> description = response.extract().path("data.description");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Description of all products is: " + description);
        System.out.println("------------------End of Test---------------------------");
    }
    //32. Get id of all the all categories of all the products
    @Test
    public void test032(){
        List<?> id = response.extract().path("data.categories.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The id of all categories of all products is: " + id);
        System.out.println("------------------End of Test---------------------------");
    }

    //33. Find the product names Where type = HardGood
    @Test
    public void test033(){
        String productName = response.extract().path("data[0].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product names Where type is HardGood : " + productName);
        System.out.println("------------------End of Test---------------------------");
    }
    //34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test034(){
        List<Integer> numberOfCategories = response.extract().path("data[1].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories for the product is : " + numberOfCategories.size());
        System.out.println("------------------End of Test---------------------------");
    }
    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test035() {
        List<String> createdAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all products whose price < 5.49 : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }
    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
    @Test
    public void test036(){
        List<Integer> numberOfCategories = response.extract().path("data[3].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories for the product is : " + numberOfCategories.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //37. Find the manufacturer of all the products
    @Test
    public void test037(){
        List<String> manufacturer = response.extract().path("data.manufacturer");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The manufacture the product is : " + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }
    //38. Find the image of products whose manufacturer is = Energizer
    @Test
    public void test038(){
        String image = response.extract().path("data[3].image");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The image is : " + image);
        System.out.println("------------------End of Test---------------------------");
    }

    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test039(){
        List<String> createdAt = response.extract().path("data.findAll{it.price < 5.99}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all products whose price < 5.99 : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //40. Find the uri of all the products
    @Test
    public void test040(){
        List<?> url = response.extract().path("data.url");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The url of all products is : " + url);
        System.out.println("------------------End of Test---------------------------");
    }

}
