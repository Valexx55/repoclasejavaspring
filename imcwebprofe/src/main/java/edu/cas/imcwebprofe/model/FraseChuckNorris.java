package edu.cas.imcwebprofe.model;

/**
 * Clase que representa la información recibida del api 
 * https://api.chucknorris.io/jokes/random
 * @author valer
 *
 */

/**
 * {
    "categories": [],
    "created_at": "2020-01-05 13:42:23.880601",
    "icon_url": "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
    "id": "leVttLieQhasdDL5U20Dng",
    "updated_at": "2020-01-05 13:42:23.880601",
    "url": "https://api.chucknorris.io/jokes/leVttLieQhasdDL5U20Dng",
    "value": "Chuck Norris can live on the dark Side of the moon............naked"
}*/
 

public class FraseChuckNorris {
	
	public final static String URL_CHUCK_NORRIS = "https://api.chucknorris.io/jokes/random";
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public FraseChuckNorris(String value) {
		super();
		this.value = value;
	}
	
	public FraseChuckNorris() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
