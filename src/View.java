import java.util.Locale;

/**
 * The class "View" contains all methods we want to display to the user.
 * "WelcomeMessage()" will print welcome message when user begin the game.
 * "showMessage()" will display the information users need to know before they enter the text
 * "errorMessage()" will display alert if users do not enter correct text
 * "generateMessage()" will generate the result and display on the screen to users
 * "quitMessage()" provide users an option to quit the game
 * "resetValue()" will reset all values in View class
 */

public class View {

    private String verb;
    private String brand;

    private boolean brandInSet;
    private boolean verbInSet;

    public void setVerb(String verb) { this.verb = verb; }

    public void setBrand(String brand) { this.brand = brand; }

    public void setBrandInSet(boolean brandInSet) { this.brandInSet = brandInSet; }

    public void setVerbInSet(boolean verbInSet) { this.verbInSet = verbInSet; }

    public String getVerb() { return verb; }

    public String getBrand() { return brand; }

    public boolean isBrandInSet() { return brandInSet; }

    public boolean isVerbInSet() { return verbInSet; }

    public void generateMessage() {
        if (!brandInSet || !verbInSet) System.out.println("You always cannot enter a correct word and verb, now the game is angry and he wants to stop the game now!");
        else if (brand.equals("BMW") && verb.equals("BUY")) System.out.println("Bmw fancy!!!");
        else if (brand.equals("TOYOTA") && verb.equals("RENT")) System.out.println("Please be careful!");
        else if (brand.equals("BUGATTI") && verb.equals("DRIVE")) System.out.println("So fast, so cool!!!");
        else if (brand.equals("TESLA") && verb.equals("HIT")) System.out.println("Why did you do that, tesla will not work!");
        else if (brand.equals("NISSAN") && verb.equals("STEAL")) System.out.println("Easy to steal!");
        else if (brand.equals("BENZ") && verb.equals("SELL")) System.out.println("How mercy!");
        else if (brand.equals("LAMBORGHINI") && verb.equals("TRY")) System.out.println("Just enjoy!");
        else if (brand.equals("FERRARI") && verb.equals("BUY")) System.out.println("Congrats! You get a F1 champion car!");
        else System.out.println("You want to " + verb.toLowerCase(Locale.ROOT) + " the " + brand + ".");
    }

    public void showMessage() {
        System.out.println("You can select one car brand from the following brand list:");
        System.out.println("audi, benz, bmw, bugatti, cadillac, chevrolet, ferrari, fiat, ford, honda, kia, lamborghini, maserati, nissan, porsche, subaru, tesla, toyota");
        System.out.println("You can select one verb from the following verb list:");
        System.out.println("buy, drive, hit, rent, sell, steal, try");
        System.out.println("Please enter a car brand and a verb (only first entered verb and brand will be considered):");
    }

    public void errorMessage() {
        System.out.println("Please enter a correct verb and car brand.");
        System.out.println("");
    }

    public void welcomeMessage() {
        System.out.println("Welcome to the car game!");
    }

    public void quitMessage() { System.out.println("Do you want to quit now?(y/n)"); }

    public void resetValue() {
        brand = "";
        verb = "";
        brandInSet = false;
        verbInSet = false;
    }

}
