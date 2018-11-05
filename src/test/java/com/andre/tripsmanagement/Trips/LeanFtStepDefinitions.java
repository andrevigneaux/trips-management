package com.andre.tripsmanagement.Trips;


import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.Link;
import com.hp.lft.sdk.web.LinkDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.hp.lft.verifications.Verify;

import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

public class LeanFtStepDefinitions {

	Browser browser;
    Button New;
    Button Create;  
    Button Delete;
    Button Edit;
    EditField Name;
    EditField Date;
    Link Página1; 
    Link Página0;
    String id;
    
    public LeanFtStepDefinitions() {}

    @Before("@trips")
    public void antes() throws GeneralLeanFtException{
    	browser = BrowserFactory.launch(BrowserType.CHROME);
   	 	browser.deleteCookies();
   	 	browser.navigate("http://localhost:8081/");
   	 	browser.sync();
    }
    
    @Cuando("^se hace clic en el botón de New$")
    public void se_hace_clic_en_el_botón_de_New() throws Throwable {
        New = browser.describe(Button.class, new ButtonDescription.Builder()
        		.buttonType("submit")
        		.name("New")
        		.tagName("BUTTON").build());
        New.click();
    }

    @Cuando("^se completen los campos en el formulario$")
    public void se_completen_los_campos_en_el_formulario() throws Throwable {
        Name = browser.describe(EditField.class, new EditFieldDescription.Builder()
        		.name("name")
        		.tagName("INPUT")
        		.type("text").build());
        Name.setValue("Prueba");
        Date = browser.describe(EditField.class, new EditFieldDescription.Builder()
        		.name("date")
        		.tagName("INPUT")
        		.type("date").build());
        Date.setValue("02112018");
    }

    @Cuando("^se haga clic en el botón Create$")
    public void se_haga_clic_en_el_botón_Create() throws Throwable {
        Create = browser.describe(Button.class, new ButtonDescription.Builder()
        		.buttonType("submit")
        		.name("Create")
        		.tagName("INPUT").build());
        Create.click();
    }

    //para simplificar el código se asume que se creará en la página 1
    @Entonces("^se creará un nuevo viaje con la información proporcionada$")
    public void se_creará_un_nuevo_viaje_con_la_información_proporcionada() throws Throwable {
        Página1 = browser.describe(Link.class, new LinkDescription.Builder()
        		.innerText("1")
        		.tagName("A").build());
        Página1.click();
        WebElement Prueba = browser.describe(WebElement.class, new WebElementDescription.Builder()
        		.innerText("Prueba")
        		.tagName("TD").build());
        Prueba.exists();
        WebElement Date = browser.describe(WebElement.class, new WebElementDescription.Builder()
        		.accessibilityName("")
        		.className("")
        		.index(1)
        		.innerText("02-11-2018")
        		.tagName("TD").build());
        Date.exists();
    }

    //borra el primer viaje que esté en la lista
    @Cuando("^se hace clic en el botón Delete de un viaje$")
    public void se_hace_clic_en_el_botón_Delete_de_un_viaje() throws Throwable {
    	Página0 = browser.describe(Link.class, new LinkDescription.Builder()
    			.innerText("0")
    			.tagName("A").build());
    	Página0.click();
    	id = browser.describe(WebElement.class, new WebElementDescription.Builder()
    			.cssSelector("html > body > div:nth-child(1) > div > div > table > tbody > tr:nth-child(1) > td:nth-child(1)")
    			.tagName("TD").build()).getInnerText();
    	Delete = browser.describe(Button.class, new ButtonDescription.Builder()
    			.absoluteLocation(new com.hp.lft.sdk.LocationProperty().setX(864).setY(222))
    			.buttonType("")
    			.index(0).build());
    	Delete.click();
    }

    @Entonces("^se eliminará el viaje de la lista$")
    public void se_eliminará_el_viaje_de_la_lista() throws Throwable {
    	String ident = browser.describe(WebElement.class, new WebElementDescription.Builder()
    			.cssSelector("html > body > div:nth-child(1) > div > div > table > tbody > tr:nth-child(1) > td:nth-child(1)")
    			.tagName("TD").build()).getInnerText();
    	Verify.areNotEqual(id, ident);
    }
/*
    //edita el primer viaje
    @Cuando("^se hace clic en el botón Edit de un viaje$")
    public void se_hace_clic_en_el_botón_Edit_de_un_viaje() throws Throwable {
        Edit = browser.describe(Button.class, new ButtonDescription.Builder()
        		.accessibilityName("")
        		.buttonType("")
        		.index(0)
        		.name("Edit")
        		.role("")
        		.tagName("A").build());
        Edit.click();
        throw new PendingException();
    }

    @Cuando("^se edite el Name$")
    public void se_edite_el_Name() throws Throwable {
    	Name = browser.describe(EditField.class, new EditFieldDescription.Builder()
        		.name("name")
        		.tagName("INPUT")
        		.type("text").build());
        Name.setValue("Test");
        throw new PendingException();
    }

    @Entonces("^al hacer clic en el botón Create se modificarán los cambios$")
    public void al_hacer_clic_en_el_botón_Create_se_modificarán_los_cambios() throws Throwable {
        Create = browser.describe(Button.class, new ButtonDescription.Builder()
        		.buttonType("submit")
        		.name("Create")
        		.tagName("INPUT").build());
        Create.click();
        
        throw new PendingException();
    }

    @Cuando("^se edite el Date$")
    public void se_edite_el_Date() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
    */
}