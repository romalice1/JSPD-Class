package adapter;

public interface UpdateAuto {
	public void UpdateOptionSetName(String autoKey, String oldOptionSetName, String newOptionSetName);
	public void UpdateOptionPrice(String autoKey, String optionSetName, String optionName, double newPrice);
}
