package slots;

import desktop_resources.GUI;
import game.Player;
import game.Translator;

public class Tax extends Field{

	private int taxAmount;
	private int taxRate = -1;
	
	public Tax(int i, Types type, int price) {
		super(i, type);
		this.taxAmount = taxAmount;
	}

	@Override
	public void landOnField(Player player) {
		if (GUI.getUserLeftButtonPressed(Translator.getString(getDescription()), Translator.getString("YES"), Translator.getString("NO"))) {
			player.getAccount().withdraw((player.getAccount().getGold()/10));
		}
		else {
			player.getAccount().withdraw(taxAmount);
		}
	}

	@Override
	public desktop_fields.Field pushToGUI(int position) {
		this.position = position;
		desktop_fields.Tax tax = new desktop_fields.Tax.Builder().build();
		tax.setDescription(this.getDescription());
		tax.setTitle(this.getName());
		tax.setSubText(taxAmount + "");
		return tax;
	}
	
}
