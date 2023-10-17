



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lili;

/**
 *
 * @author 21698
 */
public class Voiture {
public String imatriculation;
	public int numVoiture ;
	public String modele;
	public String marque ;
        public int kilometrage ;
        public String age ;
        public String validitecarte ;
	public String categorie;
	public  String etat ;

public Voiture(String imatriculation ,int numVoiture, String modele, String marque, int kilometrage, String age,String validitecarte,String categorie,String etat)
 {
			super();
			this.imatriculation = imatriculation;
			this.numVoiture = numVoiture;
			this.modele = modele;
			this.marque = marque;
			this.kilometrage = kilometrage;
			this.age = age;
			this.validitecarte = validitecarte;
                        this.categorie = categorie;
                        this.etat = etat;
                        
   
}

    Voiture() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

public String getimatriculation() {
		return imatriculation;
	}
public void setimatriculation(String imatriculation) {
		this.imatriculation =imatriculation;
	}



public int getNumVoiture() {
		return numVoiture;
	}
public void setNumVoiture(int numVoiture) {
		this.numVoiture = numVoiture;
	}

public String getmoddele() {
		return modele;
	}
public void setmodele(String modele) {
		this.modele =modele;
	}

public String getmarque() {
		return marque;
	}
public void setmarque(String marque) {
		this.marque =marque;
	}

public int getkilometrage() {
		return kilometrage;
	}
public void setkilometrage(int kilometrage) {
		this.kilometrage =kilometrage;
	}

public String getage() {
		return age;
	}
public void setage(String age) {
		this.age =age;
	}


public String getvaliditecarte() {
		return validitecarte;
	}
public void setvaliditecarte(String validitecarte) {
		this.validitecarte =validitecarte;
	}

public String getcategorie() {
		return categorie;
	}
public void setcategorie(String categorie) {
		this.categorie =categorie;
	}


public String getetat() {
		return etat;
	}
public void setetat(String etat) {
		this.etat =etat;
	}

    /**
     *
     * @return
     */
    public String getImatriculation() {
        return imatriculation; 
    }   

    void setImatriculation(String nextLine) {
       this.imatriculation =imatriculation;
    }

    public String getMarque() {
        return marque;
    }

   void setMarque() {
        this.marque =marque;
    }


 public String getModele() {
        return modele;
    }

   void setModele() {
        this.modele =modele;
    }



    void setKilometrage(int nextInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
