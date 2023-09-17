public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        while (!model.isQuitStatus()) {
            model.userEnterVerbAndCar();
            model.generateMessage();
            view.printMessage(model.getMessage());
            model.quit();
        }
    }


}
