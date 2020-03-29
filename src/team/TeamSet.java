package team;

import unit.base.*;
import unit.captain.Henderson;
import unit.captain.Kane;
import unit.captain.Mcguire;
import unit.captain.Silva;

import java.util.ArrayList;

import unit.Attacker;
import unit.BoxToBox;
import unit.Captain;
import unit.Defender;
import unit.Goalkeeper;
import unit.God;
import unit.Playmaker;

public class TeamSet {
	
	static Captain liverpoolCaptain = new Henderson();
	static Attacker liverpoolAttacker1 = new Attacker("Sadio Mane");
	static Attacker liverpoolAttacker2 = new Attacker("Alex Oxlade-Chamberlane");
	static Attacker liverpoolAttacker3 = new Attacker("Mohammed Salah");
	static BoxToBox liverpoolBoxToBox1 = new BoxToBox("Georginio Wijnaldum");
	static BoxToBox liverpoolBoxToBox2 = new BoxToBox("Adam Lallana");
	static BoxToBox liverpoolBoxToBox3 = new BoxToBox("Fabinho");
	static Defender liverpoolDefender1 = new Defender("Dejan Lovren");
	static Defender liverpoolDefender2 = new Defender("Virgil Van Dijk");
	static Playmaker liverpoolPlaymaker = new Playmaker("Roberto Firmino");
	static Goalkeeper liverpoolGoalkeeper1 = new Goalkeeper("Alisson Becker");
	static Goalkeeper liverpoolGoalkeeper2 = new Goalkeeper("Adrian");
	static God liverpoolGod = new God("Divock Origi");
	
	
	static Captain manUnitedCaptain = new Mcguire();
	static Attacker manUnitedAttacker1 = new Attacker("Daniel James");
	static Attacker manUnitedAttacker2 = new Attacker("Anthony Martial");
	static Attacker manUnitedAttacker3 = new Attacker("Marcus Rashford");
	static BoxToBox manUnitedBoxToBox1 = new BoxToBox("Frederico Rodrigues");
	static BoxToBox manUnitedBoxToBox2 = new BoxToBox("Paul Pogba");
	static BoxToBox manUnitedBoxToBox3 = new BoxToBox("Scott Mctominay");
	static Defender manUnitedDefender1 = new Defender("Victor Lindelof");
	static Defender manUnitedDefender2 = new Defender("Phil Jones");
	static Playmaker manUnitedPlaymaker = new Playmaker("Bruno Fernandes");
	static Goalkeeper manUnitedGoalkeeper1 = new Goalkeeper("Sergio Romero");
	static Goalkeeper manUnitedGoalkeeper2 = new Goalkeeper("David De Gea");
	static God manUnitedGod = new God("Jesse Lingard");
	
	
	static Captain manCityCaptain = new Silva();
	static Attacker manCityAttacker1 = new Attacker("Sergio Aguero");
	static Attacker manCityAttacker2 = new Attacker("Riyad Mahrez");
	static Attacker manCityAttacker3 = new Attacker("Leroy Sane");
	static BoxToBox manCityBoxToBox1 = new BoxToBox("Fernandinho");
	static BoxToBox manCityBoxToBox2 = new BoxToBox("Ilkay Gundogan");
	static BoxToBox manCityBoxToBox3 = new BoxToBox("Bernado Silva");
	static Defender manCityDefender1 = new Defender("Nicolas Otamendi");
	static Defender manCityDefender2 = new Defender("Aymeric Laporte");
	static Playmaker manCityPlaymaker = new Playmaker("Kevin De Bruyne");
	static Goalkeeper manCityGoalkeeper1 = new Goalkeeper("Ederson");
	static Goalkeeper manCityGoalkeeper2 = new Goalkeeper("Claudio Bravo");
	static God manCityGod = new God("Raheam Sterling");
	
	
	static Captain spurCaptain = new Kane();
	static Attacker spurAttacker1 = new Attacker("Lucas Moura");
	static Attacker spurAttacker2 = new Attacker("Steven Bergwijn");
	static Attacker spurAttacker3 = new Attacker("Son Heung Min");
	static BoxToBox spurBoxToBox1 = new BoxToBox("Erik Lamela");
	static BoxToBox spurBoxToBox2 = new BoxToBox("Eric Dier");
	static BoxToBox spurBoxToBox3 = new BoxToBox("Victor Wanyama");
	static Defender spurDefender1 = new Defender("Jan Vertonghen");
	static Defender spurDefender2 = new Defender("Toby Alderweireld");
	static Playmaker spurPlaymaker = new Playmaker("Dele Alli");
	static Goalkeeper spurGoalkeeper1 = new Goalkeeper("Hugo Lloris");
	static Goalkeeper spurGoalkeeper2 = new Goalkeeper("Paulo Gazzaniga");
	static God spurGod = new God("Moussa Sissoko");
	
	@SuppressWarnings("serial")
	static ArrayList<Unit> liverpool = new ArrayList<Unit>(){{
		add(liverpoolAttacker1);
		add(liverpoolAttacker2);
		add(liverpoolAttacker3);
		add(liverpoolBoxToBox1);
		add(liverpoolBoxToBox2);
		add(liverpoolBoxToBox3);
		add(liverpoolDefender1);
		add(liverpoolDefender2);
		add(liverpoolGoalkeeper1);
		add(liverpoolGoalkeeper2);
		add(liverpoolGod);
		add(liverpoolPlaymaker);
		add(liverpoolCaptain);
	}};
	
	@SuppressWarnings("serial")
	static ArrayList<Unit> manCity = new ArrayList<Unit>(){{
		add(manCityAttacker1);
		add(manCityAttacker2);
		add(manCityAttacker3);
		add(manCityBoxToBox1);
		add(manCityBoxToBox2);
		add(manCityBoxToBox3);
		add(manCityDefender1);
		add(manCityDefender2);
		add(manCityGoalkeeper1);
		add(manCityGoalkeeper2);
		add(manCityGod);
		add(manCityPlaymaker);
		add(manCityCaptain);
	}};
	
	@SuppressWarnings("serial")
	static ArrayList<Unit> manUnited = new ArrayList<Unit>() {{
		add(manUnitedAttacker1);
		add(manUnitedAttacker2);
		add(manUnitedAttacker3);
		add(manUnitedBoxToBox1);
		add(manUnitedBoxToBox2);
		add(manUnitedBoxToBox3);
		add(manUnitedDefender1);
		add(manUnitedDefender2);
		add(manUnitedGoalkeeper1);
		add(manUnitedGoalkeeper2);
		add(manUnitedGod);
		add(manUnitedPlaymaker);
		add(manUnitedCaptain);
	}};
	
	@SuppressWarnings("serial")
	static ArrayList<Unit> spur = new ArrayList<Unit>() {{
		add(spurAttacker1);
		add(spurAttacker2);
		add(spurAttacker3);
		add(spurBoxToBox1);
		add(spurBoxToBox2);
		add(spurBoxToBox3);
		add(spurDefender1);
		add(spurDefender2);
		add(spurGoalkeeper1);
		add(spurGoalkeeper2);
		add(spurGod);
		add(spurPlaymaker);
		add(spurCaptain);
	}};
}
