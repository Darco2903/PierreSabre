package histoire;

import personnages.Commercant;
import personnages.Humain;
import personnages.Ronin;
import personnages.Samourai;
import personnages.Yakuza;

public class HistoireTP5 {
	public static void main(String[] args) {
		
		Commercant marco = new Commercant("Marco", 20);
//		Commercant chonin = new Commercant("Chonin", 40);
//		Commercant kumi = new Commercant("Kumi", 10);
//		Yakuza yaku = new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong");
//		Ronin roro = new Ronin("Roro", "shochu", 60);
//		
//		marco.faireConnaissance(roro);
//		marco.faireConnaissance(yaku);
//		marco.faireConnaissance(chonin);
//		marco.faireConnaissance(kumi);
//		marco.listerConnaissance();
//		roro.listerConnaissance();
//		yaku.listerConnaissance();
		
		Samourai akimoto = new Samourai("Miyamoto", "Akimoto", "saké", 80);
		akimoto.faireConnaissance(marco);
		akimoto.listerConnaissance();
		marco.boire();
		akimoto.boire("thé");
	}
}
