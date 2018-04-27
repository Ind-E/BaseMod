package basemod.patches.com.megacrit.cardcrawl.helpers.RelicLibrary;

import java.util.ArrayList;
import java.util.Map;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import basemod.BaseMod;

@SpirePatch(cls = "com.megacrit.cardcrawl.helpers.RelicLibrary", method = "addClassSpecificRelics")
public class PopulateLists {

	public static void Postfix(ArrayList<AbstractRelic> relicPool) {
		AbstractPlayer.PlayerClass selection = AbstractDungeon.player.chosenClass;
		if (selection != AbstractPlayer.PlayerClass.IRONCLAD && selection != AbstractPlayer.PlayerClass.THE_SILENT &&
				selection != AbstractPlayer.PlayerClass.DEFECT) {
			for (Map.Entry<String, AbstractRelic> r : BaseMod.getRelicsInCustomPool(
					BaseMod.getColor(selection.toString())).entrySet()) {
				relicPool.add(r.getValue());
			}
		}
	}

}
