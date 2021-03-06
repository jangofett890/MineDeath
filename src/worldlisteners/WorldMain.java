package worldlisteners;

import java.util.ArrayList;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import lang.Lang;
import lang.Lang.Status;
@SuppressWarnings("unused")
public class WorldMain implements Listener{
	Block block;
	Sign sign;
	Player player;
	ArrayList<String> signText;
	protected static void print(String text, Status stat){
		Lang.print(text, stat);
	}
	public ArrayList<String> readSign(Sign sign){
		signText = new ArrayList<String>();
		for (String text : sign.getLines()){
			if(!text.matches("")){signText.add(text);}
		}
		return signText;
	}
	private String parseSign(ArrayList<String> list){
		return list.toString();
	}
	public void setLine(Sign sign, int line, String text){
		sign.setLine(line, text);
	}
	public void update(Sign sign){
		sign.update(true);
	}
}
