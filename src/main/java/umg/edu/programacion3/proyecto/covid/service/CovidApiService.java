package umg.edu.programacion3.proyecto.covid.service;

import lombok.extern.log4j.Log4j2;
import umg.edu.programacion3.proyecto.covid.util.CovidApiClient;

@Log4j2
public class CovidApiService {

    private final CovidApiClient client;

    public CovidApiService() {
        this.client = new CovidApiClient();
    }

    /**
     * Fetches regions, provinces and reports for Guatemala (GTM)
     * and logs the output. This simulates data processing.
     */
    public void fetchAndPersistCovidData() {
    try {
        System.out.println("Fetching regions...");
        String regions = client.getRegions();
        System.out.println("✅ Regions response: " + preview(regions));

        System.out.println("Fetching provinces...");
        String provinces = client.getProvinces("GTM");
        System.out.println("✅ Provinces response: " + preview(provinces));

        System.out.println("Fetching report...");
        String report = client.getReport("GTM", "2022-04-16");
        System.out.println("✅ Report response: " + preview(report));
    } catch (Exception e) {
        System.out.println("❌ ERROR: " + e.getMessage());
        e.printStackTrace();
    }
}


    private String preview(String json) {
        return json.length() > 200 ? json.substring(0, 200) + "..." : json;
    }
}
