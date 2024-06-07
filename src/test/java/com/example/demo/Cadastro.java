package com.example.demo;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Locale;


public class Cadastro {


        private WebDriver navegador;


        @BeforeEach
        public void setUp(){

            navegador = new ChromeDriver();
            navegador.manage().window().maximize();

            navegador.get("https://www.automationexercise.com/login");

        }
        //instaciando o Faker
        Faker faker = new Faker(new Locale("pt-BR"));

        @Test
        public void ChromeTest() {

            //preencher campo name
            navegador.findElement(By.cssSelector("[data-qa='signup-name']")).sendKeys(faker.name().fullName());

            //preencher campo e-mail
            navegador.findElement(By.cssSelector("[data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());

            //clicar no botão Signin
            navegador.findElement(By.cssSelector("[data-qa=signup-button]")).click();



            WebElement cadastro = navegador.findElement(By.id("form"));

            cadastro.findElement(By.id("id_gender1")).click();

            cadastro.findElement(By.id("password")).sendKeys(faker.number().digits(6));

            cadastro.findElement(By.xpath("//*[@id=\"days\"]/option[18]")).click();

            cadastro.findElement(By.xpath("//*[@id=\"months\"]/option[9]")).click();

            cadastro.findElement(By.xpath("//*[@id=\"years\"]/option[23]")).click();

            cadastro.findElement(By.id("newsletter")).click();

            cadastro.findElement(By.id("optin")).click();

            cadastro.findElement(By.id("first_name")).sendKeys(faker.name().firstName());

            cadastro.findElement(By.id("last_name")).sendKeys(faker.name().lastName());

            cadastro.findElement(By.id("address1")).sendKeys(faker.address().fullAddress());

            cadastro.findElement(By.xpath("//*[@id=\"country\"]/option[5]")).click();

            cadastro.findElement(By.id("state")).sendKeys(faker.address().state());

            cadastro.findElement(By.id("city")).sendKeys(faker.address().city());

            cadastro.findElement(By.id("zipcode")).sendKeys(faker.address().zipCode());

            cadastro.findElement(By.id("mobile_number")).sendKeys(faker.phoneNumber().phoneNumber());



           navegador.findElement(By.cssSelector("[data-qa=create-account]")).click();


        }
        @AfterEach
        public void tearDown(){
            navegador.quit();
        }
    }




