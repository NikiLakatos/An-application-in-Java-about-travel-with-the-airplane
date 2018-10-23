import java.util.TreeMap;

public class CompaniiAeriene {
	
	public String numeCompanie;
	public int nrPasageri;
	public int pretBilete;
	public String plecare;
	public String sosire;
	public String data;
	public String ora;
	public String ora2;
	public int locriDisponibil;
	
	public CompaniiAeriene() {}

	
	private static TreeMap<String, CompaniiAeriene> companii = new TreeMap<String, CompaniiAeriene>();
	
	
	public TreeMap<String, CompaniiAeriene> getCompanii() {
		return companii;
	}


	public void add(CompaniiAeriene companie) {
		companii.put(companie.getNume(), companie);
	}

	public void remove(String numeCompanie)
	{
		companii.remove(numeCompanie);
	}
	
	
	public String getNume() {
		return numeCompanie;
	}
	CompaniiAeriene(String numeCompanie,int nrPasageri,int pretBilete,String plecare,String sosire,String data,String ora,String ora2,int locuriDisponibile)
	{
		this.numeCompanie = numeCompanie;
		this.nrPasageri = nrPasageri;
		this.pretBilete = pretBilete;
		this.plecare = plecare;
		this.sosire = sosire;
		this.data = data;
		this.ora = ora;
		this.ora2 = ora2;
		this.locriDisponibil = locuriDisponibile;
	}

	
	public String toString()
	{
		return "<html>Companie: " + this.numeCompanie + "<br>Nr Pasageri: " + this.nrPasageri + "<br>Pret_Bilet:" + 
				this.pretBilete + " Euro<br>Plecare:" + this.plecare + "<br>Sosire:" + this.sosire + "<br>Data:" 
				+ this.data + "<br>Ora_Decolare:" + this.ora + "<br>Ora_Aterizare:" 
				+ this.ora2 +  "<br>Locuri Disponibile:" + this.locriDisponibil + "</html>";
	}

}
