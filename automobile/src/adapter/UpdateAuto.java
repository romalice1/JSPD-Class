package adapter;

public interface UpdateAuto {
	public void updateOptionSetName(String autoKey, String oldOptionSetName, String newOptionSetName);
	public void updateOptionPrice(String autoKey, String optionSetName, String optionName, double newPrice);
}
