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

	static Captain liverpoolCaptain = new Henderson(TeamImageUrl.liverpoolInactiveCaptain,
			TeamImageUrl.liverpoolActiveCaptain);
	static Attacker liverpoolAttacker1 = new Attacker("Sadio Mane", TeamImageUrl.liverpoolInactiveAttacker1,
			TeamImageUrl.liverpoolActiveAttacker1);
	static Attacker liverpoolAttacker2 = new Attacker("Alex Oxlade-Chamberlane",
			TeamImageUrl.liverpoolInactiveAttacker2, TeamImageUrl.liverpoolActiveAttacker2);
	static Attacker liverpoolAttacker3 = new Attacker("Mohammed Salah", TeamImageUrl.liverpoolInactiveAttacker3,
			TeamImageUrl.liverpoolActiveAttacker3);
	static BoxToBox liverpoolBoxToBox1 = new BoxToBox("Georginio Wijnaldum", TeamImageUrl.liverpoolInactiveBoxToBox1,
			TeamImageUrl.liverpoolActiveBoxToBox1);
	static BoxToBox liverpoolBoxToBox2 = new BoxToBox("Adam Lallana", TeamImageUrl.liverpoolInactiveBoxToBox2,
			TeamImageUrl.liverpoolActiveBoxToBox2);
	static BoxToBox liverpoolBoxToBox3 = new BoxToBox("Fabinho", TeamImageUrl.liverpoolInactiveBoxToBox3,
			TeamImageUrl.liverpoolActiveBoxToBox3);
	static Defender liverpoolDefender1 = new Defender("Dejan Lovren", TeamImageUrl.liverpoolInactiveDefender1,
			TeamImageUrl.liverpoolActiveDefender2);
	static Defender liverpoolDefender2 = new Defender("Virgil Van Dijk", TeamImageUrl.liverpoolInactiveDefender2,
			TeamImageUrl.liverpoolActiveDefender2);
	static Playmaker liverpoolPlaymaker = new Playmaker("Roberto Firmino", TeamImageUrl.liverpoolInactivePlaymaker,
			TeamImageUrl.liverpoolActivePlaymaker);
	static Goalkeeper liverpoolGoalkeeper1 = new Goalkeeper("Alisson Becker", TeamImageUrl.liverpoolInactiveGoalkeeper1,
			TeamImageUrl.liverpoolActiveGoalkeeper1);
	static Goalkeeper liverpoolGoalkeeper2 = new Goalkeeper("Adrian", TeamImageUrl.liverpoolInactiveGoalkeeper2,
			TeamImageUrl.liverpoolActiveGoalkeeper2);
	static God liverpoolGod = new God("Divock Origi", TeamImageUrl.liverpoolInactiveGod,
			TeamImageUrl.liverpoolActiveGod);

	static Captain manUnitedCaptain = new Mcguire(TeamImageUrl.manUnitedInactiveCaptain,
			TeamImageUrl.manUnitedActiveCaptain);
	static Attacker manUnitedAttacker1 = new Attacker("Daniel James", TeamImageUrl.manUnitedInactiveAttacker1,
			TeamImageUrl.manUnitedActiveAttacker1);
	static Attacker manUnitedAttacker2 = new Attacker("Anthony Martial", TeamImageUrl.manUnitedInactiveAttacker2,
			TeamImageUrl.manUnitedActiveAttacker2);
	static Attacker manUnitedAttacker3 = new Attacker("Marcus Rashford", TeamImageUrl.manUnitedInactiveAttacker3,
			TeamImageUrl.manUnitedActiveAttacker3);
	static BoxToBox manUnitedBoxToBox1 = new BoxToBox("Frederico Rodrigues", TeamImageUrl.manUnitedInactiveBoxToBox1,
			TeamImageUrl.manUnitedActiveBoxToBox1);
	static BoxToBox manUnitedBoxToBox2 = new BoxToBox("Paul Pogba", TeamImageUrl.manUnitedInactiveBoxToBox2,
			TeamImageUrl.manUnitedActiveBoxToBox2);
	static BoxToBox manUnitedBoxToBox3 = new BoxToBox("Scott Mctominay", TeamImageUrl.manUnitedInactiveBoxToBox3,
			TeamImageUrl.manUnitedActiveBoxToBox3);
	static Defender manUnitedDefender1 = new Defender("Victor Lindelof", TeamImageUrl.manUnitedInactiveDefender1,
			TeamImageUrl.manUnitedActiveDefender1);
	static Defender manUnitedDefender2 = new Defender("Phil Jones", TeamImageUrl.manUnitedInactiveDefender2,
			TeamImageUrl.manUnitedActiveDefender2);
	static Playmaker manUnitedPlaymaker = new Playmaker("Bruno Fernandes", TeamImageUrl.manUnitedInactivePlaymaker,
			TeamImageUrl.manUnitedActivePlaymaker);
	static Goalkeeper manUnitedGoalkeeper1 = new Goalkeeper("Sergio Romero", TeamImageUrl.manUnitedInactiveGoalkeeper1,
			TeamImageUrl.manUnitedActiveGoalkeeper1);
	static Goalkeeper manUnitedGoalkeeper2 = new Goalkeeper("David De Gea", TeamImageUrl.manUnitedInactiveGoalkeeper2,
			TeamImageUrl.manUnitedActiveGoalkeeper2);
	static God manUnitedGod = new God("Jesse Lingard", TeamImageUrl.manUnitedInactiveGod,
			TeamImageUrl.manUnitedActiveGod);

	static Captain manCityCaptain = new Silva(TeamImageUrl.manCityInactiveCaptain,
			TeamImageUrl.manCityActiveCaptain);
	static Attacker manCityAttacker1 = new Attacker("Sergio Aguero", TeamImageUrl.manCityInactiveAttacker1,
			TeamImageUrl.manCityActiveAttacker1);
	static Attacker manCityAttacker2 = new Attacker("Riyad Mahrez", TeamImageUrl.manCityInactiveAttacker2,
			TeamImageUrl.manCityActiveAttacker2);
	static Attacker manCityAttacker3 = new Attacker("Leroy Sane", TeamImageUrl.manCityInactiveAttacker3,
			TeamImageUrl.manCityActiveAttacker3);
	static BoxToBox manCityBoxToBox1 = new BoxToBox("Fernandinho", TeamImageUrl.manCityInactiveBoxToBox1,
			TeamImageUrl.manCityActiveBoxToBox1);
	static BoxToBox manCityBoxToBox2 = new BoxToBox("Ilkay Gundogan", TeamImageUrl.manCityInactiveBoxToBox2,
			TeamImageUrl.manCityActiveBoxToBox2);
	static BoxToBox manCityBoxToBox3 = new BoxToBox("Bernado Silva", TeamImageUrl.manCityInactiveBoxToBox3,
			TeamImageUrl.manCityActiveBoxToBox3);
	static Defender manCityDefender1 = new Defender("Nicolas Otamendi", TeamImageUrl.manCityInactiveDefender1,
			TeamImageUrl.manCityActiveDefender1);
	static Defender manCityDefender2 = new Defender("Aymeric Laporte", TeamImageUrl.manCityInactiveDefender2,
			TeamImageUrl.manCityActiveDefender2);
	static Playmaker manCityPlaymaker = new Playmaker("Kevin De Bruyne", TeamImageUrl.manCityInactivePlaymaker,
			TeamImageUrl.manCityActivePlaymaker);
	static Goalkeeper manCityGoalkeeper1 = new Goalkeeper("Ederson", TeamImageUrl.manCityInactiveGoalkeeper1,
			TeamImageUrl.manCityActiveGoalkeeper1);
	static Goalkeeper manCityGoalkeeper2 = new Goalkeeper("Claudio Bravo", TeamImageUrl.manCityInactiveGoalkeeper2,
			TeamImageUrl.manCityActiveGoalkeeper2);
	static God manCityGod = new God("Raheam Sterling", TeamImageUrl.manCityInactiveGod, TeamImageUrl.manCityActiveGod);

	static Captain spurCaptain = new Kane(TeamImageUrl.spurInactiveCaptain,
			TeamImageUrl.spurActiveCaptain);
	static Attacker spurAttacker1 = new Attacker("Lucas Moura", TeamImageUrl.spurInactiveAttacker1,
			TeamImageUrl.spurActiveAttacker1);
	static Attacker spurAttacker2 = new Attacker("Steven Bergwijn", TeamImageUrl.spurInactiveAttacker2,
			TeamImageUrl.spurActiveAttacker2);
	static Attacker spurAttacker3 = new Attacker("Son Heung Min", TeamImageUrl.spurInactiveAttacker3,
			TeamImageUrl.spurActiveAttacker3);
	static BoxToBox spurBoxToBox1 = new BoxToBox("Erik Lamela", TeamImageUrl.spurInactiveBoxToBox1,
			TeamImageUrl.spurActiveBoxToBox1);
	static BoxToBox spurBoxToBox2 = new BoxToBox("Eric Dier", TeamImageUrl.spurInactiveBoxToBox2,
			TeamImageUrl.spurActiveBoxToBox2);
	static BoxToBox spurBoxToBox3 = new BoxToBox("Victor Wanyama", TeamImageUrl.spurInactiveBoxToBox3,
			TeamImageUrl.spurActiveBoxToBox3);
	static Defender spurDefender1 = new Defender("Jan Vertonghen", TeamImageUrl.spurInactiveDefender1,
			TeamImageUrl.spurActiveDefender1);
	static Defender spurDefender2 = new Defender("Toby Alderweireld", TeamImageUrl.spurInactiveDefender2,
			TeamImageUrl.spurActiveDefender2);
	static Playmaker spurPlaymaker = new Playmaker("Dele Alli", TeamImageUrl.spurInactivePlaymaker,
			TeamImageUrl.spurActivePlaymaker);
	static Goalkeeper spurGoalkeeper1 = new Goalkeeper("Hugo Lloris", TeamImageUrl.spurInactiveGoalkeeper1,
			TeamImageUrl.spurActiveGoalkeeper1);
	static Goalkeeper spurGoalkeeper2 = new Goalkeeper("Paulo Gazzaniga", TeamImageUrl.spurInactiveGoalkeeper2,
			TeamImageUrl.spurActiveGoalkeeper2);
	static God spurGod = new God("Moussa Sissoko", TeamImageUrl.spurInactiveGod, TeamImageUrl.spurActiveGod);

	@SuppressWarnings("serial")
	static ArrayList<Unit> liverpool = new ArrayList<Unit>() {
		{
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
		}
	};

	@SuppressWarnings("serial")
	static ArrayList<Unit> manCity = new ArrayList<Unit>() {
		{
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
		}
	};

	@SuppressWarnings("serial")
	static ArrayList<Unit> manUnited = new ArrayList<Unit>() {
		{
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
		}
	};

	@SuppressWarnings("serial")
	static ArrayList<Unit> spur = new ArrayList<Unit>() {
		{
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
		}
	};
}
