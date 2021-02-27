import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.time.LocalDateTime; 

public class ParseJSON {
    static String json = "...";
    public static void main(String[] args) {
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();

        String pageName = jsonObject.getAsJsonObject("pageInfo").get("pageName").getAsString();
        //System.out.println(pageName);

        JsonArray arr = jsonObject.getAsJsonArray("posts");
        for (int i = 0; i < arr.size(); i++) {
            String post_id = arr.get(i).getAsJsonObject().get("post_id").getAsString();
            System.out.println(post_id);
        }
    }
}

public class Slot {
	boolean state;
	LocalDateTime last_up;
	String city;
	String neigh;
	String parking;
	Int slot_id;
	Double longitude;
	Double latitude;

	public boolean getState() { return state;}
	public void setState(boolean state) { this.state = state;}

	public LocalDateTime getLastUp() { return last_up;}
	public void setLastUp(LocalDateTime last_up) { this.last_up = last_up;}

	public String getCity() { return city;}
	public void setCity(String city) { this.city = city;}

	public String getNeigh() { return neigh;}
	public void setNeigh(String neigh) { this.neigh = neigh;}

	public String getParking() { return parking;}
	public void setParking(String parking) { this.parking = parking;}

	public Int getSlot() { return slot_id;}
	public void setSlot(Int slot_id) { this.slot_id = slot_id;}

	public Double getSlot() { return longitude;}
	public void setSlot(Double longitude) { this.longitude = longitude;}

	public Double getSlot() { return latitude;}
	public void setSlot(Double latitude) { this.latitude = latitude;}
}
