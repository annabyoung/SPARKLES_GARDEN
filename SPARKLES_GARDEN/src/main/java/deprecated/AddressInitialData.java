package deprecated;

import java.util.ArrayList;
import java.util.List;
import com.qac.sparkle_gardens.entities.Address;

/**
 * 
 * @author Tyler Deans
 * Dummy data for the address repository
 * 
 * deprecated in favour of InitialData (9/8/16)
 */
@Deprecated
public class AddressInitialData {
	private List<Address> addresses = new ArrayList<Address>();
	
	
	public AddressInitialData() {
		addresses.add(new Address(25, 1, "Anchorage 1", "Anchorage Quay", "Salford Quays", "England", "M50 3YJ"));
	}
	
	public ArrayList<Address> getAddresses() {
		return (ArrayList<Address>) addresses;
	}
	
	public void addAddress(Address address) {
		addresses.add(address);
	}
	
	public void setAddresses(List<Address> addresses) {
		this.addresses = (ArrayList<Address>) addresses;
	}
	
}


