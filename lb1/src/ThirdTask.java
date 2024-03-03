import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ThirdTask {
    ThirdTask() {
        try {
            String filePath = ".idea/planes.json";
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONArray planes = new JSONArray(content);

            for (int i = 0; i < planes.length(); i++) {
                JSONObject plane = planes.getJSONObject(i);

                int fuelCapacity = plane.getInt("fuelCapacity");
                int distanceAB = plane.getInt("distanceAB");
                int distanceBC = plane.getInt("distanceBC");
                int cargoWeight = plane.getInt("cargoWeight");

                System.out.println("Літак " + (i + 1) + ":");
                processFlight(fuelCapacity, distanceAB, distanceBC, cargoWeight);
            }

        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    private static void processFlight(int fuelCapacity, int distanceAB, int distanceBC, int cargoWeight) {
        int fuelPerKm = fuelConsumptionPerKm(cargoWeight);
        if (fuelPerKm == -1) {
            System.out.println("  Літак не може підняти вантаж.");
            return;
        }

        int totalFuelNeeded = (distanceAB + distanceBC) * fuelPerKm;

        int refuelNeeded = Math.max(0, totalFuelNeeded - fuelCapacity);

        System.out.println(refuelNeeded == 0 ? "  Дозаправка не потрібна" : "  Необхідно дозаправити " + refuelNeeded + " літрів палива.");
    }

    private static int fuelConsumptionPerKm(int weight) {
        if (weight <= 500) return 1;
        else if (weight <= 1000) return 4;
        else if (weight <= 1500) return 7;
        else if (weight <= 2000) return 9;
        else return -1;
    }
}
