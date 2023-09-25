import java.util.Locale;
import java.util.Scanner;

/**
 * This file is the class of model in MVC structure.
 * We mainly have three methods to run the model: userEnterVerbAndCar() and resetValue().
 * "userEnterVerbAndCar()" would allow users to input car brand and action they want to do on the car brand.
 * In this function we allow user enter a text for ten consecutive times to get a correct text.
 * "resetValue()" would reset all values in Model class.
 */

public class Model {

    private String brand;
    private String verb;

    private boolean brandInSet;
    private boolean verbInSet;

    public void setBrandInSet(boolean brandInSet) {
        this.brandInSet = brandInSet;
    }

    public void setVerbInSet(boolean verbInSet) {
        this.verbInSet = verbInSet;
    }

    public boolean isBrandInSet() {
        return brandInSet;
    }

    public boolean isVerbInSet() {
        return verbInSet;
    }

    public Model() {
        // Initialize some flags
        brandInSet = false;
        verbInSet = false;
    }

    public String getBrand() {
        return brand;
    }

    public String getVerb() {
        return verb;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setVerb(String verb) { this.verb = verb; }

    public void userEnterVerbAndCarBrand() {
        Scanner scanner = new Scanner(System.in);
        String tempString = scanner.nextLine();

        // process user input string to delete extra backspace (make sure we just have one backspace between each word)
        String newString = tempString.replaceAll("(\b)+", "\b");
        String[] words = newString.split(" ");
        for (String word : words) {
            String temp = word.toUpperCase(Locale.ROOT);

            for (CarBrand carBrand : CarBrand.values()) {
                if (carBrand.name().equals(temp) && !brandInSet) {
                    brandInSet = true;
                    brand = temp;
                }
            }

            for (Verb curVerb : Verb.values()) {
                if (curVerb.name().equals(temp) && !verbInSet) {
                    verbInSet = true;
                    verb = temp;
                }
            }

            if (verbInSet && brandInSet) {
                break;
            }
        }
    }

    public void resetValue() {
        brand = "";
        verb = "";
        brandInSet = false;
        verbInSet = false;
    }

}
