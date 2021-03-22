package models;

import java.math.BigDecimal;
import java.util.Objects;

public class TauxDeChange {
	
	private String d1;
	private String d2;
	private BigDecimal taux;
	

	public TauxDeChange(String d1, String d2, BigDecimal taux) {
		super();
		this.d1 = d1;
		this.d2 = d2;
		this.taux = taux;
	}
	/**
	 * @return the d1
	 */
	public String getD1() {
		return d1;
	}
	/**
	 * @param d1 the d1 to set
	 */
	public void setD1(String d1) {
		this.d1 = d1;
	}
	/**
	 * @return the d2
	 */
	public String getD2() {
		return d2;
	}
	/**
	 * @param d2 the d2 to set
	 */
	public void setD2(String d2) {
		this.d2 = d2;
	}
	/**
	 * @return the taux
	 */
	public BigDecimal getTaux() {
		return taux;
	}
	/**
	 * @param taux the taux to set
	 */
	public void setTaux(BigDecimal taux) {
		this.taux = taux;
	}
	@Override
	public int hashCode() {
		return Objects.hash(d1, d2, taux);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TauxDeChange)) {
			return false;
		}
		TauxDeChange other = (TauxDeChange) obj;
		return Objects.equals(d1, other.d1) && Objects.equals(d2, other.d2) && Objects.equals(taux, other.taux);
	}
}
