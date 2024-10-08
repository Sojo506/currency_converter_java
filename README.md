
# Currency Exchange Converter

This is a simple **Currency Exchange Converter** application that uses live exchange rates to convert between different currencies. It allows you to choose preset currency pairs or specify your own pair for conversion. The app also logs and displays the history of conversions.

## Features
- **Predefined Currency Conversions**: Convert between USD and currencies such as ARS, BRL, and COP.
- **Custom Currency Conversions**: Choose any two currencies to perform conversions.
- **Conversion History**: Track all your conversions during the session.
- **Dynamic Exchange Rates**: Uses the latest exchange rates from the ExchangeRate-API.

## Project Structure

### 1. **Main Class**
The entry point of the application. It retrieves live exchange rates from the API and starts the menu for the user to interact with.

```java
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Map<String, Double> rates = ExchangeRateClient.getCurrencyExchange().conversion_rates();
        
        // Initialize and start the Menu with live exchange rates
        Menu menu = new Menu(rates);
        menu.start();
    }
}
```

### 2. **Menu Class**
The `Menu` class manages the user interactions and choices. It displays the available options and calls the relevant conversion functions.

```java
public class Menu {
    private final ConversionService conversionService;
    private final InputHandler inputHandler;

    public Menu(Map<String, Double> rates) {
        this.conversionService = new ConversionService(rates);
        this.inputHandler = new InputHandler();
    }

    public void start() {
        // Contains the logic to display the menu, take user input, and handle the selected options.
    }
}
```

### 3. **ConversionService Class**
Handles all currency conversion logic and stores a history of conversions during the session.

- **performConversion**: Handles conversions for predefined currency pairs.
- **performCustomConversion**: Allows the user to input custom currency codes for conversion.
- **showConversionHistory**: Displays the history of conversions.

```java
public class ConversionService {
    private final Map<String, Double> rates;
    private final List<String> conversionHistory;

    public ConversionService(Map<String, Double> rates) {
        this.rates = rates;
        this.conversionHistory = new ArrayList<>();
    }

    public void performConversion(Scanner scanner, String fromCurrency, String toCurrency) {
        // Performs conversion between fixed currencies
    }

    public void performCustomConversion(Scanner scanner) {
        // Handles custom conversions based on user input
    }

    public void showConversionHistory() {
        // Displays the list of all previous conversions
    }
}
```

### 4. **InputHandler Class**
The `InputHandler` class is responsible for managing user input. It ensures that the user provides valid data when selecting options or entering amounts.

```java
public class InputHandler {
    public int getUserOption(Scanner scanner) {
        // Returns the option selected by the user
    }

    public static int getAmount(Scanner scanner) {
        // Prompts the user to enter the amount for conversion
    }
}
```

### 5. **ExchangeRateClient Class**
This class interacts with the **ExchangeRate-API** to retrieve live exchange rates. It provides two main methods:
- **getCurrencyExchange()**: Fetches the static exchange rates relative to USD.
- **getDynamicExchange()**: Retrieves the dynamic exchange rate for any two currencies and an amount.

```java
public class ExchangeRateClient {
    static Gson gson = GsonUtils.getGson();
    static String apiKey = "your-api-key";  // Use your own API key

    public static CurrencyApi getDynamicExchange(String fromCurrency, String toCurrency, double amount) {
        // Fetches the exchange rate for a specific currency pair and amount
    }

    public static ConversionRates getCurrencyExchange() throws IOException, InterruptedException {
        // Fetches the exchange rates for all currencies relative to USD
    }

    private static String fetchData(String url) {
        // Sends the HTTP request and retrieves the response as a string
    }
}
```

---

## Running the Project

### Prerequisites:
1. **Java 11+**: Ensure you have Java 11 or later installed on your machine.
2. **ExchangeRate-API Key**: You will need an API key from [ExchangeRate-API](https://www.exchangerate-api.com/) to retrieve live exchange rates.

### Steps to Run:
1. Clone the repository or download the project.
2. Open the project in your preferred IDE.
3. Replace the `apiKey` in the `ExchangeRateClient` class with your own from ExchangeRate-API.
4. Compile and run the `Main` class.

```bash
# Compile and run the project
javac Main.java
java Main
```

### Example API Response
```json
{
  "conversion_rates": {
    "USD": 1,
    "ARS": 367.5,
    "BRL": 4.95,
    "COP": 4250.75,
    // other currencies...
  }
}
```

---

## Future Improvements
- **Error Handling**: Add more sophisticated error handling to manage API issues or invalid input.
- **GUI**: Consider building a graphical user interface for a more user-friendly experience.
- **Unit Testing**: Implement tests for the different classes to ensure code reliability.

---

## License
This project is licensed under the MIT License.
