import GUI.AppWindow;
import TemperatureConvertor.TemperatureConvertorImp;

public class App {
    public static void main(String[] args) throws Exception {
        AppWindow appWindow = new AppWindow();
        appWindow.showWindow(new TemperatureConvertorImp());
    }
}
