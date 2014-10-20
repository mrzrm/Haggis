package server;


public class Logik {
	
	public static MasterObject Kontrolle (MasterObject m){
		m.setPasst(false);
		System.out.println(m.getAmZug());
		
		if (m.amZug == 1){
			m.amZug = 0;
		}else{
			m.amZug = 1;
		}
		System.out.println(m.getAmZug());
		return m;
	}
}
