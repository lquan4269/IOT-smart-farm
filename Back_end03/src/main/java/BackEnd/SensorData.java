package BackEnd;
import java.sql.Date;
public class SensorData {
	private int id;
	private String SensorKeyName;
	private String AttributeName;
	private String Value;
	private Date TimeAt;
	private int Assetid;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSensor() {
		return SensorKeyName;
	}

	public void setSensor(String SensorKeyName) {
		this.SensorKeyName = SensorKeyName;
	}

	public String getAttributeName() {
		return AttributeName;
	}

	public void setAttributeName(String AttributeName) {
		this.AttributeName = AttributeName;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String Value) {
		this.Value = Value;
	}

	public Date getTimeDate() {
		return TimeAt;
	}

	public void setTimeDate(Date TimeAt) {
		this.TimeAt = TimeAt;
	}

	public int getAssetid() {
		return Assetid;
	}

	public void setAssetid(int Assetid) {
		this.Assetid = Assetid;
	}

	public SensorData(int id, String SensorKeyName, String AttributeName, String Value, Date TimeAt, int Assetid) {
		super();
		this.id = id;
		this.SensorKeyName = SensorKeyName;
		this.AttributeName = AttributeName;
		this.Value = Value;
		this.TimeAt = TimeAt;
		this.Assetid = Assetid;
	}

	public SensorData() {
		
	}
	
}
