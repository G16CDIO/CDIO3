package slots;

import java.awt.Color;

import javax.management.DescriptorKey;

import desktop_resources.GUI;
import slots.Ownable;
import game.DiceResult;
import game.Player;
import game.Translator;
import slots.Field.Types;

public class LaborCamp extends Ownable{

	private int baseRent;
	desktop_fields.Street LaborCamp;
	
	public LaborCamp(int i, Types type, int price, int baseRent) {
		super(i, type, price);
		this.baseRent = baseRent;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRent() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override 
	public void landOnField(Player player) {
		LaborCamp.displayOnCenter();
		if(hasOwner()){
			if(getOwner()!=player)
			{
//				baseRent = player.getDice().rollDice().getSum() * 100 * player.getProperty().getLaborCampOwned();
				GUI.getUserButtonPressed(Translator.getString("LABORCAMP", baseRent), Translator.getString("ROLL"));
				DiceResult res = player.getDice().rollDice();
				int price = res.getSum() * 100 * getOwner().getProperty().getLaborCampOwned();
				GUI.setDice(res.getDice(0), 3, 7, res.getDice(1), 4,8);
				GUI.showMessage(Translator.getString("LABORCAMPCONCLUSION", res.getSum(), price));
				player.getAccount().transferTo(getOwner().getAccount(), price);
			}else{
				GUI.showMessage(Translator.getString("YOURFIELD"));
			}
		}else{
			if(BuyField(player)){
				player.getProperty().expandLaborCamp();
				GUI.showMessage(Translator.getString("BOUGHTFIELD", getName(), price));
			}	
		}
	}
	public desktop_fields.Field pushToGUI(int position){

		this.position = position;
		LaborCamp = new desktop_fields.Street.Builder().setRent(Translator.getString("LABORCAMPRENT", baseRent)).setBgColor(new Color(255f/255, 165f/255, 48f/255)).build();
		LaborCamp.setDescription(this.getDescription());
		LaborCamp.setTitle(this.getName());
		
		LaborCamp.setSubText(price+"");
		
		//LaborCamp.setSubText(baseRent+"");
		return LaborCamp;
	}
	
	@Override
	public String toString() {
		return "LaborCamp [LaborCamp=" + LaborCamp + ", price=" + price + ", position=" + position
				+ ", getRent()=" + getRent() + ", getOwner()=" + getOwner() + ", hasOwner()=" + hasOwner()
				+ ", getName()=" + getName() + ", getPosition()=" + getPosition() + "]";
	}
}
