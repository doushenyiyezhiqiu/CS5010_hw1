import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

/**
 * This file is the class of model in MVC structure.
 * We mainly have two methods to run the whole application: userEnterVerbAndCar() and generateMessage().
 * "userEnterVerbAndCar()" would allow users to input the car brand they want to operate on and the action they want to do through terminal.
 * "generateMessage()" would generate messages the game reply to the users.
 * We also have quit function which will ask user whether he wants to quit the game.
 *
 */

public class Model {
    Set<String> carSet = new HashSet<>();
    Set<String> verbSet = new HashSet<>();

    private String noun;
    private String verb;

    private boolean carInSet;
    private boolean verbInSet;
    private boolean quitStatus;

    public void setQuitStatus(boolean quitStatus) {
        this.quitStatus = quitStatus;
    }

    public boolean isQuitStatus() {
        return quitStatus;
    }

    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() { return message;}

    public void setCarInSet(boolean carInSet) {
        this.carInSet = carInSet;
    }

    public void setVerbInSet(boolean verbInSet) {
        this.verbInSet = verbInSet;
    }

    public boolean isCarInSet() {
        return carInSet;
    }

    public boolean isVerbInSet() {
        return verbInSet;
    }

    public Model() {
        // Initialize some flags
        carInSet = false;
        verbInSet = false;
        quitStatus = false;

        // Initialize carSet
        carSet.add("bmw");
        carSet.add("benz");
        carSet.add("toyota");
        carSet.add("nissan");
        carSet.add("audi");
        carSet.add("porsche");
        carSet.add("honda");
        carSet.add("tesla");
        carSet.add("kia");
        carSet.add("subaru");
        carSet.add("ford");
        carSet.add("chevrolet");
        carSet.add("maserati");
        carSet.add("ferrari");
        carSet.add("lamborghini");
        carSet.add("bugatti");
        carSet.add("cadillac");

        // Initialize verbSet
        verbSet.add("drive");
        verbSet.add("buy");
        verbSet.add("sell");
        verbSet.add("try");
        verbSet.add("rent");
        verbSet.add("hit");
        verbSet.add("steal");

    }

    public String getNoun() {
        return noun;
    }

    public String getVerb() {
        return verb;
    }

    public void setNoun(String noun) {
        this.noun = noun;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public void userEnterVerbAndCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the car game!");

        // let user enter a car brand they want to play
        int count = 0;
        while (count < 10) {
            System.out.println("Please enter a car brand from the following list (not case sensitive):");
            System.out.println("audi, benz, bmw, bugatti, cadillac, chevrolet, ferrari, ford, honda, kia, lamborghini, maserati, nissan, porsche, subaru, tesla, toyota");
            String tempNoun = scanner.nextLine();
            tempNoun = tempNoun.toLowerCase(Locale.ROOT);
            if (!carSet.contains(tempNoun)) {
                System.out.println("Sorry, the car brand you enter are not in our car list, please enter a new car brand~~~");
                count++;
            } else {
                noun = tempNoun;
                carInSet = true;
                break;
            }
        }

        if (!carInSet) {
            return;
        }

        // let user enter a verb they want to operate on the car
        count = 0;
        while (count < 10) {
            System.out.println("Please enter a verb you want to operate on the car from the following list (not case sensitive):");
            System.out.println("buy, drive, hit, rent, sell, steal, try");
            String tempVerb = scanner.nextLine();
            tempVerb = tempVerb.toLowerCase(Locale.ROOT);
            if (!verbSet.contains(tempVerb)) {
                System.out.println("Sorry, the verb you enter are not in our verb list, please enter a new verb~~~");
                count++;
            } else {
                verb = tempVerb;
                verbInSet = true;
                break;
            }
        }
    }

    public void generateMessage() {
        if (!carInSet || !verbInSet) message = "You always cannot enter a correct word and verb, now the game is angry and he wants to stop the game now!";
        else if (noun.equals("bmw") && verb.equals("buy")) message = "Bmw fancy!!!";
        else if (noun.equals("toyota") && verb.equals("rent")) message = "Please be careful!";
        else if (noun.equals("bugatti") && verb.equals("drive")) message = "So fast, so cool!!!";
        else if (noun.equals("tesla") && verb.equals("hit")) message = "Why did you do that, tesla will not work!";
        else if (noun.equals("nissan") && verb.equals("steal")) message = "Easy to steal!";
        else if (noun.equals("benz") && verb.equals("sell")) message = "How mercy!";
        else if (noun.equals("lamborghini") && verb.equals("try")) message = "Just enjoy!";
        else if (noun.equals("ferrari") && verb.equals("buy")) message = "Congrats! You get a F1 champion car!";
        else message = "You want to " + verb + " the " + noun + ".";
    }

    public void quit() {
        System.out.println("Do you want to quit now?(y/n)");
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        res = res.toLowerCase(Locale.ROOT);
        if (res.equals("y")) {
            quitStatus = true;
        }
    }
}
