package TemperatureConvertor;

public class TemperatureConvertorImp implements TemperatureConvertor {
    @Override
    public String convertTemperature(float temperature, char unit) {
        try {
            return convert(temperature, unit);
        } catch (Exception e) {
            return "Error !";
        }
    }

    private String convert(float temperature, char unit){
        String ans = "";

        switch (unit) {
            case 'C':
                ans = convertFromCelsius(temperature);
                break;
            case 'F':
                ans = convertFromFahrenheit(temperature);
                break;
            case 'K':
                ans = convertFromKelvin(temperature);
            default:
                break;
        }

        return ans;
    }
    
    private String convertFromCelsius(float temperature){
        float kelvinTemp = convertCelsiusToKelvin(temperature);
        float fahrenheitTemp = convertCelsiusToFahrenheit(temperature);
        return temperatureWriter(temperature, 'C') + " = " + temperatureWriter(kelvinTemp, 'K') + " and " + temperatureWriter(fahrenheitTemp, 'F');
    }

    private float convertCelsiusToKelvin(float temperature){
        return (float) (temperature + 273.15);
    }

    private float convertCelsiusToFahrenheit(float temperature){
        return (float) (temperature * (9.0/5.0) + 32);
    }

    private String temperatureWriter(float temperatue, char unit){
        char DEGREESYMBOL = '\u00B0';
        return temperatue + " " + DEGREESYMBOL + unit; 
    }

    private String convertFromFahrenheit(float temperature){
        float celsiusTemp = convertFahrenheitToCelsius(temperature);
        float kelvinTemp = convertFahrenheitToKelvin(temperature);
        return temperatureWriter(temperature, 'F') + " = " + temperatureWriter(celsiusTemp, 'C') + " and " + temperatureWriter(kelvinTemp, 'K');
    }

    private float convertFahrenheitToCelsius(float temperature){
        return (float) ((temperature - 32) * (5.0/9.0));
    }

    private float convertFahrenheitToKelvin(float temperature){
        return (float) ((temperature + 459.67) * (5.0/9.0));
    }

    private String convertFromKelvin(float temperature){
        float celsiusTemp = convertKelvenToCelsius(temperature);
        float fahrenheitTemp = convertKelvenToFahrenheit(temperature);
        return temperatureWriter(temperature, 'K') + " = " + temperatureWriter(celsiusTemp, 'C') + " and " + temperatureWriter(fahrenheitTemp, 'F'); 
    }

    private float convertKelvenToCelsius(float temperature){
        return (float) (temperature - 273.15);
    }

    private float convertKelvenToFahrenheit(float temperature){
        return (float) (temperature * (9.0/5.0) - 459.67);
    }

}
