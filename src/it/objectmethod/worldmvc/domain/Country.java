package it.objectmethod.worldmvc.domain;

public class Country {

	private String codiceNazione;
	private String nomeNazione;
	private String continente;
	private int popolazione;
	private int estensioneGeografica;

	public String getCodiceNazione() {
		return codiceNazione;
	}

	public void setCodiceNazione(String codiceNazione) {
		this.codiceNazione = codiceNazione;
	}

	public String getNomeNazione() {
		return nomeNazione;
	}

	public void setNomeNazione(String nomeNazione) {
		this.nomeNazione = nomeNazione;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public int getPopolazione() {
		return popolazione;
	}

	public void setPopolazione(int popolazione) {
		this.popolazione = popolazione;
	}

	public int getEstensioneGeografica() {
		return estensioneGeografica;
	}

	public void setEstensioneGeografica(int estensioneGeografica) {
		this.estensioneGeografica = estensioneGeografica;
	}

}
