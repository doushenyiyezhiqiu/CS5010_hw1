import java.util.Locale;
import java.util.Scanner;

/**
 * The class "Controller" will mix class Model and class View to make sure the whole application could run.
 * "run()" is the most significant function in this class. We allow user enter the text for ten times to get the correct text.
 * "quit()" will ask users whether they want to quit or they want to continue the game.
 * "transmitData()" would transmit data from Model to View.
 */

public class Controller {
    private Model model;
    private View view;
    private boolean quitStatus;

    public Controller() {
        // initialize the quit flag
        quitStatus = false;
    }

    public void setQuitStatus(boolean quitStatus) {
        this.quitStatus = quitStatus;
    }

    public View getView() {
        return view;
    }

    public void setModel(Model model) { this.model = model; }

    public Model getModel() {
        return model;
    }

    public void setView(View view) {
        this.view = view;
    }

    public boolean isQuitStatus() {
        return quitStatus;
    }

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.welcomeMessage();

        while (!quitStatus) {
            // We allow user enter wrong text for ten consecutive times
            int count = 0;
            while (count < 10) {
                view.showMessage();
                model.userEnterVerbAndCarBrand();

                if (model.isBrandInSet() && model.isBrandInSet()) {
                    break;
                } else {
                    count++;
                    model.resetValue();
                    view.errorMessage();
                }
            }
            transmitData();
            view.generateMessage();

            // reset the value of model and view
            model.resetValue();
            view.resetValue();
            quit();
        }
    }

    private void quit() {
        System.out.println("Do you want to quit now?(y/n)");
        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        res = res.toLowerCase(Locale.ROOT);
        if (res.equals("y")) {
            quitStatus = true;
        }
    }

    private void transmitData() {
        view.setBrandInSet(model.isBrandInSet());
        view.setVerbInSet(model.isVerbInSet());
        view.setBrand(model.getBrand());
        view.setVerb(model.getVerb());
    }

}
